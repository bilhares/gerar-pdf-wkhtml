package br.com.psg.entities;

public class PontuacaoHistorico {
	private String REGISTRO;
	private String AUTO_EXTRATO;
	private String CLASSIFICACAO_MULTA;
	private String PONTO;
	private String CPF;
	private String REFERENTE;
	private String TIPO_PROC;
	private String TIPO_REG;
	private String ARTIGO;
	private String PROCESSO;
	private String NOME;
	private String PGU;
	private String DATA_INFRACAO;
	private String VALIDADE_DATA;
	private String TOTAL_PONTOS;
	

	public String getTOTAL_PONTOS() {
		return TOTAL_PONTOS;
	}

	public void setTOTAL_PONTOS(String tOTAL_PONTOS) {
		TOTAL_PONTOS = tOTAL_PONTOS;
	}

	public String getDATA_INFRACAO() {
		return DATA_INFRACAO;
	}

	public void setDATA_INFRACAO(String dATA_INFRACAO) {
		DATA_INFRACAO = dATA_INFRACAO;
	}

	public String getVALIDADE_DATA() {
		return VALIDADE_DATA;
	}

	public void setVALIDADE_DATA(String vALIDADE_DATA) {
		VALIDADE_DATA = vALIDADE_DATA;
	}

	public String getREGISTRO() {
		return REGISTRO;
	}

	public void setREGISTRO(String rEGISTRO) {
		REGISTRO = rEGISTRO;
	}

	public String getAUTO_EXTRATO() {
		return AUTO_EXTRATO;
	}

	public void setAUTO_EXTRATO(String aUTO_EXTRATO) {
		AUTO_EXTRATO = aUTO_EXTRATO;
	}

	public String getCLASSIFICACAO_MULTA() {
		return CLASSIFICACAO_MULTA;
	}

	public void setCLASSIFICACAO_MULTA(String cLASSIFICACAO_MULTA) {
		CLASSIFICACAO_MULTA = cLASSIFICACAO_MULTA;
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

	public String getREFERENTE() {
		return REFERENTE;
	}

	public void setREFERENTE(String rEFERENTE) {
		REFERENTE = rEFERENTE;
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

	public String getARTIGO() {
		return ARTIGO;
	}

	public void setARTIGO(String aRTIGO) {
		ARTIGO = aRTIGO;
	}

	public String getPROCESSO() {
		return PROCESSO;
	}

	public void setPROCESSO(String pROCESSO) {
		PROCESSO = pROCESSO;
	}

	public String getNOME() {
		return NOME;
	}

	public void setNOME(String nOME) {
		NOME = nOME;
	}

	public String getPGU() {
		return PGU;
	}

	public void setPGU(String pGU) {
		PGU = pGU;
	}
}
