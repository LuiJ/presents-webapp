package com.santaclaus.presents.candies;


public class LollipopCandy extends AbstractCandy {

    public static final String TAG_TASTE_TYPE = "taste-type";
    public static final String FIELD_TASTE_TYPE = "taste_type";
    
    private TasteType tasteType;
    
    public LollipopCandy(){} 
    
    public LollipopCandy(String name, double weight, double price, TasteType tasteType){   
        super(name, weight, price);     
        this.tasteType = tasteType;
    } 

    public TasteType getTasteType() {
        return tasteType;
    }

    public void setTasteType(TasteType tasteType) {
        this.tasteType = tasteType;
    } 
    
    @Override
    public String toString(){
        return super.toString() + ", type: "+this.getClass().getSimpleName();
    }
    
}
