package api;
import java.util.HashMap; // import the HashMap class


public class Node implements NodeData{

    private int id;
    private GeoLocation location;
    private double weight;
    private String info;
    private int Tag;
    private NodeData father;


    public Node(int id,GeoLocation location){
        this.id=id;
        this.location= new Glocation(location.x(),location.y(),location.z());
        this.info=null;

    }

    @Override
    //Returns the key (id) associated with this node.
    public int getKey() {
        return this.id;
    }
    @Override
    //Returns the location of this node, if none return null.
    public GeoLocation getLocation() {
        if(this.location!=null){
            return this.location;}
        else{
            return null;}
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location=p;
    }

    @Override
    //Returns the weight associated with this node.
    public double getWeight() {
        return this.weight;
    }

    @Override
    //Returns the remark (meta data) associated with this node.
    public void setWeight(double w) {
        this.weight=w;

    }

    @Override
    public String getInfo() {
        return this.info ;
    }

    @Override
    public void setInfo(String s) {
        this.info=s;

    }

    public NodeData getFather() {
        return father;
    }

    public void setFather(NodeData father) {
        this.father = father;
    }

    @Override
    public int getTag() {
        return this.Tag;
    }

    @Override
    public void setTag(int t) {
        this.Tag=t;

    }

}
