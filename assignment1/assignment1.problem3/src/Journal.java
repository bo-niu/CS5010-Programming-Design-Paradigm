/**
 * Represent a journal with title, authors, publishing year, citation number, publisher and
 * editors.
 *
 * @author Bo Niu
 */
public class Journal extends Article {

  protected String publisher;
  protected String[] editor;

  /**
   * Create a new journal given its title, authors, publishing year and citation number, publisher
   * and editors.
   *
   * @param title          the journal's title
   * @param authors        the journal's authors
   * @param publishingYear the journal's publishing year
   * @param citationNum    the journal's citation number
   * @param publisher      the journal's publisher
   * @param editor         the journal's editors
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty.
   */
  public Journal(String title, String[] authors, Integer publishingYear,
      Integer citationNum, String publisher, String[] editor)
      throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum);
    this.publisher = publisher;
    this.editor = editor;

  }

  /**
   * Calculate scale factor for journal. the scale factor of a journal is always 2.
   *
   * @return 2
   */
  protected int calculateScaleFactor() {
    return 2;
  }

  /**
   * Get publisher of the journal.
   *
   * @return publisher
   */
  public String getPublisher() {
    return this.publisher;
  }

  /**
   * Get editors of the journal.
   *
   * @return editors
   */
  public String[] getEditor() {
    return this.editor.clone();
  }
}
