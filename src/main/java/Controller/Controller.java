package Controller;

import Model.Operation;
import Model.Polynomial;
import View.View;

import java.awt.event.*;

public class Controller {
    private View view;
    private Polynomial polynomial;
    private Operation operation;

    public Controller(View view, Polynomial polynomial, Operation operation) {
        this.view=view;
        this.polynomial=polynomial;
        this.operation=operation;

        view.addAddListener(new AddListener());
        view.addMultiplicateListener(new MultiplicateListener());
        view.addDivideListener(new DivideListener());
        view.addSubstractListener(new SubstractListener());
        view.addDerivationListener(new DerivationListener());
        view.addIntegrationListener(new IntegrationListener());

    }

    class AddListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            Polynomial result1 = new Polynomial();
            try {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                String first = view.getFirstField();
                String second = view.getSecondField();
                p1=operation.trans(first);
                p2=operation.trans(second);
                result1=operation.add(p1, p2);
                result=result1.toString();
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }

    class MultiplicateListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            Polynomial result1 = new Polynomial();
            try {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                String first = view.getFirstField();
                String second = view.getSecondField();
                p1=operation.trans(first);
                p2=operation.trans(second);
                result1=operation.multiplicate(p1, p2);
                result=result1.toString();
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }

    class DivideListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            try {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                String first = view.getFirstField();
                String second = view.getSecondField();
                p1=operation.trans(first);
                p2=operation.trans(second);
                result=operation.divide(p1, p2);
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }

    class SubstractListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            Polynomial result1 = new Polynomial();
            try {
                Polynomial p3 = new Polynomial();
                Polynomial p4 = new Polynomial();
                String first = view.getFirstField();
                String second = view.getSecondField();
                p3=operation.trans(first);
                p4=operation.trans(second);
                result1=operation.sub(p3, p4);
                result=result1.toString();
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }

    class DerivationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            Polynomial result1 = new Polynomial();
            try {
                Polynomial p1 = new Polynomial();
                String first = view.getFirstField();
                p1=operation.trans(first);
                result1=operation.derivation(p1);
                result=result1.toString();
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }

    class IntegrationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String result="";
            Polynomial result1 = new Polynomial();
            try {
                Polynomial p1 = new Polynomial();
                String first = view.getFirstField();
                p1=operation.trans(first);
                result1=operation.integration(p1);
                result=result1.toString();
                view.setResultArea(result);
            }catch(Exception exception) {
                view.showErrorMessage("Wrong Polynomial!");
            }
        }
    }
}
