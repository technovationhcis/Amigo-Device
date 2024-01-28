import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HologramSimulation extends JFrame {
    private double angle = 0;

    public HologramSimulation() {
        setTitle("Hologram Simulation");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angle += 0.02;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int size = 100;

        int[] x = {centerX - size, centerX + size, centerX + size, centerX - size};
        int[] y = {centerY - size, centerY - size, centerY + size, centerY + size};

        // Rotate the cube
        for (int i = 0; i < 4; i++) {
            int newX = centerX + (int) ((x[i] - centerX) * Math.cos(angle) - (y[i] - centerY) * Math.sin(angle));
            int newY = centerY + (int) ((x[i] - centerX) * Math.sin(angle) + (y[i] - centerY) * Math.cos(angle));

            x[i] = newX;
            y[i] = newY;
        }

        g2d.setColor(Color.BLUE);
        g2d.fillPolygon(x, y, 4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HologramSimulation().setVisible(true);
            }
        });
    }
}
