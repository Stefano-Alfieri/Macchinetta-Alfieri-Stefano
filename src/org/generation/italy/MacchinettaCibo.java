package org.generation.italy;
//import scanner
import java.util.Scanner;

public class MacchinettaCibo {
	public static void main(String[] args) {
		// apro scanner
		Scanner sc = new Scanner(System.in);
		// variabili e array
		double soldiUtente = 0, bilancioMacchinetta = 100;
		int[] quantitaProd = { 3, 7, 10, 2, 5 };
		String[] codiceProd = { "111", "222", "333", "444", "555" };
		double[] prezziProd = { 2, 2.5, 1.50, 3.50, 1 };
		double resto = 0;
		String codiceInserito;
		boolean indiceProd = false;
		int i;
		//inizio ciclo do while per ricomiciare sempre
		do {
			//richiesta codice
			System.out.print("Selezionare codice prodotto (o C per uscire): ");
			codiceInserito = sc.nextLine();
			//condizione per uscire dal ciclo tasto cancel
			if (codiceInserito.equalsIgnoreCase("c")) {
				System.out.println("arrivederci");
				break; //da continuare
			}
			
			
			//*INIZIO LATO UTENTE*
			
			
			//ciclo for per ricerca elemento
			for (i = 0; i < codiceProd.length; i++) {
				//verifica all'interno dell array
				if (codiceProd[i].equalsIgnoreCase(codiceInserito)) {
					indiceProd = true;
					//verifica quantità
					if (quantitaProd[i] >= 1) {
						//stampa prezzo e richiesta monete
						System.out.println("Il prezzo del prodotto è " + prezziProd[i] + " €.");
						System.out.println("inserire le monete una alla volta");
						//inizio ciclo do while per inserimento altre monete
						do {
							//aumento soldi inseriti
							soldiUtente = soldiUtente + sc.nextDouble();
							//verifica di impporto sufficente
							if (soldiUtente >= prezziProd[i]) {
								//riduzione quantità array
								quantitaProd[i] -= 1;
								//calcolo resto
								resto = soldiUtente - prezziProd[i];
								//stampa prodotto
								System.out.println("erogazione prodotto in corso");
								//verifica presenza di resto e stampa
								if (resto > 0) {
									System.out.println("il resto è " + resto + " €. verrà erogato a breve");
								}
								//aumento bilancio e azzeramento variabili
								bilancioMacchinetta = (bilancioMacchinetta + prezziProd[i]);
								resto = 0;
								soldiUtente = 0;
							}
							//fine ciclo do while inserimento monete
						} while (soldiUtente < prezziProd[i]);
						//quantità prodotto non disponibile
					} else {
						System.out.println("Quantità non disponibile.");
					}
				}
			}
			//verifica codice non presente nella macchinetta
			if (!indiceProd) {
				System.out.println("Prodotto non trovato.");
			}
			System.out.println("arrivederci");
			//fine ciclo do while per richiedere nuovamente tutto
		} while (true);
		
		//*FINE LATO UTENTE*
		
		
		
		
	}//fine main
}//fine progetto