 import java.awt.*;
 import java.awt.event.KeyEvent;

 public class Parcel {
    private int x;
    private int y;
    private int width;
    private int height;
    private int length;
    private int SpeedY;
    private int SpeedX;
    private int color;
    private int tru = 1;
    private boolean Up = false;
    private boolean down = false;
    private int on;

    public Parcel(int x, int y, int width, int length, int height, int SpeedX, int SpeedY, int color, int on){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.length = length;
        this.SpeedX = SpeedX;
        this.SpeedY = SpeedY;
        this.color = color;
        this.on = on;
    }
     public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_SPACE) {
             if (tru == 0){
                 tru = 1;
             }
             else if (tru == 1){
                 tru = 0;
             }
         }
     }
    public void move(){
        if (tru == 1 && (x + SpeedX > 0 || x + SpeedX < 520) && SpeedY == 0) {
            SpeedX = 1;
            SpeedX *= 1;
        } if (tru == 0){
            SpeedX = 0;
        }
        x = x + SpeedX;
    }
    public void moveup(){
        SpeedY = 1;
        SpeedX = 0;
        y = y - SpeedY;
    }
    public void moveDown(){
        SpeedX = 0;
        SpeedY = 1;
        y = y + SpeedY;
    }
    public void paint(Graphics g2d){
        if (color == 1){
            g2d.setColor(Color.green);
        }
        if (color == 2){
            g2d.setColor(Color.blue);
        }
        if (color == 3){
            g2d.setColor(Color.yellow);
        }
        g2d.fillRect(x, y, width, height);
        g2d.fillRect(x - length, y - length, width, height);

        for (int i = x; i < x + width; i++) {
            g2d.drawLine(i, y, i - length, y - length);
        }

        for (int k = y; k < y + height; k++) {
            g2d.drawLine(x, k, x - length, k - length);
        }
        g2d.setColor(Color.BLACK);
        g2d.drawLine(x, y, x - length, y - length);
        g2d.drawLine(x + width, y, x + width - length, y - length);
        g2d.drawLine(x, y + height, x - length, y + height - length);
        g2d.drawLine(x, y, x, y + height);
        g2d.drawLine(x - length, y - length, x - length, y + height - length);
        g2d.drawLine(x - length, y - length, x + width - length, y - length);
        g2d.drawLine(x, y, x + width, y);
        g2d.drawLine(x + width, y, x + width, y + height);
        g2d.drawLine(x, y + height, x + width, y + height);
    }
    public int getX(){
        return x;
    }
    public int getColor(){
        return color;
    }
    public void setUp(boolean temprn){
         Up = temprn;
    }
    public void setDown(boolean temprn){
        down = temprn;
    }
    public void setTru(int t){
        tru = t;
    }
    public boolean getUp(){
        return Up;
    }
    public boolean getDown(){
        return down;
    }
    public void setOn(int t){
        on = t;
    }
 }
