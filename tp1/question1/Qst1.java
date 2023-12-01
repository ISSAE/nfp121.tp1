package question1;

import java.awt.geom.Ellipse2D;
import java.awt.Polygon;
import java.awt.Rectangle;


/**
 * Write a description of class Qst1 here.
 *
 * @author Ali Zaarour
 * @version 26/11/2023
 */
public class Qst1{
    
    public static void main (String [] args) {
        var canvasPanel = Canvas.getCanvas();
        canvasPanel.setVisible(true);
        addCircle(canvasPanel);
        addTriangle(canvasPanel);
        addSquare(canvasPanel);
    }
    
    
    private static void addCircle (Canvas canvas){
        // Create an instance of Circle
        Circle myCircle = new Circle();
        myCircle.makeVisible();

        // Move the circle around
        myCircle.moveRight();
        myCircle.moveDown();
        myCircle.moveLeft();
        myCircle.moveUp();

        // Change the size and color of the circle
        myCircle.changeSize(100);
        myCircle.changeColor("yellow");

        // Slowly move the circle horizontally and vertically
        //myCircle.slowMoveHorizontal(100);
        //myCircle.slowMoveVertical(40);
        
        // Erase the circle
        //myCircle.makeInvisible();
        System.out.println(myCircle);
    }
    
    private static void addTriangle(Canvas canvas) {
        // Create an instance of Triangle
        Triangle myTriangle = new Triangle();
        myTriangle.makeVisible();
    
        // Move the triangle around
        myTriangle.moveRight();
        myTriangle.moveDown();
        myTriangle.moveLeft();
        myTriangle.moveUp();
    
        // Change the size and color of the triangle
        myTriangle.changeSize(100, 80); // Change height and width
        myTriangle.changeColor("green");
    
        // Erase the triangle
        // myTriangle.makeInvisible();
        System.out.println(myTriangle);
    }
    
    private static void addSquare(Canvas canvas) {
        // Create an instance of Square
        Square mySquare = new Square();
        mySquare.makeVisible();
    
        // Move the square around
        mySquare.moveRight();
        mySquare.moveDown();
        mySquare.moveLeft();
        mySquare.moveUp();
    
        // Change the size and color of the square
        mySquare.changeSize(80);
        mySquare.changeColor("blue");
    
        // Erase the square
        // mySquare.makeInvisible();
        System.out.println(mySquare);
    }
    
}
