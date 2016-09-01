package com.santaclaus.presents.dao;

import com.santaclaus.presents.candies.AbstractCandy;
import java.util.List;


public interface CandyDAO {

    void addCandies(int presentId, List<AbstractCandy> candies);
    
}
