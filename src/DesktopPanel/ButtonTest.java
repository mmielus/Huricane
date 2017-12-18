package DesktopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ButtonTest extends JFrame {

    public int forestDensity = 0;
    public int windSpeed = 0;
    public boolean check;

    public ButtonTest() {
/**
 * Tu jest dodawanie przycików i pól do wpisywania to nawet nie patrzcie na to bo to nic waznego
 */
        JFrame f = new JFrame("Kalibracja");
        JButton b = new JButton("START");
        b.setBounds(100, 300, 140, 40);

        JLabel label = new JLabel();
        label.setText("Podaj prędkość wiatru :");
        label.setBounds(10, 10, 150, 100);

        JLabel label2 = new JLabel();
        label2.setText("Podaj gęstość lasu :");
        label2.setBounds(10, 60, 150, 100);


        JTextField textfield = new JTextField();
        textfield.setBounds(60, 70, 130, 30);

        JTextField textfield1 = new JTextField();
        textfield1.setBounds(60, 130, 130, 30);

        f.add(textfield);
        f.add(textfield1);
        f.add(label);
        f.add(label2);
        f.add(b);
        f.setSize(500, 400);
        f.setBounds(860, 50, 300, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                check = true;
                forestDensity = Integer.parseInt(textfield1.getText());
                windSpeed = Integer.parseInt(textfield.getText());
            }
        });
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
}

