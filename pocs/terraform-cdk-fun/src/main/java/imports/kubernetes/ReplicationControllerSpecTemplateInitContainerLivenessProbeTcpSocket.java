package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.797Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket extends software.amazon.jsii.JsiiSerializable {

    /**
     * Number or name of the port to access on the container.
     * <p>
     * Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#port ReplicationController#port}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getPort();

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket> {
        private java.lang.String port;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket#getPort}
         * @param port Number or name of the port to access on the container. This parameter is required.
         *             Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#port ReplicationController#port}
         * @return {@code this}
         */
        public Builder port(java.lang.String port) {
            this.port = port;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket build() {
            return new Jsii$Proxy(port);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket {
        private final java.lang.String port;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String port) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.port = java.util.Objects.requireNonNull(port, "port is required");
        }

        @Override
        public final java.lang.String getPort() {
            return this.port;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("port", om.valueToTree(this.getPort()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket.Jsii$Proxy that = (ReplicationControllerSpecTemplateInitContainerLivenessProbeTcpSocket.Jsii$Proxy) o;

            return this.port.equals(that.port);
        }

        @Override
        public final int hashCode() {
            int result = this.port.hashCode();
            return result;
        }
    }
}
