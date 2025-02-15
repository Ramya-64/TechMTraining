package week2Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseList_4 {
	public static <t>List<t> reverse(List<t> list){
		List<t> reverseList=new ArrayList<t>();
		for(int i=list.size()-1;i>=0;i--) {
			reverseList.add(list.get(i));
		}
		return reverseList;
	}
	public static void main(String[] args) {
		List<Integer> elements=Arrays.asList(1,2,3,4,5);
		System.out.println(reverse(elements));
		
	}

}
