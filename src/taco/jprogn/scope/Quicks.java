package taco.jprogn.scope;

import taco.jprogn.compiler.concept.Concept;
import taco.jprogn.compiler.concept.ConceptSingle;
import taco.jprogn.quicks.Quick;
import taco.jprogn.quicks.QuickDyadChunk;
import taco.jprogn.quicks.QuickEnd;
import taco.jprogn.quicks.QuickFlip;
import taco.jprogn.quicks.QuickMonadChunk;
import taco.jprogn.quicks.QuickNiladChunk;
import taco.jprogn.quicks.QuickToFunc;
import taco.jprogn.quicks.QuickToFuncRun;

public class Quicks {
	public static Quick[] quicks = new Quick[256];
	public static void Init(){
		quicks[0x8D] = new QuickNiladChunk();
		quicks[0x81] = new QuickMonadChunk();
		quicks[0x82] = new QuickDyadChunk();
		quicks[0x8E] = new QuickEnd();
		quicks[0x23] = new QuickToFunc();
		quicks[0x02] = new QuickToFuncRun();
		quicks[0x5C] = new QuickFlip();
	}
	
	public static boolean isQuick(Concept c){
		if(c instanceof ConceptSingle){
			if(quicks[((ConceptSingle)c).name & 0xFF]!=null)
				return true;
		}
		return false;
	}
}
