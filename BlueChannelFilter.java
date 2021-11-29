import java.awt.Color;

/**
 * Write a description of class BlueChannelFilter here.
 *
 * @author Yixuan Sun
 * @version 2021.11.29
 */
public class BlueChannelFilter extends Filter
{
    // instance variables - replace the example below with your own
     
    /**
     * Constructor for objects of class BlueChannelFilter
     */
    public BlueChannelFilter(String name)
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
    public void apply (OFImage image)
    {
        // put your code here
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int blueAmount = pixel.getBlue();
                image.setPixel(x,y,new Color(blueAmount, blueAmount, blueAmount));
            }
        }
    }
}
