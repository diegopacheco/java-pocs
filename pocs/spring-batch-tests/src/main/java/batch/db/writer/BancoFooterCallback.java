package batch.db.writer;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileFooterCallback;

public class BancoFooterCallback implements FlatFileFooterCallback {

	public void writeFooter(Writer w) throws IOException {
		w.write("---Rodape do arquivo.");
	}

}
