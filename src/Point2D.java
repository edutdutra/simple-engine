public class Point2D {
    float x;
    float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void translate(float tx, float ty) {
        x = x+tx;
        y = y+ty;
    }

    public void scale(float sx, float sy) {
        x = x*sx;
        y = y*sy;
    }

    public void rotation(float angle) {
        double radiansAngle = angle*0.0174532;

        float x1 = (float)(x*Math.cos(radiansAngle)-y*Math.sin(radiansAngle));
        float y1 = (float)(x*Math.sin(radiansAngle)+y*Math.cos(radiansAngle));

        x = x1;
        y = y1;
    }
}
