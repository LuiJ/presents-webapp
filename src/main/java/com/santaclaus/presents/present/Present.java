package com.santaclaus.presents.present;

import com.santaclaus.presents.candies.AbstractCandy;
import java.util.ArrayList;
import java.util.List;


public class Present {
    
    public static final String TAG_PRESENT = "present";
    
    public static final String FIELD_ID = "present.id";
    public static final String FIELD_NAME = "present.name";
    
    private int id;
    private String name;
    private List<AbstractCandy> candies;
    
    public Present(){
        candies = new ArrayList<AbstractCandy>();
    }
    
    public Present(int id, String name){
        this.id = id;
        this.name = name;
        candies = new ArrayList<AbstractCandy>();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addCandy(AbstractCandy candy){
        candies.add(candy);
    }

    public List<AbstractCandy> getCandies(){
        return candies;
    }
    
}
