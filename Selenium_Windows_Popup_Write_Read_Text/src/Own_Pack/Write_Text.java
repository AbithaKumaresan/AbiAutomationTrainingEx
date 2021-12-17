package Own_Pack;

import java.io.FileWriter;
import java.io.IOException;

public class Write_Text {
	public static void main(String[] args) throws IOException {
	FileWriter file = new FileWriter("C:\\Users\\abitha.k.IQZAD\\OneDrive - IQZ Systems, LLC\\Eclips_Work\\Selenium_Windows_Popup_Write_Read_Text\\Files\\Filecre.txt", true);
	file.write("Welcome!!!");
	file.write("\n");
	file.write("I just created my very first file using Java");
	file.close();
	System.out.println("File creation successful");
}
}