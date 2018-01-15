package Panels;

import javax.swing.*;

public class ResultPanel extends JFrame {

    private static int windowHeight = 200;
    private static int windowWidth = 400;
    private static int labelWidth = 300;
    private static int labelHeight = 40;

    private JLabel brokenTreesLabel;
    private JLabel fallenTreesLabel;
    private JLabel okTreesLabel;

    public  ResultPanel(double percentOfBrokenTree, double percentOfFallenTrees, double percentOfOkTrees) {

        setTitle("");

        brokenTreesLabel = new JLabel();
        brokenTreesLabel.setText(percentOfBrokenTree + "% zostało złamanych przez huragan");
        brokenTreesLabel.setBounds( 5, 10, labelWidth, labelHeight);

        fallenTreesLabel = new JLabel();
        fallenTreesLabel.setText(percentOfFallenTrees + "% zostało przewróconych przez huragan");
        fallenTreesLabel.setBounds( 5, 10 + labelHeight, labelWidth, labelHeight);

        okTreesLabel = new JLabel();
        okTreesLabel.setText(percentOfOkTrees + "% nie uległo zniszczeniu");
        okTreesLabel.setBounds( 5, 10 + 2 * labelHeight, labelWidth, labelHeight);

        add(brokenTreesLabel);
        add(fallenTreesLabel);
        add(okTreesLabel);

        setSize(windowWidth, windowHeight);
        setBounds(860, 45, windowWidth, windowHeight);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
