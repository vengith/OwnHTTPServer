package simplewebserver;

import givenpackage.HttpCommand;
import givenpackage.InvalidRequestException;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

import create.AbstractSimpleRequest;


public class MySimpleRequest extends AbstractSimpleRequest {

	Logger logger = Logger.getLogger(ServOneClient.class.getName());
	
	public MySimpleRequest(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void parseRequest() throws IOException, InvalidRequestException {
	    String line = null;
	    boolean firstline = true;
//	    lies solange vom Socket bis nichts mehr darin steht ..
	    while( ( line = in.readLine() ) != null ) {
//	        System.out.println(">>>>" + line );
	        if(firstline){
	        	firstline = false ;
	        	scanFirstLine(line);
	        }
	    }
	}

	private void scanFirstLine(String line) throws InvalidRequestException {
		String[] parts = line.split("/");
		
		if(parts.length!= 3){
			throw new InvalidRequestException("autsch es werden " + parts.length + " Teile gefunden.");
		}
		
		this.ressourceURI = parts[1];
		this.protocolType = parts[2];
		
		parts[0] = parts[0].trim(); //hier wird ein Leerzeichen abgeschnitten, welches verhindert dass GET gesetzt wird
		
		switch (parts[0]){
		case "GET":
			this.requestType = HttpCommand.GET;
		return ;
		}
		
//		logger.info(this.ressourceURI);
//		logger.info(this.protocolType);
		
	}
}
