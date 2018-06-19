package model;

import java.util.Objects;

public class Variant {
    private int varNumber;
    private int m;
    private int i;
    private int pi;
    private int Fo;
    private String Ep;
    private Answers answers;


    public Variant(String text) {
        String[] line = text.split(" ");
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

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
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
