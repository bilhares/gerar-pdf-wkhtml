package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.psg.entities.HistoricoRecursoMulta;
import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class InformacoesRecursoDoc {
	public String gerarHtmlInformacoesRecursoDoc(List<HistoricoRecursoMulta> param) {
	//	FileUtil.criarPastas();
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
	//	html.append("<div style=\"margin-top: 18%; margin-bottom: 10%; margin-left:50px\">");
		html.append("<div style=\"margin-left:50px\">");
		// cabecalho
		html.append("<div class=\"titulo\">Informações de Recurso</div>"
				+ "<div class=\"subtitulo\" style=\"float: left;\">Transação REC-MCO - Administrador do Sistema - "
				+ DataUtil.dataAtualExtenso() + "</div>"
				+ "<div class=\"subtitulo\" style=\"float: right; margin-right: 2em;\">Número do Processo: "
				+ param.get(0).getPROCESSO() + "</div>");

		html.append("<div style=\"clear: both; float: none; margin-top: 3em;\"><p class=\"titulo\"></p>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 5.78em; display: block\"><b>Protocolo</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 8.67em; display: block\"><b>Auto</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 8.67em; display: block\"><b>Descrição</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 5.78em; display: block\"><b>Requerente</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 5.78em; display: block\"><b>Tipo</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 23.12em; display: block\"><b>Observação</b><br>&nbsp;</div>"
						+ "</div>");

		for (HistoricoRecursoMulta params : param) {
			html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 5.78em; display: block\">"
					+ params.getPROTOCOLO_RECURSO() + "<br>&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 8.67em; display: block\">" + params.getAUTO_EXTRATO()
					+ "<br>&nbsp;</div>" + "<div class=\"esq4\" style=\"width: 8.67em; display: block\">"
					+ params.getDESCRICAO_RECURSO() + "<br>&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 5.78em; display: block\">" + params.getREQUERENTE()
					+ "<br>&nbsp;</div>" + "<div class=\"esq4\" style=\"width: 5.78em; display: block\">"
					+ params.getTIPO_PROC() + "<br>&nbsp;</div>"
					+ "<div class=\"esq4\" style=\"width: 23.12em; display: block\">" + params.getOBSERVACAO()
					+ "<br>&nbsp;</div></div>");
		}
		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Síntese da Defesa</b><br>"
						+ param.get(0).getSINTESE_DEFESA() + "&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Observação do Resultado</b>"
						+ "<br>" + param.get(0).getOBSERVACAO_RESULTADO()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Resultado do Julgamento</b><br>"
						+ param.get(0).getRESULTADO_JULGAMENTO() + "&nbsp;</div></div>");

		html.append("</div></div></body></html>");
		
		String arquivo = "";
		String nomeArquivo = "informacoesRecurso" + param.get(0).getTIPO_REG().trim() + "";
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
