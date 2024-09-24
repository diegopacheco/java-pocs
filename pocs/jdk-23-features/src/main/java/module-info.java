module com.github.diegopacheco.java23.features.JEP_469 {
    requires jdk.incubator.vector;
    requires org.objectweb.asm;
    requires jdk.unsupported;
    requires jdk.httpserver;

    exports com.github.diegopacheco.java23.features.JEP_476;
}
