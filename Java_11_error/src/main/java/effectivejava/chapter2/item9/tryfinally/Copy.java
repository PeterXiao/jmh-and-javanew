package effectivejava.chapter2.item9.tryfinally;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copy {
    private static final int BUFFER_SIZE = 8 * 1024;

    // try-finally is ugly when used with more than one resource! (Page 34)
    static void copy(final String src, final String dst) throws IOException {
	final InputStream in = new FileInputStream(src);
	try {
	    final OutputStream out = new FileOutputStream(dst);
	    try {
		final byte[] buf = new byte[BUFFER_SIZE];
		int n;
		while ((n = in.read(buf)) >= 0) {
		    out.write(buf, 0, n);
		}
	    } finally {
		out.close();
	    }
	} finally {
	    in.close();
	}
    }

    public static void main(final String[] args) throws IOException {
	final String src = args[0];
	final String dst = args[1];
	copy(src, dst);
    }
}
