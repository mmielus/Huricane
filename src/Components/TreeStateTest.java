package Components;

public class TreeStateTest {

    public static void main(String[] args) {

        Tree pine = TreeFactory.getTree(); // randomowa
        Tree anotherPine = TreeFactory.getParticularPine(0);

        System.out.println(anotherPine.getState(32.0));
    }
}
