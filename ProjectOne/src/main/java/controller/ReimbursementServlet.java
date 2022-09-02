package controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Employee;
import entity.Reimbursement;
import service.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

public class ReimbursementServlet extends HttpServlet {


  @Override
//inserting a ticket
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    ReimbursementService reimbursementService = new ReimbursementService();

    ObjectMapper mapper = new ObjectMapper();
    Reimbursement reimbursement;


    try {
      reimbursement = mapper.readValue(req.getReader(), Reimbursement.class);

    } catch (Exception e) {
      e.printStackTrace();
      resp.sendError(400, "invalid input");
      return;
    }
    reimbursement = reimbursementService.insert(reimbursement);
    out.println(reimbursement);
    System.out.println(reimbursement);

  }

  @Override
  protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    ReimbursementService reimbursementService = new ReimbursementService();
    ObjectMapper mapper = new ObjectMapper();

    Reimbursement reimbursement;
    try {

      reimbursement = (Reimbursement) mapper.readValue(req.getReader(), Reimbursement.class);




    } catch (Exception e) {
      e.printStackTrace();
      resp.sendError(400, "invalid format");
      return;

    }
    reimbursement = reimbursementService.updateStatus(reimbursement);

    System.out.println(reimbursement);

  }
}


