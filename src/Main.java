import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        JFrame frame = new JFrame();

        frame.setSize(canvas.width, canvas.height);
        frame.setVisible(true);
        frame.getContentPane().add(canvas);
        frame.addKeyListener(canvas);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        canvas.start();
    }
}
