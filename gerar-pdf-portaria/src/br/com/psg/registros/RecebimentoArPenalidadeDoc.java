package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.entities.RecebimentoArPenalidade;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class RecebimentoArPenalidadeDoc {

	public String gerarHtmlRecebimentoArPenalidadeDoc(List<RecebimentoArPenalidade> param) {
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
		//html.append("<div style=\"margin-top: 18%; margin-bottom: 10%; margin-left:50px\">");
		html.append("<div style=\"margin-left:50px\">");
		// cabecalho
		html.append(
				"<div class=\"titulo\">Recebimento Ar Penalidade</div><div class=\"subtitulo\" style=\"float: left;\">"
						+ "Transação CON-MEX - Administrador do Sistema - " + DataUtil.dataAtualExtenso() + "</div>"
						+ "<div class=\"subtitulo\" style=\"float: right; margin-right: 2em;\">Busca por CPF: "
						+ param.get(0).getCpfCondutor() + "</div>"
						+ "<div style=\"clear: both; float: none; margin-top: 3em;\"><p class=\"titulo\"></p>");

		html.append(
				" <div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Auto de Infração</b>"
						+ "<br>"+param.get(0).getAUTO_INFRACAO()+"&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Responsavel pontuação</b>"
						+ "<br>"+param.get(0).getResponsavelPontos()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Placa</b><br>"+param.get(0).getPlaca()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Município Veículo</b><br>"+param.get(0).getCodigoMunicipioVeiculo()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Cód. Infração</b>"
						+ "<br>"+param.get(0).getCodigoInfracao()+"&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Competência</b><br>"+param.get(0).getCompetencia()+"&nbsp;</div>"
						+ "</div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Tipo Infração</b><br>"+param.get(0).getTipoInfracao()+"&nbsp;</div>"
						+ "</div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Infração</b><br>"+param.get(0).getDataInfracao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Hora Infração</b><br>"+param.get(0).getHoraInfracao()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Emissão Notificação</b><br>"+param.get(0).getDataEmissaoNotificacao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Vencimento (desconto)</b><br>&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Situação notificação</b>"
						+ "<br>"+param.get(0).getSituacaoAR()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Informações s/baixa</b><br>&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>N.Guia</b><br>"+param.get(0).getNumeroGuiaPagamento()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Valor Pago</b><br>"+param.get(0).getValorInfracao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Pagamento</b><br>&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Relat. Publicação</b><br>"+param.get(0).getDataRelatorioPublicacao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Publicação no DO</b><br>"
						+ param.get(0).getDATA_PUBLICACAO_DO() + "&nbsp;</div></div>");

		html.append("  <div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Local</b>"
				+ "<br>"+param.get(0).getLocalInfracao()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Cód. Munic. Infração</b>"
						+ "<br>"+param.get(0).getCodigoMunicipioInfracao()+"&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Vel. Aferida</b>"
						+ "<br>"+param.get(0).getVelocidadeAferida()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Tipo Autuador</b>"
						+ "<br>"+param.get(0).getTipoAutuador()+"&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Condutor</b>"
				+ "<br>" + param.get(0).getCondutor()
				+ "&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Infrator Notif.</b>"
				+ "<br>"+param.get(0).getCodutorInformado()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CPF condutor</b>"
						+ "<br>" + param.get(0).getCpfCondutor()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>PGU/REG</b>"
						+ "<br>"+param.get(0).getPguCondutor()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CNH</b>"
						+ "<br>"+param.get(0).getCnhCondutor()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Marca/Modelo</b>"
						+ "<br>&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Parcelamento</b><br>&nbsp;</div>"
						+ "</div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Observação AR</b>"
						+ "<br>" + param.get(0).getOBSERVACAO_AR_NP()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Recebeu AR</b><br>&nbsp;</div>"
						+ "</div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Rec. AR</b>"
						+ "<br>" + param.get(0).getDATA_RECEBEU_AR_NP()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Documento Rec. AR</b>"
						+ "<br>" + param.get(0).getDOCUMENTO_RECEBEU_AR_NP() + "&nbsp;</div></div>");

		html.append("</div></div></body></html>");

		String arquivo = "";
		String nomeArquivo = "recebimentoArPenalidade" + param.get(0).getCpfCondutor() + "";
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
