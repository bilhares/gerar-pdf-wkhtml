package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.util.FileUtil;

public class PontuacaoHistoricoDoc {
	public String gerarHtmlPontuacaoHistoricoDoc(List<PontuacaoHistorico> param) {
		// FileUtil.criarPastas();
		StringBuilder html = new StringBuilder();

		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset=\"UTF-8\">");
		html.append("<title></title>");
		html.append("<style type=\"text/css\">");

		// css
		html.append(
				"@page {size: A4 portrait;border: none;margin: 0em;padding-top: 8.5em;padding-left: 3.0em;padding-right: 3.0em;padding-bottom: 5.8em;}body {font-family: \"Trebuchet MS\", Arial, sans-serif;font-size: 10px;}"
						+ ".titulo {font-weight: bold;font-size: 11pt;/* text-decoration: underline; */}.subtitulo {font-weight: bold;font-size: 8pt;/* text-decoration: underline; */}.linha {    display: table;    clear: both;"
						+ "    /* border: 1px solid red; */    width: 100%;}.esq4 {    float: left;    /* border: 1px solid blue; */    border: 1px dotted #C0C0C0;    padding: 0.5em;    margin: 0.1em;}");

		html.append("</style>" + "</head>");
		html.append("<body>");
		//html.append("<div style=\"margin-top: 18%; margin-bottom: 10%; margin-left:50px\">");
		html.append("<div style=\"margin-left:50px\">");
		// cabecalho
		html.append("<div class=\"titulo\">Pontuação</div>"
				+ "    <!--    <div class=\"subtitulo\" style=\"float: left;\"> - 27/06/2017 22:40</div> -->    "
				+ "<div class=\"subtitulo\" style=\"float: right; margin-right: 2em;\">Número do Processo: "
				+ param.get(0).getPROCESSO() + "</div>"
				+ "    <div style=\"clear: both; float: none; margin-top: 3em;\"><p class=\"titulo\"></p>");

		html.append(" <div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Nome</b><br>"
				+ param.get(0).getNOME() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CPF</b>"
				+ "<br>" + param.get(0).getCPF()
				+ "&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>PGU</b><br>"
				+ param.get(0).getPGU() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Registro</b><br>"
				+ param.get(0).getREGISTRO() + "&nbsp;</div></div>");

		html.append(
				" <div class=\"linha\"><div class=\"esq4\" style=\"width: 8.46em; display: block\"><b>Auto</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b>Data da Infração</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 5.64em; display: block\"><b>Ponto</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b>Data de Validade</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 5.64em; display: block\"><b>Artigo</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 11.28em; display: block\"><b>Referente</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b>Classificação</b>"
						+ "<br>&nbsp;</div></div>");

		for (PontuacaoHistorico params : param) {
			html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 8.46em; display: block\"><b></b><br>"
					+ params.getAUTO_EXTRATO() + "&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b></b><br>"
					+ params.getDATA_INFRACAO() + "&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 5.64em; display: block\"><b></b><br>" + params.getPONTO()
					+ "&nbsp;</div>" + "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b></b><br>"
					+ params.getVALIDADE_DATA() + "&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 5.64em; display: block\"><b></b><br>" + params.getARTIGO()
					+ "&nbsp;</div>" + "<div class=\"esq4\" style=\"width: 11.28em; display: block\"><b></b><br>"
					+ params.getREFERENTE() + "&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 8.46em; display: block\"><b></b><br>"
					+ params.getCLASSIFICACAO_MULTA() + "&nbsp;</div></div>");
		}
		
		html.append(" <div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Total de Pontos:</b><br>"
				+ param.get(0).getTOTAL_PONTOS() + "&nbsp;</div></div>");

		html.append("</div></div></body></html>");

		String arquivo = "";
		String nomeArquivo = "pontuacaoHistorico" + param.get(0).getCPF().trim() + "";
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
