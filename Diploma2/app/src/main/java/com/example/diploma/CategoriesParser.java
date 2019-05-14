package com.example.diploma;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;
import android.net.Uri;
public class CategoriesParser {
    private ArrayList<AllCategories> categories;

    public CategoriesParser(){
        categories = new ArrayList<>();
    }

    public ArrayList<AllCategories> getCategories(){
        return  categories;
    }

    public boolean parse(XmlPullParser xpp){
        boolean status = true;
        AllCategories currentCategory = null;
        boolean inEntry = false;
        String textValue = "";
        String imgValue = "";

        try{
            int eventType = xpp.getEventType();
            while(eventType != XmlPullParser.END_DOCUMENT){

                String tagName = xpp.getName();
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("category".equalsIgnoreCase(tagName)){
                            inEntry = true;
                            currentCategory = new AllCategories();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("category".equalsIgnoreCase(tagName)){
                                categories.add(currentCategory);
                                inEntry = false;
                            } else if("name".equalsIgnoreCase(tagName)){
                                currentCategory.setName(textValue);
                            } else if("info".equalsIgnoreCase(tagName)){
                                currentCategory.setInfo(textValue);
                            } else if("image".equalsIgnoreCase(tagName)) {
                                currentCategory.setImg(imgValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }
        }
        catch (Exception e){
            status = false;
            e.printStackTrace();
        }
        return  status;
    }
}
