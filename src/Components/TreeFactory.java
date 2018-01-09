package Components;

import Components.TreeParameters.TreeParameter;

import java.util.Map;
import java.util.Random;

import static Components.TreeParameters.TreeParameter.*;

public class TreeFactory {

    private static final Map<TreeType, Map<TreeParameter, Double>> TREE_BASIC_PARAMETERS =
            TreeParameters.getTreeBasicParameterMap();
    private static final Map<TreeType, Map<TreeParameter, double[]>> TREE_ARRAY_PARAMETERS =
            TreeParameters.getTreeParameterArraysMap();


    public static Tree getTree(TreeType type) {
        int i = new Random().nextInt(9);
        double height = TREE_ARRAY_PARAMETERS.get(type).get(HEIGHT)[i];
        return new TreeBuilder()
                .setType(type)
                .setArea(getTreeArea(type,
                        TREE_ARRAY_PARAMETERS.get(type).get(CROWN_WIDTH)[i],
                        height))
                .setCrownCenterHeight(
                        (height-TREE_ARRAY_PARAMETERS.get(type).get(CROWN_HEIGHT)[i]) / 2.0)
                .setCrownMass(TREE_ARRAY_PARAMETERS.get(type).get(CROWN_MASS)[i])
                .setDiameter(TREE_ARRAY_PARAMETERS.get(type).get(DIAMATER)[i])
                .setFriction(TREE_BASIC_PARAMETERS.get(type).get(FRICTION))
                .setHeight(height)
                .setMassSoilRatio(TREE_BASIC_PARAMETERS.get(type).get(MASS_SOIL_RATIO))
                .setMoe(TREE_BASIC_PARAMETERS.get(type).get(MOE))
                .setMor(TREE_BASIC_PARAMETERS.get(type).get(MOR))
                .setRootDepth(TREE_ARRAY_PARAMETERS.get(type).get(ROOT_DEPTH)[i])
                .setRootMass(TREE_ARRAY_PARAMETERS.get(type).get(ROOT_MASS)[i])
                .createTree();
    }

    private static double getTreeArea(TreeType type, double crownWidth, double height) {
       return type == TreeType.SPRUCE
               ? getSpruceArea(crownWidth, height)
               : getPineArea(crownWidth, height);
    }

    /**
     * Algorytm wyliczania powierzchni drzewa stawiajacej opor wiatrowi,
     * przyjeto ze korona swierku jest trojkat rownoramienny
     */
    private static double getSpruceArea(double width, double height) {
        double areaSummarizer = 0.0;
        double dx, xl, xr, xl_base, xr_base, xl_top, xr_top, a, b;
        for(int i=0; i < (int)height; i++) {
            dx = 0.5 * width / height;

            xl = 0.0;
            xr = width;

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

    /**
     * Algorytm wyliczania powierzchni drzewa stawiajacej opor wiatrowi,
     * przyjeto ze korona sosny to dwa trojkaty zwrocone do siebie podstawami
     */
    // TODO za duzo przepisywania
    private static double getPineArea(double width, double height) {
        double areaSummarizer = 0.0;
        double dx, xl, xr, xl_base, xr_base, xl_top, xr_top, a, b;
        for(int i=0; i < (int)height; i++) {
            dx = 0.5 * width / height;

            xl = 0.0;
            xr = width;

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
