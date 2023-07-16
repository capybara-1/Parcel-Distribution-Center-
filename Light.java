import java.awt.*;
import java.awt.event.KeyEvent;

public class Light {
    private int x;
    private int y;
    private int width;
    private int height;
    private int parcelX;
    private int colour;
    private boolean Run = false;

    public Light(int x, int y, int width, int height, int parcelX, int colour){
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.parcelX = parcelX;
        this.colour = colour;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Run = !Run;
        }
    }
    public void setColour(int t){
        colour = t;
    }
    public void paint(Graphics g2d){
        if (colour == 2){
            g2d.setColor(Color.green);
        } if (colour == 1){
            g2d.setColor(Color.red);
        }
        g2d.fillRect(45,100,50,50);
    }

}
