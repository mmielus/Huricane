package Tree;

import Tree.Tree;
import Tree.TreeFactory;
import Tree.TreeType;

import java.awt.*;


public class TreeModel {
    private int x;
    private int y;

    private Tree tree;
    private Color color;

    public static int fallenTree = 0;
    public static int brokenTree = 0;

    public TreeModel(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.tree = TreeFactory.getTree(type);
        this.color = Color.GREEN;
    }

    public void render(Graphics g) {
        Graphics g2d = (Graphics2D) g.create();

        g2d.setColor(color);
        g2d.fillRect(x, y, 1, 1);
    }

    public void interact(double windSpeed) {
        this.tree.interact(windSpeed);
        switch (this.tree.getState()) {
            case BROKEN:
                this.color = Color.BLUE;
                break;
            case FALLEN:
                this.color = Color.RED;
                break;
            case BOTH:
                this.color = Color.RED;
                break;
            default:
                this.color = Color.GREEN;
                break;
        }
    }

    public static int getBrokenTree() {
        return brokenTree;
    }

    public static int getFallenTree() {
        return fallenTree;
    }
}
