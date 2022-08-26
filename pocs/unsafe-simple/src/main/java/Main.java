import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws Exception {
        Person p = (Person) Unsafe.getInstance().allocateInstance(Person.class);
        p.setDob("2020/01/01");
        p.setEmail("person@people.com");
        p.setName("Person1");
        System.out.println(p);

        System.out.println("Bench Unsafe ************");
        long total=0;
        PersonV2 p2 = new PersonV2();
        for(int i : Arrays.asList(1,2,3,4,5,6,7,8,9,10)) {
            total = benchUnsafe(p, p2);
        }
        System.out.println(p2);
        System.out.println("AVG(ns): " + (total/10) + " ns");

        System.out.println("Bench Reflections ************");
        total=0;
        p2 = new PersonV2();
        for(int i : Arrays.asList(1,2,3,4,5,6,7,8,9,10)){
            total += benchReflections(p,p2);
        }
        System.out.println(p2);
        System.out.println("AVG(ns): " + (total/10) + " ns");
    }

    public static long benchReflections(Person v1, PersonV2 v2){
        long init = System.nanoTime();
        Field sourceFieldName = Reflections.getField(Person.class,"name");
        Field targetFieldName = Reflections.getField(PersonV2.class,"name");
        Reflections.setString(v2, targetFieldName,Reflections.getString(v1, sourceFieldName));

        Field sourceFieldMail = Reflections.getField(Person.class,"email");
        Field targetFieldMail = Reflections.getField(PersonV2.class,"email");
        Reflections.setString(v2, targetFieldMail,Reflections.getString(v1, sourceFieldMail));

        long end = System.nanoTime();
        System.out.println("Reflections Benchmark " + (end-init) + " ns");
        return end-init;
    }

    public static long benchUnsafe(Person v1,PersonV2 v2) throws Exception {
        long init = System.nanoTime();
        Field sourceFieldName = Reflections.getField(Person.class,"name");
        Field targetFieldName = Reflections.getField(PersonV2.class,"name");
        Unsafe.copy(v1,sourceFieldName,v2,targetFieldName);

        Field sourceFieldMail = Reflections.getField(Person.class,"email");
        Field targetFieldMail = Reflections.getField(PersonV2.class,"email");
        Unsafe.copy(v1,sourceFieldMail,v2,targetFieldMail);

        long end = System.nanoTime();
        System.out.println("Unsafe Benchmark " + (end-init) + " ns");
        return end-init;
    }

}
