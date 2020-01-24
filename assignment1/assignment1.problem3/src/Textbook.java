/**
 * Represent a textbook with title, authors, publishing year, citation number, publishing company
 * and number of pages.
 *
 * @author Bo Niu
 */
public class Textbook extends Book {

  /**
   * Create a new textbook given its title, authors, publishing year, citation number, publishing
   * company and number of pages.
   *
   * @param title             the textbook's title
   * @param authors           the textbook's authors
   * @param publishingYear    the textbook's publishing year
   * @param citationNum       the textbook's citation number
   * @param publishingCompany the textbook's publishing company
   * @param numOfPages        the textbook's number of pages
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty, or page is less than
   *                                  1.
   */
  public Textbook(String title, String[] authors, Integer publishingYear, Integer citationNum,
      String publishingCompany, Integer numOfPages) throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum, publishingCompany, numOfPages);
  }
}
