package taco.jprogn.var;

import java.util.Stack;

public class VarStack extends Stack<Var> implements Var {
	private static final long serialVersionUID = 7673338579671890595L;

	public VarStack(){}
	
	public VarStack(Stack<Var> s){
		int sSize = s.size();
		for(int i=0; i < sSize; i++){
			push(s.get(i));
		}
	}
	
	public VarStack(Var v){
		push(v);
	}
	
	public String toString(){
		return asString().data;
	}
	
	public VarStack copy(){
		VarStack nStack = new VarStack();
		int siz = size();
		for(int i=0; i < siz; i++){
			nStack.push(get(i));
		}
		return nStack;
	}
	
	@Override
	public VarString asString() {
		String s = "(";
		int thissize = size();
		if(thissize > 0){
			s += " ";
		}
		for(int i=0; i < thissize; i++){
			s += get(i).asString().data + " ";
		}
		s += ")";
		return new VarString(s);
	}

	@Override
	public VarNumber asNumber() {
		return new VarNumber(size());
	}

	@Override
	public VarStack asStack() {
		return this;
	}

}
