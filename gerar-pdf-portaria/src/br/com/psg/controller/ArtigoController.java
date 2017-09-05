package br.com.psg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.psg.artigos.*;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.Retorno;
import br.com.psg.util.Artigo148Util;
import br.com.psg.util.Artigo165Util;
import br.com.psg.util.Artigo261Util;
import br.com.psg.util.Artigo263Util;
import br.com.psg.util.ArtigoDefaultUtil;

public class ArtigoController {

	Artigo148Util util148;
	Artigo261Util util261;
	Artigo263Util util263;
	Artigo165Util util165;
	ArtigoDefaultUtil utilDefault;

	public ArtigoController() {

		util148 = new Artigo148Util();
		util261 = new Artigo261Util();
		util263 = new Artigo263Util();
		util165 = new Artigo165Util();
		utilDefault = new ArtigoDefaultUtil();
	}

	public List<Retorno> route(Parametro param) {
		List<Retorno> docs = new ArrayList<>();

		switch (param.getARTIGO_INCISO_WORK().trim()) {
		case "1483":
			docs.add(util148.gerarDocumentos148(param));
			break;
		case "261":
			docs.add(util261.gerarDocumentos261(param));
			break;
		case "263I":
			docs.add(util263.gerarDocumentos263I(param));
			break;
		case "263II":
			docs.add(util263.gerarDocumentos263II(param));
			break;
		case "165":
			docs.add(util165.gerarDocumentos165(param));
			break;
		default:
			docs.add(utilDefault.gerarDocumentosDefault(param));
			break;
		}

		return docs;
	}

	public List<Retorno> routeByte(Parametro param) {
		List<Retorno> docs = new ArrayList<>();
		
		String artigoComParagrafo = getArtigoComParagrafo(param.getARTIGO_COMPLETO());
		
		System.out.println(artigoComParagrafo);
		
		param.setARTIGO_COMPLETO(artigoComParagrafo);
		
		switch (param.getARTIGO_INCISO_WORK().trim().replaceAll(" ", "")) {
		case "148":
			docs.add(util148.gerarDocumentos148(param));
			break;
		case "261":
			docs.add(util261.gerarDocumentos261(param));
			break;
		case "263I":
			docs.add(util263.gerarDocumentos263I(param));
			break;
		case "263II":
			docs.add(util263.gerarDocumentos263II(param));
			break;
		case "165":
			docs.add(util165.gerarDocumentos165(param));
			break;
		default:
			docs.add(utilDefault.gerarDocumentosDefault(param));
			break;
		}

		return docs;
	}
	
	public String getArtigoComParagrafo(String artigo){
		String retorno = "";
		if(artigo.startsWith("0")){
			if(artigo.contains("148")){
				retorno = artigo.substring(1,4)+" § "+artigo.substring(4,5)+"° § "+artigo.substring(6,7)+"°";
			}else{
				retorno =  artigo.substring(1,4)+" § "+artigo.substring(4,5)+"°"+artigo.substring(6,20);
			}
		}else{
			retorno = artigo;
		}
		return retorno;
	}
	
	
//	public static void main(String[] args) {
//		ArtigoController artigoController = new ArtigoController();
//		
//	//System.out.println(artigoController.getArtigoComParagrafo("01483 4                                                                         "));
//	//System.out.println(artigoController.getArtigoComParagrafo("02611                                                                              "));
//	System.out.println(artigoController.getArtigoComParagrafo("263 I                                                                          "));
//	}
}
