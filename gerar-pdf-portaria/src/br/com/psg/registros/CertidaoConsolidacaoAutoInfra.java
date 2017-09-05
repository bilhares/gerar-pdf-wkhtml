package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.psg.entities.RecebimentoArPenalidade;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class CertidaoConsolidacaoAutoInfra {
	public String gerarHtmlCertidaoConsolidacaoAutoInfra() {
	//	FileUtil.criarPastas();
		StringBuilder html = new StringBuilder();

		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset=\"UTF-8\">");
		html.append("<style type=\"text/css\">");
		// css
		html.append(
				"BODY {font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:none;}.font{font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:bold;}");

		html.append("</style></head><body>");

		html.append("<div id=\"geral\" align=\"center\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		
		html.append(
				"<tr>" + "<td colspan=\"2\"><img src=\""+getClass().getResource("/br/com/psg/resources/topoDetran2.png")+"\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"146\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/>"
						+ "</td>" + "</tr>");
		html.append("</table><p><p><table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\">"
				+ "<b>CERTIDÃO DE CONSOLIDAÇÃO DE AUTO DE INFRAÇÃO</b></td></tr></table><p><p>");

		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"justify\" width=\"90%\">"
				+ "Certifico a consolidação dos autos na esfera administrativa, com base em pesquisa realizada no"
				+ " sistema informatizado deste Departamento, referente à interposição de recurso "
				+ "administrativo nos termos do artigo 281 e 282 do CTB; da uniformização prevista na Resolução"
				+ " 619/2016 do CONTRAN e inexistência de suspensão por medida judicial contra o (s) AIT mencionado"
				+ " (s),cuja pontuação está sendo considerada para os fins deste processo. Com fundamento no \"caput\""
				+ " do artigo 6° e seu 2°, da Resolução 182/2005 do CONTRAN, estão esgotados todos os meios de defesa"
				+ " para os autos em questão.</td></tr></table>");

		html.append("<p><p><table align=\"center\" width=\"100%\"><tr><td><p>Campo Grande - MS, "
				+ DataUtil.dataAtualExtenso() + "</p></td></tr></table>");
		html.append(
				"<div id=\"assinatura\" align=\"left\" width=\"100%\"><table align=\"center\" width=\"100%\"><tr><td>");

		// assinatura
		html.append(
				"<img src=\""+getClass().getResource("/br/com/psg/resources/assinatura_luisfernandoferreiradossantos.jpg")+"\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" "
						+ "height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>"
						+ "<tr><td>  <p><b>LUIZ FERNANDO FERREIRA DOS SANTOS</b><br />"
						+ "DICON - Chefe da Divisão de Registro de Condutores<br>DETRAN / MS</p></td></tr>");

		html.append("</table></div></div><div id=\"rodape\" align=\"center\">"
				+ "<img src=\""+getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")+"\" alt=\"rodape\" name=\"rodape\"  width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>"
				+ "</div></body></html>");

		String arquivo = "";
		String nomeArquivo = "CertidaoConsolidacaoAutoInfra";
		try {
			arquivo = FileUtil.caminhoTemplates + "/" + nomeArquivo + ".html";
			BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
			htmlFile.write(html.toString());
			htmlFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nomeArquivo;

	}
}
