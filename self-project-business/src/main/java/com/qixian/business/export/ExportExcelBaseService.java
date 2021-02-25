package com.qixian.business.export;

import com.qixian.tool.entity.Errors;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author Xing
 * @Date 2021/2/8-9:24
 * @Version 1.0
 */
@Component
public class ExportExcelBaseService {
    /**
     * 获取设置好的样式
     * @param workbook 工作空间
     * @return org.apache.poi.hssf.usermodel.HSSFCellStyle
     */
    public HSSFCellStyle getCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        //单元格-垂直居中
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        //单元格-水平居中
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        //背景色-方块填充
        cellStyle.setFillPattern(FillPatternType.DIAMONDS);
        //前背景色-天蓝
        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.SKY_BLUE.getIndex());
        //后背景色-浅黄
        cellStyle.setFillBackgroundColor(HSSFColor.HSSFColorPredefined.LIGHT_YELLOW.getIndex());

        //底边框样式-倾斜断点
        cellStyle.setBorderBottom(BorderStyle.THIN);
        //底边框颜色-暗红
        cellStyle.setBottomBorderColor(HSSFColor.HSSFColorPredefined.DARK_RED.getIndex());
        //日期显示格式
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        //设置字体
        cellStyle.setFont(this.getFont(workbook));

        return cellStyle;
    }

    /**
     * 获取设置好的字体
     * @param workbook：工作空间
     * @return org.apache.poi.hssf.usermodel.HSSFFont
     * @author Xing
     * @date 2021-2-8 9:44
     */
    public HSSFFont getFont(HSSFWorkbook workbook) {
        HSSFFont fontStyle = workbook.createFont();
        //名称-宋体
        fontStyle.setFontName("宋体");
        //高度-13
        fontStyle.setFontHeightInPoints((short)13);
        //颜色-白色
        fontStyle.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        //加粗
        fontStyle.setBold(true);
        //斜体
        fontStyle.setItalic(true);
        //下划线
        fontStyle.setUnderline(HSSFFont.U_SINGLE);
        return fontStyle;
    }

    /**
     * 通过流的方式输出excel到页面
     * @param response 响应
     * @param workbook 工作空间
     * @param fileName 文件名
     */
    public void outExcelStream(HttpServletResponse response, Workbook workbook, String fileName){
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setContentType("application/x-download");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO8859-1") + ".xls");
            workbook.write(os);
            os.flush();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 删除文件
     * @param fileName：
     * @return void
     * @author Xing
     * @date 2021-2-8 9:44
     */
    public void deleteFileDir(String fileName) {
        File file = new File(fileName);
        deleteAll(file);
    }


    /**
     * @param dir：
     * @return void
     * @author Xing
     * @date 2021-2-8 9:44
     */
    public void deleteAll(File dir) {
        if (dir.isFile()) {
            boolean delete = dir.delete();
            if (!delete) {
                Errors.NOT_FOUND_ERROR.illegal("文件夹不存在删除失败");
            }
            return;
        } else {
            File[] files = dir.listFiles();
            Errors.NOT_FOUND_ERROR.ifNull(files, "文件不能为空");
            assert files != null;
            for (File file : files) {
                deleteAll(file);
            }
        }
        boolean delete = dir.delete();
        if (!delete) {
            Errors.NOT_FOUND_ERROR.illegal("文件夹不存在删除失败");
        }
    }
}
