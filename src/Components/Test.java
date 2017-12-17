package Components;

public class Test {

    public static void main(String[] args) {
        Tree pine = new TreeBuilder()
                .setArea(10.0)
                .setCrownCenterHeight(12.5)
                .setCrownMass(63.0)
                .setDiameter(20.0)
                .setFriction(0.29)
                .setHeight(16.0)
                .setMassSoilRatio(0.3)
                .setMoe(7000.0)
                .setMor(39.1)
                .setRootDepth(0.64)
                .setRootMass(1261)
                .setX(1)
                .setY(1)
                .createTree();

        System.out.println(pine.getState(80.0));
    }
}
