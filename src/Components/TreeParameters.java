package Components;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static Components.TreeParameters.TreeParameter.*;
import static Components.TreeType.PINE;
import static Components.TreeType.SPRUCE;

/**
 *  Wartosci parametrow z tabelki
 */
public class TreeParameters {

    public enum TreeParameter {
        HEIGHT, DIAMATER,
        CROWN_MASS, CROWN_HEIGHT, CROWN_WIDTH, ROOT_MASS, ROOT_DEPTH,
        MOR, MOE, FRICTION, MASS_SOIL_RATIO
    }

    // TODO co sie stalo z masa pnia?????????
    private static double[] HEIGHTS = {12.0, 12.0, 12.0, 16.0, 16.0, 16.0, 20.0, 20.0, 20.0};
    private static double[] DIAMETERS = {10.0, 12.0, 15.0, 13.3, 16.0, 20.0, 16.7, 20.0, 25.0};

    private static double[] PINE_CROWN_MASSES = {13.0, 18.0, 28.0, 28.0, 40.0, 63.0, 52.0, 74.0, 116.0};
    private static double[] PINE_CROWN_HEIGHTS = {5.0, 5.0, 5.0, 7.0, 7.0, 7.0, 8.0, 8.0, 8.0};
    private static double[] PINE_CROWN_WIDTHS = {3.1, 3.5, 4.0, 3.7, 4.2, 5.0, 4.3, 5.0, 5.9};
    private static double[] PINE_ROOT_MASSES = {345.0, 485.0, 719.0, 573.0, 817.0, 1261.0, 887.0, 1252.0, 1988.0};
    private static double[] PINE_ROOT_DEPTHS = {0.44, 0.48, 0.55, 0.51, 0.57, 0.64, 0.58, 0.64, 0.7};

    private static double[] SPRUCE_CROWN_MASSES = {19.0, 27.0, 43.0, 44.0, 63.0, 99.0, 83.0, 120.0, 187.0};
    private static double[] SPRUCE_CROWN_HEIGHTS = {9.0, 9.0, 9.0, 12.0, 12.0, 12.0, 15.0, 15.0, 15.0};
    private static double[] SPRUCE_CROWN_WIDTHS = {3.7, 3.9, 4.3, 4.1, 4.4, 4.9, 4.5, 4.9, 5.6};
    private static double[] SPRUCE_ROOT_MASSES = {451.0, 583.0, 770.0, 645.0, 850.0, 1193.0, 914.0, 1203.0, 1762.0};
    private static double[] SPRUCE_ROOT_DEPTHS = {0.24, 0.26, 0.3, 0.28, 0.31, 0.36, 0.32, 0.36, 0.42};

    private static double PINE_MOR = 39.1;
    private static double PINE_MOE = 7000.0;
    private static double PINE_FRICTION = 0.29;
    private static double PINE_MASS_SOIL_RATIO = 0.3;

    private static double SPRUCE_MOR = 30.6;
    private static double SPRUCE_MOE = 6300.0;
    private static double SPRUCE_FRICTION = 0.35;
    private static double SPRUCE_MASS_SOIL_RATIO = 0.2;

    public static final Map<TreeType, Map<TreeParameter, Double>> getTreeBasicParameterMap() {
        Map<TreeType, Map<TreeParameter, Double>> map = new HashMap<>();
        map.put(PINE, getPineBasicMap());
        map.put(SPRUCE, getSpruceBasicMap());

        return Collections.unmodifiableMap(map);
    }

    public static final Map<TreeType, Map<TreeParameter, double[]>> getTreeParameterArraysMap() {
        Map<TreeType, Map<TreeParameter, double[]>> map = new HashMap<>();
        map.put(PINE, getPineArraysMap());
        map.put(SPRUCE, getSpruceArraysMap());

        return Collections.unmodifiableMap(map);
    }

    private static Map<TreeParameter, Double> getPineBasicMap() {
        Map<TreeParameter, Double> map = new HashMap<>();
        map.put(MOR, PINE_MOR);
        map.put(MOE, PINE_MOE);
        map.put(FRICTION, PINE_FRICTION);
        map.put(MASS_SOIL_RATIO, PINE_MASS_SOIL_RATIO);

        return Collections.unmodifiableMap(map);
    }

    private static Map<TreeParameter, Double> getSpruceBasicMap() {
        Map<TreeParameter, Double> map = new HashMap<>();
        map.put(MOR, SPRUCE_MOR);
        map.put(MOE, SPRUCE_MOE);
        map.put(FRICTION, SPRUCE_FRICTION);
        map.put(MASS_SOIL_RATIO, SPRUCE_MASS_SOIL_RATIO);

        return Collections.unmodifiableMap(map);
    }

    private static final Map<TreeParameter, double[]> getPineArraysMap() {
        Map<TreeParameter, double[]> pineMap = new HashMap<>();

        pineMap.put(HEIGHT, HEIGHTS);
        pineMap.put(DIAMATER, DIAMETERS);
        pineMap.put(CROWN_MASS, PINE_CROWN_MASSES);
        pineMap.put(CROWN_HEIGHT, PINE_CROWN_HEIGHTS);
        pineMap.put(CROWN_WIDTH, PINE_CROWN_WIDTHS);
        pineMap.put(ROOT_MASS, PINE_ROOT_MASSES);
        pineMap.put(ROOT_DEPTH, PINE_ROOT_DEPTHS);

        return Collections.unmodifiableMap(pineMap);
    }

    private static final Map<TreeParameter, double[]> getSpruceArraysMap() {
        Map<TreeParameter, double[]> spruceMap = new HashMap<>();

        spruceMap.put(HEIGHT, HEIGHTS);
        spruceMap.put(DIAMATER, DIAMETERS);
        spruceMap.put(CROWN_MASS, SPRUCE_CROWN_MASSES);
        spruceMap.put(CROWN_HEIGHT, SPRUCE_CROWN_HEIGHTS);
        spruceMap.put(CROWN_WIDTH, SPRUCE_CROWN_WIDTHS);
        spruceMap.put(ROOT_MASS, SPRUCE_ROOT_MASSES);
        spruceMap.put(ROOT_DEPTH, SPRUCE_ROOT_DEPTHS);

        return Collections.unmodifiableMap(spruceMap);
    }

}
