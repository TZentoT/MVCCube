import java.awt.*;
import java.util.Observable;

public class Cube extends Observable {

    private Facet[] facets ;

    public Cube(){
        facets = new Facet[6];
        facets[0] = new Facet(new R3Vector(0,0,0), new R3Vector(1,0,0), new R3Vector(1,1,0),new R3Vector(0,1,0), Color.cyan);
        facets[1] = new Facet(new R3Vector(0,0,0), new R3Vector(0,0,1), new R3Vector(1,0,1),new R3Vector(1,0,0), Color.black);
        facets[2] = new Facet(new R3Vector(0,0,0), new R3Vector(0,1,0), new R3Vector(0,1,1),new R3Vector(0,0,1),Color.magenta);
        facets[3] = new Facet(new R3Vector(1,1,1), new R3Vector(1,1,0), new R3Vector(1,0,0),new R3Vector(1,0,1), Color.DARK_GRAY);
        facets[4] = new Facet(new R3Vector(1,1,1), new R3Vector(1,0,1), new R3Vector(0,0,1),new R3Vector(0,1,1), Color.BLUE);
        facets[5] = new Facet(new R3Vector(1,1,1), new R3Vector(0,1,1), new R3Vector(0,1,0),new R3Vector(1,1,0), Color.GREEN);
    }

    public void show(){
        for (Facet f: facets) {
            f.show();
        }
    }

    public void scale(double k){
        for (Facet f: facets) {
            f.scale(k);
        }
    }

    public void translate(double dx, double dy, double dz){
        for ( Facet f: facets) {
            f.translate(dx,dy,dz);
        }
    }

    public void  rotate(double x,double y,double z){
        for (Facet f: facets) {
            f.rotate(x,y,z);
        }
    }

    static int i =0;
    public void draw(Graphics2D g){
        for (Facet f: facets) {
            if (f.normal(f.getV1(),f.getV2(),f.getV3(), f.getV4()) == true ){
                f.draw(g);
                //System.out.println(++i);
            }
            else continue;
        }
    }

    public void perspectiveDraw(Graphics2D g) {
        for (Facet f : facets) {
                if (f.normal(f.getV1(),f.getV2(),f.getV3(), f.getV4()) == true ){
                f.perspectiveDraw(g);
                System.out.println(++i);
            }
            else continue;
        }
    }
}
