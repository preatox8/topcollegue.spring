package dev.topcolleguesbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.topcolleguesbackend.entite.AvisCollegue;

public interface AvisCollegueRepository extends JpaRepository<AvisCollegue, Integer>{

	List<AvisCollegue> findByPseudo(String pseudo);
}
