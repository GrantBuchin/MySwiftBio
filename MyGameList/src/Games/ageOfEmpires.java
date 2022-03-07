package Games;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ageOfEmpires {


    public static Component aoe() {
        // get image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\gbuch\\Pictures\\Java 1 Images\\aoe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // make panel to insert to main frame
        JPanel aoePanel = new JPanel();
        aoePanel.setLayout(new BorderLayout());
        // rebuffer  image to set size then set as imageIcon
        Image dimg = img.getScaledInstance(350, 350,
                Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        // add image
        JLabel aoeImage = new JLabel(imageIcon);
        //set image south
        aoePanel.add(aoeImage, BorderLayout.SOUTH);

        JTextArea aoeBio = new JTextArea("This is Age of Empires, The original came out in 1998 and had one expansion called the Rise of Rome" +
                "Personally I loved the Rise of Rome expansion the most! With the added building queue and few units like" +
                "Slingers and Armored Elephants and Sythe a variety of strategies arose! One my favorites being the" +
                "Iron age Sythe Rush or even the Slinger tool rush! I grew up with this game, it is one of my forever to be " +
                "childhood favorites!");
        //Text placement to north and text settings
        aoePanel.add(aoeBio, BorderLayout.NORTH);
        aoeBio.setLineWrap(true);
        aoeBio.setWrapStyleWord(true);
        aoeBio.setEditable(false);
        aoeBio.setOpaque(false);
        aoeBio.setFont(new Font("Arial", Font.PLAIN, 14));
        return aoePanel;
    }
}
