package taco.jprogn.var;

import java.math.BigDecimal;

public class VarNumber implements Var {

	public BigDecimal data;
	
	public VarNumber(){
		data = new BigDecimal(0);
	}
	
	public VarNumber(int arg0) {
		data = new BigDecimal(arg0);
	}
	
	public VarNumber(String arg0){
		data = new BigDecimal(arg0);
	}
	
	
	public VarNumber(BigDecimal add) {
		data = add;
	}

	public String toString(){
		return asString().data;
	}

	@Override
	public VarString asString() {
		return new VarString(data.toPlainString());
	}

	@Override
	public VarNumber asNumber() {
		return this;
	}

	@Override
	public VarStack asStack() {
		return new VarStack(this);
	}
	
}
