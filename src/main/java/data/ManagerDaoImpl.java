package data;

import entity.Manager;

import java.sql.*;
import java.util.logging.Logger;

public class ManagerDaoImpl implements ManagerDao {
    Connection connection = ConnectionFactory.getConnection();

    public ManagerDaoImpl(){}





    @Override
    public Manager insert(Manager manager){
        Logger logger = Logger.getLogger("Manager Dao Impl");



        String sql = "insert into manager values (default, ?,?);";

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql,1);

            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getPassword());
            int count = preparedStatement.executeUpdate();
            if (count == 1) {
                logger.info("manager added successfully");
            }


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            manager.setId(resultSet.getInt(1));
            return manager;

        }catch (SQLException e){
            e.printStackTrace();
            logger.warning("something went wrong");
            return null;
        }


    }





    @Override
    public Manager getById(int id) {

        String sql = "select * from manager where id = ?;";

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                return new Manager(idDb, name, password);

            }

        }
        catch (SQLException e){
            System.out.println("something went wrong");
            e.printStackTrace();
        }

        return null;
    }



}
