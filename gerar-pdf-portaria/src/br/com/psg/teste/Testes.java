package br.com.psg.teste;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.DatatypeConverter;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Testes {
	public static void main(String[] args) throws Exception {
		//
		// String data = "";
		//
		//
		//
		// byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary(data);
		// FileUtils.writeByteArrayToFile(new File("c:\\temp\\teste2.pdf"),
		// parseBase64Binary);

		// try {
		// // /C run and terminate
		// // /K run and return cmd log
		//
		// String command = "cmd /c start cmd.exe /C
		// c:/wkhtmltopdf/bin/wkhtmltopdf.exe
		// C:/xampp/htdocs/penalidade/despacho-148-05700000000.html
		// c:/wkhtmltopdf/bin/teste7.pdf";
		// Process child = Runtime.getRuntime().exec(command);
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		/*
		 * HttpClient client = HttpClientBuilder.create().build(); HttpPost
		 * request = new HttpPost(
		 * "http://localhost:8080/gerar-pdf-portaria/rest/gerar-pdf/get-byte");
		 * 
		 * StringEntity input = new
		 * StringEntity("{\n\t\"ARTIGO_INCISO_WORK\":\"263                 \",\n\t\"NOME_WORK\":\"ANDRE AURELIO CUNHA                     \",\n\t\"CPF_WORK\":\"38624743133\",\n\t\"DATA_CADASTRO_WORK\":\"12/06/2017\",\n\t\"NUM_PORTARIA\":\"002019\",\n\t\"ANO_PORTARIA\":\"2017\",\n\t\"NUMERO_CNH_WORK\":\"1000000019\",\n\t\"NUMERO_REGISTRO_WORK\":\"00002819742\",\n\t\"TIPO_PROC_WORK\":\"cassacao\",\n\t\"AUTO\":[\n\t\t\"MSMS012455\",\n\t\t\"MSMS012455\",\n\t\t\"MSMS012455\"\n\t\t]\n\t\n}\n\n\t\n\n"
		 * );
		 * 
		 * request.addHeader("accept", "application/json");
		 * request.setEntity(input);
		 * 
		 * HttpResponse response = client.execute(request);
		 * 
		 * String json = IOUtils.toString(response.getEntity().getContent());
		 * JSONArray array = new JSONArray(new JSONTokener(new
		 * FileInputStream(new File(json)))); for (int i = 0; i <
		 * array.length(); i++) { JSONObject object = array.getJSONObject(i);
		 * System.out.println(object.get("byteDespacho")); }
		 */

		// String conteudo = "";
		// byte[] encodedBytes = Base64.encodeBase64(conteudo.getBytes());
		// byte[] parseBase64Binary =
		// DatatypeConverter.parseBase64Binary(encodedBytes.toString());
		// FileUtils.writeByteArrayToFile(new File("c:\\temp\\edital02.pdf"),
		// parseBase64Binary);
		//
		// System.out.println("aaali");
		// EntityManager em = JpaUtil.getEntityManager();
		// EntityTransaction tx = em.getTransaction();
		//
		// Path fileLocation = Paths.get("C:\\temp\\1.pdf");
		// byte[] data = Files.readAllBytes(fileLocation);
		//
		// tx.begin();
		//
		// ArquivoDespacho arquivo = new ArquivoDespacho();
		// arquivo.setArquivo(data);
		// em.persist(arquivo);
		//
		//
		// PsgPenalidadeDespachos entity = new PsgPenalidadeDespachos();
		// entity.setTipoRegistro("Teste");
		// entity.setCodCiclo(1);
		// entity.setCodEtapa(1);
		// entity.setCodProcesso("00000000");
		//
		// entity.setArquivo(arquivo);
		//
		// em.persist(entity);
		// tx.commit();

		HttpResponse<InputStream> response = Unirest.get("http://10.9.23.176:8080/busca-imagens/rest/penalidades/get-pdfCompleto?numProcDetran=012152/2017&cpf=02219903133")
				  .header("content-type", "application/json")
				.asBinary();

		/*int tam = response.getBody().getArray().length();
		String bytess = "";
		for (int i = 0; i < tam; i++) {
			bytess = (String) response.getBody().getArray().getJSONObject(i).get("retorno");
		}*/
		
		InputStream responseW = response.getBody();
		byte[] bytess = IOUtils.toByteArray(responseW);
		
		//byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary(bytess);
		FileUtils.writeByteArrayToFile(new File("c:\\temp\\pdf-comp.pdf"), bytess);

	}
}
