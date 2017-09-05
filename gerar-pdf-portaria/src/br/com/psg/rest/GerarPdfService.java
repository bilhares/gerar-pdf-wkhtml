package br.com.psg.rest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.psg.controller.ArtigoController;
import br.com.psg.controller.DespachoController;
import br.com.psg.entities.CadastroCondutor;
import br.com.psg.entities.ConsultaAutoInfraConCai;
import br.com.psg.entities.Despachos;
import br.com.psg.entities.HistoricoPontuacao;
import br.com.psg.entities.HistoricoRecursoMulta;
import br.com.psg.entities.Parametro;
import br.com.psg.entities.PontuacaoHistorico;
import br.com.psg.entities.RecebimentoArPenalidade;
import br.com.psg.entities.Retorno;
import br.com.psg.util.ConCaiUtil;
import br.com.psg.util.ConsDadosCondutorUtil;
import br.com.psg.util.HistoricoPontuacaoUtil;
import br.com.psg.util.InformacoesRecursoUtil;
import br.com.psg.util.PontuacaoHistorioUtil;
import br.com.psg.util.RecebimentoArPenalidadeUtil;

@Path("/gerar-pdf")
public class GerarPdfService {
	private static final String CHARSET_UTF_8 = ";charset=utf-8";
	ArtigoController controller;
	ConsDadosCondutorUtil reg3Util;
	HistoricoPontuacaoUtil reg4Util;
	PontuacaoHistorioUtil reg5Util;
	InformacoesRecursoUtil reg6Util;
	RecebimentoArPenalidadeUtil reg7Util;
	ConCaiUtil concaiUtil;
	DespachoController despachoController;

	@PostConstruct
	private void init() {
		controller = new ArtigoController();
		despachoController = new DespachoController();
		reg3Util = new ConsDadosCondutorUtil();
		reg4Util = new HistoricoPontuacaoUtil();
		reg5Util = new PontuacaoHistorioUtil();
		reg6Util = new InformacoesRecursoUtil();
		reg7Util = new RecebimentoArPenalidadeUtil();
		concaiUtil = new ConCaiUtil();
	}

	@POST
	@Path("/gerar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String gerarPdf(Parametro param) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.toJson(controller.route(param));
	}

	@POST
	@Path("/gerar-registro/ConCAI")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarConcai(List<ConsultaAutoInfraConCai> param) {
		Retorno ret = concaiUtil.gerarDocumentos(param);
		return ret;
	}

	@POST
	@Path("/gerar-registro/3")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarRegistro3(List<CadastroCondutor> param) {
		Retorno ret = reg3Util.gerarDocumentos(param);
		return ret;
	}

	@POST
	@Path("/gerar-registro/4")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarRegistro4(List<HistoricoPontuacao> param) {
		Retorno ret = reg4Util.gerarDocumentos(param);
		return ret;
	}

	@POST
	@Path("/gerar-registro/5")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarRegistro5(List<PontuacaoHistorico> param) {
		Retorno ret = reg5Util.gerarDocumentos(param);
		return ret;
	}

	@POST
	@Path("/gerar-registro/6")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarRegistro6(List<HistoricoRecursoMulta> param) {
		Retorno ret = reg6Util.gerarDocumentos(param);
		return ret;
	}

	@POST
	@Path("/gerar-registro/7")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Retorno gerarRegistro7(List<RecebimentoArPenalidade> param) {
		Retorno ret = reg7Util.gerarDocumentos(param);
		return ret;
	}

	@GET
	@Path("/get-byte")
	@Produces("application/pdf")
	public Response getArquivo() throws IOException {
		java.nio.file.Path p = Paths.get("c:/templates-despacho-portaria/pdf/portaria-148-38624743133.pdf");
		byte[] data = Files.readAllBytes(p);
		InputStream inStream = new ByteArrayInputStream(data);
		return Response.status(Status.OK).header("Content-Disposition", "filename=doc.pdf").entity(inStream).build();
	}

	@POST
	@Path("/get-byte")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Retorno> gerarPdfByte(Parametro param) throws IOException {
		List<Retorno> bytes = controller.routeByte(param);
		return bytes;
	}
	@POST
	@Path("/get-despacho")
	@Consumes(MediaType.APPLICATION_JSON+ CHARSET_UTF_8)
	public Long gerarPdfByte(Despachos param) throws IOException {
		return despachoController.route(param);
		 
	}
	
	
}
