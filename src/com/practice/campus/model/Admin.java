package com.practice.campus.model;

import com.practice.campus.enums.RoleType;
import com.practice.campus.service.Manageable;

/**
 * 管理员类。
 */
public class Admin extends Person implements Manageable {
    private String department;

    public Admin() {
        setRoleType(RoleType.ADMIN);
    }

    public Admin(String name, int age, String department) {
        super(name, age, RoleType.ADMIN);
        this.department = department;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + "正在管理" + department + "部门。");
    }

    @Override
    public void manage() {
        System.out.println(getName() + "正在维护校园系统数据," + "正在休息。");
        // TODO 新手练习：补充更多管理员行为。
    }

    @Override
    public void introduce() {
        // TODO 新手练习：让管理员介绍姓名、年龄、管理部门。
        System.out.println("我是管理员，姓名：" + getName() + "，我的年龄是" + getAge() + "，管理部门：" + department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
