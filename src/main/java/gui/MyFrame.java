package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{

    JButton buttonAdd;
    JButton buttonRemove;

    public MyFrame(){

        buttonAdd = new JButton();
        buttonAdd.setBounds(50,50, 150,50); //button place (x, y) and button size
        buttonAdd.addActionListener(this);
        buttonAdd.setText("ADD new todo");
        buttonAdd.setFocusable(false);
        buttonAdd.setHorizontalTextPosition(JButton.CENTER);
        buttonAdd.setVerticalTextPosition(JButton.CENTER);

        buttonRemove = new JButton();
        buttonRemove.setBounds(250,50, 150,50); //button place (x, y) and button size
        buttonRemove.addActionListener(this);
        buttonRemove.setText("REMOVE to do");
        buttonRemove.setFocusable(false);
        buttonRemove.setHorizontalTextPosition(JButton.CENTER);
        buttonRemove.setVerticalTextPosition(JButton.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500); // frame size
        this.setVisible(true); // makes frame visible
        this.add(buttonAdd); // adds button to frame
        this.add(buttonRemove); // adds button to frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("ADD new todo")){
            System.out.println("Adding new TASK");
        }
        else if (e.getActionCommand().equals("REMOVE to do")){
            System.out.println("Removing TASK");
        }

    }
}
