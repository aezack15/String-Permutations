import java.util.*;
import java.io.*;

public class stringPermutations{
	public static void main(String[] args){
		stringPermutations sp=new stringPermutations();
		boolean cont=true;
		while(cont==true){	
			String userString=sp.getUserString();
			int length=userString.length();
			sp.findPermutations(userString, length);
			cont=sp.tryAgain();
		}
	}
	/*retrieves user generated string*/
	private String getUserString(){
		String s="";
		Scanner in=new Scanner(System.in);
		System.out.println("Please enter a string");
		System.out.print("> ");
		s=in.next();
		return s;
	}
	/*calculates facotirals used in determining the # of permutations*/
	private int factorial(int length){
		if(length==0){
			return 1;
		}
		return length * factorial(length-1);
	}
	
	/*
	finds the total number of string permutations possible
	= (Length of String)! / ((char repeats)! * (char repeats)! etc...)
	*/
	private int numOfP(String a){
		int[] dupes=new int[a.length()];
		char[] charArray=a.toCharArray();
		char[] values=new char[a.length()];
		for(int i=a.length()-1;i>=0;i--){
			values[i]=charArray[i];
		}
		//calculates the number of duplicate characters in the string.
		for(int i=0;i<a.length();i++){
			char check=charArray[i];
			for(int j=0;j<a.length();j++){
				if(check==charArray[j]&&values[j]!='0'){
					dupes[i]=dupes[i]+1;
					values[j]='0';
				}
			}
		}
		int denominator=sum(a,dupes);
		int total=(factorial(a.length())/denominator);
		return total;
	}
	//finds the number of possible permutations for a given string
	private int sum(String a, int[] dupes){
		int total=1;
		for(int i=0;i<a.length();i++){
			if(dupes[i]==0){
				dupes[i]=1;
			}
			total=total*factorial(dupes[i]);
		}
		return total;
	}
	/*
	Implements a highly inefficient algorithm (lol) for creating a new permutation.
	*/
	private void findPermutations(String a, int length){
		int numOfPermutations=numOfP(a);
		String foo="";
		ArrayList<String> list=new ArrayList<String>();
		cell[] temp=new cell[a.length()];
		for(int i=0;i<a.length();i++){
			cell b=new cell();
			b.c=a.charAt(i);
			b.isVisited=false;
			temp[i]=b;
		}
		list.add(a);
		while(list.size()<numOfPermutations){
			Random rand=new Random();			
			foo="";
			while(foo.length()<length){
				int randIndex=rand.nextInt(length);
				if(temp[randIndex].isVisited==false){
					foo=foo+a.charAt(randIndex);
					temp[randIndex].isVisited=true;
				}
				else{continue;}
			}
			if(!list.contains(foo)){
				list.add(foo);
			}
			for(int i=0;i<length;i++){
				temp[i].isVisited=false;
			}
		}
		//Collections.sort is awesome!
		Collections.sort(list);
		System.out.println("There were " + list.size() + " unique combinations:");
		System.out.println(list);
	}
	
	private boolean tryAgain(){
		System.out.println("");
		System.out.println("Would you like to try another string? y or n");
		System.out.print("> ");
		Scanner in=new Scanner(System.in);
		String cont=in.next();
		if(cont.equals("y")){
			System.out.println("");
			return true;
		}
		return false;
	}
}
