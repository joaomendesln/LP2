package xmlEscrita;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.IOException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.util.Scanner;
 
public class Localizacao {
	
	// por que static?
	public static int getLastCodigo(String path) {

        File tmp = new File(path);
        
        if(!tmp.exists()) {
        	return 0;
        }
        
        Document document = null;
		
		try {
		 
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        
        document = documentBuilder.parse(path);
		
		
		} catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
 			 ioe.printStackTrace();
 		} catch (SAXException sae) {
 			 sae.printStackTrace();
 		}

   	 	Node lista = document.getElementsByTagName("lista").item(0);
   	 	
		Node ultimaLoc = lista.getLastChild();
		
		Node codigo = ultimaLoc.getFirstChild();
		
		String cod = codigo.getTextContent();
		
		return Integer.parseInt(cod);
	}
	
	// add o diretorio com o id do usuario
    public static final String xmlFilePath = System.getProperty("user.dir") + "\\localizacao.xml";
	 
    public static void main(String argv[]) {
 
    	 try {    
    		 
    		 // tirar dúvida sobre esse Scanner 'input' is never closed
    		 Scanner input = new Scanner(System.in);
	
    		 String nomeInput;
	    	 String descricaoInput;
	
	    	 System.out.print("Entre com o nome: ");
	    	 nomeInput = input.next();
	
	    	 System.out.print("Entre com a descrição: ");
	    	 descricaoInput = input.next();
    		 
             DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
  
             DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
               
             File tmpDir = new File(xmlFilePath);
             boolean exists = tmpDir.exists();
        	 
             if(exists) {

                 Document document = documentBuilder.parse(xmlFilePath);

            	 Node addLocalizacao = document.getElementsByTagName("lista").item(0);
            	 
            	 Element localizacao = document.createElement("localizacao");
            	 addLocalizacao.appendChild(localizacao);

	             Node codigo = document.createElement("codigo");
	             codigo.appendChild(document.createTextNode(Integer.toString(getLastCodigo(xmlFilePath) + 1)));
	             localizacao.appendChild(codigo);
	  
	             Node nome = document.createElement("nome");
	             nome.appendChild(document.createTextNode(nomeInput));
	             localizacao.appendChild(nome);
	  
	             Node descricao = document.createElement("descricao");
	             descricao.appendChild(document.createTextNode(descricaoInput));
	             localizacao.appendChild(descricao);
	  
	             TransformerFactory transformerFactory = TransformerFactory.newInstance();
	             Transformer transformer = transformerFactory.newTransformer();
	             DOMSource domSource = new DOMSource(document);
	             StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	  
	  
	             transformer.transform(domSource, streamResult);
	  
	             System.out.println("Localização inserida\n");
             }
             else {

                 Document document = documentBuilder.newDocument();
  
	             Node lista = document.createElement("lista");
	             document.appendChild(lista);
	  
	             Node localizacao = document.createElement("localizacao");
	             lista.appendChild(localizacao);
	    
	             Node codigo = document.createElement("codigo");
	             codigo.appendChild(document.createTextNode("1"));
	             localizacao.appendChild(codigo);
	  
	             Node nome = document.createElement("nome");
	             nome.appendChild(document.createTextNode(nomeInput));
	             localizacao.appendChild(nome);
	  
	             Node descricao = document.createElement("descricao");
	             descricao.appendChild(document.createTextNode(descricaoInput));
	             localizacao.appendChild(descricao);
	  
	             TransformerFactory transformerFactory = TransformerFactory.newInstance();
	             Transformer transformer = transformerFactory.newTransformer();
	             DOMSource domSource = new DOMSource(document);
	             StreamResult streamResult = new StreamResult(new File(xmlFilePath));
	  
	             transformer.transform(domSource, streamResult);
	  
	             System.out.println("Localização inserida\n");
             }
             
             // LISTAR LOCALIZAÇÕES
             Document document = documentBuilder.parse(xmlFilePath);

        	 Node listarLista = document.getElementsByTagName("lista").item(0);
        	 
        	 NodeList lista = listarLista.getChildNodes();
        	 
        	 System.out.println("LOCALIZAÇÕES CADASTRADAS");
        	 
        	 for(int i = 0; i < lista.getLength(); i++) {
        		 
        		 NodeList localizacao = lista.item(i).getChildNodes();
        		 
        		 System.out.println("Código: " + localizacao.item(0).getTextContent());
        		 System.out.println("Nome: " + localizacao.item(1).getTextContent());
        		 System.out.println("Descrição: " + localizacao.item(2).getTextContent());
        		 System.out.println("-------------------------");
        	 }
             
             
  
         } catch (ParserConfigurationException pce) {
             pce.printStackTrace();
         } catch (TransformerException tfe) {
             tfe.printStackTrace();
         } catch (IOException ioe) {
  			 ioe.printStackTrace();
  		 } catch (SAXException sae) {
  			 sae.printStackTrace();
  		 }
    }
}
