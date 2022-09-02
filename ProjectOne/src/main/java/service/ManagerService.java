package service;

import data.*;
import entity.Employee;
import entity.Manager;
import entity.Reimbursement;

import java.util.List;

public class ManagerService {

    public Manager register(Manager manager) {
        ManagerDao managerDao = Daofactory.getManagerDao();
        Manager manager1 = managerDao.insert(manager);
        return manager1;


    }

    public Manager login(int id, String password) {
        ManagerDao managerDao = Daofactory.getManagerDao();
        Manager manager = managerDao.getById(id);
        return password.equals(manager.getPassword()) ? manager : null;


    }

    public List<Employee> getALlemployees() {
        EmployeeDao employeeDao = Daofactory.getEmployeeDao();
        return employeeDao.getAllEmployees();
    }

    public List<Reimbursement> getAllReimbursement() {
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.getAllReimbursement();
    }
    /**this is trouble**/
    public Reimbursement updateStatus(Reimbursement reimbursement) {
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.updateStatus(reimbursement);

    }
}



