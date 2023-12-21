package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public boolean save(String oid, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
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

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(OrderDetailDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public OrderDetailDTO search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

}
