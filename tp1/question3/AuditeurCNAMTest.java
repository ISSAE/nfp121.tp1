package question3;

/**
 * Classe-test AuditeurCNAMTest.
 * 
 * @author (votre nom)
 * @version (un num�ro de version ou une date)
 * 
 *          Les classes-test sont document�es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont bas�es sur le document � 2002 Robert A. Ballance intitul�
 *          �JUnit: Unit Testing Framework�.
 * 
 *          Les objets Test (et TestSuite) sont associ�s aux classes � tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          m�me paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque m�thode Test �
 *          ex�cuter. Il peut y avoir plus d'une m�thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ d�couvrira
 *          automatiquement (par introspection) les m�thodes Test de votre
 *          classe Test et g�n�rera la TestSuite cons�quente. Chaque appel d'une
 *          m�thode Test sera pr�c�d� d'un appel de setUp(), qui r�alise les
 *          engagements, et suivi d'un appel � tearDown(), qui les d�truit.
 */
public class AuditeurCNAMTest extends junit.framework.TestCase {
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test AuditeurCNAMTest.
     */
    public AuditeurCNAMTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * M�thode appel�e avant chaque appel de m�thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        // Initialisez ici vos engagements
    }

    /**
     * Supprime les engagements
     * 
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Lib�rez ici les ressources engag�es par setUp()
    }

    /*
     * Il ne vous reste plus qu'� d�finir une ou plusieurs m�thodes de test. Ces
     * m�thodes doivent v�rifier les r�sultats attendus � l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient d�buter par
     * "test". Vous pouvez �baucher le corps grace au menu contextuel
     * "Enregistrer une m�thode de test".
     */

    /** Un test de la m�thode toString(). */
    public void test_toString() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Dupont",
                "paul", "03-1234");
        assertEquals("Dupont paul login : dupont_p", auditeur1.toString());
    }

    public void test_nom_court() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("paul",
                "pierre", "12345");
        assertEquals("paul", auditeur1.nom());
        assertEquals("pierre", auditeur1.prenom());
        assertEquals("paul_p", auditeur1.login());
    }

    public void test_nom_court_bis() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("thon",
                "germon", "12345");
        assertEquals("Mr thon germon", "thon", auditeur1.nom());
        assertEquals("Mr thon germon", "germon", auditeur1.prenom());
        assertEquals("Mr thon germon", "thon_g", auditeur1.login());
    }

    public void test_nom_avec_particule() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM(
                "le Thon", "alban", "12345");
        assertEquals("Mr le Thon albacore ", "le Thon", auditeur1.nom());
        assertEquals("Mr le Thon albacore ", "alban", auditeur1.prenom());
        assertEquals(" matricule ?", "12345", auditeur1.matricule());
        assertEquals(" login ? ", "le_tho_a", auditeur1.login());
    }

    public void test_nom_compose() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM(
                "Ton-Ton", "max", "12345");
        assertEquals("Mr Ton-Ton max ", "Ton-Ton", auditeur1.nom());
        assertEquals("Mr Ton-Ton max ", "max", auditeur1.prenom());
        assertEquals("Mr Ton-Ton max ", "ton_to_m", auditeur1.login());
    }

    public void test_nom_court_avec_particule() {

        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Te-Te",
                "max", "12345");
        assertEquals("Mr Te-Te max ", "Te-Te", auditeur1.nom());
        assertEquals("Mr Te-Te max ", "max", auditeur1.prenom());
        assertEquals("nom court avec particules ? ", "te_te_m",
            auditeur1.login());
    }

    public void test_nom_avec_accent() {
        question3.AuditeurCNAM auditeur1 = new question3.AuditeurCNAM("Chlo�",
                "chlo�", "12345");
        assertEquals("Mme Chlo� chlo� ", "Chlo�", auditeur1.nom());
        assertEquals("Mme Chlo� chlo� ", "chlo�", auditeur1.prenom());
        assertEquals(" nom avec accent (� devient e) ? ", "chloe_c",
            auditeur1.login()); //renvoi faux pour tester le cas de defis
    }
    
    /**
     * Teste le comportement lorsque le nom est une cha�ne vide.
     */
    public void test_nom_vide() {
        AuditeurCNAM auditeur = new AuditeurCNAM("", "John", "12345");
        assertEquals("", auditeur.nom());
        assertEquals("John", auditeur.prenom());
        assertEquals("_j", auditeur.login());
    }
    
    /**
     * Teste le comportement lorsque le nom est tr�s long.
     * V�rifie si la classe g�re correctement un nom d�passant une certaine longueur.
     */
    public void test_nom_tres_long() {
        String nomTresLong = "NomTresLongQuiDepasseLaLongueurMaximaleAutorisee";
        AuditeurCNAM auditeur = new AuditeurCNAM(nomTresLong, "Alice", "12345");
        assertEquals("nomtre_a", auditeur.login());
    }
    
        /**
     * Teste le comportement avec un nom compos� et une separation par vide.
     * V�rifie si la classe g�re correctement les noms compos�s avec separation par vide.
     */
    public void test_nom_compose_avec_separation_vide() {
        AuditeurCNAM auditeur = new AuditeurCNAM("de la Roche", "Jean", "12345");
        assertEquals("de la Roche", auditeur.nom());
        assertEquals("Jean", auditeur.prenom());
        assertEquals("de_la__j", auditeur.login());
    }

}
