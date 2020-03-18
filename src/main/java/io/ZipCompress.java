package io;//: io/ZipCompress.java
// Uses Zip compression to compress any
// number of files given on the command line.
// {Args: ZipCompress.java}

import java.util.zip.*;
import java.io.*;
import java.util.*;

import static net.mindview.util.Print.*;

public class ZipCompress {

    public static void main(String[] args) throws IOException {


        /**
         * args =
         * D:\MavenSpace\thinkinjava\src\main\java\io\ZipCompress.java D:\MavenSpace\thinkinjava\src\main\java\io\GZIPcompress.java
         */
        String path = "D:\\MavenSpace\\thinkinjava\\src\\main\\java\\io\\";
        FileOutputStream f = new FileOutputStream(path+"test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        //zos注释
        zos.setComment("A test of Java Zipping");
        // No corresponding getComment(), though.
        for (String arg : args) {
            print("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            // 刷新缓存区域
            out.flush();
        }
        out.close();


        // Checksum valid only after the file has been closed!
        // 校验和
        print("Checksum: " + csum.getChecksum().getValue());
        // Now extract the files:
        print("Reading file");
        FileInputStream fi = new FileInputStream(path+"test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            print("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }
        if (args.length == 1) {
            //校验和
            print("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();


        // Alternative way to open and read Zip files:
        //另外一种读取zip文件的方式
        ZipFile zf = new ZipFile(path+"test.zip");
        //zip条目的枚举
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            print("File: " + ze2);
            // ... and extract the data as before
        }
    /* if(args.length == 1) */
    }
} /* (Execute to see output) *///:~
