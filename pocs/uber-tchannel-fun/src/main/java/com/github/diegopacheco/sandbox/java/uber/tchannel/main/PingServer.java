package com.github.diegopacheco.sandbox.java.uber.tchannel.main;


import com.uber.tchannel.api.TChannel;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import java.net.InetAddress;

public class PingServer {

    private int port;

    public PingServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        Options options = new Options();
        options.addOption("p", "port", true, "Server Port to connect to");
        options.addOption("?", "help", false, "Usage");
        HelpFormatter formatter = new HelpFormatter();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("?")) {
            formatter.printHelp("PingClient", options, true);
            return;
        }

        int port = Integer.parseInt(cmd.getOptionValue("p", "8888"));

        System.out.println(String.format("Starting server on port: %d", port));
        new PingServer(port).run();
        System.out.println("Stopping server...");
    }

    public void run() throws Exception {
        TChannel tchannel = new TChannel.Builder("ping-server")
                .setServerHost(InetAddress.getLoopbackAddress())
                .setServerPort(this.port)
                .build();
        tchannel.makeSubChannel("ping-server")
            .register("ping", new PingRequestHandler());

        tchannel.listen().channel().closeFuture().sync();
    }

}