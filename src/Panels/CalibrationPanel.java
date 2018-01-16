package Panels;

import Forest.ForestType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class CalibrationPanel extends JFrame implements ActionListener, ChangeListener {


    private JLabel forestDensityLabel;
    private JLabel forestKindLabel;

    private JLabel hurricaneVelocityLabel;
    private JLabel hurricaneAngleLabel;
    private JLabel maxHurricaneRadiusLabel;
    private JLabel maxTraversalVelocityLabel;
    private JLabel maxRadialVelocityLabel;
    private JLabel newHurricaneAngleLabel;
    private JLabel brokenTreeQuantityLabel;
    private JLabel fallenTreeQuantityLabel;
    private JLabel brokenTreeQuantity;
    private JLabel fallenTreeQuantity;
    private JLabel forrestSizeLabel;

    private JComboBox<String> forestList;

    private JTextField forestDensityTextField;
    private JTextField hurricaneVelocityTextField;
    private JTextField hurricaneAngleTextField;
    private JTextField maxHurricaneRadiusTextField;
    private JTextField maxTraversalVelocityTextField;
    private JTextField maxRadialVelocityTextField;
    private JTextField forrestSizeTextField;


    private JSlider newHurricaneAngle;

    private JButton startSimulate;
    private JButton newSimulation;
    private int forestDensity;
    private int hurricaneVelocity;
    private int hurricaneAngle;
    private int maxHurricaneRadius;
    private int maxTraversalVelocity;
    private int maxRadialVelocity;
    private int forrestSize;
    private boolean checkStart;
    private boolean checkNewSimulation;
    private ForestType forestType = null;


    private static final String[] FOREST_TYPE = {"", "Świerkowy", "Sosnowy", "Mieszany"};


    public CalibrationPanel() {
/**
 * Tu jest dodawanie przycików i pól do wpisywania to nawet nie patrzcie na to bo to nic waznego
 */
        setTitle("Kalibracja");


        newHurricaneAngle = new JSlider(JSlider.HORIZONTAL, 0, 360, 0);
        newHurricaneAngle.setBounds(220, 260, 150, 50);
        newHurricaneAngle.setMajorTickSpacing(360);
        newHurricaneAngle.setMinorTickSpacing(0);
        newHurricaneAngle.setPaintTicks(true);
        newHurricaneAngle.setPaintLabels(true);

        newHurricaneAngleLabel = new JLabel("Zmień kierunek huraganu");
        newHurricaneAngleLabel.setBounds(10, 260, 250, 35);

        startSimulate = new JButton("START");
        startSimulate.setBounds(10, 460, 100, 40);

        newSimulation = new JButton("NOWA");
        newSimulation.setBounds(120, 460, 100, 40);
        hurricaneVelocityLabel = new JLabel();
        hurricaneVelocityLabel.setText("Prędkość translacji [m/s]:");
        hurricaneVelocityLabel.setBounds(10, 4, 250, 35);

        forestDensityLabel = new JLabel();
        forestDensityLabel.setText("Gęstość lasu [ilość drzew/ha] :");
        forestDensityLabel.setBounds(10, 35, 250, 35);

        forestKindLabel = new JLabel();
        forestKindLabel.setText("Rodzaj lasu:");
        forestKindLabel.setBounds(10, 66, 250, 35);

        hurricaneAngleLabel = new JLabel();
        hurricaneAngleLabel.setText("Kąt przejścia huraganu");
        hurricaneAngleLabel.setBounds(10, 97, 250, 35);

        maxHurricaneRadiusLabel = new JLabel();
        maxHurricaneRadiusLabel.setText("Maksymalny promień huraganu");
        maxHurricaneRadiusLabel.setBounds(10, 127, 250, 35);

        maxTraversalVelocityLabel = new JLabel();
        maxTraversalVelocityLabel.setText("Maksymalna prędkość trawersalna huraganu");
        maxTraversalVelocityLabel.setBounds(10, 156, 265, 35);

        maxRadialVelocityLabel = new JLabel();
        maxRadialVelocityLabel.setText("Maksymalna prędkość radialna huraganu");
        maxRadialVelocityLabel.setBounds(10, 187, 250, 35);

        forrestSizeLabel = new JLabel();
        forrestSizeLabel.setText("Powierzchnia lasu [ha]");
        forrestSizeLabel.setBounds(10, 217, 250, 35);

        brokenTreeQuantityLabel = new JLabel("Ilość złamanych drzew: ");
        brokenTreeQuantityLabel.setBounds(10, 310, 200, 20);

        fallenTreeQuantityLabel = new JLabel("Ilość wyrwanych drzew: ");
        fallenTreeQuantityLabel.setBounds(10, 340, 200, 20);

        brokenTreeQuantity = new JLabel("0");
        brokenTreeQuantity.setBounds(220, 310, 50, 20);

        fallenTreeQuantity = new JLabel("0");
        fallenTreeQuantity.setBounds(220, 340, 50, 20);

        forestList = new JComboBox<>(FOREST_TYPE);
        forestList.setSelectedIndex(0);
        forestList.setBounds(270, 68, 99, 30);


        forestDensityTextField = new JTextField();
        forestDensityTextField.setBounds(270, 38, 100, 30);

        hurricaneVelocityTextField = new JTextField();
        hurricaneVelocityTextField.setBounds(270, 8, 100, 30);

        maxRadialVelocityTextField = new JTextField();
        maxRadialVelocityTextField.setBounds(270, 189, 100, 30);

        hurricaneAngleTextField = new JTextField();
        hurricaneAngleTextField.setBounds(270, 99, 100, 30);

        maxHurricaneRadiusTextField = new JTextField();
        maxHurricaneRadiusTextField.setBounds(270, 129, 100, 30);

        maxTraversalVelocityTextField = new JTextField();
        maxTraversalVelocityTextField.setBounds(270, 159, 100, 30);

        forrestSizeTextField = new JTextField();
        forrestSizeTextField.setBounds(270, 219, 100, 30);

        add(newHurricaneAngleLabel);
      //  add(newSimulation);
        add(newHurricaneAngle);
        add(startSimulate);
        add(forestDensityTextField);
        add(hurricaneVelocityLabel);
        add(hurricaneVelocityTextField);
        add(forestDensityLabel);
        add(startSimulate);
        add(forestKindLabel);
        add(forestList);
        add(hurricaneAngleLabel);
        add(maxHurricaneRadiusLabel);
        add(maxTraversalVelocityLabel);
        add(maxRadialVelocityLabel);
        add(maxRadialVelocityTextField);
        add(hurricaneAngleTextField);
        add(maxHurricaneRadiusTextField);
        add(maxTraversalVelocityTextField);
        add(brokenTreeQuantity);
        add(fallenTreeQuantity);
        add(brokenTreeQuantityLabel);
        add(fallenTreeQuantityLabel);
       // add(forrestSizeTextField);
    //    add(forrestSizeLabel);

        setSize(500, 400);
        setBounds(860, 45, 400, 550);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        startSimulate.addActionListener(this);
        forestList.addActionListener(this);
        newSimulation.addActionListener(this);

        newHurricaneAngle.addChangeListener(this);
        /**
         * Tutaj ładnie byłoby użyc switch-case ale cos sie psulo z tym a nie ma czasu kminic nad tym
         *
         */
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if ((source == startSimulate) && (getForestType() != null)) {
            checkStart = true;
            forestDensity = Integer.parseInt(forestDensityTextField.getText());
            hurricaneVelocity = Integer.parseInt(hurricaneVelocityTextField.getText());
            hurricaneAngle = Integer.parseInt(hurricaneAngleTextField.getText());
            newHurricaneAngle.setValue(hurricaneAngle);
            newHurricaneAngle.repaint();
            maxHurricaneRadius = Integer.parseInt(maxHurricaneRadiusTextField.getText());
            maxTraversalVelocity = Integer.parseInt(maxTraversalVelocityTextField.getText());
            maxRadialVelocity = Integer.parseInt(maxRadialVelocityTextField.getText());
       //     forrestSize = Integer.parseInt(forrestSizeTextField.getText());

        } else if (source == forestList) {
            if (forestList.getSelectedItem() == "Świerkowy") {
                forestType = ForestType.SPRUCE;
            } else if (forestList.getSelectedItem() == "Sosnowy") {
                forestType = ForestType.PINE;
            } else if (forestList.getSelectedItem() == "Mieszany") {
                forestType = ForestType.MIXED;
            }
        } else if (source == newSimulation) {
            checkNewSimulation = true;
        } else {
            showMessageDialog(null, "Nie wybrano rodzaju lasu");
        }

    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        JSlider source = (JSlider) changeEvent.getSource();
        if (!source.getValueIsAdjusting()) {
            hurricaneAngle = source.getValue();
        }
    }


    /**
     * @return zwraca gestosc lasu
     */
    public int getForestDensity() {
        return forestDensity;
    }

    /**
     * @return zwraca predkosc wiatru
     */
    public int getHurricaneVelocity() {
        return hurricaneVelocity;
    }

    /**
     * pomocnicze zeby sprawdzic kiedy zostalo cos wpisane
     *
     * @return
     */
    public boolean getCheckStart() {
        return checkStart;
    }

    public ForestType getForestType() {
        return forestType;
    }

    public int getHurricaneAngle() {
        return hurricaneAngle;
    }

    public int getMaxHurricaneRadius() {
        return maxHurricaneRadius;
    }

    public int getMaxTraversalVelocity() {
        return maxTraversalVelocity;
    }

    public int getMaxRadialVelocity() {
        return maxRadialVelocity;
    }

    public boolean getCheckNewSimulation() {
        return checkNewSimulation;
    }

    public int getForrestSize() {
        return forrestSize;
    }

    public void setCheckNewSimulation() {
        this.checkNewSimulation = false;
    }

    public void setCheckStart() {
        this.checkStart = false;
    }

    public void setBroktenTreeQuantity(int brokenTreeQuantity) {
        this.brokenTreeQuantity.setText(Integer.toString(brokenTreeQuantity));
    }

    public void setFallenTreeQuantity(int fallenTreeQuantity) {
        this.fallenTreeQuantity.setText(Integer.toString(fallenTreeQuantity));
    }
}

