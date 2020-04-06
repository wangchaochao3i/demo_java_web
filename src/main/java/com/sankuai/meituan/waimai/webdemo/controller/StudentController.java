package com.sankuai.meituan.waimai.webdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sankuai.meituan.waimai.webdemo.RetUtil;
import com.sankuai.meituan.waimai.webdemo.service.StudentService;
import com.sankuai.meituan.waimai.webdemo.vo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.tools.SysPropsDumper;

/**
 * @author: ChaoChao.Wang
 * @version: 2020-04-06
 * @description:
 **/

@RestController
@RequestMapping("/webdemo/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/r/getByName")
    @ResponseBody
    //post --> RequestBody :  Content-Type: application/json
    public JSONObject getStudentByName(@RequestBody String studentName) {
        try {
            System.out.println("get student by name:" + studentName);
            Student student = this.studentService.getStudentByName(studentName);
            System.out.println("get student by name success:" + JSON.toJSONString(student));
            return RetUtil.success(student);
        } catch (Exception e) {
            e.printStackTrace();
            return RetUtil.failed(e.getMessage());
        }
    }

    @RequestMapping("/w/update")
    //post --> RequestBody :  Content-Type: application/json
    @ResponseBody
    public JSONObject updateStudent(@RequestBody Student student) {
        try {
            System.out.println("update student:" + JSON.toJSONString(student));
            //update to database ...
            return RetUtil.success(student);
        } catch (Exception e) {
            e.printStackTrace();
            return RetUtil.failed(e.getMessage());
        }
    }

    //get / post
    @RequestMapping(value = "/r/getById", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getById(@RequestParam(name = "id", required = true) int id) {
        try {
            System.out.println("getById:" + id);
            Student student = new Student();
            student.setName("李四");
            student.setAge(20);
            return RetUtil.success(student);
        } catch (Exception e) {
            e.printStackTrace();
            return RetUtil.failed(e.getMessage());
        }
    }
}

