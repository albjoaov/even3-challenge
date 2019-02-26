package br.com.even3.crachaChallenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadComponent {

	@Value("${contato.disco.raiz}")
	private String raiz;

	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;

	public void salvar(String diretorio, MultipartFile arquivo) {
		Path diretorioPath = Paths.get(raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

		try {
			Files.createDirectories(diretorioPath);
			arquivo.transferTo(arquivoPath.toFile());
		} catch (IOException e) {
			throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
		}
	}

	public void salvarFoto(MultipartFile foto) {
		this.salvar(diretorioFotos, foto);
	}
}