package br.com.psg.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.psg.entities.Retorno;

public class GerarPdfUtil {
	public Retorno gerarPdf(String nomeArquivoDespacho, String nomeArquivoPorta) {

		String caminhoHtmlDespacho = FileUtil.caminhoTemplates + "/" + nomeArquivoDespacho + ".html ";
		String caminhoPdfDespacho = FileUtil.caminhoPdfTemplates + "/" + nomeArquivoDespacho + ".pdf";

		String caminhoHtmlPortaria = FileUtil.caminhoTemplates + "/" + nomeArquivoPorta + ".html ";
		String caminhoPdfPortaria = FileUtil.caminhoPdfTemplates + "/" + nomeArquivoPorta + ".pdf";

		try {
			String commandDespacho = "cmd /c start cmd.exe /C c:/wkhtmltopdf/bin/wkhtmltopdf.exe " + caminhoHtmlDespacho
					+ " " + caminhoPdfDespacho;
			String commandPortaria = "cmd /c start cmd.exe /C c:/wkhtmltopdf/bin/wkhtmltopdf.exe " + caminhoHtmlPortaria
					+ " " + caminhoPdfPortaria;

			System.out.println("COMANDO DESPACHO: cmd /c start cmd.exe /C c:/wkhtmltopdf/bin/wkhtmltopdf.exe "
					+ caminhoHtmlDespacho + " " + caminhoPdfDespacho);

			System.out.println("COMANDO PORTARIA: cmd /c start cmd.exe /C c:/wkhtmltopdf/bin/wkhtmltopdf.exe "
					+ caminhoHtmlPortaria + " " + caminhoPdfPortaria);
			if (nomeArquivoDespacho != null) {
				Runtime.getRuntime().exec(commandDespacho);
			}
			if (nomeArquivoPorta != null) {
				Runtime.getRuntime().exec(commandPortaria);
			}

			Retorno docs = new Retorno();
			docs.setDespacho(caminhoPdfDespacho);
			docs.setPortaria(caminhoPdfPortaria);

			return docs;

		} catch (IOException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
}
