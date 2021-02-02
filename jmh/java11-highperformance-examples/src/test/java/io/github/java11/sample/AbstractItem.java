 package io.github.java11.sample;

 import java.util.Optional;
 import java.util.Set;

 import org.immutables.value.Value;

 // Or you can configure different @Value.Style
 @Value.Immutable
 abstract class AbstractItem {
     abstract String getName();

     abstract Set<String> getTags();

     abstract Optional<String> getDescription();
}