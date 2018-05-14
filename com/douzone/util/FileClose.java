package com.douzone.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileClose {
	
	
	//Reader, Writer close 생성
	
	public static void close (Reader r) {
		try {
			if(r != null) {
				r.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (Writer w) {
		try {
			if(w != null) {
				w.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//InputStream, OutputStream close 생성
	
	public static void close(InputStream is) {
		try {
			if(is != null) {
				is.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close (OutputStream os) {
		try {
			if(os != null) {
				os.close();
			}
 		} catch (Exception e){
			e.printStackTrace();
		}
	}

	public static void close (InputStream fis, InputStream is) {
		close(fis);
		close(is);
	}
	
	public static void close (OutputStream fos, OutputStream os) {
		close(fos);
		close(os);
	}
	
	public static void close (Reader br, Reader r) {
		close(br);
		close(r);
	}

	public static void close (Writer bw, Writer w) {
		close(bw);
		close(w);
	}
} 

