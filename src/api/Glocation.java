package api;

public class Glocation implements GeoLocation{
    private double x;
    private double y;
    private double z;



    public Glocation(double x, double y, double z) {
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public double x() {
        return this.x;
    }

    @Override
    public double y() {
        return this.y;
    }

    @Override
    public double z() {
        return this.z;
    }

    @Override
    public double distance(GeoLocation g) {
        double dx=this.x-g.x();
        double dy=this.y-g.y();
        double dz=this.z-g.z();
        dx*=dx;
        dy*=dy;
        dz*=dz;
        double dist=dx+dy+dz;
        return Math.sqrt(dist);
    }
}
