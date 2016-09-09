package com.santaclaus.presents.present;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.Identifiable;
import java.util.ArrayList;
import java.util.List;


public class Present implements Identifiable {
    
    public static final String TAG_PRESENT = "present";
    
    public static final String TABLE_NAME = "present";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    
    private int id;
    private String name;
    private String type;
    private List<AbstractCandy> candies;
    
    public Present(){
        type = this.getClass().getSimpleName();
        candies = new ArrayList<AbstractCandy>();
    }
    
    public Present(int id, String name){
        this.id = id;
        this.name = name;
        type = this.getClass().getSimpleName();
        candies = new ArrayList<AbstractCandy>();
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public void setId(int id){
        this.id = id;
    }

    public String getType() {
        return type;
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
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName()+": id=" + id + ", name=" + name;
    }
    
}
