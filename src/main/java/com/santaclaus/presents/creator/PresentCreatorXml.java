package com.santaclaus.presents.creator;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.parser.xml.PresentHandler;
import com.santaclaus.presents.present.Present;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;


public class PresentCreatorXml implements PresentCreator {
    
    private InputStream xmlFile;    
    
    public PresentCreatorXml(InputStream xmlFile){
        this.xmlFile = xmlFile;        
    }

    @Override
    public Present create(){
        
        Present present = null;
        
        try {        
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            PresentHandler handler = new PresentHandler();
            saxParser.parse(xmlFile, handler); 
            
            present = new Present();
            
            String presentName = handler.getPresentName();
            present.setName(presentName);
            
            List<AbstractCandy> candies = handler.getCandies();
            for (AbstractCandy candy : candies){
                present.addCandy(candy);
            }            
        }
        catch (ParserConfigurationException | SAXException | IOException e){
            throw new RuntimeException(e.getMessage(), e);
        }       
        
        return present;        
    }
    
}
