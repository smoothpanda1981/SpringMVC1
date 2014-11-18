package com.yan.wang.spring.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Logger;

/**
 * Created by ywang on 18.11.14.
 */
@Controller
public class EmployeesController {
        //Map to store employees, ideally we should use database
        Map<Integer, Employee> empData = new HashMap<Integer, Employee>();


        @RequestMapping(value = "/rest/emp/dummy", method = RequestMethod.GET)
        public @ResponseBody Employee getDummyEmployee() {
            System.out.println("Hello");
            Employee emp = new Employee();
            emp.setId(9999);
            emp.setName("Dummy");
            emp.setCreatedDate(new Date());
            empData.put(9999, emp);
            return emp;
        }

        @RequestMapping(value = "/rest/emp/{id}", method = RequestMethod.GET)
        public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
            return empData.get(empId);
        }

        @RequestMapping(value = "/rest/emps", method = RequestMethod.GET)
        public @ResponseBody
        List<Employee> getAllEmployees() {
            List<Employee> emps = new ArrayList<Employee>();
            Set<Integer> empIdKeys = empData.keySet();
            for(Integer i : empIdKeys){
                emps.add(empData.get(i));
            }
            return emps;
        }

        @RequestMapping(value = "/rest/emp/create", method = RequestMethod.POST)
        public @ResponseBody Employee createEmployee(@RequestBody Employee emp) {
            emp.setCreatedDate(new Date());
            empData.put(emp.getId(), emp);
            return emp;
        }

        @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
        public @ResponseBody Employee deleteEmployee(@PathVariable("id") int empId) {
            Employee emp = empData.get(empId);
            empData.remove(empId);
            return emp;
        }
}
