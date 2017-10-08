package taco.jprogn.var;

import taco.jprogn.callables.generic.CallablePushVar;

public interface Var {
	public VarString asString();
	public VarNumber asNumber();
	public VarStack  asStack();
	public default VarCallable asCallable(){
		return new VarCallable(new CallablePushVar(this));
	}
	public boolean truthy();
	public boolean v_equals(Var other);
}
