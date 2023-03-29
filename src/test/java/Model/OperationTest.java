package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class OperationTest {

    private static int testExec = 0;
    private static int succes = 0;
    private static Operation operation = new Operation();
    private static Monomial m1 = new Monomial();
    private static Monomial m2 = new Monomial();
    private static Monomial m3 = new Monomial();
    private static  Monomial m4 = new Monomial();
    private static  Monomial m5 = new Monomial();

    private static Polynomial p2 = new Polynomial();
    private static Polynomial p1 = new Polynomial();

    private String poly1="10*x^4+5*x^2+7*x^0";
    private String poly2="3*x^3+8*x^2+9*x^1";

    Polynomial result= new Polynomial();

    String result1 = "";

    public OperationTest()
    {
        System.out.println("Constructor inaintea fiecarui test!");
    }
    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.out.println("O singura data inaintea executiei setului de teste.");
        //operation = new Operation();
    }

    @AfterClass
    private static void tearDownAfterClass() throws Exception{
        System.out.println("O singura data dupa terminarea executiei.");
        System.out.println("S_au executat " + testExec + " teste din care "+ succes+"au avut succes.");
    }

    @Before
    public void setUp() throws Exception{
        System.out.println("Incepe un nou test.");
        testExec++;
    }

    @After
    public void tearDown() throws Exception{
        System.out.println("S-a terminat testul curent.");
    }
    @Test
    public void add() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        m4.setCoefficient(1);
        m4.setPower(1);

        m5.setCoefficient(-2);
        m5.setPower(0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        result = operation.add(p1,p2);
        assertEquals(result.toString(),"-2.0*x^0+-3.0*x^1+-6.0*x^2+4.0*x^3");
        succes++;
    }

    @Test
    void sub() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        m4.setCoefficient(1);
        m4.setPower(1);

        m5.setCoefficient(-2);
        m5.setPower(0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        result = operation.sub(p1,p2);
        assertEquals(result.toString(),"2.0*x^0+-5.0*x^1+-6.0*x^2+4.0*x^3");
        succes++;
    }

    @Test
    void multiplicate() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        m4.setCoefficient(1);
        m4.setPower(1);

        m5.setCoefficient(-2);
        m5.setPower(0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        result = operation.multiplicate(p1,p2);
        assertEquals(result.toString(),"8.0*x^1+8.0*x^2+-14.0*x^3+4.0*x^4");
        succes++;
    }

    @Test
    void multiplicate1() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        m5.setPower(0);
        m5.setCoefficient(0);

        p2.addMonom(m5);
        result = operation.multiplicate(p1,p2);
        assertEquals(result.toString(),"-0.0*x^1+-0.0*x^2+0.0*x^3");
        succes++;
    }

    @Test
    void divide(){
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        m4.setCoefficient(1);
        m4.setPower(1);

        m5.setCoefficient(-2);
        m5.setPower(0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        result1 = operation.divide(p1,p2);
        assertEquals(result1,"0.0*x^0+2.0*x^1+4.0*x^2 R: 0.0*x^0");
        succes++;
    }

    @Test
    void divide1(){
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        m5.setCoefficient(0);
        m5.setPower(0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m5);
        result1 = operation.divide(p1,p2);
        assertEquals(result1,"0.0*x^0+2.0*x^1+4.0*x^2 R: 0.0*x^0");
        succes++;
    }
    @Test
    void integration() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        result = operation.integration(p1);
        assertEquals(result.toString(),"-2.0*x^2+-2.0*x^3+1.0*x^4");
        succes++;
    }

    @Test
    void derivation() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        result = operation.derivation(p1);
        assertEquals(result.toString(),"-4.0*x^0+-12.0*x^1+12.0*x^2");
        succes++;
    }

    @Test
    void trans() {
        operation.trans(poly1);
    }

    @Test
    public void testAlwaysFail() {
        m1.setCoefficient(4);
        m1.setPower(3);

        m2.setCoefficient(-6);
        m2.setPower(2);

        m3.setCoefficient(-4);
        m3.setPower(1);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        result = operation.derivation(p1);
        assertEquals(result.toString(),"-9.0*x^0+-1.0*x^1+12.0*x^8");
        succes++;
    }
}