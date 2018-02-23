package org.cxio.core;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.cxio.core.interfaces.AspectElement;
import org.cxio.metadata.MetaDataCollection;
import org.cxio.misc.NumberVerification;
import org.cxio.misc.Status;
import org.cxio.util.CxConstants;
import org.cxio.util.JsonWriter;
import org.ndexbio.model.cx.CXAspectFragment;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NdexCXNetworkWriter {
	
//	private UUID networkId;
	private OutputStream out;
	private OutputStreamWriter writer;
	private ObjectMapper objectMapper;
	private JsonGenerator g;

	private int fragmentLength;
		
	public NdexCXNetworkWriter ( OutputStream outputStream) throws IOException {
	//	networkId = networkUUID;
		out = outputStream;
		writer = new OutputStreamWriter(out);
		objectMapper = new ObjectMapper();
		g  = (new JsonFactory()).createGenerator(writer);
		g.configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false);
		g.configure(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM, false);
		g.setCodec(objectMapper);
	}
	

	private void writeObject(Object obj) throws JsonProcessingException, IOException {
		writer.write(objectMapper.writeValueAsString( obj));
		writer.flush();
	}
	
	
	public void start() throws IOException {
		writer.write("[");
		
		NumberVerification nv = new NumberVerification(CxConstants.LONG_NUMBER_TEST);
		writeObject(nv);
		writer.write(",");
		writer.flush();
	}
	
	public void writeMetadata(MetaDataCollection m) throws JsonProcessingException, IOException{
		writeObject(m);
		writer.write(",\n");
	}
	
	public void writeAspectFragment(CXAspectFragment fragment) throws IOException  {		
		g.writeStartObject();
		g.writeObjectField(fragment.getAspectName(), fragment.getElements());
		g.writeEndObject();
		g.flush();
		writer.write(",");
		writer.flush();
	}
	
	public void startAspectFragment(String aspectName) throws IOException {
		g.writeStartObject();
		g.writeFieldName(aspectName);
		g.writeRaw(':');
		g.flush();
		writer.flush();
	}
	
	public void openFragment() throws IOException {
		g.writeRaw("[");
		g.flush();
		writer.flush();
		fragmentLength = 0;
	}
	
	public void closeFragment() throws IOException {
		writer.write("]");
		writer.flush();
	}
	
	public void writeElement(AspectElement e) throws IOException {
	   if ( fragmentLength>0)
		   writer.write(",\n");
	 //  JsonWriter tw = new JsonWriter ( g, objectMapper);
	   //e.write(tw);
		writeObject(e);
	//   g.flush();
	 //  writer.flush();
	   fragmentLength++;		
	}
	
	public void writeAspectElementsFromNdexAspectFile(String filePath) throws IOException {
		Path p = Paths.get(filePath);
		Files.copy(p, out);		
	}
	
	public int getFragmentLength() { return fragmentLength;}
	
	public void endAspectFragment() throws IOException {
		g.writeEndObject();
		g.flush();
		writer.write(",\n");
		writer.flush();
	}
	
	public void end() throws JsonProcessingException, IOException {
		Status s = new Status (true);
		writeObject(s);
		writer.write("]");
		writer.flush();
		g.close();
	}
	
	public void end (boolean isSuccess, String message) throws JsonProcessingException, IOException {
		Status s = new Status (isSuccess, message);
		writeObject(s);
		writer.write("]");
		writer.flush();
		g.close();
	}
}