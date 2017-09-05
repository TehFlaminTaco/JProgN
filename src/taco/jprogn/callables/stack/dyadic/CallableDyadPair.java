package taco.jprogn.callables.stack.dyadic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class CallableDyadPair implements CallableDyad {

	@Override
	public Var call(Var a, Var b) {
		VarStack nStack = (a.asStack()).copy();
		VarStack s = b.asStack();
		int bSize = s.size();
		for(int i=0; i < bSize; i++){
			nStack.push(s.get(i));
		}
		return nStack;
	}
	
}
