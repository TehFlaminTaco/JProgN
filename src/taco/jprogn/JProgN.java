package taco.jprogn;

import taco.jprogn.compiler.Executor;
import taco.jprogn.compiler.Tokenizer;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.scope.Callables;
import taco.jprogn.scope.Quicks;
import taco.jprogn.var.Var;

public class JProgN {
	public static Encoding encoding;
	public static void main(String[] args){
		Quicks.Init();
		Callables.Init();
		
		Concept[] arr = Tokenizer.tokenize("1234,,,".getBytes());
		System.out.println(
				Executor.execute(arr, new Var[]{})
		);
	}
}
