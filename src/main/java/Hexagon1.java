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
    public void draw()
    {
        super.beforeDraw();
        stroke(0);

        // Start drawing here
        hexagonGrid1();
        super.afterDraw();
    }

    private void hexagonGrid1() {
        int SIZE = 50;
        int COL_COUNT = 3;
        int ROW_COUNT = 6;
        float heightPad = sin(PI/3) * SIZE;
        for (int xGrid = 1; xGrid <= COL_COUNT; xGrid++) {
            for(int yGrid = 1; yGrid <= ROW_COUNT; yGrid++) {
                pushMatrix();
                if (yGrid % 2 == 1) {
                    translate(xGrid * (SIZE *3), yGrid * (heightPad));
                } else {
                    translate(xGrid * (SIZE *3) + (SIZE+SIZE/2) , yGrid * (heightPad));
                }
                hexagon(0, 0, SIZE);
                popMatrix();
            }
        }
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
