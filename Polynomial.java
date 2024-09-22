public class Polynomial {
    //fields
    double [] coefficients;

    //methods

    //No-argument constructor
    public Polynomial() {
	coefficients = new double [2];
    }

    //Argument constructor
    public Polynomial(double [] coeffs) {
	this.coefficients = new double [coeffs.length];
	for (int i = 0; i < coeffs.length; i++) {
	    this.coefficients[i] = coeffs[i];
	}
    }

    //add method
    public Polynomial add(Polynomial f2) {
    	int len;
    		
    	 if (f2.coefficients.length > coefficients.length) {

	     len = f2.coefficients.length; }


	 else {
		
	     len = coefficients.length; } 

    double [] sum_array = new double [len];
    for (int i = 0; i < len; i++) {
		
	if (i < coefficients.length && i < f2.coefficients.length) {
	    sum_array[i] = coefficients[i] + f2.coefficients[i]; }
	else if (i < coefficients.length) {
	    sum_array[i] += coefficients[i]; }
	else if (i < f2.coefficients.length) {
	    sum_array[i] += f2.coefficients[i]; }
			
    }
    return new Polynomial(sum_array);
    }

    //evaluate method
    public double evaluate(double x) {
	double sum = 0;
	
	for (int i = 0; i < coefficients.length; i++) {
	    double prod = 1;
	    for (int j = 0; j < i; j++) {
		prod = prod * x; }
	    sum += coefficients[i] * prod; }
	
	return sum; }

    //hasRoot method
    public boolean hasRoot(double x) {
	return evaluate(x) == 0.0;
    }
}

    
  

    

	
	
	

	
