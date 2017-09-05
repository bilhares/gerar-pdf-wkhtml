package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class DespachoRecurso {
	
	public String gerarDespachoRecurso(Despachos despacho){
		
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
		
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"left\" width=\"100%\"><b>À DICON</td></tr></table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">No que concerne a defesa protocolada, cumpre esclarecer que o momento oportuno para apresentação de quaisquer alegações resta sanado, uma vez que deveria ter "
				+ "sido realizada nas fases processuais instituídas pela Resolução 182/2005 do CONTRAN, de forma que, esgotados os prazos e recursos cabíveis, encerrou-se a instância administrativa referente à imposição da penalidade.</td></tr>");
		html.append("</table>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 30px\">");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Diante do exposto e, tendo em vista que não há nos autos nenhum vício capaz de torná-lo ilegal, relato pelo "
				+ "<b>NÃO CONHECIMENTO</b>, sugerindo, s.m.j, a emissão de notificação em resposta ao pedido e posterior continuidade da execução da penalidade imposta.</td></tr>");
		html.append("</table>");
		
		// table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Campo Grande " + DataUtil.dataAtualExtenso()
				+ "</p></td></tr></table>");

		//assinatura relator
		html.append("<div id=\"assinatura\" align=\"center\" width=\"100%\" style=\"margin-top: 20px\">");
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"center\"><p align=\"center\"><b>"+despacho.getRelator()+"<br>Setor de Análise de Recursos - SEAPA</b></p></td></tr></table>");
		html.append("</div>");
		
		html.append("<table align=\"center\" width=\"100%\" style=\"margin-top: 20px\"><tr><td><p>De acordo,</p></td></tr></table>");
		
		
		// assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
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
		String nomeArquivo = "despacho-recurso";
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
