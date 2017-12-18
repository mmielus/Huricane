package DesktopPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonPanel extends JPanel implements ActionListener {

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonPanel() {
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);
        //greenButton.setBounds(200,500,100,100);
        setLayout(null);

        JLabel label = new JLabel();
        JTextField textfield= new JTextField();
        JLabel label1 = new JLabel();
        setPreferredSize(new Dimension(200, 600));
     //   add(greenButton);
  //      greenButton.setBounds(50, 450, 100, 50);
//        add(label);
//        label.setText("podaj prędkośc wiatru :");
//        label.setBounds(0, 100, 100, 100);
      //  add(textfield);
     //   textfield.setBounds(0, 50, 130, 30);
//        add(label1);




//

//        label1.setText("podaj gestosc powietrza :");




        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}