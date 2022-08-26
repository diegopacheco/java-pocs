import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;

public class Unsafe {

    private static sun.misc.Unsafe INSTANCE;

    public static sun.misc.Unsafe getInstance() {
        try {
            if (null == INSTANCE) {
                synchronized (Unsafe.class) {
                    Field f = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
                    f.setAccessible(true);
                    INSTANCE = (sun.misc.Unsafe) f.get(null);
                }
            }
            return INSTANCE;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long getFieldOffset(String fieldName) {
        try {
            return getInstance().objectFieldOffset(String.class.getDeclaredField(fieldName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void copy(Object objectSource,Field fieldSource, Object objectTarget,Field fieldTarget) {
        try {
            long sourceOffset = getInstance().objectFieldOffset(fieldSource);
            long targetOffset = getInstance().objectFieldOffset(fieldTarget);
            Object value = getInstance().getObject(objectSource,sourceOffset);
            getInstance().putObject(objectTarget,targetOffset,value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long toAddress(Object obj) {
        Object[] array = new Object[] {obj};
        long baseOffset = getInstance().arrayBaseOffset(Object[].class);
        return normalize(getInstance().getInt(array, baseOffset));
    }

    private static long normalize(int value) {
        if(value >= 0) return value;
        return (~0L >>> 32) & value;
    }

    private static long sizeOf(Object o) {
        sun.misc.Unsafe u = getInstance();
        HashSet<Field> fields = new HashSet<Field>();
        Class c = o.getClass();
        while (c != Object.class) {
            for (Field f : c.getDeclaredFields()) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }
        // get offset
        long maxSize = 0;
        for (Field f : fields) {
            long offset = u.objectFieldOffset(f);
            if (offset > maxSize) {
                maxSize = offset;
            }
        }
        return ((maxSize/8) + 1) * 8;   // padding
    }

}
