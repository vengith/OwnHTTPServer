package simplewebserver;



import givenpackage.ContentType;
import givenpackage.HttpCommand;
import givenpackage.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.logging.Logger;

import create.AbstractSimpleRequest;
import create.AbstractSimpleResponse;
import create.RessourceManager;

public class MyRessourceManager implements RessourceManager {

	Logger logger = Logger.getLogger(ServOneClient.class.getName());
	String root = null;
	
	public MyRessourceManager (String string) {
		root = string;
	}

	@Override
	public void doGet(AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException {
		logger.info("doGet");
		
		File f = new File(URLDecoder.decode(root));
		
		if (f.isDirectory()) {
			response.setContentType(ContentType.HTML);
		} else {
			//Wenn Datei(en)
		}
		
		
	}

	@Override
	public void doService(AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException {
		logger.info("doService");
		if (request.getRequestType() == HttpCommand.GET) {  //Vergleich auf GET 
			doGet(request, response);
		} else {
			//Setzt den Response Status auf BAD_REQUEST
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public void copyFile(File file, AbstractSimpleResponse response)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void copyStreams(InputStream in, OutputStream out)
			throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeDirectoryAsHtml(File file, AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}
