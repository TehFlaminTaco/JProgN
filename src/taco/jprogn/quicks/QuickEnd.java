package taco.jprogn.quicks;

import taco.jprogn.compiler.concept.Concept;

public class QuickEnd implements Quick {

	@Override
	public Concept[] call(Concept[] con_arr, int index) {
		return con_arr;
	}

}
