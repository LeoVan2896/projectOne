package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Employee;
import entity.Manager;
import entity.Reimbursement;
import service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class ManagerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        ManagerService managerService = new ManagerService();
        ObjectMapper mapper = new ObjectMapper();
        Manager manager;

        try{
            manager = mapper.readValue(req.getReader(), Manager.class);

        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(400, "invalid format");
            return;
        }

        String authType = req.getParameter("auth");
        if(authType.equals("login")){
            manager = managerService.login(manager.getId(), manager.getPassword());

        }
        else if(authType.equals("register")){
            manager = managerService.register(manager);

        }
        if(manager == null){
            resp.sendError(400, "invalid credentials");
            return;
        }
        out.println(manager.getName());
        req.getSession().setAttribute("id", manager.getId());



    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        ManagerService managerService = new ManagerService();


        int managerId;
        try{
            managerId = (Integer) req.getSession().getAttribute("id");
            System.out.println("id from session"+managerId);
        }catch (Exception e){
            e.printStackTrace();
            resp.sendError(401, "Must be login to see all employees information");
           return;
        }

        List<Employee> employees = managerService.getALlemployees();
        Iterator var7 = employees.iterator();

        while(var7.hasNext()){
            Employee employee = (Employee)var7.next();
            out.println(employee);
        }
        List<Reimbursement> reimbursements = managerService.getAllReimbursement();
        Iterator var8 = reimbursements.iterator();
        while (var8.hasNext()){
            Reimbursement reimbursement = (Reimbursement) var8.next();
            out.println(reimbursement);
        }
    }
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        ManagerService managerService = new ManagerService();
        ObjectMapper mapper = new ObjectMapper();






    }
}
