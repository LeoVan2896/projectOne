package service;

import data.Daofactory;
import data.EmployeeDao;
import data.ReimbursermentDao;
import entity.Employee;
import entity.Reimbursement;

import java.util.List;
import java.util.logging.Logger;

public class EmployeeService {

    public Employee register(Employee employee){
        EmployeeDao employeeDao =Daofactory.getEmployeeDao();
        Employee employee1 = employeeDao.insert(employee);
        return employee1;
    }

    public Employee login(int employeeid, String password){

        EmployeeDao employeeDao = Daofactory.getEmployeeDao();
        Employee employee = employeeDao.getById(employeeid);


        System.out.println("employee info is " + employee);



        if(password.equals(employee.getPassword())){
            return employee ;



    }

        return null;
    }


    public List<Reimbursement> getByemloyeeid(int employeeid) {
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.getByemployeeid(employeeid);

    }

    public List<Reimbursement> statusPending(int employeeid){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.statusPending(employeeid);
    }
    public  List<Reimbursement> statusApproved(int employeeid){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.statusApproved(employeeid);
    }
    public List<Reimbursement> statusDenied(int employeeid){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return  reimbursermentDao.statusDenied(employeeid);
    }
    public Employee getEmployeeByid(int employeeid){
        EmployeeDao employeeDao = Daofactory.getEmployeeDao();
        return employeeDao.getById(employeeid);
    }


    public Employee update(Employee employee){
        EmployeeDao employeeDao = Daofactory.getEmployeeDao();
        return employeeDao.update(employee);
    }













}
