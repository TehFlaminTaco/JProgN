package taco.jprogn.compiler.concept;

import taco.jprogn.callables.Callable;
import taco.jprogn.callables.generic.CallableDyadConceptArray;
import taco.jprogn.callables.generic.CallableMonadConceptArray;
import taco.jprogn.callables.generic.CallableNiladConceptArray;

public class ConceptArray implements Concept {
	
	Concept[] concepts;
	int airity = 0; // Niladic by default -shrug-
	
	public ConceptArray(Concept[] concepts, int airity){
		this.airity = airity;
		this.concepts = concepts;
	}
	
	@Override
	public Callable getCallable() {
		switch(airity){
		case 0: return new CallableNiladConceptArray(concepts);
		case 1: return new CallableMonadConceptArray(concepts);
		case 2: return new CallableDyadConceptArray(concepts);
		}
		return null;
	}
	
	public String toString(){
		String s = "";
		for(int i=0; i < concepts.length; i++){
			s += concepts[i];
		}
		return s;
	}

}
