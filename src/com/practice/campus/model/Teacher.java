package com.practice.campus.model;

import com.practice.campus.enums.RoleType;
import com.practice.campus.service.Actionable;

/**
 * 老师类。
 */
public class Teacher extends Person implements Actionable {
    private String subject;

    public Teacher() {
        setRoleType(RoleType.TEACHER);
    }

    public Teacher(String name, int age, String subject) {
        super(name, age, RoleType.TEACHER);
        this.subject = subject;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + "正在讲授" + subject + "课程。");
    }

    @Override
    public void action() {
        System.out.println(getName() + "正在批改作业，" + "正在备课");
        // TODO 新手练习：补充老师的其他行为，比如备课、答疑。
    }

    @Override
    public void introduce() {
        // TODO 新手练习：参考 Student 的 introduce()，让老师介绍姓名、年龄、科目。
        System.out.println("我是老师，姓名：" + getName() +"，我的年龄是" + getAge() + "，授课科目：" + subject);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
