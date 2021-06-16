package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.676Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.NetworkPolicySpecEgress")
@software.amazon.jsii.Jsii.Proxy(NetworkPolicySpecEgress.Jsii$Proxy.class)
public interface NetworkPolicySpecEgress extends software.amazon.jsii.JsiiSerializable {

    /**
     * ports block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ports NetworkPolicy#ports}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts> getPorts() {
        return null;
    }

    /**
     * to block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#to NetworkPolicy#to}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo> getTo() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link NetworkPolicySpecEgress}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link NetworkPolicySpecEgress}
     */
    public static final class Builder implements software.amazon.jsii.Builder<NetworkPolicySpecEgress> {
        private java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts> ports;
        private java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo> to;

        /**
         * Sets the value of {@link NetworkPolicySpecEgress#getPorts}
         * @param ports ports block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ports NetworkPolicy#ports}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder ports(java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressPorts> ports) {
            this.ports = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts>)ports;
            return this;
        }

        /**
         * Sets the value of {@link NetworkPolicySpecEgress#getTo}
         * @param to to block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#to NetworkPolicy#to}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder to(java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressTo> to) {
            this.to = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo>)to;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link NetworkPolicySpecEgress}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public NetworkPolicySpecEgress build() {
            return new Jsii$Proxy(ports, to);
        }
    }

    /**
     * An implementation for {@link NetworkPolicySpecEgress}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements NetworkPolicySpecEgress {
        private final java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts> ports;
        private final java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo> to;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.ports = software.amazon.jsii.Kernel.get(this, "ports", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecEgressPorts.class)));
            this.to = software.amazon.jsii.Kernel.get(this, "to", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecEgressTo.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressPorts> ports, final java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressTo> to) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.ports = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts>)ports;
            this.to = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo>)to;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecEgressPorts> getPorts() {
            return this.ports;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecEgressTo> getTo() {
            return this.to;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getPorts() != null) {
                data.set("ports", om.valueToTree(this.getPorts()));
            }
            if (this.getTo() != null) {
                data.set("to", om.valueToTree(this.getTo()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.NetworkPolicySpecEgress"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NetworkPolicySpecEgress.Jsii$Proxy that = (NetworkPolicySpecEgress.Jsii$Proxy) o;

            if (this.ports != null ? !this.ports.equals(that.ports) : that.ports != null) return false;
            return this.to != null ? this.to.equals(that.to) : that.to == null;
        }

        @Override
        public final int hashCode() {
            int result = this.ports != null ? this.ports.hashCode() : 0;
            result = 31 * result + (this.to != null ? this.to.hashCode() : 0);
            return result;
        }
    }
}
