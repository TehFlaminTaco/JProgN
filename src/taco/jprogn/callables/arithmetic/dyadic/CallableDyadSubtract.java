package taco.jprogn.callables.arithmetic.dyadic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarNumber;

public class CallableDyadSubtract implements CallableDyad {

	@Override
	public Var call(Var a, Var b) {
		if(a instanceof VarNumber && b instanceof VarNumber){
			VarNumber aN = (VarNumber)a;
			VarNumber bN = (VarNumber)b;
			return new VarNumber(aN.data.add(bN.data));
		}
		
		return null;
	}
	
	public String toString(){
		return "-";
	}

}
