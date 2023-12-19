package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO>{
     /*String generateNewId() throws ClassNotFoundException, SQLException;
     boolean isExistOrder(String oid) throws SQLException, ClassNotFoundException;*/
    boolean save(String oid,String date,String cid) throws SQLException, ClassNotFoundException;
}
