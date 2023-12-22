package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.dao.custom.impl.*;
import com.example.layeredarchitecture.db.DBConnection;

public class DAOFactory {
    //Singleton Design Pattern
    //1. Create a private constructor
    //2. Create a private static variable
    //3. Create a public static method to get the instance

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL ,QUERY
    }
    //SuperDAO > 
    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerDAOImpl();

            case ITEM:
                return new ItemDAOImpl();

            case ORDER:
                return new OrderDAOImpl();

            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
                
            case QUERY:
                return new QueryDAOImpl();    

            default:
                return null;

        }
    }
}
