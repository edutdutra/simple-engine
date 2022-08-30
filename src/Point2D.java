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

    public void scale(float a, float b) {
        float [][]pointsArray = new float[1][2];
        float [][]scaleArray = new float[2][2];
        float [][]resultArray = new float[1][2];

        // points array data
        pointsArray[0][0] = x;
        pointsArray[0][1] = y;

        // scale array data
        scaleArray[0][0] = a;
        scaleArray[0][1] = 0;
        scaleArray[1][0] = 0;
        scaleArray[1][1] = b;

        for(int i=0;i<pointsArray.length;i++){
            for(int j=0;j<pointsArray[i].length;j++){
                resultArray[i][j] = pointsArray[i][j] * scaleArray[i][j];
            }
        }

        for(int i=0;i<resultArray.length;i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                System.out.println("i + j: " + i + " + " + j + " = " + resultArray[i][j]);
            }
        }
    }

    public void rotation(float angle) {
        double radiansAngle = angle*0.0174532;

        float x1 = (float)(x*Math.cos(radiansAngle)-y*Math.sin(radiansAngle));
        float y1 = (float)(x*Math.sin(radiansAngle)+y*Math.cos(radiansAngle));

        x = x1;
        y = y1;
    }
}
