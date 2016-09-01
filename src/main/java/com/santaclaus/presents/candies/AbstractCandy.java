package com.santaclaus.presents.candies;


public abstract class AbstractCandy implements Identifiable {
    
    public static final String TAG_CANDY = "candy";
    public static final String TAG_NAME = "name";
    public static final String TAG_WEIGHT = "weight";
    public static final String TAG_PRICE = "price";
    
    public static final String FIELD_ID = "candy.id";
    public static final String FIELD_PRESENT_ID = "candy.present_id";
    public static final String FIELD_TYPE = "candy.type";
    public static final String FIELD_NAME = "candy.name";
    public static final String FIELD_WEIGHT = "candy.weight";
    public static final String FIELD_PRICE = "candy.price";
    
    private int id;
    private int presentId;
    private String type;
    private String name;
    private double weight;
    private double price;
    
    public AbstractCandy(){}
    
    public AbstractCandy(String name, double weight, double price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPresentId(){
        return presentId;
    }

    public void setPresentId(int presentId) {
        this.presentId = presentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "PresentID#"+presentId+", CandyID#"+id+", CandyType: "+type+", Name: "+name+", Weight: "+weight+", Price: "+price+";";
    }
}
