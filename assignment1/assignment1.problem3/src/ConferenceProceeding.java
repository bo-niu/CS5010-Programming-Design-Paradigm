/**
 * Represent a conference proceeding with title, authors, publishing year, citation number,
 * conference location and conference name.
 *
 * @author Bo Niu
 */
public class ConferenceProceeding extends Article {

  private String conferenceName;
  private String conferenceLocation;

  /**
   * Create a new conference proceeding given its title, authors, publishing year and citation
   * number, conference location and conference name.
   *
   * @param title              the conference proceeding's title
   * @param authors            the conference proceeding's authors
   * @param publishingYear     the conference proceeding's publishing year
   * @param citationNum        the conference proceeding's citation number
   * @param conferenceName     the conference proceeding's conference name
   * @param conferenceLocation the conference proceeding's conference location
   * @throws IllegalArgumentException if publishing year is after the current year, or citation
   *                                  number is less than 0, or title is empty.
   */
  public ConferenceProceeding(String title, String[] authors, Integer publishingYear,
      Integer citationNum, String conferenceName, String conferenceLocation)
      throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum);

    this.conferenceLocation = conferenceLocation;
    this.conferenceName = conferenceName;
  }


  /**
   * Calculate scale factor for conference proceeding. the scale factor of a conference proceeding
   * is always 1.
   *
   * @return 1
   */
  protected int calculateScaleFactor() {
    return 1;
  }

  /**
   * Get conference name of the conference proceeding.
   *
   * @return conference name
   */
  public String getConferenceName() {
    return this.conferenceName;
  }

  /**
   * Get conference location of the conference proceeding.
   *
   * @return conference location
   */
  public String getConferenceLocation() {
    return this.conferenceLocation;
  }
}
