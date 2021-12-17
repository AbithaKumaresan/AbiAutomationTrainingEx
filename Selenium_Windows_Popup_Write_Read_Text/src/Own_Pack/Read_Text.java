package Own_Pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read_Text {
	public static void main(String[] args) throws IOException 
	{
		FileReader file = new FileReader("C:\\Users\\abitha.k.IQZAD\\OneDrive - IQZ Systems, LLC\\Eclips_Work\\Selenium_Windows_Popup_Write_Read_Text\\Files\\Filecre.txt");
		BufferedReader read = new BufferedReader(file);
		String text;
		while((text=read.readLine())!=null) {
			System.out.println(text);
			}
		read.close();
	}
}
