
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.ArrayList;

class Person implements Comparable<Person> {
  
  private String name;
  private int age;
  private String status;
  public static ArrayList<Person> persons;
  
  static {
    persons = new ArrayList<>();
  }
  
  Person(String name, int age, String ... status) {
    this.name = name;
    this.age = age;
    this.status = Arrays.toString(status);
    persons.add(this);
  }
  
  Person(String name, int age) {
    this(name, age, "unemployed");
  }
  
  static class CompareAge implements Comparator<Person> {
    @Override
    public int compare(Person one, Person two) {
      return one.getAge() - two.getAge();
    }
  }
  
  
  @Override
  public int compareTo(Person p) {
    return name.compareTo(p.getName());
  }
  
  public String getName() { return name; }
  
  public int getAge() { return age; }
  
  @Override
  public String toString() {
    return String.format("Name: %s\nAge: %d\nStatus: %s\n", name, age, status);
  }
  
  public static void sortByAge() {
    
    if(persons.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }
    
    System.out.println("Before sorting...");
    for(Person n: persons) System.out.println(n.getAge() + " ");
    System.out.println();
    
    Collections.sort(persons, new CompareAge());
   
    System.out.println("After sorting...");
    for(Person n2: persons) System.out.println(n2.getAge() + " ");
    System.out.println();
    
  }
  
  public static void sortPersonsByName() {
    
    if(persons.isEmpty()) {
      System.out.println("List is empty!");
      return;
    }
    
    System.out.println("Before sorting...");
    for(Person n: persons) System.out.println(n.getName() + " ");
    System.out.println();
    
    Collections.sort(Person.persons);
   
    System.out.println("After sorting...");
    for(Person n2: persons) System.out.println(n2.getName() + " ");
    System.out.println();
    
  }
  
}

public class Main {
  public static void main(String[] args) {
    Person p = new Person("Wilson", 23, "Java - Developer", "Manager", "Trader", "Iron Man");
    Person p1 = new Person("Alex", 30);
    System.out.println(p);
    System.out.println(p1);
    
    Person.sortPersonsByName();
    Person.sortByAge();
    
  }
}