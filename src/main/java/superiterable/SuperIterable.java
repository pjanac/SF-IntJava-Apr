package superiterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

public final class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    this.self = self;
  }

  public <F> SuperIterable<F> map(Function<E, F> op) {
    ArrayList<F> rv = new ArrayList<>();
    // pass every item in "self" through op.apply
    // populate rv with results...
    return new SuperIterable<>(rv);
  }

  public SuperIterable<E> filter(Predicate<E> test) {
    ArrayList<E> rv = new ArrayList<>();
    self.forEach(i -> {if (test.test(i)) rv.add(i);});
    return new SuperIterable<>(rv);
  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }

  public static void main(String[] args) {
    SuperIterable<String> sis = new SuperIterable<>(Arrays.asList("Fred", "Jim", "Sheila"));

    sis
        .filter(s -> s.length() > 3)
        .filter(s -> s.length() < 6)
        .forEach(s -> System.out.println("> " + s));

    System.out.println("--------------------------------");
    sis
        // turn all the names, into upper case...
        .forEach(s -> System.out.println("> " + s));

    System.out.println("--------------------------------");
    sis
        // turn all the names into their lengths...
        .forEach(s -> System.out.println("> " + s));
  }
}