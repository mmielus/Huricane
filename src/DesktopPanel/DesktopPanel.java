package DesktopPanel;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.EventQueue;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DesktopPanel extends JFrame {
    public Tree forest[][] = new Tree[800][600];
    long l = System.currentTimeMillis();
    private BufferStrategy bufferstrat = null;
    private Canvas render;
    private int lit = 1;
    private int mnoz = 1;
    public ButtonTest test = new ButtonTest();


    public DesktopPanel() {

        super();
        setTitle("Hurricane");
        setIgnoreRepaint(true);
        setResizable(false);
        render = new Canvas();
        render.setIgnoreRepaint(true);
        setLayout(new BorderLayout());
        setBounds(50, 50, 800, 600);
        render.setBounds(50, 50, 800, 600);
        JPanel panel = new ButtonPanel();
        panel.setIgnoreRepaint(true);
        panel.setBounds(700, 100, 100, 100);
        add(render, BorderLayout.WEST);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        render.createBufferStrategy(2);
        bufferstrat = render.getBufferStrategy();
    }

    /**
     * Metoda dodajaca drzewo do lasu
     *
     * @param x wspolrzedna
     * @param y wspolrzedna
     */
    public void addTree(int x, int y) {
        forest[x][y] = (new Tree(x, y, 5, 5, Color.GREEN));
    }

    /**
     * Wyswietla las renderujac kazde drzewo po kolei.
     *
     * @param g2d
     */
    public void renderForest(Graphics2D g2d) {
        Tree tree = null;
        for (int i = 0; i < 800; i++)
            for (int j = 0; j < 600; j++)
                if (forest[i][j] != null) {
                    tree = forest[i][j];
                    tree.render(g2d);
                }


    }

    /** Metoda tworzaca las
     *
     */
    public void makeForest() {
        Random generator = new Random();
        int l = 0;
        while (test.getCheck() == false) {
            System.out.println(test.forestDensity);
        }
        while (l < test.getForestDensity()) {
            addTree(generator.nextInt(800), generator.nextInt(600));
            l++;
        }
    }

    /**
     *
     */
    public void render() {
        do {
            do {
                Graphics2D g2d = (Graphics2D) bufferstrat.getDrawGraphics();
                g2d.fillRect(0, 0, render.getWidth(), render.getHeight());

                renderForest(g2d);

                g2d.dispose();
            } while (bufferstrat.contentsRestored());
            bufferstrat.show();
        } while (bufferstrat.contentsLost());
    }

    /**
     *
     */
    public void loop() {
        Random generator = new Random();
        Tree tree = null;
        makeForest();
        while (true) {

/**
 * ta czesc ponizej jest od tego zeby zmienialo zielone kropki na czerwone
 * o ile sie nie myle to w tej czesci bedzie trzeba polaczyc to co napisal epy zeby jakos to symulowalo odpowiednio
 */
            if (l + 500 < System.currentTimeMillis()) {
                l = System.currentTimeMillis();
                mnoz++;
                int a = generator.nextInt(10) * mnoz;
                for (int i = 0; i < 580; i++) {
                    if (forest[a][i + 2] != null) {
                        tree = forest[a][i + 2];
                        tree.changeColor(Color.red);
                    }
                }
            }
            lit++;
            render();

            try {
                Thread.sleep(1000 / 30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}