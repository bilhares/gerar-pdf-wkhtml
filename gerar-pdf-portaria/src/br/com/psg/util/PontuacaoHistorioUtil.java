package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.HistoricoPontuacao;
import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.HistorioPontuacaoDoc;
import br.com.psg.registros.PontuacaoHistoricoDoc;

public class PontuacaoHistorioUtil {
	PontuacaoHistoricoDoc cons;
	GerarPdfUtilRegistros util;

	public PontuacaoHistorioUtil() {
		cons = new PontuacaoHistoricoDoc();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<PontuacaoHistorico> param) {	
		String dados = cons.gerarHtmlPontuacaoHistoricoDoc(param);
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
