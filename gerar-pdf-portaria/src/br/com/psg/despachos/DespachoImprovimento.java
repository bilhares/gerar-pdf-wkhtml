package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DespachoImprovimento {
	
	public String gerarImprovimento(Despachos despacho){
		
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
				+ "\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"132\" hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/></td></tr>");
		html.append("</table>");

		html.append("<p><p>");
		
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"left\" width=\"100%\"><b>À DIRHAB – DIRETORIA DE HABILITAÇÃO</b></td></tr></table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Encaminhamos o presente processo "+despacho.getNumProcesso()+", devidamente relatado com o improvimento do recurso interposto para envio "
				+ "a presidência a fim de análise e S.M.J., acolhimento e publicação da competente portaria de aplicação de penalidade.</td></tr>");
		html.append("</table>");
		
		// table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Campo Grande " + DataUtil.dataAtualExtenso()
				+ "</p></td></tr></table>");

		// assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append("<tr><td>");
		html.append("<img src=\""
				+ getClass().getResource("/br/com/psg/resources/assinatura_luisfernandoferreiradossantos.jpg")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>");

		html.append(
				"<tr><td>  <p><b>LUIZ FERNANDO FERREIRA DOS SANTOS</b><br />Chefe da Divisão de Registro de Condutores<br>DETRAN / MS</p></td></tr>");

		html.append("</table></div>");

		html.append("</div>");

		// rodapé
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")
				+ "\" alt=\"rodape\" name=\"rodape\"  width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");

		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "despacho-improvimento";
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
