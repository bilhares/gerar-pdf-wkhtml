package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.CadastroCondutor;
import br.com.psg.entities.HistoricoPontuacao;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.ConsultaDadosCondutor;
import br.com.psg.registros.HistorioPontuacaoDoc;

public class HistoricoPontuacaoUtil {
	HistorioPontuacaoDoc cons;
	GerarPdfUtilRegistros util;

	public HistoricoPontuacaoUtil() {
		cons = new HistorioPontuacaoDoc();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<HistoricoPontuacao> param) {	
		String dados = cons.gerarHtmlHistorioPontuacao(param);
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
