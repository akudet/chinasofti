package test3;

import java.util.*;

public class SortInfoByAge {
	
	public static void main(String[] args) {
		List<Info> infomations = new ArrayList<Info>();
		
		infomations.add(new Info("zaft", "male", 17));
		infomations.add(new Info("jtwu", "male", 23));
		infomations.add(new Info("kyo", "male", 15));
		infomations.add(new Info("izumi", "male", 16));
		
		Collections.sort(infomations, new Comparator<Info>() {

			public int compare(Info o1, Info o2) {
				return new Integer(o1.getAge()).compareTo(o2.getAge());
			}
			
		});
		
		for (Info info : infomations) {
			System.out.println(info);
		}
	}

}
