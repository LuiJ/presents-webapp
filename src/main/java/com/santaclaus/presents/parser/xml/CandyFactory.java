package com.santaclaus.presents.parser.xml;

import com.santaclaus.presents.candies.AbstractCandy;
import java.util.Properties;


public class CandyFactory {
    
    private static final String CHOCO_CANDY = "ChocolateCandy";
    private static final String CHOCO_CANDY_WITH_FILLING = "ChocolateCandyWithFilling";
    private static final String LOLLIPOP_CANDY = "LollipopCandy";
    private static final String LOLLIPOP_CANDY_WITH_FILLING = "LollipopCandyWithFilling";

    private static AbstractCandyBuilder builder;
    
    public static AbstractCandy create(Properties candyProperties, String candyType){
        
        AbstractCandy candy = null;
        
        if (candyType.equals(CHOCO_CANDY)){
            builder = new ChocolateCandyBuilder();
        }
        else if (candyType.equals(CHOCO_CANDY_WITH_FILLING)){
            builder = new ChocolateCandyWithFillingBuilder();
        }
        else if (candyType.equals(LOLLIPOP_CANDY)){
            builder = new LollipopCandyBuilder();
        }
        else if (candyType.equals(LOLLIPOP_CANDY_WITH_FILLING)){
            builder = new LollipopCandyWithFillingBuilder();
        }
        else {
            throw new IllegalArgumentException("'"+candyType+"' is incorrect CANDY TYPE");
        }
        
        candy = builder.build(candyProperties, candyType);
        
        return candy;
        
    }   
    
}
