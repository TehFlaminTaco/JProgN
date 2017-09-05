package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableNilad;
import taco.jprogn.var.Var;

public class CallablePushVar implements CallableNilad {

	public Var data;
	
	public CallablePushVar(Var var) {
		data = var;
	}

	public CallablePushVar() {}

	@Override
	public Var call() {
		return data;
	}
	
	public String toString(){
		return data.toString();
	}
	
}
