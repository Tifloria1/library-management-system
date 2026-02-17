package vente.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import vente.backend.dto.BookRequestDTO;
import vente.backend.dto.BookResponseDTO;
import vente.backend.services.BookService;


@RequestMapping("/api/books")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")


public class BookController {
	private final BookService bookService;

	
	
	@GetMapping
	public List<BookResponseDTO> getAllBooks(){
		return bookService.getAllBooks();
	}

	
	
	@GetMapping("/{id:\\d+}")
	
	public BookResponseDTO getBookById(@PathVariable Long id){
		return bookService.getBookById(id);
		
	}
	
	@GetMapping("/available")
	public List<BookResponseDTO> getAvailableBooks(){
		return bookService.getAvailableBooks();
	}
	
	@GetMapping("/search")
	public List<BookResponseDTO> search(@RequestParam String keyword){
		return bookService.search(keyword);
	}
	
	
	@PostMapping
	public BookResponseDTO createBook (@Valid @RequestBody BookRequestDTO dto) {
		return bookService.createBook(dto);
	}
	
	
	@PutMapping("/{id}")
	public BookResponseDTO updateBook(@Valid @PathVariable Long id,
			@RequestBody BookRequestDTO dto) {
		return bookService.updateBook(id, dto);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
	}

}
