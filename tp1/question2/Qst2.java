package question2;


/**
 * Description of class Qst2.
 *
 * @author Ali.z
 * @version 28/11/2023
 */
public class Qst2
{
    public static void main(String [] args){
        var pic = new Picture();
        pic.draw();
        pic.getSun().changeColor("blue");
        pic.setTerreIsFixe(true);
        pic.coucher(400);
    }
}
