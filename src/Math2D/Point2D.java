package Math2D;

public class Point2D {
    public float x;
    public float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void translate(float translateX, float translateY) {
        x = x + translateX;
        y = y + translateY;
    }

    public void scale(float scaleX, float scaleY) {
        x = x * scaleX;
        y = y * scaleY;
    }

    public void rotation(float angle) {
        double radiansAngle = angle * 0.0174532;

        float x1 = (float) (x * Math.cos(radiansAngle) - y * Math.sin(radiansAngle));
        float y1 = (float) (x * Math.sin(radiansAngle) + y * Math.cos(radiansAngle));

        x = x1;
        y = y1;
    }
}
