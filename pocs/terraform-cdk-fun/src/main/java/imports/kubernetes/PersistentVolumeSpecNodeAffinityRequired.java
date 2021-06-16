package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.683Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PersistentVolumeSpecNodeAffinityRequired")
@software.amazon.jsii.Jsii.Proxy(PersistentVolumeSpecNodeAffinityRequired.Jsii$Proxy.class)
public interface PersistentVolumeSpecNodeAffinityRequired extends software.amazon.jsii.JsiiSerializable {

    /**
     * node_selector_term block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#node_selector_term PersistentVolume#node_selector_term}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> getNodeSelectorTerm();

    /**
     * @return a {@link Builder} of {@link PersistentVolumeSpecNodeAffinityRequired}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PersistentVolumeSpecNodeAffinityRequired}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PersistentVolumeSpecNodeAffinityRequired> {
        private java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> nodeSelectorTerm;

        /**
         * Sets the value of {@link PersistentVolumeSpecNodeAffinityRequired#getNodeSelectorTerm}
         * @param nodeSelectorTerm node_selector_term block. This parameter is required.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#node_selector_term PersistentVolume#node_selector_term}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nodeSelectorTerm(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> nodeSelectorTerm) {
            this.nodeSelectorTerm = (java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm>)nodeSelectorTerm;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PersistentVolumeSpecNodeAffinityRequired}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PersistentVolumeSpecNodeAffinityRequired build() {
            return new Jsii$Proxy(nodeSelectorTerm);
        }
    }

    /**
     * An implementation for {@link PersistentVolumeSpecNodeAffinityRequired}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PersistentVolumeSpecNodeAffinityRequired {
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> nodeSelectorTerm;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.nodeSelectorTerm = software.amazon.jsii.Kernel.get(this, "nodeSelectorTerm", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> nodeSelectorTerm) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.nodeSelectorTerm = (java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm>)java.util.Objects.requireNonNull(nodeSelectorTerm, "nodeSelectorTerm is required");
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinityRequiredNodeSelectorTerm> getNodeSelectorTerm() {
            return this.nodeSelectorTerm;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("nodeSelectorTerm", om.valueToTree(this.getNodeSelectorTerm()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PersistentVolumeSpecNodeAffinityRequired"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersistentVolumeSpecNodeAffinityRequired.Jsii$Proxy that = (PersistentVolumeSpecNodeAffinityRequired.Jsii$Proxy) o;

            return this.nodeSelectorTerm.equals(that.nodeSelectorTerm);
        }

        @Override
        public final int hashCode() {
            int result = this.nodeSelectorTerm.hashCode();
            return result;
        }
    }
}
