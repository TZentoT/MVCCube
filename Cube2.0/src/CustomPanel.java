import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private Cube c;
    private int number=0;
    private String str = "X: 0 ; Y: 0 ;";

    public  CustomPanel(Cube  c){
        super();
        //this.setLayout(null);
        this.setSize(1200,800);
        this.c = c;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public void setStr(int n, int n2){
        int barX =0 , barY =0;
        this.str = "X: " + n + "; Y: " + n2 + ";";
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0,0,2000,2000);
        g2d.drawString(str,20,20);
        g2d.translate(this.getWidth()/2,this.getHeight()/2);
        g2d.drawLine(-this.getWidth()/2,0,this.getWidth()/2,0);
        g2d.drawLine(0,getHeight()/2,0,-this.getHeight()/2);
        if (getNumber() == 1) c.draw(g2d);
        else if (getNumber() == 2) c.perspectiveDraw(g2d);
    }
}
