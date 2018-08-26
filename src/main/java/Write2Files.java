import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/**
 * Created by 15 on 17.08.2018.
 */
public class Write2Files {
    public static void main(String... args) throws IOException {

        LinkedList<Row2Peptides> row2Peptides = new LinkedList<Row2Peptides>();
        Map<String,Double> mapFirst = new HashMap<String, Double>();
        Map<String,Double> mapSecond = new HashMap<String, Double>();


        mapFirst=readFromExcel("C:\\IT\\excel\\13A.xls", "extended_Arnoud_60_minutes_13A_");
        mapSecond=readFromExcel("C:\\IT\\excel\\13E.xls", "extended_Arnoud_60_minutes_13E");


        for (Map.Entry<String, Double> entry : mapSecond.entrySet()) {
            String key = entry.getKey();
            if (mapFirst.get(key)!=null){

               row2Peptides.add(new Row2Peptides(key, mapFirst.get(key), entry.getValue()));

            }

        }
        writeIntoExcel("C:\\IT\\excel\\result_2.xls", row2Peptides);

    }
    @SuppressWarnings("deprecation")

    public static void writeIntoExcel(String file, LinkedList<Row2Peptides> list) throws FileNotFoundException, IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("B");
        int b=list.size()+2;
        for (int i=0;i<list.size();i++){

            Row row = sheet.createRow(i);
//            Row row2 = sheet.createRow(b);
            Cell namePeptide = row.createCell(0);
            namePeptide.setCellValue(list.get(i).getPeptide());

            Cell cell_b_first = row.createCell(1);
            cell_b_first.setCellValue(list.get(i).getbFirst());

            Cell cell_b_second = row.createCell(2);
            cell_b_second.setCellValue(list.get(i).getbSecond());

            Cell cell_b_first_minus_b_second = row.createCell(3);
            cell_b_first_minus_b_second.setCellValue(list.get(i).getbFirst()-list.get(i).getbSecond());

            if (i%19==0&&i!=0){

                Cell cell_b_second_mid = row.createCell(4);
                double sum=0;
                for (int a=i-19;a<i+1;a++){
                    sum = sum+list.get(a).getbSecond();
                }
                sum=sum/20;
                cell_b_second_mid.setCellValue(sum);

                Cell cell_b_first_minus_b_second_mid = row.createCell(5);

                double sum2=0;
                for (int a=i-19;a<i+1;a++){
                    sum2 = sum2+list.get(a).getbFirst()-list.get(a).getbSecond();
                }
                sum2=sum2/20;

                cell_b_first_minus_b_second_mid.setCellValue(sum2);
                b++;
            }


        }



        // Записываем всё в файл
        book.write(new FileOutputStream(file));
        book.close();
    }

    public static Map<String,Double> readFromExcel(String file, String sheet) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
        Map<String,Double> map = new HashMap<String, Double>();

        for (int i=0; i<myExcelSheet.getLastRowNum()+1; i++){
            HSSFRow row = myExcelSheet.getRow(i);
            if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING&&
                    row.getCell(56).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                String name = row.getCell(0).getStringCellValue();
                double b = row.getCell(56).getNumericCellValue();
                map.put(name,b);
            }

        }


        myExcelBook.close();
        return map;
    }
}


