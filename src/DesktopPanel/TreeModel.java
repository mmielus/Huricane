package DesktopPanel;

import Components.Tree;
import Components.TreeFactory;

import java.awt.*;


public class TreeModel {
    private int x;
    private int y;

    private Components.Tree tree = TreeFactory.getTree();
    private Color color;

    public TreeModel(int x, int y) {

        this.x=x;
        this.y=y;
        this.color = Color.GREEN;
    }

    public void render(Graphics g){
        Graphics g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillRect(x,y,3,3);
    }

    public void interact(double windSpeed) {
        Tree.TreeState state = this.tree.getState(windSpeed);

        switch (state) {
            case BROKEN: this.color = Color.YELLOW;
                break;
            case FALLEN: this.color = Color.RED;
                break;
            case BOTH: this.color = Color.RED;
                break;
            default: this.color = Color.GREEN;
                break;
        }
    }
}
