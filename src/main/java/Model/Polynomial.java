package Model;

import Model.Monomial;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private Map<Integer, Monomial> polynomial;
    public Polynomial() {
        this.polynomial = new HashMap<>();
    }
    public Map<Integer,Monomial> getPolinom() {
        return polynomial;
    }
    public void setPolinom(Map<Integer, Monomial> polinom) {
        this.polynomial = polynomial;
    }
    public void addMonom(Monomial m) {
        polynomial.put(m.getPower(), m);
    }
    public int maxKey(Map<Integer, Monomial> polinom){
        int maxim=0;
        for(Map.Entry<Integer, Monomial> entry :  polynomial.entrySet()) {
            if(entry.getKey()>maxim){
                maxim=entry.getKey();
            }
        }
        return maxim;
    }
    public String toString() {
        String result="";
        for(Map.Entry<Integer, Monomial> entry1 :  polynomial.entrySet()) {
            if(entry1.getKey() == maxKey(polynomial))
                result += entry1.getValue().getCoefficient() + "*x^" + entry1.getValue().getPower();
            else
                result += entry1.getValue().getCoefficient() + "*x^" + entry1.getValue().getPower() + "+";
        }
        return result;
    }
}