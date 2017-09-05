package br.com.psg.util;

import java.util.HashMap;
import java.util.Map;

import br.com.psg.artigos.Artigo148Despacho;
import br.com.psg.artigos.Artigo148Portaria;
import br.com.psg.artigos.DespachoInstauracaoProcessoAdm;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.CertidaoConsolidacaoAutoInfra;

public class Artigo148Util {
	
	Artigo148Despacho despacho148;
	Artigo148Portaria portaria148;
	DespachoInstauracaoProcessoAdm despachoInst;
	CertidaoConsolidacaoAutoInfra certidaoCons;
	GerarPdfUtilByteArray util;

	public Artigo148Util() {
		despacho148 = new Artigo148Despacho();
		portaria148 = new Artigo148Portaria();
		despachoInst = new DespachoInstauracaoProcessoAdm();
		util = new GerarPdfUtilByteArray();
		certidaoCons = new CertidaoConsolidacaoAutoInfra();
	}

	public Retorno gerarDocumentos148(Parametro param) {
		String despacho = despacho148.gerarPdf148DespachoInstauracao(param);		
		String portaria = portaria148.gerarPdf148Portaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria,despachoInstauracao,certidao);

		return docs;
	}
}
