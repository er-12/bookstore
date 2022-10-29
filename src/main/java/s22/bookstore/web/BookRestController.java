package s22.bookstore.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;

@RestController
public class BookRestController {
	
	@Autowired
	BookRepository bookRepository;
	
	//returns list of books
	@GetMapping("/books")
	public Iterable<Book> getBooks() {
		return bookRepository.findAll();
	}
	
	//add new book
	@PostMapping("/books")
	Book addNewBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	//edit book info
	@PutMapping("/books/{id}")
	Book editBook(@RequestBody Book editedBook, @PathVariable Long id) {
		editedBook.setId(id);
		return bookRepository.save(editedBook);
	}
	
	//delete book
	@DeleteMapping("/books/{id}") 
	public Iterable<Book> deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
		return bookRepository.findAll();
	}
	
	//find specific book by id and return it
	@GetMapping("/books/{id}")
	Optional<Book> getBook(@PathVariable Long id) {
		return bookRepository.findById(id);
	}
}
