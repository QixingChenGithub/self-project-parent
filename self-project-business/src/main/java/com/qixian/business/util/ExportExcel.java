package com.qixian.business.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

/**
 * 导出Excel公共方法
 *
 * @author Xing
 * @version 1.0
 */
public class ExportExcel {

    private final String title;

    private final String[] rowName;

    private final List<Object[]> dataList;

    /**
     * @descpt 构造方法，传入要导出的数据
     * @params title：
     * @params rowName：
     * @params dataList：
     * @author Xing
     * @date 2021-2-7 15:14
     */
    public ExportExcel(String title, String[] rowName, List<Object[]> dataList) {
        this.dataList = dataList;
        this.rowName = rowName;
        this.title = title;
    }

    
    /**
     * @descpt Excel导出
     * @params workbook：
     * @params sheet：
     * @params x：
     * @return void
     * @author Xing
     * @date 2021-2-7 15:14
     */
    public void export() throws Exception {
        try {
            // 产生表格标题行
            //创建HSSFWorkbook对象
            HSSFWorkbook workbook =  new  HSSFWorkbook();
            //创建HSSFSheet对象
            HSSFSheet sheet = workbook.createSheet( "sheet1" );
            HSSFRow rowm = sheet.createRow(0);
            HSSFCell cellTitle = rowm.createCell(0);
            //设置高度
            rowm.setHeight((short) (25 * 35));

            //sheet样式定义【getColumnTopStyle()/getStyle()均为自定义方法 - 在下面  - 可扩展】
            //获取列头样式对象
            HSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);
            //单元格样式对象
            HSSFCellStyle style = getStyle(workbook);

            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, (rowName.length - 1)));
            cellTitle.setCellStyle(columnTopStyle);
            cellTitle.setCellValue(title);

            // 定义所需列数
            int columnNum = rowName.length;
            // 在索引2的位置创建行(最顶端的行开始的第二行)
            HSSFRow rowRowName = sheet.createRow(1);
            //设置高度
            rowRowName.setHeight((short) (25 * 25));
            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                //创建列头对应个数的单元格
                HSSFCell cellRowName = rowRowName.createCell(n);
                //设置列头单元格的数据类型
                HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
                //设置列头单元格的值
                cellRowName.setCellValue(text);
                //设置列头单元格样式
                cellRowName.setCellStyle(columnTopStyle);
            }

            //将查询出的数据设置到sheet对应的单元格中
            for (int i = 0; i < dataList.size(); i++) {
                //遍历每个对象
                Object[] obj = dataList.get(i);
                //创建所需的行数
                HSSFRow row = sheet.createRow(i + 2);
                //设置高度
                row.setHeight((short) (25 * 20));

                for (int j = 0; j < obj.length; j++) {
                    //设置单元格的数据类型
                    HSSFCell cell;
                    if (j == 0) {
                        cell = row.createCell(j, CellType.NUMERIC);
                        cell.setCellValue(i + 1);
                    } else {
                        cell = row.createCell(j, CellType.STRING);
                        if (!"".equals(obj[j]) && obj[j] != null) {
                            //设置单元格的值
                            cell.setCellValue(obj[j].toString());
                        }
                    }
                    //设置单元格样式
                    cell.setCellStyle(style);
                }
            }
            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    HSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        HSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == CellType.STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 128);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * @descpt 列头单元格样式
     * @params workbook：
     * @return org.apache.poi.hssf.usermodel.HSSFCellStyle
     * @author Xing
     * @date 2021-2-7 15:16
     */
    public static HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {

        // 设置字体
        HSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 11);
        //字体加粗
        font.setBold(true);
        //设置字体名字
        font.setFontName("Courier New");
        //设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        // 设置单元格内容水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置单元格内容垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        // 设置填充模式，模式为全部前景色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        // 设置前景色为绿色
        style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getColor().getIndex());
        // 设置背景色，如果填充模式为其它填充模式，这个前景和背景色将相互交映显示
        style.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.RED.getColor().getIndex());

        return style;

    }

    /**
     * @descpt 列数据信息单元格样式
     * @params workbook：
     * @return org.apache.poi.hssf.usermodel.HSSFCellStyle
     * @author Xing
     * @date 2021-2-7 15:14
     */
    public static HSSFCellStyle getStyle(HSSFWorkbook workbook) {
        // 设置字体
        HSSFFont font = workbook.createFont();
        // 设置字体名字
        font.setFontName("Courier New");
        // 设置样式;
        HSSFCellStyle style = workbook.createCellStyle();
        // 在样式用应用设置的字体;
        style.setFont(font);
        // 设置自动换行;
        style.setWrapText(false);
        // 设置单元格内容水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        // 设置单元格内容垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        return style;
    }
}