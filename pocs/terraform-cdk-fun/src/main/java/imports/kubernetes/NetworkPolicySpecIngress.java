package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.677Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.NetworkPolicySpecIngress")
@software.amazon.jsii.Jsii.Proxy(NetworkPolicySpecIngress.Jsii$Proxy.class)
public interface NetworkPolicySpecIngress extends software.amazon.jsii.JsiiSerializable {

    /**
     * from block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#from NetworkPolicy#from}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom> getFrom() {
        return null;
    }

    /**
     * ports block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ports NetworkPolicy#ports}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts> getPorts() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link NetworkPolicySpecIngress}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link NetworkPolicySpecIngress}
     */
    public static final class Builder implements software.amazon.jsii.Builder<NetworkPolicySpecIngress> {
        private java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom> from;
        private java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts> ports;

        /**
         * Sets the value of {@link NetworkPolicySpecIngress#getFrom}
         * @param from from block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#from NetworkPolicy#from}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder from(java.util.List<? extends imports.kubernetes.NetworkPolicySpecIngressFrom> from) {
            this.from = (java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom>)from;
            return this;
        }

        /**
         * Sets the value of {@link NetworkPolicySpecIngress#getPorts}
         * @param ports ports block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ports NetworkPolicy#ports}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder ports(java.util.List<? extends imports.kubernetes.NetworkPolicySpecIngressPorts> ports) {
            this.ports = (java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts>)ports;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link NetworkPolicySpecIngress}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public NetworkPolicySpecIngress build() {
            return new Jsii$Proxy(from, ports);
        }
    }

    /**
     * An implementation for {@link NetworkPolicySpecIngress}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements NetworkPolicySpecIngress {
        private final java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom> from;
        private final java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts> ports;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.from = software.amazon.jsii.Kernel.get(this, "from", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecIngressFrom.class)));
            this.ports = software.amazon.jsii.Kernel.get(this, "ports", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecIngressPorts.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.NetworkPolicySpecIngressFrom> from, final java.util.List<? extends imports.kubernetes.NetworkPolicySpecIngressPorts> ports) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.from = (java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom>)from;
            this.ports = (java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts>)ports;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecIngressFrom> getFrom() {
            return this.from;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecIngressPorts> getPorts() {
            return this.ports;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getFrom() != null) {
                data.set("from", om.valueToTree(this.getFrom()));
            }
            if (this.getPorts() != null) {
                data.set("ports", om.valueToTree(this.getPorts()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.NetworkPolicySpecIngress"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NetworkPolicySpecIngress.Jsii$Proxy that = (NetworkPolicySpecIngress.Jsii$Proxy) o;

            if (this.from != null ? !this.from.equals(that.from) : that.from != null) return false;
            return this.ports != null ? this.ports.equals(that.ports) : that.ports == null;
        }

        @Override
        public final int hashCode() {
            int result = this.from != null ? this.from.hashCode() : 0;
            result = 31 * result + (this.ports != null ? this.ports.hashCode() : 0);
            return result;
        }
    }
}
