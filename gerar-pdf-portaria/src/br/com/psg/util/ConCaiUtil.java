package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.ConsultaAutoInfraConCai;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.ConsultaAultoDeInfracao;

public class ConCaiUtil {
	ConsultaAultoDeInfracao cons;
	GerarPdfUtilRegistros util;

	public ConCaiUtil() {
		cons = new ConsultaAultoDeInfracao();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<ConsultaAutoInfraConCai> param) {
		String dados = cons.gerarHtmlConsultaAutoInfra(param);
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
