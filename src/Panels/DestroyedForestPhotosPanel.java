package Panels;

import javax.swing.*;
import java.awt.*;

public class DestroyedForestPhotosPanel extends JFrame {

    public DestroyedForestPhotosPanel() {
        super("Zniszczony las po symulacji");
        JPanel broken1Panel = new PhotoPanel("broken1.jpg");
        JPanel broken2Panel = new PhotoPanel("broken2.jpg");
        JPanel broken3Panel = new PhotoPanel("broken3.jpg");
        JPanel broken4Panel = new PhotoPanel("broken4.jpg");

        JPanel fallen1Panel = new PhotoPanel("fallen1.jpg");
        JPanel fallen2Panel = new PhotoPanel("fallen2.jpg");
        JPanel fallen3Panel = new PhotoPanel("fallen3.jpg");
        JPanel fallen4Panel = new PhotoPanel("fallen4.jpeg");
        if (Tree.Tree.getBrokenTree() > Tree.Tree.getFallenTree()) {
            add(broken1Panel);
            add(broken2Panel);
            add(broken3Panel);
            add(broken4Panel);
        } else {
            add(fallen1Panel);
            add(fallen2Panel);
            add(fallen3Panel);
            add(fallen4Panel);
        }
        setLayout(new GridLayout(2, 2));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension((int) dimension.getWidth(), (int) dimension.getHeight()));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}

