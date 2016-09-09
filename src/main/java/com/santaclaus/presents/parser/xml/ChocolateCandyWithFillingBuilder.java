package com.santaclaus.presents.parser.xml;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandyWithFilling;
import com.santaclaus.presents.candies.FillingType;
import java.util.Properties;


public class ChocolateCandyWithFillingBuilder extends ChocolateCandyBuilder {
    
    @Override
    public ChocolateCandyWithFilling build(Properties candyProperties, String candyType){
        
        ChocolateCandyWithFilling candy = (ChocolateCandyWithFilling) super.build(candyProperties, candyType);
        
        FillingType fillingType = FillingType
        .valueOf(candyProperties.getProperty(ChocolateCandyWithFilling.TAG_FILLING_TYPE));
        
        candy.setFillingType(fillingType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new ChocolateCandyWithFilling();
    }
    
}
    
    
