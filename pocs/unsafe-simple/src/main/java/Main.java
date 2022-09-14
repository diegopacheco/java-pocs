import java.lang.reflect.Field;
public class Main {

    private static final int UP_TO = 1_000;

    public static void main(String args[]) throws Exception {

        Person p = (Person) Unsafe.getInstance().allocateInstance(Person.class);
        p.setDob("2020/01/01");
        p.setEmail("person@people.com");
        p.setName("Person1");
        PersonV2 p2 = new PersonV2();

        // warm up 10%
        for(int i=0;i<=UP_TO/10;i++) {
            benchReflections(p,p2);
            benchUnsafe(p, p2);
        }

        System.out.println("Bench up to: " + UP_TO + " Conversions! ");

        System.out.println("Bench Unsafe ************");
        long total=0;

        for(int i=0;i<=UP_TO;i++) {
            total += benchUnsafe(p, p2);
        }
        System.out.println("AVG(ns): " + (total/10) + " ns");

        System.out.println("Bench Reflections ************");
        total=0;
        p2 = new PersonV2();
        for(int i=0;i<=UP_TO;i++) {
            total += benchReflections(p,p2);
        }
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
        return end-init;
    }

}
