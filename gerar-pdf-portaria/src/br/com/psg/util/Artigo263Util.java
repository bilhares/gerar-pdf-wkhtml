package br.com.psg.util;

import java.util.HashMap;
import java.util.Map;

import br.com.psg.artigos.Artigo263Despacho;
import br.com.psg.artigos.Artigo263IIPortaria;
import br.com.psg.artigos.Artigo263IPortaria;
import br.com.psg.artigos.DespachoInstauracaoProcessoAdm;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.CertidaoConsolidacaoAutoInfra;

public class Artigo263Util {

	Artigo263Despacho despacho263;
	Artigo263IPortaria portaria263I;
	Artigo263IIPortaria portaria263II;
	GerarPdfUtilByteArray util;
	DespachoInstauracaoProcessoAdm despachoInst;
	CertidaoConsolidacaoAutoInfra certidaoCons;

	public Artigo263Util() {
		despacho263 = new Artigo263Despacho();
		portaria263I = new Artigo263IPortaria();
		portaria263II = new Artigo263IIPortaria();
		util = new GerarPdfUtilByteArray();
		despachoInst = new DespachoInstauracaoProcessoAdm();
		certidaoCons = new CertidaoConsolidacaoAutoInfra();
	}

	public Retorno gerarDocumentos263I(Parametro param) {
		String despacho = despacho263.gerarPdf263DespachoInstauracao(param);
		String portaria = portaria263I.gerarPdf263Portaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria,despachoInstauracao,certidao);

		return docs;
	}

	public Retorno gerarDocumentos263II(Parametro param) {
		String despacho = despacho263.gerarPdf263DespachoInstauracao(param);
		String portaria = portaria263II.gerarPdf263Portaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria,despachoInstauracao,certidao);

		return docs;
	}

}
