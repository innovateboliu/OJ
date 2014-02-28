package language;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	private Object obj;
	public Object get() {
		return obj;
	}
	public void set(Object obj) {
		this.obj = obj;
	}
	
	
	public static void main(String[] args) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("xanadu.txt");
			out = new FileOutputStream("outagain.txt");
			int c;
			
			while ((c = in.read()) != -1) {
				out.write(c);
			}
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			
		}
	}
}


