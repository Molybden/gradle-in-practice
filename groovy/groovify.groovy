import java.util.ArrayList;
import java.util.List;
public class User{
    private String name;
    private int age;
    private List list = new ArrayList();
    public void setAge(int age){
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void quote(String quote){
        System.out.println(name+" says: '"+quote+"'");
    }
    public void likes(String name){
        list.add(name);
    }
    public List likes(){
        return list;
    }    
}

User user = new User();
user.setName("Albert");
user.setAge(42);
user.likes("Hamburgers");
user.likes("Pizza");
user.quote("Hi, nice to meet you.");
List list = user.likes();