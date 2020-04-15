import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class tess {
	
	
	
	@Test
	public void prixTotal() {

		person tes = new person("wer","dsf",5);
		
		
	
		 tes.prixTotal(3,"madatedenaissance");
		 

	}



	@Test
	public void afficher() {

		person tes = new person("wer","dsf",5);
		tes.afficher(2.4);

	}

	
	@Test
	public void getPlat() {

		person tes = new person("wer","dsf",5);
		tes.getPlat();

	}
	
	@Test
	public void setPlat() {
		
		String plat = "";
		person tes = new person("wer","dsf",5);
		tes.setPlat(plat);

	}

	
	
	
	
	
	
}
