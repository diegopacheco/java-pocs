package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.676Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.NetworkPolicySpecEgressTo")
@software.amazon.jsii.Jsii.Proxy(NetworkPolicySpecEgressTo.Jsii$Proxy.class)
public interface NetworkPolicySpecEgressTo extends software.amazon.jsii.JsiiSerializable {

    /**
     * ip_block block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ip_block NetworkPolicy#ip_block}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock> getIpBlock() {
        return null;
    }

    /**
     * namespace_selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#namespace_selector NetworkPolicy#namespace_selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> getNamespaceSelector() {
        return null;
    }

    /**
     * pod_selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#pod_selector NetworkPolicy#pod_selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector> getPodSelector() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link NetworkPolicySpecEgressTo}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link NetworkPolicySpecEgressTo}
     */
    public static final class Builder implements software.amazon.jsii.Builder<NetworkPolicySpecEgressTo> {
        private java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock> ipBlock;
        private java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> namespaceSelector;
        private java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector> podSelector;

        /**
         * Sets the value of {@link NetworkPolicySpecEgressTo#getIpBlock}
         * @param ipBlock ip_block block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#ip_block NetworkPolicy#ip_block}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder ipBlock(java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToIpBlock> ipBlock) {
            this.ipBlock = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock>)ipBlock;
            return this;
        }

        /**
         * Sets the value of {@link NetworkPolicySpecEgressTo#getNamespaceSelector}
         * @param namespaceSelector namespace_selector block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#namespace_selector NetworkPolicy#namespace_selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder namespaceSelector(java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> namespaceSelector) {
            this.namespaceSelector = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector>)namespaceSelector;
            return this;
        }

        /**
         * Sets the value of {@link NetworkPolicySpecEgressTo#getPodSelector}
         * @param podSelector pod_selector block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/network_policy.html#pod_selector NetworkPolicy#pod_selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder podSelector(java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToPodSelector> podSelector) {
            this.podSelector = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector>)podSelector;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link NetworkPolicySpecEgressTo}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public NetworkPolicySpecEgressTo build() {
            return new Jsii$Proxy(ipBlock, namespaceSelector, podSelector);
        }
    }

    /**
     * An implementation for {@link NetworkPolicySpecEgressTo}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements NetworkPolicySpecEgressTo {
        private final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock> ipBlock;
        private final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> namespaceSelector;
        private final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector> podSelector;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.ipBlock = software.amazon.jsii.Kernel.get(this, "ipBlock", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecEgressToIpBlock.class)));
            this.namespaceSelector = software.amazon.jsii.Kernel.get(this, "namespaceSelector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector.class)));
            this.podSelector = software.amazon.jsii.Kernel.get(this, "podSelector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.NetworkPolicySpecEgressToPodSelector.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToIpBlock> ipBlock, final java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> namespaceSelector, final java.util.List<? extends imports.kubernetes.NetworkPolicySpecEgressToPodSelector> podSelector) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.ipBlock = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock>)ipBlock;
            this.namespaceSelector = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector>)namespaceSelector;
            this.podSelector = (java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector>)podSelector;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToIpBlock> getIpBlock() {
            return this.ipBlock;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToNamespaceSelector> getNamespaceSelector() {
            return this.namespaceSelector;
        }

        @Override
        public final java.util.List<imports.kubernetes.NetworkPolicySpecEgressToPodSelector> getPodSelector() {
            return this.podSelector;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getIpBlock() != null) {
                data.set("ipBlock", om.valueToTree(this.getIpBlock()));
            }
            if (this.getNamespaceSelector() != null) {
                data.set("namespaceSelector", om.valueToTree(this.getNamespaceSelector()));
            }
            if (this.getPodSelector() != null) {
                data.set("podSelector", om.valueToTree(this.getPodSelector()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.NetworkPolicySpecEgressTo"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            NetworkPolicySpecEgressTo.Jsii$Proxy that = (NetworkPolicySpecEgressTo.Jsii$Proxy) o;

            if (this.ipBlock != null ? !this.ipBlock.equals(that.ipBlock) : that.ipBlock != null) return false;
            if (this.namespaceSelector != null ? !this.namespaceSelector.equals(that.namespaceSelector) : that.namespaceSelector != null) return false;
            return this.podSelector != null ? this.podSelector.equals(that.podSelector) : that.podSelector == null;
        }

        @Override
        public final int hashCode() {
            int result = this.ipBlock != null ? this.ipBlock.hashCode() : 0;
            result = 31 * result + (this.namespaceSelector != null ? this.namespaceSelector.hashCode() : 0);
            result = 31 * result + (this.podSelector != null ? this.podSelector.hashCode() : 0);
            return result;
        }
    }
}
