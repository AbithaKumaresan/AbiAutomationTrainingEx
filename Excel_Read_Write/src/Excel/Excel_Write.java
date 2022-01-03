package Excel;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Write {
    public static void main(String[] args) throws IOException {
        
        XSSFWorkbook workbook = new XSSFWorkbook();
       XSSFSheet sheet = workbook.createSheet("Book");
       
       Object list[][] = { {"Name","Country","Postion"},
                      {"Ronaldo","Portugal","Striker"},
                      {"Messi","Argentina" ,"Left Wing"},
                      {"Neymar","Brazil","Forward"}
       };
       
       int rows =list.length;
       int column =list[0].length;
       
       for(int r=0;r<rows;r++) {
               XSSFRow row = sheet.createRow(r);
               for(int c=0;c<column;c++) {
                      XSSFCell cell = row.createCell(c);
                      
                      Object value = list[r][c];
                      
                      if(value instanceof String)
                              cell.setCellValue((String)value);
                      if(value instanceof Integer)
                              cell.setCellValue((Integer)value);
                      if(value instanceof Boolean)
                              cell.setCellValue((Boolean)value);
                      
               }
       }
       
       String filePath = ".\\dataFile\\writeExcel.xlsx";
       FileOutputStream outputstream = new FileOutputStream(filePath);
       workbook.write(outputstream);
       outputstream.close();
       
       System.out.println("File writing operation is successful");

}

}
