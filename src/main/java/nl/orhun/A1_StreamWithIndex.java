package nl.orhun;

import java.util.List;
import java.util.stream.IntStream;

public class A1_StreamWithIndex {

  public static void main(String[] args) {
    record Person(int id, String name) {}

    List<String> names = List.of("Gokhan", "Ozlem", "Elisa", "Emir");

    //Stream with indexed iteration
    List<Person> list = IntStream.range(0, names.size())
        .mapToObj(value -> new Person(value, names.get(value))).toList();

    System.out.println(list);
  }
}
