/**
 * Created by 15 on 17.08.2018.
 */
public class RowPeptideWithB {
    private String peptide;
    private double b_60;
    private double b_60NL;
    private double b_minus10;
    private double b_minus20;
    private double b_plus10;
    private double b_plus20;
    private double b_plus30;
    private double b_plus40;

    public RowPeptideWithB(String peptide, double b_60, double b_60NL, double b_minus10, double b_minus20, double b_plus10, double b_plus20, double b_plus30, double b_plus40) {
        this.peptide = peptide;
        this.b_60 = b_60;
        this.b_60NL = b_60NL;
        this.b_minus10 = b_minus10;
        this.b_minus20 = b_minus20;
        this.b_plus10 = b_plus10;
        this.b_plus20 = b_plus20;
        this.b_plus30 = b_plus30;
        this.b_plus40 = b_plus40;
    }

    public String getPeptide() {
        return peptide;
    }

    public void setPeptide(String peptide) {
        this.peptide = peptide;
    }

    public double getB_60() {
        return b_60;
    }

    public void setB_60(double b_60) {
        this.b_60 = b_60;
    }

    public double getB_60NL() {
        return b_60NL;
    }

    public void setB_60NL(double b_60NL) {
        this.b_60NL = b_60NL;
    }

    public double getB_minus10() {
        return b_minus10;
    }

    public void setB_minus10(double b_minus10) {
        this.b_minus10 = b_minus10;
    }

    public double getB_minus20() {
        return b_minus20;
    }

    public void setB_minus20(double b_minus20) {
        this.b_minus20 = b_minus20;
    }

    public double getB_plus10() {
        return b_plus10;
    }

    public void setB_plus10(double b_plus10) {
        this.b_plus10 = b_plus10;
    }

    public double getB_plus20() {
        return b_plus20;
    }

    public void setB_plus20(double b_plus20) {
        this.b_plus20 = b_plus20;
    }

    public double getB_plus30() {
        return b_plus30;
    }

    public void setB_plus30(double b_plus30) {
        this.b_plus30 = b_plus30;
    }

    public double getB_plus40() {
        return b_plus40;
    }

    public void setB_plus40(double b_plus40) {
        this.b_plus40 = b_plus40;
    }
}
