import java.util.Calendar;

/**
 * Represent a publication which is the parent class of all kinds of specific publications. Note: it
 * is an abstract class.
 *
 * @author Bo Niu
 */
public abstract class Publication {

  protected String title;
  protected String[] authors;
  protected Integer publishingYear;
  protected Integer citationNum;

  /**
   * Create a new publication given the title, authors, publishing year and citation number.
   *
   * @param title          the publication's title
   * @param authors        the publication's authors
   * @param publishingYear the publication's publishing year
   * @param citationNum    the publication's citation number
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty.
   */
  public Publication(String title, String[] authors, Integer publishingYear, Integer citationNum)
      throws IllegalArgumentException {
    Calendar cal = Calendar.getInstance();
    if (publishingYear > cal.get(Calendar.YEAR) || citationNum < 0 || title.isEmpty()) {
      throw new IllegalArgumentException("Publishing year or citation number or title is illegal.");
    }

    this.title = title;
    this.authors = authors;
    this.publishingYear = publishingYear;
    this.citationNum = citationNum;
  }

  /**
   * abstract method. Calculate the scale factor used to calculate impact.
   *
   * @return scale factor
   */
  protected abstract int calculateScaleFactor();

  /**
   * abstract method. Calculate the bump factor used to calculate impact.
   *
   * @return bump factor
   */
  protected int calculateBumpFactor() {
    Calendar cal = Calendar.getInstance();
    int age = cal.get(Calendar.YEAR) - this.publishingYear;
    if (age < 3) {
      return 100;
    } else {
      return 0;
    }
  }

  /**
   * Calculate the impact of the publication.
   *
   * @return impact
   * @throws ImpactEstimationException if the age of the publication is higher than 250.
   */
  public Double estimateImpact() throws ImpactEstimationException {
    int scaleFactor = calculateScaleFactor();
    int bumpFactor = calculateBumpFactor();
    Calendar cal = Calendar.getInstance();
    int age = cal.get(Calendar.YEAR) - this.publishingYear;
    if (age == 0) {
      age = 1;
    } else if (age > 250) {
      throw new ImpactEstimationException(age);
    }
    Double baseImpact = (double) citationNum / age;
    return scaleFactor * baseImpact + bumpFactor;
  }

  /**
   * Get the publication's title.
   *
   * @return the title.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the publication's authors.
   *
   * @return the authors.
   */
  public String[] getAuthors() {
    return this.authors.clone();
  }

  /**
   * Get the publication's publishing year.
   *
   * @return the publishing year.
   */
  public Integer getPublishingYear() {
    return this.publishingYear;
  }

  /**
   * Get the publication's citation number.
   *
   * @return the citation number.
   */
  public Integer getCitationNum() {
    return this.citationNum;
  }


}
