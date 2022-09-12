package s22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean 
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("save some books");
			repository.save(new Book("On Chesil Beach", "Ian McEwan", 2007, "9780099520825", 12.90));
			repository.save(new Book("Atonement", "Ian McEwan", 2001, "9780099429791", 14.90));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
