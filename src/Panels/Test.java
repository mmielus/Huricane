package Panels;

import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("Log");
        logger.info("Rozpoczeto symulacje");
        SimulatePanel panel = new SimulatePanel();
        panel.simulate();
    }
}

