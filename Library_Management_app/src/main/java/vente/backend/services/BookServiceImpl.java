package vente.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import vente.backend.dto.BookRequestDTO;
import vente.backend.dto.BookResponseDTO;
import vente.backend.entities.Book;
import vente.backend.exceptions.ResourceNotFoundException;
import vente.backend.repositories.BookRepository;


@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService{
	
	private final BookRepository bookRepository;
	
	private BookResponseDTO toResponseDTO(Book book) {
		return new BookResponseDTO(
				book.getId(),
				book.getTitle(),
				book.getAuthor(),
				book.getIsbn(),
				book.getPublicationYear(),
				book.isAvailable()
				);
	}
	
	public List<BookResponseDTO>getAllBooks(){
		return bookRepository.findAll()
				.stream()
	            .map(this::toResponseDTO)
	            .toList();
	}
	
	
	public BookResponseDTO getBookById(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("The book notfound with id =" + id)
						);
				return toResponseDTO(book);
				
	}
	
	public List<BookResponseDTO> getAvailableBooks() {
		return bookRepository.findByAvailable(true)
				.stream()
				.map(this::toResponseDTO)
				.toList();
	}
	
	
	public List<BookResponseDTO> search(String keyword){
		return bookRepository.findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(keyword, keyword)
				.stream()
				.map(this::toResponseDTO)
				.toList();
	}
	
	
	public BookResponseDTO createBook(BookRequestDTO dto) {
		 
		Book book = new Book();
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setIsbn(dto.getIsbn());
		book.setPublicationYear(dto.getPublicationYear());
		
		if(dto.getAvailable()!=null) {
			book.setAvailable(dto.getAvailable());
		}else {
			book.setAvailable(true);
		}
		
		Book savedBook = bookRepository.save(book);
		
		return toResponseDTO(savedBook);
		
		
	}
	
	
	public BookResponseDTO updateBook(Long id, BookRequestDTO dto){
		Book book = bookRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("this book not found with the id =" +id));
		book.setTitle(dto.getTitle());
		book.setAuthor(dto.getAuthor());
		book.setIsbn(dto.getIsbn());
		book.setPublicationYear(dto.getPublicationYear());
		
		
		//wedont forceavailable in update notlike in create weforce it
		if(dto.getAvailable() !=null) {
			book.setAvailable(dto.getAvailable());
		}
		
		Book updatedBook = bookRepository.save(book);
		
		
		return toResponseDTO(updatedBook);
		
	}
		
		public void deleteBook(Long id) {
			if(!bookRepository.existsById(id)) {
				throw new ResourceNotFoundException("Book not found with the id = " + id);
				
			} 
				bookRepository.deleteById(id);
			}
	
		

		
		
				
		
		
	}
	
	
	
	
	
	


