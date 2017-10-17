package batch.db.writer;

import java.util.List;

import org.springframework.batch.item.file.FlatFileItemWriter;

import batch.db.pojo.Banco;

public class BancoFlatFileItemWriter extends FlatFileItemWriter<Banco> {

	@Override
	public void write(List<? extends Banco> items) throws Exception {
		super.write(items);
	}
}
