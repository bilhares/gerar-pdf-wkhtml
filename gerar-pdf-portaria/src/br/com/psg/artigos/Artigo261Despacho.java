package br.com.psg.artigos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Parametro;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class Artigo261Despacho {

	public String gerarPdf261DespachoInstauracao(Parametro param) {
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
//		html.append(" <h1 style=\"text-align: center\"> artigo_" + param.getARTIGO_INCISO_WORK()
//				+ "(DESPACHO INSTAURAÇÃO SUSPENSÃO)</h1>");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append(
				"<tr>" + "<td colspan=\"2\"><img src=\""+getClass().getResource("/br/com/psg/resources/topoDetran2.png")+"\"alt=\"logo\" name=\"logo\"  width=\"900\" height=\"146\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/>"
						+ "</td>" + "</tr>");
		html.append("</table>");
		html.append("<p><p>");
		html.append(
				"<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>Senhor Diretor Preisidente,</b></td></tr></table>");
		html.append("<p><p>");
		html.append(" <table align=\"center\" width=\"100%\">");
		html.append("<tr>");
		html.append(" <td align=\"justify\" width=\"90%\">");
		html.append("Considerando que consta ativa na pontuação do condutor <b><u><i>" + param.getNOME_WORK()
				+ "</i></u></b>, CPF n° " + " <b><u><i>" + param.getCPF_WORK()
				+ "</i></u></b>, infrações que atingem a contagem de 20 pontos prevista no artigo 259 do CTB, no "
				+ " período de um ano, referente aos autos de infração <b><u>");
		
		for (String auto : param.getAUTO()) {
			html.append("<i>" + auto + "</i>, ");
		}

		html.append("</u></b> artigos <b><u><i>" + param.getARTIGO_COMPLETO()+ " do CTB</i></u>"
				+ " </b>, conforme extrato em anexo, passível de aplicação de penalidade de suspensão do direito de conduzir veículos "
				+ " automotores nos termos do artigo 261 § primeiro c/c artigo 7° da Resolução nº 182/2005 do CONTRAN. , solicito ao Senhor Diretor "
				+ "Presidente do DETRAN-MS abertura de processo administrativo para aplicação de penalidade de suspensão do direito de conduzir veículos"
				+ " automotores com fundamento nos artigos 256 e 261 ambos do CTB, além da realização do curso de reciclagem nos termos do artigo 268 do "
				+ "CTB c/c com a Resolução 168/2004.");
		html.append("</td>");
		html.append("</tr>");
		html.append("<tr><td></td></tr>");
		html.append("<tr>");
		html.append(
				"<td align=\"justify\" width=\"90%\"></td>");
		html.append("</tr>");
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
		html.append(
				"<img src=\""+getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")+"\" alt=\"rodape\" name=\"rodape\" width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");
		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "despacho-" + param.getARTIGO_INCISO_WORK().trim().replaceAll(" ", "") + "-" + param.getCPF_WORK().trim();
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

	public static void main(String[] args) throws IOException {
		Artigo261Despacho artigo261DespachoInst = new Artigo261Despacho();
		System.out.println(artigo261DespachoInst.gerarPdf261DespachoInstauracao(null));
	}
}