package item03;

public class StaticFactorySingleton {

  private static final StaticFactorySingleton INSTANCE = new StaticFactorySingleton();

  private StaticFactorySingleton() {
  }

  public static StaticFactorySingleton getInstance() {
    return INSTANCE;
  }

  /**
   * readResolve 메서드 - 진짜 객체만 반환하고, 가짜 객체는 버린다. 역직렬화 시 발생하는 가짜 객체를 제거하는 기능을 한다.
   */
  private Object readResolve() {
    return INSTANCE;
  }
}
