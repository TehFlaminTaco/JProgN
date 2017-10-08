package taco.jprogn;

import taco.jprogn.compiler.Executor;
import taco.jprogn.compiler.Tokenizer;
import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.scope.Callables;
import taco.jprogn.scope.Quicks;
import taco.jprogn.var.Var;
import taco.jprogn.var.VarStack;

public class JProgN {
	public static Encoding encoding;
	public static void main(String[] args){
		Quicks.Init();
		Callables.Init();
		
		Concept[] arr = Tokenizer.tokenize(Encoding.fromString("2×3+1"));
		
		VarStack out = Executor.execute(arr, new Var[]{});
		while(!out.isEmpty()){
			if(out.size()>1){
				System.out.println(out.pop());
			}else{
				System.out.print(out.pop());
			}
		}
	}
}
