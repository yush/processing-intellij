import processing.core.*;
import java.util.*;
import processing.dxf.*;
import java.util.Calendar;

public class ExampleApplet extends PApplet {
    // --------------------------------------------------
    int dim = 740;
    int res = 3;
    float radius=0;
    PGraphics pg;
    PGraphics composition;

    public static void main(String args[]) {
        PApplet.main("ExampleApplet");
    }

/*
Processing + Axidraw — Generative hut tutorial by Julien "v3ga" Gachadoat
January 2020
www.generativehut.com
—
www.instagram.com/julienv3ga
https://twitter.com/v3ga
https://github.com/v3ga
*/

    boolean bExportSVG = false;

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
        background(255);
        if (bExportSVG)
        {
            //beginRaw(DXF, "data/exports/dxf/export_"+timestamp()+".dxf");
            beginRecord(SVG, "data/exports/svg/export_"+timestamp()+".svg");
        }

        // Drawing options : no fill and stroke set to black
        noFill();
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
        if (bExportSVG)
        {
            endRecord();
            //endRaw();
            bExportSVG = false;
        }
    }

    @Override
    public void keyPressed()
    {
        if (key == 'e')
        {
            bExportSVG = true;
        }
    }

    String timestamp()
    {
        Calendar now = Calendar.getInstance();
        return String.format("%1$ty%1$tm%1$td_%1$tH%1$tM%1$tS", now);
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
