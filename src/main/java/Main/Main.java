package Main;

import Controller.Controller;
import Model.Operation;
import Model.Polynomial;
import View.View;

public class Main {
    public static void main(String[] args) {
        Polynomial polynomial = new Polynomial();
        View view = new View();
        Operation operation = new Operation();
        Controller controller = new Controller(view, polynomial,operation);

    }
}