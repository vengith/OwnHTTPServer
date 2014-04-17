package simplewebserver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import simplewebserver.MySimpleRequest;
import simplewebserver.MySimpleResponse;

public interface MyRessourceManager {

	void doGet(AbstractSimpleRequest request, AbstractSimpleResponse response)
			throws IOException;

	void doService(AbstractSimpleRequest request, AbstractSimpleResponse response)
			throws IOException;
	
	 void copyFile(File file, AbstractSimpleResponse response) throws IOException;

	void copyStreams(InputStream in, OutputStream out) throws IOException;

	void writeDirectoryAsHtml(File file, AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException;


}