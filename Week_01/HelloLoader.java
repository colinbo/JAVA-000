import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Base64;

public class HelloLoader extends ClassLoader {

    public static void main(String[] args) {
        try {

            Class helloClass = new HelloLoader().findClass("Hello");
            Object helloObj = helloClass.newInstance();
            Method method = helloClass.getDeclaredMethod("hello");
            method.invoke(helloObj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected Class<?> findClass(String classname) throws ClassNotFoundException {
        String classContent = "yv66vgAAADQAHAoABgAOCQAPABAIABEKABIAEwcAFAcAFQEABjxpbml0PgEAAygpVgEABENvZGUB" +
                "AA9MaW5lTnVtYmVyVGFibGUBAAVoZWxsbwEAClNvdXJjZUZpbGUBAApIZWxsby5qYXZhDAAHAAgH" +
                "ABYMABcAGAEAE0hlbGxvLCBjbGFzc0xvYWRlciEHABkMABoAGwEABUhlbGxvAQAQamF2YS9sYW5n" +
                "L09iamVjdAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsB" +
                "ABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgAh" +
                "AAUABgAAAAAAAgABAAcACAABAAkAAAAdAAEAAQAAAAUqtwABsQAAAAEACgAAAAYAAQAAAAEAAQAL" +
                "AAgAAQAJAAAAJQACAAEAAAAJsgACEgO2AASxAAAAAQAKAAAACgACAAAABAAIAAUAAQAMAAAAAgAN";

        byte[] bytes = Base64.getDecoder().decode(classContent);
        return defineClass(classname, bytes, 0, bytes.length);

    }
}
