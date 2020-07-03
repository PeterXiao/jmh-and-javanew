/**
 *
 */
package basics.limits;

/**
 * @author Office
 *
 */
import java.util.concurrent.CompletionStage;

public interface AsyncHelloWorldService {
   default CompletionStage<String> returnHelloWorld(){
	return null;
   };

    CompletionStage<String> returnHelloWorldWithName(String name);

    CompletionStage<Void> sayHelloWorld();

    CompletionStage<Void> sayHelloWorldWithName(String name);
}
