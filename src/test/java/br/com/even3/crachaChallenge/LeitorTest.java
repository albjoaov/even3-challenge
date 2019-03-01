package br.com.even3.crachaChallenge;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.Test;

public class LeitorTest {

	// public static void main(String[] args) throws Exception {
	//
	// try (final PDDocument doc = new PDDocument()) {
	//
	// PDPage page = new PDPage();
	// doc.addPage(page);
	//
	//// ClassLoader iAUS = getcl
	//// PDImageXObject pdImage = PDImageXObject.createFromFile(image, doc);
	// test();
	//
	// PDPageContentStream contents = new PDPageContentStream(doc, page);
	// PDRectangle mediaBox = page.getMediaBox();
	//
	// float startX = (mediaBox.getWidth() - pdImage.getWidth()) / 2;
	// float startY = (mediaBox.getHeight() - pdImage.getHeight()) / 2;
	// contents.drawImage(pdImage, startX, startY);
	//
	// contents.close();
	//
	// doc.save(new File("/tmp/image.pdf"));
	// } catch (IOException e) {
	// System.err.println("Exception while trying to create pdf document - " + e);
	// }
	// }

	@Test
	public void test() throws IOException {
		try (final PDDocument doc = new PDDocument()) {

			PDPage page = new PDPage();
			doc.addPage(page);

			ClassLoader imageLoader = getClass().getClassLoader();
			String file = imageLoader.getResource("logo.png").getFile();
			PDImageXObject pdImage = PDImageXObject.createFromFile(file, doc);

			PDPageContentStream contents = new PDPageContentStream(doc, page);
			PDRectangle mediaBox = page.getMediaBox();

			float startX = (mediaBox.getWidth() - pdImage.getWidth()) / 2;
			float startY = (mediaBox.getHeight() - pdImage.getHeight()) / 2;
			contents.drawImage(pdImage, startX, startY);

			contents.close();

			doc.save(new File("image.pdf"));
		} catch (IOException e) {
			System.err.println("Exception while trying to create pdf document - " + e);
		}

	}

}
