import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Test;

public class tess2 {
	
	
	
	@Test
	public void prixTotal() {

		Commandes tes = new Commandes("wer","dsf",5);	
		tes.prixTotal(3,"madatedenaissance");

		 
	}


	@Test
	public void getClient() {

		Commandes tes = new Commandes("wer","dsf",5);
		tes.getClient();

	}
	
	@Test
	public void setClient() {
		
		String client = "";
		Commandes tes = new Commandes("wer","dsf",5);
		tes.setClient(client); 

	}

	@Test
	public void modif() {

		double nul = 0;
		Commandes tes = new Commandes("wer","dsf",5);
		tes.tot = nul; 
		
	}

	
	@Test
	public void afficher() {
		Commandes tes = new Commandes("wer","dsf",5);
		tes.afficher();
	}
	
	@Test
	public void affichernv() {

		Commandes tes = new Commandes("wer","dsf",5);
		tes.afficher();

	}
}
