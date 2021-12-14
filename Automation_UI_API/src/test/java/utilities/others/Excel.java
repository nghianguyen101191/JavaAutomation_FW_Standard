package utilities.others;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Excel {
  public String path;
  public FileInputStream fis = null;
  public FileOutputStream fileOut = null;
  private HSSFWorkbook workbook = null;
  private HSSFSheet sheet = null;
  private HSSFRow row = null;
  private HSSFCell cell = null;

  public static List<String> readFirstRow(String filePath, String sheetName) {
    List<String> fieldsArrayList = new ArrayList<String>();
    try {
      FileInputStream myInput = new FileInputStream(new File(filePath));
      Workbook workBook = WorkbookFactory.create(myInput);
      Sheet sheet = workBook.getSheet(sheetName); // return sheet name
      Row firstRow = sheet.getRow(0); // get first row
      int length = firstRow.getLastCellNum(); // get first row lengh
      Cell cell = null; // define cell is null value

      for (int i = 0; i < length; i++) {
        cell = firstRow.getCell(i);
        fieldsArrayList.add(cell.toString());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return fieldsArrayList;
  }

  public static List<HashMap<String, String>> readXSLXFile(String filePath, String sheetName) {
    List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
    try {
      FileInputStream myInput = new FileInputStream(new File(filePath));
      Workbook workBook = WorkbookFactory.create(myInput);
      Sheet sheet = workBook.getSheet(sheetName);

      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row rowFields = sheet.getRow(0);
        Row data = sheet.getRow(i);
        if (data == null || data.getLastCellNum() <= 0) continue;
        HashMap<String, String> hmData = new HashMap<>();

        for (int j = 0; j < rowFields.getLastCellNum(); j++) {
          Cell dataCell = data.getCell(j);
          hmData.put(rowFields.getCell(j).toString().trim(), convertCell(dataCell));
        }

        listData.add(hmData);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return listData;
  }

  public static List<HashMap<String, String>> readXSLXFileID(
      String filePath, String sheetName, String testCaseID) throws Exception {
    List<HashMap<String, String>> listData = new ArrayList<HashMap<String, String>>();
    try {
      FileInputStream myInput = new FileInputStream(new File(filePath));
      Workbook workBook = WorkbookFactory.create(myInput);
      Sheet sheet = workBook.getSheet(sheetName);

      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row rowFields = sheet.getRow(0);
        Row data = sheet.getRow(i);

        if (data == null) {
          continue;
        }

        if (data.getLastCellNum() < 0) {
          continue;
        }

        if (!data.getCell(0).toString().trim().equals(testCaseID)) {
          continue;
        }
        HashMap<String, String> hmData = new HashMap<>();

        for (int j = 0; j < rowFields.getLastCellNum(); j++) {
          Cell dataCell = data.getCell(j);
          hmData.put(rowFields.getCell(j).toString().trim(), convertCell(dataCell));
        }
        listData.add(hmData);
      }

    } catch (Throwable t) {
      throw new Exception("error read readXSLXFileID");
    }

    return listData;
  }

  @SuppressWarnings("unchecked")
  public static Object[][] readXSLXFileDataProvider(String filePath, String sheetName) {
    HashMap<String, String>[][] listData = null;
    try {
      FileInputStream myInput = new FileInputStream(new File(filePath));
      Workbook workBook = WorkbookFactory.create(myInput);
      Sheet sheet = workBook.getSheet(sheetName);
      listData = new HashMap[sheet.getLastRowNum()][1];
      for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        Row rowFields = sheet.getRow(0);
        Row data = sheet.getRow(i);
        if (data == null || data.getLastCellNum() <= 0) continue;
        HashMap<String, String> hmData = new HashMap<>();

        for (int j = 0; j < rowFields.getLastCellNum(); j++) {
          Cell dataCell = data.getCell(j);
          hmData.put(rowFields.getCell(j).toString().trim(), convertCell(dataCell));
        }

        listData[i - 1][0] = hmData;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return listData;
  }

  @SuppressWarnings("deprecation")
  private static String convertCell(Cell c) {
    c.setCellType(Cell.CELL_TYPE_STRING);
    String result = "";
    if (c == null || c.getCellTypeEnum() == CellType.BLANK) {
      result = "";
    } else {
      result = c.toString().trim();
    }

    return result;
  }

  /*
  Extra more method excel

  */

  public void ReadExcelSheet(String path) {

    this.path = path;
    try {
      fis = new FileInputStream(path);
      workbook = new HSSFWorkbook(fis);
      sheet = workbook.getSheetAt(0);
      fis.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public int getRowCount(String sheetName) {
    int index = workbook.getSheetIndex(sheetName);
    if (index == -1) return 0;
    else {
      int number = sheet.getPhysicalNumberOfRows();
      return number;
    }
  }

  public String getCellData(String sheetName, String colName, int rowNum) {
    try {
      if (rowNum <= 0) return "";

      int index = workbook.getSheetIndex(sheetName);
      int col_Num = -1;
      if (index == -1) return "";

      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++) {
        if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) col_Num = i;
      }
      if (col_Num == -1) return "";

      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(rowNum - 1);
      if (row == null) return "";
      cell = row.getCell(col_Num);

      if (cell == null) return "";
      // System.out.println(cell.getCellType());
      if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
      else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
          || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

        String cellText = String.valueOf(cell.getNumericCellValue());
        if (HSSFDateUtil.isCellDateFormatted(cell)) {
          // format in form of M/D/YY
          double d = cell.getNumericCellValue();

          Calendar cal = Calendar.getInstance();
          cal.setTime(HSSFDateUtil.getJavaDate(d));
          cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
          cellText =
              cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH) + 1 + "/" + cellText;
        }

        return cellText;
      } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return "";
      else return String.valueOf(cell.getBooleanCellValue());

    } catch (Exception e) {

      e.printStackTrace();
      return "row " + rowNum + " or column " + colName + " does not exist in xls";
    }
  }

  public String getCellData(String sheetName, int colNum, int rowNum) {
    try {
      if (rowNum <= 0) return "";

      int index = workbook.getSheetIndex(sheetName);

      if (index == -1) return "";

      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(rowNum - 1);
      if (row == null) return "";
      cell = row.getCell(colNum);
      if (cell == null) return "";

      if (cell.getCellType() == Cell.CELL_TYPE_STRING) return cell.getStringCellValue();
      else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
          || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

        String cellText = String.valueOf(cell.getNumericCellValue());
        if (HSSFDateUtil.isCellDateFormatted(cell)) {
          // format in form of M/D/YY
          double d = cell.getNumericCellValue();

          Calendar cal = Calendar.getInstance();
          cal.setTime(HSSFDateUtil.getJavaDate(d));
          cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
          cellText =
              cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
        }

        return cellText;
      } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) return "";
      else return String.valueOf(cell.getBooleanCellValue());
    } catch (Exception e) {

      e.printStackTrace();
      return "row " + rowNum + " or column " + colNum + " does not exist  in xls";
    }
  }

  public boolean setCellData(String sheetName, String colName, int rowNum, String data) {
    try {
      fis = new FileInputStream(path);
      workbook = new HSSFWorkbook(fis);

      if (rowNum <= 0) return false;

      int index = workbook.getSheetIndex(sheetName);
      int colNum = -1;
      if (index == -1) return false;

      sheet = workbook.getSheetAt(index);

      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++) {
        if (row.getCell(i).getStringCellValue().trim().equals(colName)) colNum = i;
      }
      if (colNum == -1) return false;

      sheet.autoSizeColumn(colNum);
      row = sheet.getRow(rowNum - 1);
      if (row == null) row = sheet.createRow(rowNum - 1);

      cell = row.getCell(colNum);
      if (cell == null) cell = row.createCell(colNum);

      // cell style
      // CellStyle cs = workbook.createCellStyle();
      // cs.setWrapText(true);
      // cell.setCellStyle(cs);
      cell.setCellValue(data);

      fileOut = new FileOutputStream(path);

      workbook.write(fileOut);

      fileOut.close();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean isSheetExist(String sheetName) {
    int index = workbook.getSheetIndex(sheetName);
    if (index == -1) {
      index = workbook.getSheetIndex(sheetName.toUpperCase());
        return index != -1;
    } else return true;
  }

  public int getColumnCount(String sheetName) {
    // check if sheet exists
    if (!isSheetExist(sheetName)) return -1;

    sheet = workbook.getSheet(sheetName);
    row = sheet.getRow(0);

    if (row == null) return -1;

    return row.getLastCellNum();
  }
}
