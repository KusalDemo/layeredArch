package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean saveOrderDetails(String oid, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        /*Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO `OrderDetails` (oid, itemCode, qty, unitPrice) VALUES (?,?,?,?)");
        pstm.setString(1, oid);
        pstm.setString(2, orderDetailDTO.getItemCode());
        pstm.setInt(3, orderDetailDTO.getQty());
        pstm.setDouble(4, orderDetailDTO.getUnitPrice().doubleValue());
        int isSaved = pstm.executeUpdate();
        return isSaved > 0;*/
        return SQLUtil.execute("INSERT INTO `OrderDetails` (oid, itemCode, qty, unitPrice) VALUES (?,?,?,?)", oid, orderDetailDTO.getItemCode(), orderDetailDTO.getQty(), orderDetailDTO.getUnitPrice());
    }

}
