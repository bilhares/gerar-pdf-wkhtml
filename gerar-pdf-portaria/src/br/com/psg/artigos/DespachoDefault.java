package br.com.psg.artigos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Parametro;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DespachoDefault {

	public String gerarPdfDespachoDefault(Parametro param) {

	//	FileUtil.criarPastas();
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
//		html.append(" <h1 style=\"text-align: center\"> ELSE " + " (DESPACHO INSTAURAÇÃO SUSPENSÃO)</h1>");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append(
				"<tr>" + "<td colspan=\"2\"><img src=\""+getClass().getResource("/br/com/psg/resources/topoDetran2.png")+"\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"146\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/>"
						+ "</td>" + "</tr>");
		html.append("</table>");
		html.append("<p><p>");
		html.append(
				"<table align=\"center\" width=\"100%\"><tr><td align=\"left\" width=\"100%\"><b>Senhor Presidente, </b></td></tr></table>");
		html.append("<p><p>");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append("<tr>");
		html.append(" <td align=\"justify\" width=\"90%\">");
		html.append("Considerando a documentação referente ao condutor <b><u><i>"+param.getNOME_WORK()+"</i></u></b>, CPF: <b><u><i>"+param.getCPF_WORK()+"</i></u></b>, "
				+ "para instauração de processo administrativo, infração tipificada referente ao auto de infração <b><u>");

		for (String auto : param.getAUTO()) {
			html.append("<i>" + auto + "</i>, ");
		}

		html.append("</u></b> artigo <b><u><i>" + param.getARTIGO_COMPLETO()
				+ "</i></u></b> do CTB, , conforme extrato em anexo, passível de aplicação de penalidade de suspensão do direito de conduzir veículos automotores nos "
				+ "termos da legislação vigente");
		html.append("</td>");
		html.append("</tr>");
		html.append("<tr><td></td></tr>" + "	<tr>"
				+ "<td align=\"justify\" width=\"90%\">Solicito ao Senhor Diretor Presidente do DETRAN-MS abertura de processo administrativo para aplicação de penalidade de suspensão"
				+ " do direito de conduzir veículos automotores com fundamento no artigo 256 seus incisos e parágrafos e artigo 261 ambos do Código de Trânsito Brasileiro (CTB), além de"
				+ " realização do curso de reciclagem nos termos do artigo 268 do CTB c/c com a Resolução 168/2004. </td>"
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
		html.append(" <img src=\"" + getClass().getResource("/br/com/psg/resources/assinatura_luisfernandoferreiradossantos.jpg")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/>");
		html.append("</td>");
		html.append("</tr>");
		html.append("<tr>");
		html.append(" <td>");
		html.append("<p><b>LUIZ FERNANDO FERREIRA DOS SANTOS</b><br />"
				+ " DICON - Chefe da Divisão de Registro de Condutores<br>DETRAN / MS</p>");
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
		String nomeArquivo = "despacho-" + param.getARTIGO_INCISO_WORK().trim().replaceAll(" ", "") + "-" + param.getCPF_WORK().trim() + "";
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