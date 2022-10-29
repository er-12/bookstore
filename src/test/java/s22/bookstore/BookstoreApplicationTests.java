package s22.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import s22.bookstore.web.BookController;

@SpringBootTest
class BookstoreApplicationTests {
	
	@Autowired
	BookController bookController;
	
	@Test
	void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

}
