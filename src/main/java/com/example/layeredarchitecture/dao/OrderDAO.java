package com.example.layeredarchitecture.dao;

import java.sql.SQLException;

public interface OrderDAO {
     String generateNewId() throws ClassNotFoundException, SQLException;
     boolean isExistOrder(String oid) throws SQLException, ClassNotFoundException;
    boolean saveOrder(String oid,String date,String cid) throws SQLException, ClassNotFoundException;
}
