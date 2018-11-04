package donnees;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import boutique.Boutique;


public class Enregistrement  {
	

	public void save(Boutique b, String nomFichier) throws ExceptionSave {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(
							new File(nomFichier))));
			oos.writeObject(b);
			oos.close();
		}
		catch (FileNotFoundException e) {
			throw new ExceptionSave("Le fichier n'est pas valide.");
		}
		catch (IOException e) {
			throw new ExceptionSave("Sauvegarde impossible.");
		}
	}

	
	public Boutique load(String nomFichier) throws ExceptionSave {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
				new BufferedInputStream(
					new FileInputStream(
						new File(nomFichier))));
			Boutique boutique = (Boutique)ois.readObject();
			ois.close();
			return boutique;
		}
		catch (ClassNotFoundException e) {
			try {
				ois.close();
			}
			catch (IOException e2) {
				throw new ExceptionSave("Chargement impossible.");
			}
			throw new ExceptionSave("Le fichier ne comporte pas de donnees de boutique.");
		}
		catch (FileNotFoundException e) {
			throw new ExceptionSave("Le fichier n'existe pas.");
		}
		catch (IOException e) {
			throw new ExceptionSave("Chargement impossible.");
		}
	}

}
