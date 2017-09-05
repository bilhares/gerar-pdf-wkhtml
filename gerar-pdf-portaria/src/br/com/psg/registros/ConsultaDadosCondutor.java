package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.CadastroCondutor;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class ConsultaDadosCondutor {
	public String gerarHtmlConsultaDadosCondutor(CadastroCondutor param) {
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
		// cabe�alho
		html.append("<div class=\"titulo\">Consulta de Dados do Condutor</div>"
				+ "<div class=\"subtitulo\" style=\"float: left;\"> -" + DataUtil.dataAtualExtenso() + "</div>"
				+ "<div class=\"subtitulo\" style=\"float: right; margin-right: 2em;\">Número do Processo:"
				+ param.getPROCESSO() + "</div> "
				+ "<div style=\"clear: both; float: none; margin-top: 3em;\">");

		html.append(
				"<p class=\"titulo\">Dados do Condutor</p><div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\">"
						+ "<b>Renach</b><br>" + param.getNUMERO_FORMULARIO()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Registro</b>"
						+ "<br>" + param.getNUMERO_REGISTRO()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CPF</b>" + "<br>"
						+ param.getCPF() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>P.G.U.</b>"
				+ "<br>" + param.getNUMERO_PGU()
				+ "&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Nº CNH</b><br>"
				+ param.getNUMERO_CNH() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Nacionalidade</b><br>"
				+ param.getNACIONALIDADE() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Nome</b><br>"
				+ param.getNOME_CONDUTOR() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 19.02em; display: block\"><b>Sexo</b><br>" + param.getSEXO()
				+ "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Mãe</b><br>"
				+ param.getNOME_MAE() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 19.02em; display: block\"><b>1° categ.</b><br>"
				+ param.getCATEGORIA_HABILITACAO() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Pai</b><br>"
				+ param.getNOME_PAI() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 19.02em; display: block\"><b>Emis.def.</b><br>"
				+ param.getEMISSAO_DEFINITIVA() + "&nbsp;</div></div>");

		html.append(
				" <div class=\"linha\"><div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Documento</b><br>"
						+ param.getDOCUMENTO() + "&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 19.02em; display: block\"><b>Data 155</b><br>"
						+ param.getDATA_155() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Local</b><br>"
				+ param.getLOCAL_RESIDENCIA() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Data atualização</b><br>"
				+ param.getDATA_ATUALIZACAO() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Transação</b><br>"
				+ param.getCOD_ULTIMA_TRANSACAO() + "&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Nascimento</b><br>"
						+ param.getDATA_NASCIMENTO() + "&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Munic Nasc.</b><br>"
						+ param.getMUNICIPIO_NASCIMENTO() + "&nbsp;</div></div>");

		html.append("<p class=\"titulo\">Dados da CNH</p>"
				+ "<div class=\"linha\"><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Categoria atual</b><br>"
				+ param.getCATEGORIAL_ATUAL() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Validade</b><br>"
				+ param.getVALIDADE_CNH() + "&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Val.def.</b><br>"
				+ param.getVALIDADE_DEFINITIVA() + "&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Data 1° Habil</b><br>"
						+ param.getDATA_PRIMEIRA_HABILITACAO() + "&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>UF</b><br>"
						+ param.getUF_PRIMEIRA_HABILITACAO()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 15.15em; display: block\">"
						+ "<b>UF Transf</b><br>" + param.getUF_EFETUOU_TRANSFERENCIA()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Sit</b><br>"
						+ param.getSITUACAO_CNH() + "&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Processo SIHAB</b><br>"
						+ param.getPROCECESSO_SIHAB() + "&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Obs</b><br>"
						+ param.getOBSERVACAO() + "&nbsp;</div></div>");

		html.append(
				"<p class=\"titulo\">Dados de Endereço</p><div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Logradouro</b>"
						+ "<br>" + param.getLOGRADOURO_RESIDENCIA()
						+ "&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Complemento</b><br>"
						+ param.getLOGRADOURO_COMPLEMENTO() + "&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Município</b><br>"
						+ param.getMUNICIPIO() + "&nbsp;</div></div>");

		html.append("<div class=\"linha\"><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Bairro</b><br>"
				+ param.getBAIRRO() + "&nbsp;"
				+ "</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>CEP</b><br>"+param.getCEP()+"&nbsp;</div></div>");

		html.append(
				"<div class=\"linha\"><div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Telefone</b><br>"
						+ param.getNUMERO_TELEFONE() + "&nbsp;</div></div>");
		html.append(" </div></div></body></html>");

		String arquivo = "";
		String nomeArquivo = "consDadoCondutor" + param.getCPF().trim() + "";
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
