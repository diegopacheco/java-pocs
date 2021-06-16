package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.931Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecContainerPort")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecContainerPort.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecContainerPort extends software.amazon.jsii.JsiiSerializable {

    /**
     * Number of port to expose on the pod's IP address.
     * <p>
     * This must be a valid port number, 0 &lt; x &lt; 65536.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#container_port StatefulSet#container_port}
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getContainerPort();

    /**
     * What host IP to bind the external port to.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_ip StatefulSet#host_ip}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getHostIp() {
        return null;
    }

    /**
     * Number of port to expose on the host.
     * <p>
     * If specified, this must be a valid port number, 0 &lt; x &lt; 65536. If HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_port StatefulSet#host_port}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getHostPort() {
        return null;
    }

    /**
     * If specified, this must be an IANA_SVC_NAME and unique within the pod.
     * <p>
     * Each named port in a pod must have a unique name. Name for the port that can be referred to by services
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#name StatefulSet#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * Protocol for port. Must be UDP or TCP. Defaults to "TCP".
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#protocol StatefulSet#protocol}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getProtocol() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecContainerPort}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecContainerPort}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecContainerPort> {
        private java.lang.Number containerPort;
        private java.lang.String hostIp;
        private java.lang.Number hostPort;
        private java.lang.String name;
        private java.lang.String protocol;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerPort#getContainerPort}
         * @param containerPort Number of port to expose on the pod's IP address. This parameter is required.
         *                      This must be a valid port number, 0 &lt; x &lt; 65536.
         *                      <p>
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#container_port StatefulSet#container_port}
         * @return {@code this}
         */
        public Builder containerPort(java.lang.Number containerPort) {
            this.containerPort = containerPort;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerPort#getHostIp}
         * @param hostIp What host IP to bind the external port to.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_ip StatefulSet#host_ip}
         * @return {@code this}
         */
        public Builder hostIp(java.lang.String hostIp) {
            this.hostIp = hostIp;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerPort#getHostPort}
         * @param hostPort Number of port to expose on the host.
         *                 If specified, this must be a valid port number, 0 &lt; x &lt; 65536. If HostNetwork is specified, this must match ContainerPort. Most containers do not need this.
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_port StatefulSet#host_port}
         * @return {@code this}
         */
        public Builder hostPort(java.lang.Number hostPort) {
            this.hostPort = hostPort;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerPort#getName}
         * @param name If specified, this must be an IANA_SVC_NAME and unique within the pod.
         *             Each named port in a pod must have a unique name. Name for the port that can be referred to by services
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#name StatefulSet#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerPort#getProtocol}
         * @param protocol Protocol for port. Must be UDP or TCP. Defaults to "TCP".
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#protocol StatefulSet#protocol}
         * @return {@code this}
         */
        public Builder protocol(java.lang.String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecContainerPort}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecContainerPort build() {
            return new Jsii$Proxy(containerPort, hostIp, hostPort, name, protocol);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecContainerPort}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecContainerPort {
        private final java.lang.Number containerPort;
        private final java.lang.String hostIp;
        private final java.lang.Number hostPort;
        private final java.lang.String name;
        private final java.lang.String protocol;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.containerPort = software.amazon.jsii.Kernel.get(this, "containerPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.hostIp = software.amazon.jsii.Kernel.get(this, "hostIp", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.hostPort = software.amazon.jsii.Kernel.get(this, "hostPort", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.protocol = software.amazon.jsii.Kernel.get(this, "protocol", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.Number containerPort, final java.lang.String hostIp, final java.lang.Number hostPort, final java.lang.String name, final java.lang.String protocol) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.containerPort = java.util.Objects.requireNonNull(containerPort, "containerPort is required");
            this.hostIp = hostIp;
            this.hostPort = hostPort;
            this.name = name;
            this.protocol = protocol;
        }

        @Override
        public final java.lang.Number getContainerPort() {
            return this.containerPort;
        }

        @Override
        public final java.lang.String getHostIp() {
            return this.hostIp;
        }

        @Override
        public final java.lang.Number getHostPort() {
            return this.hostPort;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.String getProtocol() {
            return this.protocol;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("containerPort", om.valueToTree(this.getContainerPort()));
            if (this.getHostIp() != null) {
                data.set("hostIp", om.valueToTree(this.getHostIp()));
            }
            if (this.getHostPort() != null) {
                data.set("hostPort", om.valueToTree(this.getHostPort()));
            }
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }
            if (this.getProtocol() != null) {
                data.set("protocol", om.valueToTree(this.getProtocol()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecContainerPort"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecContainerPort.Jsii$Proxy that = (StatefulSetSpecTemplateSpecContainerPort.Jsii$Proxy) o;

            if (!containerPort.equals(that.containerPort)) return false;
            if (this.hostIp != null ? !this.hostIp.equals(that.hostIp) : that.hostIp != null) return false;
            if (this.hostPort != null ? !this.hostPort.equals(that.hostPort) : that.hostPort != null) return false;
            if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
            return this.protocol != null ? this.protocol.equals(that.protocol) : that.protocol == null;
        }

        @Override
        public final int hashCode() {
            int result = this.containerPort.hashCode();
            result = 31 * result + (this.hostIp != null ? this.hostIp.hashCode() : 0);
            result = 31 * result + (this.hostPort != null ? this.hostPort.hashCode() : 0);
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            result = 31 * result + (this.protocol != null ? this.protocol.hashCode() : 0);
            return result;
        }
    }
}
