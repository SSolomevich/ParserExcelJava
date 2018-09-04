import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class WriteMid {
    public static void main(String... args) throws IOException {

    LinkedList<Mid> mids = new LinkedList<Mid>();
    Map<Double,Double> mapForMid = new TreeMap<Double, Double>();



    mapForMid=readFromExcel("C:\\IT\\excel\\result_2.xls", "B");

        for (Map.Entry<Double, Double> entry : mapForMid.entrySet()) {
            Double key = entry.getKey();


                mids.add(new Mid(key, mapForMid.get(key)));



        }

    writeIntoExcel("C:\\IT\\excel\\mid.xls", mids);

}
    @SuppressWarnings("deprecation")

    public static void writeIntoExcel(String file, LinkedList<Mid> list) throws FileNotFoundException, IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("B_mid");
        int b=0;




        for (int i=0;i<list.size();i++){

//            Row row = sheet.createRow(i);
            Row row2 = sheet.createRow(b);
//            Cell namePeptide = row.createCell(0);
//            namePeptide.setCellValue(list.get(i).getB_mid());

//            Cell cell_b_first = row.createCell(1);
//            cell_b_first.setCellValue(list.get(i).getDelta_mid());
//





            if (i%19==0&&i!=0){
                Cell b1 = row2.createCell(0);
                b1.setCellValue(list.get(i-19).getDelta_mid());

                Cell b2 = row2.createCell(1);
                b2.setCellValue(list.get(i-18).getDelta_mid());

                Cell b3 = row2.createCell(2);
                b3.setCellValue(list.get(i-17).getDelta_mid());

                Cell b4 = row2.createCell(3);
                b4.setCellValue(list.get(i-16).getDelta_mid());

                Cell b5 = row2.createCell(4);
                b5.setCellValue(list.get(i-15).getDelta_mid());

                Cell b6 = row2.createCell(5);
                b6.setCellValue(list.get(i-14).getDelta_mid());

                Cell b7 = row2.createCell(6);
                b7.setCellValue(list.get(i-13).getDelta_mid());

                Cell b8 = row2.createCell(7);
                b8.setCellValue(list.get(i-12).getDelta_mid());

                Cell b9 = row2.createCell(8);
                b9.setCellValue(list.get(i-11).getDelta_mid());

                Cell b10 = row2.createCell(9);
                b10.setCellValue(list.get(i-10).getDelta_mid());

                Cell b11 = row2.createCell(10);
                b11.setCellValue(list.get(i-9).getDelta_mid());

                Cell b12 = row2.createCell(11);
                b12.setCellValue(list.get(i-8).getDelta_mid());

                Cell b13 = row2.createCell(12);
                b13.setCellValue(list.get(i-7).getDelta_mid());

                Cell b14 = row2.createCell(13);
                b14.setCellValue(list.get(i-6).getDelta_mid());

                Cell b15 = row2.createCell(14);
                b15.setCellValue(list.get(i-5).getDelta_mid());

                Cell b16 = row2.createCell(15);
                b16.setCellValue(list.get(i-4).getDelta_mid());

                Cell b17 = row2.createCell(16);
                b17.setCellValue(list.get(i-3).getDelta_mid());

                Cell b18 = row2.createCell(17);
                b18.setCellValue(list.get(i-2).getDelta_mid());

                Cell b19 = row2.createCell(18);
                b19.setCellValue(list.get(i-1).getDelta_mid());

                Cell b20 = row2.createCell(19);
                b20.setCellValue(list.get(i).getDelta_mid());







                Cell cell_b_second_mid = row2.createCell(21);
                double sum=0;
                for (int a=i-19;a<i+1;a++){
                    sum = sum+list.get(a).getB_mid();
                }
                sum=sum/20;
                cell_b_second_mid.setCellValue(sum);

                Cell cell_b_first_minus_b_second_mid = row2.createCell(22);

                double sum2=0;
                for (int a=i-19;a<i+1;a++){
                    sum2 = sum2+list.get(a).getDelta_mid();
                }
                sum2=sum2/20;

                cell_b_first_minus_b_second_mid.setCellValue(sum2);

                Cell cell_n = row2.createCell(23);
                cell_n.setCellValue(20);
                Cell cell_n2 = row2.createCell(24);
                cell_n2.setCellValue(19);



                b++;
            }

        }



        // Записываем всё в файл
        book.write(new FileOutputStream(file));
        book.close();
    }

    public static Map<Double,Double> readFromExcel(String file, String sheet) throws IOException{
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet(sheet);
        Map<Double,Double> map = new TreeMap<Double, Double>();

        for (int i=0; i<myExcelSheet.getLastRowNum()+1; i++){
            HSSFRow row = myExcelSheet.getRow(i);
//            if(row.getCell(2).getCellType() == HSSFCell.CELL_TYPE_NUMERIC&&
//                    row.getCell(3).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                double name = row.getCell(2).getNumericCellValue();
                double b = row.getCell(3).getNumericCellValue();
                map.put(name,b);
//            }

        }


        myExcelBook.close();
        return map;
    }
}
