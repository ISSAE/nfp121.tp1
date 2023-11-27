package question1;

import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 1.0 (15 July 2000)
 */

public class Triangle {
    private int height;
    private int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangle() {
        height = 30;
        width = 40;
        xPosition = 50;
        yPosition = 15;
        color = "green";
        isVisible = false;
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    /**
     * Move the triangle a few pixels to the right.
     */
    public void moveRight() {
        moveHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moveLeft() {
        moveHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moveUp() {
        moveVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moveDown() {
        moveVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moveHorizontal(int distance) {
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moveVertical(int distance) {
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
     */
    public void slowMoveHorizontal(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
     */
    public void slowMoveVertical(int distance) {
        int delta;

        if (distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for (int i = 0; i < distance; i++) {
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    /*
     * Draw the triangle with current specifications on screen.
     */
    private void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { xPosition, xPosition + (width / 2),
                    xPosition - (width / 2) };
            int[] ypoints = { yPosition, yPosition + height, yPosition + height };
            canvas.draw(this, color, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * Get the height of the triangle.
     * 
     * @return The height of the triangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get the width of the triangle.
     * 
     * @return The width of the triangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the x-coordinate of the triangle's position.
     * 
     * @return The x-coordinate of the triangle's position.
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * Get the y-coordinate of the triangle's position.
     * 
     * @return The y-coordinate of the triangle's position.
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Get the color of the triangle.
     * 
     * @return The color of the triangle.
     */
    public String getColor() {
        return color;
    }

    /**
     * Check if the triangle is visible.
     * 
     * @return True if the triangle is visible, otherwise false.
     */
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * Returns a string representation of the triangle.
     * @return The triangle information as a formatted string.
     */
    @Override
    public String toString() {
        return "Triangle Info:\n" +
                "Position X: " + getXPosition() + "\n" +
                "Position Y: " + getYPosition() + "\n" +
                "Couleur: " + getColor() + "\n" +
                "Hauteur: " + getHeight() + "\n" +
                "Largeur: " + getWidth();
    }
}
