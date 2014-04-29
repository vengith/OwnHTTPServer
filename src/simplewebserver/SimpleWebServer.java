package simplewebserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import givenpackage.ConfigurationException;
import create.RessourceManager;

public class SimpleWebServer {

	private static final int STANDARD_PORT = 8080;

	public SimpleWebServer() {
	}

	public static void main(String[] args) throws IOException, ConfigurationException {
		int port = STANDARD_PORT;
		RessourceManager ressourceManager = new MyRessourceManager("C:/Users/miw/git/OwnHTTPServer/testdata"); // ./testdata
		ServerSocket welcome = new ServerSocket(port);
		while (true) {
			Socket socket = welcome.accept();
			new ServOneClient(socket, ressourceManager);
		}
	}

}
