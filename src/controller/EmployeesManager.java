package controller;

import entities.Employees;

import java.util.ArrayList;
import java.util.List;

public class EmployeesManager {

    private List<Employees> listOfEmployees;

    public EmployeesManager(){
        this.listOfEmployees = new ArrayList<>();
    }

    public int addEmployee(Employees e){
        this.listOfEmployees.add(e);
        return this.listOfEmployees.size();
    }

    public int count(){
        return this.listOfEmployees.size();
    }

    public Employees getEmployees(int index){
        if(index < 0 || index >= count()) {
            return null;
        }
        return this.listOfEmployees.get(index);
    }

}
