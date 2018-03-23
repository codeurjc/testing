package es.codeurjc.rest.books;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

@RunWith(SpringRunner.class)
@RestClientTest(BooksService.class)
public class BooksServiceTest {

	@Autowired
	private BooksService service;

	@Autowired
	private MockRestServiceServer booksServer;

	private String jsonResponse = "{\n" + 
			" \"kind\": \"books#volumes\",\n" + 
			" \"totalItems\": 502,\n" + 
			" \"items\": [\n" + 
			"  {\n" + 
			"   \"kind\": \"books#volume\",\n" + 
			"   \"id\": \"USaAQ0hHQWIC\",\n" + 
			"   \"etag\": \"bPrwJYXD7aM\",\n" + 
			"   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/USaAQ0hHQWIC\",\n" + 
			"   \"volumeInfo\": {\n" + 
			"    \"title\": \"Java a Tope: J2me (java 2 Micro Edition).\",\n" + 
			"    \"publisher\": \"Sergio Gálvez Rojas\",\n" + 
			"    \"publishedDate\": \"2003\",\n" + 
			"    \"industryIdentifiers\": [\n" + 
			"     {\n" + 
			"      \"type\": \"ISBN_13\",\n" + 
			"      \"identifier\": \"9788468847047\"\n" + 
			"     },\n" + 
			"     {\n" + 
			"      \"type\": \"ISBN_10\",\n" + 
			"      \"identifier\": \"8468847046\"\n" + 
			"     }\n" + 
			"    ],\n" + 
			"    \"readingModes\": {\n" + 
			"     \"text\": false,\n" + 
			"     \"image\": true\n" + 
			"    },\n" + 
			"    \"pageCount\": 188,\n" + 
			"    \"printType\": \"BOOK\",\n" + 
			"    \"averageRating\": 4.0,\n" + 
			"    \"ratingsCount\": 9,\n" + 
			"    \"maturityRating\": \"NOT_MATURE\",\n" + 
			"    \"allowAnonLogging\": false,\n" + 
			"    \"contentVersion\": \"1.1.0.0.preview.1\",\n" + 
			"    \"imageLinks\": {\n" + 
			"     \"smallThumbnail\": \"http://books.google.com/books/content?id=USaAQ0hHQWIC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" + 
			"     \"thumbnail\": \"http://books.google.com/books/content?id=USaAQ0hHQWIC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" + 
			"    },\n" + 
			"    \"language\": \"es\",\n" + 
			"    \"previewLink\": \"http://books.google.es/books?id=USaAQ0hHQWIC&printsec=frontcover&dq=intitle:Java&hl=&cd=1&source=gbs_api\",\n" + 
			"    \"infoLink\": \"http://books.google.es/books?id=USaAQ0hHQWIC&dq=intitle:Java&hl=&source=gbs_api\",\n" + 
			"    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Java_a_Tope_J2me_java_2_Micro_Edition.html?hl=&id=USaAQ0hHQWIC\"\n" + 
			"   },\n" + 
			"   \"saleInfo\": {\n" + 
			"    \"country\": \"ES\",\n" + 
			"    \"saleability\": \"NOT_FOR_SALE\",\n" + 
			"    \"isEbook\": false\n" + 
			"   },\n" + 
			"   \"accessInfo\": {\n" + 
			"    \"country\": \"ES\",\n" + 
			"    \"viewability\": \"ALL_PAGES\",\n" + 
			"    \"embeddable\": true,\n" + 
			"    \"publicDomain\": false,\n" + 
			"    \"textToSpeechPermission\": \"ALLOWED\",\n" + 
			"    \"epub\": {\n" + 
			"     \"isAvailable\": false\n" + 
			"    },\n" + 
			"    \"pdf\": {\n" + 
			"     \"isAvailable\": false\n" + 
			"    },\n" + 
			"    \"webReaderLink\": \"http://play.google.com/books/reader?id=USaAQ0hHQWIC&hl=&printsec=frontcover&source=gbs_api\",\n" + 
			"    \"accessViewStatus\": \"SAMPLE\",\n" + 
			"    \"quoteSharingAllowed\": false\n" + 
			"   }\n" + 
			"  },\n" + 
			"  {\n" + 
			"   \"kind\": \"books#volume\",\n" + 
			"   \"id\": \"29zE8HTdJ1QC\",\n" + 
			"   \"etag\": \"swhA3SUn5CY\",\n" + 
			"   \"selfLink\": \"https://www.googleapis.com/books/v1/volumes/29zE8HTdJ1QC\",\n" + 
			"   \"volumeInfo\": {\n" + 
			"    \"title\": \"Introduccion Al Desarrollo de Programas Con Java\",\n" + 
			"    \"publisher\": \"UNAM\",\n" + 
			"    \"publishedDate\": \"2007\",\n" + 
			"    \"industryIdentifiers\": [\n" + 
			"     {\n" + 
			"      \"type\": \"ISBN_10\",\n" + 
			"      \"identifier\": \"9703243177\"\n" + 
			"     },\n" + 
			"     {\n" + 
			"      \"type\": \"ISBN_13\",\n" + 
			"      \"identifier\": \"9789703243174\"\n" + 
			"     }\n" + 
			"    ],\n" + 
			"    \"readingModes\": {\n" + 
			"     \"text\": false,\n" + 
			"     \"image\": true\n" + 
			"    },\n" + 
			"    \"pageCount\": 253,\n" + 
			"    \"printType\": \"BOOK\",\n" + 
			"    \"averageRating\": 4.5,\n" + 
			"    \"ratingsCount\": 2,\n" + 
			"    \"maturityRating\": \"NOT_MATURE\",\n" + 
			"    \"allowAnonLogging\": false,\n" + 
			"    \"contentVersion\": \"0.0.1.0.preview.1\",\n" + 
			"    \"imageLinks\": {\n" + 
			"     \"smallThumbnail\": \"http://books.google.com/books/content?id=29zE8HTdJ1QC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api\",\n" + 
			"     \"thumbnail\": \"http://books.google.com/books/content?id=29zE8HTdJ1QC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api\"\n" + 
			"    },\n" + 
			"    \"language\": \"es\",\n" + 
			"    \"previewLink\": \"http://books.google.es/books?id=29zE8HTdJ1QC&printsec=frontcover&dq=intitle:Java&hl=&cd=2&source=gbs_api\",\n" + 
			"    \"infoLink\": \"http://books.google.es/books?id=29zE8HTdJ1QC&dq=intitle:Java&hl=&source=gbs_api\",\n" + 
			"    \"canonicalVolumeLink\": \"https://books.google.com/books/about/Introduccion_Al_Desarrollo_de_Programas.html?hl=&id=29zE8HTdJ1QC\"\n" + 
			"   },\n" + 
			"   \"saleInfo\": {\n" + 
			"    \"country\": \"ES\",\n" + 
			"    \"saleability\": \"NOT_FOR_SALE\",\n" + 
			"    \"isEbook\": false\n" + 
			"   },\n" + 
			"   \"accessInfo\": {\n" + 
			"    \"country\": \"ES\",\n" + 
			"    \"viewability\": \"PARTIAL\",\n" + 
			"    \"embeddable\": true,\n" + 
			"    \"publicDomain\": false,\n" + 
			"    \"textToSpeechPermission\": \"ALLOWED\",\n" + 
			"    \"epub\": {\n" + 
			"     \"isAvailable\": false\n" + 
			"    },\n" + 
			"    \"pdf\": {\n" + 
			"     \"isAvailable\": false\n" + 
			"    },\n" + 
			"    \"webReaderLink\": \"http://play.google.com/books/reader?id=29zE8HTdJ1QC&hl=&printsec=frontcover&source=gbs_api\",\n" + 
			"    \"accessViewStatus\": \"SAMPLE\",\n" + 
			"    \"quoteSharingAllowed\": false\n" + 
			"   }\n" + 
			"  }]}";

	@Test
	public void bookServiceTest() throws Exception {

		this.booksServer.expect(requestTo("https://www.googleapis.com/books/v1/volumes?q=intitle:Java"))
				.andRespond(withSuccess(jsonResponse, MediaType.APPLICATION_JSON));

		List<String> books = this.service.getBookTitles("Java");

		System.out.println(books);

		assertThat(books).hasSize(2);
		assertThat(books).containsExactly("Java a Tope: J2me (java 2 Micro Edition).",
				"Introduccion Al Desarrollo de Programas Con Java");
	}
}