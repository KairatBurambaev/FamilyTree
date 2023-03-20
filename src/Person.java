import java.io.Serializable;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private String gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String gender) {
        this(name, gender, null, null);
    }

    public Person(String name, String gender, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public boolean addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getMotherInfo() {
        String res = "Мама: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "Нет данных";
        }
        return res;
    }

    private String getFatherInfo() {
        String res = "Папа: ";
        if (father != null) {
            res += father.getName();
        } else {
            res += "Нет данных";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("Отсутствует");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person) obj;
        return person.getName().equals(getName());
    }
}