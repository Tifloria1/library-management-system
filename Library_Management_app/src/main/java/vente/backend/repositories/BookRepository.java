package vente.backend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vente.backend.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	
List<Book> findByAvailable(boolean available);

List<Book> findByAuthorContainingIgnoreCaseOrTitleContainingIgnoreCase(String author, String title);
}
