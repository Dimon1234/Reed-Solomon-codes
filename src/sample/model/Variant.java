package model;

import java.util.Objects;

public class Variant {
    private int varNumber;
    private int m;
    private  int i;
    private int pi;
    private int Fo;
    private String Ep;

    public Variant(int varNumber, int m, int i, int pi, int fo, String ep) {
        this.varNumber = varNumber;
        this.m = m;
        this.i = i;
        this.pi = pi;
        Fo = fo;
        Ep = ep;
    }

    public Variant(String[] line)
    {
        this.varNumber = Integer.parseInt(line[0]);
        this.m = Integer.parseInt(line[1]);
        this.i = Integer.parseInt(line[2]);
        this.pi = Integer.parseInt(line[3]);
        this.Fo = Integer.parseInt(line[4]);
        this.Ep = line[5];
    }

    public int getVarNumber() {
        return varNumber;
    }

    public int getM() {
        return m;
    }

    public int getI() {
        return i;
    }

    public int getPi() {
        return pi;
    }

    public int getFo() {
        return Fo;
    }

    public String getEp() {
        return Ep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variant variant = (Variant) o;
        return varNumber == variant.varNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(varNumber);
    }

    @Override
    public String toString() {
        return "Variant{" +
                "m=" + m +
                ", i=" + i +
                ", pi=" + pi +
                ", Fo=" + Fo +
                ", Ep='" + Ep + '\'' +
                '}';
    }
}
