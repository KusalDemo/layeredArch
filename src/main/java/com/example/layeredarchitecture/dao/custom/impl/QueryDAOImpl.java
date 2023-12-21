package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.SearchDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
    public ArrayList<SearchDTO> search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute("select c.name, o.oid, o.date from Customer c join Orders o on c.id = o.customerID where o.customerID = ?",id);
        ArrayList<SearchDTO> searchDTOS = new ArrayList<>();

        while (resultSet.next()){
            searchDTOS.add(new SearchDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return searchDTOS;
    }
}
