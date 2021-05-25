import processing.core.PVector;

import java.util.*;

public class Mesh {
    public List<PVector> vertices;

    public Mesh() {
        this.vertices = new ArrayList<PVector>();
    }

    public static Mesh InitBox() {
        Mesh box = new Mesh();

        return box;
    }
}
