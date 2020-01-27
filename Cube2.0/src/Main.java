import javax.swing.*;
import java.awt.*;

public class Main  extends JFrame {

    public static void main(String[] args){
        new Main();
    }

    public Main(){
        this.setTitle("Cube");
        this.setBounds(15,15,1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Cube c = new Cube();
        CustomPanel panel = new CustomPanel(c);// Viewer
        JPanel panel2 = new JPanel();
        CustomButton button = new CustomButton(c, panel);// Controller №1
        CustomButton button2 = new CustomButton(c, panel);// Controller №2

        CustomScroll scroll = new CustomScroll(c, panel);
        CustomScroll scroll2 = new CustomScroll(c, panel);

        c.addObserver(button);
        c.addObserver(button2);

        scroll2.setOrientation(Scrollbar.HORIZONTAL);

        this.getContentPane().add(scroll, BorderLayout.EAST);
        this.getContentPane().add(scroll2, BorderLayout.SOUTH);
        this.getContentPane().add(panel2, BorderLayout.NORTH);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        panel2.add(button);
        panel2.add(button2);
        button.setText("Orthogonal");
        button2.setText("Perspective");

        c.scale(100);
        c.translate(-50,-50,-50);
        //c.rotate(45,45,45);
        //Viewer window = new Viewer( c);
        this.setVisible(true);
    }
}
