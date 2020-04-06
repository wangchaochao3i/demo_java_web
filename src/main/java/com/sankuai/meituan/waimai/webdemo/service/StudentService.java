package com.sankuai.meituan.waimai.webdemo.service;

import com.sankuai.meituan.waimai.webdemo.vo.Student;
import org.springframework.stereotype.Service;

/**
 * @author: ChaoChao.Wang
 * @version: 2020-04-06
 * @description:
 **/

@Service
public class StudentService {

    public Student getStudentByName(String studentName) {
        Student student = new Student();
        student.setAge(22);
        student.setName("张三");
        return student;
        //TODO  查询数据库
    }
}

