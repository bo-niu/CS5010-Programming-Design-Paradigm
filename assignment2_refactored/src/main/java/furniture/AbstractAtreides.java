package furniture;

/**
 * Atreides cabinet class.
 */
public abstract class AbstractAtreides extends AbstractCabinet {

  /**
   * Constructor of the Atreides class.
   *
   * @param furnitureColor furniture's color
   * @param mountedType    mounted type
   * @param shelfNum       shelf number
   * @param drawerNum      drawer number
   */
  public AbstractAtreides(final FurnitureColor furnitureColor,
      final MountedType mountedType, final int shelfNum, final int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
  }

  /**
   * Make object to String.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Atreides{}"
        + super.toString();
  }
}