package br.com.psg.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import br.com.psg.config.PropertiesConfig;
import br.com.psg.entities.Retorno;

public class GerarPdfUtilRegistros {
	public Retorno gerarPdf(String nomeArquivo) {

		String caminhoHtml = FileUtil.caminhoTemplates + "/" + nomeArquivo + ".html ";
		String caminhoPdf = FileUtil.caminhoPdfTemplates + "/" + nomeArquivo + ".pdf";
		String caminhoPdfCompleto = FileUtil.caminhoPdfTemplates + "/" + nomeArquivo + "-completo.pdf";

		try {
			Properties prop = new Properties();
			PropertiesConfig config = new PropertiesConfig();
			prop.load(config.getProperties());

			String command = prop.getProperty("comando") + " --margin-top 35 --margin-bottom 50 " + caminhoHtml + " " + caminhoPdf;
			//String command = prop.getProperty("comando") + " " + caminhoHtml + " " + caminhoPdf;

			System.out.println("COMANDO DESPACHO INST: " + command);

			Retorno docs = new Retorno();

			Runtime.getRuntime().exec(command);

			TimeUnit.SECONDS.sleep(2);

//			String addMarcaDagua = prop.getProperty("comandoAddMD") + " " + caminhoPdf + " multistamp "
//					+ FileUtil.caminhoTemplates+"/marcadagua.pdf" + " output " + caminhoPdfCompleto;
			
			String addMarcaDagua = prop.getProperty("comandoAddMD") + " " + caminhoPdf + " multistamp "
					+ getClass().getResource("/br/com/psg/resources/marcadagua.pdf").toString().replace("file:/", " ") + " output " + caminhoPdfCompleto;
			
			System.out.println("COMANDO DESPACHO INST: " + addMarcaDagua);
			
			Runtime.getRuntime().exec(addMarcaDagua);

			TimeUnit.SECONDS.sleep(2);

			java.nio.file.Path pdf = Paths.get(caminhoPdfCompleto);
			byte[] dataPdf = Files.readAllBytes(pdf);
			docs.setByteRegistro(dataPdf);
			
			File file = new File(caminhoPdf);
			file.delete();
			
			return docs;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		throw new RuntimeException();
	}
}
