package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.594Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.EndpointsSubsetAddress")
@software.amazon.jsii.Jsii.Proxy(EndpointsSubsetAddress.Jsii$Proxy.class)
public interface EndpointsSubsetAddress extends software.amazon.jsii.JsiiSerializable {

    /**
     * The IP of this endpoint. May not be loopback (127.0.0.0/8), link-local (169.254.0.0/16), or link-local multicast ((224.0.0.0/24).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#ip Endpoints#ip}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getIp();

    /**
     * The Hostname of this endpoint.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#hostname Endpoints#hostname}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getHostname() {
        return null;
    }

    /**
     * Node hosting this endpoint. This can be used to determine endpoints local to a node.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#node_name Endpoints#node_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getNodeName() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link EndpointsSubsetAddress}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link EndpointsSubsetAddress}
     */
    public static final class Builder implements software.amazon.jsii.Builder<EndpointsSubsetAddress> {
        private java.lang.String ip;
        private java.lang.String hostname;
        private java.lang.String nodeName;

        /**
         * Sets the value of {@link EndpointsSubsetAddress#getIp}
         * @param ip The IP of this endpoint. May not be loopback (127.0.0.0/8), link-local (169.254.0.0/16), or link-local multicast ((224.0.0.0/24). This parameter is required.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#ip Endpoints#ip}
         * @return {@code this}
         */
        public Builder ip(java.lang.String ip) {
            this.ip = ip;
            return this;
        }

        /**
         * Sets the value of {@link EndpointsSubsetAddress#getHostname}
         * @param hostname The Hostname of this endpoint.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#hostname Endpoints#hostname}
         * @return {@code this}
         */
        public Builder hostname(java.lang.String hostname) {
            this.hostname = hostname;
            return this;
        }

        /**
         * Sets the value of {@link EndpointsSubsetAddress#getNodeName}
         * @param nodeName Node hosting this endpoint. This can be used to determine endpoints local to a node.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#node_name Endpoints#node_name}
         * @return {@code this}
         */
        public Builder nodeName(java.lang.String nodeName) {
            this.nodeName = nodeName;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link EndpointsSubsetAddress}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public EndpointsSubsetAddress build() {
            return new Jsii$Proxy(ip, hostname, nodeName);
        }
    }

    /**
     * An implementation for {@link EndpointsSubsetAddress}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements EndpointsSubsetAddress {
        private final java.lang.String ip;
        private final java.lang.String hostname;
        private final java.lang.String nodeName;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.ip = software.amazon.jsii.Kernel.get(this, "ip", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.hostname = software.amazon.jsii.Kernel.get(this, "hostname", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nodeName = software.amazon.jsii.Kernel.get(this, "nodeName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String ip, final java.lang.String hostname, final java.lang.String nodeName) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.ip = java.util.Objects.requireNonNull(ip, "ip is required");
            this.hostname = hostname;
            this.nodeName = nodeName;
        }

        @Override
        public final java.lang.String getIp() {
            return this.ip;
        }

        @Override
        public final java.lang.String getHostname() {
            return this.hostname;
        }

        @Override
        public final java.lang.String getNodeName() {
            return this.nodeName;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("ip", om.valueToTree(this.getIp()));
            if (this.getHostname() != null) {
                data.set("hostname", om.valueToTree(this.getHostname()));
            }
            if (this.getNodeName() != null) {
                data.set("nodeName", om.valueToTree(this.getNodeName()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.EndpointsSubsetAddress"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EndpointsSubsetAddress.Jsii$Proxy that = (EndpointsSubsetAddress.Jsii$Proxy) o;

            if (!ip.equals(that.ip)) return false;
            if (this.hostname != null ? !this.hostname.equals(that.hostname) : that.hostname != null) return false;
            return this.nodeName != null ? this.nodeName.equals(that.nodeName) : that.nodeName == null;
        }

        @Override
        public final int hashCode() {
            int result = this.ip.hashCode();
            result = 31 * result + (this.hostname != null ? this.hostname.hashCode() : 0);
            result = 31 * result + (this.nodeName != null ? this.nodeName.hashCode() : 0);
            return result;
        }
    }
}
