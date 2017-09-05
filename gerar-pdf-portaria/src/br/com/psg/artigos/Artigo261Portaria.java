package br.com.psg.artigos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Parametro;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class Artigo261Portaria {
	public String gerarPdf261Portaria(Parametro param) {
		//FileUtil.criarPastas();
		StringBuilder html = new StringBuilder();

		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset=\"UTF-8\">");
		html.append("<style type=\"text/css\">");
		html.append("body{font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;" + "font-size:12px;"
				+ "font-weight:none;}");
		html.append(".font{font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;" + "font-size:12px;"
				+ "font-weight:bold;}");
		html.append("</style>");
		html.append("</head>");
		html.append("<body>");
//		html.append("<h1 style=\"text-align: center\">artigo_"+param.getARTIGO_INCISO_WORK()+" (PORTARIA)</h1>");
		html.append("<div id=\"geral\" align=\"center\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append(
				"<tr>" + "<td colspan=\"2\"><img src=\""+getClass().getResource("/br/com/psg/resources/topoDetran2.png")+"\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"146\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/>"
						+ "</td>" + "</tr>");
		html.append(
				"<tr><td width=\"50%\">PORTARIA <b><u><i>"+param.getNUM_PORTARIA()+"</i></u></b> / <b><u><i>"+param.getANO_PORTARIA()+"</i></u></b> - DETRAN-MS</td>"
						+ "<td width=\"50%\">Campo Grande, MS, <b><u><i>"+ DataUtil.dataAtualExtenso()+"</i></u></b>.</td></tr>");
		html.append("</table>");
		html.append("<p>");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">O DIRETOR PRESIDENTE DO DEPARTAMENTO ESTADUAL DE TRÂNSITO DO"
						+ " ESTADO DE MATO GROSSO DO SUL - DETRAN - MS no uso de suas atribuições legais,"
						+ " em especial as definidas nos incisos I, II e VI do artigo 22 do Código de Trânsito Brasileiro - CTB.</td>"
						+ "</tr>");
		html.append("<tr>"
				+ "<td align=\"justify\" width=\"90%\">CONSIDERANDO o que autoriza o artigo 256 em seus incisos e parágrafos e artigo 261 ambos do CTB;</td>"
						+ "</tr>");
		html.append("<tr>" + "<td align=\"justify\" width=\"90%\">CONSIDERANDO o que regulamenta a Resolução 182/2005, do CONTRAN.</td>" + "</tr>");
		html.append("<tr>" + "<td align=\"justify\" width=\"90%\">RESOLVE:</td>" + "</tr>");
		html.append("<tr>"
				+ "<td align=\"justify\" width=\"90%\">1° INSTAURAR processo administrativo em nome do condutor <b><u><i>"
				+ param.getNOME_WORK() + "</i></u></b>, portador da CNH nº <b><u><i>" + param.getNUMERO_CNH_WORK()
				+ "</i></u></b>," + " sob o registro <b><u><i>" + param.getNUMERO_REGISTRO_WORK()
				+ "</i></u></b> para a aplicação da penalidade de suspensão" 
				+ " do direito de conduzir veículos automotores, com fundamento ao artigo 261, caput do CTB por infringência ao artigo <b><u><i>"
				+ param.getARTIGO_COMPLETO()+ "</i></u> do CTB</b>.</td>" + "</tr>");
		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">2° Registre-se e expeça-se a competente notificação ao condutor, concedendo-lhe na forma do §"
						+ " 4° do artigo 10 da Resolução 182/2005, o prazo de 15 (quinze) dias para a apresentação de"
						+ " defesa a contar do recebimento da notificação.</td>" + "</tr>");
		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">3° Informe-se que a não apresentação da defesa em tempo hábil determinará o seguimento do"
						+ " processo à revelia.</td>" + "</tr>");
		html.append("</table>");
		html.append("<p><p>");
		html.append("<p><p>");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append(" <tr><td><p>Campo Grande - MS,"+ DataUtil.dataAtualExtenso()+" <b><u><i>" 
				+ "</i></u></b>.</p></td></tr>");
		html.append("</table>");
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append("<tr>");
		html.append(" <td>");
		html.append(
				"<img src=\""+getClass().getResource("/br/com/psg/resources/gersonclaro.png")+"\" alt=\"assinatura\" name=\"assinatura\" width=\"270\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/>");
		html.append("</td>");
		html.append("</tr>");
		html.append("<tr>");
		html.append(" <td>");
		html.append("<p>GERSON CLARO DINO<br />" + "<strong>Diretor Presidente DETRAN-MS</strong></p>");
		html.append("</td>");
		html.append("</tr>");
		html.append("</table>");
		html.append("</div>");
		html.append("</div>");
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append(
				"<img src=\""+getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")+"\" alt=\"rodape\" name=\"rodape\" width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");
		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "portaria-" + param.getARTIGO_INCISO_WORK().trim().replaceAll(" ", "")+ "-" + param.getCPF_WORK().trim();
		try {
			arquivo = FileUtil.caminhoTemplates +"/"+ nomeArquivo+".html";
			BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
			htmlFile.write(html.toString());
			htmlFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nomeArquivo;
	}
}
