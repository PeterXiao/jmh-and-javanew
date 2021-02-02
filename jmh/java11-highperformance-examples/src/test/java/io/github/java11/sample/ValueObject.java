package io.github.java11.sample;

import java.util.List;
import java.util.Optional;

import org.immutables.value.Value;

// Define abstract value type
@Value.Immutable
public interface ValueObject {
    String name();

    List<Integer> counts();

    Optional<String> description();
}