package com.xiwai.algorithm.augu26;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class num690 {
}


class Solution {
    HashMap<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        int flag = 0;
        int sum = 0;

        List<Integer> temp = new ArrayList<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);

        }
        return DiGui690(id);
    }

    public int DiGui690(int id) {
        Employee employee = map.get(id);
        int sum = employee.importance;
        List<Integer> temp = employee.subordinates;
        for (int i : temp) {
            sum += DiGui690(i);
        }
        return sum;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
