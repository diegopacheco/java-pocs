package com.github.diegopacheco.sec.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

class CompressionService {

    public byte[] compress(byte[] cleanText){
        try{
            ByteArrayOutputStream obj = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream(obj);
            gzip.write(cleanText);
            gzip.close();
            return obj.toByteArray();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public byte[] decompress(byte[] cipherText){
        try{
            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(cipherText));
            byte[] buffer = new byte[cipherText.length];
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int len;
            while ((len = gis.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
            gis.close();
            out.close();
            return out.toByteArray();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
