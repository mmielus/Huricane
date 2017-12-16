package DesktopPanel;

import java.awt.*;
import javax.swing.JPanel;

public class SimulationPanel {
    JPanel simulationPanel;
    SimulationPanel()
    {
        simulationPanel = new JPanel();
        simulationPanel.setBounds(20,20,
                800,520);
        simulationPanel.setVisible(true);
        simulationPanel.setBackground(Color.gray);
    }
    JPanel getSimulationPanel(){
        return simulationPanel;
    }
}
