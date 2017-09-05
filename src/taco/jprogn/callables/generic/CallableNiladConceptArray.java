package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableNilad;
import taco.jprogn.compiler.Executor;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class CallableNiladConceptArray implements CallableNilad {

	public Concept[] concepts;
	
	public CallableNiladConceptArray(Concept[] concepts){
		this.concepts = concepts;
	}
	
	@Override
	public Var call() {
		VarStack out = Executor.execute(concepts, new Var[]{});
		if(!out.isEmpty()){
			return out.pop();
		}
		return null;
	}
	
	public String toString(){
		String s = "⁽";
		for(int i=0; i < concepts.length; i++){
			s += concepts[i];
		}
		return s;
	}

}
