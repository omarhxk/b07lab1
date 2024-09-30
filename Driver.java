import java.io.File;

public class Driver {
    public static void main(String [] args) {
	Polynomial p = new Polynomial();
	System.out.println(p.evaluate(3));
	double [] c1 = {6,0,0,5};
	int [] e1 = {2, 1, 4, 3};
	Polynomial p1 = new Polynomial(c1, e1);
	System.out.println(p1.evaluate(2));
	double [] c2 = {0,-2,0,0,-9};
	int [] e2 = {0, 1, 2, 3, 4};
	Polynomial p2 = new Polynomial(c2, e2);
	Polynomial s = p1.add(p2);
	System.out.println("s(5) = " + s.evaluate(5));
	if(s.hasRoot(1))
	    System.out.println("1 is a root of s");
	else
	    System.out.println("1 is not a root of s");
	Polynomial p3 = p1.multiply(p2);
	System.out.println(p3.evaluate(2));

	//TESTING
	/*System.out.println("\n\n");
	
	//No argument constructor
	Polynomial f1 = new Polynomial();
	f1.print_poly();
	System.out.println("\n\n");
	
	//Argument Constructor
	double [] co = {-8, 0.2, 6.7};
	int [] ex = {0, 1, 4};
	Polynomial f2 = new Polynomial(co, ex);
	f2.print_poly();
	System.out.println("\n\n");

	//File Constructor
	File test = new File("csc2.txt");
        Polynomial p4 = new Polynomial(test);
	p4.print_poly();
	System.out.println("\n\n");

	File t = new File("csc4.txt");
	Polynomial p5 = new Polynomial(t);
	p5.print_poly();
	System.out.println("\n\n");

	File t2 = new File("csc5.txt");
	Polynomial p6 = new Polynomial(t2);
	p6.print_poly();
	System.out.println("\n\n");

	File t3 = new File("csc6.txt");
	Polynomial p7 = new Polynomial(t3);
	p7.print_poly();
	System.out.println("\n\n");

	File t4 = new File("csc13.txt");
	Polynomial p8 = new Polynomial(t4);
	p8.print_poly();
	System.out.println("\n\n"); */

	//Add Method
	/*Polynomial p8 = p6.add(p5);
	p8.print_poly();
	System.out.println("\n\n");

	p8 = p5.add(p6);
	p8.print_poly();
	System.out.println("\n\n");

	Polynomial p9 = p7.add(p4);
	p9.print_poly();
	System.out.println("\n\n");

	p9 = p4.add(p7);
	p9.print_poly();
	System.out.println("\n\n");

	p9 = p8.add(f1);
	p9.print_poly();
	System.out.println("\n\n");

	double [] c3 = {1, 1, 19, 3.55, 52};
	int [] e3 = {1, 5, 0, 6, 2};
	Polynomial p12 = new Polynomial(c3, e3);
	p9 = p12.add(p5);
	p9.print_poly(); */
	

	//Evaluate Method
	/*System.out.println(f1.evaluate(9));
	System.out.println(p7.evaluate(-5));
	System.out.println(p7.evaluate(0));
	System.out.println(p6.evaluate(-2));
	System.out.println(p5.evaluate(7));*/

	//Multiply Method
	/*Polynomial p10 = p7.multiply(p6);
	p10.print_poly();
	System.out.println("\n\n");

	p10 = p5.multiply(p4);
	p10.print_poly();
	System.out.println("\n\n");

	double [] c4 = {1, -1};
	int [] e4 = {1, 0};
	double [] c5 = {1, 1};
	
	Polynomial p11 = new Polynomial(c4, e4);
	Polynomial p12 = new Polynomial(c5, e4);
	p11.print_poly();
	p12.print_poly();
	p10 = p11.multiply(p12);
	p10.print_poly();
	System.out.println("\n\n");*/

	//saveToFile method
	/*p7.saveToFile("csc10.txt");
	p6.saveToFile("csc11.txt");
	p5.saveToFile("csc12.txt");
	p4.saveToFile("csc13.txt");
	f1.saveToFile("csc14.txt");
	f2.saveToFile("csc15.txt");*/

	

    }
}
