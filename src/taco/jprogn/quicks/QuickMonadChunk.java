package taco.jprogn.quicks;

import java.util.Stack;

import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.compiler.concept.ConceptArray;
import taco.jprogn.compiler.concept.ConceptSingle;

public class QuickMonadChunk implements Quick {

	@Override
	public Concept[] call(Concept[] con_arr, int index) {
		Stack<Concept> nConArr = new Stack<Concept>();
		Stack<Concept> callStack = new Stack<Concept>();
		
		for(int i=0; i < index; i++){
			nConArr.push(con_arr[i]);
		}
		int i = index+1;
		int d = 1;
		
		while(i < con_arr.length && d > 0){
			Concept n = con_arr[i];
			if(n instanceof ConceptSingle){
				ConceptSingle nS = (ConceptSingle)n;
				
				if(nS.name == (byte)0x8E)
					d--;
				if(nS.name == (byte)0x81)
					d++;
				if(nS.name == (byte)0x82)
					d++;
				if(nS.name == (byte)0X8D)
					d++;
			}
			callStack.push(n);
			i++;
		}
		if(d == 0){
			callStack.pop();
		}
		Concept[] callArray = new Concept[callStack.size()];
		callStack.toArray(callArray);
		nConArr.push(new ConceptArray(callArray, 1));
		while(i < con_arr.length){
			nConArr.push(con_arr[i]);
			i++;
		}
		con_arr = new Concept[nConArr.size()];
		return nConArr.toArray(con_arr);
	}

}
