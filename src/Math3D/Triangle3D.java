package Math3D;
import java.awt.*;

public class Triangle3D {
    Vector3D point1;
    Vector3D point2;
    Vector3D point3;

    public Triangle3D(Vector3D point1, Vector3D point2, Vector3D point3) {
        super();
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public void draw(Graphics2D dbg, Matrix4x4 matrix) {
        Vector3D point1L = matrix.multipliesVector(point1);
        Vector3D point2L = matrix.multipliesVector(point2);
        Vector3D point3L = matrix.multipliesVector(point3);

        dbg.drawLine((int)point1L.x, (int)point1L.y, (int)point2L.x, (int)point2L.y);
        dbg.drawLine((int)point2L.x, (int)point2L.y, (int)point3L.x, (int)point3L.y);
        dbg.drawLine((int)point3L.x, (int)point3L.y, (int)point1L.x, (int)point1L.y);
    }
}
