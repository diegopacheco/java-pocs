import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Reflections {
    private static Map<String,Field> cache = new ConcurrentHashMap<>();

    public static Field getField(Class clazz,String field){
        String fieldName = clazz.getName()+"."+field;
        Field f = cache.get(fieldName);
        if (null==f){
            try{
                f = clazz.getDeclaredField(field);
                f.setAccessible(true);
                cache.put(fieldName,f);
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        return f;
    }

    public static void setString(Object o,Field f,Object value){
        try{
            f.set(o,(String)value);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String getString(Object o,Field f){
        try{
            return (String)f.get(o);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
