import java.util.List;

public class FakeObject {
        
    private String  id;
    private Integer value;
    private String  name;

    public FakeObject(){}

    public FakeObject(String id,Integer value,String name){
        this.id    = id;
        this.value = value;
        this.name  = name;
    }

    public void fakeMethod(String fakeName, Long fakeNumber, List<String> fakeList) {}
    
    public  void fakeMethodWithComplexObject(Object fakeObj){}
    
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getValue() {
        return value;
    }

}