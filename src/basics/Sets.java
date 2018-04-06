package basics;

import java.util.HashSet; //random order
import java.util.LinkedHashSet;    //ordered in the way they were entered
import java.util.Set;
import java.util.TreeSet;	//ordered alphabetically

public class Sets {

	public static void main(String[] args) {
		//define collection
		Set<String> colors = new HashSet<String>();  //polymorphism
		
		
		colors.add("blue");
		colors.add("red");
		colors.add("green");
		colors.add("magenta");
		colors.add("green");    //this will be excluded as only unique items are printed
		colors.add("gold");
		System.out.println(colors);
		
		Set<String> otherColors = new HashSet<String>();
		
		otherColors.add("cyan");
		otherColors.add("yellow");
		otherColors.add("purple");
		otherColors.add("magenta");
		otherColors.add("grey");
		
		//"AND"
		Set<String> intersectionSet = new HashSet<String>(colors);
		intersectionSet.retainAll(otherColors);
		System.out.println("The intersection is: " + intersectionSet);
		
		//"OR"
		Set<String> unionSet = new HashSet<String>(colors);
		unionSet.addAll(otherColors);
		System.out.println("The union is: " + unionSet);
		
		//In 1 but not the other
		Set<String> differenceSet = new HashSet<String>(colors);
		differenceSet.removeAll(otherColors);
		System.out.println("The difference is: " + differenceSet);
		
		Set<String> linkedColors = new LinkedHashSet<String>();
		linkedColors.addAll(colors);
		linkedColors.addAll(otherColors);
		System.out.println("Ordered in the way entered: " + linkedColors);
		
		Set<String> treeColors = new TreeSet<String>();
		treeColors.addAll(otherColors);
		System.out.println("Alphabetically ordered: " + treeColors);
	}

}
