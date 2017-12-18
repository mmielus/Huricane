package Components;

import java.awt.*;

class Tree {

    private static double STANDARD_GRAVITY = 9.80665; // g - przyspieszenie ziemskie
    private static double AIR_DENSITY = 1.226; // gestosc powierza

    public Tree(int x, int y,
                double height, double crownCenterHeight,
                double area, double diameter,
                double friction,
                double crownMass,
                double moe, double mor,
                double rootMass, double rootDepth,
                double massSoilRatio) {

        this.height = height;
        this.crownCenterHeight = crownCenterHeight;
        this.area = area;
        this.diameter = diameter;
        this.friction = friction;
        this.crownMass = crownMass;
        this.moe = moe;
        this.mor = mor;
        this.rootMass = rootMass;
        this.rootDepth = rootDepth;
        this.massSoilRatio = massSoilRatio;
    }

    public enum TreeState {
        OK, BROKEN, FALLEN, BOTH
    }

    private int x;
    private int y;

    private double height; // wysokosc drzewa
    private double crownCenterHeight; // wysokosc srodka korony
    private double area; // powierzchnia korony
    private double diameter; // srednica drzewa na wysokosci 1.3 m
    private double friction; // wspolczynnik tarcia
    private double crownMass; // masa korony

    private double moe; //spolczynnik elastycznosci
    private double mor; // wspolczynnik pekania drzewa

    private double rootMass; // masa korzenia
    private double rootDepth; // glebokosc korzenia
    private double massSoilRatio; // stosunek wagi gleby do masy drzewa

    /**
     * Drzewo zostanie zlamane gdy całkowity moment ugiecia drzewa przekroczy wytrzymałosc pnia
     * lub wyrwane gdy moment ugiecia przekroczy wytrzymałosc korzenia
     * @param airVelocity   predkosc powietrza
     */
    public TreeState getState(double airVelocity) {
        double bendingMoment = getBendingMoment(airVelocity),
                treeResistance = getTreeResistance(),
                rootResistance = getRootResistance();

        System.out.println(
                String.format("bending: %f tree res: %f root res: %f", bendingMoment, treeResistance, rootResistance));

        //napisz mnie ladnie plsss
        if (bendingMoment > treeResistance && bendingMoment > rootResistance)
            return TreeState.BOTH;

        if (bendingMoment > treeResistance)
            return TreeState.BROKEN;

        if (bendingMoment > rootResistance)
            return TreeState.FALLEN;


        return TreeState.OK;
    }

    /**
     * Obliczenie momentu skrecajacego drzewa
     */
    private double getBendingMoment(double velocity) {
        double horizontalForce = getHorizontalResistance(velocity),
                verticalForce = getVerticalResistance(),
                treeTopTilt = getTreeTopTilt(velocity, horizontalForce);

        System.out.println(
                String.format("horizontal: %f vertical: %f tilt: %f", horizontalForce, verticalForce, treeTopTilt));
        return horizontalForce + (verticalForce * treeTopTilt);
    }

    /**
     * Odchylenie czubka drzewa od pionu
     */
    private double getTreeTopTilt(double velocity, double horizontalForce) {
        double distanceFromTop = this.height - this.crownCenterHeight, // odleglosc srodka korony od czubka
                inertiaMoment = (Math.PI * Math.pow(this.diameter, 4.0)) / 64.0; // powierzchniowy moment bezwlasnosci

        return (horizontalForce * crownCenterHeight * crownCenterHeight * height *
                    (3-(crownCenterHeight/height)-((3*distanceFromTop)/height))) /
                (6* this.moe * inertiaMoment);
    }

    /**
     * Calkowita pozioma siła wiatru obliczana jest osobno dla kazdego 1 metrowego segmentu drzewa
     * @param velocity  predkosc pozioma dla segmentu
     */
    private double getHorizontalResistance(double velocity) {
        return (0.5) * this.friction * AIR_DENSITY * velocity * velocity * getCurrentArea(velocity);
    }

    /**
     * Pod wpływem wiatru powierzchnia korony ulega zmniejszeniu
     */
    private double getCurrentArea(double velocity) {
        return ((0.044444 * velocity) - 0.288889) * this.area;
    }

    /**
     * Kiedy drzewo pod naporem wiatru zacznie sie odchylac pod uwage brana jest dodatkowo siła grawitacji
     */
    private double getVerticalResistance() {
        return this.crownMass * STANDARD_GRAVITY;
    }

    /**
     * obliczenie sil oporu drzewa
     */
    private double getTreeResistance() {
        return (Math.PI / 32.0) * this.mor * Math.pow(this.diameter, 3.0);
    }

    /**
     * Obliczenie sily wytrzymalosci korzenia
     */
    private double getRootResistance() {
        return ((STANDARD_GRAVITY * this.rootMass * this.rootDepth) / this.massSoilRatio);
    }


}
