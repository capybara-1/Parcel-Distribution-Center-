import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
public class MovingLines {
    private int x;
    private int y;
    private int width;
    private int height;
    private int xv;
    private boolean Run = false;

    public MovingLines(int x, int y, int width, int height, int xv){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xv = xv;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Run = !Run;
        }
    }
    public void move(){
        if (Run && x < 520) {
            xv++;
        }
        x += xv;
    }
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
      //  if (Run) {
            for (int i = x; i < x + width; i += 10) {
                g.drawLine(i, y + height / 2 - 50, i + 5, y + height / 2 - 50);
        //    }
        }
    }
}
