package taco.jprogn.quicks;

import taco.jprogn.callables.Callable;
import taco.jprogn.callables.CallableDyad;
import taco.jprogn.callables.generic.CallableFlipped;
import taco.jprogn.callables.generic.CallablePushVar;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.compiler.concept.ConceptCallable;
import taco.jprogn.scope.Quicks;
import taco.jprogn.var.VarCallable;

public class QuickFlip implements Quick {

	@Override
	public Concept[] call(Concept[] con_arr, int index) {

		if(index+1 == con_arr.length){
			return null;
		}
		
		if(Quicks.isQuick(con_arr[index+1])){
			return null;
		}
		
		Callable nextCall = con_arr[index+1].getCallable();
		
		if(!(nextCall instanceof CallableDyad)){
			return null;
		}
		
		Concept[] newArr = new Concept[con_arr.length-1];
		for(int i=0; i < index; i++){
			newArr[i] = con_arr[i];
		}

		newArr[index] = new ConceptCallable(
				new CallableFlipped(
						(CallableDyad)nextCall
				)
		);
		for(int i=index+2; i<con_arr.length; i++){
			newArr[i-1] = con_arr[i];
		}
		return newArr;
	}

}
