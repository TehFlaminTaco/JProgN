package taco.jprogn.compiler.concept;

import taco.jprogn.Encoding;
import taco.jprogn.callables.Callable;
import taco.jprogn.scope.Callables;

public class ConceptSingle implements Concept {
	public byte name;

	public ConceptSingle(byte b) {
		name = b;
	}

	@Override
	public Callable getCallable() {
		return Callables.defaults[name];
	}
	
	@Override
	public String toString(){
		return Encoding.toString(name);
	}
	
}
