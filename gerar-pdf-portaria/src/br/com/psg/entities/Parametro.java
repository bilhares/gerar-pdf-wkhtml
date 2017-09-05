package br.com.psg.entities;

import java.util.List;

public class Parametro {

	private String ARTIGO_INCISO_WORK;
	private String ARTIGO_COMPLETO;
	private String NOME_WORK;
	private String CPF_WORK;
	private String DATA_CADASTRO_WORK;
	private String NUM_PORTARIA;
	private String ANO_PORTARIA;
	private String NUMERO_CNH_WORK;
	private String NUMERO_REGISTRO_WORK;
	private String TIPO_PROC_WORK;
	private List<String> AUTO;
	
	public String getARTIGO_COMPLETO() {
		return ARTIGO_COMPLETO;
	}

	public void setARTIGO_COMPLETO(String aRTIGO_COMPLETO) {
		ARTIGO_COMPLETO = aRTIGO_COMPLETO;
	}

	public String getTIPO_PROC_WORK() {
		return TIPO_PROC_WORK;
	}

	public void setTIPO_PROC_WORK(String tIPO_PROC_WORK) {
		TIPO_PROC_WORK = tIPO_PROC_WORK;
	}

	public String getARTIGO_INCISO_WORK() {
		return ARTIGO_INCISO_WORK;
	}

	public void setARTIGO_INCISO_WORK(String aRTIGO_INCISO_WORK) {
		ARTIGO_INCISO_WORK = aRTIGO_INCISO_WORK;
	}

	public String getNOME_WORK() {
		return NOME_WORK;
	}

	public void setNOME_WORK(String nOME_WORK) {
		NOME_WORK = nOME_WORK;
	}

	public String getCPF_WORK() {
		return CPF_WORK;
	}

	public void setCPF_WORK(String cPF_WORK) {
		CPF_WORK = cPF_WORK;
	}

	public String getDATA_CADASTRO_WORK() {
		return DATA_CADASTRO_WORK;
	}

	public void setDATA_CADASTRO_WORK(String dATA_CADASTRO_WORK) {
		DATA_CADASTRO_WORK = dATA_CADASTRO_WORK;
	}

	public String getNUM_PORTARIA() {
		return NUM_PORTARIA;
	}

	public void setNUM_PORTARIA(String nUM_PORTARIA) {
		NUM_PORTARIA = nUM_PORTARIA;
	}

	public String getANO_PORTARIA() {
		return ANO_PORTARIA;
	}

	public void setANO_PORTARIA(String aNO_PORTARIA) {
		ANO_PORTARIA = aNO_PORTARIA;
	}

	public String getNUMERO_CNH_WORK() {
		return NUMERO_CNH_WORK;
	}

	public void setNUMERO_CNH_WORK(String nUMERO_CNH_WORK) {
		NUMERO_CNH_WORK = nUMERO_CNH_WORK;
	}

	public String getNUMERO_REGISTRO_WORK() {
		return NUMERO_REGISTRO_WORK;
	}

	public void setNUMERO_REGISTRO_WORK(String nUMERO_REGISTRO_WORK) {
		NUMERO_REGISTRO_WORK = nUMERO_REGISTRO_WORK;
	}

	public List<String> getAUTO() {
		return AUTO;
	}

	public void setAUTO(List<String> aUTO) {
		AUTO = aUTO;
	}

}
