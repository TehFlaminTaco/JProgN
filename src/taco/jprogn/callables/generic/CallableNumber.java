package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableNilad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarNumber;

public class CallableNumber implements CallableNilad {
	int n;
	
	public CallableNumber(int n){
		this.n = n;
	}
	
	@Override
	public Var call() {
		return new VarNumber(n);
	}

}
