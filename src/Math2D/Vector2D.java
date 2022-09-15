package Math2D;

public class Vector2D {

    public float x;
    public float y;
    public float w;

    public Vector2D(float x, float y, float w) {
        super();
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public void applyMatrix(Matrix3x3 matrix) {
        Vector2D vector = matrix.multipliesVector(this);

        x = vector.x;
        y = vector.y;
    }
}
