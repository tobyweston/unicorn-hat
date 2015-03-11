package bad.robot.unicorn;

import java.util.HashMap;
import java.util.Map;

public class Wrappers {

    private static Map<Class, Object> wrappers = new HashMap<Class, Object>() {{
        put(Boolean.class, new Boolean(false));
        put(Byte.class, new Byte((byte) 0));
        put(Character.class, new Character(' '));
        put(Double.class, new Double(0));
        put(Float.class, new Float(0F));
        put(Integer.class, new Integer(0));
        put(Long.class, new Long(0));
        put(Short.class, new Short((short) 0));
        put(Void.class, null);
    }};

    public static Object newInstanceOf(Class<?> type) throws IllegalAccessException, InstantiationException {
        if (wrappers.containsKey(type))
            return wrappers.get(type);
        return type.newInstance();
    }

}
