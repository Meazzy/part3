import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fichierlire {

	public static void main(String[] args) throws IOException {

		int commande01 = 15, plats01 = 16, qt01 = 17;
		int commande02 = 18, plats02 = 19, qt02 = 20;
		int commande03 = 21, plats03 = 22, qt03 = 23;

		boolean veriter = false;

		// Lecture du fichier.
		try (BufferedReader in = new BufferedReader(new FileReader("files/teston.txt"))) {
			String line;

			System.out.println("Bienvenue chez Barette!" + "\n" + "Factures : " + "\n");

			while ((line = in.readLine()) != null) {
				String[] pair = line.split(" ");

				veriter = true;

				// Les Objets Commande.
				Commandes commande1 = new Commandes(pair[commande01], pair[plats01], Integer.parseInt(pair[qt01]));
				Commandes commande2 = new Commandes(pair[commande02], pair[plats02], Integer.parseInt(pair[qt02]));
				Commandes commande3 = new Commandes(pair[commande03], pair[plats03], Integer.parseInt(pair[qt03]));

				if (pair[commande02].equals(pair[commande03])) {
					double nb = 0;

					nb = commande2.prixTotal(Integer.parseInt(pair[qt02]), pair[plats02])
							+ commande3.prixTotal(Integer.parseInt(pair[qt03]), pair[plats03]);

					commande1.afficher();
					commande2.modif(nb);
					commande2.affichernv();
					commande3.setClient(pair[4]);
					commande2.modif(0);

					commande3.affichernv();

				} else if (pair[commande01].equals(pair[commande02])) {
					double nb = 0;

					nb = commande1.prixTotal(Integer.parseInt(pair[qt01]), pair[plats01])
							+ commande2.prixTotal(Integer.parseInt(pair[qt02]), pair[plats02]);

					commande1.modif(nb);
					commande1.affichernv();

					commande2.setClient(pair[3]);
					commande2.modif(0);
					commande2.affichernv();

					commande3.afficher();

				} else {

					commande1.afficher();
					commande2.afficher();
					commande3.afficher();

				}
			}

			// Message d'erreur si le fichier de respecte pas les memes normes que
			// teston.txt
		} catch (Exception e) {

			System.out.println(
					"\n2 ERREUR POSSIBLES : « La suite du fichier ne respecte pas la norme correct ! » OU « Le fichier ne respecte pas le format\r\n"
							+ "demandé ! ». ");
		}

	}

	public void doSomething() {
		// TODO Auto-generated method stub
		
	}
}
