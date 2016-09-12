package com.santaclaus.presents.dao;

import com.santaclaus.presents.present.Present;
import java.util.List;


public interface PresentDAO {

    int save(Present present);
    Present getById(int id);
    List<Present> getAll();
    
}
