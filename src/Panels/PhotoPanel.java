package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class PhotoPanel extends JPanel {
    private BufferedImage bufferedImage;

    public PhotoPanel() {
        super();
    }

    public PhotoPanel(String photo) {
        super();

        File file = new File(photo);
        try {
            bufferedImage = read(file);
        } catch (IOException e) {
            System.err.println("Error reading from file");
        }
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) dimension.getWidth() / 4, (int) dimension.getHeight() / 4));
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bufferedImage, 0, 0, this);
    }
}
