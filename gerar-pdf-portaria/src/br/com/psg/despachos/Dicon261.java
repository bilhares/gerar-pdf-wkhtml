package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class Dicon261 {
	public String gerarDicon261(Despachos depacho) {

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
				+ "\"alt=\"logo\" name=\"logo\" width=\"900\" height=\"132\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/></td></tr>");
		html.append("</table>");

		html.append("<p><p>");

		// titulo
		html.append(
				"<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>CERTIFICAÇÃO PARA ARTIGO 261 SEM DEFESA DE NOTIFICAÇÃO 15 DIAS</b></td></tr></table>");

		html.append("<p><p>");
		// tabela principal
		html.append("<table align=\"center\" width=\"100%\">");
		// conteudo
		html.append("<tr><td align=\"justify\" width=\"90%\"><b>À DIRHAB, DIRETORIA DE HABILITAÇÃO</b></td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Instaurado procedimento para apurar responsabilidade do condutor <b>"
						+ depacho.getNomeCondutor() + "</b>, CPF nº <b>" + depacho.getCpfCondutor()
						+ "</b>, por infringir artigo <b>261</b>, "
						+ "do Código de Trânsito Brasileiro, conforme consta dos autos, instruído com os Autos de Infração, documentos em imagem para prosseguimento do feito, certificamos que o condutor "
						+ "não interpôs recurso de penalidade para os autos em questão e ou teve os mesmos julgados improvidos, nos termos do artigo 281 e 282 do CTB, e não interpôs defesa escrita referente"
						+ " à notificação de instauração de processo administrativo no prazo de 15 dias acostada aos autos.</td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Dispõe <i>o artigo 261 do CTB, que a penalidade de suspensão do direito de dirigir será aplicada, nos casos previstos, pelo prazo mínimo de 01 "
						+ "(um) mês até o máximo de 01 (um) ano e, nos casos de reincidência no período de 12 (doze) meses, pelo prazo mínimo de 06 (seis) meses e até o máximo de dois anos segundo critérios "
						+ "estabelecidos pelo CONTRAN; além dos casos previstos em outros artigos do CTB e excetuados aqueles especificados no artigo 263, a suspensão do direito de conduzir será aplicada sempre "
						+ "que o infrator atingir a contagem de vinte pontos, prevista no artigo 259.</i></td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">O artigo 16 da resolução 182/2005 – CONTRAN dispõe que para infratores não reincidentes na penalidade de suspensão do direito de dirigir no "
						+ "período de doze meses a pena a ser aplicada será de 01 (um) a 03 (três) meses, para penalidades de suspensão do direito de dirigir, aplicadas em razão de infrações para as quais não "
						+ "sejam previstas multas agravadas.</td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">As infrações praticadas pelo condutor atingem a contagem de <b>"+depacho.getPontuacao()+"</b> pontos e enquadram-se no disposto acima.</td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Diante do exposto e por tudo que dos autos consta, encaminhamos o presente feito a Vossa Senhoria para apreciação quanto à "
						+ "aplicação da penalidade de suspensão do direito de dirigir, bem como a realização do curso de reciclagem para condutores infratores, na forma do artigo 268, inciso II do CTB.</td></tr>");

		html.append("</table>");

		html.append("<p>");

		// table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Em " + DataUtil.dataAtualExtenso()
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
		String nomeArquivo = "despacho-261-dicon";
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
