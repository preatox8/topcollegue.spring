package dev.topcolleguesbackend.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AVISCOLLEGUE")
public class AvisCollegue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "AVIS")
	private String avis;
	
	@Column(name = "PSEUDO")
	private String pseudo;

	public AvisCollegue() {
		super();
	}

	public AvisCollegue(String avis, String pseudo) {
		super();
		this.avis = avis;
		this.pseudo = pseudo;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the avis
	 */
	public String getAvis() {
		return avis;
	}

	/**
	 * @param avis the avis to set
	 */
	public void setAvis(String avis) {
		this.avis = avis;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	

}
