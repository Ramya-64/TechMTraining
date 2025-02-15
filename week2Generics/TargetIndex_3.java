package week2Generics;

import java.util.Arrays;
import java.util.List;

public class TargetIndex_3 {
	public static <t>int index(List<t> list, t target){
		for(int i=0;i<list.size();i++) {
			if(list.get(i).equals(target))
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		List<Integer> elements=Arrays.asList(9,2,5,3,4,6,5);
		System.out.println("Index of 5: "+index(elements,5));
		
	}

}
