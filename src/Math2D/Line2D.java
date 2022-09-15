package Math2D;
import java.awt.Graphics2D;

public class Line2D {
    public Vector2D a;
    public Vector2D b;

    public Line2D(Vector2D a, Vector2D b) {
        this.a = a;
        this.b = b;
    }

    public Line2D(float x1, float y1, float x2, float y2) {
        this.a = new Vector2D(x1, y1, 1);
        this.b = new Vector2D(x2, y2, 1);
    }

    public void applyMatrix(Matrix3x3 matrix) {
        a.applyMatrix(matrix);
        b.applyMatrix(matrix);
    }

    public void draw(Graphics2D dbg) {
        dbg.drawLine((int)a.x,(int)a.y,(int)b.x,(int)b.y);
    }

//    public void translate(float tx, float ty) {
//        a.translate(tx, ty);
//        b.translate(tx, ty);
//    }
//
//    public void scale(float sx, float sy) {
//        a.scale(sx, sy);
//        b.scale(sx, sy);
//    }
//
//    public void rotation(float ang) {
//        a.rotation(ang);
//        b.rotation(ang);
//    }

}
