package br.com.psg.artigos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Parametro;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DespachoInstauracaoProcessoAdm {
	public String gerarPdfDespachoInstauracaoProcessoAdm(Parametro param) {
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
		html.append("<div id=\"geral\" align=\"center\" width=\"100%\">");
//		html.append(" <h1 style=\"text-align: center\">(DESPACHO INSTAUÇÃO PROCESSO ADMINISTRATIVO)</h1>");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append(
				"<tr>" + "<td colspan=\"2\"><img src=\""+getClass().getResource("/br/com/psg/resources/topoDetran2.png")+"\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"146\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/>"
						+ "</td>" + "</tr>");
		html.append("</table>");
		html.append("<p><p>");
		html.append(
				"<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>DESPACHO PARA INSTAURAÇÃO DE PROCESSO ADMINISTRATIVO</b></td></tr></table>");
		html.append("<p><p>");
		html.append(" <table align=\"center\" width=\"100%\">");

		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">Nos termos do que foi informado pela Divisão de Registro de Condutores, DETERMINO a abertura de processo administrativo para o condutor"
						+ " <b><u><i>" + param.getNOME_WORK() + "</i></u></b>, CPF n° <b><u><i>" + param.getCPF_WORK()
						+ "</i></u></b>, por infringência ao artigo <b><u><i>" + param.getARTIGO_COMPLETO()
						+ " do CTB</i></u></b>.</td>" + "</tr>");
		html.append("<tr><td></td></tr>");
		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">Expeça-se a respectiva Portaria de abertura e a competente notificação ao condutor, concedendo-lhe na forma do § 4° do artigo 10 da Resolução 182/2005,"
						+ " o prazo de 15 (quinze) dias para a apresentação de defesa a contar do recebimento da notificação, informe-se que a não apresentação da defesa em tempo hábil determinará o seguimento do processo"
						+ " à revelia.</td>" + "</tr>");
		html.append(
				"<tr>" + "<td align=\"justify\" width=\"90%\">Instrua-se o processo com os documentos necessários na forma da legislação vigente.</td>"
						+ "</tr>");
		html.append("</table>");
		html.append("<p><p>");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append(" <tr><td><p>Campo Grande - MS, <b><u><i>" + DataUtil.dataAtualExtenso()
				+ "</i></u></b>.</p></td></tr>");
		html.append("</table>");
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append("<tr>");
		html.append(" <td>");
		html.append(" <img src=\"" + getClass().getResource("/br/com/psg/resources/gersonclaro.png")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/>");
		html.append("</td>");
		html.append("</tr>");
		html.append("<tr>");
		html.append(" <td>");
		html.append("<p><b>GERSON CLARO DINO</b><br />" + " <strong>Diretor Presidente DETRAN-MS      </strong></p>");
		html.append("</td>");
		html.append("</tr>");
		html.append("</table>");
		html.append("</div>");
		html.append("</div>");
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append("<img src=\"" + getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")
				+ "\" alt=\"rodape\" name=\"rodape\"  width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");
		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "despacho-instauracao" + param.getARTIGO_INCISO_WORK().trim().replaceAll(" ", "") + "-"
				+ param.getCPF_WORK().trim() + "";
		try {
			arquivo = FileUtil.caminhoTemplates + "/" + nomeArquivo + ".html";
			BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
			htmlFile.write(html.toString());
			htmlFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nomeArquivo;

	}
}
