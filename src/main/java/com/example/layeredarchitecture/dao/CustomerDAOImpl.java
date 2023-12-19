package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM Customer");*/

        ResultSet customerDTOS=SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> getAllCustomers = new ArrayList<>();

        while (customerDTOS.next()){
            getAllCustomers.add(new CustomerDTO(customerDTOS.getString(1), customerDTOS.getString(2), customerDTOS.getString(3)));
        }
        return getAllCustomers;


    }
    @Override
    public boolean save(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());
        int isSaved = pstm.executeUpdate();
        
        if(isSaved > 0){
            return true;
        }
        return false;*/
        return SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getAddress());
    }
    @Override
    public boolean update(CustomerDTO customer) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, customer.getId());
        pstm.setString(2, customer.getName());
        pstm.setString(3, customer.getAddress());
        int isUpadated = pstm.executeUpdate();

        return isUpadated > 0;*/
        return SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?", customer.getName(), customer.getAddress(), customer.getId());
    }
    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeQuery().next();*/
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer WHERE id=?", id);
        if (rst.next()) {
            return true;
        } else {
            return false;
        }

    }
    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        int isDeleted = pstm.executeUpdate();

        return isDeleted > 0;*/
        return SQLUtil.execute("DELETE FROM Customer WHERE id=?", id);
    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
       /* Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = connection.createStatement().executeQuery("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");*/
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, id + "");
        ResultSet rst = pstm.executeQuery();*/
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer WHERE id=?", id);
        if(rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(id + "", rst.getString("name"), rst.getString("address"));
            return customerDTO;
        }else{
            return null;
        }
    }

}
