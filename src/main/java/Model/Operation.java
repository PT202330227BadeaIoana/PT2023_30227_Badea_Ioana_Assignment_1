package Model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class Operation {
    public Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry1 :  p1.getPolinom().entrySet()) {
            boolean found = false;
            Monomial monomial = new Monomial();
            for(Map.Entry<Integer, Monomial> entry2 : p2.getPolinom().entrySet()) {
                if(entry1.getValue().getPower() == entry2.getValue().getPower()) {
                    monomial.setPower(entry1.getValue().getPower());
                    monomial.setCoefficient(entry1.getValue().getCoefficient()+entry2.getValue().getCoefficient());
                    result.addMonom(monomial);
                    found = true;
                }
            }
            if(found==false) {
                result.addMonom(entry1.getValue());
            }
        }
        for(Map.Entry<Integer, Monomial> entry2 : p2.getPolinom().entrySet()) {
            boolean found = false;
            for(Map.Entry<Integer, Monomial> entry1 : p1.getPolinom().entrySet()) {
                if(entry2.getValue().getPower() == entry1.getValue().getPower()) {
                    found = true;
                }
            }
            if(found==false) {
                result.addMonom(entry2.getValue());
            }
        }
        return result;
    }

    public Polynomial sub(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for(Map.Entry<Integer, Monomial> entry1 :  p2.getPolinom().entrySet()) {
            entry1.getValue().setCoefficient((-1)*entry1.getValue().getCoefficient());
        }
        result=add(p1,p2);
        return result;
    }

    public Polynomial multiplicate(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        for (Map.Entry<Integer, Monomial> entry1 : p1.getPolinom().entrySet()) {
            for (Map.Entry<Integer, Monomial> entry2 : p2.getPolinom().entrySet()) {
                Monomial monomial = new Monomial();
                monomial.setPower(entry1.getValue().getPower() + entry2.getValue().getPower());
                monomial.setCoefficient(entry1.getValue().getCoefficient() * entry2.getValue().getCoefficient());
                if (result.getPolinom().get(monomial.getPower()) != null) {
                    result.getPolinom().get(monomial.getPower()).setCoefficient(
                            result.getPolinom().get(monomial.getPower()).getCoefficient() + monomial.getCoefficient());
                } else {
                    result.addMonom(monomial);
                }
            }

        }
        return result;
    }

    public int max(Polynomial polinom){
        int maxim=0;
        for(Map.Entry<Integer, Monomial> entry :  polinom.getPolinom().entrySet()) {
            if(entry.getKey()>maxim){
                maxim=entry.getKey();
            }

        }
        return maxim;
    }
    public Monomial divideMonom(Monomial m1, Monomial m2){
        Monomial result = new Monomial();
        result.setPower(m1.getPower()-m2.getPower());
        result.setCoefficient(m1.getCoefficient()/ m2.getCoefficient());
        return result;
    }

    public Monomial findMonom(Polynomial p){
        Monomial result = new Monomial();
        for(Map.Entry<Integer, Monomial> entry : p.getPolinom().entrySet()){
            if(entry.getKey()== max(p)){
                result=entry.getValue();
            }
        }
        return result;
    }

    public Polynomial multiplicate1(Polynomial p,Monomial m) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Monomial> entry1 : p.getPolinom().entrySet()) {
            Monomial monomial = new Monomial();
            monomial.setPower(entry1.getValue().getPower() + m.getPower());
            monomial.setCoefficient(entry1.getValue().getCoefficient() * m.getCoefficient());
            if (result.getPolinom().get(monomial.getPower()) != null) {
                result.getPolinom().get(monomial.getPower()).setCoefficient(
                        result.getPolinom().get(monomial.getPower()).getCoefficient() + monomial.getCoefficient());
            } else {
                result.addMonom(monomial);
            }


        }
        return result;
    }

    public String divide(Polynomial p1, Polynomial p2){
        Polynomial q =new Polynomial();
        Monomial t =new Monomial();
        Polynomial r =new Polynomial();
        String result;
        int degreeP1 = max(p1);
        int degreeP2 = max(p2);
        while(!p1.getPolinom().isEmpty() && (degreeP1>=degreeP2)){
            t=divideMonom(findMonom(p1), findMonom(p2));
            q.addMonom(t);
            r=multiplicate1(p2, t);
            p1=sub(p1, r);
            p1.getPolinom().remove(degreeP1);
            degreeP1 = max(p1);
        }
        result = q.toString() + " R: " + p1.toString();
        return result;
    }


    public Polynomial integration(Polynomial p1){
        Polynomial result =new Polynomial();
        for(Map.Entry<Integer, Monomial> entry1 :  p1.getPolinom().entrySet()) {
            Monomial monomial = new Monomial();
            monomial.setPower(entry1.getValue().getPower()+1);
            monomial.setCoefficient(entry1.getValue().getCoefficient()/(entry1.getValue().getPower()+1));
            result.addMonom(monomial);
        }
        return result;
    }

    public Polynomial derivation(Polynomial p1){
        Polynomial result =new Polynomial();
        for(Map.Entry<Integer, Monomial> entry1 :  p1.getPolinom().entrySet()) {
            Monomial monomial = new Monomial();
            monomial.setPower(entry1.getValue().getPower()-1);
            monomial.setCoefficient(entry1.getValue().getCoefficient()*entry1.getValue().getPower());
            result.addMonom(monomial);
        }
        return result;
    }

    public Polynomial trans(String s){
        Pattern pattern = Pattern.compile ("([+-]?\\d*\\*x\\^\\d+)");
        Matcher matcher = pattern.matcher(s);
        Polynomial polynomial = new Polynomial();
        while(matcher.find()){
            Monomial monomial = new Monomial();
            String monom = matcher.group();
            Pattern pattern1 = Pattern.compile("[+-]?\\d+");
            Matcher matcher1 = pattern1.matcher(monom);
            float coefficient = (matcher1.find())?parseFloat(matcher1.group()):null;
            int power = (matcher1.find())?parseInt(matcher1.group()):null;
            monomial.setCoefficient(coefficient);
            monomial.setPower(power);
            polynomial.addMonom(monomial);
        }
        return polynomial;
    }
}
