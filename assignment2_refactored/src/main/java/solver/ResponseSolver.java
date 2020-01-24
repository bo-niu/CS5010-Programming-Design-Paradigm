package solver;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import furniture.*;

/**
 * solver.ResponseSolver class, used to parse the json file, calculate the recommended furniture and
 * write a json file including the results.
 */
//@SuppressWarnings("ALL")
public class ResponseSolver {

  private ArrayList<AbstractCabinet> cabinetArrayList;
  private ArrayList<AbstractDoor> doorArrayList;
  private ArrayList<AbstractDrawerFront> drawerFrontArrayList;

  private JsonInput_Cabinet jsonInput_cabinet;
  private JsonInput_Door jsonInput_door;
  private JsonInput_DrawerFront jsonInput_drawerFront;


  private ArrayList<ArrayList<AbstractCabinet>> cabinetResult;
  private ArrayList<ArrayList<AbstractDoor>> doorResult;
  private ArrayList<ArrayList<AbstractDrawerFront>> drawerFrontResult;

  /**
   * Constructor.
   */
  public ResponseSolver() {
    cabinetArrayList = new ArrayList<AbstractCabinet>();
    doorArrayList = new ArrayList<AbstractDoor>();
    drawerFrontArrayList = new ArrayList<AbstractDrawerFront>();

    jsonInput_cabinet = new JsonInput_Cabinet();
    jsonInput_door = new JsonInput_Door();
    jsonInput_drawerFront = new JsonInput_DrawerFront();

    cabinetResult = new ArrayList<ArrayList<AbstractCabinet>>();
    doorResult = new ArrayList<ArrayList<AbstractDoor>>();
    drawerFrontResult = new ArrayList<ArrayList<AbstractDrawerFront>>();
    initialize();
  }

  /**
   * Initilize all parameters.
   */
  private void initialize() {
    addAllYossarian();
    addAllLuthien();
    addAllAtreides();

    addAllSlothrop();
    addAllBelacqua();
    addAllGaga();

    addAllDrawFront();

    System.out.println("cabinetArrayList.size() == " + cabinetArrayList.size());
    System.out.println("doorArrayList.size() == " + doorArrayList.size());
    System.out.println("drawerFrontArrayList.size() == " + drawerFrontArrayList.size());
  }

  /**
   * Reset json input.
   */
  private void resetAllJsonInput() {
    jsonInput_cabinet = new JsonInput_Cabinet();
    jsonInput_door = new JsonInput_Door();
    jsonInput_drawerFront = new JsonInput_DrawerFront();
  }

  /**
   * Reset all ArrayList output.
   */
  private void resetAllArrayListOutput() {
    cabinetResult = new ArrayList<ArrayList<AbstractCabinet>>();
    doorResult = new ArrayList<ArrayList<AbstractDoor>>();
    drawerFrontResult = new ArrayList<ArrayList<AbstractDrawerFront>>();
  }

  /**
   * Run the whole process including parsing json file, calculate recommended furniture.
   *
   * @param jsonPath json file path
   */
  public void run(final String jsonPath) {

    parseJsonRequest(jsonPath);
    resetAllArrayListOutput();

    if (jsonInput_cabinet.isWorkFlag()) {
      final ArrayList<AbstractCabinet> tmp = new ArrayList<AbstractCabinet>();
      if (jsonInput_cabinet.getMountedType() == MountedType.FLOOR) {
        getFloorCabinetResult(cabinetResult, tmp, jsonInput_cabinet.getWidth(),
            jsonInput_cabinet.getShelfNum(), jsonInput_cabinet.getDrawerNum(),
            jsonInput_cabinet.getBudget(), 0);
      } else {
        getWallCabinetResult(cabinetResult);
      }
    }

    if (jsonInput_door.isWorkFlag()) {
      final ArrayList<AbstractDoor> tmp = new ArrayList<AbstractDoor>();
      getDoorResult(doorResult, tmp, jsonInput_door.getWidth(), jsonInput_door.getBudget(), 0);
    }

    if (jsonInput_drawerFront.isWorkFlag()) {
      getDrawerFrontResult(drawerFrontResult);
    }

    System.out.println("final cabinetResult.size() == " + cabinetResult.size());
    System.out.println("final doorResult.size() == " + doorResult.size());
    System.out.println("final drawerFrontResult.size() == " + drawerFrontResult.size());


  }

  /**
   * Parse json file.
   *
   * @param jsonPath json file path
   */
  private void parseJsonRequest(final String jsonPath) {

    resetAllJsonInput();
    final JSONParser jsonParser = new JSONParser();
    try (FileReader reader = new FileReader(jsonPath)) {
      //Read JSON file
      final Object obj = jsonParser.parse(reader);

      final JSONArray furnitureList = (JSONArray) obj;
//      System.out.println(furnitureList);

      for (final Object jObj : furnitureList) {

        final JSONObject jj = (JSONObject) jObj;

        if (jj.containsKey("cabinet")) {
          parseCabinetObject(jj);
        } else if (jj.containsKey("door")) {
          parseDoorObject(jj);
        } else if (jj.containsKey("drawerFront")) {
          parseDrawerFrontObject(jj);
        }

      }
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
  }

  /**
   * Extract cabinet information from json file.
   *
   * @param obj input json object
   */
  private void parseCabinetObject(final JSONObject obj) {

    jsonInput_cabinet.setWorkFlag(true);
    String str;
    final JSONObject cabinetObject = (JSONObject) obj.get("cabinet");
//    String str = (String) cabinetObject.get("height");
    jsonInput_cabinet.setHeight(((Number) cabinetObject.get("height")).intValue());
    jsonInput_cabinet.setWidth(((Number) cabinetObject.get("width")).intValue());
    jsonInput_cabinet.setDepth(((Number) cabinetObject.get("depth")).intValue());
    jsonInput_cabinet.setBudget(((Number) cabinetObject.get("budget")).intValue());
    jsonInput_cabinet.setShelfNum(((Number) cabinetObject.get("shelfNum")).intValue());
    jsonInput_cabinet.setDrawerNum(((Number) cabinetObject.get("drawerNum")).intValue());
    str = (String) cabinetObject.get("color");
    jsonInput_cabinet.setFurnitureColor(FurnitureColor.valueOf(str));
    str = (String) cabinetObject.get("mounted");
    jsonInput_cabinet.setMountedType(MountedType.valueOf(str));
  }

  /**
   * Extract door information from json file.
   *
   * @param obj input json object
   */
  private void parseDoorObject(final JSONObject obj) {

    jsonInput_door.setWorkFlag(true);
    String str;
    final JSONObject cabinetObject = (JSONObject) obj.get("door");
    jsonInput_door.setHeight(((Number) cabinetObject.get("height")).intValue());
    jsonInput_door.setWidth(((Number) cabinetObject.get("width")).intValue());
    jsonInput_door.setBudget(((Number) cabinetObject.get("budget")).intValue());
    str = (String) cabinetObject.get("color");
    jsonInput_door.setFurnitureColor(FurnitureColor.valueOf(str));
  }

  /**
   * Extract drawer front information from json file.
   *
   * @param obj input json object
   */
  private void parseDrawerFrontObject(final JSONObject obj) {

    jsonInput_drawerFront.setWorkFlag(true);
    String str;
    final JSONObject cabinetObject = (JSONObject) obj.get("drawerFront");
    jsonInput_drawerFront.setHeight(((Number) cabinetObject.get("height")).intValue());
    jsonInput_drawerFront.setDepth(((Number) cabinetObject.get("depth")).intValue());
    jsonInput_drawerFront.setWidth(((Number) cabinetObject.get("width")).intValue());
    jsonInput_drawerFront.setBudget(((Number) cabinetObject.get("budget")).intValue());
    str = (String) cabinetObject.get("color");
    jsonInput_drawerFront.setFurnitureColor(FurnitureColor.valueOf(str));
  }

  /**
   * Create a json file with the result in it.
   *
   * @param jsonPath output json file path
   */
  @SuppressWarnings("unchecked")
  public void createJson(final String jsonPath) {

    final JSONArray jsonList = new JSONArray();
    for (int i = 0; i < cabinetResult.size(); i++) {

      String groupStr;
      if (drawerFrontResult.size() > 0) {
        groupStr = "cabinetAndDrawerGroup" + (i + 1);
      } else {
        groupStr = "cabinetGroup" + (i + 1);
      }
      for (int j = 0; j < cabinetResult.get(i).size(); j++) {
        final JSONObject candidateDetails = new JSONObject();
        candidateDetails.put("name", cabinetResult.get(i).get(j).getJsonInfo());
        candidateDetails.put("width", cabinetResult.get(i).get(j).getWidth());
        candidateDetails.put("height", cabinetResult.get(i).get(j).getHeight());
        candidateDetails.put("depth", cabinetResult.get(i).get(j).getDepth());
        candidateDetails.put("price", cabinetResult.get(i).get(j).getPrice());
        candidateDetails.put("color", cabinetResult.get(i).get(j).getFurnitureColor().toString());
        candidateDetails.put("drawerNum", cabinetResult.get(i).get(j).getDrawerNum());
        candidateDetails.put("shelfNum", cabinetResult.get(i).get(j).getShelfNum());
        candidateDetails.put("comments", cabinetResult.get(i).get(j).getCommentInfo());
        final JSONObject candidateObject = new JSONObject();
        candidateObject.put(groupStr, candidateDetails);
        jsonList.add(candidateObject);
      }
      if (drawerFrontResult.size() > 0) {
        for (int j = 0; j < drawerFrontResult.get(i).size(); j++) {
          final JSONObject candidateDetails = new JSONObject();
          candidateDetails.put("name", drawerFrontResult.get(i).get(j).getJsonInfo());
          candidateDetails.put("width", drawerFrontResult.get(i).get(j).getWidth());
          candidateDetails.put("height", drawerFrontResult.get(i).get(j).getHeight());
          candidateDetails.put("depth", drawerFrontResult.get(i).get(j).getDepth());
          candidateDetails.put("price", drawerFrontResult.get(i).get(j).getPrice());
          candidateDetails
              .put("color", drawerFrontResult.get(i).get(j).getFurnitureColor().toString());
          candidateDetails.put("comments", drawerFrontResult.get(i).get(j).getCommentInfo());
          final JSONObject candidateObject = new JSONObject();
          candidateObject.put(groupStr, candidateDetails);
          jsonList.add(candidateObject);
        }
      }
    }

    for (int i = 0; i < doorResult.size(); i++) {
      final String groupStr = "doorGroup" + (i + 1);
      for (int j = 0; j < doorResult.get(i).size(); j++) {
        final JSONObject candidateDetails = new JSONObject();
        candidateDetails.put("name", doorResult.get(i).get(j).getJsonInfo());
        candidateDetails.put("width", doorResult.get(i).get(j).getWidth());
        candidateDetails.put("height", doorResult.get(i).get(j).getHeight());
        candidateDetails.put("price", doorResult.get(i).get(j).getPrice());
        candidateDetails.put("color", doorResult.get(i).get(j).getFurnitureColor().toString());
        candidateDetails.put("comments", doorResult.get(i).get(j).getCommentInfo());
        final JSONObject candidateObject = new JSONObject();
        candidateObject.put(groupStr, candidateDetails);
        jsonList.add(candidateObject);
      }
    }

    try (FileWriter file = new FileWriter(jsonPath)) {

      file.write(jsonList.toJSONString());
      file.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }

  }


  /**
   * add all Yossarian elements.
   */
  private void addAllYossarian() {

    YossarianWardrobeSize yossarianWardrobeSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      final int[] shelfNumArray = {0, 1, 2, 3, 4, 5, 6, 7};
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          yossarianWardrobeSize = new YossarianWardrobeSize(furnitureColor, mountedType, shelfNum,
              0);
          if (yossarianWardrobeSize.isValid()) {
            cabinetArrayList.add(yossarianWardrobeSize);
          }
        }
      }
    }
    YossarianHalfSize yossarianHalfSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      final int[] shelfNumArray = {0, 1, 2, 3};
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          yossarianHalfSize = new YossarianHalfSize(furnitureColor, mountedType, shelfNum, 0);
          if (yossarianHalfSize.isValid()) {
            cabinetArrayList.add(yossarianHalfSize);
          }
        }
      }
    }
    YossarianQuarterSize yossarianQuarterSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      final int[] shelfNumArray = {0, 1, 2, 3, 4, 5, 6, 7};
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          yossarianQuarterSize = new YossarianQuarterSize(furnitureColor, mountedType, shelfNum, 0);
          if (yossarianQuarterSize.isValid()) {
            cabinetArrayList.add(yossarianQuarterSize);
          }
        }
      }
    }
  }

  /**
   * add all Luthien elements.
   */
  private void addAllLuthien() {

    final int[] shelfNumArray = {0, 1, 2, 3, 4, 5, 6, 7};
    final int[] drawerNumArray = {0, 1, 2, 3};
    LuthienHalfSize luthienHalfSize;

    String sst;
    for (final MountedType mountedType : MountedType.values()) {
      sst = mountedType.toString();
      System.out.println(sst);
    }

    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          for (final int drawerNum : drawerNumArray) {
            luthienHalfSize = new LuthienHalfSize(furnitureColor, mountedType, shelfNum, drawerNum);
            if (luthienHalfSize.isValid()) {
              cabinetArrayList.add(luthienHalfSize);
            }
          }
        }
      }
    }
    LuthienQuarterSize luthienQuarterSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          for (final int drawerNum : drawerNumArray) {
            luthienQuarterSize = new LuthienQuarterSize(furnitureColor, mountedType, shelfNum,
                drawerNum);
            if (luthienQuarterSize.isValid()) {
              cabinetArrayList.add(luthienQuarterSize);
            }
          }
        }
      }
    }
  }

  /**
   * add all Atreides elements.
   */
  private void addAllAtreides() {

    final int[] shelfNumArray = {0, 1, 2, 3, 4, 5, 6, 7};
    final int[] drawerNumArray = {0, 1, 2, 3};
    AtreidesHalfSize atreidesHalfSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          for (final int drawerNum : drawerNumArray) {
            atreidesHalfSize = new AtreidesHalfSize(furnitureColor, mountedType, shelfNum,
                drawerNum);
            if (atreidesHalfSize.isValid()) {
              cabinetArrayList.add(atreidesHalfSize);
            }
          }
        }
      }
    }
    AtreidesQuarterSize atreidesQuarterSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      for (final MountedType mountedType : MountedType.values()) {
        for (final int shelfNum : shelfNumArray) {
          for (final int drawerNum : drawerNumArray) {
            atreidesQuarterSize = new AtreidesQuarterSize(furnitureColor, mountedType, shelfNum,
                drawerNum);
            if (atreidesQuarterSize.isValid()) {
              cabinetArrayList.add(atreidesQuarterSize);
            }
          }
        }
      }
    }
  }

  /**
   * add all Slothrop elements.
   */
  private void addAllSlothrop() {

    SlothropHalfSize slothropHalfSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      slothropHalfSize = new SlothropHalfSize(furnitureColor);
      if (slothropHalfSize.isValid()) {
        doorArrayList.add(slothropHalfSize);
      }
    }
    SlothropWardrobeSize slothropWardrobeSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      slothropWardrobeSize = new SlothropWardrobeSize(furnitureColor);
      if (slothropWardrobeSize.isValid()) {
        doorArrayList.add(slothropWardrobeSize);
      }
    }
  }

  /**
   * add all Belacqua elements.
   */
  private void addAllBelacqua() {

    BelacquaHalfSize belacquaHalfSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      belacquaHalfSize = new BelacquaHalfSize(furnitureColor);
      if (belacquaHalfSize.isValid()) {
        doorArrayList.add(belacquaHalfSize);
      }
    }
    BelacquaQuarterSize belacquaQuarterSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      belacquaQuarterSize = new BelacquaQuarterSize(furnitureColor);
      if (belacquaQuarterSize.isValid()) {
        doorArrayList.add(belacquaQuarterSize);
      }
    }
    BelacquaWardrobeSize belacquaWardrobeSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      belacquaWardrobeSize = new BelacquaWardrobeSize(furnitureColor);
      if (belacquaWardrobeSize.isValid()) {
        doorArrayList.add(belacquaWardrobeSize);
      }
    }
  }

  /**
   * add all Gaga elements.
   */
  private void addAllGaga() {

    GagaHalfSize gagaHalfSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      gagaHalfSize = new GagaHalfSize(furnitureColor);
      if (gagaHalfSize.isValid()) {
        doorArrayList.add(gagaHalfSize);
      }
    }
    GagaQuarterSize gagaQuarterSize;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      gagaQuarterSize = new GagaQuarterSize(furnitureColor);
      if (gagaQuarterSize.isValid()) {
        doorArrayList.add(gagaQuarterSize);
      }
    }
  }

  /**
   * add all DrawFront elements.
   */
  private void addAllDrawFront() {

    GagaQuarterSizeDrawFront gagaQuarterSizeDrawFront;
    for (final FurnitureColor furnitureColor : FurnitureColor.values()) {
      gagaQuarterSizeDrawFront = new GagaQuarterSizeDrawFront(furnitureColor);
      if (gagaQuarterSizeDrawFront.isValid()) {
        drawerFrontArrayList.add(gagaQuarterSizeDrawFront);
      }
    }

  }

  /**
   * Get all cabinets that meet the requirement of the customer.
   *
   * @param cabinetResult    cabinet result
   * @param tmp              temp ArrayList
   * @param curWidthLeft     current width left
   * @param curShelfNumLeft  current shelf left
   * @param curDrawerNumLeft current drawer number left
   * @param curBudgetLeft    current budget left
   * @param cur              current index
   */
  @SuppressWarnings("unchecked")
  private void getFloorCabinetResult(final ArrayList<ArrayList<AbstractCabinet>> cabinetResult,
      final ArrayList<AbstractCabinet> tmp, final int curWidthLeft, final int curShelfNumLeft,
      final int curDrawerNumLeft,
      final int curBudgetLeft, final int cur) {

    if (curWidthLeft < 0) {
      return;
    }
    if (curWidthLeft == 0 && curShelfNumLeft == 0 && curDrawerNumLeft == 0) {
      cabinetResult.add((ArrayList<AbstractCabinet>) tmp.clone());
      return;
    }
    if (curShelfNumLeft < 0 || curDrawerNumLeft < 0) {
      return;
    }

    for (int i = cur; i < cabinetArrayList.size(); i++) {

      if ((cabinetArrayList.get(i).getHeight() == jsonInput_cabinet.getHeight()) &&
          (cabinetArrayList.get(i).getWidth() <= curWidthLeft) &&
          (cabinetArrayList.get(i).getShelfNum() <= curShelfNumLeft) &&
          (cabinetArrayList.get(i).getDrawerNum() <= curDrawerNumLeft) &&
          (cabinetArrayList.get(i).getFurnitureColor() == jsonInput_cabinet.getFurnitureColor()) &&
          (cabinetArrayList.get(i).getDepth() == jsonInput_cabinet.getDepth()) &&
          (cabinetArrayList.get(i).getMountedType() == jsonInput_cabinet.getMountedType()) &&
          (cabinetArrayList.get(i).getPrice() <= curBudgetLeft)) {

        tmp.add(cabinetArrayList.get(i));
        getFloorCabinetResult(cabinetResult, tmp, curWidthLeft - cabinetArrayList.get(i).getWidth(),
            curShelfNumLeft - cabinetArrayList.get(i).getShelfNum(),
            curDrawerNumLeft - cabinetArrayList.get(i).getDrawerNum(),
            curBudgetLeft - cabinetArrayList.get(i).getPrice(), i);
        tmp.remove(tmp.size() - 1);
      }

    }

  }

  /**
   * Get cabinet result which are all wall mounted.
   *
   * @param cabinetResult cabinet result
   */
  private void getWallCabinetResult(final ArrayList<ArrayList<AbstractCabinet>> cabinetResult) {

    for (int i = 0; i < cabinetArrayList.size(); i++) {

      if (cabinetArrayList.get(i).getHeight() == jsonInput_cabinet.getHeight() &&
          cabinetArrayList.get(i).getWidth() == jsonInput_cabinet.getWidth() &&
          cabinetArrayList.get(i).getFurnitureColor() == jsonInput_cabinet.getFurnitureColor() &&
          cabinetArrayList.get(i).getMountedType() == jsonInput_cabinet.getMountedType() &&
          cabinetArrayList.get(i).getDepth() == jsonInput_cabinet.getDepth() &&
          cabinetArrayList.get(i).getPrice() <= jsonInput_cabinet.getBudget()) {
        final ArrayList<AbstractCabinet> tmp = new ArrayList<AbstractCabinet>();
        tmp.add(cabinetArrayList.get(i));
        cabinetResult.add(tmp);
      }
    }

  }

  /**
   * Get door result.
   *
   * @param doorResult    door result
   * @param tmp           temp ArrayList
   * @param curWidthLeft  current width left
   * @param curBudgetLeft current budge left
   * @param cur           current index
   */
  @SuppressWarnings("unchecked")
  private void getDoorResult(final ArrayList<ArrayList<AbstractDoor>> doorResult,
      final ArrayList<AbstractDoor> tmp,
      final int curWidthLeft, final int curBudgetLeft, final int cur) {

    if (curWidthLeft < 0) {
      return;
    }
    if (curWidthLeft == 0) {
      doorResult.add((ArrayList<AbstractDoor>) tmp.clone());
      return;
    }

    for (int i = cur; i < doorArrayList.size(); i++) {

      if (doorArrayList.get(i).getHeight() == jsonInput_door.getHeight()
          && cabinetArrayList.get(i).getWidth() <= curWidthLeft &&
          doorArrayList.get(i).getFurnitureColor() == jsonInput_door.getFurnitureColor() &&
          doorArrayList.get(i).getPrice() <= curBudgetLeft) {
        tmp.add(doorArrayList.get(i));
        getDoorResult(doorResult, tmp, curWidthLeft - doorArrayList.get(i).getWidth(),
            curBudgetLeft - doorArrayList.get(i).getPrice(), i);
        tmp.remove(tmp.size() - 1);
      }

    }

  }

  /**
   * Get drawer front result.
   *
   * @param drawerFrontResult drawer front result
   */
  private void getDrawerFrontResult(
      final ArrayList<ArrayList<AbstractDrawerFront>> drawerFrontResult) {

    if (cabinetResult.size() == 0) {
      return;
    }

    final ArrayList<ArrayList<AbstractCabinet>> newCabinet = new ArrayList<ArrayList<AbstractCabinet>>();
    for (int i = 0; i < cabinetResult.size(); i++) {
      final ArrayList<AbstractDrawerFront> tmp = new ArrayList<AbstractDrawerFront>();
      int num = jsonInput_cabinet.getDrawerNum();
      if (num == 0) {
        return;
      }
      for (int j = 0; j < cabinetResult.get(i).size(); j++) {

        for (int k = 0; k < drawerFrontArrayList.size(); k++) {

          if (drawerFrontArrayList.get(k).getWidth() == cabinetResult.get(i).get(j).getWidth() &&
              drawerFrontArrayList.get(k).getFurnitureColor() == jsonInput_drawerFront
                  .getFurnitureColor() &&
              drawerFrontArrayList.get(k).getDepth() == jsonInput_drawerFront.getDepth() &&
              drawerFrontArrayList.get(k).getDepth() == cabinetResult.get(i).get(j).getDepth() &&
              drawerFrontArrayList.get(k).getPrice() <= jsonInput_drawerFront.getBudget()) {
            num--;
            tmp.add(drawerFrontArrayList.get(k));
            break;
          }
        }
        if (num == 0) {
          newCabinet.add(cabinetResult.get(i));
          drawerFrontResult.add(tmp);
          break;
        }
      }
    }

    cabinetResult = newCabinet;


  }

  /**
   * to string.
   *
   * @return string
   */
  @Override
  public String toString() {
    return "solver.ResponseSolver{" +
        "cabinetArrayList=" + cabinetArrayList +
        ", doorArrayList=" + doorArrayList +
        ", drawerFrontArrayList=" + drawerFrontArrayList +
        ", jsonInput_cabinet=" + jsonInput_cabinet +
        ", jsonInput_door=" + jsonInput_door +
        ", jsonInput_drawerFront=" + jsonInput_drawerFront +
        ", cabinetResult=" + cabinetResult +
        ", doorResult=" + doorResult +
        ", drawerFrontResult=" + drawerFrontResult +
        '}';
  }

  /**
   * Compare two solver.ResponseSolver object.
   *
   * @param object solver.ResponseSolver object
   * @return true if two object are the same.
   */
  @Override
  public boolean equals(final Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    final ResponseSolver solver = (ResponseSolver) object;
    return cabinetArrayList.equals(solver.cabinetArrayList) &&
        doorArrayList.equals(solver.doorArrayList) &&
        drawerFrontArrayList.equals(solver.drawerFrontArrayList) &&
        jsonInput_cabinet.equals(solver.jsonInput_cabinet) &&
        jsonInput_door.equals(solver.jsonInput_door) &&
        jsonInput_drawerFront.equals(solver.jsonInput_drawerFront) &&
        cabinetResult.equals(solver.cabinetResult) &&
        doorResult.equals(solver.doorResult) &&
        drawerFrontResult.equals(solver.drawerFrontResult);
  }

  /**
   * Get hash code of the object.
   *
   * @return hash code
   */
  @Override
  public int hashCode() {
    return Objects.hash(cabinetArrayList, doorArrayList, drawerFrontArrayList, jsonInput_cabinet,
        jsonInput_door, jsonInput_drawerFront, cabinetResult, doorResult, drawerFrontResult);
  }


}
