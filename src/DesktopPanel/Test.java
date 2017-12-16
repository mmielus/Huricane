package DesktopPanel;

import java.awt.EventQueue;

public class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                DesktopPanel panel =new DesktopPanel();
                panel.loop();
            }
        });
    }
}

