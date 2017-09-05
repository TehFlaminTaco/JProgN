package taco.jprogn.compiler;

import java.util.Stack;

import taco.jprogn.callables.Callable;
import taco.jprogn.callables.CallableDyad;
import taco.jprogn.callables.CallableMonad;
import taco.jprogn.callables.CallableNilad;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.compiler.concept.ConceptSingle;
import taco.jprogn.quicks.Quick;
import taco.jprogn.scope.Quicks;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class Executor {
	public static VarStack execute(Concept[] arr, Var[] args){
		arr = process_quicks(arr);
		VarStack varStack = new VarStack();
		for(int i=0; i < args.length; i++){
			varStack.push(args[i]);
		}
		
		Stack<CallableMonad> monadStack = new Stack<CallableMonad>();
		Stack<CallableDyad> dyadStack = new Stack<CallableDyad>();
		for(int i = 0; i < arr.length; i++){
			Callable c = arr[i].getCallable();
			if(c instanceof CallableNilad){
				varStack.push(((CallableNilad)c).call());
			}
			if(c instanceof CallableMonad){
				monadStack.push((CallableMonad)c);
			}
			if(c instanceof CallableDyad){
				dyadStack.push((CallableDyad)c);
			}
			while(processStacks(monadStack, dyadStack, varStack)){};
		}
		return varStack;
	}
	
	private static boolean processStacks(Stack<CallableMonad> monadStack, Stack<CallableDyad> dyadStack, Stack<Var> varStack){
		int vSize = varStack.size();
		if(vSize >= 2 && dyadStack.size()>=1){
			Var b = varStack.pop();
			Var a = varStack.pop();
			CallableDyad d = dyadStack.pop();
			varStack.push(d.call(a, b));
			return true;
		}
		if(vSize >= 1 && monadStack.size()>=1){
			Var a = varStack.pop();
			CallableMonad m = monadStack.pop();
			varStack.push(m.call(a));
			return true;
		}
		return false;
	}

	public static Concept[] process_quicks(Concept[] arr){
		boolean changed = true;
		while(changed){
			changed = false;
			for(int i=0; i < arr.length; i++){
				if(arr[i] instanceof ConceptSingle){
					Quick q = Quicks.quicks[((ConceptSingle)arr[i]).name];
					if(q != null){
						changed = true;
						arr = q.call(arr, i);
						break;
					}
				}
			}
		}
		return arr;
	}
}
