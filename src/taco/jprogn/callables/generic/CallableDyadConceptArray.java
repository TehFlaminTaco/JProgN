package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableDyad;
import taco.jprogn.compiler.Executor;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class CallableDyadConceptArray implements CallableDyad {

	public Concept[] concepts;
	
	public CallableDyadConceptArray(Concept[] concepts){
		this.concepts = concepts;
	}
	
	@Override
	public Var call(Var a, Var b) {
		VarStack out = Executor.execute(concepts, new Var[]{a,b});
		if(!out.isEmpty()){
			return out.pop();
		}
		return null;
	}
	
	public String toString(){
		String s = "²";
		for(int i=0; i < concepts.length; i++){
			s += concepts[i];
		}
		return s;
	}

}
