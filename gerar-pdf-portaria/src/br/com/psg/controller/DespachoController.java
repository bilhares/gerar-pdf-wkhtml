package br.com.psg.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.psg.dao.DocumentosDao;
import br.com.psg.despachos.AnaliseDefesa;
import br.com.psg.despachos.DefesaProvida;
import br.com.psg.despachos.DespachoImprovimento;
import br.com.psg.despachos.DespachoImprovimentoDefesa;
import br.com.psg.despachos.DespachoProvimentoDefesa;
import br.com.psg.despachos.DespachoRecurso;
import br.com.psg.despachos.Dicon148;
import br.com.psg.despachos.Dicon165;
import br.com.psg.despachos.Dicon165A;
import br.com.psg.despachos.Dicon261;
import br.com.psg.despachos.Dicon263;
import br.com.psg.despachos.DiconDefault;
import br.com.psg.despachos.DiconDirhabNaoConhecimento;
import br.com.psg.despachos.Dirae;
import br.com.psg.despachos.DirhabJariDentroDoPrazo;
import br.com.psg.despachos.DirhabJariEnvioDefesa;
import br.com.psg.despachos.DirhabRecursoImprovido;
import br.com.psg.despachos.DirhabRecursoProvido;
import br.com.psg.despachos.relatorioDefesa;
import br.com.psg.entities.Despachos;
import br.com.psg.entities.Retorno;
import br.com.psg.util.DespachosUtil;

public class DespachoController {
	private DespachosUtil despachosUitl;
	private DocumentosDao documentosDao;

	public DespachoController() {
		despachosUitl = new DespachosUtil();
		documentosDao = new DocumentosDao();
	}

	public Long route(Despachos param) {
		List<Retorno> docs = new ArrayList<>();
		switch (param.getCodEtapa().trim()) {
		case "10":
			docs.add(despachosUitl.gerarDespachoPdf(new relatorioDefesa(), param));
			break;
		case "11":
			docs.add(despachosUitl.gerarDespachoPdf(new DespachoProvimentoDefesa(), param));
			break;
		case "12":
			docs.add(despachosUitl.gerarDespachoPdf(new AnaliseDefesa(), param));
			break;
		case "13":
			docs.add(despachosUitl.gerarDespachoPdf(new DefesaProvida(), param));
			break;
		case "21":
			if (param.getResultadoJulgamento().equals("Recurso improvido")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DespachoImprovimentoDefesa(), param));
			}
			if (param.getResultadoJulgamento().equals("Não conhecimento")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DespachoRecurso(), param));
			}
			break;
		case "22":
			if (param.getResultadoJulgamento().equals("Recurso improvido")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DespachoImprovimento(), param));
			} else if (param.getResultadoJulgamento().equals("Não conhecimento")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DiconDirhabNaoConhecimento(), param));
			} else {
				docs.add(despachosUitl.gerarDespachoPdf(getPdfByArtigo(param.getArtigoNegocio().trim()), param));
			}
			break;
		case "23":
			docs.add(despachosUitl.gerarDespachoPdf(new Dirae(), param));
			break;
		case "32":
			docs.add(despachosUitl.gerarDespachoPdf(new DirhabJariDentroDoPrazo(), param));
			break;
		case "33":
			docs.add(despachosUitl.gerarDespachoPdf(new DirhabJariEnvioDefesa(), param));
			break;
		case "37":
			docs.add(despachosUitl.gerarDespachoPdf(new DirhabJariEnvioDefesa(), param));
			break;
		case "38":
			if (param.getResultadoJulgamento().equals("Recurso provido")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DirhabRecursoProvido(), param));
			}
			if (param.getResultadoJulgamento().equals("Recurso improvido")) {
				docs.add(despachosUitl.gerarDespachoPdf(new DirhabRecursoImprovido(), param));
			}
			break;
		default:
			break;
		}
		return documentosDao.salvarDocumentos(docs, param);
	}

	private Object getPdfByArtigo(String artigo) {
		Object o = null;
		switch (artigo) {
		case "148":
			o = new Dicon148();
			break;
		case "165":
			o = new Dicon165();
			break;
		case "165A":
			o = new Dicon165A();
			break;
		case "263":
			o = new Dicon263();
			break;
		case "261":
			o = new Dicon261();
			break;
		default:
			o = new DiconDefault();
			break;
		}
		return o;
	}
}
