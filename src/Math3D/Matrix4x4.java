package Math3D;

public class Matrix4x4 {
    public double identityMatrix[][] = new double[4][4];

    public void setIdentityMatrix() {
        identityMatrix[0][0] = 1;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;
        identityMatrix[0][3] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = 1;
        identityMatrix[1][2] = 0;
        identityMatrix[1][3] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
        identityMatrix[2][3] = 0;

        identityMatrix[3][0] = 0;
        identityMatrix[3][1] = 0;
        identityMatrix[3][2] = 0;
        identityMatrix[3][3] = 1;
    }

    public void setTranslate(double a, double b, double c) {
        identityMatrix[0][0] = 1;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;
        identityMatrix[0][3] = a;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = 1;
        identityMatrix[1][2] = 0;
        identityMatrix[1][3] = b;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = 1;
        identityMatrix[2][3] = c;

        identityMatrix[3][0] = 0;
        identityMatrix[3][1] = 0;
        identityMatrix[3][2] = 0;
        identityMatrix[3][3] = 1;
    }

    public void setScale(double a, double b, double c) {
        identityMatrix[0][0] = a;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;
        identityMatrix[0][3] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = b;
        identityMatrix[1][2] = 0;
        identityMatrix[1][3] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = c;
        identityMatrix[2][3] = 0;

        identityMatrix[3][0] = 0;
        identityMatrix[3][1] = 0;
        identityMatrix[3][2] = 0;
        identityMatrix[3][3] = 1;
    }

    public void setRotateX(double angle) {
        double radiansAngle = Math.toRadians(angle);
        double sin = Math.sin(radiansAngle);
        double cos = Math.cos(radiansAngle);

        identityMatrix[0][0] = 1;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = 0;
        identityMatrix[0][3] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = cos;
        identityMatrix[1][2] = -sin;
        identityMatrix[1][3] = 0;

        identityMatrix[2][0] = 0;
        identityMatrix[2][1] = sin;
        identityMatrix[2][2] = cos;
        identityMatrix[2][3] = 0;

        identityMatrix[3][0] = 0;
        identityMatrix[3][1] = 0;
        identityMatrix[3][2] = 0;
        identityMatrix[3][3] = 1;
    }

    public void setRotateZW(double angle) {
//        double radiansAngle = Math.toRadians(angle);
//        double sin = Math.sin(radiansAngle);
//        double cos = Math.cos(radiansAngle);
//
//        identityMatrix[0][0] = 1;
//        identityMatrix[0][1] = 0;
//        identityMatrix[0][2] = 0;
//        identityMatrix[0][3] = 0;
//
//        identityMatrix[1][0] = 0;
//        identityMatrix[1][1] = cos;
//        identityMatrix[1][2] = -sin;
//        identityMatrix[1][3] = 0;
//
//        identityMatrix[2][0] = 0;
//        identityMatrix[2][1] = sin;
//        identityMatrix[2][2] = cos;
//        identityMatrix[2][3] = 0;
//
//        identityMatrix[3][0] = 0;
//        identityMatrix[3][1] = 0;
//        identityMatrix[3][2] = 0;
//        identityMatrix[3][3] = 1;
    }

    public void setRotateY(double angle) {
        double radiansAngle = Math.toRadians(angle);
        double sin = Math.sin(radiansAngle);
        double cos = Math.cos(radiansAngle);

        identityMatrix[0][0] = cos;
        identityMatrix[0][1] = 0;
        identityMatrix[0][2] = -sin;
        identityMatrix[0][3] = 0;

        identityMatrix[1][0] = 0;
        identityMatrix[1][1] = 1;
        identityMatrix[1][2] = 0;
        identityMatrix[1][3] = 0;

        identityMatrix[2][0] = sin;
        identityMatrix[2][1] = 0;
        identityMatrix[2][2] = cos;
        identityMatrix[2][3] = 0;

        identityMatrix[3][0] = 0;
        identityMatrix[3][1] = 0;
        identityMatrix[3][2] = 0;
        identityMatrix[3][3] = 1;
    }

    public Vector3D multipliesVector(Vector3D vector) {
        Vector3D result = new Vector3D(1,1,1,1);

        result.x = vector.x*identityMatrix[0][0] + vector.y*identityMatrix[0][1] + vector.z*identityMatrix[0][2] + vector.w*identityMatrix[0][3];
        result.y = vector.x*identityMatrix[1][0] + vector.y*identityMatrix[1][1] + vector.z*identityMatrix[1][2] + vector.w*identityMatrix[1][3];
        result.z = vector.x*identityMatrix[2][0] + vector.y*identityMatrix[2][1] + vector.z*identityMatrix[2][2] + vector.w*identityMatrix[2][3];
        result.w = vector.x*identityMatrix[3][0] + vector.y*identityMatrix[3][1] + vector.z*identityMatrix[3][2] + vector.w*identityMatrix[3][3];

        return result;
    }

    public Matrix4x4 multiply(Matrix4x4 m) {
        Matrix4x4 result = new Matrix4x4();

        for (int l = 0; l < 4; l++) {
            for (int i = 0; i < 4; i++) {
                for (int h = 0; h < 4; h++) {
                    result.identityMatrix[l][i] += identityMatrix[l][h] *  m.identityMatrix[h][i];
                }
            }
        }

        return result;
    }

}
