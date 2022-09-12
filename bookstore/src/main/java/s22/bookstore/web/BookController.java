package s22.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.bookstore.domain.Book;
import s22.bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/", "/booklist"}) 
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist"; //booklist.html
		}
	
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook"; 
    }     
    
    @PostMapping(value = "/save") 
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    }
	
    @RequestMapping(value = "/edit/{id}")
    public String addBook(@PathVariable("id") Long bookId, Model model){
       model.addAttribute("book", repository.findById(bookId));
       return "editbook";
    }
}
