import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class tess3 {
	
	
	@Test
	public void main() throws IOException {

		String[] as = {""};
		 fichierlire myObject = new fichierlire();
		    myObject.doSomething();
		    myObject.main(as);
		int commande022 = 18, plats02 = 19, qt02 = 20;
		int commande033 = 21, plats03 = 22, qt03 = 23;

		boolean veriter = false;

		// Lecture du fichier.
		try (BufferedReader in = new BufferedReader(new FileReader("files/teston.txt"))) {
			String line;

			System.out.println("Bienvenue chez Barette!" + "\n" + "Factures : " + "\n");

			while ((line = in.readLine()) != null) {
				String[] pair = line.split(" ");

				veriter = true;

				// Les Objets Commande.
				
			
				Commandes tes1 = new Commandes("wer","dsf",5);
				Commandes tes2 = new Commandes("wer","dsf",5);
				Commandes tes3 = new Commandes("wer","dsf",5);

				if (pair[commande022].equals(pair[commande033])) {
					double nb = 0;

					nb = tes2.prixTotal(Integer.parseInt(pair[qt02]), pair[plats02])
							+ tes3.prixTotal(Integer.parseInt(pair[qt03]), pair[plats03]);

					tes1.afficher();
					tes2.modif(nb);
					tes2.affichernv();
					tes3.setClient(pair[4]);
					tes2.modif(0);

					tes3.affichernv();

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
	
}
