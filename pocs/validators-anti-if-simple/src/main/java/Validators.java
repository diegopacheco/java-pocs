import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

// TODO: Add 3 caches: Fields, Annotations and Annotations of Annotations
public final class Validators {

    public static final <I> boolean validade(I input){
        try{
            for (Field f: input.getClass().getDeclaredFields()){
                for(Annotation annotation : f.getDeclaredAnnotations()){
                    ValidationAnnotation a = (ValidationAnnotation)
                            annotation.annotationType().getDeclaredAnnotation(ValidationAnnotation.class);

                    if (null!=a){
                        Validator validator = (Validator)
                                annotation.annotationType().getDeclaredClasses()[0].
                                        getDeclaredConstructors()[0].newInstance();
                        f.setAccessible(true);
                        boolean result = validator.validate(f.get(input));
                        if (!result)
                            return false;
                    }
                }
            }
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
