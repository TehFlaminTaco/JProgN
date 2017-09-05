package taco.jprogn.callables.generic;

import taco.jprogn.callables.CallableMonad;
import taco.jprogn.compiler.Executor;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class CallableMonadConceptArray implements CallableMonad {

	public Concept[] concepts;
	
	public CallableMonadConceptArray(Concept[] concepts){
		this.concepts = concepts;
	}
	
	@Override
	public Var call(Var a) {
		VarStack out = Executor.execute(concepts, new Var[]{a});
		if(!out.isEmpty()){
			return out.pop();
		}
		return null;
	}
	
	public String toString(){
		String s = "¹";
		for(int i=0; i < concepts.length; i++){
			s += concepts[i];
		}
		return s;
	}

}
