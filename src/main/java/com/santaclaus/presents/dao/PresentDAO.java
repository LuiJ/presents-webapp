package com.santaclaus.presents.dao;

import com.santaclaus.presents.present.Present;
import java.util.List;


public interface PresentDAO {

    int addPresent(Present present);
    Present getPresentById(int id);
    List<Present> getAllPresents();
    
}
