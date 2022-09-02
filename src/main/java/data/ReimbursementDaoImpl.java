package data;

import entity.Reimbursement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Logger;


public class ReimbursementDaoImpl implements ReimbursermentDao {
    Connection connection = ConnectionFactory.getConnection();

    public ReimbursementDaoImpl() {
    }

    @Override
    public Reimbursement insert(Reimbursement reimbursement) {
        Logger logger = Logger.getLogger("reimbursement Dao Impl");

        String sql = "insert into reimbursement values(default, ?,?,?,?);";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, reimbursement.getAmount());
            preparedStatement.setString(2, reimbursement.getDescription());
            preparedStatement.setString(3, "pending");
            preparedStatement.setInt(4, reimbursement.getEmployee_id());
            System.out.println(preparedStatement.toString());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Reimbursement added successfully");


                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                resultSet.next();

                int generatedId = resultSet.getInt(1);
                reimbursement.setId(generatedId);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong when prepare statement");
        }
        return reimbursement;
    }

    @Override
    public List<Reimbursement> getAllReimbursement() {

        List<Reimbursement> reimbursements = new ArrayList<>();
        String sql = "select * from reimbursement;";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int employeeid = resultSet.getInt("employeeid");

                Reimbursement reimbursement = new Reimbursement(id, amount, description, status, employeeid);
                reimbursements.add(reimbursement);

                System.out.println(id + amount + status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursements;
    }

    @Override
    public String update(Reimbursement reimbursement) {
        String sql = "Update reimbursement set amount =?, description = ?; where id =?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, reimbursement.getAmount());
            preparedStatement.setString(2, reimbursement.getDescription());
            preparedStatement.setInt(3, reimbursement.getId());


            int count = preparedStatement.executeUpdate();


            if (count == 1) {
                System.out.println("Update successful");
            } else {
                System.out.println("something went wrong");
                if (count == 0) {
                    System.out.println("no row affected");
                } else {
                    System.out.println("many rows affected");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from reimbursement where id = ?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("delete successful");
            } else {
                return false;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public Reimbursement getById(int id) {

        String sql = "select* from reimbursement where id = ?;";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int idR = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int employeeid = resultSet.getInt("employeeid");

                Reimbursement reimbursement = new Reimbursement(idR, amount, description, status, employeeid);


                return reimbursement;

            }


        } catch (SQLException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
        return null;


    }

    @Override

    public Reimbursement updateStatus(Reimbursement reimbursement) {
        String sql = "update reimbursement set status = ? where id =?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, reimbursement.getStatus());
            preparedStatement.setInt(2, reimbursement.getId());

            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                System.out.println("Update successful");
            } else {
                System.out.println("something went wrong");
                if (count == 0) {
                    System.out.println("no row affected");
                } else {
                    System.out.println("many rows affected");
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println(reimbursement);
        return null;
    }

    @Override
    public List<Reimbursement> getByemployeeid(int employeeid) {
        String sql = "select * from reimbursement where employeeid = ? ;";
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int Eid = resultSet.getInt("employeeid");
                Reimbursement reimbursement = new Reimbursement(id, amount, description, status, Eid);


                reimbursements.add(reimbursement);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    @Override
    public List<Reimbursement> statusPending(int employeeid) {
        String sql = "select * from reimbursement where employeeid = ? and status = 'pending' ;";
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int Eid = resultSet.getInt("employeeid");
                Reimbursement reimbursement = new Reimbursement(id, amount, description, status, Eid);


                reimbursements.add(reimbursement);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    @Override
    public List<Reimbursement> statusApproved(int employeeid) {
        String sql = "select * from reimbursement where employeeid = ? and where status = 'approved';";
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int Eid = resultSet.getInt("employeeid");
                Reimbursement reimbursement = new Reimbursement(id, amount, description, status, Eid);


                reimbursements.add(reimbursement);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    @Override
    public List<Reimbursement> statusDenied(int employeeid) {
        String sql = "select * from reimbursement where employeeid = ? and status = 'denied' ;";
        List<Reimbursement> reimbursements = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeid);

            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println(resultSet);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int amount = resultSet.getInt("amount");
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                int Eid = resultSet.getInt("employeeid");
                Reimbursement reimbursement = new Reimbursement(id, amount, description, status, Eid);


                reimbursements.add(reimbursement);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }
}



