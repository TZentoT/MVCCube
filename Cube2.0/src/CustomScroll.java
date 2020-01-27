import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Observable;
import java.util.Observer;


public class CustomScroll extends JScrollBar implements Observer {

    private Cube c;
    private CustomPanel panel;
    private static int buttonCount=0;
    private int number =0;

    public CustomScroll(Cube c , CustomPanel panel){
        ScrollListener listener = new ScrollListener();
        this.addAdjustmentListener( listener);
        this.c = c;
        this.panel = panel;
        ++buttonCount;
        number = buttonCount;
        setValue(0);
        setMinimum(-1);
        setMaximum(49);
    }

    @Override
    public void update(Observable o, Object arg) {
        c = (Cube) o;
    }
    int temp = 0;
    static int fooX = 0, fooY = 0;
    private class ScrollListener implements AdjustmentListener {
        public void adjustmentValueChanged(AdjustmentEvent e){
            if ( temp <= getValue()){
                temp++;
                System.out.println(getValue());
                if (number == 1){ c.rotate(10,0,0);
                    fooY = temp*10;
                }
                else if (number == 2){ c.rotate(0,10,0);
                    fooX = temp*10;
                }
                panel.repaint();
            }
            else {
                temp--;
                if (number == 1){ c.rotate(-10,0,0);
                    fooY = temp*10;
                }
                else if (number == 2){ c.rotate(0,-10,0);
                    fooX = temp*10;
                }
                panel.repaint();
            }
            panel.setStr(fooX,fooY);
        }
    }
}
