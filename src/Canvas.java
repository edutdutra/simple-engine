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

public class Canvas extends JPanel implements Runnable{
    Thread runner;
    boolean active = true;
    int paintCounter = 0;

    BufferedImage imageBuffer;
    byte bufferDeVideo[];

    int frameCount = 0;
    int fps = 0;

    Font f = new Font("", Font.PLAIN, 30);

    int clickX = 0;
    int clickY = 0;
    int mouseX = 0;
    int mouseY = 0;


    int width = 640;
    int height = 480;

    BufferedImage imageTmp = null;

    boolean LEFT = false;
    boolean RIGHT = false;
    boolean UP = false;
    boolean DOWN = false;

    Graphics2D dbg = null;

    Line2D triangulo[] = new Line2D[3];

    public Canvas() {
        setSize(width,height);
        setFocusable(true);

        try {
            imageTmp = ImageIO.read(getClass().getResource("assets/fundo.jpg"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        imageBuffer = new BufferedImage(640,480, BufferedImage.TYPE_4BYTE_ABGR);

        dbg = (Graphics2D)imageBuffer.getGraphics();

        //bufferDeVideo = ((DataBufferByte)imageBuffer.getRaster().getDataBuffer()).getData();

        triangulo[0] = new Line2D(100, 100, 200, 200);
        triangulo[1] = new Line2D(200, 200, 0, 200);
        triangulo[2] = new Line2D(0, 200, 100, 100);

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
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

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                //System.out.println("CLICO "+key);
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

                if(key == KeyEvent.VK_Q) {

                    float tx = triangulo[0].a.x;
                    float ty = triangulo[0].a.y;

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(-tx, -ty);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].scale(1.2f, 1.2f);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(tx, ty);
                    }

                }
                if(key == KeyEvent.VK_E) {
                    float tx = triangulo[0].a.x;
                    float ty = triangulo[0].a.y;

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(-tx, -ty);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].scale(0.8f, 0.8f);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(tx, ty);
                    }
                }

                if(key == KeyEvent.VK_X) {
                    float tx = triangulo[0].a.x;
                    float ty = triangulo[0].a.y;

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(-tx, -ty);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].rotation(15);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(tx, ty);
                    }
                }
                if(key == KeyEvent.VK_Z) {
                    float tx = triangulo[0].a.x;
                    float ty = triangulo[0].a.y;

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(-tx, -ty);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].rotation(-15);
                    }

                    for(int i = 0; i < triangulo.length;i++) {
                        triangulo[i].translate(tx, ty);
                    }
                }
            }
        });

    }
    @Override
    public void paint(Graphics graphics) {
        dbg.setColor(Color.white);
        dbg.fillRect(0, 0, 640, 480);


        dbg.setColor(Color.black);
        for(int i = 0; i < triangulo.length;i++) {
            triangulo[i].draw(dbg);
        }


        graphics.setFont(f);

        graphics.drawImage(imageBuffer,0,0,null);

        graphics.setColor(Color.black);
        graphics.drawString("FPS " + fps, 10, 25);
    }

    public void start(){
        runner = new Thread(this);
        runner.start();
    }

    public void simulateWorld(long diffTime){

        float diffSeconds = diffTime/1000.0f;
        float vel = 200;

        //translate coordenadas
        float tx = 0;
        float ty = 0;

        if(UP) {
            ty = -vel*diffSeconds;
        }
        if(DOWN) {
            ty = vel*diffSeconds;
        }
        if(LEFT) {
            tx = -vel*diffSeconds;
        }
        if(RIGHT) {
            tx = vel*diffSeconds;
        }

        for(int i = 0; i < triangulo.length;i++) {
            triangulo[i].translate(tx, ty);
        }
    }


    @Override
    public void run() {
        long time = System.currentTimeMillis();
        long seconds = time/1000;
        long diffTime = 0;

        while(active){
            simulateWorld(diffTime);
            paintImmediately(0, 0, 640, 480);
            paintCounter +=100;

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long newTime = System.currentTimeMillis();
            long newSeconds = newTime/1000;

            diffTime = System.currentTimeMillis() - time;
            time = System.currentTimeMillis();
            frameCount++;

            if(newSeconds!=seconds) {
                fps = frameCount;
                frameCount = 0;
                seconds = newSeconds;
            }
        }

    }
}
