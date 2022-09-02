package service;

import data.Daofactory;
import entity.Reimbursement;
import data.ReimbursermentDao;
import java.util.List;

public class ReimbursementService {
    public Reimbursement insert(Reimbursement reimbursement){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();

        System.out.println(reimbursement);
        return reimbursermentDao.insert(reimbursement);

    }



    public List<Reimbursement> getAllReimbursement(){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();


        return reimbursermentDao.getAllReimbursement();
    }





    public String update(Reimbursement reimbursement){
        ReimbursermentDao reimbursermentDao =Daofactory.getReimbursementDao();

        return reimbursermentDao.update(reimbursement);
    }




    public boolean delete(int id){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.delete(id);

    }
    public Reimbursement updateStatus(Reimbursement reimbursement){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        if(reimbursement.getStatus().equals("approved")){
           System.out.println("Cannot change ticket's status anymore");
           return null;

       }else if(reimbursement.getStatus().equals("denied")){
            System.out.println("Cannot change ticket's status anymore");
            return null;
            }
        return reimbursermentDao.updateStatus(reimbursement);


    }

    public Reimbursement getById(int id){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return  reimbursermentDao.getById(id);


    }
    public List<Reimbursement>  getByemloyeeid(int employeeid){
        ReimbursermentDao reimbursermentDao = Daofactory.getReimbursementDao();
        return reimbursermentDao.getByemployeeid(employeeid);
    }
}
