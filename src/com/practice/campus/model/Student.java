package com.practice.campus.model;

import com.practice.campus.enums.RoleType;
import com.practice.campus.service.Actionable;

/**
 * 学生类。
 */
public class Student extends Person implements Actionable {
    private String studentNo;

    public Student() {
        setRoleType(RoleType.STUDENT);
    }

    public Student(String name, int age, String studentNo) {
        super(name, age, RoleType.STUDENT);
        this.studentNo = studentNo;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + "正在学习 Java 面向对象。" + studentNo);
        // TODO 新手练习：把输出内容改得更丰富，比如加上学号 studentNo。
    }

    @Override
    public void action() {
        System.out.println(getName() + "正在完成作业。");
        // TODO 新手练习：思考 action() 和 doWork() 的含义有什么区别。
    }

    @Override
    public void introduce() {
    	System.out.println("我是学生，姓名：" + getName() + "，年龄：" + getAge() + "，学号：" + studentNo + "，角色描述：" + getRoleType().getDescription());
        // TODO 新手练习：仿照 Teacher / Admin，补充更多自我介绍信息。
    }

    public void setInfo(String name) {
        setName(name);
    }

    public void setInfo(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void setInfo(String name, int age, String studentNo) {
        setName(name);
        setAge(age);
        this.studentNo = studentNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }
}
