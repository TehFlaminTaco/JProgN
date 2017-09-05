package taco.jprogn.compiler.concept;

import taco.jprogn.Encoding;
import taco.jprogn.callables.Callable;
import taco.jprogn.callables.generic.CallablePushVar;
import taco.jprogn.var.VarNumber;
import taco.jprogn.var.VarString;

public class ConceptMulti implements Concept {
	public byte[] name;

	public ConceptMulti(byte[] name) {
		this.name = name;
	}

	@Override
	public Callable getCallable() {
		CallablePushVar call = new CallablePushVar();
		if(name[0]==0x22 || name[0]==0x27){ // String '' or ""
			byte[] newStr = new byte[name.length - 2];
			for(int i=1; i < name.length-1; i++){
				newStr[i-1] = name[i];
			}
			call.data = new VarString(Encoding.toString(newStr));
		}
		if(name[0]==0x60){ // Char literal. `
			call.data = new VarString(Encoding.toString(name[1]));
		}
		if(name[0]==0x24){ // Number literal. $1234
			byte[] newStr = new byte[name.length - 1];
			for(int i=1; i < name.length; i++){
				newStr[i-1] = name[i];
			}
			call.data = new VarNumber(Encoding.toString(newStr));
		}
		return call;
	}
	
	@Override
	public String toString(){
		return Encoding.toString(name);
	}
	
}
