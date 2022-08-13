package com.atguigu.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.atguigu.easyexcel.dto.ExcelStudentDTO;
import com.atguigu.easyexcel.listener.ExcelStudentDTOListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author: leell
 * Date: 2022/8/13 12:57:47
 */
public class ExcelController {

    public void importData() throws FileNotFoundException {
        FileInputStream inputStream=new FileInputStream("sdf.excel");
        EasyExcel.read(inputStream, ExcelStudentDTO.class, new ExcelStudentDTOListener()).sheet().doRead();
    }
}
