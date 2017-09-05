package taco.jprogn.callables;

import taco.jprogn.var.Var;

public interface CallableDyad extends Callable {
	Var call(Var a, Var b);
}
