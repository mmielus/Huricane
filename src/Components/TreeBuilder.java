package Components;

public class TreeBuilder {
    private TreeType type;
    private int x;
    private int y;
    private double height;
    private double crownCenterHeight;
    private double area;
    private double diameter;
    private double friction;
    private double crownMass;
    private double moe;
    private double mor;
    private double rootMass;
    private double rootDepth;
    private double massSoilRatio;

    public TreeBuilder setType(TreeType type) {
        this.type = type;
        return this;
    }

    public TreeBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    public TreeBuilder setCrownCenterHeight(double crownCenterHeight) {
        this.crownCenterHeight = crownCenterHeight;
        return this;
    }

    public TreeBuilder setArea(double area) {
        this.area = area;
        return this;
    }

    public TreeBuilder setDiameter(double diameter) {
        this.diameter = diameter;
        return this;
    }

    public TreeBuilder setFriction(double friction) {
        this.friction = friction;
        return this;
    }

    public TreeBuilder setCrownMass(double crownMass) {
        this.crownMass = crownMass;
        return this;
    }

    public TreeBuilder setMoe(double moe) {
        this.moe = moe;
        return this;
    }

    public TreeBuilder setMor(double mor) {
        this.mor = mor;
        return this;
    }

    public TreeBuilder setRootMass(double rootMass) {
        this.rootMass = rootMass;
        return this;
    }

    public TreeBuilder setRootDepth(double rootDepth) {
        this.rootDepth = rootDepth;
        return this;
    }

    public TreeBuilder setMassSoilRatio(double massSoilRatio) {
        this.massSoilRatio = massSoilRatio;
        return this;
    }

    public Tree createTree() {
        return new Tree(
                height, crownCenterHeight,
                area, diameter,
                friction,
                crownMass,
                moe, mor,
                rootMass, rootDepth,
                massSoilRatio,
                type);
    }
}