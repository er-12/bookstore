package s22.bookstore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;

@DataJpaTest
class BookRepoTest {
	
	@Autowired
	BookRepository bookRepo;

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void findByTitleShouldReturnBooks() {
		List<Book> books = bookRepo.findByTitle("Atonement");
		assertThat(books.get(0).getTitle()).isEqualTo("Atonement");
	}
	
	@Test
	public void findByAuthorShouldReturnSize() {
		List<Book> books = bookRepo.findByAuthor("Ian McEwan");
		assertThat(books).hasSize(2);
	}

	@Test
	public void insertNewBook() {
		Book book = new Book("1984", "George Orwell", 1950, "12345", 12.5, new Category("Dystopian Fiction"));
		bookRepo.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteNewBook() {
		List<Book> books = bookRepo.findByTitle("Atonement");
		Book book = books.get(0);
		bookRepo.delete(book);
		List<Book> newBooks = bookRepo.findByTitle("Atonement");
		assertThat(newBooks).hasSize(0);
	}

}
