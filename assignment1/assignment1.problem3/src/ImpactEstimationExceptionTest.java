import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImpactEstimationExceptionTest {

  private ImpactEstimationException impactEstimationException;

  @Before
  public void setUp() throws Exception {
    impactEstimationException = new ImpactEstimationException(900);
  }

  @Test
  public void getAge() {
    Assert.assertEquals((int) 900, (int) this.impactEstimationException.getAge());
  }
}