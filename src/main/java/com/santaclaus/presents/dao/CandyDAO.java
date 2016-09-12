package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import java.util.List;


public interface CandyDAO {

    void save(AbstractCandy candies);
    List<AbstractCandy> getByPresentId(int presentId);
    
}
