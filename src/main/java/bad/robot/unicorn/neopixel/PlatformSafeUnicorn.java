package bad.robot.unicorn.neopixel;

import bad.robot.unicorn.Primitives;
import bad.robot.unicorn.Unicorn;
import bad.robot.unicorn.Wrappers;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.function.Supplier;

import static bad.robot.unicorn.neopixel.Platform.runningOnPi;

public class PlatformSafeUnicorn implements InvocationHandler {

    private final Supplier<Unicorn> factory;

    private Unicorn delegate;

    public static Unicorn createPlatformSafeUnicorn(Supplier<Unicorn> factory) {
        InvocationHandler handler = new PlatformSafeUnicorn(factory);
        return (Unicorn) Proxy.newProxyInstance(Unicorn.class.getClassLoader(), new Class[]{Unicorn.class}, handler);
    }

    public PlatformSafeUnicorn(Supplier<Unicorn> factory) {
        this.factory = factory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (runningOnPi() && delegate == null)
            delegate = factory.get();
        if (runningOnPi())
            return method.invoke(factory, args);
        return innocuousValue(method);
    }

    private Object innocuousValue(Method method) throws InstantiationException, IllegalAccessException {
        Class<?> returnType = method.getReturnType();
        if (returnType.isPrimitive())
            return Primitives.newInstanceOf(returnType);
        return Wrappers.newInstanceOf(returnType);
    }
}


