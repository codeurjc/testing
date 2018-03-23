package es.codeurjc.rest.books;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {

	private BooksService booksService;
	
	public BooksController(BooksService service) {
		this.booksService = service;
	}
	
	@GetMapping("/booktitles")
	public List<String> getBookTitles(@RequestParam String title) {

		return booksService.getBookTitles(title);
	}
}
