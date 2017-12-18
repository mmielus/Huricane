package Components;

import java.util.Random;

/**
 * Klasa od generowania randomowej sosny
 * TODO: swierk, ogarnac to moze jakos lepiej
 */
public class TreeFactory {

    // Wartosci z tabelki
    private static double[] HEIGHTS = {12.0, 12.0, 12.0, 16.0, 16.0, 16.0, 20.0, 20.0, 20.0};
    private static double[] DIAMETERS = {10.0, 12.0, 15.0, 13.3, 16.0, 20.0, 16.7, 20.0, 25.0};
    private static double[] CROWN_MASSES = {13.0, 18.0, 28.0, 28.0, 40.0, 63.0, 52.0, 74.0, 116.0};
    private static double[] CROWN_HEIGHTS = {5.0, 5.0, 5.0, 7.0, 7.0, 7.0, 8.0, 8.0, 8.0};
    private static double[] CROWN_WIDTHS = {3.1, 3.5, 4.0, 3.7, 4.2, 5.0, 4.3, 5.0, 5.9};
    private static double[] ROOT_MASSES = {345.0, 485.0, 719.0, 573.0, 817.0, 1261.0, 887.0, 1252.0, 1988.0};
    private static double[] ROOT_DEPTHS = {0.44, 0.48, 0.55, 0.51, 0.57, 0.64, 0.58, 0.64, 0.7};

    private static double PINE_MOR = 39.1;
    private static double PINE_MOE = 7000.0;
    private static double PINE_FRICTION = 0.29;
    private static double PINE_MASS_SOIL_RATIO = 0.3;

    public static Tree getTree() {
        int i = new Random().nextInt(9);
        return new TreeBuilder()
                .setArea(getTreeArea(CROWN_WIDTHS[i], HEIGHTS[i]))
                .setCrownCenterHeight((HEIGHTS[i]-CROWN_HEIGHTS[i]) / 2.0)
                .setCrownMass(CROWN_MASSES[i])
                .setDiameter(DIAMETERS[i])
                .setFriction(PINE_FRICTION)
                .setHeight(HEIGHTS[i])
                .setMassSoilRatio(PINE_MASS_SOIL_RATIO)
                .setMoe(PINE_MOE)
                .setMor(PINE_MOR)
                .setRootDepth(ROOT_DEPTHS[i])
                .setRootMass(ROOT_MASSES[i])
                .createTree();
    }

    // Do testowania predkosci wiatru - konkretna sosna z tabelki
    public static Tree getParticularPine(int index) {
        if (index < 0 || index > 8)
            throw new IllegalArgumentException();

        return new TreeBuilder()
                .setArea(getTreeArea(CROWN_WIDTHS[index], HEIGHTS[index]))
                .setCrownCenterHeight((HEIGHTS[index]-CROWN_HEIGHTS[index]) / 2.0)
                .setCrownMass(CROWN_MASSES[index])
                .setDiameter(DIAMETERS[index])
                .setFriction(PINE_FRICTION)
                .setHeight(HEIGHTS[index])
                .setMassSoilRatio(PINE_MASS_SOIL_RATIO)
                .setMoe(PINE_MOE)
                .setMor(PINE_MOR)
                .setRootDepth(ROOT_DEPTHS[index])
                .setRootMass(ROOT_MASSES[index])
                .createTree();
    }

    /**
     * Algorytm wyliczania powierzchni drzewa stawiajacej opor wiatrowi,
     * przyjeto ze korona sosny jest trojkat rownoramienny
     * NEEDS IMPROVEMENT
     */
    private static double getTreeArea(double crownWidth, double height) {

        double areaSummarizer = 0.0;
        double dx, xl, xr, xl_base, xr_base, xl_top, xr_top, a, b;
        for(int i=0; i < (int)height; i++) {
            dx = 0.5 * crownWidth / height;

            xl = 0.0;
            xr = crownWidth;

            xl_base = xl + i*dx;
            xr_base = xr - i*dx;
            xl_top = xl + (i+1)*dx;
            xr_top = xr - (i+1)*dx;

            a = xr_base - xl_base;
            b = xr_top - xl_top;

            areaSummarizer = areaSummarizer + ((a+b) * 0.5);
        }
        return areaSummarizer;
    }
}
