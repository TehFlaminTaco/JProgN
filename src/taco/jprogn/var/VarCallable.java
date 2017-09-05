package taco.jprogn.var;

import taco.jprogn.callables.Callable;
import taco.jprogn.compiler.concept.Concept;

public class VarCallable implements Var, Callable {

	Callable[] toDo;
	
	public VarCallable(Callable callable) {
		toDo = new Callable[]{callable};
	}
	
	public VarCallable(Callable[] calls){
		toDo = calls;
	}

	public VarCallable(Concept tar) {
		toDo = new Callable[]{tar.getCallable()};
	}

	@Override
	public VarString asString() {
		return new VarString(toString());
	}

	@Override
	public VarNumber asNumber() {
		return new VarNumber(0);
	}

	@Override
	public VarStack asStack() {
		return new VarStack(this);
	}
	
	@Override
	public VarCallable asCallable(){
		return this;
	}
	
	@Override
	public String toString(){
		String s = "";
		for(int i=0; i < toDo.length; i++){
			s += toDo[i];
		}
		return s;
	}

}
