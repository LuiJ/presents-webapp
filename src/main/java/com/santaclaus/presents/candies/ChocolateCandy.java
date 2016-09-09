package com.santaclaus.presents.candies;


public class ChocolateCandy extends AbstractCandy {
    
    public static final String TAG_CHOCO_TYPE = "choco-type";
    public static final String FIELD_CHOCO_TYPE = "choco_type";
    
    private ChocoType chocoType; 
    
    public ChocolateCandy(){}
    
    public ChocolateCandy(String name, double weight, double price, ChocoType chocoType){   
        super(name, weight, price);     
        this.chocoType = chocoType;
    } 

    public ChocoType getChocoType() {
        return chocoType;
    }

    public void setChocoType(ChocoType chocoType) {
        this.chocoType = chocoType;
    } 
    
    @Override
    public String toString(){
        return super.toString() + ", type: "+this.getClass().getSimpleName();
    }
    
}
