package batch.db.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.listener.ItemListenerSupport;

@SuppressWarnings("unchecked")
public class FailItemListenerSupport extends ItemListenerSupport {

	private static Log logger = LogFactory.getLog("item.error");

	public void onReadError(Exception ex) {
		logger.error("Erro ao efetuar a leitura do banco: ", ex);
	}

	public void onWriteError(Exception ex, Object item) {
		logger.error("Erro ao realizar escrita no arquivo: ", ex);
	}

}
