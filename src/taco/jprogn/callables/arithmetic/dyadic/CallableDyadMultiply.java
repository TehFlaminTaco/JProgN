package taco.jprogn.callables.arithmetic.dyadic;

import java.math.BigDecimal;

import taco.jprogn.callables.Callable;
import taco.jprogn.callables.CallableDyad;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarCallable;
import taco.jprogn.var.VarNumber;
import taco.jprogn.var.VarStack;
import taco.jprogn.var.VarString;

public class CallableDyadMultiply implements CallableDyad {

	@Override
	public Var call(Var a, Var b) {
		// When one of the two is a number, direction cannot matter.
		// This is convenient, because now if we can cover both a is a number and b is a number as just a.
		if(b instanceof VarNumber){
			Var c = a;
			a = b;
			b = c;
		}
		if(a instanceof VarNumber){
			VarNumber aN = a.asNumber();
			if(b instanceof VarNumber){
				return new VarNumber(aN.data.multiply(b.asNumber().data));
			}
			if(b instanceof VarString){
				String o = "";
				for(BigDecimal i = BigDecimal.ZERO; i.compareTo(aN.data)==-1; i = i.add(BigDecimal.ONE)){
					o += (VarString)b;
				}
				return new VarString(o);
			}
			if(b instanceof VarStack){
				VarStack nS = new VarStack();
				VarStack bS = (VarStack)b;
				int bSize = bS.size();
				for(BigDecimal i = BigDecimal.ZERO; i.compareTo(aN.data)==-1; i = i.add(BigDecimal.ONE)){
					for(int c = 0; c < bSize; c++){
						nS.push(bS.get(c));
					}
				}
				return nS;
			}
			if(b instanceof VarCallable){
				Callable[] nArr = new Callable[((VarNumber) a).data.intValue()];
				for(int i=0; i < nArr.length; i++){
					nArr[i] = (VarCallable)b;
				}
				return new VarCallable(nArr);
			}
			return b;
		}
		
		return null;
	}
	
	public String toString(){
		return "*";
	}
	
}
