package taco.jprogn.scope;

import taco.jprogn.callables.Callable;
import taco.jprogn.callables.arithmetic.dyadic.CallableDyadAdd;
import taco.jprogn.callables.generic.CallableNumber;
import taco.jprogn.callables.stack.dyadic.CallableDyadPair;

public class Callables {
	public static Callable[] defaults = new Callable[256];
	public static void Init(){
		
		// Arithmetic
			// Dyadic
				defaults[0x2B] = new CallableDyadAdd();
		
		// Stack
			// Dyadic
				defaults[0x2C] = new CallableDyadPair();
		
		// Generics
			defaults[0x30] = new CallableNumber(0);
			defaults[0x31] = new CallableNumber(1);
			defaults[0x32] = new CallableNumber(2);
			defaults[0x33] = new CallableNumber(3);
			defaults[0x34] = new CallableNumber(4);
			defaults[0x35] = new CallableNumber(5);
			defaults[0x36] = new CallableNumber(6);
			defaults[0x37] = new CallableNumber(7);
			defaults[0x38] = new CallableNumber(8);
			defaults[0x39] = new CallableNumber(9);
	}
}
