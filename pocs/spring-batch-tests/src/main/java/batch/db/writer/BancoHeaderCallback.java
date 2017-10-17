package batch.db.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class BancoHeaderCallback implements FlatFileHeaderCallback {

	public void writeHeader(Writer w) throws IOException {
		w.write("---header: " + new Date().toString());		
	}

}
