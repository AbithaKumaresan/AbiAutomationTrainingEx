package Projec1;

public class Reverse_String {
  
public static void main(String[] args){

	String InputValue = "abitha";
	char[] chars = InputValue.toCharArray();
	int length = chars.length;
  System.out.println("The char lenght is: " +length);
for (int i = length-1; i>=0; i--)
{	
System.out.print(chars[i]);	
}
}
} 

