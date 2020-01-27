public class R3Vector {
    private  double x,y,z;

    public R3Vector(double x, double y, double z){
        this.x =x ; this.y =y; this.z= z;

    }

    public void out(){
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }

    public R3Vector sum(R3Vector a){
       return new R3Vector(this.x+a.x, this.y+a.y, this.z+a.z);
    }

    public  static  R3Vector sum (R3Vector a ,R3Vector b){
        return new R3Vector(a.x+b.x, a.y+b.y, a.z+b.z);
    }

    public void scale(double k){ this.x*=k ; this.y*=k;this.z*=k; }

    public void translate(double dx,double dy,double dz ){
        this.x+=dx; this.y+=dy;this.z+=dz;
    }
    public static void scalarOp(R3Vector a, R3Vector b, double cos){
        System.out.println(Math.sqrt((Math.pow(a.x,2) + Math.pow(a.y,2) + Math.pow(a.z,2)) * Math.sqrt(Math.pow(b.x,2) + Math.pow(b.y,2) + Math.pow(b.z,2)))*Math.cos(cos));
    }

    public R3Vector vectorOp(R3Vector a){
        return new R3Vector(y*a.z-a.y*z , x*a.z-a.x*z, x*a.y-a.x*y);
    }


//    public R3Vector rotateZ(double u){
//        R3Vector r = new R3Vector(0,0,1);
//        return sum(this , scalarOp(r,this,Math.tan(45/2)));
//    }

    public void turnZ(double u){
        //return new R3Vector(x*Math.cos(u*(Math.PI/180)) - y*Math.sin(u*(Math.PI/180)),-x*Math.sin(u*(Math.PI/180)) + y*Math.cos(u*(Math.PI/180)),z);
        double c = u * Math.PI /180;
        double x1 = x;
        x = x1* Math.cos(c) - y* Math.sin(c);
        y = x1* Math.sin(c) + y* Math.cos(c);
    }

    public void turnY(double u){
        //return new R3Vector(x*Math.cos(u*(Math.PI/180)) + z*Math.sin(u*(Math.PI/180)),y,-x*Math.sin(u*(Math.PI/180)) + z*Math.cos(u*(Math.PI/180)));
        double c = u * Math.PI /180;
        double x1 = x;
        x = x1* Math.cos(c) - z* Math.sin(c);
        z = x1* Math.sin(c) + z* Math.cos(c);
    }

    public void turnX(double u){
        //return new R3Vector(x,z*Math.sin(u*(Math.PI/180)) + y*Math.cos(u*(Math.PI/180)),z*(-y*Math.sin(u*Math.PI/180)+z*Math.cos(u*Math.PI/4)));
        double c = u * Math.PI /180;
        double z1 = z;
        z = z1* Math.cos(c) - y* Math.sin(c);
        y = z1* Math.sin(c) + y* Math.cos(c);
    }

    public void turn(double ux, double uy, double uz){

         turnX(ux);
         turnY(uy);
         turnZ(uz);
    }

    public void setX(double x){ this.x = x; }
    public void setY(double y){ this.y = y; }
    public void setZ(double z){ this.z = z; }

    public double getX(){ return  this.x;}
    public double getY(){ return  this.y;}
    public double getZ(){ return  z;}

}
