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
        FileHandler fh;
        DesktopPanel panel =new DesktopPanel();
        panel.simulate();

        try {

            fh = new FileHandler("symulacja.log"); // jak cos to nie dziala
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

