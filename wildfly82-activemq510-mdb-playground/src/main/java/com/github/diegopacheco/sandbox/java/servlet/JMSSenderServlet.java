package com.github.diegopacheco.sandbox.java.servlet;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/jms/sender")
public class JMSSenderServlet extends HttpServlet {

    @Resource(mappedName = "java:jboss/activemq/amqTest")
    ConnectionFactory cf;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String msg = request.getParameter("msg");
            sendeit(msg);
            PrintWriter out = response.getWriter();
            out.println("Message sent: " + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendeit(String msg) throws Exception {

        Connection connection = null;
        Session session = null;
        try {
            connection = cf.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("test");
            MessageProducer producer = session.createProducer(queue);
            connection.start();
            TextMessage message = session.createTextMessage(msg);
            producer.send(message);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    throw e;
                }
            }
            closeConnection(connection);
        }

    }

    private void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (JMSException jmse) {
            System.out.println("Could not close connection " + con + " exception was " + jmse);
        }
    }

}
