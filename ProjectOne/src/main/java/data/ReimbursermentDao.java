package data;
import entity.Reimbursement;

import java.util.List;

public interface ReimbursermentDao {
    //CRUD
    public Reimbursement insert(Reimbursement reimbursement);
    public List<Reimbursement> getAllReimbursement();
    public String update(Reimbursement reimbursement);


    public boolean delete(int id);



    //getById-get ticket-check then updatestatus the status


    public Reimbursement getById(int id);

    public Reimbursement updateStatus(Reimbursement reimbursement);



    List<Reimbursement> getByemployeeid(int employeeid);

    List<Reimbursement> statusPending(int employeeid);

    List<Reimbursement> statusApproved(int employeeid);
    List<Reimbursement> statusDenied(int employeeid);
}
