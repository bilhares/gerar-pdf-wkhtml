package br.com.psg.util;

import java.util.List;

import br.com.psg.entities.CadastroCondutor;
import br.com.psg.entities.Retorno;
import br.com.psg.registros.ConsultaDadosCondutor;

public class ConsDadosCondutorUtil {
	ConsultaDadosCondutor cons;
	GerarPdfUtilRegistros util;

	public ConsDadosCondutorUtil() {
		cons = new ConsultaDadosCondutor();
		util = new GerarPdfUtilRegistros();
	}

	public Retorno gerarDocumentos(List<CadastroCondutor> param) {	
		String dados = cons.gerarHtmlConsultaDadosCondutor(param.get(0));
		Retorno documento = util.gerarPdf(dados);
		return documento;
	}
}
