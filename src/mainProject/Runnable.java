package mainProject;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import catalogo_bibliotecario.Frequenza;
import catalogo_bibliotecario.Lettura;
import catalogo_bibliotecario.LetturaDAO;
import catalogo_bibliotecario.Libro;
import catalogo_bibliotecario.Rivista;
import utils.JpaUtil;

public class Runnable {

	static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	public static void main(String[] args) {
		System.out.println("esisto");
		
		// Aggiunta di un elemento del catalogo
		Libro l1 = new Libro();
		String ISBN1 = LetturaDAO.generatore_codice_ISBN();
		l1.setCodice_ISBN(ISBN1);
		l1.setTitolo("Libro");
		l1.setAnno_pubblicazione(LocalDate.of(2020,11,24));
		l1.setNumero_pagine(211);
		l1.setAutore("Maccio Capatonda");
		l1.setGenere("Libro Cartonato");
		// LetturaDAO.salva_libro(l1);
		
		Rivista r1 = new Rivista();
		String ISBN2 = LetturaDAO.generatore_codice_ISBN();
		r1.setCodice_ISBN(ISBN2);
		r1.setTitolo("Limes");
		r1.setAnno_pubblicazione(LocalDate.of(1993,1,1));
		r1.setNumero_pagine(300);
		r1.setPeriodicità(Frequenza.MENSILE);
		
		// LetturaDAO.salva_rivista(r1);
		
		// Rimozione di un elemento del catalogo dato un codice ISBN
		LetturaDAO.rimuovi_con_codice_ISBN(ISBN1);
		
		//  Ricerca per ISBN
		Libro libro_cercato = LetturaDAO.trova_libro(ISBN1);
		Rivista Rivista_carcata = LetturaDAO.trova_rivista(ISBN2);
		
		// Ricerca per anno pubblicazione
		List<Lettura> elenco_per_anno = LetturaDAO.trova_per_anno_pubblicazione(LocalDate.of(2020,11,24));
		
		// Ricerca per autore
		List<Lettura> elenco_per_autore = LetturaDAO.trova_per_autore("Maccio Capatonda");
		
		// Ricerca per titolo o parte di esso
		List<Lettura> elenco_per_titolo = LetturaDAO.trova_per_titolo("Limes");
		
		// Ricerca degli elementi attualmente in prestito dato un numero di tessera utente
		
		
		// Ricerca di tutti i prestiti scaduti e non ancora restituiti
		
	}
}
