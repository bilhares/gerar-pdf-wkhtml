package br.com.psg.util;

import java.util.HashMap;
import java.util.Map;

import br.com.psg.artigos.Artigo165Portaria;
import br.com.psg.artigos.DespachoDefault;
import br.com.psg.artigos.DespachoInstauracaoProcessoAdm;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.CertidaoConsolidacaoAutoInfra;

public class Artigo165Util {
	DespachoDefault despachoDef;
	Artigo165Portaria portaria165;
	GerarPdfUtilByteArray util;
	DespachoInstauracaoProcessoAdm despachoInst;
	CertidaoConsolidacaoAutoInfra certidaoCons;

	public Artigo165Util() {
		despachoDef = new DespachoDefault();
		portaria165 = new Artigo165Portaria();
		despachoInst = new DespachoInstauracaoProcessoAdm();
		util = new GerarPdfUtilByteArray();
		certidaoCons = new CertidaoConsolidacaoAutoInfra();
	}

	public Retorno gerarDocumentos165(Parametro param) {
		String despacho = despachoDef.gerarPdfDespachoDefault(param);
		String portaria = portaria165.gerarPdf165Portaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria, despachoInstauracao, certidao);

		return docs;
	}
}
