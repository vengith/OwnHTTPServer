package create;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Logger;

import givenpaket.ContentType;
import givenpaket.HttpStatus;

public abstract class AbstractSimpleResponse {

	private static Logger logger = Logger.getLogger(AbstractSimpleResponse.class
				.getName());
	protected static final String CONTENT_TYPE = "content-type";
	protected HttpStatus status = HttpStatus.OK;
	boolean statusInitialized = false;
	protected HashMap<HttpStatus, Integer> httpCodes;
	protected Socket socket;
	protected PrintStream out;
	protected String myProtocolType = "HTTP/1.0";
	protected ContentType contentType;
	protected boolean headerSend;

	public AbstractSimpleResponse() {
		super();
	}

	protected void initStatusCodes() {
		if (!statusInitialized) {
			httpCodes = new HashMap<>();
			httpCodes.put(HttpStatus.OK, 200);
			httpCodes.put(HttpStatus.BAD_REQUEST, 400);
			httpCodes.put(HttpStatus.NOT_FOUND, 404);
			httpCodes.put(HttpStatus.FORBIDDEN, 403);
			httpCodes.put(HttpStatus.INTERNAL_SERVER_ERROR, 500);
			statusInitialized = true;
		}
	
	}

	public void setHttpStatus(HttpStatus error) {
		this.status = error;
	
	}

	public void close() {
		logger.info("closing socket and co ...");
		out.println();
		out.println();
		out.close();
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public void setContentType(ContentType type) {
		logger.info("Content-Type to be set to " + type);
		// TODO: Map the enums to the real types
		this.contentType = type;
		
	}

	public OutputStream getOutputStream() throws IOException {
		return socket.getOutputStream();
	}

	
	public abstract void addToBody(String string) throws IOException;

	public abstract void sendHeader() throws IOException;

}