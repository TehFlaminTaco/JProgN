package taco.jprogn.var;

public class VarString implements Var {

	public String data;
	
	public VarString(String data){
		this.data = data;
	}
	
	public VarString(char b) {
		data = new String(new char[]{b});
	}
	
	public String toString(){
		return asString().data;
	}

	@Override
	public VarString asString() {
		return this;
	}

	@Override
	public VarNumber asNumber() {
		try{
			return new VarNumber(data);
		}catch(Exception e){
			return new VarNumber(0);
		}
	}

	@Override
	public VarStack asStack() {
		VarStack stack = new VarStack();
		char[] cArr = data.toCharArray();
		for(int i=0; i < cArr.length; i++){
			stack.push(new VarString(cArr[i]));
		}
		return stack;
	}

	@Override
	public boolean truthy() {
		return data.length()>0;
	}

	@Override
	public boolean v_equals(Var other) {
		if(other instanceof VarString){
			return other.asString().data.equals(data);
		}
		return false;
	}

}
