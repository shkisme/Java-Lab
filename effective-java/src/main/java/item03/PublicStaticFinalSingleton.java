package item03;

import java.lang.reflect.Constructor;

public class PublicStaticFinalSingleton {

  public static final PublicStaticFinalSingleton INSTANCE = new PublicStaticFinalSingleton();

  private static int instanceCount = 0;

  private PublicStaticFinalSingleton() {
    if (instanceCount > 0) {
      throw new IllegalStateException("생성자는 한번만 호출될 수 있습니다.");
    }
    instanceCount++;
  }

  /**
   * 취약점 - reflection api 의 AccessibleObject.setAccessible()로 가짜 객체를 생성할 수 있다.
   */
  public static void main(String[] args) {
    try {
      Constructor<PublicStaticFinalSingleton> constructor = PublicStaticFinalSingleton.class.getDeclaredConstructor();
      constructor.setAccessible(true);
      PublicStaticFinalSingleton instance = constructor.newInstance(); // private 생성자를 호출하여 객체를 생성합니다.
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
