package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class relatorioDefesa {
	
	public String gerarHtmlRelatorioDefesa(Despachos despacho){
		
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
		
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"left\" width=\"100%\"><b>RELATÓRIO DE DEFESA</td></tr></table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Trata-se o presente de defesa interposta pelo condutor(a)"+despacho.getNomeCondutor()+" referente ao "
				+ "processo "+despacho.getNumProcesso()+", que se enquadra em uma das hipóteses elencadas pelo o artigo 25 da Resolução nº. 182/2005 do CONTRAN, <i>in verbis</i>:</td></tr>");
		html.append("</table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		
		html.append("<tr><td align=\"left\" width=\"90%\">Art. 25. As defesas e os recursos não serão conhecidos quando interpostos:<br>I - fora do prazo;<br>II - por quem não seja parte legítima.</td></tr>");
		html.append("</table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Dessa forma, relato pelo <b>NÃO CONHECIMENTO</b> do presente recurso, devendo, nos termos do que preceitua o artigo 15 da Resolução 182/2005 do CONTRAN, "
				+ "ser aplicada a penalidade.</td></tr>");
		html.append("</table>");
		
		
		// table data
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\"><tr><td><p>Campo Grande " + DataUtil.dataAtualExtenso()
				+ "</p></td></tr></table>");

		//assinatura relator
		html.append("<div id=\"assinatura\" align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"center\"><p align=\"center\"><b>"+despacho.getRelator()+"<br>Setor de Análise de Recursos - SEAPA</b></p></td></tr></table>");
		html.append("</div>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 55px;\"><tr><td align=\"left\" width=\"100%\"><b>À DICON</b></td></tr></table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");

		html.append(
				"<tr><td align=\"justify\" width=\"90%\">Tendo em vista o NÃO CONHECIMENTO da defesa escrita, encaminhamos o processo para prosseguimento do feito.</td></tr>");
		html.append("</table>");
		
		// table data
				html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\"><tr><td><p>Campo Grande " + DataUtil.dataAtualExtenso()
						+ "</p></td></tr></table>");
		
		
		// assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\" style=\"margin-top: 30px\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append("<tr><td>");
		html.append("<img src=\""
				+ getClass().getResource("/br/com/psg/resources/assinatura_rosemeiry.jpg")
				+ "\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>");

		html.append(
				"<tr><td>  <p><b>ROSEMEIRY HOFFMANN SILVA</b><br /> Chefe do Setor de Penalidades – SEPEN<br>DETRAN / MS</p></td></tr>");

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
		String nomeArquivo = "relatorio-defesa";
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
