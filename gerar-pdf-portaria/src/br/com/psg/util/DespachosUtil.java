package br.com.psg.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import br.com.psg.despachos.DespachoProvimentoDefesa;
import br.com.psg.despachos.relatorioDefesa;
import br.com.psg.entities.Despachos;
import br.com.psg.entities.Retorno;

public class DespachosUtil {
	String despachoNome = "";
	GerarPdfUtilByteArray util;

	public DespachosUtil() {
		util = new GerarPdfUtilByteArray();
	}

	public Retorno gerarDespachoPdf(Object tipo, Despachos despacho) {

		Class<?> c = tipo.getClass();

		for (Method m : c.getMethods()) {

			if (m.getName().startsWith("gerar")) {
				try {
					if (m.getParameters().length>0) {
						despachoNome = (String) m.invoke(c.newInstance(), despacho);
					} else {
						despachoNome = (String) m.invoke(c.newInstance());
					}
					System.out.println("Nome: " + despachoNome);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		Retorno docs = util.gerarPdf(despachoNome, null, null, null);
		return docs;
	}

	public static void main(String[] args) {
		// DespachosUtil util = new DespachosUtil();
		// Despachos despacho = new Despachos();
		// despacho.setArtigo("148");
		// despacho.setArtigoNegocio("111");
		// despacho.setCpfCondutor("");
		// despacho.setNomeCondutor(" ");
		// despacho.setNumProcesso(" ");
		// despacho.setPontuacao(" ");
		// util.gerarDespachoPdf(new DespachoProvimentoDefesa(), despacho);
	}
}
