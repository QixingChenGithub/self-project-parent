package com.qixian.business.export;

import com.qixian.business.entity.SysUser;
import com.qixian.business.util.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Xing
 * @Date 2021/2/8-9:24
 * @Version 1.0
 */
@Service
public class ExportExcelServiceImpl extends ExportExcelBaseService implements IExportExcelService {

    @Override
    public void exportExcelWithSimple(HttpServletRequest req, HttpServletResponse resp, List<SysUser> list) {
        String fileName = "个人消费明细表";
        exportExcelWithSimple(req, resp, "titleName", "sheetName",  fileName, list, new HashMap<>());
    }

    @Override
    public void exportExcelWithDispose(String exportKey, String fileName, List<T> list, HttpServletRequest req, HttpServletResponse resp) {
        //查询一表 级联 获取多表集合
        /*List<ExportFieldBean> fieldBeanList = exportMapper.getExportByExportKey(exportKey).getFieldBeanList();

        try {
            //工作空间
            HSSFWorkbook workbook = new HSSFWorkbook();

            //第1张工作表
            HSSFSheet sheet1 = workbook.createSheet("个人消费明细");
            sheet1.setDefaultRowHeightInPoints(20);//行高
            sheet1.setDefaultColumnWidth(20);//列宽

            //行表头
            HSSFRow headRow = sheet1.createRow(0);
            headRow.createCell(0).setCellValue("序号");
            headRow.getCell(0).setCellStyle(super.getCellStyle(workbook));

            //创建行表头单元格并设置样式
            for (ExportFieldBean fieldBean : fieldBeanList) {
                headRow.createCell(headRow.getLastCellNum()).setCellValue(fieldBean.getExportName());//赋值
                headRow.getCell(headRow.getLastCellNum()).setCellStyle(super.getCellStyle(workbook));//样式
            }

            //创建行数据体
            int index = 1;
            HSSFRow bodyRow = null;
            JSONArray jsonArray = JSONArray.fromObject(list);// --赋值(先转json, 再赋值, 通用性高)

            for (Object obj : jsonArray) {

                bodyRow = sheet1.createRow(sheet1.getLastRowNum() + 1);

                bodyRow.createCell(0).setCellValue(index++);

                for (ExportFieldBean fieldBean : fieldBeanList) {
                    bodyRow.createCell(bodyRow.getLastCellNum()).setCellValue(((JSONObject) obj).get(fieldBean.getExportCode()) + "");//赋值
//                    bodyRow.getCell(bodyRow.getLastCellNum()).setCellStyle(super.getCellStyle(workbook));//样式
                }
            }

            //输出
            super.outExcelStream(resp, workbook, fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public void exportExcelWithSimple(HttpServletRequest req, HttpServletResponse resp, String titleName, String sheetName,  String fileName, List<?> list, Map<String, String> map) {
        try {
            //工作空间
            HSSFWorkbook workbook = new HSSFWorkbook();

            //第1张工作表
            HSSFSheet sheet1 = workbook.createSheet(sheetName);
            //行高
            sheet1.setDefaultRowHeightInPoints(20);
            //列宽
            sheet1.setDefaultColumnWidth(20);

            //行标题
            HSSFRow titleRow = sheet1.createRow(0);
            titleRow.createCell(0).setCellValue(titleName);
            //合并单元格
            // TODO 标题的长度为一共有多少列数据合并
            int lastCol = map.size();
            sheet1.addMergedRegion(new CellRangeAddress(0, 0, 0, lastCol));

            //行表头
            // TODO 使用nacos config中的配置信息Map处理
            HSSFRow headRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
            headRow.createCell(0).setCellValue("序号");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                headRow.createCell(headRow.getLastCellNum()).setCellValue(entry.getValue());
            }

            //行表头单元格设置样式
            for (int h = 0; h < headRow.getLastCellNum(); h++) {
                headRow.getCell(h).setCellStyle(super.getCellStyle(workbook));
            }

            //行数据体
            HSSFRow bodyRow;
            int index = 1;
            for (Object bean : list) {
                bodyRow = sheet1.createRow(sheet1.getLastRowNum() + 1);
                bodyRow.createCell(0).setCellValue(index);
                ExcelUtil.writeToRow(bodyRow, bean, map.size(), map);
                index++;
            }

            //输出
            super.outExcelStream(resp, workbook, fileName);

            //将生成的excel文件写到磁盘
//            FileOutputStream fos = new FileOutputStream(fileName + ".xls");
//            workbook.write(fos);
//            fos.close();
            //从磁盘删除删除文件
//            super.deleteFileDir(fileName + ".xls");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
