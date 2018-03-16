package es.codeurjc.rest.anuncios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnuncioController {

	@GetMapping(value="/anuncio", produces = "application/json")	
	public String getAnuncio() {

		return "{ \"nombre\":\"Pepe\", "+
				"\"asunto\":\"Vendo moto\","+
				"\"comentario\":\"...\"}";
	}
}