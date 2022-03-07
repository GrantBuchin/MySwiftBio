package Games;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Media.ImageResizer;

public class Doom extends JPanel{

    public static Component doomII() {

        // get image
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("C:\\Users\\gbuch\\Pictures\\Java 1 Images\\doom2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // make panel to insert to main frame
        JPanel doomPanel = new JPanel();
        doomPanel.setLayout(new BorderLayout());

        // rebuffer  image to set size then set as imageIcon
        Image dimg = img.getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);

        JTextArea doomBio = new JTextArea("This is Doom, in particular doom 2! I grew up off of this one as well. " +
                "my cousin often would play this with me when we were little on the computer. I usually held down the " +
                "shift key so we could constantly run and sprint around the map. It brings back alot of childhood memories!");
        // add image
        JLabel doomImage = new JLabel(imageIcon);
        //set image south
        doomPanel.add(doomImage, BorderLayout.SOUTH);
        //Text placement to north and text settings
        doomPanel.add(doomBio, BorderLayout.NORTH);
        doomBio.setLineWrap(true);
        doomBio.setEditable(false);
        doomBio.setWrapStyleWord(true);
        doomBio.setOpaque(false);
        doomBio.setFont(new Font("Arial", Font.PLAIN, 14));
        return doomPanel;
    }
}
