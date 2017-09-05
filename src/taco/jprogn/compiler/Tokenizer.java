package taco.jprogn.compiler;

import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.compiler.concept.ConceptMulti;
import taco.jprogn.compiler.concept.ConceptSingle;

public class Tokenizer {
	public static Concept[] tokenize(byte[] code){
		Concept[] tempArr = new Concept[code.length]; // We default to the length of the code, as that should be the largest this concept array can possibly be.
		int currElemt = 0;
		for(int i=0; i < code.length; i++){
			int strt;
			switch(code[i]){
			case 0x22:
				strt = i++;
				while(++i+1<code.length && code[i]!=0x22){};
				tempArr[currElemt++] = new ConceptMulti(copyByteRange(code, strt, i));
				break;
			case 0x27:
				strt = i++;
				while(++i+1<code.length && code[i]!=0x27){};
				tempArr[currElemt++] = new ConceptMulti(copyByteRange(code, strt, i));
				break;
			case 0x60:
				tempArr[currElemt++] = new ConceptMulti(copyByteRange(code, i++, i));
				break;
			case 0x24:
				strt = i++;
				while(++i+1<code.length && code[i+1]>=0x30 && code[i+1]<=0x39){};
				tempArr[currElemt++] = new ConceptMulti(copyByteRange(code, strt, i));
				break;
			default:
				tempArr[currElemt++] = new ConceptSingle(code[i]);
				break;
			}
		}
		Concept[] newArr = new Concept[currElemt];
		for(int i=0; i < currElemt; i++){
			newArr[i] = tempArr[i];
		}
		return newArr;
	}
	
	private static byte[] copyByteRange(byte[] orignal, int start, int end){
		byte[] out = new byte[end-start+1];
		for(int i=start; i <= end; i++){
			out[i-start] = orignal[i];
		}
		return out;
	}
}
