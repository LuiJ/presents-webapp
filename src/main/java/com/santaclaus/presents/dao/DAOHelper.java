package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.Identifiable;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * Created by Filipp_Stankevich on 9/1/2016.
 */
public class DAOHelper <T extends Identifiable> {


    public List<T> getAll() {

        //делегация запроса в executeQuery: SELECT * FROM Candy.TABLE_NAME, имя таблицы, возможно через reflection


        throw new NotImplementedException();
    }

    public T getById(int id) {
        throw new NotImplementedException();
    }

    public void save(T instance) {

        //возможно изпользовать reflection, получая значения статических полей в классе с именами полей в БД

        throw new NotImplementedException();
    }

    private List<T> executeQuery(String query) {

        //SELECT * FROM Candy.TABLE_NAME, имя таблицы, возможно через reflection

        //Вызов билдера на основе класса T

        throw new NotImplementedException();
    }

    private T executeQueryForSingeResult(String query) {

        //Вызов  List<T> executeQuery
        throw new NotImplementedException();
    }


}
