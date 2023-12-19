package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailDAO extends CrudDAO<OrderDetailDTO>{
    boolean save(String oid, OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
}
