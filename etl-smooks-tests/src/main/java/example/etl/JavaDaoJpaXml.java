package example.etl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.SmooksException;
import org.milyn.container.ExecutionContext;
import org.milyn.event.report.HtmlReportGenerator;
import org.milyn.io.StreamUtils;
import org.milyn.persistence.util.PersistenceUtil;
import org.milyn.routing.db.StatementExec;
import org.milyn.scribe.adapter.jpa.EntityManagerRegister;
import org.milyn.scribe.register.DaoRegister;
import org.milyn.scribe.register.MapDaoRegister;
import org.milyn.util.HsqlServer;
import org.xml.sax.SAXException;

import example.dao.PessoaDao;

public class JavaDaoJpaXml {

	private HsqlServer dbServer;
	private EntityManagerFactory emf;
	private EntityManager em;

	public static byte[] messageInDao = readInputMessage();
	public static byte[] messageInJpa = readInputMessage();

	public static void main(String[] args) throws Exception {
	
		JavaDaoJpaXml main = new JavaDaoJpaXml();

		System.out
				.println("\n\nThis sample will use Smooks to extract data from an message and load it into a Database (Hypersonic)\n");

		try {
			JavaDaoJpaXml
					.pause("First the database needs be started. Press return to start the database...");

			main.startDatabase();

			main.initDatabase();

			System.out.println();

			JavaDaoJpaXml
					.pause("The database is started now. Press return to see its contents.");

			main.printOrders();

			System.out.println();

			System.out
					.println("\n\nThis first run Smooks will use data access objects to persist and lookup entities.");

			JavaDaoJpaXml
					.pause("Press return to see the sample message for the first run..");

			System.out.println("\n" + new String(messageInDao) + "\n");

			JavaDaoJpaXml.pause("Now press return to execute Smooks.");

			main.runSmooksTransformWithDao();

			System.out.println();

			JavaDaoJpaXml
					.pause("Smooks has processed the message.  Now press return to view the contents of the database again.  This time there should be orders and orderlines...");

			main.printOrders();

			System.out
					.println("\n\nThis second run Smooks will use JPA to persist and lookup entities.");

			JavaDaoJpaXml
					.pause("Press return to see the sample message for the second run..");

			System.out.println("\n" + new String(messageInJpa) + "\n");
			System.out.println();

			JavaDaoJpaXml.pause("Now press return to execute Smooks.");

			main.runSmooksTransformWithJpa();

			System.out.println();

			JavaDaoJpaXml
					.pause("Smooks has processed the message.  Now press return to view the contents of the database again.  This time there should be new orders and orderlines...");

			main.printOrders();

			JavaDaoJpaXml.pause("And that's it! Press return exit...");
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			main.stopDatabase();
		}
	}

	protected void runSmooksTransformWithDao() throws IOException,
			SAXException, SmooksException {

		Smooks smooks = new Smooks("./smooks-configs/smooks-dao-config.xml");

		try {
			ExecutionContext executionContext = smooks.createExecutionContext();

			// Configure the execution context to generate a report...
			executionContext.setEventListener(new HtmlReportGenerator(
					"target/report/report-dao.html"));

			DaoRegister<Object> register = MapDaoRegister.builder().put(
					"pessoa", new PessoaDao(em)).build();

			PersistenceUtil.setDAORegister(executionContext, register);

			EntityTransaction tx = em.getTransaction();
			tx.begin();

			smooks.filterSource(executionContext, new StreamSource(
					new ByteArrayInputStream(messageInDao)), null);

			tx.commit();
		} finally {
			smooks.close();
		}
	}

	protected void runSmooksTransformWithJpa() throws IOException,
			SAXException, SmooksException {

		Smooks smooks = new Smooks("./smooks-configs/smooks-jpa-config.xml");

		try {
			ExecutionContext executionContext = smooks.createExecutionContext();

			// Configure the execution context to generate a report...
			executionContext.setEventListener(new HtmlReportGenerator(
					"target/report/report-jpa.html"));

			PersistenceUtil.setDAORegister(executionContext,
					new EntityManagerRegister(em));

			EntityTransaction tx = em.getTransaction();

			tx.begin();

			smooks.filterSource(executionContext, new StreamSource(
					new ByteArrayInputStream(messageInJpa)), null);

			tx.commit();
		} finally {
			smooks.close();
		}
	}

	public void printOrders() throws SQLException {
		List<Map<String, Object>> customers = getCustomers();
		List<Map<String, Object>> products = getProducts();
		List<Map<String, Object>> orders = getOrders();
		List<Map<String, Object>> orderItems = getOrderItems();

		printResultSet("Customers", customers);
		printResultSet("Products", products);
		printResultSet("Orders", orders);
		printResultSet("Order Items", orderItems);
	}

	public List<Map<String, Object>> getOrders() throws SQLException {
		StatementExec exec1OrderItems = new StatementExec(
				"select * from orders");
		List<Map<String, Object>> rows = exec1OrderItems
				.executeUnjoinedQuery(dbServer.getConnection());
		return rows;
	}

	public List<Map<String, Object>> getOrderItems() throws SQLException {
		StatementExec exec1OrderItems = new StatementExec(
				"select * from orderlines");
		List<Map<String, Object>> rows = exec1OrderItems
				.executeUnjoinedQuery(dbServer.getConnection());
		return rows;
	}

	public List<Map<String, Object>> getProducts() throws SQLException {
		StatementExec exec1OrderItems = new StatementExec(
				"select * from products");
		List<Map<String, Object>> rows = exec1OrderItems
				.executeUnjoinedQuery(dbServer.getConnection());
		return rows;
	}

	public List<Map<String, Object>> getCustomers() throws SQLException {
		StatementExec exec1OrderItems = new StatementExec(
				"select * from customers");
		List<Map<String, Object>> rows = exec1OrderItems
				.executeUnjoinedQuery(dbServer.getConnection());
		return rows;
	}

	private void printResultSet(String name, List<Map<String, Object>> resultSet) {
		System.out
				.println(("---- " + name + " -------------------------------------------------------------------------------------------------")
						.substring(0, 80));
		if (resultSet.isEmpty()) {
			System.out.println("(No rows)");
		} else {
			for (int i = 0; i < resultSet.size(); i++) {
				Set<Map.Entry<String, Object>> row = resultSet.get(i)
						.entrySet();

				System.out.println("Row " + i + ":");
				for (Map.Entry<String, Object> field : row) {
					System.out.println("\t" + field.getKey() + ":\t"
							+ field.getValue());
				}
			}
		}
		System.out
				.println(("---------------------------------------------------------------------------------------------------------------------")
						.substring(0, 80));
	}

	public void startDatabase() throws Exception {
		dbServer = new HsqlServer(9201);
		emf = Persistence.createEntityManagerFactory("db");
		em = emf.createEntityManager();
	}

	public void initDatabase() throws Exception {
		InputStream schema = new FileInputStream("init-db.sql");

		try {
			dbServer.execScript(schema);
		} finally {
			schema.close();
		}
	}

	void stopDatabase() throws Exception {
		try {
			em.close();
		} catch (Exception e) {
		}
		try {
			emf.close();
		} catch (Exception e) {
		}
		dbServer.stop();
	}

	private static byte[] readInputMessage() {
		try {
			return StreamUtils.readStream(new FileInputStream(new File("").getAbsolutePath() +  "/src/main/resources/input-sources/input-msg-dao.xml"));
		} catch (IOException e) {
			e.printStackTrace();
			return "<no-message/>".getBytes();
		}
	}

	public void startEntityManagerFactory() throws Exception {

		InputStream schema = new FileInputStream(new File("").getAbsolutePath() +  "/src/main/resources/db-create.sql");

		try {
			dbServer = new HsqlServer(9201);
			dbServer.execScript(schema);
		} finally {
			schema.close();
		}

	}

	static void pause(String message) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("> " + message);
			in.readLine();
		} catch (IOException e) {
		}
		System.out.println("\n");
	}

}
