package com.santaclaus.presents.parser.xml;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.candies.ChocolateCandy;
import com.santaclaus.presents.candies.ChocoType;
import java.util.Properties;


public class ChocolateCandyBuilder extends AbstractCandyBuilder {
    
    @Override
    public ChocolateCandy build(Properties candyProperties, String candyType){
        
        ChocolateCandy candy = (ChocolateCandy) super.build(candyProperties, candyType);
        
        ChocoType chocoType = ChocoType
        .valueOf(candyProperties.getProperty(ChocolateCandy.TAG_CHOCO_TYPE));
        
        candy.setChocoType(chocoType);
        
        return candy;
        
    }
    
    @Override
    protected AbstractCandy createSpecificCandy(){
        return new ChocolateCandy();
    }
    
}
