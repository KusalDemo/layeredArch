package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.QueryDAO;
import com.example.layeredarchitecture.model.SearchDTO;
import com.example.layeredarchitecture.model.SearchOrderDTO;

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

    public ArrayList<SearchOrderDTO> getAllOrderDetails(String id) throws SQLException, ClassNotFoundException {
        ResultSet allOrderDetails = SQLUtil.execute("select od.oid, o.date, od.itemCode, i.description, od.qty, od.unitPrice from OrderDetails od join Item i on od.itemCode = i.code join Orders o on od.oid = o.oid where o.oid = ?", id);
        ArrayList<SearchOrderDTO> allDetails = new ArrayList<>();
        while (allOrderDetails.next()){
            allDetails.add(new SearchOrderDTO(
                    allOrderDetails.getString(1),
                    allOrderDetails.getString(2),
                    allOrderDetails.getString(3),
                    allOrderDetails.getString(4),
                    allOrderDetails.getString(5),
                    allOrderDetails.getString(6)
            ));
        }
        return allDetails;
    }
}
