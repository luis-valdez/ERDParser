import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Main {
    public static void main(String[] args){
        // read
        File file = new File("./test.json");
        JSONObject ERD_JSON = getJsonFromFile(file);
        JSONArray entities = (JSONArray) ERD_JSON.get("entidades");

        //iterate over entities
        ArrayList<Entity> entityArrayList = new ArrayList<>();
        ArrayList<Attribute> attributeArrayList = new ArrayList<>();
        for (Object entity: entities) {
            attributeArrayList.clear();

            JSONObject JSONentity = (JSONObject) entity ;
            JSONArray JSONArrayAttributes = (JSONArray) JSONentity.get("atributos");
            System.out.println(JSONentity.get("nombre"));
            String entityName = JSONentity.get("nombre").toString();

            //iterate over attributes
            for(Object attribute: JSONArrayAttributes){

                JSONObject JSONAttribute = (JSONObject) attribute;
                String attributeName = JSONAttribute.get("nombre").toString();
                attributeArrayList.add(new Attribute(attributeName, "VARCHAR"));

                System.out.println("--"+JSONAttribute.get("nombre"));

            }
            entityArrayList.add(new Entity(entityName, attributeArrayList));
        }
    }


    public static JSONObject getJsonFromFile(File inputSource) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(inputSource));
            return (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
