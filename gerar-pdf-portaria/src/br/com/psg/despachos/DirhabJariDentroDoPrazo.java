package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DirhabJariDentroDoPrazo {
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

		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 45px\">");

		html.append("<tr><td align=\"justify\" width=\"90%\"><i><b>À <br/>DIRHAB - DIRETORIA DE HABILITAÇÃO</b></i></td></tr>");

		html.append("</table>");

		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 45px\">");

		html.append("<tr><td align=\"justify\" width=\"90%\">Encaminhamos o presente processo, para conhecimento e deliberação, visto que foi protocolado recurso tempestivo, em anexo, contra a "
				+ "penalidade aplicada.</td></tr>");

		html.append("</table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 45px\">");

		html.append("<tr><td align=\"justify\" width=\"90%\">Assim, sugerimos o envio dos autos à JARI.</td></tr>");

		html.append("</table>");


		// table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Campo Grande (MS), " + DataUtil.dataAtualExtenso()
				+ "</p></td></tr></table>");

		// assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append("<tr><td>");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/assinatura_luis.png")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"226\" height=\"160\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>");

		html.append(
				"<tr><td>  <p><b>LUIZ FERNANDO FERREIRA DOS SANTOS</b><br />Chefe da Divisão de Registro de condutores</p></td></tr>");

		html.append("</table></div>");

		html.append("</div>");

		// rodapé
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/rodape_jari.png")
				+ "\" alt=\"rodape\" name=\"rodape\" width=\"800\" height=\"102\" hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");

		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "dirhab-jari-detro-prazo";
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
