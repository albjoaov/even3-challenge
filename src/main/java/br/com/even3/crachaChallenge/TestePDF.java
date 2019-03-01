package br.com.even3.crachaChallenge;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class TestePDF {

//	public static void main(String[] args) throws Exception {
//
//		try (final PDDocument doc = new PDDocument()) {
//
//			PDPage page = new PDPage();
//			doc.addPage(page);
//
////			ClassLoader iAUS = getcl
////			PDImageXObject pdImage = PDImageXObject.createFromFile(image, doc);
//
//			PDPageContentStream contents = new PDPageContentStream(doc, page);
//			PDRectangle mediaBox = page.getMediaBox();
//
//			float startX = (mediaBox.getWidth() - pdImage.getWidth()) / 2;
//			float startY = (mediaBox.getHeight() - pdImage.getHeight()) / 2;
//			contents.drawImage(pdImage, startX, startY);
//
//			contents.close();
//
//			doc.save(new File("/tmp/image.pdf"));
//		} catch (IOException e) {
//			System.err.println("Exception while trying to create pdf document - " + e);
//		}
//	}

	public void test() throws IOException {
		ClassLoader imageLoader = getClass().getClassLoader();
		String file = imageLoader.getResource("logo.png").getFile();
		PDImageXObject pdImage = PDImageXObject.createFromFile(file, null);

	}

}
