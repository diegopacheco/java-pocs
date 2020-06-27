package com.github.diegopacheco.serdebenchs.avro;

import com.github.diegopacheco.serdebenchs.SerdeService;
import org.apache.avro.io.*;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.ByteArrayOutputStream;

public class AvroSerdeServie implements SerdeService<AvroHttpRequest,byte[]> {

    @Override
    public byte[] serialize(AvroHttpRequest request) {
        DatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(AvroHttpRequest.class);
        byte[] data = new byte[0];
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = EncoderFactory.get().binaryEncoder(stream, null);
        try {
            writer.write(request, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public AvroHttpRequest deserialize(byte[] data) {
        DatumReader<AvroHttpRequest> employeeReader = new SpecificDatumReader<>(AvroHttpRequest.class);
        Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
        try {
            return employeeReader.read(null, decoder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
