package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.506Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DataKubernetesPersistentVolumeClaimSpec")
@software.amazon.jsii.Jsii.Proxy(DataKubernetesPersistentVolumeClaimSpec.Jsii$Proxy.class)
public interface DataKubernetesPersistentVolumeClaimSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#selector DataKubernetesPersistentVolumeClaim#selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> getSelector() {
        return null;
    }

    /**
     * Name of the storage class requested by the claim.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#storage_class_name DataKubernetesPersistentVolumeClaim#storage_class_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getStorageClassName() {
        return null;
    }

    /**
     * The binding reference to the PersistentVolume backing this claim.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#volume_name DataKubernetesPersistentVolumeClaim#volume_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getVolumeName() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DataKubernetesPersistentVolumeClaimSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataKubernetesPersistentVolumeClaimSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataKubernetesPersistentVolumeClaimSpec> {
        private java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> selector;
        private java.lang.String storageClassName;
        private java.lang.String volumeName;

        /**
         * Sets the value of {@link DataKubernetesPersistentVolumeClaimSpec#getSelector}
         * @param selector selector block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#selector DataKubernetesPersistentVolumeClaim#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link DataKubernetesPersistentVolumeClaimSpec#getStorageClassName}
         * @param storageClassName Name of the storage class requested by the claim.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#storage_class_name DataKubernetesPersistentVolumeClaim#storage_class_name}
         * @return {@code this}
         */
        public Builder storageClassName(java.lang.String storageClassName) {
            this.storageClassName = storageClassName;
            return this;
        }

        /**
         * Sets the value of {@link DataKubernetesPersistentVolumeClaimSpec#getVolumeName}
         * @param volumeName The binding reference to the PersistentVolume backing this claim.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/persistent_volume_claim.html#volume_name DataKubernetesPersistentVolumeClaim#volume_name}
         * @return {@code this}
         */
        public Builder volumeName(java.lang.String volumeName) {
            this.volumeName = volumeName;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataKubernetesPersistentVolumeClaimSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataKubernetesPersistentVolumeClaimSpec build() {
            return new Jsii$Proxy(selector, storageClassName, volumeName);
        }
    }

    /**
     * An implementation for {@link DataKubernetesPersistentVolumeClaimSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataKubernetesPersistentVolumeClaimSpec {
        private final java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> selector;
        private final java.lang.String storageClassName;
        private final java.lang.String volumeName;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector.class)));
            this.storageClassName = software.amazon.jsii.Kernel.get(this, "storageClassName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.volumeName = software.amazon.jsii.Kernel.get(this, "volumeName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> selector, final java.lang.String storageClassName, final java.lang.String volumeName) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.selector = (java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector>)selector;
            this.storageClassName = storageClassName;
            this.volumeName = volumeName;
        }

        @Override
        public final java.util.List<imports.kubernetes.DataKubernetesPersistentVolumeClaimSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.lang.String getStorageClassName() {
            return this.storageClassName;
        }

        @Override
        public final java.lang.String getVolumeName() {
            return this.volumeName;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getSelector() != null) {
                data.set("selector", om.valueToTree(this.getSelector()));
            }
            if (this.getStorageClassName() != null) {
                data.set("storageClassName", om.valueToTree(this.getStorageClassName()));
            }
            if (this.getVolumeName() != null) {
                data.set("volumeName", om.valueToTree(this.getVolumeName()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DataKubernetesPersistentVolumeClaimSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataKubernetesPersistentVolumeClaimSpec.Jsii$Proxy that = (DataKubernetesPersistentVolumeClaimSpec.Jsii$Proxy) o;

            if (this.selector != null ? !this.selector.equals(that.selector) : that.selector != null) return false;
            if (this.storageClassName != null ? !this.storageClassName.equals(that.storageClassName) : that.storageClassName != null) return false;
            return this.volumeName != null ? this.volumeName.equals(that.volumeName) : that.volumeName == null;
        }

        @Override
        public final int hashCode() {
            int result = this.selector != null ? this.selector.hashCode() : 0;
            result = 31 * result + (this.storageClassName != null ? this.storageClassName.hashCode() : 0);
            result = 31 * result + (this.volumeName != null ? this.volumeName.hashCode() : 0);
            return result;
        }
    }
}
