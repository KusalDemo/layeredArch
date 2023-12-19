package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateNewId() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
    @Override
    public boolean isExistOrder(String oid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
        stm.setString(1, oid);

        if (stm.executeQuery().next()) {
            return true;
        }else{
            return false;
        }
    }
    @Override
    public boolean saveOrder(String oid,String date,String cid) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
        pstm.setString(1, oid);
        pstm.setString(2, date);
        pstm.setString(3, cid);
        int isSaved = pstm.executeUpdate();

        return isSaved > 0;
    }


}
