public class EditedVolume extends Book {

  public EditedVolume(String title, String[] authors, Integer publishingYear, Integer citationNum,
      String publishingCompany, Integer numOfPages) throws IllegalArgumentException {
    super(title, authors, publishingYear, citationNum, publishingCompany, numOfPages);
  }
}
