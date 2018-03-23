package es.codeurjc.rest.anuncios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnuncioController {

	@GetMapping("/anuncio")	
	public Anuncio getAnuncio() {

		return new Anuncio("Pepe","Vendo moto","...");
	}
}