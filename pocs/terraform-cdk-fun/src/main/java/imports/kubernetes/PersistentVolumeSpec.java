package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.682Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PersistentVolumeSpec")
@software.amazon.jsii.Jsii.Proxy(PersistentVolumeSpec.Jsii$Proxy.class)
public interface PersistentVolumeSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * Contains all ways the volume can be mounted. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#access-modes.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#access_modes PersistentVolume#access_modes}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getAccessModes();

    /**
     * A description of the persistent volume's resources and capacity. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#capacity.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#capacity PersistentVolume#capacity}
     */
    @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> getCapacity();

    /**
     * persistent_volume_source block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#persistent_volume_source PersistentVolume#persistent_volume_source}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> getPersistentVolumeSource();

    /**
     * A list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#mount_options PersistentVolume#mount_options}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getMountOptions() {
        return null;
    }

    /**
     * node_affinity block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#node_affinity PersistentVolume#node_affinity}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity> getNodeAffinity() {
        return null;
    }

    /**
     * What happens to a persistent volume when released from its claim.
     * <p>
     * Valid options are Retain (default) and Recycle. Recycling must be supported by the volume plugin underlying this persistent volume. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#recycling-policy
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#persistent_volume_reclaim_policy PersistentVolume#persistent_volume_reclaim_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPersistentVolumeReclaimPolicy() {
        return null;
    }

    /**
     * A description of the persistent volume's class. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#class.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#storage_class_name PersistentVolume#storage_class_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getStorageClassName() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PersistentVolumeSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PersistentVolumeSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PersistentVolumeSpec> {
        private java.util.List<java.lang.String> accessModes;
        private java.util.Map<java.lang.String, java.lang.String> capacity;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> persistentVolumeSource;
        private java.util.List<java.lang.String> mountOptions;
        private java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity> nodeAffinity;
        private java.lang.String persistentVolumeReclaimPolicy;
        private java.lang.String storageClassName;

        /**
         * Sets the value of {@link PersistentVolumeSpec#getAccessModes}
         * @param accessModes Contains all ways the volume can be mounted. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#access-modes. This parameter is required.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#access_modes PersistentVolume#access_modes}
         * @return {@code this}
         */
        public Builder accessModes(java.util.List<java.lang.String> accessModes) {
            this.accessModes = accessModes;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getCapacity}
         * @param capacity A description of the persistent volume's resources and capacity. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#capacity. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#capacity PersistentVolume#capacity}
         * @return {@code this}
         */
        public Builder capacity(java.util.Map<java.lang.String, java.lang.String> capacity) {
            this.capacity = capacity;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getPersistentVolumeSource}
         * @param persistentVolumeSource persistent_volume_source block. This parameter is required.
         *                               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#persistent_volume_source PersistentVolume#persistent_volume_source}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeSource(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> persistentVolumeSource) {
            this.persistentVolumeSource = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource>)persistentVolumeSource;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getMountOptions}
         * @param mountOptions A list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#mount_options PersistentVolume#mount_options}
         * @return {@code this}
         */
        public Builder mountOptions(java.util.List<java.lang.String> mountOptions) {
            this.mountOptions = mountOptions;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getNodeAffinity}
         * @param nodeAffinity node_affinity block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#node_affinity PersistentVolume#node_affinity}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nodeAffinity(java.util.List<? extends imports.kubernetes.PersistentVolumeSpecNodeAffinity> nodeAffinity) {
            this.nodeAffinity = (java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity>)nodeAffinity;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getPersistentVolumeReclaimPolicy}
         * @param persistentVolumeReclaimPolicy What happens to a persistent volume when released from its claim.
         *                                      Valid options are Retain (default) and Recycle. Recycling must be supported by the volume plugin underlying this persistent volume. More info: http://kubernetes.io/docs/user-guide/persistent-volumes#recycling-policy
         *                                      <p>
         *                                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#persistent_volume_reclaim_policy PersistentVolume#persistent_volume_reclaim_policy}
         * @return {@code this}
         */
        public Builder persistentVolumeReclaimPolicy(java.lang.String persistentVolumeReclaimPolicy) {
            this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
            return this;
        }

        /**
         * Sets the value of {@link PersistentVolumeSpec#getStorageClassName}
         * @param storageClassName A description of the persistent volume's class. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#class.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume.html#storage_class_name PersistentVolume#storage_class_name}
         * @return {@code this}
         */
        public Builder storageClassName(java.lang.String storageClassName) {
            this.storageClassName = storageClassName;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PersistentVolumeSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PersistentVolumeSpec build() {
            return new Jsii$Proxy(accessModes, capacity, persistentVolumeSource, mountOptions, nodeAffinity, persistentVolumeReclaimPolicy, storageClassName);
        }
    }

    /**
     * An implementation for {@link PersistentVolumeSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PersistentVolumeSpec {
        private final java.util.List<java.lang.String> accessModes;
        private final java.util.Map<java.lang.String, java.lang.String> capacity;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> persistentVolumeSource;
        private final java.util.List<java.lang.String> mountOptions;
        private final java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity> nodeAffinity;
        private final java.lang.String persistentVolumeReclaimPolicy;
        private final java.lang.String storageClassName;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.accessModes = software.amazon.jsii.Kernel.get(this, "accessModes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.capacity = software.amazon.jsii.Kernel.get(this, "capacity", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.persistentVolumeSource = software.amazon.jsii.Kernel.get(this, "persistentVolumeSource", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource.class)));
            this.mountOptions = software.amazon.jsii.Kernel.get(this, "mountOptions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.nodeAffinity = software.amazon.jsii.Kernel.get(this, "nodeAffinity", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeSpecNodeAffinity.class)));
            this.persistentVolumeReclaimPolicy = software.amazon.jsii.Kernel.get(this, "persistentVolumeReclaimPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.storageClassName = software.amazon.jsii.Kernel.get(this, "storageClassName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<java.lang.String> accessModes, final java.util.Map<java.lang.String, java.lang.String> capacity, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> persistentVolumeSource, final java.util.List<java.lang.String> mountOptions, final java.util.List<? extends imports.kubernetes.PersistentVolumeSpecNodeAffinity> nodeAffinity, final java.lang.String persistentVolumeReclaimPolicy, final java.lang.String storageClassName) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.accessModes = java.util.Objects.requireNonNull(accessModes, "accessModes is required");
            this.capacity = java.util.Objects.requireNonNull(capacity, "capacity is required");
            this.persistentVolumeSource = (java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource>)java.util.Objects.requireNonNull(persistentVolumeSource, "persistentVolumeSource is required");
            this.mountOptions = mountOptions;
            this.nodeAffinity = (java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity>)nodeAffinity;
            this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
            this.storageClassName = storageClassName;
        }

        @Override
        public final java.util.List<java.lang.String> getAccessModes() {
            return this.accessModes;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getCapacity() {
            return this.capacity;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecPersistentVolumeSource> getPersistentVolumeSource() {
            return this.persistentVolumeSource;
        }

        @Override
        public final java.util.List<java.lang.String> getMountOptions() {
            return this.mountOptions;
        }

        @Override
        public final java.util.List<imports.kubernetes.PersistentVolumeSpecNodeAffinity> getNodeAffinity() {
            return this.nodeAffinity;
        }

        @Override
        public final java.lang.String getPersistentVolumeReclaimPolicy() {
            return this.persistentVolumeReclaimPolicy;
        }

        @Override
        public final java.lang.String getStorageClassName() {
            return this.storageClassName;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("accessModes", om.valueToTree(this.getAccessModes()));
            data.set("capacity", om.valueToTree(this.getCapacity()));
            data.set("persistentVolumeSource", om.valueToTree(this.getPersistentVolumeSource()));
            if (this.getMountOptions() != null) {
                data.set("mountOptions", om.valueToTree(this.getMountOptions()));
            }
            if (this.getNodeAffinity() != null) {
                data.set("nodeAffinity", om.valueToTree(this.getNodeAffinity()));
            }
            if (this.getPersistentVolumeReclaimPolicy() != null) {
                data.set("persistentVolumeReclaimPolicy", om.valueToTree(this.getPersistentVolumeReclaimPolicy()));
            }
            if (this.getStorageClassName() != null) {
                data.set("storageClassName", om.valueToTree(this.getStorageClassName()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PersistentVolumeSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PersistentVolumeSpec.Jsii$Proxy that = (PersistentVolumeSpec.Jsii$Proxy) o;

            if (!accessModes.equals(that.accessModes)) return false;
            if (!capacity.equals(that.capacity)) return false;
            if (!persistentVolumeSource.equals(that.persistentVolumeSource)) return false;
            if (this.mountOptions != null ? !this.mountOptions.equals(that.mountOptions) : that.mountOptions != null) return false;
            if (this.nodeAffinity != null ? !this.nodeAffinity.equals(that.nodeAffinity) : that.nodeAffinity != null) return false;
            if (this.persistentVolumeReclaimPolicy != null ? !this.persistentVolumeReclaimPolicy.equals(that.persistentVolumeReclaimPolicy) : that.persistentVolumeReclaimPolicy != null) return false;
            return this.storageClassName != null ? this.storageClassName.equals(that.storageClassName) : that.storageClassName == null;
        }

        @Override
        public final int hashCode() {
            int result = this.accessModes.hashCode();
            result = 31 * result + (this.capacity.hashCode());
            result = 31 * result + (this.persistentVolumeSource.hashCode());
            result = 31 * result + (this.mountOptions != null ? this.mountOptions.hashCode() : 0);
            result = 31 * result + (this.nodeAffinity != null ? this.nodeAffinity.hashCode() : 0);
            result = 31 * result + (this.persistentVolumeReclaimPolicy != null ? this.persistentVolumeReclaimPolicy.hashCode() : 0);
            result = 31 * result + (this.storageClassName != null ? this.storageClassName.hashCode() : 0);
            return result;
        }
    }
}
