package api;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Gui extends JFrame implements ActionListener{
    private DirectedWeightedGraph graph;
    private DirectedWeightedGraphAlgorithms Algograph;
    private JMenuBar menuBar;
    private JMenu file, func, edit;
    private JMenuItem exit, load, save, addE, addN, removeE, removeN, center, shortest, TSP;

    ImageIcon icon = new ImageIcon("src//api//plus_2795.png");

    public Gui () {
        this.graph = graph;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 700);
        this.setTitle("Menus");
        this.setVisible(true);
        this.setLayout (new FlowLayout());


        menuBar = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        func = new JMenu("Functions");
        removeN = new JMenuItem("Remove Node");
        addN = new JMenuItem("Add Node");
        removeE = new JMenuItem("Remove Edge");
        addE = new JMenuItem("Add Edge");
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");
        center = new JMenuItem("Is Center");
        shortest = new JMenuItem("Shortest Path");
        TSP = new JMenuItem("TSP");


        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(func);
        edit.add(removeN);
        edit.add(addN);
        edit.add(removeE);
        edit.add(addE);
        file.add(load);
        file.add(save);
        file.add(exit);
        func.add(center);
        func.add(shortest);
        func.add(TSP);


        load.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);
        shortest.addActionListener(this);
        center.addActionListener(this);
        TSP.addActionListener(this);
        addN.addActionListener(this);
        addE.addActionListener(this);
        removeN.addActionListener(this);
        removeE.addActionListener(this);


        file.setMnemonic(KeyEvent.VK_F); // Alt + f for file
        edit.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
        func.setMnemonic(KeyEvent.VK_H); // Alt + h for help
        load.setMnemonic(KeyEvent.VK_L); // l for load
        save.setMnemonic(KeyEvent.VK_S); // s for save
        exit.setMnemonic(KeyEvent.VK_E); // e for exit

    }


   /* public void actionPerformed (ActionEvent e) {
    }*/
    //public class AddGraphListener implements ActionListener {

    //public class ExitOnClick implements ActionListener{




    public static void main(String[] args) {
        new Gui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}