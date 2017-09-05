package taco.jprogn.callables.arithmetic.dyadic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarCallable;
import taco.jprogn.var.VarNumber;
import taco.jprogn.var.VarStack;
import taco.jprogn.var.VarString;

public class CallableDyadAdd implements CallableDyad {

	@Override
	public Var call(Var a, Var b) {
		if(a instanceof VarCallable || b instanceof VarCallable){
			VarCallable aC = a.asCallable();
			VarCallable aB = b.asCallable();
			return new VarCallable(new VarCallable[]{aC, aB});
		}
		if(a instanceof VarStack){
			VarStack nStack = ((VarStack) a).copy();
			VarStack s = b.asStack();
			int bSize = s.size();
			for(int i=0; i < bSize; i++){
				nStack.push(s.get(i));
			}
			return nStack;
		}
		if(a instanceof VarString || b instanceof VarString){
			VarString aS = a.asString();
			VarString bS = b.asString();
			return new VarString(aS.data + bS.data);
		}
		if(a instanceof VarNumber && b instanceof VarNumber){
			VarNumber aN = (VarNumber)a;
			VarNumber bN = (VarNumber)b;
			return new VarNumber(aN.data.add(bN.data));
		}
		if(b instanceof VarStack){
			VarStack nStack = (a.asStack()).copy();
			VarStack s = (VarStack)b;
			int bSize = s.size();
			for(int i=0; i < bSize; i++){
				nStack.push(s.get(i));
			}
			return nStack;
		}
		return a; // I'm 90% sure this can't be reached.
	}
	
	public String toString(){
		return "+";
	}
}
