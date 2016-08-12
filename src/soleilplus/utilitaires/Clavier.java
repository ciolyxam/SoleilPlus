import java.io.IOException ;
import java.lang.IndexOutOfBoundsException ;
import java.lang.StringIndexOutOfBoundsException ;
// ***********************************************************
// Classe de gestion des saisies au clavier
// ***********************************************************

/** Classe clavier qui contient les méthodes suivantes :<ul>
* <li><b>lireBooleen(String message)</b> qui lit un booléen saisi au clavier, si la données saisie n'est pas autorisée une nouvelle saisie est demandée à l'utilisateur (le prompt affiché est modifié)</li>
* <li><b>lireChar(String message)</b> qui lit un caractère saisi au clavier.</li>
* <li><b>lireClavier(String prompt)</b> qui lit ce qui est saisi au clavier - Saisie terminée par ENTREE</li>
* <li><b>lireDouble(String message)</b> qui lit un réel saisi au clavier, si la données saisie n'est pas un double une nouvelle saisie est demandée à l'utilisateur (le prompt affiché est modifié)</li>
* <li><b>lireEntier(String message)</b> qui lit un entier saisi au clavier</li>
* <li><b>lireString(String message)</b> qui lit une chaîne de caractères saisi au clavier, si aucun caractère n'est saisi (ENTREE directement), une chaîne vide est renvoyée (on ne boucle pas)</li>
* <li>main(java.lang.String[] args) le programme principal qui :créé une table de multiplication 11x11 - (0 à 9) x (0 à9) ; l'affiche (en formatant les entiers sur 5 digits) et teste les méthodes de la classe Clavier.</li></ul>
* Nota : Dans cette classe, les exceptions seront "capturées" et gérées (try … catch) dans la méthode la plus adéquate. Les exceptions à traiter sont : IOException, NumberFormatException, StringIndexOutOfBoundsException.
*/
public final class Clavier  {
	/** Programme principal qui :<ul><li>créé une table de multiplication 11x11 - 
	 *  (0 à 9)x(0 à 9) ; <li>l'affiche (en formatant les entiers sur 5 digits).</li>
	 *  <li>demande à l'utilisateur de saisir 2 opérandes (avec contrôle de saisie) ;</li>
	 *  <li>permet à l'utilisateur de boucler sur la saisie des opérande ; </li>
	 *  <li>teste les méthodes de lecture de données au clavier.</li></ul>
	 */
	public static void main(String args[]) {
		// charge à vous stagiaires de réaliser ici les appels pour tester les fonctions 

	} // FIN DE LA METHODE main()

// *************************************************************************************************
// DECLARATION DES FONCTIONS DE LA CLASSE
// *************************************************************************************************
	/** Cette méthode sert à lire le flot de caractères au clavier et qui gère les erreurs pouvant se produire (rares).
	 *  @param <b>prompt</b> Elle accepte un paramètre de type String qui est l'invite fournie à l'utilisateur (exemple "Saisir un entier :"). Cette fonction sera appelée par toutes les autres.
	 *  @return La valeur renvoyée est un String (sans caractère CR ou LF).
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
			// Dans ce cas la chaine retournée est "" (valeur d'initialisation)
		}
		return chaine ;
	}

	/** Cette méthode est utilisée pour lire une chaîne de caractères saisie au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en paramètre un prompt (Exemple : "Saisir un entier :").<br>
	 *  Si l'utilisateur n'entre aucun caractère et frappe la touche ENTREE, LireString renvoie la chaîne de caractère vide.<br>
	 *  @param <b>message<b> est un paramètre qui correspond au message de base du prompt (Exemple : message à "Saisir un entier" ; prompt à message + " : ").
	 *  @return La valeur renvoyée est un String.
	 */
	public static String lireString(String message) {
		return lireClavier(message + " : ") ;
	}

	/** Cette méthode est utilisée pour lire un entier saisi au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en paramètre un prompt (Exemple : "Saisir un entier :").<br>
	 *  Elle convertit la chaîne de caractères renvoyée par lireClavier en un entier.<br>
	 *  Si la chaîne de caractères renvoyée par lireClavier n'est pas convertible en un entier, lireEntier gère l'erreur : elle demande à l'utilisateur de saisir de nouveau une donnée (le prompt est adapté pour signaler qu'il y a eu une erreur : prompt à message + "( un entier SVP !) :" )<br>
	 *  @param <b>message<b> est un paramètre qui correspond au message de base du prompt (Exemple : "Saisir un entier" ; le prompt étant message + " : ").
	 *  @return La valeur renvoyée est un int.
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

	/** Cette méthode est utilisée pour lire une réponse binaire saisie au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en paramètre un prompt (Exemple : "Voulez-vous continuer :").<br>
	 *  Elle convertit la chaîne de caractères renvoyée par lireClavier en un entier.<br>
	 *  Si la chaîne de caractères renvoyée par lireClavier n'est pas une des valeurs possibles, lireBoleen gère l'erreur : elle demande à l'utilisateur de saisir de nouveau une donnée (le prompt est adapté pour signaler qu'il y a eu une erreur : prompt à message + "(Oui ou Non SVP!) :" )<br>
	 *  @param <b>message<b> est un paramètre qui correspond au message de base du prompt (Exemple : message à "Voulez-vous continuer" ; prompt à message + " : ").
	 *  @return Les réponses positives possibles sont OUI, OUi, Oui, oui, O, o, y, Y, yes, Yes, YEs, YES - la fonction renvoie alors true.<br>Les réponses négatives possibles sont : NON, NOn, Non, non, N, n, no, No, NO - la fonction renvoie alors false.
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

	/** Cette méthode est utilisée pour lire un réel double saisi au clavier.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en paramètre un prompt (Exemple : "Saisir un double :").<br>
	 *  Elle convertit la chaîne de caractères renvoyée par lireClavier en un double.<br>
	 *  Si la chaîne de caractères renvoyée par lireClavier n'est pas convertible en un double, lireEntier gère l'erreur : elle demande à l'utilisateur de saisir de nouveau une donnée (le prompt est adapté pour signaler qu'il y a eu une erreur : prompt à message + "(un double SVP !) :" )<br>
	 *  @param Elle accepte un paramètre qui correspond au message de base du prompt (Exemple : "Saisir un double" ; le prompt étant message + " : ").
	 *  @return La valeur renvoyée est un double.
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

	/** Cette méthode est utilisée pour lire un caractère saisi au clavier. La valeur renvoyée est un char.<br>
	 *  Elle appelle la fonction lireClavier en lui passant en paramètre un prompt (Exemple : "Saisir un caractere :").<br>
	 *  Elle extrait le 1er caractère de la chaîne de caractères renvoyée par lireClavier (penser à la méthode charAt()).<br>
	 *  Si lireClavier renvoie la chaîne vide (cas où l'utilisateur a saisi directement ENTREE), une erreur sera générée (charAt() essayant d'accéder au 1er élément de la chaîne… qui n'existe pas !). lireChar gère cette erreur. Elle demande à l'utilisateur de saisir de nouveau une donnée (le prompt est adapté pour signaler qu'il y a eu une erreur : prompt à message + "(un caractere SVP !) :" )<br>
	 *  @param <b>message<b> est un paramètre qui correspond au message de base du prompt (Exemple : message à "Saisir un caractere" ; prompt à message + " : ").
	 *  @return un caractère de type char (1er caractère de la chaine saisie)
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