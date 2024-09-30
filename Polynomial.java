import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Polynomial {
    //fields
    double [] coefficients;
    int [] exponents;

    //methods

    //No-argument constructor
    public Polynomial() {
	coefficients = new double [1];
	exponents = new int [1];
    }

    //Argument constructor
    public Polynomial(double [] coeffs, int [] exps) {
	
	this.coefficients = new double [coeffs.length];
	for (int i = 0; i < coeffs.length; i++) {
	    this.coefficients[i] = coeffs[i]; }

	this.exponents = new int [exps.length];
	for (int i = 0; i < exps.length; i++) {
	    this.exponents[i] = exps[i]; }
    }

    //File Constructor
    public Polynomial(File f) {

	try {
	    
	Scanner reader = new Scanner(f);
	String data = reader.nextLine();
	System.out.println(data);
	String [] terms = data.split("\\+"); 

	int len = 0;
	for (int i = 0; i < terms.length; i++) {
	    
	    len += terms[i].split("-").length; }

	if (terms[0].split("-")[0].isEmpty()) {

	    len += -1; }

	exponents = new int [len];
	coefficients = new double [len];

	int index = 0;

	//System.out.println("here");

	for (int i = 0; i < terms.length; i++) {
	    String [] terms2 = terms[i].split("-");

	    //First term can be positive or negative.

	    //Deals with case of a singlular x or x^p (no coefficient).
	    int ind = 0;

	    if (terms2[0].isEmpty()) {

		ind = 1; }
	    
	    if (terms2[ind].startsWith("x")) {

		    coefficients[index] = 1;

		    if (terms[i].startsWith("-")) {

			coefficients[index] = -1; }

		    if (!terms2[ind].endsWith("x")) {

			exponents[index] =
			    Integer.parseInt(terms2[ind].split("x")[1]); }

		    else {

			exponents[index] = 1; } } 

	    //Deals with case of ax^p.
	    else {
		
		String [] s = terms2[ind].split("x");
		coefficients[index] = Double.parseDouble(s[0]);
		
		if (terms[i].startsWith("-")) {
		    coefficients[index] = -1 * coefficients[index]; }
		
		if (s.length > 1) {
		    exponents[index] = Integer.parseInt(s[1]); }
		
		else if (terms2[ind].contains("x")) {
		    exponents[index] = 1; } } 
	
	    index++;

	    //Next terms are all negative, as they were split using "-".

	    
	    for (int j = ind + 1; j < terms2.length; j++) {

		//System.out.println(j);

		//Deals with case of singular x or x^p (no coefficient).
		if (terms2[j].startsWith("x")) {

		    coefficients[index] = -1;

		    if (!terms2[j].endsWith("x")) {

			exponents[index] =
			    Integer.parseInt(terms2[j].split("x")[0]); }

		    else {

			exponents[index] = 1; } }
		    
		//Deals with case of ax^p.
		else {
		    
		    String [] p = terms2[j].split("x");
		    
		    coefficients[index] = -1 * Double.parseDouble(p[0]);
		    
		    if (p.length > 1 && !p[1].isEmpty()) {
			exponents[index] = Integer.parseInt(p[1]); }
		    
		    else if (terms2[j].contains("x")) {
			
			exponents[index] = 1; } }
		
		index++; } } } 

	catch (FileNotFoundException ex) {
	    
	    exponents = new int [1];
	    coefficients = new double [1]; }
	
    }

    //helper fcn. Checks if value value is in array A.
    public boolean is_in(int value, int [] A) {

	for (int i = 0; i < A.length; i++) {
	    if (A[i] == value) {
		    return true; }
	}
	return false; }
	
    //add method
    public Polynomial add(Polynomial f2) {

	int len = 0;

	//We account for all exponents of our first polynomial
	for (int i = 0; i < exponents.length; i++) {

	    len++; }

	/*We only account for exponents of our second polynomial that we have
	  not already seen in polynomial one*/
	for (int i = 0; i < f2.exponents.length; i++) {

	    if (!is_in(f2.exponents[i], exponents)) {

		len ++; } }

	/*We create new arrays for the exponents and coefficients of our new
	sum polynomial. They are the same size, by def*/
	int [] sum_exponents = new int [len];
	double [] sum_coefficients = new double [len];

	/*We initialize all previous exponents and corresponding coefficients
	of polynomial one*/
	for (int i = 0; i < exponents.length; i++) {

	    sum_exponents[i] = exponents[i];
	    sum_coefficients[i] = coefficients[i]; }

	//We mark the first remaining free index.
	int index = exponents.length;

	//We iterate through polynomial 2 
	for (int i = 0; i < f2.exponents.length; i++) {

	    /*We append all the unique exponents and their corresponding
	    coefficients to our sum polynomial*/
	    if (!is_in(f2.exponents[i], exponents)) {

		sum_exponents[index] = f2.exponents[i];
		sum_coefficients[index] = f2.coefficients[i];
		index++; }

	    /*For nonunique exponents, we find add their coefficient to
	      the pre-existing coefficient from polynomial 1*/
	    else {

		int j = 0;
		while (j < len && sum_exponents[j] != f2.exponents[i]) {
		    j++; }

		if (j != len) {
		    sum_coefficients[j] += f2.coefficients[i]; } } }

	//Getting rid of 0 coefficients
	int p = 0;
	
	for (int w = 0; w < len; w++) {
	    if (sum_coefficients[w] != 0) {
		p++; } }

	if (p > 0) {

	    double sum_coefficients2 [] = new double [p];
	    int sum_exponents2 [] = new int [p];
	    int ind = 0;
	    for (int w = 0; w < len; w++) {

		if (sum_coefficients[w] != 0) {
		    sum_coefficients2[ind] = sum_coefficients[w];
		    sum_exponents2[ind] = sum_exponents[w];
		    ind++; } }

	    return new Polynomial(sum_coefficients2, sum_exponents2); }

	return new Polynomial(sum_coefficients, sum_exponents); }
    		

    //evaluate method
    public double evaluate(double x) {
	double sum = 0;
	
	for (int i = 0; i < coefficients.length; i++) {
	    double prod = 1;
	    for (int j = 0; j < exponents[i]; j++) {
		prod = prod * x; }
	    sum += coefficients[i] * prod; }
	
	return sum; }

    //hasRoot method
    public boolean hasRoot(double x) {
	return evaluate(x) == 0.0;
    }

    //Helper fcn
    public Polynomial product(int e, double c) {

	int [] product_exps = new int [exponents.length];
	for (int i = 0; i < exponents.length; i++) {

	    product_exps[i] = e + exponents[i]; }

	double [] product_coeffs = new double [coefficients.length];
	for (int i = 0; i < coefficients.length; i++) {

	    if (coefficients[i] != 0) {
		
		product_coeffs[i] = coefficients[i] * c; } }

	return new Polynomial(product_coeffs, product_exps); }

	    
    //Multiply Method
    public Polynomial multiply(Polynomial f2) {

	Polynomial product = new Polynomial();
	
	for (int i = 0; i < exponents.length; i++) {
		
	    product = product.add(f2.product(exponents[i], coefficients[i]));
	    } 

	return product; }
		

    //saveToFile method
    public void saveToFile(String file_name) {

	try {
	    
	File my_file = new File(file_name);
	PrintStream output = new PrintStream(my_file);

	String s = "";

	for (int i = 0; i < exponents.length; i++) {

	    s += Double.toString(coefficients[i]);

	    if (exponents[i] != 0) {

		s += "x" + Integer.toString(exponents[i]); }

	    if (i + 1 != exponents.length) {

		if (coefficients[i + 1] >= 0) {

		    s += "+"; } } }

	output.print(s); }

	catch (FileNotFoundException ex) {

	    return; }

	return; }

    //Method to print our polynomial
    public void print_poly() {

	System.out.println("Polynomial in (cofficient, exponent) form:");

	for (int i = 0; i < exponents.length; i++) {

	    System.out.println("(" + coefficients[i] + ","
			       + exponents[i] + ")"); }
	}
	
    
	
}

    
  

    

	
	
	

	
