package com.santaclaus.presents.parser.resultset;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.present.Present;


public class EntityBuilderFactory {
    
    public static EntityBuilder create(Class type){
        
            EntityBuilder builder = null;

            if (type == Present.class){
                builder = new PresentBuilder();
            }
            else if (type == AbstractCandy.class){
                builder = new CandyBuilder();
            }
            else {
                throw new IllegalArgumentException("Incorrect entity type.");
            }

            return builder;        
    }     
}
