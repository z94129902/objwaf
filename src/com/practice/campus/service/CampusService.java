package com.practice.campus.service;

import com.practice.campus.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务类：统一管理校园人员。
 *
 * 这里使用 List<Person>，体现多态：
 * 一个集合可以同时保存 Student、Teacher、Admin。
 */
public class CampusService {
    private final List<Person> people = new ArrayList<>();

    public void addPerson(Person person) {
        people.add(person);
        System.out.println("添加成功：" + person.getName());
    }

    public void showAllPeople() {
        if (people.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }

        for (int i = 0; i < people.size(); i++) {
            System.out.print((i + 1) + ". ");
            people.get(i).introduce();
        }
    }

    public void doAllWork() {
        if (people.isEmpty()) {
            System.out.println("暂无人员信息");
            return;
        }

        for (Person person : people) {
            person.doWork();
        }
    }

    public int size() {
        return people.size();
    }

    /**
     * TODO 新手练习：完善按姓名查找人员功能。
     *
     * 提示：
     * 1. 遍历 people 集合。
     * 2. 使用 person.getName().equals(name) 判断姓名是否相同。
     * 3. 找到后 return person。
     * 4. 没找到 return null。
     */
    public Person findByName(String name) {
    	for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
    	return null;
    }

    /**
     * TODO 新手练习：可以尝试新增 deleteByName(String name) 方法。
     */
    public Person deleteByName(String name) {
    	for (Person person : people) {
    		if(person.getName().equals(name)) {
    			people.remove(person);
    			return person;
    		}
    	}
    	return null;
    }
}
    

