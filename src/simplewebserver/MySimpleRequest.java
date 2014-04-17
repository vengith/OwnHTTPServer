package simplewebserver;

import givenpackage.HttpCommand;
import givenpackage.InvalidRequestException;

import java.io.IOException;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Scanner;

import create.AbstractSimpleRequest;

public class MySimpleRequest extends AbstractSimpleRequest{
	
	this.socket = socket;
	in = new BuffferedReader(new InputStreamReader(socket.getInputStream()));	
	
	
	public MySimpleRequest(Socket socket) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void parseRequest() throws IOException, InvalidRequestException {
		String line = null;
		boolean firstLine = true;
		
		//Lies es so lange von Socket, bis nichts mehr da ist...
		
		while( (line = in.readLine() )  != null ){
			System.out.println(">>>" + line);
			
			if (firstLine) {
				firstLine = false;
				scanFirstLine(line);
			}
		}
	}

	private void scanFirstLine(String line) {
		// TODO Auto-generated method stub
		String [] parts = line.split("");
		
		if (parts.length != 3) {
			throw new InvalidRequestException("Leider nur doof!");
		}
		
		this.ressourceURI = parts[1];
		this.protocolType = parts[2];
		
		switch (parts[0]) {
		case "GET":
			this.requestType = HttpCommand.GET;
			//CASES noch für den Rest
		}
	}

}
