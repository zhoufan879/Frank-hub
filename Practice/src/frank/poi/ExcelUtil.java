package frank.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	private static List<Object> all;
	private static File file_2003 = new File("F:\\SFKJ\\团队工作\\工作周报\\工作周报模板-姓名.xls");
	private static File file_2007 = new File("F:\\SFKJ\\通讯录.xlsx");
	
	private static File out_2003 = new File("F:\\SFKJ\\通讯录-2003.xls");
	private static File out_2007 = new File("F:\\SFKJ\\通讯录-2007.xlsx");
	
	public static void main(String[] args) {
		read(file_2003);
		write(out_2003);
		
		read(file_2007);
		write(out_2007);
	}

	public static void read(File file ) {
		FileInputStream fis = null;
        
        try {
        	all = new ArrayList<Object>();
            Workbook wb = null;
            Sheet sheet1;
            int rows;
            Row row;
            fis = new FileInputStream(file);
            wb = getWorkbook(file, fis);
            sheet1 = wb.getSheetAt(0);                
            rows = sheet1.getPhysicalNumberOfRows();
            
            for(int i = 1; i < rows; i++ ){
                row = sheet1.getRow(i);
                if (row == null) {  continue; }
                    int cells = row.getPhysicalNumberOfCells();                    
                    String obj = null;
                    for(int j = 0; j < cells; j++ ){
                        Cell cell = row.getCell(j);
                        if (cell == null) { System.out.print(" | ");continue; }
                        String value = null;
                        
                        System.out.print(cell.getCellType() + " - ");
                        switch (cell.getCellType()) {
                                case Cell.CELL_TYPE_FORMULA:
                                        value = cell.getCellFormula();
                                        break;
                                case Cell.CELL_TYPE_NUMERIC:
                                        value = ""+cell.getNumericCellValue();
                                        break;
                                case Cell.CELL_TYPE_STRING:
                                        value = cell.getStringCellValue();
                                        break;
                                default:
                                        value = cell.getCellType() + "-"+ cell.getDateCellValue();
                        }
                        System.out.print(value + " | ");
                        obj += value;
                    }
                    System.out.println();

                    all.add(obj);
            }
        } catch (FileNotFoundException ex) {
        	ex.printStackTrace();
        } catch (IOException ex) {
        	ex.printStackTrace();
        } catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException ex) {
                	ex.printStackTrace();
                }
            }
        }
	}

	public static void write(File export ) {
		Workbook wb = null;
        FileOutputStream fileOut = null;
        try {
            if(all!=null && all.size()>0){
                wb = getWorkbook(export, null, true);
                String date = new SimpleDateFormat("yyyyMMddHHHHmmss").format(new Date());
                Sheet sheet = wb.createSheet("sheet-" + date);
                Row row;
                int index = 0;
                
                for(Object d : all){
                    row = sheet.createRow(index++);
                    row.createCell(0).setCellValue(d.toString());
                }
                                
                fileOut = new FileOutputStream(export);
                wb.write(fileOut);
            }          
            
            System.out.println("write succ!!!");
        } catch (FileNotFoundException ex) {
        	ex.printStackTrace();
        } catch (IOException ex) {
        	ex.printStackTrace();
        } catch (InvalidFormatException e) {
			e.printStackTrace();
		} finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
            	ex.printStackTrace();
            }
        }
	}
	
	public static Workbook getWorkbook(File xls, FileInputStream fis ) throws InvalidFormatException, IOException {
		return getWorkbook(xls, fis, false);
	}
	
	@SuppressWarnings("resource")
	public static Workbook getWorkbook(File xls, FileInputStream fis, boolean r ) throws InvalidFormatException, IOException {
		if(xls.getAbsolutePath().endsWith(".xlsx")){
			return r?new XSSFWorkbook():new XSSFWorkbook(fis);
		} else if(xls.getAbsolutePath().endsWith(".xls")) {
			return r?new HSSFWorkbook():new HSSFWorkbook(fis);
		} else {
			return null;
		}
	}
}
