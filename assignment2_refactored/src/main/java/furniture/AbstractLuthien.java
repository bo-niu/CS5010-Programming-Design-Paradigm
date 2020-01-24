package furniture;

/**
 * Luthien cabinet class.
 */
public abstract class AbstractLuthien extends AbstractCabinet {

  public AbstractLuthien(final FurnitureColor furnitureColor,
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
    return "Luthien{}"
        + super.toString();
  }
}