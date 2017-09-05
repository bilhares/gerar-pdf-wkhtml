package br.com.psg.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import br.com.psg.config.PropertiesConfig;
import br.com.psg.entities.Retorno;

public class GerarPdfUtilByteArray {

	// public final String margem = "--margin-left 12 --margin-right 12";
	// public final String margem = "--page-width 595px --page-height 842px";

	/* prod */
	// public final String margem = "--page-size A4 --page-width 7385px
	// --page-height 10445px";

	/* dev */
	// public final String margem = "--page-size A4 --page-width 666px
	// --page-height 943px";

	public final String margem = "--page-size A4";

	public Retorno gerarPdf(String nomeArquivoDespacho, String nomeArquivoPorta, String despachoInstauracao,
			String certidao) {

		String caminhoHtmlDespacho = FileUtil.caminhoTemplates + "/" + nomeArquivoDespacho + ".html ";
		String caminhoPdfDespacho = FileUtil.caminhoPdfTemplates + "/" + nomeArquivoDespacho + ".pdf";

		String caminhoHtmlPortaria = FileUtil.caminhoTemplates + "/" + nomeArquivoPorta + ".html ";
		String caminhoPdfPortaria = FileUtil.caminhoPdfTemplates + "/" + nomeArquivoPorta + ".pdf";

		String caminhoHtmlDespachoInst = FileUtil.caminhoTemplates + "/" + despachoInstauracao + ".html ";
		String caminhoPdfDespachoInst = FileUtil.caminhoPdfTemplates + "/" + despachoInstauracao + ".pdf";

		String caminhoHtmlCertidao = FileUtil.caminhoTemplates + "/" + certidao + ".html ";
		String caminhoPdfCertidao = FileUtil.caminhoPdfTemplates + "/" + certidao + ".pdf";

		try {
			Properties prop = new Properties();
			PropertiesConfig config = new PropertiesConfig();
			prop.load(config.getProperties());

			String path = FileUtil.class.getClassLoader().getResource("").getPath();
			System.out.println(path);

			String commandDespacho = prop.getProperty("comando") + "  " + margem + "  " + caminhoHtmlDespacho + "  "
					+ caminhoPdfDespacho;

			String commandPortaria = prop.getProperty("comando") + "  " + margem + "  " + caminhoHtmlPortaria + "  "
					+ caminhoPdfPortaria;

			String commandDespachoIns = prop.getProperty("comando") + "  " + margem + "  " + caminhoHtmlDespachoInst
					+ "  " + caminhoPdfDespachoInst;

			String commandCertidao = prop.getProperty("comando") + "  " + margem + "  " + caminhoHtmlCertidao + "  "
					+ caminhoPdfCertidao;

			System.out.println("COMANDO DESPACHO: " + commandDespacho);

			System.out.println("COMANDO PORTARIA:  " + commandPortaria);

			System.out.println("COMANDO DESPACHO INST: " + commandDespachoIns);

			System.out.println("COMANDO CERTIDAO: " + commandCertidao);

			Retorno docs = new Retorno();
			if (nomeArquivoDespacho != null) {
				Runtime.getRuntime().exec(commandDespacho);
				TimeUnit.SECONDS.sleep(2);
				System.out.println("execucao comando 1");
			}
			if (nomeArquivoPorta != null) {
				Runtime.getRuntime().exec(commandPortaria);
				TimeUnit.SECONDS.sleep(2);
				System.out.println("execucao comando 2");
			}
			if (despachoInstauracao != null) {
				Runtime.getRuntime().exec(commandDespachoIns);
				System.out.println("execucao comando 3");
				TimeUnit.SECONDS.sleep(2);
			}
			if (certidao != null) {
				Runtime.getRuntime().exec(commandCertidao);
				System.out.println("execucao comando 4");
				TimeUnit.SECONDS.sleep(2);
			}
			if (nomeArquivoDespacho != null) {
				java.nio.file.Path pDespacho = Paths.get(caminhoPdfDespacho);
				byte[] dataDespacho = Files.readAllBytes(pDespacho);
				docs.setByteDespacho(dataDespacho);
			}
			if (nomeArquivoPorta != null) {
				java.nio.file.Path pPortaria = Paths.get(caminhoPdfPortaria);
				byte[] dataPortaria = Files.readAllBytes(pPortaria);
				docs.setBytePortaria(dataPortaria);
			}
			if (despachoInstauracao != null) {
				java.nio.file.Path pDespachoInst = Paths.get(caminhoPdfDespachoInst);
				byte[] dataDespachoInst = Files.readAllBytes(pDespachoInst);
				docs.setByteDespachoInst(dataDespachoInst);
			}
			if (certidao != null) {
				java.nio.file.Path pCertidao = Paths.get(caminhoPdfCertidao);
				byte[] dataCertidao = Files.readAllBytes(pCertidao);
				docs.setByteCertidao(dataCertidao);
			}

			return docs;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
}
