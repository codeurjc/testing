package es.codeurjc.test.tablonanuncios;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TablonController {

	@Autowired
	private Usuario usuario;

	private ConcurrentMap<Long, Anuncio> anuncios = new ConcurrentHashMap<>();
	private AtomicLong nextId = new AtomicLong();

	public TablonController() {
		addAnuncio(new Anuncio("Pepe", "Hola caracola", "XXXX"));
		addAnuncio(new Anuncio("Juan", "Hola caracola", "XXXX"));
	}

	private void addAnuncio(Anuncio anuncio) {
		Long id = nextId.getAndIncrement();
		anuncio.setId(id);
		anuncios.put(id, anuncio);
	}

	@RequestMapping("/")
	public String tablon(Model model, HttpSession session) {

		model.addAttribute("anuncios", anuncios.values());
		model.addAttribute("bienvenida", session.isNew());

		return "tablon";
	}

	@RequestMapping("/anuncio/nuevo")
	public String nuevoAnuncio(Model model, Anuncio anuncio) {

		addAnuncio(anuncio);

		usuario.setNombre(anuncio.getNombre());
		usuario.incAnuncios();

		return "anuncio_guardado";

	}

	@RequestMapping("/anuncio/nuevo_form")
	public String nuevoAnuncioForm(Model model) {

		model.addAttribute("nombre", usuario.getNombre());
		model.addAttribute("num_anuncios", usuario.getNumAnuncios());

		return "nuevo_anuncio";
	}

	@RequestMapping("/anuncio/{id}")
	public String nuevoAnuncio(Model model, @PathVariable Long id) {

		Anuncio anuncio = anuncios.get(id);

		model.addAttribute("anuncio", anuncio);

		return "ver_anuncio";
	}
	
	@RequestMapping("/anuncio/{id}/borrar")
	public String borrarAnuncio(Model model, @PathVariable Long id) {

		Anuncio anuncio = anuncios.remove(id);

		model.addAttribute("anuncio", anuncio);

		return "anuncio_borrado";
	}
}