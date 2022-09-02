package data;


import entity.Manager;

public class Daofactory {
    private static EmployeeDao employeeDao = null;
    private static ManagerDao managerDao = null;

    private static ReimbursermentDao reimbursermentDao = null;


    private Daofactory(){

    }

    public static EmployeeDao getEmployeeDao(){
        if(employeeDao == null){
            System.out.println("connection is established");
            employeeDao = new EmployeeDaoImpl();

         }
        return employeeDao;
    }
    public static ManagerDao getManagerDao(){
        if(managerDao == null){
            System.out.println("this should only run once");
            managerDao = new ManagerDaoImpl();

        }

        return managerDao;
    }
    public static ReimbursermentDao getReimbursementDao(){
        if(reimbursermentDao == null){
            System.out.println("this should only run once");
            reimbursermentDao = new ReimbursementDaoImpl();

        }
        return reimbursermentDao;

    }


}
