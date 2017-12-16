package DesktopPanel;

import java.awt.*;

public class Tree {
    private int x;
    private int y;
    private int life;
    private int size;
    private Color color;

    public Tree(int x,int y,int size,int life, Color color){
        this.x=x;
        this.y=y;
        this.size=size;
        this.life=life;
        this.color=color;
    }
    public void render(Graphics g){
        Graphics g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillRect(x,y,3,3);
    }
    public void changeColor(Color color){
        this.color = color;
    }
}
