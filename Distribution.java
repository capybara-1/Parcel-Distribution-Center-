import javax.swing .*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;
import java.awt.event.KeyEvent;
public class Distribution extends JPanel {
    Parcel[] p = new Parcel[20];
    ConveyorBelt [] one = new ConveyorBelt[10];
    ConveyorBelt [] two = new ConveyorBelt[10];
    Scanner s;
    Light l;
    private boolean up = false;
    private boolean down = false;
    private int on = 1;

    private int x = 20;
    private int x1 = 520;

    public Distribution(){
        one[0] = new ConveyorBelt(0,250,1200,145,0);

        for (int i = 0; i < p.length; i++){
            p[i] = new Parcel(i * -200,320,(int) (Math.random() * 41) + 10,(int) (Math.random() * 31) + 20,(int) (Math.random() * 31) + 20,1,0,(int) ((int) (Math.random() * (3)) + 1),on);
            l = new Light(45,450,100,100,p[i].getX(),1);
        }
        for (int i = 1; i < one.length; i++){
            one[i] = new ConveyorBelt(0,250,1200,145,0);
            on = one[i].getOn();
            x = x + 20;
        }
        for (int i = 0; i < one.length; i++){
            two[i] = new ConveyorBelt(460,-200,145,10000,0);
            x1 = x1 + 20;
        }
        s = new Scanner(460, 250, 145,145,0, 0);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                for (Parcel o: p) {
                    o.keyPressed(e);
                }
                for (ConveyorBelt i: one){
                    i.keyPressed(e);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        setFocusable(true);
    }
    public void move(){
        for (Parcel e: p){
            e.move();
            if (e.getColor() == 1){
                if (e.getX() == 520){
                    s = new Scanner(460, 250, 145,145,1, e.getX());
                }
            }
            if (e.getColor() == 2){
                if (e.getX() == 520){
                    s = new Scanner(460, 250, 145,145,2,e.getX());
                    e.setTru(1);
                    e.setUp(true);
                }
            }
            if (e.getColor() == 3) {
                if (e.getX() == 520) {
                    s = new Scanner(460, 250, 145, 145, 3, e.getX());
                    e.setTru(1);
                    e.setDown(true);
                }
            }
            if (e.getUp() == true){
                e.moveup();
            }
            if (e.getDown() == true){
                e.moveDown();
            }
        }
        for (ConveyorBelt u: one){
            u.move();
        }
        for (ConveyorBelt i: two){
            i.move();
        }
    }
    public void paint(Graphics g ){
        super.paint(g);
        for (ConveyorBelt u: one){
            u.paint(g);
        }
        for (ConveyorBelt i: two){
            i.paint(g);
        }
        for (Parcel e: p){
            e.paint(g);
            l.paint(g);
        }
        s.paint(g);
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Parcel Distribution Assignment");
        Distribution panel = new Distribution();
        frame.add(panel);
        frame.setSize(1024, 640);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Distribution k = new Distribution();
        frame.add(k);
        Distribution l = new Distribution();
        frame.add(l);
        while (true) {
            panel.move();
            panel.repaint();
            Thread.sleep(10);
        }
    }
}
