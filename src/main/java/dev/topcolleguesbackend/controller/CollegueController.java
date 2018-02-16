package dev.topcolleguesbackend.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.topcolleguesbackend.entite.Collegue;
import dev.topcolleguesbackend.repository.CollegueRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CollegueController {

	@Autowired
	private CollegueRepository collegueRepository;
	
	@RequestMapping(path = "/collegues", method = RequestMethod.GET)
	public List<Collegue> listercollegue() {
		return this.collegueRepository.findAll();
	}
	
	@RequestMapping(path = "/collegues", method = RequestMethod.POST)
	public Collegue ajoutercollegue(@RequestBody Collegue collegue) {
		
		if(collegueRepository.findByPseudo(collegue.getPseudo()) == null) {
			Collegue collegueajout = new Collegue();
			collegueajout.setScore(collegue.getScore());
			collegueajout.setImageUrl(collegue.getImageUrl());
			collegueajout.setPseudo(collegue.getPseudo());
			
			collegueRepository.save(collegueajout);
			
			return collegueajout;
			
		}else {
			System.out.println("Pseudo déja existant");
			return null;
		}
	}
	
	@RequestMapping(path = "/collegues/{pseudo}", method = RequestMethod.PATCH)
	public Collegue majscore(@PathVariable String pseudo, @RequestBody Map<String, String> collegue) {
		Collegue collegueajour = collegueRepository.findByPseudo(pseudo);

		if(collegue.get("action").contains("aimer")) {
			collegueajour.setScore(collegueajour.getScore()+10);
			
		}else if(collegue.get("action").contains("detester")){
			collegueajour.setScore(collegueajour.getScore()-5);
		}
		
		collegueRepository.save(collegueajour);
		
		return collegueajour;
	}
	
	@RequestMapping(path = "/collegues/{pseudo}", method = RequestMethod.GET)
	public Collegue affichercollegue(@PathVariable String pseudo) {
		Collegue collegueajour = collegueRepository.findByPseudo(pseudo);
		return collegueajour;
		
	}
}
