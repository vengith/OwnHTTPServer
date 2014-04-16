//Überarbeitung und Implementierung Chaosteilchen & vengith


package create;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import create.AbstractSimpleRequest;
import create.AbstractSimpleResponse;

public interface RessourceManager {

	void doGet(AbstractSimpleRequest request, AbstractSimpleResponse response)
			throws IOException;

	void doService(AbstractSimpleRequest request, AbstractSimpleResponse response)
			throws IOException;
	
	 void copyFile(File file, AbstractSimpleResponse response) throws IOException;

	void copyStreams(InputStream in, OutputStream out) throws IOException;

	void writeDirectoryAsHtml(File file, AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException;


}