package bad.robot.unicorn;

import java.util.HashMap;
import java.util.Map;

public class Primitives {

    private static Map<Class, Object> primitives = new HashMap<Class, Object>() {{
        put(boolean.class, new Boolean(false));
        put(byte.class, new Byte((byte) 0));
        put(char.class, new Character(' '));
        put(double.class, new Double(0));
        put(float.class, new Float(0F));
        put(int.class, new Integer(0));
        put(long.class, new Long(0));
        put(short.class, new Short((short) 0));
        put(void.class, null);
    }};

    public static Object newInstanceOf(Class<?> type) {
        return primitives.get(type);
    }

}
