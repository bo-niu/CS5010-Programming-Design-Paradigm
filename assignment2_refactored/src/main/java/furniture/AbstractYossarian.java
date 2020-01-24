package furniture;

/**
 * Yossarian Cabinet furniture class.
 */
public abstract class AbstractYossarian extends AbstractCabinet {

  /**
   * Constructor of the Yossarian class.
   *
   * @param furnitureColor furniture's color
   * @param mountedType    mounted type
   * @param shelfNum       shelf number
   * @param drawerNum      drawer number
   */
  public AbstractYossarian(final FurnitureColor furnitureColor,
      final MountedType mountedType, final int shelfNum, final int drawerNum) {
    super(furnitureColor, mountedType, shelfNum, drawerNum);
  }

  /**
   * Transform the object to a string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "Yossarian{}"
        + super.toString();
  }
}
