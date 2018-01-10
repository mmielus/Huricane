package DesktopPanel;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("Log");
        logger.info("Rozpoczeto symulacje");
        DesktopPanel panel =new DesktopPanel();
        panel.simulate();
    }
}

