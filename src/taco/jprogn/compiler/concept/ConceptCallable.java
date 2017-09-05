package taco.jprogn.compiler.concept;

import taco.jprogn.callables.Callable;

public class ConceptCallable implements Concept {

	Callable data;
	
	public ConceptCallable(Callable data){
		this.data = data;
	}
	
	@Override
	public Callable getCallable() {
		return data;
	}

}
