package Components;

import java.awt.*;

public class Vortex {

    private static double EXPONENT = 0.6; // stała oszacowana poprzez mierzenie tornad

    private Point center; // srodek
    private double angle; // kat w jakim porusza sie tornado
    private double rMax; // maksymalny promien
    private double vTravMax; // maksymalna predkosc trawersalna
    private double vRadMax; // maksymalna predkosc radialna
    private double vTrans; // predkosc translacji - poruszania sie po plaszczyznie

    public Vortex (int x, int y,
                   double angle,
                   double rMax,
                   double vTravMax,
                   double vRadMax,
                   double vTrans) {
        this.center = new Point(x, y);
        this.angle = angle;
        this.rMax = rMax;
        this.vTravMax = vTravMax;
        this.vRadMax = vRadMax;
        this.vTrans = vTrans;
    }

    /**
     *  Poruszanie sie tornada - zmiana wspolrzednych srodka
     *  w zalozeniu co sekunde
     */
    public void recalculateCenter() {
        this.center.setLocation(
                this.center.getX() + (vTrans * Math.sin(angle)),
                this.center.getY() + (vTrans * Math.cos(angle))
        );
    }

    public Point getCenter() {
        return center;
    }

    private double getVTrav(double r) {
        return (r <= rMax)
                ? vTravMax * (r / rMax)
                : vTravMax * (rMax / r);
    }

    private double getVRad(double r) {
        return (r <= rMax)
                ? vRadMax * Math.pow((r / rMax), EXPONENT)
                : vRadMax * Math.pow((rMax / r), EXPONENT);
    }

    /**
     * Predkosc cyrkularna
     */
    private double getVCir(int x, int y) {
        double r = new Point(x, y).distance(this.center); // odleglosc od srodka
        return getVTrav(r) + getVRad(r);
    }

    public double getV(int x, int y) {
        return getVCir(x, y) - vTrans;
    }
}
