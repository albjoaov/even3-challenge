package br.com.even3.crachaChallenge.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.stereotype.Service;
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

import br.com.even3.crachaChallenge.models.Participante;

@Service
public class CrachaService {

	public int countPaginasCracha(String participantes) {
		String[] participantesLines = participantes.split("\n");
		int countParticipantes = participantesLines.length;
		return countParticipantes;
	}
	/*
	 * Participante participante = new Participante(); participante.setCol1(col1);
	 * participante.setCol1(col2); participante.setCol1(col3);
	 * participante.setCol1(col4); participante.setCol1(col5);
	 */

	public byte[] criarPDF(MultipartFile arquivo, String nome, String participantes)
			throws MalformedURLException, IOException, DocumentException {
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, arrayOutputStream);
		document.open();
		PdfContentByte cb = pdfWriter.getDirectContentUnder();
		Image imagem = Image.getInstance(arquivo.getBytes());

		float scale = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin() - 0)
				/ imagem.getWidth()) * 100;

		imagem.scalePercent(scale);

		if (nome.contains("{{Nome}}")) {
			Participante participante = new Participante();
			List<String[]> participantesList = this.splitParticipantes(participantes);
			nome.replace("{{Nome}}", participante.getCol1());
		}

		for (int i = 0; i < this.countPaginasCracha(participantes); i++) {

			document.add(getWatermarkedImage(cb, Image.getInstance(imagem), nome));
		}

		document.close();
		byte[] bytes = arrayOutputStream.toByteArray();

		return bytes;
	}

	public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException {
		float width = img.getScaledWidth();
		float height = img.getScaledHeight();
		PdfTemplate template = cb.createTemplate(width, height);
		template.addImage(img, width, 0, 0, height, 0, 0);
		ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
				new Phrase(watermark, new Font(FontFamily.HELVETICA)), width / 2, height / 2, 0);
		return Image.getInstance(template);
	}

	public List<String[]> splitParticipantes(String participantes) {
		List<String[]> participantesColumns = null;
		String[] participantesLines = participantes.split("\n");
		// String[] titulos = participantesLines[0].split("\t");
		for (int i = 1; i < this.countPaginasCracha(participantes); i++) {
			String[] participantesArray = null;
			participantesArray = participantesLines[i].split("\t");
			participantesColumns.add(participantesArray);
		}
		return participantesColumns;
	}
}
