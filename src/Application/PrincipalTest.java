package Application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrincipalTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	 @Test
	    void testMatriculeNotNull() {
	        String matricule = "12345";
	        assertNotNull(matricule, "Le matricule ne doit pas être nul");
	    }
	 @Test
	    void testMoyenneSuccess() {
	        Double moyenne = 15.0;
	        assertTrue(moyenne >= 10, "L'étudiant doit avoir réussi");
	    }
	 @Test
	    void testMoyenneFailure() {
	        Double moyenne = 9.5;
	        assertFalse(moyenne >= 10, "L'étudiant doit avoir échoué");
	    }

	    @Test
	    void testNomAndPrenomConcatenation() {
	        String nom = "Jane";
	        String prenom = "Smith";
	        assertEquals("Jane Smith", nom + " " + prenom);
	    }
	    
}
