package com.santaclaus.presents.candies;


public class LollipopCandyWithFilling extends LollipopCandy {
    
    public static final String TAG_FILLING_TYPE = "filling-type";
    public static final String FIELD_FILLING_TYPE = "filling_type";
    
    private FillingType fillingType;
    
    public LollipopCandyWithFilling(){}
    
    public LollipopCandyWithFilling(String name, double weight, double price, 
            TasteType tasteType, FillingType fillingType)
    {
        super(name, weight, price, tasteType);
        this.fillingType = fillingType;
    }

    public FillingType getFillingType() {
        return fillingType;
    }

    public void setFillingType(FillingType fillingType) {
        this.fillingType = fillingType;
    } 
    
}
