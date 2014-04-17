package simplewebserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

import givenpackage.HttpStatus;
import givenpackage.InvalidRequestException;
import create.RessourceManager;

public class ServOneClient extends Thread {
	Logger logger = Logger.getLogger(ServOneClient.class.getName());

	private static final String INVALID_REQUEST = null;
	private Socket socket;
	private RessourceManager ressourceManager;

	public ServOneClient(Socket socket, RessourceManager ressourceManager) {
		this.socket = socket;
		this.ressourceManager = ressourceManager;
		this.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		SimpleRequest request;
		SimpleResponse response;
		try {
			request = new SimpleRequest(socket);
			response = new SimpleResponse(socket);
		} catch (IOException e1) {
			// If we cannot create a request or a response on the socket, we
			// cannot communicate with the client, so just print an error log
			// message and stop further processing.
			e1.printStackTrace();
			return;
		}

		try {
			request.parseRequest();
		} catch (InvalidRequestException e) {
			// We have no valid request so send this info back to the user.
			e.printStackTrace();
			response.setHttpStatus(HttpStatus.BAD_REQUEST);
			try {
				response.addToBody("The request was invalid.\n");
				response.addToBody("Details:\n");
				response.addToBody(e.getMessage());
				return;
			} catch (IOException e1) {
				// communication problem, see above
				e1.printStackTrace();
				return;
			}
		} catch (IOException e) {
			// communication problem, see above
			e.printStackTrace();
			return;
		}
		logger.info(request.toString());

		try {
			ressourceManager.doService(request, response);
		} catch (IOException e) {
			// communication problem, see above
			e.printStackTrace();
			return;
		}

		// End communication
		response.close();
	}

}