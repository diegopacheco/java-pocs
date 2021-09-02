package com.github.diegopacheco.gzip;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPService {

    public static String compress(String str,String readEncoding,String writeEncoding){
        try{
            if (str == null || str.length() == 0) {
                return str;
            }
            System.out.println("String length : " + str.length());
            ByteArrayOutputStream obj=new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(obj);
            gzip.write( (null==readEncoding) ? str.getBytes() : str.getBytes(readEncoding));
            gzip.close();
            String outStr = (null==writeEncoding) ? obj.toString() : obj.toString(writeEncoding);
            System.out.println("Output String length : " + outStr.length());
            return outStr;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String decompress(String str,String readEncoding,String writeEncoding){
        try{
            if (str == null || str.length() == 0) {
                return str;
            }
            System.out.println("Input String length : " + str.length());
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(
                    (null==readEncoding) ? str.getBytes() : str.getBytes(readEncoding)
            ));
            BufferedReader bf = new BufferedReader(new InputStreamReader(gis,
                    (null==writeEncoding) ? Charset.defaultCharset().name() : writeEncoding));
            String outStr = "";
            String line;
            while ((line=bf.readLine())!=null) {
                outStr += line;
            }
            System.out.println("Output String lenght : " + outStr.length());
            return outStr;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
