import java.awt.*;
import java.awt.geom.Path2D;

public class Facet {

    private R3Vector[] vertex;
    private Color color;

    public Facet(R3Vector v1, R3Vector v2, R3Vector v3, R3Vector v4 , Color color){
        this.color = color;
        vertex = new R3Vector[4];
        vertex[0] = v1; vertex[1] = v2; vertex[2] = v3; vertex[3] = v4;
    }

    public void show(){
        for (R3Vector r: vertex) {
            r.out();
        }
    }

    public void rotate(double x,double y,double z){
        for(int i = 0; i< vertex.length; i++){
             vertex[i].turn(x,y,z);
        }
    }

    public boolean normal(R3Vector a, R3Vector b, R3Vector c, R3Vector d){
        return light(new R3Vector(a.getX()+b.getX()+c.getX()+d.getX(), a.getY()+b.getY()+c.getY()+d.getY(), a.getZ()+b.getZ()+c.getZ()+d.getZ()));
    }

    public boolean light(R3Vector n){

        double foo = (n.getX()*0+n.getY()*0+n.getZ()*1)/(Math.sqrt(Math.pow(n.getX(),2) + Math.pow(n.getY(),2) + Math.pow(n.getZ(),2)) * Math.sqrt(1));

        //foo *= 180/Math.PI;
       //System.out.println(foo);
        if (foo < 0) return true;
        else return  false;
    }

    public R3Vector normal(){
        return null;
    }

    public void translate(double dx, double dy, double dz){
        for (R3Vector r: vertex) {
            r.translate(dx,dy,dz);
        }
    }

    public void scale(double k){
        for (R3Vector r: vertex) {
            r.scale(k);
        }
    }

    public R3Vector getV1(){
        return vertex[0];
    }

    public R3Vector getV2(){
        return vertex[1];
    }

    public R3Vector getV3(){
        return vertex[2];
    }

    public  R3Vector getV4(){
        return vertex[3];
    }

    public void draw(Graphics2D g){

        Path2D p = new Path2D.Double();

        p.moveTo(vertex[0].getX(), -vertex[0].getY());
        p.lineTo(vertex[1].getX(), -vertex[1].getY());
        p.lineTo(vertex[2].getX(), -vertex[2].getY());
        p.lineTo(vertex[3].getX(), -vertex[3].getY());
        p.lineTo(vertex[0].getX(),- vertex[0].getY());
        p.closePath();
        g.setColor(color);
        g.fill(p);
    }

    public void perspectiveDraw(Graphics2D g){
        Path2D p = new Path2D.Double();
        double bar = 1500;
        double t1 = -bar/(vertex[0].getZ() - bar);
        double t2 = -bar/(vertex[1].getZ() - bar);
        double t3 = -bar/(vertex[2].getZ() - bar);
        double t4 = -bar/(vertex[3].getZ() - bar);
        p.moveTo(vertex[0].getX()*t1, -vertex[0].getY()*t1);
        p.lineTo(vertex[1].getX()*t2, -vertex[1].getY()*t2);
        p.lineTo(vertex[2].getX()*t3, -vertex[2].getY()*t3);
        p.lineTo(vertex[3].getX()*t4, -vertex[3].getY()*t4);
        p.lineTo(vertex[0].getX()*t1,- vertex[0].getY()*t1);
        p.closePath();
        g.setColor(color);
        g.fill(p);
    }
}
