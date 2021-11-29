import java.awt.Color;

/**
 * Write a description of class FlippedWarholFilter here.
 *
 * @author Yixuan Sun
 * @version 2021.11.29
 */
public class FlippedWarholFilter extends Filter
{
    // instance variables - replace the example below with your own
     
    /**
     * Constructor for objects of class FlippedWarholFilter
     */
    public FlippedWarholFilter(String name)
    {
        // initialise instance variables
        super(name);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight()/2;
        int width = image.getWidth()/2;
        OFImage original = new OFImage(image);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = original.getPixel(x * 2, y * 2);
                image.setPixel(x,y,pixel);
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = width; x < width * 2; x++) {
                Color pixel = original.getPixel((width - (x - width)) * 2 - 1, y * 2);
                int redAmount = pixel.getRed();
                image.setPixel(x,y, new Color(redAmount, 0, 0));
            }
        }
        
        for(int y = height; y < height * 2; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = original.getPixel(x * 2, (height - (y - height)) * 2 - 1);
                int greenAmount = pixel.getGreen();
                image.setPixel(x,y, new Color(0, greenAmount, 0));
            }
        }
        
        for(int y = height; y < height * 2; y++) {
            for(int x = width; x < width * 2; x++) {
                Color pixel = original.getPixel((width - (x - width)) * 2 - 1, (height - (y - height)) * 2 - 1);
                int blueAmount = pixel.getBlue();
                image.setPixel(x,y, new Color(0, 0, blueAmount));
            }
        }
    }
}