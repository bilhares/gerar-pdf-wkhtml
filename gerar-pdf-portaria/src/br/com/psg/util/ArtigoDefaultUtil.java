package br.com.psg.util;

import br.com.psg.artigos.DespachoDefault;
import br.com.psg.artigos.DespachoInstauracaoProcessoAdm;
import br.com.psg.artigos.PortariaDefault;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.CertidaoConsolidacaoAutoInfra;

public class ArtigoDefaultUtil {
	DespachoDefault despachoDef;
	PortariaDefault portariaDef;
	GerarPdfUtilByteArray util;
	DespachoInstauracaoProcessoAdm despachoInst;
	CertidaoConsolidacaoAutoInfra certidaoCons;

	public ArtigoDefaultUtil() {
		despachoDef = new DespachoDefault();
		portariaDef = new PortariaDefault();
		util = new GerarPdfUtilByteArray();
		despachoInst = new DespachoInstauracaoProcessoAdm();
		certidaoCons = new CertidaoConsolidacaoAutoInfra();
	}

	public Retorno gerarDocumentosDefault(Parametro param) {
		String despacho = despachoDef.gerarPdfDespachoDefault(param);
		String portaria = portariaDef.gerarPdfDefaultPortaria(param);
		String despachoInstauracao = despachoInst.gerarPdfDespachoInstauracaoProcessoAdm(param);
		String certidao = certidaoCons.gerarHtmlCertidaoConsolidacaoAutoInfra();

		Retorno docs = util.gerarPdf(despacho, portaria, despachoInstauracao, certidao);

		return docs;
	}
}
