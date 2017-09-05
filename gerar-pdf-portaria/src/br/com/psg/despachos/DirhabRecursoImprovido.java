package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DirhabRecursoImprovido {
	public String gerarDefesaProvida() {

		StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset=\"UTF-8\">");
		html.append("<style type=\"text/css\">");
		// css
		html.append(
				"BODY {font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:none;}.font{font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:bold;}"
				+ "#rodape {position:absolute;bottom:0;}");

		html.append("</style>");
		html.append("</head><body>");

		html.append("<div id=\"geral\" align=\"center\" width=\"100%\"><table align=\"center\" width=\"100%\">");
		// imagem cabeçalho
		html.append("<tr><td colspan='2'><img src=\"" + getClass().getResource("/br/com/psg/resources/cabecalho.jpg")
				+ "\"alt=\"logo\" name=\"logo\" width=\"900\" height=\"132\" hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/></td></tr>");
		html.append("</table>");

		html.append("<p><p>");

		// titulo
		html.append(
				"<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>DESPACHO</b></td></tr></table>");

		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 45px\">");

		html.append("<tr><td align=\"justify\" width=\"90%\"><b>À DICON - Divisão de Registro de Condutores</b></td></tr>");

		html.append("</table>");

		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 45px\">");

		html.append("<tr><td align=\"justify\" width=\"90%\">Considerando decisão da JARI pelo IMPROVIMENTO do recurso, encaminhamos o presente processo para prosseguimento do feito.</td></tr>");

		html.append("</table>");


		// table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Campo Grande (MS), " + DataUtil.dataAtualExtenso()
				+ "</p></td></tr></table>");

		// assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append("<tr><td>");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/assinatura_rosilda.jpg")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"226\" height=\"160\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>");

		html.append(
				"<tr><td>  <p><b>ROSILDA DA SILVA MELO</b><br />Diretora de Habilitação<br>DETRAN / MS</p></td></tr>");

		html.append("</table></div>");

		html.append("</div>");

		// rodapé
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/rodape_jari_dirhab.png")
				+ "\" alt=\"rodape\" name=\"rodape\" width=\"800\" height=\"98\" hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");

		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "dirhab-recurso-improvido";
		try {
			arquivo = FileUtil.caminhoTemplates + "/" + nomeArquivo + ".html";
			BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
			htmlFile.write(html.toString());
			System.out.println("criou o arquivo");
			htmlFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nomeArquivo;
	}
}
