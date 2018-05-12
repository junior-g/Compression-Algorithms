/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic.compression;

/**
 *
 * @author abis
 */
import java.io.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;
 
public class Gui extends JPanel implements ActionListener {
    JButton compB, decompB;
    JFileChooser f;
    public Gui() {
        super(new BorderLayout());
        //Create a file chooser
        f = new JFileChooser();
        compB = new JButton("Compress");
        compB.addActionListener(this);
        decompB = new JButton("Decompress");
        decompB.addActionListener(this);
        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(compB);
        buttonPanel.add(decompB);        
        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
    }
 
    public void actionPerformed(ActionEvent e) {
        // when open is clicked
        if (e.getSource() == compB) {
             
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(Gui.this);
            Files f = new Files();
            String s = null;
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                s = file.getPath();
                s = f.editPath(s);
            } else {
            }
            ArithmeticCompression obj = new ArithmeticCompression();
            obj.compression(f.readCompress(s), s);
          
        //when save is clicked
        } else if (e.getSource() == decompB) {
            final JFileChooser fc = new JFileChooser();
            int returnVal = fc.showOpenDialog(fc);
            String s = null;
            Files f = new Files();
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                s = file.getPath();
                s = f.editPath(s);
            } else {
            }
            ArrayList<String> c = new ArrayList<String>();
            ArrayList<Double> d = new ArrayList<Double>();
            double data = 0.0;
            int len = 0;
            Files obj1 = new Files();
            obj1.readDecompress(s, data, len, c, d);
         
        }
 
    }
 
    /////////////////////
 
    ////////////////////
     
     
    public static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add content to the window.
        frame.add(new Gui());
 
        //Display the window.
        frame.pack();
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
