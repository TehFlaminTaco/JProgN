package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;

public class CallableFlipped implements CallableDyad {

	CallableDyad data;
	
	public CallableFlipped(CallableDyad data){
		this.data = data;
	}
	
	@Override
	public Var call(Var a, Var b) {
		return data.call(b, a);
	}
	
}
