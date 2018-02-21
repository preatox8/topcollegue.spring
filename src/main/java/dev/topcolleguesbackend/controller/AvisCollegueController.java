package dev.topcolleguesbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.topcolleguesbackend.entite.AvisCollegue;
import dev.topcolleguesbackend.entite.Collegue;
import dev.topcolleguesbackend.repository.AvisCollegueRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AvisCollegueController {

	@Autowired
	private AvisCollegueRepository avisCollegueRepository;
	
	@RequestMapping(path = "/avis", method = RequestMethod.POST)
	public AvisCollegue ajouteraviscollegue(@RequestBody AvisCollegue aviscollegue) {
			AvisCollegue aviscollegueajout = new AvisCollegue();
			aviscollegueajout.setAvis(aviscollegue.getAvis());
			aviscollegueajout.setPseudo((aviscollegue.getPseudo()));
			avisCollegueRepository.save(aviscollegueajout);
			return aviscollegueajout;
	}
	
	@RequestMapping(path = "/avis/{pseudo}", method = RequestMethod.GET)
	public List<AvisCollegue> afficheravisuncollegue(@PathVariable String pseudo) {
		List<AvisCollegue> avisuncollegueajour = avisCollegueRepository.findByPseudo(pseudo);
		return avisuncollegueajour;
		
	}
}
