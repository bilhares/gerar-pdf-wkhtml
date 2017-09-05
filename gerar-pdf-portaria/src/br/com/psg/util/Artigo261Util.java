package br.com.psg.util;

import java.util.HashMap;
import java.util.Map;

import br.com.psg.artigos.Artigo261Despacho;
import br.com.psg.artigos.Artigo261Portaria;
import br.com.psg.artigos.DespachoInstauracaoProcessoAdm;
import br.com.psg.artigos.PortariaDefault;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.CertidaoConsolidacaoAutoInfra;

public class Artigo261Util {
	Artigo261Despacho despacho261;
	Artigo261Portaria portaria261;
	PortariaDefault portariaDef;
	GerarPdfUtilByteArray util;
	DespachoInstauracaoProcessoAdm despachoInst;
	CertidaoConsolidacaoAutoInfra certidaoCons;

	public Artigo261Util() {
		despacho261 = new Artigo261Despacho();
		portaria261 = new Artigo261Portaria();
		portariaDef = new PortariaDefault();
		util = new GerarPdfUtilByteArray();
		despachoInst = new DespachoInstauracaoProcessoAdm();
		certidaoCons = new CertidaoConsolidacaoAutoInfra();
	}

	public Retorno gerarDocumentos261(Parametro param) {
		String despacho = despacho261.gerarPdf261DespachoInstauracao(param);
		//String portaria = portaria261.gerarPdf261Portaria(param);
		String portaria = portariaDef.gerarPdfDefaultPortaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria,despachoInstauracao,certidao);

		return docs;
	}
}
