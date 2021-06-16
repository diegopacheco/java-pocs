package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.963Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StorageClassConfig")
@software.amazon.jsii.Jsii.Proxy(StorageClassConfig.Jsii$Proxy.class)
public interface StorageClassConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * metadata block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#metadata StorageClass#metadata}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.StorageClassMetadata> getMetadata();

    /**
     * Indicates the type of the provisioner.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#storage_provisioner StorageClass#storage_provisioner}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getStorageProvisioner();

    /**
     * Indicates whether the storage class allow volume expand.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#allow_volume_expansion StorageClass#allow_volume_expansion}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getAllowVolumeExpansion() {
        return null;
    }

    /**
     * Persistent Volumes that are dynamically created by a storage class will have the mount options specified.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#mount_options StorageClass#mount_options}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getMountOptions() {
        return null;
    }

    /**
     * The parameters for the provisioner that should create volumes of this storage class.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#parameters StorageClass#parameters}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getParameters() {
        return null;
    }

    /**
     * Indicates the type of the reclaim policy.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#reclaim_policy StorageClass#reclaim_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getReclaimPolicy() {
        return null;
    }

    /**
     * Indicates when volume binding and dynamic provisioning should occur.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#volume_binding_mode StorageClass#volume_binding_mode}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getVolumeBindingMode() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StorageClassConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StorageClassConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StorageClassConfig> {
        private java.util.List<imports.kubernetes.StorageClassMetadata> metadata;
        private java.lang.String storageProvisioner;
        private java.lang.Boolean allowVolumeExpansion;
        private java.util.List<java.lang.String> mountOptions;
        private java.util.Map<java.lang.String, java.lang.String> parameters;
        private java.lang.String reclaimPolicy;
        private java.lang.String volumeBindingMode;
        private java.lang.Number count;
        private java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private com.hashicorp.cdktf.TerraformProvider provider;

        /**
         * Sets the value of {@link StorageClassConfig#getMetadata}
         * @param metadata metadata block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#metadata StorageClass#metadata}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metadata(java.util.List<? extends imports.kubernetes.StorageClassMetadata> metadata) {
            this.metadata = (java.util.List<imports.kubernetes.StorageClassMetadata>)metadata;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getStorageProvisioner}
         * @param storageProvisioner Indicates the type of the provisioner. This parameter is required.
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#storage_provisioner StorageClass#storage_provisioner}
         * @return {@code this}
         */
        public Builder storageProvisioner(java.lang.String storageProvisioner) {
            this.storageProvisioner = storageProvisioner;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getAllowVolumeExpansion}
         * @param allowVolumeExpansion Indicates whether the storage class allow volume expand.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#allow_volume_expansion StorageClass#allow_volume_expansion}
         * @return {@code this}
         */
        public Builder allowVolumeExpansion(java.lang.Boolean allowVolumeExpansion) {
            this.allowVolumeExpansion = allowVolumeExpansion;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getMountOptions}
         * @param mountOptions Persistent Volumes that are dynamically created by a storage class will have the mount options specified.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#mount_options StorageClass#mount_options}
         * @return {@code this}
         */
        public Builder mountOptions(java.util.List<java.lang.String> mountOptions) {
            this.mountOptions = mountOptions;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getParameters}
         * @param parameters The parameters for the provisioner that should create volumes of this storage class.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#parameters StorageClass#parameters}
         * @return {@code this}
         */
        public Builder parameters(java.util.Map<java.lang.String, java.lang.String> parameters) {
            this.parameters = parameters;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getReclaimPolicy}
         * @param reclaimPolicy Indicates the type of the reclaim policy.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#reclaim_policy StorageClass#reclaim_policy}
         * @return {@code this}
         */
        public Builder reclaimPolicy(java.lang.String reclaimPolicy) {
            this.reclaimPolicy = reclaimPolicy;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getVolumeBindingMode}
         * @param volumeBindingMode Indicates when volume binding and dynamic provisioning should occur.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/storage_class.html#volume_binding_mode StorageClass#volume_binding_mode}
         * @return {@code this}
         */
        public Builder volumeBindingMode(java.lang.String volumeBindingMode) {
            this.volumeBindingMode = volumeBindingMode;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getDependsOn}
         * @param dependsOn the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder dependsOn(java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link StorageClassConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StorageClassConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StorageClassConfig build() {
            return new Jsii$Proxy(metadata, storageProvisioner, allowVolumeExpansion, mountOptions, parameters, reclaimPolicy, volumeBindingMode, count, dependsOn, lifecycle, provider);
        }
    }

    /**
     * An implementation for {@link StorageClassConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StorageClassConfig {
        private final java.util.List<imports.kubernetes.StorageClassMetadata> metadata;
        private final java.lang.String storageProvisioner;
        private final java.lang.Boolean allowVolumeExpansion;
        private final java.util.List<java.lang.String> mountOptions;
        private final java.util.Map<java.lang.String, java.lang.String> parameters;
        private final java.lang.String reclaimPolicy;
        private final java.lang.String volumeBindingMode;
        private final java.lang.Number count;
        private final java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private final com.hashicorp.cdktf.TerraformProvider provider;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.metadata = software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StorageClassMetadata.class)));
            this.storageProvisioner = software.amazon.jsii.Kernel.get(this, "storageProvisioner", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.allowVolumeExpansion = software.amazon.jsii.Kernel.get(this, "allowVolumeExpansion", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.mountOptions = software.amazon.jsii.Kernel.get(this, "mountOptions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.parameters = software.amazon.jsii.Kernel.get(this, "parameters", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.reclaimPolicy = software.amazon.jsii.Kernel.get(this, "reclaimPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.volumeBindingMode = software.amazon.jsii.Kernel.get(this, "volumeBindingMode", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StorageClassMetadata> metadata, final java.lang.String storageProvisioner, final java.lang.Boolean allowVolumeExpansion, final java.util.List<java.lang.String> mountOptions, final java.util.Map<java.lang.String, java.lang.String> parameters, final java.lang.String reclaimPolicy, final java.lang.String volumeBindingMode, final java.lang.Number count, final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn, final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle, final com.hashicorp.cdktf.TerraformProvider provider) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.metadata = (java.util.List<imports.kubernetes.StorageClassMetadata>)java.util.Objects.requireNonNull(metadata, "metadata is required");
            this.storageProvisioner = java.util.Objects.requireNonNull(storageProvisioner, "storageProvisioner is required");
            this.allowVolumeExpansion = allowVolumeExpansion;
            this.mountOptions = mountOptions;
            this.parameters = parameters;
            this.reclaimPolicy = reclaimPolicy;
            this.volumeBindingMode = volumeBindingMode;
            this.count = count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            this.lifecycle = lifecycle;
            this.provider = provider;
        }

        @Override
        public final java.util.List<imports.kubernetes.StorageClassMetadata> getMetadata() {
            return this.metadata;
        }

        @Override
        public final java.lang.String getStorageProvisioner() {
            return this.storageProvisioner;
        }

        @Override
        public final java.lang.Boolean getAllowVolumeExpansion() {
            return this.allowVolumeExpansion;
        }

        @Override
        public final java.util.List<java.lang.String> getMountOptions() {
            return this.mountOptions;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getParameters() {
            return this.parameters;
        }

        @Override
        public final java.lang.String getReclaimPolicy() {
            return this.reclaimPolicy;
        }

        @Override
        public final java.lang.String getVolumeBindingMode() {
            return this.volumeBindingMode;
        }

        @Override
        public final java.lang.Number getCount() {
            return this.count;
        }

        @Override
        public final java.util.List<com.hashicorp.cdktf.ITerraformDependable> getDependsOn() {
            return this.dependsOn;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformResourceLifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformProvider getProvider() {
            return this.provider;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("metadata", om.valueToTree(this.getMetadata()));
            data.set("storageProvisioner", om.valueToTree(this.getStorageProvisioner()));
            if (this.getAllowVolumeExpansion() != null) {
                data.set("allowVolumeExpansion", om.valueToTree(this.getAllowVolumeExpansion()));
            }
            if (this.getMountOptions() != null) {
                data.set("mountOptions", om.valueToTree(this.getMountOptions()));
            }
            if (this.getParameters() != null) {
                data.set("parameters", om.valueToTree(this.getParameters()));
            }
            if (this.getReclaimPolicy() != null) {
                data.set("reclaimPolicy", om.valueToTree(this.getReclaimPolicy()));
            }
            if (this.getVolumeBindingMode() != null) {
                data.set("volumeBindingMode", om.valueToTree(this.getVolumeBindingMode()));
            }
            if (this.getCount() != null) {
                data.set("count", om.valueToTree(this.getCount()));
            }
            if (this.getDependsOn() != null) {
                data.set("dependsOn", om.valueToTree(this.getDependsOn()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getProvider() != null) {
                data.set("provider", om.valueToTree(this.getProvider()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StorageClassConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StorageClassConfig.Jsii$Proxy that = (StorageClassConfig.Jsii$Proxy) o;

            if (!metadata.equals(that.metadata)) return false;
            if (!storageProvisioner.equals(that.storageProvisioner)) return false;
            if (this.allowVolumeExpansion != null ? !this.allowVolumeExpansion.equals(that.allowVolumeExpansion) : that.allowVolumeExpansion != null) return false;
            if (this.mountOptions != null ? !this.mountOptions.equals(that.mountOptions) : that.mountOptions != null) return false;
            if (this.parameters != null ? !this.parameters.equals(that.parameters) : that.parameters != null) return false;
            if (this.reclaimPolicy != null ? !this.reclaimPolicy.equals(that.reclaimPolicy) : that.reclaimPolicy != null) return false;
            if (this.volumeBindingMode != null ? !this.volumeBindingMode.equals(that.volumeBindingMode) : that.volumeBindingMode != null) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            return this.provider != null ? this.provider.equals(that.provider) : that.provider == null;
        }

        @Override
        public final int hashCode() {
            int result = this.metadata.hashCode();
            result = 31 * result + (this.storageProvisioner.hashCode());
            result = 31 * result + (this.allowVolumeExpansion != null ? this.allowVolumeExpansion.hashCode() : 0);
            result = 31 * result + (this.mountOptions != null ? this.mountOptions.hashCode() : 0);
            result = 31 * result + (this.parameters != null ? this.parameters.hashCode() : 0);
            result = 31 * result + (this.reclaimPolicy != null ? this.reclaimPolicy.hashCode() : 0);
            result = 31 * result + (this.volumeBindingMode != null ? this.volumeBindingMode.hashCode() : 0);
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            return result;
        }
    }
}
