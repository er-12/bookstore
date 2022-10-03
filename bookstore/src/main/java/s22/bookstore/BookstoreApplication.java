package s22.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;
import s22.bookstore.domain.Category;
import s22.bookstore.domain.CategoryRepository;
import s22.bookstore.domain.AppUser;
import s22.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean 
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository catrepo, UserRepository urepository) {
		return (args) -> {
			log.info("save some books");
			
			catrepo.save(new Category("Fiction"));
			catrepo.save(new Category("Non-Fiction"));
			catrepo.save(new Category("Thriller"));
			
			repository.save(new Book("On Chesil Beach", "Ian McEwan", 2007, "9780099520825", 12.90, catrepo.findByName("Fiction").get(0)));
			repository.save(new Book("Atonement", "Ian McEwan", 2001, "9780099429791", 14.90, catrepo.findByName("Fiction").get(0)));	
			
			// Create users: admin/admin user/user 
			AppUser user1 = new AppUser("Elli", "Ensimmäinen", "USER", "user", "$2a$10$tbOfiTyM0QivddDdua60mehTjsDmbRofYL0sgvc9DRpragQ9KxdHq");
			AppUser user2 = new AppUser("Tommi", "Toinen", "ADMIN", "admin", "$2a$10$AqSNP/tz8atz2BGcLgQQkuqHWImakP5u6MhWzqWjhAd6Dn6lrItOO");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
