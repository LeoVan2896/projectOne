package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Employee;
import entity.Reimbursement;
import service.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        EmployeeService employeeService = new EmployeeService();

        int employeeId;

        try {
            employeeId = (Integer) req.getSession().getAttribute("employeeid");
            System.out.println("id from session: " + employeeId);


        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(401, "must be login to see your information");
            return;
        }

        String filter = req.getParameter("status");
        if (filter.equals("pending")) {
            List<Reimbursement> reimbursements = employeeService.statusPending(employeeId);
            for (Reimbursement reimbursement : reimbursements) {
                out.println(reimbursement);
                System.out.println(reimbursement);
            }
        } else if (filter.equals("approved")) {
            List<Reimbursement> reimbursements = employeeService.statusApproved(employeeId);
            for (Reimbursement reimbursement : reimbursements) {
                out.println(reimbursement);
                System.out.println(reimbursement);
            }
        } else if (filter.equals("denied")) {
            List<Reimbursement> reimbursements = employeeService.statusDenied(employeeId);
            for (Reimbursement reimbursement : reimbursements) {
                out.println(reimbursement);
                System.out.println(reimbursement);
            }
        } else {


            List<Reimbursement> reimbursements = employeeService.getByemloyeeid(employeeId);
            for (Reimbursement reimbursement : reimbursements) {
                out.println(reimbursement);
                System.out.println(reimbursement);
            }
        }
    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter out = resp.getWriter();
            EmployeeService employeeService = new EmployeeService();
            ObjectMapper mapper = new ObjectMapper();
            Employee employee;


            try {
                employee = mapper.readValue(req.getReader(), Employee.class);

                System.out.println(employee);


            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(400, "invalid format or username is taken");
                return;
            }

            String authType = req.getParameter("auth");
            if (authType.equals("login")) {
                employee = employeeService.login(employee.getEmployeeid(), employee.getPassword());


            } else if (authType.equals("register")) {

                employee = employeeService.register(employee);
                out.println(employee);
            }
            if (employee == null) {
                resp.sendError(400, "invalid credential!");
                return;
            }

            req.getSession().setAttribute("employeeid", employee.getEmployeeid());


        }

        @Override
        protected void doPut (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter out = resp.getWriter();
            EmployeeService employeeService = new EmployeeService();
            ObjectMapper mapper = new ObjectMapper();

            Employee employee;

            try {
                employee = (Employee) mapper.readValue(req.getReader(), Employee.class);

            } catch (Exception e) {
                e.printStackTrace();
                resp.sendError(400, "Invalid input!!! ");
                return;
            }
            employee = employeeService.update(employee);
            out.println(employee);
        }


    }

