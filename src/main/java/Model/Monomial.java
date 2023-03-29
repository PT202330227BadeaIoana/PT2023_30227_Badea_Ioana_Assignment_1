package Model;

public class Monomial {
    private float coefficient;
    private int power;
    public Monomial() {
        this.coefficient=coefficient;
        this.power=power;
    }
    public float getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(float coefficient) {
        this.coefficient=coefficient;
    }
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power=power;
    }
    public String toSring() {
        return this.coefficient + "*x^" + this.power;
    }
}
