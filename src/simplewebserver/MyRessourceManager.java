package simplewebserver;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import simplewebserver.MySimpleRequest;
import simplewebserver.MySimpleResponse;
import create.AbstractSimpleRequest;
import create.AbstractSimpleResponse;
import create.RessourceManager;

public class MyRessourceManager implements RessourceManager{

	public MyRessourceManager(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doGet(AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doService(AbstractSimpleRequest request,
			AbstractSimpleResponse response) throws IOException {
		// TODO Auto-generated method stub
		
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