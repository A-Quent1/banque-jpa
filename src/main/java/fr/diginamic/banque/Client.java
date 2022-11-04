package fr.diginamic.banque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.diginamic.banque.Client;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "NOM", length = 50, nullable= false, unique= true)
	public String nom;
	
	@Column(name = "PRENOM", length = 50, nullable= false, unique= true)
	public String prenom;
	
	@Column(name = "DATE_NAISSANCE", nullable= false, unique= true)
	public LocalDate dateNaissance;
	
	@Embedded
	public Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name = "ID_BANQUE")
	public Banque banque;
	
	@ManyToMany
	@JoinTable(name = "LIEN_CLIENT_COMPTE",
	joinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "ID_COMPTE", referencedColumnName = "Id" ))
	public List<Compte> comptes = new ArrayList<Compte>();
	
	/**
	 * 
	 */
	public Client() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}

	/**
	 * @param banque the banque to set
	 */
	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	/**
	 * @return the comptes
	 */
	public List<Compte> getComptes() {
		return comptes;
	}

	/**
	 * @param comptes the comptes to set
	 */
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
