/**
 * Represent an Article with title, authors, publishing year, citation number. Note: this class is
 * an abstract class which cannot be instantiated.
 *
 * @author Bo Niu
 */
public abstract class Article extends Publication {

  /**
   * Create a new article given its title, authors, publishing year and citation number.
   *
   * @param title          the publication's title
   * @param authors        the publication's authors
   * @param publishingYear the publication's publishing year
   * @param citationNum    the publication's citation number
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty.
   */
  public Article(String title, String[] authors, Integer publishingYear,
      Integer citationNum) throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum);

  }
}
