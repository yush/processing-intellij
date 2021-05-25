import processing.core.PApplet;

public class ThreeToSVG extends PAppletSvgExport {
    public static void main(String args[]) {
        PApplet.main("ThreeToSVG");
    }
    public Mesh box = Mesh.InitBox();

    @Override
    public void settings() {
        size(800, 800, P2D);
    }

    @Override
    public void setup() {

    }

    @Override
    public void draw()
    {
        super.beforeDraw();
        stroke(0);

        box.draw();

        // Start drawing here
        super.afterDraw();
    }

}
