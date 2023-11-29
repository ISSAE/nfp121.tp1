package question3;

import java.util.List;

/**
 * Description of class Qst3.
 *
 * @author Ali.z
 * @version 29/11/2023
 */
public class Qst3
{
    public static void main(String [] args){
        var auditeurs = List.of(
            new AuditeurCNAM("Ali","Zaarour","00"),
            new AuditeurCNAM("Emile","Khairallah","01"),
            new AuditeurCNAM("Pierre","Rmayle ","02")
        );

        for (AuditeurCNAM auditeur : auditeurs) {
            System.out.println(auditeur);
        }
        
    }
}
