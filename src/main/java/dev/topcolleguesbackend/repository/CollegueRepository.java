package dev.topcolleguesbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.topcolleguesbackend.entite.Collegue;

public interface CollegueRepository extends JpaRepository<Collegue, Integer>{

	Collegue findByPseudo(String pseudo);
	
}
