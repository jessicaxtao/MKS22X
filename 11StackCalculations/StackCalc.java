import java.util.Stack;

public class StackCalc {
    public static double eval(String s) {
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for(String token : tokens) {
	    if(isOp(token)) {
		values.push(apply(token, values.pop(), values.pop()));
	    }else{
		values.push(Double.parseDouble(token));
	    }
	}
	return values.pop();
    }

    public static boolean isOp(String a) {
	if(a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/") || a.equals("%")) {
	    return true;
	}
	return false;
    }

    public static double apply(String op, Double x, Double y) {
	if(op.equals("+")) {
	    return y + x;
	}else if(op.equals("-")) {
	    return y - x;
	}else if(op.equals("*")) {
	    return y * x;
	}else if(op.equals("/")) {
	    return y / x;
	}else if(op.equals("%")) {
	    return y % x;
	}else {
	    return -1;
	}
    }
}
