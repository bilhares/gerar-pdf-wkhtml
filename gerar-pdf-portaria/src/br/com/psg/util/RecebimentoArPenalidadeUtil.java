package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.HistoricoPontuacao;
import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.entities.RecebimentoArPenalidade;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.HistorioPontuacaoDoc;
import br.com.psg.registros.PontuacaoHistoricoDoc;
import br.com.psg.registros.RecebimentoArPenalidadeDoc;

public class RecebimentoArPenalidadeUtil {
	RecebimentoArPenalidadeDoc cons;
	GerarPdfUtilRegistros util;

	public RecebimentoArPenalidadeUtil() {
		cons = new RecebimentoArPenalidadeDoc();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<RecebimentoArPenalidade> param) {	
		String dados = cons.gerarHtmlRecebimentoArPenalidadeDoc(param);
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
