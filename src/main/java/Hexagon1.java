import processing.core.*;

public class Hexagon1 extends PAppletSvgExport {
    // --------------------------------------------------
    public static void main(String args[]) {
        PApplet.main("Hexagon1");
    }

    @Override
    public void settings() {
        size(800, 800, P2D);
    }

    @Override
    public void setup()
    {
    }

    @Override
    public void draw()
    {
        super.beforeDraw();
        stroke(0);

        // Start drawing here
        int SIZE = 50;
        int COL_COUNT = 3;
        int ROW_COUNT = 3;
        float heightPad = sin(PI/3) * SIZE;
        for (int xGrid = 1; xGrid <= COL_COUNT; xGrid++) {
            for(int yGrid = 1; yGrid <= ROW_COUNT; yGrid++) {
                pushMatrix();
                translate(xGrid * (SIZE * 2), yGrid * (heightPad * 2));
                hexagon(0, 0, SIZE);
                popMatrix();
            }
        }

        // End drawing here

        // If we were exporting, then we stop recording and set the flag to false
        super.afterDraw();
    }

    @Override
    public void keyPressed()
    {
        super.keyPressed();
    }

    public void hexagon(int x, int y, int size) {
        beginShape();
        for (float theta = 0; theta < TWO_PI; theta+=PI/3 ) {
            float xVertex = cos(theta);
            float yVertex = sin(theta);
            vertex(xVertex * size, yVertex * size);
        }
        endShape(CLOSE);
    }
}
