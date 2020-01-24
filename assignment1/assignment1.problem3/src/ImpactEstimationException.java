public class ImpactEstimationException extends Exception {

  private int age;

  public ImpactEstimationException(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }
}
