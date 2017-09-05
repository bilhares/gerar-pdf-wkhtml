package br.com.psg.entities;

public class Retorno {
	private String despacho;
	private String portaria;

	private byte[] byteDespacho;
	private byte[] bytePortaria;
	private byte[] byteDespachoInst;

	private byte[] byteRegistro;

	private byte[] byteCertidao;

	public byte[] getByteCertidao() {
		return byteCertidao;
	}

	public void setByteCertidao(byte[] byteCertidao) {
		this.byteCertidao = byteCertidao;
	}

	public byte[] getByteRegistro() {
		return byteRegistro;
	}

	public void setByteRegistro(byte[] byteRegistro) {
		this.byteRegistro = byteRegistro;
	}

	public String getDespacho() {
		return despacho;
	}

	public void setDespacho(String despacho) {
		this.despacho = despacho;
	}

	public String getPortaria() {
		return portaria;
	}

	public void setPortaria(String portaria) {
		this.portaria = portaria;
	}

	public byte[] getByteDespacho() {
		return byteDespacho;
	}

	public void setByteDespacho(byte[] byteDespacho) {
		this.byteDespacho = byteDespacho;
	}

	public byte[] getBytePortaria() {
		return bytePortaria;
	}

	public void setBytePortaria(byte[] bytePortaria) {
		this.bytePortaria = bytePortaria;
	}

	public byte[] getByteDespachoInst() {
		return byteDespachoInst;
	}

	public void setByteDespachoInst(byte[] byteDespachoInst) {
		this.byteDespachoInst = byteDespachoInst;
	}

}
