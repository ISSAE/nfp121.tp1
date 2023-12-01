package question2;

import question1.Circle;
import question1.Square;
import question1.Triangle;

/**
 * This class represents a simple picture. You can draw the picture using the
 * draw method. But wait, there's more: being an electronic picture, it can be
 * changed. You can set it to black-and-white display and back to colors (only
 * after it's been drawn, of course).
 * 
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.1 (24 May 2001)
 */
public class Picture {
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle sun;
    private Circle soleilJaune;
    private Boolean terreIsFixe;

    /**
     * Constructor for objects of class Picture
     */
    public Picture() {
        // nothing to do... instance variables are automatically set to null
    }

    /**
     * Draw this picture.
     */
    public void draw() {
        this.terreIsFixe = false;
        
        wall = new Square();
        wall.moveVertical(80);
        wall.changeSize(100);
        wall.makeVisible();

        window = new Square();
        window.changeColor("black");
        window.moveHorizontal(20);
        window.moveVertical(100);
        window.makeVisible();

        roof = new Triangle();
        roof.changeSize(50, 140);
        roof.moveHorizontal(60);
        roof.moveVertical(70);
        roof.makeVisible();

        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveHorizontal(180);
        sun.moveVertical(-10);
        sun.changeSize(60);
        sun.makeVisible();
        
        soleilJaune = new Circle();
        soleilJaune.changeColor("yellow");
        soleilJaune.moveHorizontal(180);
        soleilJaune.moveVertical(-20);
        soleilJaune.changeSize(60);
        soleilJaune.makeVisible();
        
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("black");
            window.changeColor("white");
            roof.changeColor("black");
            sun.changeColor("black");
        }
    }

    /**
     * Change this picture to use color display
     */
    public void setColor() {
        if (wall != null) // only if it's painted already...
        {
            wall.changeColor("red");
            window.changeColor("black");
            roof.changeColor("green");
            sun.changeColor("yellow");
        }
    }
    
    /**
     * Anime le déplacement vertical du soleil pour simuler le coucher, si les conditions sont remplies.
     *
     * @param distance La distance pour déplacer le soleil.
     */
    public void coucher(int distance) {
        if (sun != null && sun.getColor().equalsIgnoreCase("blue") && terreIsFixe) {
    
            Thread animationThread = new Thread(() -> {
                int steps = distance / 10;//nb d'iteration par deplacement
    
                for (int i = 0; i < steps; i++) {
                    sun.slowMoveVertical(10);
    
                    try {
                        Thread.sleep(100); 
                    } catch (InterruptedException e) {
                        // Gérer l'exception d'interruption si nécessaire
                        e.printStackTrace();
                    }
                }
            });
    
            animationThread.start();
        }
    }
    
    /**
     * Get the wall square instance.
     * 
     * @return The Square representing the wall.
     */
    public Square getWall() {
        return wall;
    }

    /**
     * Get the window square instance.
     * 
     * @return The Square representing the window.
     */
    public Square getWindow() {
        return window;
    }

    /**
     * Get the roof triangle instance.
     * 
     * @return The Triangle representing the roof.
     */
    public Triangle getRoof() {
        return roof;
    }

    /**
     * Get the sun circle instance.
     * 
     * @return The Circle representing the sun.
     */
    public Circle getSun() {
        return sun;
    }
    
        /**
     * Get the soleilJaune circle instance.
     * 
     * @return The Circle representing the sun.
     */
    public Circle getSoleilJaune() {
        return soleilJaune;
    }
    
        /**
     * Get the status of the "terre".
     * 
     * @return The status of the "terre".
     */
    public Boolean isTerreIsFixe() {
        return terreIsFixe;
    }

    /**
     * Set the status of the "terre".
     * 
     * @param terreIsFixe The status of the "terre" to be set.
     */
    public void setTerreIsFixe(Boolean terreIsFixe) {
        this.terreIsFixe = terreIsFixe;
    }

}
