package pomPomTree;

import javafx.scene.paint.Color;

public class PomPom implements Comparable<PomPom>{
    private int red;
    private int green;
    private int blue;
    private String colorName;

    public PomPom(int red, int green, int blue, String colorName) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.colorName = colorName;
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public String getColorName() {
        return colorName;
    }

    public int compareTo(PomPom otherPom) {
    	return Integer.compare(this.red, otherPom.getRed());
    }
    public Color getFXColor() {
        // Convert RGB values to the range 0.0-1.0
        double normalizedRed = red / 255.0;
        double normalizedGreen = green / 255.0;
        double normalizedBlue = blue / 255.0;

        // Create a Color object using RGB values
        return Color.color(normalizedRed, normalizedGreen, normalizedBlue);
    }
}