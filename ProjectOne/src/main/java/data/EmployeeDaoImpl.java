package data;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao {
    Connection connection = ConnectionFactory.getConnection();

    public EmployeeDaoImpl(){

    }

    @Override
    public Employee insert(Employee employee){
        Logger logger = Logger.getLogger("employee Dao Impl");

        String sql = "insert into employee values(default, ?, ?, ?, ?,?, ?);";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, 1);

            preparedStatement.setString(1, employee.getUsername());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setInt(4, employee.getPhonenumber());
            preparedStatement.setString(5, employee.getPassword());
            preparedStatement.setString(6,"employee");


            int count = preparedStatement.executeUpdate();
            if (count == 1){
                logger.info("Employee added successfully");

            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            employee.setEmployeeid(resultSet.getInt(1));
            return employee;


        }catch (SQLException e){
            e.printStackTrace();
            logger.warning("Something went wrong when prepare statement");
            return null;
        }



    }
    @Override
    public Employee getById(int employeeid){
        String sql = "select * from employee where employeeid = ?; ";
            try{
                PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
                preparedStatement.setInt(1, employeeid);
                ResultSet resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    int idDb = resultSet.getInt("employeeid");
                    String username = resultSet.getString("username");
                    String name = resultSet.getString("name");

                    String address = resultSet.getString("address");
                    int phonenumber = resultSet.getInt("phonenumber");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");







                   return new Employee(idDb, username, name, address, phonenumber,password, role);

                }



            }catch (SQLException e){
                System.out.println("something went wrong when trying to retrieve data");
                e.printStackTrace();
            }

            return null;
    }
    @Override
    public List<Employee> getAllEmployees(){
        List<Employee> employees = new ArrayList<>();
        String sql = "select * from employee;";
        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int employeeid = resultSet.getInt("employeeid");

                String username = resultSet.getString("username");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                int phonenumber = resultSet.getInt("phonenumber");
                String role = resultSet.getString("role");

                Employee employee = new Employee(employeeid, username, name, address, phonenumber, role);
                employees.add(employee);





            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }




    @Override
    public Employee update(Employee employee){
        String sql = "update employee set name = ?, address = ?, phonenumber = ? where employeeid =?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getAddress());
            preparedStatement.setInt(3, employee.getPhonenumber());

            int count = preparedStatement.executeUpdate();
            if(count == 1 ){
                System.out.println("Update successful");
            }else {
                System.out.println("Something went wrong");
                if (count == 0){
                    System.out.println("no row affected");

                }else {
                    System.out.println("many row affected");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

}
