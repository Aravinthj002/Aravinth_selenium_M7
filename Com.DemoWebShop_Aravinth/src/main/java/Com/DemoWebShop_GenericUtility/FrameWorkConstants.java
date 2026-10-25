package Com.DemoWebShop_GenericUtility;

public interface FrameWorkConstants {

	JavaUtility javaUtility = new JavaUtility();

	String propertyFilePath = "./src/test/resources/TestData/commonData.properties/";

	String excelFilePath = "./src/test/resources/TestData/testScriptDatas.xlsx";

	String screenshotsPath = "./screenshots/" + javaUtility.localDateAndTime() + ".png";

	String reportsPath = "./reports/" + javaUtility.localDateAndTime() + ".html";

}
