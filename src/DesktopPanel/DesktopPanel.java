package DesktopPanel;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class DesktopPanel extends JFrame {
  //  public ArrayList<Tree> forest = new ArrayList<>(500);
    public Tree forest[][] = new Tree[800][600];
    long l = System.currentTimeMillis();
    private BufferStrategy bufferstrat = null;
    private Canvas render;
    private int lit=1;
    private int mnoz=1;
    public DesktopPanel(){
        super();
        setTitle("Hurricane");
        setIgnoreRepaint(true);
        setResizable(false);

        render = new Canvas();
        render.setIgnoreRepaint(true);
        setBounds(50,50,800,600);
        render.setBounds(50,50,800,600);

        add(render);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        render.createBufferStrategy(2);
        bufferstrat = render.getBufferStrategy();
    }
    public void addTree(int x,int y){
        forest[x][y] = (new Tree(x, y, 5, 5, Color.GREEN));
    }
    public void renderForest(Graphics2D g2d){
        Tree tree=null;
        for(int i=0;i<800;i++)
            for(int j=0;j<600;j++)
                if(forest[i][j]!=null) {
                    tree = forest[i][j];
                    tree.render(g2d);
                }
        

    }
    public void makeForest() {
        Random generator = new Random();
        int l=0;
        while(l<20000) {
            addTree(generator.nextInt(800),generator.nextInt(600) );
         l++;
        }


    }
    public void render(){
        do{
            do{
                Graphics2D g2d = (Graphics2D) bufferstrat.getDrawGraphics();
                g2d.fillRect(0, 0, render.getWidth(), render.getHeight());

                renderForest(g2d);

                g2d.dispose();
            }while(bufferstrat.contentsRestored());
            bufferstrat.show();
        }while(bufferstrat.contentsLost());
    }
    public void loop(){
        Random generator = new Random();
        Tree tree=null;
        makeForest();
        while(true){


            if(l+500<System.currentTimeMillis()) {
                l=System.currentTimeMillis();
                mnoz++;
                int a = generator.nextInt(10)*mnoz;
                for(int i=0;i<580;i++) {
                    if (forest[a][i + 2] != null) {
                        tree = forest[a][i + 2];
                        tree.changeColor(Color.red);
                    }
                }
            }
            lit++;
            render();

            try {
                Thread.sleep(1000/30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

