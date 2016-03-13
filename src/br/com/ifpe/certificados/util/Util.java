package br.com.ifpe.certificados.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Roberto Alencar
 *
 */
public class Util {

    public static byte[] lerConteudoArquivoPDF(String arquivo) throws IOException {

	File file = new File(arquivo);
	FileInputStream fis = new FileInputStream(file);
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	
	byte[] buf = new byte[1024];
	for (int readNum; (readNum = fis.read(buf)) != -1;) {
	    bos.write(buf, 0, readNum);
	    System.out.println("read " + readNum + " bytes,");
	}

	fis.close();
	
	return bos.toByteArray();
    }

}
