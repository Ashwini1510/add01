/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com;

import com.google.common.collect.Table.Cell;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author sunil
 */
public class FileUtil {
    public static FacebookVO loadData() throws Exception{
        FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Facebook.xlsx"));
        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet
        Sheet firstSheet = workbook.getSheetAt(0); //first TAB
        //get second row  (with values)
        Row r =  firstSheet.getRow(1);
        org.apache.poi.ss.usermodel.Cell c = r.getCell(0); //what value
        String login = c.getStringCellValue();
        c = r.getCell(1); //where value
        String password = c.getStringCellValue();
       
       FacebookVO facebook = new FacebookVO(login, password);
       
        System.out.println(facebook);
        inputStream.close();
        return facebook;
    }
}