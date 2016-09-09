package com.santaclaus.presents.candies;


public abstract class AbstractCandy implements Identifiable {
    
    public static final String TAG_CANDY = "candy";
    public static final String TAG_NAME = "name";
    public static final String TAG_WEIGHT = "weight";
    public static final String TAG_PRICE = "price";
    
    public static final String TABLE_NAME = "candy";
    public static final String FIELD_ID = "id";
    public static final String FIELD_PRESENT_ID = "present_id";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_WEIGHT = "weight";
    public static final String FIELD_PRICE = "price";
    
    private int id;
    private int presentId;
    private String name;
    private double weight;
    private double price;
    private String type;
    
    public AbstractCandy(){}
    
    public AbstractCandy(String name, double weight, double price){
        this.name = name;
        this.weight = weight;
        this.price = price;
        type = this.getClass().getSimpleName();
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public void setId(int id){
        this.id = id;
    }

    public int getPresentId(){
        return presentId;
    }

    public void setPresentId(int presentId) {
        this.presentId = presentId;
    }

    public void setType(String type) {
        this.type = type;
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
    
    public void setWeight(double weight){
        this.weight = weight;
    }    
    public double getWeight(){
        return weight;
    }
   
    public void setPrice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }
    
    @Override
    public String toString(){
        return "PresentID#"+presentId+", CandyID#"+id+", Name: "+name+", Weight: "+weight+", Price: "+price;
    }
}
