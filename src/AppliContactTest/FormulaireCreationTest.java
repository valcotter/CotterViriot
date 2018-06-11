/**
* Exercice X
* Semaine X
* Auteur : Audrey VIRIOT
* Date de création : 11 juin 2018
*/

package AppliContactTest;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import AppliContact.FormulaireCreation;

class FormulaireCreationTest {
	
	FormulaireCreation fc = new FormulaireCreation(null, null, false, null); 

	@Test
	void testVerificationEntree() {
		String contenuNom = ""; 
		String contenuPrenom = ""; 
		int longueurNum = 8; 
		
		assertFalse("Test de vérification des entrées", fc.verificationEntree(contenuNom, contenuPrenom, longueurNum));
		
	}

}
