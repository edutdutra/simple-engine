package Objects;

import java.awt.*;
import java.util.ArrayList;

import Math3D.Matrix4x4;
import Math3D.Triangle3D;
import Math3D.Vector3D;

public class Cube {
    ArrayList<Triangle3D> triangles = new ArrayList<Triangle3D>();

    public Cube() {
        Vector3D point1 = new Vector3D(0, 0, 0, 1);
        Vector3D point2 = new Vector3D(1, 0, 0, 1);
        Vector3D point3 = new Vector3D(1, 1, 0, 1);
        Vector3D point4 = new Vector3D(0, 1, 0, 1);

        Vector3D point5 = new Vector3D(0, 0, 1, 1);
        Vector3D point6 = new Vector3D(1, 0, 1, 1);
        Vector3D point7 = new Vector3D(1, 1, 1, 1);
        Vector3D point8 = new Vector3D(0, 1, 1, 1);

        Triangle3D triangle1 = new Triangle3D(point1, point2, point3);
        Triangle3D triangle2 = new Triangle3D(point3, point4, point1);

        Triangle3D triangle3 = new Triangle3D(point5, point6, point7);
        Triangle3D triangle4 = new Triangle3D(point7, point8, point5);

        Triangle3D triangle5 = new Triangle3D(point1, point2, point6);
        Triangle3D triangle6 = new Triangle3D(point6, point5, point1);

        Triangle3D triangle7 = new Triangle3D(point3, point4, point8);
        Triangle3D triangle8 = new Triangle3D(point8, point7, point3);

        Triangle3D triangle9 = new Triangle3D(point2, point3, point7);
        Triangle3D triangle10 = new Triangle3D(point7, point6, point2);

        Triangle3D triangle11 = new Triangle3D(point4, point1, point5);
        Triangle3D triangle12 = new Triangle3D(point5, point8, point4);

        triangles.add(triangle1);
        triangles.add(triangle2);
        triangles.add(triangle3);
        triangles.add(triangle4);
        triangles.add(triangle5);
        triangles.add(triangle6);
        triangles.add(triangle7);
        triangles.add(triangle8);
        triangles.add(triangle9);
        triangles.add(triangle10);
        triangles.add(triangle11);
        triangles.add(triangle12);
    }

    public void draw(Graphics2D dbg, Matrix4x4 matrix) {
        for(int i = 0; i < triangles.size();i++) {
            triangles.get(i).draw(dbg, matrix);
        }
    }
}
