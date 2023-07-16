import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
public class Scanner {
    private int x;
    private BufferedImage img = null;
    private int y;
    private int height;
    private int width;
    private int parcelX;
    private int check;
    public Scanner(int x, int y, int height, int width, int check, int parcelX) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.check = check;
        this.parcelX = parcelX;
            if (check == 1) {
                try {
                    img = ImageIO.read(new File("res\\truck.png"));
                } catch (IOException e) {
                    System.out.println("ERROR");
                }
            }
            if (check == 2) {
                try {
                    img = ImageIO.read(new File("res\\plane.png"));
                } catch (IOException e) {
                    System.out.println("ERROR");
                }
            }
            if (check == 3) {
                try {
                    img = ImageIO.read(new File("res\\question.png"));
                } catch (IOException e) {
                    System.out.println("ERROR");
                }
            }
        }
    public void paint(Graphics g2d){
        g2d.setColor(Color.black);
        g2d.fillRect(x,y,width,height);
        g2d.drawImage(img, 45,450,125,125,null);
    }
}