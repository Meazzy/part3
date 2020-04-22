import java.text.DecimalFormat;

public class Commandes {

	public double TVS = 5.0;
	public double TVQ = 9.975;

	public String client;
	public String plats;
	public int quantite;
	public double tot;
	public boolean Frai0;
	public boolean Frai1;

	public Commandes(String pClient, String pPlats, int pQuantite) {
		super();
		this.client = pClient;
		this.plats = pPlats;
		this.quantite = pQuantite;

	}

	public String getClient() {

		return this.client;

	}

	public void setClient(String client) {

		this.client = client;

	}

	public double prixTotal(int quantite, String plats) {
		double prix = 0;
		double totale;

		switch (plats) {

		case "Poutine":
			prix = 10.50;
			break;
		case "Frites":
			prix = 2.50;
			break;
		case "Repas_Poulet":
			prix = 15.75;
			break;
		}

		totale = (prix * quantite);

		TVQ = (totale * TVQ) / 100;
		TVS = (totale * TVS) / 100;

		totale = totale * 1.14975;

		return totale;
	}

	public double modif(double nul) {

		tot = nul;
		return tot;
	}

	public void afficher() {
		if (Facture1()) {

			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2); // arrondi à 2 chiffres apres la virgules
			df.setMinimumFractionDigits(2);
			df.setDecimalSeparatorAlwaysShown(true);

			System.out.print(this.client + "\t" + df.format(prixTotal(quantite, plats)) + "$ taxes incluses" + "\n");

		}

	}

	public void afficherErreur() {

		if (Facture0()) {
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2); // arrondi à 2 chiffres apres la virgules
			df.setMinimumFractionDigits(2);
			df.setDecimalSeparatorAlwaysShown(true);
			System.out.print(
					"\n Les erreurs sont : \n" + this.client + "\t" + df.format(modif(0)) + "$ taxes incluses" + "\n");

		}

	}

	public boolean Facture1() {

		if (this.quantite != 0) {
			Frai1 = true;

		}
		return Frai1;

	}

	public boolean Facture0() {

		if (prixTotal(quantite, plats) == 0) {
			Frai0 = true;

		}
		return Frai0;

	}
}
