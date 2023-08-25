package item02;

public class Person {

  /* 점층적 생성자 패턴
  private final long id;        // 필수
  private final String name;    // 필수
  private final int age;        // 필수
  private final String job;     // 선택
  private final String address; // 선택
  private final int weight;     // 선택

  public Person(long id, String name, int age) {
    this(id, name, age, null);
  }

  public Person(long id, String name, int age, String job) {
    this(id, name, age, job, null);
  }

  public Person(long id, String name, int age, String job, String address) {
    this(id, name, age, job, address, 0);
  }

  public Person(long id, String name, int age, String job, String address, int weight) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.job = job;
    this.address = address;
    this.weight = weight;
  }
  */

  /* 자바 빈즈 패턴
  private long id;        // 필수
  private String name;    // 필수
  private int age;        // 필수
  private String job;     // 선택
  private String address; // 선택
  private int weight;     // 선택

  public Person() {

  }

  public void setId(long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public static void main(String[] args) {
    Person person = new Person();
    person.setId(1);
    person.setName("PERSON");
    person.setAddress("BUSAN");
    person.setAge(20);
    person.setJob("STUDENT");
    person.setWeight(100);
  }
  */

  // 빌더 패턴
  private final long id;        // 필수
  private final String name;    // 필수
  private final int age;        // 필수
  private final String job;     // 선택
  private final String address; // 선택
  private final int weight;     // 선택

  public static class Builder {

    private final long id;        // 필수
    private final String name;    // 필수
    private final int age;        // 필수

    private String job = "STUDENT";   // 선택
    private String address = "KOREA"; // 선택
    private int weight = 0;           // 선택

    public Builder(long id, String name, int age) {
      this.id = id;
      this.name = name;
      this.age = age;
    }

    public Builder job(String job) {
      this.job = job;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder weight(int weight) {
      this.weight = weight;
      return this;
    }

    public Person build() {
      return new Person(this);
    }
  }

  public Person(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.age = builder.age;
    this.job = builder.job;
    this.address = builder.address;
    this.weight = builder.weight;
  }

  public static void main(String[] args) {
    Person person = new Builder(1, "SON", 20)
        .address("BUSAN")
        .weight(30)
        .build();

    System.out.println(person.job);
  }
}
