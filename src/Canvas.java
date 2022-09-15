import Math3D.Matrix4x4;
import Objects.Cube;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel implements Runnable, KeyListener {
    int width = 640;
    int height = 480;

    Thread runner;
    boolean active = true;
    int paintCounter = 0;

    BufferedImage imageBuffer;

    int frameCount = 0;
    int fps = 0;

    Font font = new Font("", Font.PLAIN, 30);


    BufferedImage imageTmp = null;

    boolean LEFT = false;
    boolean RIGHT = false;
    boolean UP = false;
    boolean DOWN = false;

    Graphics2D dbg = null;

    float triangleX = 0;
    float triangleY = 0;
    float triangleZ = 0;
    float rotationXAngle = 0;
    float rotationYAngle = 0;
    Matrix4x4 translateMatrix;
    Cube cube = new Cube();

    public Canvas() {
        setSize(width, height);
        setFocusable(true);

        try {
            imageTmp = ImageIO.read(getClass().getResource("assets/fundo.jpg"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        imageBuffer = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        dbg = (Graphics2D) imageBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        dbg.setColor(Color.white);
        dbg.fillRect(0, 0, width, height);
        dbg.setColor(Color.black);

        Matrix4x4 rotationX = new Matrix4x4();
        rotationX.setRotateX(rotationXAngle);

        Matrix4x4 rotationY = new Matrix4x4();
        rotationY.setRotateY(rotationYAngle);

        Matrix4x4 matrix = new Matrix4x4();
        matrix.setIdentityMatrix();

        Matrix4x4 scale = new Matrix4x4();
        scale.setScale(200, 200, 200);

        Matrix4x4 result = matrix.multiply(translateMatrix);
        result.multiply(rotationX);
        result.multiply(rotationY);
        result.multiply(scale);

        cube.draw(dbg, result);

        graphics.setFont(font);
        graphics.drawImage(imageBuffer, 0, 0, null);
        graphics.setColor(Color.black);
        graphics.drawString("FPS " + fps, 10, 25);
    }

    public void start() {
        runner = new Thread(this);
        runner.start();
    }

    public void simulateWorld(long diffTime) {
        float diffSeconds = diffTime / 1000.0f;
        float speed = 200;

        float translateX = 0;
        float translateY = 0;

        if (UP) {
            translateY = -speed * diffSeconds;
        }

        if (DOWN) {
            translateY = speed * diffSeconds;
        }

        if (LEFT) {
            translateX = -speed * diffSeconds;
        }

        if (RIGHT) {
            translateX = speed * diffSeconds;
        }

        triangleX += translateX;
        triangleY += translateY;

        translateMatrix = new Matrix4x4();
        translateMatrix.setTranslate(translateX, translateY, 0);
    }


    @Override
    public void run() {
        long time = System.currentTimeMillis();
        long seconds = time / 1000;
        long diffTime = 0;

        while (active) {
            simulateWorld(diffTime);
            paintImmediately(0, 0, width, height);
            paintCounter += 100;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long newTime = System.currentTimeMillis();
            long newSeconds = newTime / 1000;

            diffTime = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            frameCount++;

            if (newSeconds != seconds) {
                fps = frameCount;
                frameCount = 0;
                seconds = newSeconds;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // switch case
        if(key == KeyEvent.VK_W) {
            UP = true;
        }

        if(key == KeyEvent.VK_S) {
            DOWN = true;
        }

        if(key == KeyEvent.VK_A) {
            LEFT = true;
        }

        if(key == KeyEvent.VK_D) {
            RIGHT = true;
        }


        if(key == KeyEvent.VK_X) {
            rotationXAngle += 10;
        }

        if(key == KeyEvent.VK_Z) {
            rotationXAngle -= 10;
        }

        if(key == KeyEvent.VK_N) {
            rotationYAngle += 10;
        }

        if(key == KeyEvent.VK_M) {
            rotationYAngle -= 10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // switch case
        if(key == KeyEvent.VK_W) {
            UP = false;
        }

        if(key == KeyEvent.VK_S) {
            DOWN = false;
        }

        if(key == KeyEvent.VK_A) {
            LEFT = false;
        }

        if(key == KeyEvent.VK_D) {
            RIGHT = false;
        }
    }
}
