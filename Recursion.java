public class Recursion {
    
    public static String name() {
	return "Tao, Jessica";
    }

    public static double sqrt(double n) {
	if(n < 0) {
	    throw new IllegalArgumentException();
	}
	return helperSqrt(n, 25);
    }

    public static double helperSqrt(double n, double guess) {
	double better_guess = (n / 25 + guess) / 2;
	if(isCloseEnough(n, better_guess * better_guess)) {
	    return better_guess;
	}
	return helperSqrt(n, better_guess);
    }

    public static boolean isCloseEnough(double a, double b) {
	if(a > (b - b*0.000000000001) && a < (b + b*0.000000000001)){
	    return true;
	}
	return false;
    }

    public static void main(String[] args) {
	System.out.println(sqrt(10));
    }
}
