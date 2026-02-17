package vente.backend.services;

import java.util.List;

import vente.backend.dto.BookRequestDTO;
import vente.backend.dto.BookResponseDTO;


public interface BookService {
	
	List<BookResponseDTO> getAllBooks();
	
	List<BookResponseDTO> getAvailableBooks();
	
	void deleteBook (Long id);
	
	List<BookResponseDTO> search(String keyword);
	

	BookResponseDTO getBookById(Long id);
	
	BookResponseDTO createBook(BookRequestDTO dto);
	BookResponseDTO updateBook(Long id, BookRequestDTO dto);
	
	
	
	}

	

