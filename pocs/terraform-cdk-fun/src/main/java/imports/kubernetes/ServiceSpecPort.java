package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.883Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ServiceSpecPort")
@software.amazon.jsii.Jsii.Proxy(ServiceSpecPort.Jsii$Proxy.class)
public interface ServiceSpecPort extends software.amazon.jsii.JsiiSerializable {

    /**
     * The port that will be exposed by this service.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#port Service#port}
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getPort();

    /**
     * The name of this port within the service.
     * <p>
     * All ports within the service must have unique names. Optional if only one ServicePort is defined on this service.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#name Service#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * The port on each node on which this service is exposed when `type` is `NodePort` or `LoadBalancer`.
     * <p>
     * Usually assigned by the system. If specified, it will be allocated to the service if unused or else creation of the service will fail. Default is to auto-allocate a port if the <code>type</code> of this service requires one. More info: http://kubernetes.io/docs/user-guide/services#type--nodeport
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#node_port Service#node_port}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getNodePort() {
        return null;
    }

    /**
     * The IP protocol for this port. Supports `TCP` and `UDP`. Default is `TCP`.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#protocol Service#protocol}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getProtocol() {
        return null;
    }

    /**
     * Number or name of the port to access on the pods targeted by the service.
     * <p>
     * Number must be in the range 1 to 65535. This field is ignored for services with <code>cluster_ip = "None"</code>. More info: http://kubernetes.io/docs/user-guide/services#defining-a-service
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#target_port Service#target_port}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getTargetPort() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServiceSpecPort}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServiceSpecPort}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServiceSpecPort> {
        private java.lang.Number port;
        private java.lang.String name;
        private java.lang.Number nodePort;
        private java.lang.String protocol;
        private java.lang.String targetPort;

        /**
         * Sets the value of {@link ServiceSpecPort#getPort}
         * @param port The port that will be exposed by this service. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#port Service#port}
         * @return {@code this}
         */
        public Builder port(java.lang.Number port) {
            this.port = port;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpecPort#getName}
         * @param name The name of this port within the service.
         *             All ports within the service must have unique names. Optional if only one ServicePort is defined on this service.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#name Service#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpecPort#getNodePort}
         * @param nodePort The port on each node on which this service is exposed when `type` is `NodePort` or `LoadBalancer`.
         *                 Usually assigned by the system. If specified, it will be allocated to the service if unused or else creation of the service will fail. Default is to auto-allocate a port if the <code>type</code> of this service requires one. More info: http://kubernetes.io/docs/user-guide/services#type--nodeport
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#node_port Service#node_port}
         * @return {@code this}
         */
        public Builder nodePort(java.lang.Number nodePort) {
            this.nodePort = nodePort;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpecPort#getProtocol}
         * @param protocol The IP protocol for this port. Supports `TCP` and `UDP`. Default is `TCP`.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#protocol Service#protocol}
         * @return {@code this}
         */
        public Builder protocol(java.lang.String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpecPort#getTargetPort}
         * @param targetPort Number or name of the port to access on the pods targeted by the service.
         *                   Number must be in the range 1 to 65535. This field is ignored for services with <code>cluster_ip = "None"</code>. More info: http://kubernetes.io/docs/user-guide/services#defining-a-service
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#target_port Service#target_port}
         * @return {@code this}
         */
        public Builder targetPort(java.lang.String targetPort) {
            this.targetPort = targetPort;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServiceSpecPort}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServiceSpecPort build() {
            return new Jsii$Proxy(port, name, nodePort, protocol, targetPort);
        }
    }

    /**
     * An implementation for {@link ServiceSpecPort}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServiceSpecPort {
        private final java.lang.Number port;
        private final java.lang.String name;
        private final java.lang.Number nodePort;
        private final java.lang.String protocol;
        private final java.lang.String targetPort;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nodePort = software.amazon.jsii.Kernel.get(this, "nodePort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.protocol = software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.targetPort = software.amazon.jsii.Kernel.get(this, "targetPort", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.Number port, final java.lang.String name, final java.lang.Number nodePort, final java.lang.String protocol, final java.lang.String targetPort) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.port = java.util.Objects.requireNonNull(port, "port is required");
            this.name = name;
            this.nodePort = nodePort;
            this.protocol = protocol;
            this.targetPort = targetPort;
        }

        @Override
        public final java.lang.Number getPort() {
            return this.port;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.Number getNodePort() {
            return this.nodePort;
        }

        @Override
        public final java.lang.String getProtocol() {
            return this.protocol;
        }

        @Override
        public final java.lang.String getTargetPort() {
            return this.targetPort;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("port", om.valueToTree(this.getPort()));
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }
            if (this.getNodePort() != null) {
                data.set("nodePort", om.valueToTree(this.getNodePort()));
            }
            if (this.getProtocol() != null) {
                data.set("protocol", om.valueToTree(this.getProtocol()));
            }
            if (this.getTargetPort() != null) {
                data.set("targetPort", om.valueToTree(this.getTargetPort()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ServiceSpecPort"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServiceSpecPort.Jsii$Proxy that = (ServiceSpecPort.Jsii$Proxy) o;

            if (!port.equals(that.port)) return false;
            if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
            if (this.nodePort != null ? !this.nodePort.equals(that.nodePort) : that.nodePort != null) return false;
            if (this.protocol != null ? !this.protocol.equals(that.protocol) : that.protocol != null) return false;
            return this.targetPort != null ? this.targetPort.equals(that.targetPort) : that.targetPort == null;
        }

        @Override
        public final int hashCode() {
            int result = this.port.hashCode();
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            result = 31 * result + (this.nodePort != null ? this.nodePort.hashCode() : 0);
            result = 31 * result + (this.protocol != null ? this.protocol.hashCode() : 0);
            result = 31 * result + (this.targetPort != null ? this.targetPort.hashCode() : 0);
            return result;
        }
    }
}
