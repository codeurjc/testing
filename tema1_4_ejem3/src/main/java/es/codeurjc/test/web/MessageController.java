package es.codeurjc.test.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {

	private List<Message> messages = Collections.synchronizedList(new ArrayList<>());

	@GetMapping("/")
	public String showMessages(Model model) {

		model.addAttribute("messages", this.messages);

		return "index";
	}

	@PostMapping("/")
	public String newMessage(Message message) {

		messages.add(message);

		return "redirect:/";
	}

}
