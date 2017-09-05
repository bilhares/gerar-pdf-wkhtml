package br.com.psg.util;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import br.com.psg.config.PropertiesConfig;

public class FileUtil {


	public static String caminhoTemplates = "/opt/tomcat/html-pdf-detran";
	public static String caminhoPdfTemplates = "/opt/tomcat/html-pdf-detran/pdf";
	
//	public static String caminhoTemplates = "/pdf-html-detran";
//	public static String caminhoPdfTemplates = "/pdf-html-detran/pdf";

	public static void criarPastas() {
		File dirOrigem = new File(caminhoTemplates);
		File dirAssinado = new File(caminhoPdfTemplates);
		dirOrigem.setWritable(false);
		dirAssinado.setWritable(false);
		if (!dirOrigem.exists()) {
			//dirOrigem.mkdirs();
		}
		if (!dirAssinado.exists()) {
			//dirAssinado.mkdirs();
		}
		System.out.println("pastas criadas!");
	}
	
	public static void path(){
		String path = FileUtil.class.getClassLoader().getResource("").getPath();
		System.out.println(path);
	}

}
