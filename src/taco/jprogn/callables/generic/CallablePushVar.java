package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableNilad;
import taco.jprogn.var.Var;

public class CallablePushVar implements CallableNilad {

	public Var data;
	
	@Override
	public Var call() {
		return data;
	}
	
}
