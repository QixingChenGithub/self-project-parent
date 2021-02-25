package com.qixian.business.export;

import com.qixian.business.entity.SysUser;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Xing
 * @Date 2021/2/8-9:20
 * @Version 1.0
 */
public interface IExportExcelService {

    /**
     *  直接导出excel
     * @param req：servlet
     * @param resp：servlet
     * @param list：导出数据
     * @return void
     * @author Xing
     * @date 2021-2-8 9:21
     */
    public void exportExcelWithSimple(HttpServletRequest req, HttpServletResponse resp, List<SysUser> list);

    /**
     *  根据数据库导出
     * @param exportKey：导出key
     * @param fileName：文件名
     * @param list：导出数据
     * @param req：servlet
     * @param resp：servlet
     * @return void
     * @author Xing
     * @date 2021-2-8 9:21
     */
    public void exportExcelWithDispose(String exportKey, String fileName, List<T> list, HttpServletRequest req, HttpServletResponse resp);
}
