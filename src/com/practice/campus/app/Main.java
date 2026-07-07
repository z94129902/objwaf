package com.practice.campus.app;

import com.practice.campus.enums.RoleType;
import com.practice.campus.model.Admin;
import com.practice.campus.model.Person;
import com.practice.campus.model.Student;
import com.practice.campus.model.Teacher;
import com.practice.campus.service.CampusService;
import com.practice.campus.util.ReflectionUtil;

import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final CampusService CAMPUS_SERVICE = new CampusService();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = readInt("请输入菜单编号：");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    addAdmin();
                    break;
                case 4:
                    CAMPUS_SERVICE.showAllPeople();
                    break;
                case 5:
                    CAMPUS_SERVICE.doAllWork();
                    break;
                case 6:
                    showRoleTypes();
                    break;
                case 7:
                    showClassInfoByReflection();
                    break;
                case 8:
                    findPersonByName();
                    break;
                case 9:
                	deletePersonByName();
                	break;
                case 0:
                    System.out.println("系统已退出");
                    return;
                default:
                    System.out.println("菜单编号不存在，请重新输入");
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("===== 校园角色管理系统 =====");
        System.out.println("1. 添加学生");
        System.out.println("2. 添加老师");
        System.out.println("3. 添加管理员");
        System.out.println("4. 查看所有人员");
        System.out.println("5. 执行所有人员工作");
        System.out.println("6. 查看角色类型");
        System.out.println("7. 使用反射查看类信息");
        System.out.println("8. 按姓名查找人员");
        System.out.println("9. 按姓名删除人员");
        System.out.println("0. 退出系统");
    }

    private static void addStudent() {
        String name = readLine("请输入学生姓名：");
        int age = readInt("请输入学生年龄：");
        String studentNo = readLine("请输入学生学号：");

        Student student = new Student(name, age, studentNo);
        CAMPUS_SERVICE.addPerson(student);
    }

    private static void addTeacher() {
        String name = readLine("请输入老师姓名：");
        int age = readInt("请输入老师年龄：");
        String subject = readLine("请输入授课科目：");

        Teacher teacher = new Teacher(name, age, subject);
        CAMPUS_SERVICE.addPerson(teacher);
    }

    private static void addAdmin() {
        String name = readLine("请输入管理员姓名：");
        int age = readInt("请输入管理员年龄：");
        String department = readLine("请输入管理部门：");

        Admin admin = new Admin(name, age, department);
        CAMPUS_SERVICE.addPerson(admin);
    }

    private static void showRoleTypes() {
        System.out.println("系统支持的角色类型：");
        for (RoleType roleType : RoleType.values()) {
            System.out.println(roleType.name() + " - " + roleType.getDescription());
        }
    }

    private static void showClassInfoByReflection() {
        System.out.println("示例：com.practice.campus.model.Student");
        String className = readLine("请输入完整类名：");
        ReflectionUtil.printClassInfo(className);
    }

    private static void findPersonByName() {
        String name = readLine("请输入要查找的姓名：");
        Person person = CAMPUS_SERVICE.findByName(name);
        if (person == null) {
            System.out.println("没有找到该人员。提示：请完善 CampusService.findByName 方法。");
        } else {
            person.introduce();
        }
    }
    
    private static void deletePersonByName() {
    	String name = readLine("请输入要查找的姓名：");
    	Person person = CAMPUS_SERVICE.deleteByName(name);
    	if (person == null) {
    		System.out.println("没有找到该人员。");
    	} else {
    		System.out.println("已删除：");
    		person.introduce();
    	}
    }

    private static String readLine(String message) {
        System.out.print(message);
        return SCANNER.nextLine();
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = SCANNER.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("请输入数字");
            }
        }
    }
}
