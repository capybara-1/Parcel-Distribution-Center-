import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
public class ConveyorBelt {
    private int x;
    private int y;
    private int width;
    private int height;
    private int xv;
    private int tru = 0;
    private int on = 1;
    public ConveyorBelt(int x, int y, int width, int height, int xv){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xv = xv;
    }
    public void move(){
    /*    if (x < 520) {
            xv++;
        }
        x += xv;
     */
    }
    public void keyPressed(KeyEvent e) {
     if (e.getKeyCode() == KeyEvent.VK_SPACE){
         if (tru == 0){
             tru = 1;
         } else {
             tru = 0;
         }
     }
    }
    public int getOn(){
        return on;
    }
    public void paint(Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(x,y,width,height);
       // g.setColor(Color.WHITE);
        //for (int i = x; i < x + width; i += 10) {
          //  g.drawLine(i, y + height / 2, i + 5, y + height / 2);
        //}
        g.setColor(Color.RED);
        for (int i = y; i < y + height; i += 10) {
            g.drawLine(x + width / 2, i, x + width / 2, i + 5);
        }
        if (tru == 1){
            on = 0;
            g.setColor(Color.black);
        }
        if (tru == 0){
            on = 1;
            g.setColor(Color.green);
        }
        g.fillOval(x + 40 ,y - 80, 40 , 40);
    }
}
