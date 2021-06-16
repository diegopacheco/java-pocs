package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.594Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.EndpointsSubset")
@software.amazon.jsii.Jsii.Proxy(EndpointsSubset.Jsii$Proxy.class)
public interface EndpointsSubset extends software.amazon.jsii.JsiiSerializable {

    /**
     * address block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#address Endpoints#address}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.EndpointsSubsetAddress> getAddress() {
        return null;
    }

    /**
     * not_ready_address block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#not_ready_address Endpoints#not_ready_address}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress> getNotReadyAddress() {
        return null;
    }

    /**
     * port block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#port Endpoints#port}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.EndpointsSubsetPort> getPort() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link EndpointsSubset}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link EndpointsSubset}
     */
    public static final class Builder implements software.amazon.jsii.Builder<EndpointsSubset> {
        private java.util.List<imports.kubernetes.EndpointsSubsetAddress> address;
        private java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress> notReadyAddress;
        private java.util.List<imports.kubernetes.EndpointsSubsetPort> port;

        /**
         * Sets the value of {@link EndpointsSubset#getAddress}
         * @param address address block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#address Endpoints#address}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder address(java.util.List<? extends imports.kubernetes.EndpointsSubsetAddress> address) {
            this.address = (java.util.List<imports.kubernetes.EndpointsSubsetAddress>)address;
            return this;
        }

        /**
         * Sets the value of {@link EndpointsSubset#getNotReadyAddress}
         * @param notReadyAddress not_ready_address block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#not_ready_address Endpoints#not_ready_address}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder notReadyAddress(java.util.List<? extends imports.kubernetes.EndpointsSubsetNotReadyAddress> notReadyAddress) {
            this.notReadyAddress = (java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress>)notReadyAddress;
            return this;
        }

        /**
         * Sets the value of {@link EndpointsSubset#getPort}
         * @param port port block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#port Endpoints#port}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder port(java.util.List<? extends imports.kubernetes.EndpointsSubsetPort> port) {
            this.port = (java.util.List<imports.kubernetes.EndpointsSubsetPort>)port;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link EndpointsSubset}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public EndpointsSubset build() {
            return new Jsii$Proxy(address, notReadyAddress, port);
        }
    }

    /**
     * An implementation for {@link EndpointsSubset}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements EndpointsSubset {
        private final java.util.List<imports.kubernetes.EndpointsSubsetAddress> address;
        private final java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress> notReadyAddress;
        private final java.util.List<imports.kubernetes.EndpointsSubsetPort> port;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.address = software.amazon.jsii.Kernel.get(this, "address", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsSubsetAddress.class)));
            this.notReadyAddress = software.amazon.jsii.Kernel.get(this, "notReadyAddress", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsSubsetNotReadyAddress.class)));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsSubsetPort.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.EndpointsSubsetAddress> address, final java.util.List<? extends imports.kubernetes.EndpointsSubsetNotReadyAddress> notReadyAddress, final java.util.List<? extends imports.kubernetes.EndpointsSubsetPort> port) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.address = (java.util.List<imports.kubernetes.EndpointsSubsetAddress>)address;
            this.notReadyAddress = (java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress>)notReadyAddress;
            this.port = (java.util.List<imports.kubernetes.EndpointsSubsetPort>)port;
        }

        @Override
        public final java.util.List<imports.kubernetes.EndpointsSubsetAddress> getAddress() {
            return this.address;
        }

        @Override
        public final java.util.List<imports.kubernetes.EndpointsSubsetNotReadyAddress> getNotReadyAddress() {
            return this.notReadyAddress;
        }

        @Override
        public final java.util.List<imports.kubernetes.EndpointsSubsetPort> getPort() {
            return this.port;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAddress() != null) {
                data.set("address", om.valueToTree(this.getAddress()));
            }
            if (this.getNotReadyAddress() != null) {
                data.set("notReadyAddress", om.valueToTree(this.getNotReadyAddress()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.EndpointsSubset"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EndpointsSubset.Jsii$Proxy that = (EndpointsSubset.Jsii$Proxy) o;

            if (this.address != null ? !this.address.equals(that.address) : that.address != null) return false;
            if (this.notReadyAddress != null ? !this.notReadyAddress.equals(that.notReadyAddress) : that.notReadyAddress != null) return false;
            return this.port != null ? this.port.equals(that.port) : that.port == null;
        }

        @Override
        public final int hashCode() {
            int result = this.address != null ? this.address.hashCode() : 0;
            result = 31 * result + (this.notReadyAddress != null ? this.notReadyAddress.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            return result;
        }
    }
}
