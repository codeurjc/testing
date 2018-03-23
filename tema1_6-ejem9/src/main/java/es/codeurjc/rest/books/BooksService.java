package es.codeurjc.rest.books;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

class BooksResponse {
	public List<Book> items;
}

class Book {
	public VolumeInfo volumeInfo;
}

class VolumeInfo {
	public String title;
}

@Service
public class BooksService {

	private RestTemplate restTemplate;
	
	public BooksService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public List<String> getBookTitles(String title) {
		
		String url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;

		BooksResponse data = restTemplate.getForObject(url, BooksResponse.class);

		List<String> bookTitles = new ArrayList<String>();

		for (Book book : data.items) {
			bookTitles.add(book.volumeInfo.title);
		}

		return bookTitles;
	}
}
