package simplewebserver;

import java.io.IOException;
import java.net.Socket;

import create.AbstractSimpleResponse;

public class MySimpleResponse extends AbstractSimpleResponse {

	public MySimpleResponse(Socket socket) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addToBody(String string) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendHeader() throws IOException {
		out.append(myProtocolType);
		
	}

}
