package Math2D;

public class Matrix3x3 {
    public float identityMatrix[][] = new float[3][3];

    public void setIdentityMatrix() {
        identityMatrix[0][0] = 1;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = 1;
        identityMatrix[1][2] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
    }

    public void setTranslate(float a, float b) {
        identityMatrix[0][0] = 1;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = a;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = 1;
        identityMatrix[1][2] = b;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
    }

    public void setScale(float a, float b) {
        identityMatrix[0][0] = a;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = b;
        identityMatrix[1][2] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
    }

    public void setRotate(float angle) {
        double radiansAngle = angle * 0.0174532;

        identityMatrix[0][0] = (float) Math.cos(radiansAngle);
        identityMatrix[0][1] = (float) Math.sin(radiansAngle);
        identityMatrix[0][2] = 0;

        identityMatrix[1][0] = (float) -Math.sin(radiansAngle);

        identityMatrix[1][1] = (float) Math.cos(radiansAngle);
        identityMatrix[1][2] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
    }

    public Vector2D multipliesVector(Vector2D vector) {
        Vector2D result = new Vector2D(1, 1, 1);

        result.x = vector.x * identityMatrix[0][0] + vector.y * identityMatrix[0][1] + vector.w * identityMatrix[0][2];
        result.y = vector.x * identityMatrix[1][0] + vector.y * identityMatrix[1][1] + vector.w * identityMatrix[1][2];
        result.w = vector.x * identityMatrix[2][0] + vector.y * identityMatrix[2][1] + vector.w * identityMatrix[2][2];

        return result;
    }

    public Matrix3x3 multiply(Matrix3x3 matrix) {
        Matrix3x3 result = new Matrix3x3();

        result.identityMatrix[0][0] = matrix.identityMatrix[0][0] * identityMatrix[0][0] + matrix.identityMatrix[1][0] * identityMatrix[0][1] + matrix.identityMatrix[2][0] * identityMatrix[0][2];
        result.identityMatrix[0][1] = matrix.identityMatrix[0][1] * identityMatrix[0][0] + matrix.identityMatrix[1][1] * identityMatrix[0][1] + matrix.identityMatrix[2][1] * identityMatrix[0][2];
        result.identityMatrix[0][2] = matrix.identityMatrix[0][2] * identityMatrix[0][0] + matrix.identityMatrix[1][2] * identityMatrix[0][1] + matrix.identityMatrix[2][2] * identityMatrix[0][2];

        result.identityMatrix[1][0] = matrix.identityMatrix[0][0] * identityMatrix[1][0] + matrix.identityMatrix[1][0] * identityMatrix[1][1] + matrix.identityMatrix[2][0] * identityMatrix[1][2];
        result.identityMatrix[1][1] = matrix.identityMatrix[0][1] * identityMatrix[1][0] + matrix.identityMatrix[1][1] * identityMatrix[1][1] + matrix.identityMatrix[2][1] * identityMatrix[1][2];
        result.identityMatrix[1][2] = matrix.identityMatrix[0][2] * identityMatrix[1][0] + matrix.identityMatrix[1][2] * identityMatrix[1][1] + matrix.identityMatrix[2][2] * identityMatrix[1][2];

        result.identityMatrix[2][0] = matrix.identityMatrix[0][0] * identityMatrix[2][0] + matrix.identityMatrix[1][0] * identityMatrix[2][1] + matrix.identityMatrix[2][0] * identityMatrix[2][2];
        result.identityMatrix[2][1] = matrix.identityMatrix[0][1] * identityMatrix[2][0] + matrix.identityMatrix[1][1] * identityMatrix[2][1] + matrix.identityMatrix[2][1] * identityMatrix[2][2];
        result.identityMatrix[2][2] = matrix.identityMatrix[0][2] * identityMatrix[2][0] + matrix.identityMatrix[1][2] * identityMatrix[2][1] + matrix.identityMatrix[2][2] * identityMatrix[2][2];

        return result;
    }

}
