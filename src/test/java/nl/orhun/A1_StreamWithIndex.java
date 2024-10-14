package nl.orhun;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class A1_StreamWithIndex {

  @Test
  void streamWithIndex() {
    record Person(int id, String name) {}

    List<String> names = List.of("Gokhan", "Ozlem", "Elisa", "Emir");

    //Stream with indexed iteration
    List<Person> list = IntStream.range(0, names.size())
        .mapToObj(value -> new Person(value, names.get(value))).toList();

    assertThat(list).containsExactlyInAnyOrder(
        new Person(0, "Gokhan"),
        new Person(1, "Ozlem"),
        new Person(2, "Elisa"),
        new Person(3, "Emir")
    );
  }
}
