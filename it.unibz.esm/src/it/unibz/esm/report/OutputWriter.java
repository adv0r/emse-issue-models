package it.unibz.esm.report;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputWriter {


	public static void write(String what, String where)
			throws IOException {
		Writer out = new OutputStreamWriter(new FileOutputStream(where),"UTF-8");
		try {
			out.write(what);
		} finally {
			out.close();
		}
	}
	

}
