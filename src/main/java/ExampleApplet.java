import processing.core.*;
import processing.svg.*;

public class ExampleApplet extends PApplet {
    boolean record;
    public static void main(String args[]) {
        PApplet.main("ExampleApplet");
    }

    @Override
    public void settings() {
        size(200, 200, P2D);
    }

    @Override
    public void setup() {
        clear();
    }

    @Override
    public void draw() {
        if (record) {
            beginRaw(SVG, "output.svg");
        }

        // Do all your drawing here
        hexagon(50, 50, 50);

        if (record) {
            endRaw();
            record = false;
        }
    }

    void hexagon(float x, float y, float radius) {
        polygon(x, y, radius, 6);
    }

    void polygon(float x, float y, float radius, int npoints) {
        float angle = TWO_PI / npoints;
        beginShape();
        for (float a = 0; a < TWO_PI; a += angle) {
            float sx = x + cos(a) * radius;
            float sy = y + sin(a) * radius;
            vertex(sx, sy);
        }
        endShape(CLOSE);
    }

    // Hit 'r' to record a single frame
    @Override
    public void keyPressed() {
        if (key == 'r') {
            record = true;
        }
    }
}
