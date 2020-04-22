import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class tess3 {

	@Test
	public void main() throws IOException {

		String[] as = { "" };
		fichierlire myObject = new fichierlire();
		myObject.doSomething();
		myObject.main(as);
		int commande01 = 15, plats01 = 16, qt01 = 17;
		int commande02 = 18, plats02 = 19, qt02 = 20;
		int commande03 = 21, plats03 = 22, qt03 = 23;

		boolean veriter = false;

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
					commande2.afficher();
					commande3.setClient(pair[4]);
					commande2.modif(0);

					try {

						Date actuelle = new Date();
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

						File out = new File("files/java.txt");
						out.renameTo(new File("files/Facture_du_" + dateFormat.format(actuelle)));

						PrintStream myconsole = new PrintStream(new File("files/java.txt"));
						System.setOut(myconsole);
						System.out.println("Bienvenue chez Barette!" + "\n" + "Factures : " + "\n");
						commande1.afficher();
						commande2.modif(nb);
						commande2.afficher();
						commande3.setClient(pair[4]);
						commande2.modif(0);

						// commande3.affichernv();

					} catch (FileNotFoundException fx) {
						System.out.println(fx);
					}

					// Message d'erreur si le fichier de respecte pas les memes normes que
					// teston.txt
					catch (Exception e) {

						System.out.println(
								"\n2 ERREUR POSSIBLES : « La suite du fichier ne respecte pas la norme correct ! » OU « Le fichier ne respecte pas le format\r\n"
										+ "demandé ! ». ");
					}
				}
			}
		}
	}
}
