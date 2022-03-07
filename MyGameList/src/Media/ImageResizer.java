package Media;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

    /**
     * This program demonstrates how to resize an image.
     *
     * @author www.codejava.net
     *
     */
    public class ImageResizer {

        /**
         * Resizes an image to a absolute width and height (the image may not be
         * proportional)
         * @param inputImagePath Path of the original image
         * @param scaledWidth absolute width in pixels
         * @param scaledHeight absolute height in pixels
         * @throws IOException
         */
        public static void resize(String inputImagePath, int scaledWidth, int scaledHeight)
                throws IOException {
            // reads input image
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);

            // creates output image
            BufferedImage outputImage = new BufferedImage(scaledWidth,
                    scaledHeight, inputImage.getType());

            // scales the input image to the output image
            Graphics2D g2d = outputImage.createGraphics();
            g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();
        }

        /**
         * Resizes an image by a percentage of original size (proportional).
         * @param inputImagePath Path of the original image
         * @param percent a double number specifies percentage of the output image
         * over the input image.
         * @throws IOException
         */
        public static void resize(String inputImagePath, double percent) throws IOException {
            File inputFile = new File(inputImagePath);
            BufferedImage inputImage = ImageIO.read(inputFile);
            int scaledWidth = (int) (inputImage.getWidth() * percent);
            int scaledHeight = (int) (inputImage.getHeight() * percent);
            resize(inputImagePath, scaledWidth, scaledHeight);
        }



        /**
         * Test resizing images
         */
        public static void main(String[] args) {
            String inputImagePath = "D:/Photo/Puppy.jpg";

            try {
                // resize to a fixed width (not proportional)
                int scaledWidth = 1024;
                int scaledHeight = 768;
                ImageResizer.resize(inputImagePath, scaledWidth, scaledHeight);

                // resize smaller by 50%
                double percent = 0.5;
                ImageResizer.resize(inputImagePath, percent);

                // resize bigger by 50%
                percent = 1.5;
                ImageResizer.resize(inputImagePath, percent);

            } catch (IOException ex) {
                System.out.println("Error resizing the image.");
                ex.printStackTrace();
            }
        }

    }

