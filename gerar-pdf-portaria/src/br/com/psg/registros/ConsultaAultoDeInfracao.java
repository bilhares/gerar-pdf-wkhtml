package br.com.psg.registros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import br.com.psg.entities.ConsultaAutoInfraConCai;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class ConsultaAultoDeInfracao {
	public String gerarHtmlConsultaAutoInfra(List<ConsultaAutoInfraConCai> param) {
		//FileUtil.criarPastas();
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
		
		html.append("<div class=\"titulo\">Consulta do Auto de Infração</div>");
		html.append(
				" <div class=\"subtitulo\" style=\"float: left;\">Transação CON-CAI - Administrador do Sistema -"+DataUtil.dataAtualExtenso()+"</div>");
		html.append(
				"<div class=\"subtitulo\" style=\"float: right; margin-right: 2em;\">Número do Processo: "+param.get(0).getCodigoInfracao()+"</div>");
		html.append(" <div style=\"clear: both; float: none; margin-top: 3em;\">");
		html.append("  <div class=\"linha\">");

		// linha1
		html.append(" <div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Número do Auto</b>"
				+ "<br>"+param.get(0).getNumAutoRetorno()+"&nbsp;</div>");
		html.append("<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Código órgão Autuador</b>"
				+ "<br>"+param.get(0).getCodigoOrgaoAutuador()+"&nbsp;</div>");
		html.append("<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Renainf</b>" + "<br>"+param.get(0).getRenainf()+"&nbsp;</div>");
		html.append("<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Responsável pelos Pontos</b>"
				+ "<br>"+param.get(0).getResponsavelPontos()+"&nbsp;</div>");
		html.append("</div>");
		// linha2
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 6.06em; display: block\"><b>Placa</b>" + "<br>"+param.get(0).getPlaca()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 24.24em; display: block\"><b>Marca/Modelo do Veículo</b><br>"+param.get(0).getMarca()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 24.24em; display: block\"><b>Município do Veículo</b><br>"+param.get(0).getCodigoMunicipioVeiculo()+"&nbsp;</div>");
		html.append("<div class=\"esq4\" style=\"width: 6.06em; display: block\"><b>UF da Placa</b><br>"+param.get(0).getUfPlaca()+"&nbsp;</div>");
		html.append("</div>");
		// linha3
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 9.51em; display: block\"><b>Código da Infração</b><br>"+param.get(0).getCodigoInfracao()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 53.89em; display: block\"><b>Descrição da Multa</b><br>"+param.get(0).getDescricaoMulta()+"&nbsp;</div>");
		html.append("</div>");
		// linha4
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Valor da Infração</b><br>"+param.get(0).getValorInfracao()+"&nbsp;</div>");
		html.append(
				" <div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Tipo de Infração</b><br>"+param.get(0).getCodigoTipoInfracao()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 37.2em; display: block\"><b>Competência</b><br>"+param.get(0).getCompetencia()+"&nbsp;</div>");
		html.append("</div>");
		// linha5
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Data/Hora da Infração</b><br>"+param.get(0).getHoraInfracao()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Data Limite de Defesa</b><br>"+param.get(0).getDataLimiteDefesa()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Data da Emissão de Notificação</b><br>"+param.get(0).getDataEmissaoNotificacao()+"&nbsp;</div>");
		html.append(
				"<div class=\"esq4\" style=\"width: 15.15em; display: block\"><b>Data de Publicação D.O.</b><br>"+param.get(0).getDataPublicacaoDO()+"&nbsp;</div>");
		html.append("</div>");
		// linha6
		html.append("<div class=\"linha\">");
		html.append("<div class=\"esq4\" style=\"width: 38.04em; display: block\"><b>Local da Infração</b>"
				+ " <br>"+param.get(0).getLocalInfracao()+"&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 25.36em; display: block\"><b>Município da Infração</b>"
				+ "<br>"+param.get(0).getCodigoMunicipioInfracao()+"&nbsp;</div>");
		html.append("</div>");
		// linha7
		html.append("<div class=\"linha\">");
		html.append("<div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Velocidade Aferida</b>"
				+ "<br>"+param.get(0).getVelocidadeAferida()+"&nbsp;</div><div class=\"esq4\" style=\"width: 31em; display: block\"><b>Tipo de Autuador</b><br>"+param.get(0).getCodigoTipoAutuador()+"&nbsp;</div>"
				+ "<div class=\"esq4\" style=\"width: 18.6em; display: block\"><b>Código do Local Eletrônico</b><br>"+param.get(0).getCodigoLocalEletronico()+"&nbsp;</div>");
		html.append("</div>");
		// linha8
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 47.55em; display: block\"><b>Condutor</b><br>"+param.get(0).getCondutor()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 15.85em; display: block\"><b>Condutor Informado?</b><br>"+param.get(0).getCodutorInformado()+"&nbsp;</div>");
		html.append("</div>");
		// linha9
		html.append("<div class=\"linha\">");
		html.append(
				" <div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CPF do Condutor</b><br>39328015120&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\">"
						+ "<b>PGU/Registro do Condutor</b><br>"+param.get(0).getPguCondutor()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CNH do Condutor</b>"
						+ "<br>"+param.get(0).getCnhCondutor()+"&nbsp;</div>");
		html.append("</div>");
		// linha10
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 47.55em; display: block\"><b>Situação Atual</b><br>"+param.get(0).getSituacaoAutuacao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 15.85em; display: block\"><b>Código Renainf</b><br>"+param.get(0).getCodigoRenainf()+"&nbsp;</div>");
		html.append("</div>");
		// lina11
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 18.6em; display: block\"><b>Número da Guia de Pagamento</b><br>"+param.get(0).getNumeroGuiaPagamento()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 18.6em; display: block\"><b>Número da Guia de Penalidade</b><br>"+param.get(0).getNumeroGuiaPenalidade()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 24.8em; display: block\"><b>Informações sobre Excesso de Peso</b><br>"+param.get(0).getPeso()+"&nbsp;</div>");
		html.append("</div>");
		// linha12
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 47.55em; display: block\"><b>Status da Notificação</b><br>"+param.get(0).getStatusNotificacao1()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 15.85em; display: block\"><b>Data do Cadastramento</b><br>"+param.get(0).getDataCadastramento1()+"&nbsp;</div>");
		html.append("</div>");
		// linha13
		html.append(" <p class=\"titulo\">Informações do Responsável</p>");
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 19.02em; display: block\"><b>Tipo de Responsável</b><br>"+param.get(0).getTipoResponsavelInfracao()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Nome</b><br>"+param.get(0).getNomeResponsavel()+"&nbsp;</div>");
		html.append("</div>");
		// linha14
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Registro</b><br>"+param.get(0).getRegistroResponsavel()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>PGU</b>"
						+ "<br>"+param.get(0).getPguResponsavel()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>CPF</b><br>"+param.get(0).getCpfResponsavel()+"&nbsp;</div>");
		html.append("</div>");
		// linha15
		html.append("<p class=\"titulo\">Informações de Notificação</p>");
		html.append("<div class=\"linha\">");
		html.append(
				" <div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Status da Notificação</b><br>"+param.get(0).getStatusNotificacao2()+"&nbsp;</div>");
		html.append("</div>");
		// linha16
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Número do Objeto AR</b><br>"+param.get(0).getNumeroObjetoAR()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Número do Objeto NPA</b><br>"+param.get(0).getNumeroObjetoNPA()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 37.2em; display: block\"><b>Situação AR</b><br>"+param.get(0).getSituacaoAR()+"&nbsp;</div>");
		html.append("</div>");
		// linha17
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 44.38em; display: block\"><b>Nome do Recebedor AR</b><br>"+param.get(0).getNomeRecebedorAR()+"&nbsp;</div><div class=\"esq4\" style=\"width: 19.02em; display: block\">"
						+ "<b>Data de Recebimento AR</b><br>"+param.get(0).getDataRecebimentoAR()+"&nbsp;</div>");
		html.append("</div>");
		// linha18
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 22.19em; display: block\"><b>Documento de Recebimento AR</b><br>"+param.get(0).getDocumentoRecebimentoAR()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 41.21em; display: block\"><b>Encaminhado AR para</b><br>"+param.get(0).getEncaminhadoARPara()+"&nbsp;</div>");
		html.append("</div>");
		// linha19
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 26.66em; display: block\"><b>Logradouro</b><br>"+param.get(0).getLogradouro()+"&nbsp;</div><div class=\"esq4\" style=\"width: 8.68em; display: block\"><b>Número</b>"
						+ "<br>"+param.get(0).getNumeroLogradouro()+"&nbsp;</div><div class=\"esq4\" style=\"width: 26.66em; display: block\"><b>Complemento</b><br>"+param.get(0).getComplemento()+"&nbsp;</div>");
		html.append("</div>");
		// linha20
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 24.8em; display: block\"><b>bairro</b><br>"+param.get(0).getBairro()+"&nbsp;</div><div class=\"esq4\" style=\"width: 24.8em; display: block\"><b>cidade</b><br>"+param.get(0).getCidade()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>uf</b><br>"+param.get(0).getUf()+"&nbsp;</div>");
		html.append("</div>");
		// linha21
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>CEP</b><br>"+param.get(0).getCep()+"&nbsp;</div><div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>CPF/CNPJ</b>"
						+ "<br>"+param.get(0).getCpfCnpj()+"&nbsp;</div>");
		html.append("</div>");
		// linha22
		html.append("<p class=\"titulo\">Informações de Recurso</p>");
		html.append("<div class=\"linha\">");
		html.append(
				" <div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Situação do Recurso</b><br>"+param.get(0).getSituacaoRecurso()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Resultado do Recurso</b><br>"+param.get(0).getResultadoRecurso()+"&nbsp;</div>");
		html.append("</div>");
		// linha23
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 34.1em; display: block\"><b>Requerente Recurso</b><br>"+param.get(0).getRequerenteRecurso()+"&nbsp;</div><div class=\"esq4\" style=\"width: 12.4em; display: block\"><b>Data de Protocolo</b>"
						+ "<br>"+param.get(0).getDataProtocolo()+"&nbsp;</div><div class=\"esq4\" style=\"width: 15.5em; display: block\"><b>Número do Processo</b><br>"+param.get(0).getNumeroProcesso()+"&nbsp;</div>");
		html.append("</div>");
		// linha24
		html.append("  <p class=\"titulo\">Informações Complementares</p>");
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Código do Agente Autuador</b><br>"+param.get(0).getCodigoAgenteAutuador()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\">"
						+ "<b>Código do Usuário que Cadastrou</b><br>"+param.get(0).getCodigoUsuarioCadastrou()+"&nbsp;</div><div class=\"esq4\" style=\"width: 20.67em; display: block\"><b>Data/Hora de Cadastramento</b>"
						+ "<br>"+param.get(0).getDataCadastramento2()+"&nbsp;</div>");
		html.append("</div>");
		// linha25
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Identificação do Terminal que Cadastrou</b><br>"+param.get(0).getIdentificacaoTerminalCadastrou()+"&nbsp;</div>"
						+ "<div class=\"esq4\" style=\"width: 31.7em; display: block\"><b>Data Relatório de Publicação</b><br>"+param.get(0).getDataRelatorioPublicacao()+"&nbsp;</div>");
		html.append("</div>");
		// linha26
		html.append("<div class=\"linha\">");
		html.append(
				"<div class=\"esq4\" style=\"width: 64.8em; display: block\"><b>Informações sobre Cancelamento</b><br>&nbsp;</div>");
		html.append("</div>");
		html.append("</div>");
		html.append("</div>");
		html.append("</body>");
		html.append("</html>");

		String arquivo = "";
		String nomeArquivo = "autoInfracaoCONCAI";
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
