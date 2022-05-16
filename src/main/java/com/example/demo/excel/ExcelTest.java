package com.example.demo.excel;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * ExcelTest 类是
 *
 * @author dongyinggang
 * @date 2022-05-07 09:47
 **/
public class ExcelTest {

    public static void main(String[] args) {
        ExcelWriter excelWriter = ExcelUtil.getWriter("d:/writeTest.xlsx");
        List<String> list = new ArrayList<>();
        excelWriter.write(list);

        BigExcelWriter bigWriter = ExcelUtil.getBigWriter("d:/writeTest.xlsx");
        List<String> list2 = new ArrayList<>();
        bigWriter.write(list2);
    }
}
