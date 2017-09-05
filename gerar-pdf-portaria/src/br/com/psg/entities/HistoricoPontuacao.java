package br.com.psg.entities;

public class HistoricoPontuacao {
	private String INFRACAO;
	private String AUTO;
	private String PONTO;
	private String CPF;
	private String TIPO_PROC;
	private String TIPO_REG;
	private String PROCESSO;
	private String SITUACAO;
	private String NOME;
	private String DATA_INFRACAO;

	public String getDATA_INFRACAO() {
		return DATA_INFRACAO;
	}

	public void setDATA_INFRACAO(String dATA_INFRACAO) {
		DATA_INFRACAO = dATA_INFRACAO;
	}

	public String getINFRACAO() {
		return INFRACAO;
	}

	public void setINFRACAO(String iNFRACAO) {
		INFRACAO = iNFRACAO;
	}

	public String getAUTO() {
		return AUTO;
	}

	public void setAUTO(String aUTO) {
		AUTO = aUTO;
	}

	public String getPONTO() {
		return PONTO;
	}

	public void setPONTO(String pONTO) {
		PONTO = pONTO;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTIPO_PROC() {
		return TIPO_PROC;
	}

	public void setTIPO_PROC(String tIPO_PROC) {
		TIPO_PROC = tIPO_PROC;
	}

	public String getTIPO_REG() {
		return TIPO_REG;
	}

	public void setTIPO_REG(String tIPO_REG) {
		TIPO_REG = tIPO_REG;
	}

	public String getPROCESSO() {
		return PROCESSO;
	}

	public void setPROCESSO(String pROCESSO) {
		PROCESSO = pROCESSO;
	}

	public String getSITUACAO() {
		return SITUACAO;
	}

	public void setSITUACAO(String sITUACAO) {
		SITUACAO = sITUACAO;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}
}
