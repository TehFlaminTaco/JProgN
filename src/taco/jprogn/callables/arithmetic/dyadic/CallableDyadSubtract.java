package taco.jprogn.callables.arithmetic.dyadic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarCallable;
import taco.jprogn.var.VarNumber;
import taco.jprogn.var.VarStack;
import taco.jprogn.var.VarString;

public class CallableDyadSubtract implements CallableDyad {

	@Override
	public Var call(Var a, Var b) {
		if(b instanceof VarCallable){
			b = b.asString();
		}
		if(a instanceof VarNumber && b instanceof VarNumber){
			VarNumber aN = (VarNumber)a;
			VarNumber bN = (VarNumber)b;
			return new VarNumber(aN.data.add(bN.data));
		}
		if(b instanceof VarStack){
			VarStack bS = (VarStack)b;
			for(int i=0; i < bS.size(); i++){
				a = call(a, bS.get(i));
			}
			return a;
		}
		if(a instanceof VarStack){
			VarStack nS = new VarStack();
			VarStack aS = (VarStack)a;
			for(int i=0; i < aS.size(); i++){
				if(!aS.get(i).v_equals(b)){
					nS.push(aS.get(i));
				}
			}
			return nS;
		}
		VarString aS = a.asString();
		VarString bS = b.asString();
		
		return new VarString(aS.data.replaceAll(bS.data, ""));
	}
	
	public String toString(){
		return "-";
	}

}
