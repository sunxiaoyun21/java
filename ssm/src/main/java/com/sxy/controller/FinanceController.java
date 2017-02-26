package com.sxy.controller;

import com.google.common.collect.Maps;
import com.sxy.dto.AjaxResult;
import com.sxy.dto.DataTablesResult;
import com.sxy.pojo.Finance;
import com.sxy.service.FinanceService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/23.
 */
@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @RequestMapping(value = "/day",method = RequestMethod.GET)
    public  String home(){
        return "/finance/day";
    }

    @RequestMapping(value = "/day/load",method = RequestMethod.GET)
    @ResponseBody
    public DataTablesResult dayLoad(HttpServletRequest request){
        String draw=request.getParameter("draw");
        String start=request.getParameter("start");
        String length=request.getParameter("length");
        String day=request.getParameter("day");

        Map<String,Object> map= Maps.newHashMap();
        map.put("start",start);
        map.put("length",length);
        map.put("day",day);

        List<Finance> financeList=financeService.findFinanceByMap(map);
        Long count=financeService.findFinanceCountByMap();
        Long filterCount=financeService.findFilterByMap(map);
        return new DataTablesResult(draw,count,count,financeList);

    }

    /**
     * 业务流水的确定
     * @param id
     * @return
     */
    @RequestMapping(value = "/confirm/{id:\\d+}",method = RequestMethod.POST)
    @ResponseBody
    private AjaxResult confirmState(@PathVariable Integer id){
        financeService.confirmById(id);
        return new AjaxResult(AjaxResult.SUCCESS);
    }

    /**
     * 将报表导出Excel
     */
    @RequestMapping(value = "/day/{day}/data.xls",method = RequestMethod.GET  )
    private void exportCsvFile(@PathVariable String day, HttpServletResponse response) throws IOException {
        List<Finance> financeList = financeService.findFinanceByCreateDay(day);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=\"" + day + ".xls\"");

       //创建工作表
        Workbook workbook=new HSSFWorkbook();
        // 创建sheet页
        Sheet sheet=workbook.createSheet(day+"xls");
        //创建行，从零开始
        Row row=sheet.createRow(0);
        row.createCell(0).setCellValue("业务流水号");
        row.createCell(1).setCellValue("创建日期");
        row.createCell(2).setCellValue("类型");
        row.createCell(3).setCellValue("业务模块");
        row.createCell(4).setCellValue("业务流水号");
        row.createCell(5).setCellValue("状态");
        row.createCell(6).setCellValue("备注");
        row.createCell(7).setCellValue("创建人");
        row.createCell(7).setCellValue("确认人");
        row.createCell(7).setCellValue("确认日期");

        for(int i=0;i<financeList.size();i++){
            Finance finance=financeList.get(i);
            Row dataRow=sheet.createRow(i+1);
            dataRow.createCell(0).setCellValue(finance.getSerialNumber());
            dataRow.createCell(1).setCellValue(finance.getCreateDate());
            dataRow.createCell(2).setCellValue(finance.getType());
            dataRow.createCell(3).setCellValue(finance.getMoney());
            dataRow.createCell(4).setCellValue(finance.getModule());
            dataRow.createCell(5).setCellValue(finance.getModuleSerialNumber());
            dataRow.createCell(6).setCellValue(finance.getState());
            dataRow.createCell(7).setCellValue(finance.getRemark());
            dataRow.createCell(8).setCellValue(finance.getCeratUser());
            dataRow.createCell(9).setCellValue(finance.getConfirmUser());
            dataRow.createCell(10).setCellValue(finance.getConfirmDate());
        }
        //单元格样式
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(5);
        sheet.autoSizeColumn(10);

        OutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();

    }

    /**
     * 按天加载圆饼图
     * @param type
     * @param today
     * @return
     */

    @RequestMapping(value = "/day/{type}/{today}/pie",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult dayPieData(@PathVariable String type,@PathVariable String today){
        type="in".equals(type) ? "收入" : "支出";
        List<Map<String,Object>> pieData=financeService.findPieDataByDay(today,type);
        return  new AjaxResult(AjaxResult.SUCCESS);
    }
}
