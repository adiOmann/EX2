package api;

import java.util.HashMap;

public class Edge implements EdgeData {

    private int Src;
    private int Dest;
    private double Weight;
    private String Info;
    private int Tag;


    public Edge (int src, int dest, double weight) {
        this.Src = src;
        this.Dest = dest;
        this.Weight = weight;
    }

    @Override
    public int getSrc() {
        return this.Src;
    }

    @Override
    public int getDest() {
        return this.Dest;
    }

    @Override
    public double getWeight() {
        return this.Weight;
    }

    @Override
    public String getInfo() {
        return this.Info;
    }

    @Override
    public void setInfo(String s) {
        this.Info=s;

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
