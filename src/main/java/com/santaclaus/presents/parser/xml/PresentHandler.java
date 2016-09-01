package com.santaclaus.presents.parser.xml;

import com.santaclaus.presents.candies.AbstractCandy;
import com.santaclaus.presents.present.Present;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class PresentHandler extends DefaultHandler {
            
    private static final String ATTRIBUTE_TYPE = "type";
    private static final String ATTRIBUTE_NAME = "name";
    
    private String presentName;
    private boolean isTagCandy = false;
    private boolean isStartTag = false;
    private String tagName;
    private String candyType;
    private Properties candyProperties;
    private List<AbstractCandy> candies;

    public String getPresentName() {
        return presentName;
    }

    public List<AbstractCandy> getCandies() {
        return candies;
    }  
    
    public PresentHandler(){
        this.candies = new ArrayList<AbstractCandy>();
    }

    @Override
    public void startElement(String uri, String localName,String tagName,
        Attributes attributes) throws SAXException 
    {
        isStartTag = true;
        this.tagName = tagName; 
        if (tagName.equalsIgnoreCase(AbstractCandy.TAG_CANDY)) { 
            candyProperties = new Properties();
            candyType = attributes.getValue(ATTRIBUTE_TYPE); 
            if (candyType == null || candyType.equals("")){
                throw new SAXException("'"+ATTRIBUTE_TYPE+"' attribute in '"+AbstractCandy.TAG_CANDY+"' tag is empty");
            }
            isTagCandy = true;
        }    
        if (tagName.equalsIgnoreCase(Present.TAG_PRESENT)) {
            presentName = attributes.getValue(ATTRIBUTE_NAME); 
            if (presentName == null || presentName.equals("")){
                throw new SAXException("'"+ATTRIBUTE_NAME+"' attribute in '"+Present.TAG_PRESENT+"' tag is empty");
            }
        }
    }
    

    @Override
    public void endElement(String uri, String localName,
        String tagName) throws SAXException 
    {
        if (tagName.equalsIgnoreCase(AbstractCandy.TAG_CANDY)) {
            isTagCandy = false;
            AbstractCandy candy = CandyFactory.create(candyProperties, candyType);
            candies.add(candy);
        } 
    }
    

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (isTagCandy && isStartTag && !tagName.equalsIgnoreCase(AbstractCandy.TAG_CANDY)) {
            String tagValue = new String(ch, start, length);
            if (tagValue.length() == 0){
                throw new SAXException("Value of "+tagName+"' tag is empty");
            }
            candyProperties.setProperty(tagName, tagValue);
            isStartTag = false;
        }
    }
    
}
