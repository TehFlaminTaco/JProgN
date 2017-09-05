package taco.jprogn.callables;

import taco.jprogn.var.Var;

public interface CallableMonad extends Callable {
	Var call(Var a);
}
