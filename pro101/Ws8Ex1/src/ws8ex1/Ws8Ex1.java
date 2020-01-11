package ws8ex1;

import java.io.*;

public class Ws8Ex1 {

    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferIn = null;
        BufferedOutputStream bufferOut = null;
        InputStream fIn = new FileInputStream("D:/nhan/java/pro101/in.txt");
        OutputStream fOut = new FileOutputStream("D:/nhan/java/pro101/out.txt");
        bufferIn = new BufferedInputStream(fIn);
        bufferOut = new BufferedOutputStream(fOut);

        int c;
        char ch = 0;
        while ((c = bufferIn.read()) != -1) {
            if (Character.isUpperCase((char) c)) {
                ch = (char) ((int) (c + 3 - 65) % 26 + 65);

            } else {
                ch = (char) ((int) (c + 3 - 97) % 26 + 97);
            }
            bufferOut.write(ch);
        }
        if (bufferIn != null) {
            bufferIn.close();
        }
        if (bufferOut != null) {
            bufferOut.close();
        }
    }
}
