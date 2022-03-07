package MainFrame;

import Games.ageOfEmpires;
import Games.Doom;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGameList extends JFrame {
    // call games to get list when game chosen from list.
    // game list
    private final JList list;
    // button for selection
    private final JButton button;
    JPanel centerPanel = new JPanel(new BorderLayout());
    JPanel centerSouth = new JPanel(new FlowLayout());

    public MyGameList() {

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(1250, 770));

        // title
        JLabel titleLabel = new JLabel("Grants Game List!");
        titleLabel.setPreferredSize(new Dimension(175, 100));
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        // panel to set north for title.
        JPanel titleTop = new JPanel();
        // set color to BLUE to see position of panel.
//        titleTop.setBorder(new LineBorder(Color.BLUE));
        // Add titleTop to top of frame
        this.add(titleTop, BorderLayout.NORTH);
        // Add title Label to titleTop and set Center for title
        titleTop.add(titleLabel, BorderLayout.CENTER);

        //List
        Object[] data = {"Age of Empires", "Doom 2", "Dynasty Warriors 5", "Call of Duty", "Knight of the old republic"};
        list = new JList(data);
        //listener for enable button
        list.addListSelectionListener(this::listSelection);

        // button to get page
        button = new JButton("Let's Go");

        //disable button until selection is made
        button.setEnabled(false);
        button.addActionListener(new DrawListener());

        //add center panel to put list and button into. This allows title by self at top.
        this.add(centerPanel, BorderLayout.CENTER);
//        centerPanel.setBorder(new LineBorder(Color.yellow));

        // add intro later to this panel.
        JPanel centerNorth = new JPanel(new BorderLayout());
        // add centerNorth panel to north in centerPanel
        centerPanel.add(centerNorth, BorderLayout.NORTH);

        // add intro to textField for display in centerNorth panel
        JTextArea Intro = new JTextArea();
        Intro.setText("Hello! I am Grant. I am making this small series of pages to help myself" +
                "learn more about java swing and java in general." +
                " This page composes of a list of games I enjoy playing. " +
                "Please select one and it should take you to a page to explain the game briefly!");
        Intro.setLineWrap(true);
        Intro.setEditable(false);
        Intro.setBorder(new EmptyBorder(1, 1, 1, 1));
        Intro.setOpaque(false);
        Intro.setFont(new Font("Arial", Font.PLAIN, 16));

        // add intro to center north panel under title.
        centerNorth.add(Intro, BorderLayout.NORTH);

        // add list and button to centerNorth panel
        centerNorth.add(list, BorderLayout.CENTER);
        centerNorth.add(button, BorderLayout.EAST);

        //set centerSouth panel to south in centerPanel used for option selected.
        centerPanel.add(centerSouth, BorderLayout.SOUTH);
//        centerSouth.setBorder(new LineBorder(Color.BLACK));
    }

    // If selection had been made, enable button
    public void listSelection(ListSelectionEvent e) {
        button.setEnabled(list.getSelectedIndex() != -1);
    }

    private class DrawListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            centerSouth.removeAll();
            if (list.getSelectedIndex() == 0){
                centerSouth.add(ageOfEmpires.aoe());
            }

            if (list.getSelectedIndex() == 1){
                centerSouth.add(Doom.doomII());
            }
            revalidate();
            repaint();
        }
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new MyGameList();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}


