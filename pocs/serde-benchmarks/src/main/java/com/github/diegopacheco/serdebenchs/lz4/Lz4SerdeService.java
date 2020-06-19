package com.github.diegopacheco.serdebenchs.lz4;

import com.github.diegopacheco.serdebenchs.model.Person;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

public class Lz4SerdeService {

    private static LZ4Factory factory = LZ4Factory.fastestInstance();

    public Lz4Result serialize(Person p){
        try{
            LZ4Compressor compressor = factory.fastCompressor();
            byte[] data = personToString(p).getBytes("UTF-8");
            int maxCompressedLength = compressor.maxCompressedLength(data.length);
            byte[] compressed = new byte[maxCompressedLength];
            compressor.compress(data, 0, data.length, compressed, 0, maxCompressedLength);

            Lz4Result result = new Lz4Result();
            result.setCompressed(compressed);
            result.setOriginalLength(data.length);
            return result;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Person deserialize(Lz4Result result){
        try{
            LZ4FastDecompressor decompressor = factory.fastDecompressor();
            byte[] restored = new byte[result.getOriginalLength()];
            decompressor.decompress(result.getCompressed(), 0, restored, 0, result.getOriginalLength());
            return fromString(restored);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private String personToString(Person p){
        StringBuilder sb = new StringBuilder();
        sb.append(p.getId()).append(",")
          .append(p.getName()).append(",")
          .append(p.getEmail()) ;
        return sb.toString();
    }

    private Person fromString(byte[] source){
        try{
            Person p = new Person();
            String data[] = new String(source,"UTF-8").split(",");
            p.setId(data[0]);
            p.setName(data[1]);
            p.setEmail(data[2]);
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }


}
