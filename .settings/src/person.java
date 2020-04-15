 


	public class person {

	
	
	public String nom;
	public String plat;
	public int qnt;
	
	
	
	public person(String nom, String plat, int qnt) {
		super();
		this.nom = nom;
		this.plat = plat;
		this.qnt = qnt;
		
	}
	
	public String getPlat() {

		return this.plat;

	}

	public void setPlat(String plat) {

		this.plat = plat;

	}

	
	public double prixTotal(int qnt, String plat) {
		double prix = 0;
		
		double prixTot;

		switch (plat) {

		case "Poutine":
			prix = 10.5;
			break;
		case "Frites":
			prix = 2.5;
			break;
		case "Repas_Poulet":
			prix = 15.75;
			break;
		}

		prixTot = prix * qnt;

		return prixTot ;
	}
	public void afficher(double prix) {
		System.out.print(this.nom + " " + prix+ "\n");
		
	}


		
}