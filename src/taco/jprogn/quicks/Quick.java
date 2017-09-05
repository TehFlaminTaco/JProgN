package taco.jprogn.quicks;

import taco.jprogn.compiler.concept.Concept;

public interface Quick {
	public Concept[] call(Concept[] con_arr, int index);
}
