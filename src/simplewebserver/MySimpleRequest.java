package simplewebserver;

import givenpackage.InvalidRequestException;

import java.io.IOException;

import create.AbstractSimpleRequest;

public class MySimpleRequest extends AbstractSimpleRequest{

	@Override
	public void parseRequest() throws IOException, InvalidRequestException {
		String line = null;
		boolean firstLine = true;
		
		//Lies es so lange von Socket, bis nichts mehr da ist...
		
		while( line = in.readLine() ) 
	}

}
