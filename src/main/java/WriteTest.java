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
 * Created by 15 on 16.08.2018.
 */
public class WriteTest {


    public static void main(String... args) throws IOException {
        LinkedList<RowPeptideWithB> rowPeptideWithBS = new LinkedList<RowPeptideWithB>();

        Map<String,Double> map60 = new HashMap<String, Double>();
        Map<String,Double> map60NL = new HashMap<String, Double>();
        Map<String,Double> mapMinus10 = new HashMap<String, Double>();
        Map<String,Double> mapMinus20 = new HashMap<String, Double>();
        Map<String,Double> mapPlus10 = new HashMap<String, Double>();
        Map<String,Double> mapPlus20 = new HashMap<String, Double>();
        Map<String,Double> mapPlus30 = new HashMap<String, Double>();
        Map<String,Double> mapPlus40 = new HashMap<String, Double>();

        map60=readFromExcel("C:\\IT\\excel\\60.xls", "extended_DIA_1hour_linear_20071");
        map60NL=readFromExcel("C:\\IT\\excel\\60NL.xls", "extended_DIA_1hour_NL_base_2007");
        mapMinus10=readFromExcel("C:\\IT\\excel\\minus10.xls","extended_DIA_minus10");
        mapMinus20=readFromExcel("C:\\IT\\excel\\minus20.xls","extended_DIA_minus20");
        mapPlus10=readFromExcel("C:\\IT\\excel\\plus10.xls","extended_DIA_plus10");
        mapPlus20=readFromExcel("C:\\IT\\excel\\plus20.xls", "extended_DIA_plus20");
        mapPlus30=readFromExcel("C:\\IT\\excel\\plus30.xls","extended_DIA_plus30");
        mapPlus40=readFromExcel("C:\\IT\\excel\\plus40.xls","extended_DIA_plus40");

        int numberRow=1;

        for (Map.Entry<String, Double> entry8 : mapPlus40.entrySet()) {
            String key = entry8.getKey();
            if (map60.get(key)!=null&&map60NL.get(key)!=null&&mapMinus10.get(key)!=null&&mapMinus20.get(key)!=null&&
                    mapPlus10.get(key)!=null&&mapPlus20.get(key)!=null&&mapPlus30.get(key)!=null){
//                writeIntoExcel("C:\\IT\\excel\\resultMedi.xls", numberRow, key, map60.get(key),
//                        map60NL.get(key), mapMinus10.get(key), mapMinus20.get(key), mapPlus10.get(key),
//                        mapPlus20.get(key),mapPlus30.get(key),entry8.getValue());
//                System.out.println(key+"  "+ map60.get(key)+"  " +entry8.getValue());
                rowPeptideWithBS.add(new RowPeptideWithB(key, map60.get(key),
                        map60NL.get(key), mapMinus10.get(key), mapMinus20.get(key), mapPlus10.get(key),
                        mapPlus20.get(key),mapPlus30.get(key),entry8.getValue()));
                numberRow++;
            }

        }
        writeIntoExcel("C:\\IT\\excel\\resultMedi.xls", rowPeptideWithBS);

//        System.out.println(map60.get("1_MADEAGSEADHEGTHSTKR_4_run0"));


//        int n=0;
//        for (Map.Entry<String, Double> entry : map60.entrySet()) {
//            System.out.println("ID =  " + entry.getKey() + " b = " + entry.getValue());
//            n++;
//        }
//        System.out.println(map60.size());
//        writeIntoExcel("C:\\IT\\1.xls");
    }
    @SuppressWarnings("deprecation")
//    public static void writeIntoExcel(String file, int n, String peptide, double b_60,
//                                      double b_60NL,double b_minus10,double b_minus20,
//                                      double b_plus10, double b_plus20, double b_plus30,
//                                      double b_plus40) throws FileNotFoundException, IOException {
    public static void writeIntoExcel(String file, LinkedList<RowPeptideWithB> list) throws FileNotFoundException, IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("B");

        for (int i=0;i<list.size();i++){

            Row row = sheet.createRow(i);

            Cell namePeptide = row.createCell(0);
            namePeptide.setCellValue(list.get(i).getPeptide());

            Cell cell_b_60 = row.createCell(1);
            cell_b_60.setCellValue(list.get(i).getB_60());

            Cell cell_b_60NL = row.createCell(2);
            cell_b_60NL.setCellValue(list.get(i).getB_60NL());

            Cell cell_b_minus10 = row.createCell(3);
            cell_b_minus10.setCellValue(list.get(i).getB_minus10());

            Cell cell_b_minus20 = row.createCell(4);
            cell_b_minus20.setCellValue(list.get(i).getB_minus20());

            Cell cell_b_plus10 = row.createCell(5);
            cell_b_plus10.setCellValue(list.get(i).getB_plus10());

            Cell cell_b_plus20 = row.createCell(6);
            cell_b_plus20.setCellValue(list.get(i).getB_plus20());

            Cell cell_b_plus30 = row.createCell(7);
            cell_b_plus30.setCellValue(list.get(i).getB_plus30());

            Cell cell_b_plus40 = row.createCell(8);
            cell_b_plus40.setCellValue(list.get(i).getB_plus40());
        }

        // Нумерация начинается с нуля
//        Row row = sheet.createRow(n);
//
//        Cell namePeptide = row.createCell(0);
//        namePeptide.setCellValue(peptide);
//
//        Cell cell_b_60 = row.createCell(1);
//        cell_b_60.setCellValue(b_60);
//
//        Cell cell_b_60NL = row.createCell(2);
//        cell_b_60NL.setCellValue(b_60NL);






        // Мы запишем имя и дату в два столбца
        // имя будет String, а дата рождения --- Date,
        // формата dd.mm.yyyy


//        Cell name = row.createCell(0);
//        name.setCellValue("John");
//
//        Cell birthdate = row.createCell(1);
//
//        DataFormat format = book.createDataFormat();
//        CellStyle dateStyle = book.createCellStyle();
//        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//        birthdate.setCellStyle(dateStyle);


        // Нумерация лет начинается с 1900-го
//        birthdate.setCellValue(new Date(110, 10, 10));

        // Меняем размер столбца
//        sheet.autoSizeColumn(1);

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
                    row.getCell(57).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                String name = row.getCell(0).getStringCellValue();
                double b = row.getCell(57).getNumericCellValue();
                map.put(name,b);
            }

        }

//        HSSFRow row = myExcelSheet.getRow(0);
//
//        if(row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING){
//            String name = row.getCell(0).getStringCellValue();
//            System.out.println("name : " + name);
//        }
//
//        if(row.getCell(1).getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
//            Date birthdate = row.getCell(1).getDateCellValue();
//            System.out.println("birthdate :" + birthdate);
//        }

        myExcelBook.close();
        return map;
    }
}
