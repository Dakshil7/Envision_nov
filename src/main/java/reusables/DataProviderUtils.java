package reusables;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DataProviderUtils {

   @DataProvider(name="jasonDataProvider")
   public static Object[][] getJasonData(Method methodName) throws IOException, ParseException {
      List<String> testColoumnsForRows;
      List<List<String>> testRows = new ArrayList<List<String>>();

      String testCaseName = methodName.getName();
      System.out.println(testCaseName);

      DataProviderArguments testArgs = methodName.getAnnotation(DataProviderArguments.class);
      String testDataArguments = testArgs.value();
      String testName = testDataArguments.split("=")[0];
      String[] testFields = testDataArguments.split("=")[1].split(",");
      System.out.println(testName);
      System.out.println(Arrays.asList(testFields));

      List<String> listOfTestFields = Arrays.asList(testFields);



      File jasonDataFile = new File(System.getProperty("user.dir")+
              "//src//test//resources//TestData//TestData-"+System.getProperty("envName").toLowerCase()+".json");
      FileReader fileReader = new FileReader(jasonDataFile);

      JSONParser jasonParser = new JSONParser();
      Object object = jasonParser.parse(fileReader);
      //System.out.println(object);
      JSONObject jsonObject = (JSONObject) object;
      System.out.println(jsonObject);

      JSONArray testCaseObject = (JSONArray) jsonObject.get(testCaseName);
      System.out.println(testCaseObject);

      for(int i=0;i<testCaseObject.size();i++){
         List<String> testColoumnsForRow = new ArrayList<>();
         JSONObject testSetObject = (JSONObject) testCaseObject.get(i);
//         System.out.println(testSetObject);

         for(int j=0;j<listOfTestFields.size();j++){
            testColoumnsForRow.add(testSetObject.get(listOfTestFields.get(j)).toString());
         }







//         Iterator itr = testSetObject.keySet().iterator();
//         while (itr.hasNext()){
//            String key = itr.next().toString();
//            String value = testSetObject.get(key).toString();
//            System.out.println(key+" = "+value);
//            if(listOfTestFields.contains(key)){
//            testColoumnsForRow.add(value);}
         //}
         testRows.add(testColoumnsForRow);

      }
      System.out.println(testRows);

      Object[][] TwoDArray = new Object[testRows.size()][testRows.get(0).size()];
      for(int i=0;i<testRows.size();i++){
         for(int j=0;j<testRows.get(i).size();j++){
            TwoDArray[i][j] = testRows.get(i).get(j);
         }
      }

      return TwoDArray;





   }

}
