package br.com.psg.entities;

public class Despachos {

	private String nomeCondutor;
	private String tipoRegistro;
	private String cpfCondutor;
	private String artigo;
	private String artigoNegocio;
	private String pontuacao;
	private String numProcesso;
	private String numProcessoBPM;
	private String resultadoJulgamento;
	private String codEtapa;
	private String relator;
	private String gerarDoc;
	private String grupo;
	private int codCiclo;
	

	public int getCodCiclo() {
		return codCiclo;
	}

	public void setCodCiclo(int codCiclo) {
		this.codCiclo = codCiclo;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getNumProcessoBPM() {
		return numProcessoBPM;
	}

	public void setNumProcessoBPM(String numProcessoBPM) {
		this.numProcessoBPM = numProcessoBPM;
	}

	public String getRelator() {
		return relator;
	}

	public void setRelator(String relator) {
		this.relator = relator;
	}

	public String getGerarDoc() {
		return gerarDoc;
	}

	public void setGerarDoc(String gerarDoc) {
		this.gerarDoc = gerarDoc;
	}

	public String getNomeCondutor() {
		return nomeCondutor;
	}

	public void setNomeCondutor(String nomeCondutor) {
		this.nomeCondutor = nomeCondutor;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public String getCpfCondutor() {
		return cpfCondutor;
	}

	public void setCpfCondutor(String cpfCondutor) {
		this.cpfCondutor = cpfCondutor;
	}

	public String getArtigo() {
		return artigo;
	}

	public void setArtigo(String artigo) {
		this.artigo = artigo;
	}

	public String getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(String pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(String numProcesso) {
		this.numProcesso = numProcesso;
	}

	public String getResultadoJulgamento() {
		return resultadoJulgamento;
	}

	public void setResultadoJulgamento(String resultadoJulgamento) {
		this.resultadoJulgamento = resultadoJulgamento;
	}

	public String getArtigoNegocio() {
		return artigoNegocio;
	}

	public void setArtigoNegocio(String artigoNegocio) {
		this.artigoNegocio = artigoNegocio;
	}

	public String getCodEtapa() {
		return codEtapa;
	}

	public void setCodEtapa(String codEtapa) {
		this.codEtapa = codEtapa;
	}

}
