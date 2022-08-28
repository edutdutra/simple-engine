import java.awt.Graphics2D;

public class Line2D {
    Point2D a;
    Point2D b;

    public Line2D(Point2D a, Point2D b) {
        this.a = a;
        this.b = b;
    }

    public Line2D(float x1, float y1, float x2, float y2) {
        this.a = new Point2D(x1, y1);
        this.b = new Point2D(x2, y2);
    }

    public void draw(Graphics2D dbg) {
        dbg.drawLine((int)a.x,(int)a.y,(int)b.x,(int)b.y);
    }

    public void translate(float tx, float ty) {
        a.translate(tx, ty);
        b.translate(tx, ty);
    }

    public void scale(float sx, float sy) {
        a.scale(sx, sy);
        b.scale(sx, sy);
    }

    public void rotation(float ang) {
        a.rotation(ang);
        b.rotation(ang);
    }

}
