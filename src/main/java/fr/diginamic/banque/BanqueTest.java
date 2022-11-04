package fr.diginamic.banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BanqueTest {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque-jpa");
		EntityManager entity = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entity.getTransaction();
		
		transaction.begin();
		
		
		//---------------------------------------------------------------------
		// Banques des clients
		//---------------------------------------------------------------------
		
		Banque banque1 = new Banque();
		banque1.setNom("Crédit Mutuelle");
		entity.persist(banque1);
		
		Banque banque2 = new Banque();
		banque2.setNom("Société Générale");
		entity.persist(banque2);
		
		Banque banque3 = new Banque();
		banque3.setNom("Groupama");
		entity.persist(banque3);
		
		
		//---------------------------------------------------------------------
		// Adresses des clients
		//---------------------------------------------------------------------
		
		Adresse adresse1 = new Adresse();
		adresse1.setNumero(99);
		adresse1.setRue("Av. Ferdinand de Lesseps");
		adresse1.setCodePostal(38000);
		adresse1.setVille("Grenoble");
		
		Adresse adresse2 = new Adresse();
		adresse2.setNumero(75);
		adresse2.setRue("Rue Banaudon");
		adresse2.setCodePostal(69009);
		adresse2.setVille("Lyon");
		
		Adresse adresse3 = new Adresse();
		adresse3.setNumero(58);
		adresse3.setRue("Rue des Coudriers");
		adresse3.setCodePostal(68200);
		adresse3.setVille("Mulhouse");
		
		
		//---------------------------------------------------------------------
		// Les clients
		//---------------------------------------------------------------------
		
		Client client1 = new Client();
		client1.setNom("Racot");
		client1.setPrenom("Charlotte");
		client1.setDateNaissance(LocalDate.of(1941, 2, 13));
		client1.setBanque(banque1);
		client1.setAdresse(adresse3);
		entity.persist(client1);
		
		Client client2 = new Client();
		client2.setNom("Miron");
		client2.setPrenom("Antoine");
		client2.setDateNaissance(LocalDate.of(1982, 8, 11));
		client2.setBanque(banque2);
		client2.setAdresse(adresse2);
		entity.persist(client2);
		
		Client client3 = new Client();
		client3.setNom("Puillau");
		client3.setPrenom("Cloé");
		client3.setDateNaissance(LocalDate.of(2002, 12, 4));
		client3.setBanque(banque3);
		client3.setAdresse(adresse3);
		entity.persist(client3);
		
		Client client4 = new Client();
		client4.setNom("Dupont");
		client4.setPrenom("Jean");
		client4.setDateNaissance(LocalDate.of(1998, 9, 28));
		client4.setBanque(banque1);
		client4.setAdresse(adresse1);
		entity.persist(client4);
		
		Client client5 = new Client();
		client5.setNom("Broncheau");
		client5.setPrenom("Thomas");
		client5.setDateNaissance(LocalDate.of(1996, 5, 16));
		client5.setBanque(banque1);
		client5.setAdresse(adresse3);
		entity.persist(client5);
		
		
		//---------------------------------------------------------------------
		// Comptes des clients
		//---------------------------------------------------------------------
		
		LivretA livretA1 = new LivretA();
		livretA1.setNumero("SG-01-5468416519");
		livretA1.setSolde(11256);
		livretA1.setTaux(1.5);
		livretA1.getClients().add(client2);
		entity.persist(livretA1);
		
		LivretA livretA2 = new LivretA();
		livretA2.setNumero("CM-01-4421867359");
		livretA2.setSolde(2593);
		livretA2.setTaux(2);
		livretA2.getClients().add(client4);
		entity.persist(livretA2);
		
		AssuranceVie assuranceVie1 = new AssuranceVie();
		assuranceVie1.setNumero("CM-02-2492767386");
		assuranceVie1.setSolde(46995);
		assuranceVie1.setDateFin(LocalDate.of(2057, 11, 19));
		assuranceVie1.setTaux(3);
		assuranceVie1.getClients().add(client1);
		entity.persist(assuranceVie1);
		
		AssuranceVie assuranceVie2 = new AssuranceVie();
		assuranceVie2.setNumero("GR-02-2318673269");
		assuranceVie2.setSolde(60744);
		assuranceVie2.setDateFin(LocalDate.of(2049, 1, 04));
		assuranceVie2.setTaux(4.2);
		assuranceVie2.getClients().add(client3);
		assuranceVie2.getClients().add(client5);
		entity.persist(assuranceVie2);
		
		AssuranceVie assuranceVie3 = new AssuranceVie();
		assuranceVie3.setNumero("SG-01-5468416519");
		assuranceVie3.setSolde(81004);
		assuranceVie3.setDateFin(LocalDate.of(2072, 10, 31));
		assuranceVie3.setTaux(3.1);
		assuranceVie3.getClients().add(client2);
		entity.persist(assuranceVie2);
		
		
		//---------------------------------------------------------------------
		// Opérations des clients
		//---------------------------------------------------------------------
		
		Virement virement1 = new Virement();
		virement1.setDate(LocalDateTime.now());
		virement1.setMontant(125);
		virement1.setMotif("Paiement pour une réservitation à l'hotel");
		virement1.setBeneficiaire("Ibis Hotel Rennes");
		virement1.setCompte(livretA2);
		entity.persist(virement1);
		
		Virement virement2 = new Virement();
		virement2.setDate(LocalDateTime.now());
		virement2.setMontant(1300);
		virement2.setMotif("Installation d'un poêle à bois");
		virement2.setBeneficiaire("Entreprise Feu de Dieu");
		virement2.setCompte(assuranceVie2);
		entity.persist(virement2);
		
		Operation operation1 = new Operation();
		operation1.setDate(LocalDateTime.now());
		operation1.setMontant(90);
		operation1.setMotif("Virement du Livret A au compte chèque");
		operation1.setCompte(livretA2);
		entity.persist(operation1);
		
		Operation operation2 = new Operation();
		operation2.setDate(LocalDateTime.now());
		operation2.setMontant(200);
		operation2.setMotif("Virement de l'assurance au compte chèque");
		operation2.setCompte(assuranceVie1);
		entity.persist(operation2);
		
		
		transaction.commit();
		}
}
