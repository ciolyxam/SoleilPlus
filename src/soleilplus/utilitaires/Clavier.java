import java.io.IOException ;
import java.lang.IndexOutOfBoundsException ;
import java.lang.StringIndexOutOfBoundsException ;
// ***********************************************************
// Classe de gestion des saisies au clavier
// ***********************************************************

/** Classe clavier qui contient les m�thodes suivantes :<ul>
* <li><b>lireBooleen(String message)</b> qui lit un bool�en saisi au clavier, si la donn�es saisie n'est pas autoris�e une nouvelle saisie est demand�e � l'utilisateur (le prompt affich� est modifi�)</li>
* <li><b>lireChar(String message)</b> qui lit un caract�re saisi au clavier.</li>
* <li><b>lireClavier(String prompt)</b> qui lit ce qui est saisi au clavier - Saisie termin�e par ENTREE</li>
* <li><b>lireDouble(String message)</b> qui lit un r�el saisi au clavier, si la donn�es saisie n'est pas un double une nouvelle saisie est demand�e � l'utilisateur (le prompt affich� est modifi�)</li>
* <li><b>lireEntier(String message)</b> qui lit un entier saisi au clavier</li>
* <li><b>lireString(String message)</b> qui lit une cha�ne de caract�res saisi au clavier, si aucun caract�re n'est saisi (ENTREE directement), une cha�ne vide est renvoy�e (on ne boucle pas)</li>
* <li>main(java.lang.String[] args) le programme principal qui :cr�� une table de multiplication 11x11 - (0 � 9) x (0 �9) ; l'affiche (en formatant les entiers sur 5 digits) et teste les m�thodes de la classe Clavier.</li></ul>
* Nota : Dans cette classe, les exceptions seront "captur�es" et g�r�es (try � catch) dans la m�thode la plus ad�quate. Les exceptions � traiter sont : IOException, NumberFormatException, StringIndexOutOfBoundsException.
*/
public final class Clavier  {
	/** Programme principal qui :<ul><li>cr�� une table de multiplication 11x11 - 
	 *  (0 � 9)x(0 � 9) ; <li>l'affiche (en formatant les entiers sur 5 digits).</li>
	 *  <li>demande � l'utilisateur de saisir 2 op�randes (avec contr�le de saisie) ;</li>
	 *  <li>permet � l'utilisateur de boucler sur la saisie des op�rande ; </li>
	 *  <li>teste les m�thodes de lecture de donn�es au clavier.</li></ul>
	 */
	public static void main(String args[]) {
		// charge � vous stagiaires de r�aliser ici les appels pour tester les fonctions 

	} // FIN DE LA METHODE main()

// *************************************************************************************************
// DECLARATION DES FONCTIONS DE LA CLASSE
// *************************************************************************************************
	/** Cette m�thode sert � lire le flot de caract�res au clavier et qui g�re les erreurs pouvant se produire (rares).
	 *  @param <b>prompt</b> Elle accepte un param�tre de type String qui est l'invite fournie � l'utilisateur (exemple "Saisir un entier :"). Cette fonction sera appel�e par toutes les autres.
	 *  @return La valeur renvoy�e est un String (sans caract�re CR ou LF).
	 */
	public static String lireClavier(String prompt) {
		String chaine = "" ;
		char car ;

		System.out.print(prompt) ;
		try {
			while((car = (char) System.in.read()) != '\n') chaine = chaine + car ;
			chaine = chaine.substring(0,chaine.length()-1) ;
		}
		catch (IOException e) {
			System.out.println("Erreur de saisie au clavier") ;
			// Dans ce cas la chaine retourn�e est "" (valeur d'initialisation)
		}
		return chaine ;
	}

	/** Cette m�thode est utilis�e pour lire une cha�ne de caract�res saisie au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en param�tre un prompt (Exemple : "Saisir un entier :").<br>
	 *  Si l'utilisateur n'entre aucun caract�re et frappe la touche ENTREE, LireString renvoie la cha�ne de caract�re vide.<br>
	 *  @param <b>message<b> est un param�tre qui correspond au message de base du prompt (Exemple : message � "Saisir un entier" ; prompt � message + " : ").
	 *  @return La valeur renvoy�e est un String.
	 */
	public static String lireString(String message) {
		return lireClavier(message + " : ") ;
	}

	/** Cette m�thode est utilis�e pour lire un entier saisi au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en param�tre un prompt (Exemple : "Saisir un entier :").<br>
	 *  Elle convertit la cha�ne de caract�res renvoy�e par lireClavier en un entier.<br>
	 *  Si la cha�ne de caract�res renvoy�e par lireClavier n'est pas convertible en un entier, lireEntier g�re l'erreur : elle demande � l'utilisateur de saisir de nouveau une donn�e (le prompt est adapt� pour signaler qu'il y a eu une erreur : prompt � message + "( un entier SVP !) :" )<br>
	 *  @param <b>message<b> est un param�tre qui correspond au message de base du prompt (Exemple : "Saisir un entier" ; le prompt �tant message + " : ").
	 *  @return La valeur renvoy�e est un int.
	 */
	public static int lireEntier(String message) {
		String prompt = message + " : " ;
		int entierSaisi = 0 ;
		boolean continuer = true ;

		while(continuer) {
			try {
				entierSaisi = Integer.parseInt(lireClavier(prompt)) ;
				continuer = false ;
			}
			catch(NumberFormatException e) {
				prompt = message + " (saisir un entier SVP !) : " ;
			}
		}
		return entierSaisi ;
	}

	/** Cette m�thode est utilis�e pour lire une r�ponse binaire saisie au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en param�tre un prompt (Exemple : "Voulez-vous continuer :").<br>
	 *  Elle convertit la cha�ne de caract�res renvoy�e par lireClavier en un entier.<br>
	 *  Si la cha�ne de caract�res renvoy�e par lireClavier n'est pas une des valeurs possibles, lireBoleen g�re l'erreur : elle demande � l'utilisateur de saisir de nouveau une donn�e (le prompt est adapt� pour signaler qu'il y a eu une erreur : prompt � message + "(Oui ou Non SVP!) :" )<br>
	 *  @param <b>message<b> est un param�tre qui correspond au message de base du prompt (Exemple : message � "Voulez-vous continuer" ; prompt � message + " : ").
	 *  @return Les r�ponses positives possibles sont OUI, OUi, Oui, oui, O, o, y, Y, yes, Yes, YEs, YES - la fonction renvoie alors true.<br>Les r�ponses n�gatives possibles sont : NON, NOn, Non, non, N, n, no, No, NO - la fonction renvoie alors false.
	 */
	public static boolean lireBooleen(String message) {
		String chaine = "", prompt = message ;
		boolean continuer = true ;
		boolean reponse = false ;
	
		while (continuer) {
			chaine = lireClavier(prompt).toUpperCase() ;
			if (chaine.equals("OUI") | chaine.equals("O") | chaine.equals("YES") | chaine.equals("Y")) {
				continuer = false ;
				reponse = true ;
			}
			else if (chaine.equals("NON") | chaine.equals("N") | chaine.equals("NO")){
				continuer = false ;
				reponse = false ;
			}
			prompt = message + " (reponse oui ou non) : " ;
		}
		return reponse ;
	}

	/** Cette m�thode est utilis�e pour lire un r�el double saisi au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en param�tre un prompt (Exemple : "Saisir un double :").<br>
	 *  Elle convertit la cha�ne de caract�res renvoy�e par lireClavier en un double.<br>
	 *  Si la cha�ne de caract�res renvoy�e par lireClavier n'est pas convertible en un double, lireEntier g�re l'erreur : elle demande � l'utilisateur de saisir de nouveau une donn�e (le prompt est adapt� pour signaler qu'il y a eu une erreur : prompt � message + "(un double SVP !) :" )<br>
	 *  @param Elle accepte un param�tre qui correspond au message de base du prompt (Exemple : "Saisir un double" ; le prompt �tant message + " : ").
	 *  @return La valeur renvoy�e est un double.
	 */
	public static double lireDouble(String message) {
		String prompt = message + " : " ;
		double doubleSaisi = 0.0 ;
		boolean continuer = true ;

		while(continuer) {
			try {
				doubleSaisi = Double.parseDouble(lireString(prompt)) ;
				continuer = false ;
			}
			catch(NumberFormatException e) {
				prompt = message + " (saisir un nombre compatible double SVP !) : " ;
			}
		}
		return doubleSaisi ;
	}

	/** Cette m�thode est utilis�e pour lire un caract�re saisi au clavier. La valeur renvoy�e est un char.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en param�tre un prompt (Exemple : "Saisir un caractere :").<br>
	 *  Elle extrait le 1er caract�re de la cha�ne de caract�res renvoy�e par lireClavier (penser � la m�thode charAt()).<br>
	 *  Si lireClavier renvoie la cha�ne vide (cas o� l'utilisateur a saisi directement ENTREE), une erreur sera g�n�r�e (charAt() essayant d'acc�der au 1er �l�ment de la cha�ne� qui n'existe pas !). lireChar g�re cette erreur. Elle demande � l'utilisateur de saisir de nouveau une donn�e (le prompt est adapt� pour signaler qu'il y a eu une erreur : prompt � message + "(un caractere SVP !) :" )<br>
	 *  @param <b>message<b> est un param�tre qui correspond au message de base du prompt (Exemple : message � "Saisir un caractere" ; prompt � message + " : ").
	 *  @return un caract�re de type char (1er caract�re de la chaine saisie)
	 */
	public static char lireChar(String message) {
		String prompt = message + " : " ;
		char charSaisi = ' ' ;
		boolean continuer = true ;

		while(continuer) {
			try {
				charSaisi = lireClavier(prompt).charAt(0) ;
				continuer = false ;
			}
			catch(StringIndexOutOfBoundsException e) {
				prompt = message + " (saisir au moins un caractere SVP !) : " ;
			}
		}
		return charSaisi ;
	}
}

//************************************************************
// FIN DE LA CLASSE Clavier
//************************************************************