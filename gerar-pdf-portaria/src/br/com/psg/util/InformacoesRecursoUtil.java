package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.HistoricoPontuacao;
import br.com.psg.entities.HistoricoRecursoMulta;
import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.HistorioPontuacaoDoc;
import br.com.psg.registros.InformacoesRecursoDoc;
import br.com.psg.registros.PontuacaoHistoricoDoc;

public class InformacoesRecursoUtil {
	InformacoesRecursoDoc cons;
	GerarPdfUtilRegistros util;

	public InformacoesRecursoUtil() {
		cons = new InformacoesRecursoDoc();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<HistoricoRecursoMulta> param) {
		String dados = cons.gerarHtmlInformacoesRecursoDoc(param);
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
