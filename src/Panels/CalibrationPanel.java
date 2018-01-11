package Panels;

import Forest.ForestType;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class CalibrationPanel extends JFrame implements ActionListener {

    private JLabel windSpeedLabel;
    private JButton startSimulate;
    private JLabel forestDensityLabel;
    private JLabel forestKindLabel;
    private JComboBox<String> forestList;
    private JTextField windSpeedTextField;
    private JTextField forestDensityTextField;
    private JTextField forestKindTextField;
    public int forestDensity = 0;
    private int windSpeed = 0;
    private boolean check;
    private ForestType forestType;

    private static final String[] FOREST_TYPE = {"", "Świerkowy", "Sosnowy", "Mieszany"};

    public CalibrationPanel() {
/**
 * Tu jest dodawanie przycików i pól do wpisywania to nawet nie patrzcie na to bo to nic waznego
 */
        setTitle("Kalibracja");

        startSimulate = new JButton("START");
        startSimulate.setBounds(0, 300, 140, 40);

        windSpeedLabel = new JLabel();
        windSpeedLabel.setText("Podaj prędkość wiatru [m/s]:");
        windSpeedLabel.setBounds(10, 2, 250, 35);

        forestDensityLabel = new JLabel();
        forestDensityLabel.setText("Podaj gęstość lasu [ilość drzew/10ha] :");
        forestDensityLabel.setBounds(10, 30, 250, 35);

        forestKindLabel = new JLabel();
        forestKindLabel.setText("Wybierz rodzaj lasu:");
        forestKindLabel.setBounds(10, 61, 250, 35);

        forestList = new JComboBox<>(FOREST_TYPE);
        forestList.setSelectedIndex(0);
        forestList.setBounds(240, 65, 99, 30);

        windSpeedTextField = new JTextField();
        windSpeedTextField.setBounds(240, 5, 100, 30);

        forestDensityTextField = new JTextField();
        forestDensityTextField.setBounds(240, 35, 100, 30);

        forestKindTextField = new JTextField();
        forestKindTextField.setBounds(240, 5, 100, 30);

        add(startSimulate);
        add(windSpeedTextField);
        add(forestDensityTextField);
        add(windSpeedLabel);
        add(forestDensityLabel);
        add(startSimulate);
        add(forestKindLabel);
        add(forestList);
        setSize(500, 400);
        setBounds(860, 45, 400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        startSimulate.addActionListener(this);
        forestList.addActionListener(this);
        /**
         * Tutaj ładnie byłoby użyc switch-case ale cos sie psulo z tym a nie ma czasu kminic nad tym
         *
         */
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();

        if (source == startSimulate) {
            check = true;
            forestDensity = Integer.parseInt(forestDensityTextField.getText());
            windSpeed = Integer.parseInt(windSpeedTextField.getText());
        } else if (source == forestList) {
            if (forestList.getSelectedItem() == "Świerkowy") {
                forestType = ForestType.SPRUCE;
            } else if (forestList.getSelectedItem() == "Sosnowy") {
                forestType = ForestType.PINE;
            } else if (forestList.getSelectedItem() == "Mieszany") {
                forestType = ForestType.MIXED;
            } else {
                showMessageDialog(null, "Nie wybrano rodzaju lasu");
            }
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
    public int getWindSpeed() {
        return windSpeed;
    }

    /**
     * pomocnicze zeby sprawdzic kiedy zostalo cos wpisane
     *
     * @return
     */
    public boolean getCheck() {
        return check;
    }

    public ForestType getForestType() {
        return forestType;
    }
}

