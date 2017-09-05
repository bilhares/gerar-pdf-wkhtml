/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.psg.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fsalles
 */
@Entity
@Table(name = "psg_assinatura_digital")
public class Credencial {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "COD_USUARIO")
    private int codUsuario;
    @Column(name = "COD_FORMULARIO")
    private int codFormulario;
    @Column(name = "COD_PROCESSO")
    private int codProcesso;
    @Column(name = "COD_ETAPA")
    private int codEtapa;
    @Column(name = "COD_CICLO")
    private int codCiclo;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;
    @Column(name = "DIRETORIO")
    private String diretorio;
    @Column(name = "DIRETORIO_ASSINADOS")
    private String diretorioAssinado;
    @Column(name = "NOME_FORM")
    private String nomeModelo;
    @Column(name = "NOME_ETAPA")
    private String nomeEtapa;
    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;
    @Column(name = "NOME_ANEXO")
    private String nomeAnexo;
    @Column(name = "TIPO_REGISTRO")
    private String tipoRegistro;

    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodFormulario() {
        return codFormulario;
    }

    public void setCodFormulario(int codFormulario) {
        this.codFormulario = codFormulario;
    }

    public int getCodProcesso() {
        return codProcesso;
    }

    public void setCodProcesso(int codProcesso) {
        this.codProcesso = codProcesso;
    }

    public int getCodEtapa() {
        return codEtapa;
    }

    public void setCodEtapa(int codEtapa) {
        this.codEtapa = codEtapa;
    }

    public int getCodCiclo() {
        return codCiclo;
    }

    public void setCodCiclo(int codCiclo) {
        this.codCiclo = codCiclo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeAnexo() {
        return nomeAnexo;
    }

    public void setNomeAnexo(String nomeAnexo) {
        this.nomeAnexo = nomeAnexo;
    }

    public String getDiretorioAssinado() {
        return diretorioAssinado;
    }

    public void setDiretorioAssinado(String diretorioAssinado) {
        this.diretorioAssinado = diretorioAssinado;
    }

}
