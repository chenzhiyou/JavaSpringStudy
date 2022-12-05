package spring_transaction.entity;


public class Fruits {
    private int fid;
    private String fname;
    private String spec;
    private double up;
    private String t1;
    private String t2;
    private int inum;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public double getUp() {
        return up;
    }

    public void setUp(double up) {
        this.up = up;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getInum() {
        return inum;
    }

    public void setInum(int inum) {
        this.inum = inum;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "fid=" + fid +
                ", fname='" + fname + '\'' +
                ", spec='" + spec + '\'' +
                ", up=" + up +
                ", t1='" + t1 + '\'' +
                ", t2='" + t2 + '\'' +
                ", inum=" + inum +
                '}';
    }
}
