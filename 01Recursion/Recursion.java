public class Recursion {
    
    public static double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n == 0.0){
	    return 0;
	}
	return helperSqrt(n, 25);
    }
    
    public static double helperSqrt(double n, double guess){
	if (isCloseEnough(guess * guess, n)){
	    return guess;
	}
	double better_guess = (n / guess + guess)/2;
	return helperSqrt(n, better_guess);
    }
    
    private static boolean isCloseEnough(double a,double b){
	if (a==0 && b==0){
	    return true;
	}
	if (a <= 1.000000000001*b && a >= .999999999999*b){
	    return true;
	}
	return false;
    }
    /*
    public static void main(String[] args) {
	System.out.println(sqrt(1));
    }
    */
}
