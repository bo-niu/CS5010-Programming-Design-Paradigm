/**
 * Represent a book with title, authors, publishing year, citation number, publishing company and
 * number of pages.
 *
 * @author Bo Niu
 */
public class Book extends Publication {

  protected String publishingCompany;
  protected Integer numOfPages;

  /**
   * Create a new book given its title, authors, publishing year, citation number, publishing
   * company and number of pages.
   *
   * @param title             the book's title
   * @param authors           the book's authors
   * @param publishingYear    the book's publishing year
   * @param citationNum       the book's citation number
   * @param publishingCompany the book's publishing company
   * @param numOfPages        the book's number of pages
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty, or page is less than
   *                                  1.
   */
  public Book(String title, String[] authors, Integer publishingYear,
      Integer citationNum, String publishingCompany, Integer numOfPages)
      throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum);

    if (numOfPages < 1) {
      throw new IllegalArgumentException("number of page cannot be less than 1");
    }
    this.publishingCompany = publishingCompany;
    this.numOfPages = numOfPages;
  }


  /**
   * Calculate scale factor for book. the scale factor of a book is always 4.
   *
   * @return 4
   */
  @Override
  protected int calculateScaleFactor() {
    return 4;
  }

  /**
   * Get publishing company of the book.
   *
   * @return publishing company
   */
  public String getPublishingCompany() {
    return this.publishingCompany;
  }

  /**
   * Get Number of pages of the book.
   *
   * @return number of pages
   */
  public Integer getNumOfPages() {
    return this.numOfPages;
  }
}
