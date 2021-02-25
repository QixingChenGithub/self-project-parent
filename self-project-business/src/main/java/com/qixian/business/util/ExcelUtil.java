package com.qixian.business.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xing
 * @Date 2021/2/7-15:48
 * @Version 1.0
 */
public class ExcelUtil {

    public static Map<Integer, String> handleTitleMap(List<String> titles) {
        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        for (String title : titles) {
            map.put(i, title);
            i++;
        }
        return map;
    }

    public static <T> HSSFWorkbook generateXls(String title, Map<Integer, String> titleMap, List<T> list) throws IOException, IllegalAccessException {
        //首先生成标题
        HSSFWorkbook book = new HSSFWorkbook();
        generateTitle(book, title, titleMap.size());
        generateTableTitle(book, titleMap);
        generateData(book, list, titleMap.size());
        return book;
    }

    private static void generateTitle(HSSFWorkbook book, String title, int col) {
        //准备样式
        HSSFCellStyle cellStyle = book.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.RED.index);

        //创建字体，这里还能设置字体呢，不光能设置大小
        HSSFFont font = book.createFont();
        font.setFontHeight((short) 440);
        cellStyle.setFont(font);


        book.createSheet();
        HSSFSheet sheetAt = book.getSheetAt(0);
        HSSFRow row = sheetAt.createRow(0);

        HSSFCell cell = row.createCell(0);
        cell.setCellValue(title);


        sheetAt.addMergedRegion(new CellRangeAddress(0, 0, 0, col));
        cell.setCellStyle(cellStyle);


    }


    private static void generateTableTitle(HSSFWorkbook book, Map<Integer, String> titleMap) {
        HSSFSheet sheet = book.createSheet("sheet1");
        HSSFRow row = sheet.createRow(1);
        for (int i = 0; i < titleMap.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(titleMap.get(i));
        }
    }

    private static <T> void generateData(HSSFWorkbook book, List<T> list, int column) throws IllegalAccessException {
        HSSFSheet sheetAt = book.getSheetAt(0);
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row = sheetAt.createRow(i + 2);
            writeToRow(row, list.get(i), column);
        }
    }

    public static void writeToRow(HSSFRow row, Object o, int column) throws IllegalAccessException {
        Class<?> aClass = o.getClass();
        int index = 1;
        for (Field f : aClass.getDeclaredFields()) {
            if (index + 1 == column) {
                break;
            }
            f.setAccessible(true);
            if (null == f.get(o)) {
                continue;
            }
            HSSFCell cell = row.createCell(index++);
            cell.setCellValue(f.get(o).toString());
        }
    }

    public static void writeToRow(HSSFRow row, Object o, int column, Map<String, String> map) throws IllegalAccessException {
        Class<?> aClass = o.getClass();
        int index = 1;
        for (Map.Entry<String, String> entrySet : map.entrySet()) {
            String filedName = entrySet.getKey();
            for (Field f : aClass.getDeclaredFields()) {
                if (index == column + 1) {
                    break;
                }
                if (filedName.equals(f.getName())) {
                    f.setAccessible(true);
                    if (null == f.get(o)) {
                        index++;
                        continue;
                    }
                    HSSFCell cell = row.createCell(index++);
                    cell.setCellValue(f.get(o).toString());
                    break;
                }
            }
        }

    }

    /*public static <T> List<T> getData(File file, Map<Integer, String> map, Class c, int startIndex) throws IOException, InvalidFormatException {
        List<T> result = new ArrayList<T>();
        Workbook book = HSSFWorkbook.create(file);
        Iterator<Sheet> sheetIterator = book.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                try {
                    if (i < startIndex) {
                        continue;
                    }
                    //这里就是每一行，遍历然后添加数据到list
                    handleRow(map, c, result, sheet.getRow(i));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }*/

    private static <T> void handleRow(Map<Integer, String> map, Class c, List<T> result, Row row) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Object o = c.newInstance();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            //这里获得字段名
            String fieldName = map.get(i);
            setVal(o, fieldName, row.getCell(i));
        }
        result.add((T) o);
    }

    private static void setVal(Object o, String fieldName, Cell cell) throws NoSuchFieldException, IllegalAccessException {
        Class<?> aClass = o.getClass();
        Field field = aClass.getDeclaredField(fieldName);

        //这里说明有那个字段，就下来就把单元格里面的值拿出来并做类型转换并赋值进去
        field.setAccessible(true);
        field.set(o, getVal(field, cell));
    }

    private static Object getVal(Field field, Cell cell) {
        cell.setCellType(CellType.STRING);
        if (field.getType() == Integer.class || field.getType() == int.class) {
            return Integer.parseInt(cell.getStringCellValue());
        }
        if (field.getType() == Double.class || field.getType() == double.class) {
            return Double.parseDouble(cell.getStringCellValue());
        }
        if (field.getType() == Date.class) {
            return cell.getDateCellValue();
        }
        if (field.getType() == String.class) {
            return cell.getStringCellValue();
        }
        if (field.getType() == boolean.class || field.getType() == Boolean.class) {
            return cell.getBooleanCellValue();
        }
        return null;
    }
}
