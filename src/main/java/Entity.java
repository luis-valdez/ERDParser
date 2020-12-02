import java.util.ArrayList;

public class Entity {
    private String name;
    private ArrayList<Attribute> attributeArrayList;

    public Entity(String name, ArrayList<Attribute> attributeArrayList) {
        this.name = name;
        this.attributeArrayList = attributeArrayList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Attribute> getAttributeArrayList() {
        return attributeArrayList;
    }

    public void setAttributeArrayList(ArrayList<Attribute> attributeArrayList) {
        this.attributeArrayList = attributeArrayList;
    }
}
