package week2Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeList_5 {
		public static <t>List<t> merge(List<t> list1,List<t> list2){
			List<t> mergeList=new ArrayList<t>();
			for(int i=0;i<list1.size();i++) {
				for(int j=i;j<=i;j++) {
					mergeList.add(list1.get(i));
					mergeList.add(list2.get(j));
				}
			}
			return mergeList;
		}
		public static void main(String[] args) {
			List<Integer> list1=Arrays.asList(1,2,3,4,5);
			List<Integer> list2=Arrays.asList(6,7,8,9,10);
			System.out.println("Alternate Merging Of two list: "+merge(list1,list2));			
		}

	}

