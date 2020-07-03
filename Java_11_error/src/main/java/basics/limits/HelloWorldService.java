package basics.limits;


import java.io.IOException;

public interface HelloWorldService {

    // String returnHelloWorld();

    String returnHelloWorldWithException() throws IOException;

    String returnHelloWorldWithName(String name);

    String returnHelloWorldWithNameWithException(String name) throws IOException;

    void sayHelloWorld();

    void sayHelloWorldWithException() throws IOException;

    void sayHelloWorldWithName(String name);

    void sayHelloWorldWithNameWithException(String name) throws IOException;

    default String returnHelloWorld() {
	 return "world";
    }
}
