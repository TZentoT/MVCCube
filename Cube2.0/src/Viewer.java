import javax.swing.*;
import java.awt.*;

public class Viewer extends JFrame {

    private Cube c;

    public  Viewer(Cube  c){
        this.setSize(1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setVisible(true);
        this.c = c;
    }

    @Override
    public void paint(Graphics g){
       Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,2000,2000);
        g2d.translate(this.getWidth()/2,this.getHeight()/2);
        g2d.drawLine(-this.getWidth()/2,0,this.getWidth()/2,0);
        g2d.drawLine(0,getHeight()/2,0,-this.getHeight()/2);
        //c.draw(g2d);
        c.perspectiveDraw(g2d);
    }

}
