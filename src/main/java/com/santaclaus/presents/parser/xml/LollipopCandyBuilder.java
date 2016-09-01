package com.santaclaus.presents.parser.xml;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.LollipopCandy;
import com.santaclaus.presents.candies.properties.TasteType;
import java.util.Properties;


public class LollipopCandyBuilder extends AbstractCandyBuilder {
    
    @Override
    public LollipopCandy build(Properties candyProperties, String candyType){
        
        LollipopCandy candy = (LollipopCandy) super.build(candyProperties, candyType);
        
        TasteType tasteType = TasteType.valueOf(candyProperties.getProperty(LollipopCandy.TAG_TASTE_TYPE));
        
        candy.setTasteType(tasteType);
        
        return candy;
        
    }  
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new LollipopCandy();
    }
    
    
}
