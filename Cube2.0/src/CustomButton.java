import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

public class CustomButton extends JButton implements Observer {

    private Cube c;
    private CustomPanel panel;
    private static int buttonCount=0;
    private int number =0;

    public CustomButton(Cube c , CustomPanel panel){
        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);
        this.setSize(100,100);
        this.c = c;
        this.panel = panel;
        ++buttonCount;
        number = buttonCount;

    }

    @Override
    public void update(Observable o, Object arg) {
        // if ("1" == (String) arg) System.out.println(1);
        c = (Cube) o;
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
           if (number == 1) panel.setNumber(number);
           else if (number == 2) panel.setNumber(number);
           panel.repaint();
        }
    }
}
