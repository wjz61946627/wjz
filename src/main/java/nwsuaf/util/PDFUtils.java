package nwsuaf.util;

import com.aspose.cells.License;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PDFUtils {

	private static boolean LOAD_EXCEL = false;
	private static boolean LOAD_WORLD = false;

	/**
	 * @return 获取aspose证书，不然转出来的pdf有水印
	 */
	private static String getLicensStr() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<License>");

		stringBuilder.append("<Data>");

		stringBuilder.append("<Products>");
		stringBuilder.append("<Product>Aspose.Total for Java</Product>");
		stringBuilder.append("</Products>");

		stringBuilder.append("<EditionType>Enterprise</EditionType>");
		stringBuilder.append("<SubscriptionExpiry>20991231</SubscriptionExpiry>");
		stringBuilder.append("<LicenseExpiry>20991231</LicenseExpiry>");
		stringBuilder.append("<SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber>");

		stringBuilder.append("</Data>");

		stringBuilder.append("<Signature>");
		stringBuilder.append("s");
		stringBuilder.append("</Signature>");

		stringBuilder.append("</License>");
		return stringBuilder.toString();
	}

	private static boolean getExcelLicense() {
		if (LOAD_EXCEL) {
			return true;
		}

		ByteArrayInputStream license = new ByteArrayInputStream(getLicensStr().getBytes());
		try {
			new License().setLicense(license);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOAD_EXCEL = true;
		return true;
	}

	private static boolean getWorldLicense() {
		if (LOAD_WORLD) {
			return true;
		}

		ByteArrayInputStream license = new ByteArrayInputStream(getLicensStr().getBytes());
		try {
			new com.aspose.words.License().setLicense(license);
		} catch (Exception e) {
			e.printStackTrace();
		}

		LOAD_WORLD = true;
		return true;
	}

	private static boolean checkConvertFile(String srcPath, String targetPath) {
		File srcFile = new File(srcPath);
		File targetFile = new File(targetPath);

		if (!srcFile.exists() || !srcFile.canRead()) {
			return false;
		}

		if (targetFile.exists()) {
			return false;
		}

		try {
			if (!targetFile.createNewFile()) {
				return false;
			}
		} catch (IOException e1) {
			return false;
		}

		if (!targetFile.canWrite()) {
			return false;
		}

		return true;
	}

	public static boolean doc2pdf(String srcPath, String targetPath) {
		getWorldLicense();

		if (!checkConvertFile(srcPath, targetPath)) {
			return false;
		}

		try (FileOutputStream os = new FileOutputStream(new File(targetPath))) {
			Document doc = new Document(srcPath);
			doc.save(os, com.aspose.words.SaveFormat.PDF);
			os.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean excel2pdf(String srcPath, String targetPath) {
		getExcelLicense();

		if (!checkConvertFile(srcPath, targetPath)) {
			return false;
		}

		try (FileOutputStream os = new FileOutputStream(new File(targetPath))) {

			Workbook wb = new Workbook(srcPath);

			PdfSaveOptions pdfSaveOptions = new PdfSaveOptions();
			// 一个sheet一个pdf页
			pdfSaveOptions.setOnePagePerSheet(true);
			wb.save(os, pdfSaveOptions);
			os.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
