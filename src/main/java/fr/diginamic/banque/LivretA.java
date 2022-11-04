package fr.diginamic.banque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="LIVRET_A")
public class LivretA extends Compte {
	
	@Column(name = "TAUX", nullable= false, unique= true)
	public double taux;

	public LivretA() {
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
