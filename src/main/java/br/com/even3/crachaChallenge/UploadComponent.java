package br.com.even3.crachaChallenge;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class UploadComponent {

	@Value("${contato.disco.raiz}")
	private String raiz;

	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;

	public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException {
		float width = img.getScaledWidth();
		float height = img.getScaledHeight();
		PdfTemplate template = cb.createTemplate(width, height);
		template.addImage(img, width, 0, 0, height, 0, 0);
		ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
				new Phrase(watermark, new Font(FontFamily.HELVETICA)), width / 2, height / 2, 0);
		return Image.getInstance(template);
	}

	public byte[] salvar(MultipartFile arquivo, String nome)
			throws MalformedURLException, IOException, DocumentException {
//		try (final PDDocument doc = new PDDocument()) {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, arrayOutputStream);
		document.open();
		PdfContentByte cb = pdfWriter.getDirectContentUnder();
//			PDPage page = new PDPage();
//			doc.addPage(page);

		Image imagem = Image.getInstance(arquivo.getBytes());
		float scale = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - 0)
				/ imagem.getWidth()) * 100;
		imagem.scalePercent(scale);
//		document.add(imagem);

		document.add(getWatermarkedImage(cb, Image.getInstance(imagem), nome));
		document.add(getWatermarkedImage(cb, Image.getInstance(imagem), nome));

//		document.add(new Paragraph("Jose carlos"));

//			PDImageXObject pdImage = PDImageXObject.createFromByteArray(doc, arquivo.getBytes(), "2131231");
//
//			PDPageContentStream contents = new PDPageContentStream(doc, page);
//			PDRectangle mediaBox = page.getMediaBox();
//
//			float startX = (mediaBox.getWidth() - pdImage.getWidth()) / 2;
//			float startY = (mediaBox.getHeight() - pdImage.getHeight()) / 2;
//			contents.drawImage(pdImage, startX, startY);
//
//			contents.close();
		document.close();
		byte[] bytes = arrayOutputStream.toByteArray();

//		FileUtils.writeByteArrayToFile(new File("image.pdf"), bytes); SALVAMENTO
//			doc.save(new File("image.pdf"));
//		} catch (IOException e) {
//			System.err.println("Exception while trying to create pdf document - " + e);
//		}
		return bytes;
	}

	public byte[] salvarFoto(MultipartFile foto, String nome)
			throws MalformedURLException, IOException, DocumentException {
		return this.salvar(foto, nome);
	}
}
