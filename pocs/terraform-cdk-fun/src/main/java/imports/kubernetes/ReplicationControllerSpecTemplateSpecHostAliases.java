package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.830Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateSpecHostAliases")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateSpecHostAliases.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateSpecHostAliases extends software.amazon.jsii.JsiiSerializable {

    /**
     * Hostnames for the IP address.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#hostnames ReplicationController#hostnames}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getHostnames();

    /**
     * IP address of the host file entry.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ip ReplicationController#ip}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getIp();

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateSpecHostAliases}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateSpecHostAliases}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateSpecHostAliases> {
        private java.util.List<java.lang.String> hostnames;
        private java.lang.String ip;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecHostAliases#getHostnames}
         * @param hostnames Hostnames for the IP address. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#hostnames ReplicationController#hostnames}
         * @return {@code this}
         */
        public Builder hostnames(java.util.List<java.lang.String> hostnames) {
            this.hostnames = hostnames;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecHostAliases#getIp}
         * @param ip IP address of the host file entry. This parameter is required.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ip ReplicationController#ip}
         * @return {@code this}
         */
        public Builder ip(java.lang.String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateSpecHostAliases}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateSpecHostAliases build() {
            return new Jsii$Proxy(hostnames, ip);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateSpecHostAliases}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateSpecHostAliases {
        private final java.util.List<java.lang.String> hostnames;
        private final java.lang.String ip;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.hostnames = software.amazon.jsii.Kernel.get(this, "hostnames", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.ip = software.amazon.jsii.Kernel.get(this, "ip", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.List<java.lang.String> hostnames, final java.lang.String ip) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.hostnames = java.util.Objects.requireNonNull(hostnames, "hostnames is required");
            this.ip = java.util.Objects.requireNonNull(ip, "ip is required");
        }

        @Override
        public final java.util.List<java.lang.String> getHostnames() {
            return this.hostnames;
        }

        @Override
        public final java.lang.String getIp() {
            return this.ip;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("hostnames", om.valueToTree(this.getHostnames()));
            data.set("ip", om.valueToTree(this.getIp()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateSpecHostAliases"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateSpecHostAliases.Jsii$Proxy that = (ReplicationControllerSpecTemplateSpecHostAliases.Jsii$Proxy) o;

            if (!hostnames.equals(that.hostnames)) return false;
            return this.ip.equals(that.ip);
        }

        @Override
        public final int hashCode() {
            int result = this.hostnames.hashCode();
            result = 31 * result + (this.ip.hashCode());
            return result;
        }
    }
}
