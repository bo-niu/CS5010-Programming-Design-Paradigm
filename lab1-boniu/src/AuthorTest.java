import org.junit.Assert;

/**
 * Represents the test class for the class Author.
 */
public class AuthorTest {

  /**
   * jane is the object we use to test the Author class.
   */
  private Author jane;

  /**
   * In this method, we initialize jane with name, email and address.
   *
   * @throws Exception if an exception occurs.
   */
  @org.junit.Before
  public void setUp() throws Exception {

    this.jane = new Author("Jane Doe", "j@a.com", "222 Main St, Seattle, WA, 98980");
  }

  /**
   * Test if getName method returns the same name as what we initialized.
   *
   * @throws Exception if an exception occurs.
   */
  @org.junit.Test
  public void getName() throws Exception {

    Assert.assertEquals("Jane Doe", this.jane.getName());
  }

  /**
   * Test if getEmail method returns the same email as what we initialized.
   *
   * @throws Exception if an exception occurs.
   */
  @org.junit.Test
  public void getEmail() throws Exception {

    Assert.assertEquals("j@a.com", this.jane.getEmail());
  }

  /**
   * Test if getAddress method returns the same address as what we initialized.
   *
   * @throws Exception if an exception occurs.
   */
  @org.junit.Test
  public void getAddress() throws Exception {

    Assert.assertEquals("222 Main St, Seattle, WA, 98980", this.jane.getAddress());
  }

}