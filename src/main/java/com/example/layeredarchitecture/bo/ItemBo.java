package com.example.layeredarchitecture.bo;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo {
    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean delete(String code) throws SQLException, ClassNotFoundException;
    boolean save(ItemDTO item) throws SQLException, ClassNotFoundException;
    boolean update(ItemDTO item) throws SQLException, ClassNotFoundException;
    boolean exist(String code) throws SQLException, ClassNotFoundException;
    String generateNewId() throws SQLException, ClassNotFoundException;
}
