package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class Dicon263 {
	public String gerarDicon263(Despachos despacho) {

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
				"<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>CERTIFICAÇÃO PARA ARTIGO 263 SEM DEFESA DE NOTIFICAÇÃO 15 DIAS</b></td></tr></table>");

		html.append("<p><p>");
		// tabela principal
		html.append("<table align=\"center\" width=\"100%\">");
		// conteudo
		html.append("<tr><td align=\"justify\" width=\"90%\"><b>À DIRHAB, DIRETORIA DE HABILITAÇÃO</b></td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Instaurado procedimento para apurar responsabilidade do condutor <b>"
						+ despacho.getNumProcesso() + "</b>, CPF nº <b>" + despacho.getCpfCondutor()
						+ "</b>, por infringir artigo 263 inciso I e II"
						+ ", do Código de Trânsito Brasileiro, conforme consta dos autos, instruído com os devidos Autos de Infração, documentos em imagem para prosseguimento do feito, "
						+ "certificamos que o condutor não interpôs recurso de penalidade para o(s) auto(s) em questão e ou teve o(s) mesmo(s) julgado(s) improvidos, nos termos do artigo 281 e 282 do CTB,"
						+ " e não interpôs defesa escrita referente à notificação de instauração de processo administrativo no prazo de 15 dias acostada aos autos.</td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Dispõe <i>o artigo 263, inciso I e II do CTB, que a penalidade de cassação do documento de habilitação será aplicada, "
						+ "quando, suspenso o direito de conduzir, o infrator conduzir qualquer veiculo; nos casos de reincidência, no prazo de doze meses, das infrações previstas no inciso "
						+ "III do art. 162 e nos arts. 163,164,165,173,174 e 175.</i></td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">A infração praticada pelo condutor enquadra-se no disposto acima.</td></tr>");

		html.append("<tr><td></td></tr>");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Diante do exposto e por tudo que dos autos consta, encaminhamos o presente feito a Vossa Senhoria para apreciação quanto "
						+ "à aplicação da penalidade de cassação do documento de habilitação, bem como a realização do curso de reciclagem para condutores infratores, na forma do artigo 268, "
						+ "inciso II do CTB.</td></tr>");

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
		String nomeArquivo = "despacho-263-dicon";
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
