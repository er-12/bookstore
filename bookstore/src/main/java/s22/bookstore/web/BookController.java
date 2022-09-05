package s22.bookstore.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import s22.bookstore.domain.Book;


@Controller
public class BookController {
	
	@GetMapping("index")
	public String listBooks(Model model) {
		
		ArrayList<Book> books = new ArrayList<>();
		
		books.add(new Book("On Chesil Beach", "Ian McEwan", 2007, "9780099520825", 12.90));
		books.add(new Book("Atonement", "Ian McEwan", 2003, "9787245520855", 14.90));
		
		model.addAttribute("bookList", books);
		 
		return "books"; //books.html
	}

}
