package br.com.psg.despachos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import br.com.psg.entities.Despachos;
import br.com.psg.util.DataUtil;
import br.com.psg.util.FileUtil;

public class Dicon165 {
public String gerarDicon165(Despachos despacho){
		
		StringBuilder html = new StringBuilder();
		html.append("<html>");
		html.append("<head>");
		html.append("<meta charset=\"UTF-8\">");
		html.append("<style type=\"text/css\">");
		//css
		html.append(
				"BODY {font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:none;}.font{font-family:Tahoma, Verdana, Arial, Helvetica, sans-serif;font-size:12px;font-weight:bold;}"
				+ "#rodape {position:absolute;bottom:0;z-index: 0;} #assinatura{position: relative;z-index: 2}");
		html.append("</style>");
		html.append("</head><body>");
		
		html.append("<div id=\"geral\" align=\"center\" width=\"100%\"><table align=\"center\" width=\"100%\">");
		//imagem cabeçalho
		html.append("<tr><td colspan='2'><img src=\"" + getClass().getResource("/br/com/psg/resources/cabecalho.jpg")
				+ "\"alt=\"logo\" name=\"logo\" width=\"900\" height=\"132\" hspace=\"12\" border=\"0\" align=\"top\" id=\"logo\"/></td></tr>");
		html.append("</table>");
		
		html.append("<p><p>");
		
		//titulo
		html.append("<table align=\"center\" width=\"100%\"><tr><td align=\"center\" width=\"100%\"><b>CERTIFICAÇÃO PARA ARTIGO 165 SEM DEFESA DE NOTIFICAÇÃO 15 DIAS</b></td></tr></table>");
		
		html.append("<p><p>");
		//tabela principal
		html.append("<table align=\"center\" width=\"100%\">");
		//conteudo
		html.append("<tr><td align=\"justify\" width=\"90%\"><b>À DIRHAB, DIRETORIA DE HABILITAÇÃO</b></td></tr>");
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Instaurado procedimento para apurar responsabilidade do condutor <b>"+despacho.getNomeCondutor()+"</b>, CPF nº <b>"+despacho.getCpfCondutor()+"</b>, por infringir "
				+ "artigo <b>165</b>, do Código de Trânsito Brasileiro, multa tipificada com o código 5169-1, nos termos do anexo IV da Portaria 59/2007, DENATRAN, e devidamente "
				+ "comprovado/confirmado nos termos do artigo 277, § 2º do CTB conforme consta dos autos, instruído com o devido Auto de Infração, documentos em imagem para "
				+ "prosseguimento do feito, certificando que o condutor não interpôs recurso de penalidade para o auto em questão e ou teve o mesmo julgado improvido, nos termos "
				+ "do artigo 281 e 282 do CTB, e não interpôs defesa escrita referente à notificação 15 dias acostada aos autos.</td></tr>");
		
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Dispõe o artigo 165 do CTB, <i>que dirigir sob a influência de álcool ou de qualquer outra substância psicoativa que determine "
				+ "dependência, é infração gravíssima, com penalidade de multa (cinco vezes) e suspensão do direito de conduzir por 12 meses.</i></td></tr>");
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Também o artigo 276 do CTB, dispõe que qualquer concentração de álcool por litro de sangue sujeita o condutor às"
				+ " penalidades previstas no artigo 165 do CTB.</td></tr>");
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">A redação dada pela Lei nº11275 de 2006 ao artigo 277 do CTB dispõe que <i>todo condutor de veículo automotor envolvido "
				+ "em acidente de trânsito ou que for alvo de fiscalização de trânsito, sob suspeita de dirigir sob a influência de álcool será submetido a testes de alcoolemia, exames "
				+ "clínicos, perícia ou outro exame que, por meios técnicos ou científicos, em aparelhos homologados pelo CONTRAN que permitam certificar seu estado.</td></tr>");
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">A infração praticada pelo condutor enquadra-se no disposto acima.</td></tr>");
		
		html.append("<tr><td></td></tr>");
		
		html.append("<tr><td align=\"justify\" width=\"90%\">Diante do exposto e por tudo que dos autos consta, encaminhamos o presente feito a Vossa Senhoria para apreciação quanto à "
				+ "aplicação da penalidade de suspensão do direito de dirigir ao condutor em referência, conforme determina o artigo 165 do CTB, bem como a realização do curso de reciclagem "
				+ "para condutores infratores na forma do artigo 268, inciso II do CTB.</td></tr>");
		
		
		
		html.append("</table>");
		
		html.append("<p>");
		
		//table data
		html.append("<table align=\"center\" width=\"100%\"><tr><td><p>Em "+DataUtil.dataAtualExtenso()+"</p></td></tr></table>");
		
		//assinatura
		html.append("<div id=\"assinatura\" align=\"left\" width=\"100%\">");
		html.append("<table align=\"center\" width=\"100%\">");
		html.append("<tr><td>");
		html.append("<img src=\""+getClass().getResource("/br/com/psg/resources/assinatura_luisfernandoferreiradossantos.jpg")+"\" alt=\"assinatura\" name=\"assinatura\" width=\"168\" height=\"122\" hspace=\"12\" border=\"0\" align=\"top\" id=\"assinatura\"/></td></tr>");
		
		html.append("<tr><td>  <p><b>LUIZ FERNANDO FERREIRA DOS SANTOS</b><br />Chefe da Divisão de Registro de Condutores<br>DETRAN / MS</p></td></tr>");
		
		html.append("</table></div>");
		
		html.append("</div>");
		
		//rodapé
		html.append(" <div id=\"rodape\" align=\"center\">");
		html.append(
				"<img src=\""+getClass().getResource("/br/com/psg/resources/rodapeDetran.jpg")+"\" alt=\"rodape\" name=\"rodape\"  width=\"900\" height=\"112\"  hspace=\"12\" border=\"0\" align=\"top\" id=\"rodape\"/>");
		html.append("</div>");
		
		html.append("</body>");
		html.append("</html>");
		
		
		String arquivo = "";
		String nomeArquivo = "despacho-165-dicon";
		try {
			arquivo = FileUtil.caminhoTemplates +"/"+ nomeArquivo+".html";
			BufferedWriter htmlFile = new BufferedWriter(new FileWriter(arquivo));
			htmlFile.write(html.toString());
			System.out.println("criou o arquivo");
			htmlFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nomeArquivo;
	}
}
