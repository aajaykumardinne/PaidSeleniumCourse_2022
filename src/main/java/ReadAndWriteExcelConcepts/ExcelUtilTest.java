package ReadAndWriteExcelConcepts;

public class ExcelUtilTest {

	public static void main(String[] args) {

		String sheetName = "Login";

		Xls_Reader reader = new Xls_Reader(
				"C:\\Users\\dinne\\eclipse-workspace\\PaidSeleniumCourse_2022\\src\\main\\java\\ReadAndWriteExcelConcepts\\ExcelData.xlsx");
		String data = reader.getCellData(sheetName, "username", 2);
		System.out.println(data);

		System.out.println(reader.getCellData(sheetName, 1, 3));

		int rowCount = reader.getRowCount(sheetName);
		System.out.println("total rows : " + rowCount);

		// reader.addColumn(sheetName, "Status");
		// reader.removeColumn(sheetName, 3);

		if (!reader.isSheetExist("Registration")) {
			reader.addSheet("Registration");
		}

		reader.setCellData(sheetName, "Status", 2, "Pass");
		reader.setCellData(sheetName, "Status", 3, "Fail");

		int colCount_Reg = reader.getColumnCount("Registration");
		System.out.println(colCount_Reg);

		System.out.println(reader.getCellData("Registration", "Age", 2));
	}

}
