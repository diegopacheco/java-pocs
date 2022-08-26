import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@ValidationAnnotation
public @interface NotEmpty {

    class NotEmptyValidator implements Validator<String>{
        @Override
        public boolean validate(String input) {
            return (null==input || "".equals(input)) ? false : true;
        }
    }

}
