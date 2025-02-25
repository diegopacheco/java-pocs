package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.756Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecVolumeCsi")
@software.amazon.jsii.Jsii.Proxy(PodSpecVolumeCsi.Jsii$Proxy.class)
public interface PodSpecVolumeCsi extends software.amazon.jsii.JsiiSerializable {

    /**
     * the name of the volume driver to use. More info: https://kubernetes.io/docs/concepts/storage/volumes/#csi.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#driver Pod#driver}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getDriver();

    /**
     * A string value that uniquely identifies the volume. More info: https://kubernetes.io/docs/concepts/storage/volumes/#csi.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_handle Pod#volume_handle}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getVolumeHandle();

    /**
     * controller_expand_secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#controller_expand_secret_ref Pod#controller_expand_secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> getControllerExpandSecretRef() {
        return null;
    }

    /**
     * controller_publish_secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#controller_publish_secret_ref Pod#controller_publish_secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> getControllerPublishSecretRef() {
        return null;
    }

    /**
     * Filesystem type to mount.
     * <p>
     * Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fs_type Pod#fs_type}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getFsType() {
        return null;
    }

    /**
     * node_publish_secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#node_publish_secret_ref Pod#node_publish_secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> getNodePublishSecretRef() {
        return null;
    }

    /**
     * node_stage_secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#node_stage_secret_ref Pod#node_stage_secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> getNodeStageSecretRef() {
        return null;
    }

    /**
     * Whether to set the read-only property in VolumeMounts to "true". If omitted, the default is "false". More info: http://kubernetes.io/docs/user-guide/volumes#csi.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * Attributes of the volume to publish.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_attributes Pod#volume_attributes}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getVolumeAttributes() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecVolumeCsi}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecVolumeCsi}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecVolumeCsi> {
        private java.lang.String driver;
        private java.lang.String volumeHandle;
        private java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> controllerExpandSecretRef;
        private java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> controllerPublishSecretRef;
        private java.lang.String fsType;
        private java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> nodePublishSecretRef;
        private java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> nodeStageSecretRef;
        private java.lang.Boolean readOnly;
        private java.util.Map<java.lang.String, java.lang.String> volumeAttributes;

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getDriver}
         * @param driver the name of the volume driver to use. More info: https://kubernetes.io/docs/concepts/storage/volumes/#csi. This parameter is required.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#driver Pod#driver}
         * @return {@code this}
         */
        public Builder driver(java.lang.String driver) {
            this.driver = driver;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getVolumeHandle}
         * @param volumeHandle A string value that uniquely identifies the volume. More info: https://kubernetes.io/docs/concepts/storage/volumes/#csi. This parameter is required.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_handle Pod#volume_handle}
         * @return {@code this}
         */
        public Builder volumeHandle(java.lang.String volumeHandle) {
            this.volumeHandle = volumeHandle;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getControllerExpandSecretRef}
         * @param controllerExpandSecretRef controller_expand_secret_ref block.
         *                                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#controller_expand_secret_ref Pod#controller_expand_secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder controllerExpandSecretRef(java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> controllerExpandSecretRef) {
            this.controllerExpandSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef>)controllerExpandSecretRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getControllerPublishSecretRef}
         * @param controllerPublishSecretRef controller_publish_secret_ref block.
         *                                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#controller_publish_secret_ref Pod#controller_publish_secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder controllerPublishSecretRef(java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> controllerPublishSecretRef) {
            this.controllerPublishSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef>)controllerPublishSecretRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getFsType}
         * @param fsType Filesystem type to mount.
         *               Must be a filesystem type supported by the host operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified.
         *               <p>
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fs_type Pod#fs_type}
         * @return {@code this}
         */
        public Builder fsType(java.lang.String fsType) {
            this.fsType = fsType;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getNodePublishSecretRef}
         * @param nodePublishSecretRef node_publish_secret_ref block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#node_publish_secret_ref Pod#node_publish_secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nodePublishSecretRef(java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> nodePublishSecretRef) {
            this.nodePublishSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef>)nodePublishSecretRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getNodeStageSecretRef}
         * @param nodeStageSecretRef node_stage_secret_ref block.
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#node_stage_secret_ref Pod#node_stage_secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nodeStageSecretRef(java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> nodeStageSecretRef) {
            this.nodeStageSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef>)nodeStageSecretRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getReadOnly}
         * @param readOnly Whether to set the read-only property in VolumeMounts to "true". If omitted, the default is "false". More info: http://kubernetes.io/docs/user-guide/volumes#csi.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#read_only Pod#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolumeCsi#getVolumeAttributes}
         * @param volumeAttributes Attributes of the volume to publish.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#volume_attributes Pod#volume_attributes}
         * @return {@code this}
         */
        public Builder volumeAttributes(java.util.Map<java.lang.String, java.lang.String> volumeAttributes) {
            this.volumeAttributes = volumeAttributes;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecVolumeCsi}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecVolumeCsi build() {
            return new Jsii$Proxy(driver, volumeHandle, controllerExpandSecretRef, controllerPublishSecretRef, fsType, nodePublishSecretRef, nodeStageSecretRef, readOnly, volumeAttributes);
        }
    }

    /**
     * An implementation for {@link PodSpecVolumeCsi}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecVolumeCsi {
        private final java.lang.String driver;
        private final java.lang.String volumeHandle;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> controllerExpandSecretRef;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> controllerPublishSecretRef;
        private final java.lang.String fsType;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> nodePublishSecretRef;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> nodeStageSecretRef;
        private final java.lang.Boolean readOnly;
        private final java.util.Map<java.lang.String, java.lang.String> volumeAttributes;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.driver = software.amazon.jsii.Kernel.get(this, "driver", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.volumeHandle = software.amazon.jsii.Kernel.get(this, "volumeHandle", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.controllerExpandSecretRef = software.amazon.jsii.Kernel.get(this, "controllerExpandSecretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef.class)));
            this.controllerPublishSecretRef = software.amazon.jsii.Kernel.get(this, "controllerPublishSecretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef.class)));
            this.fsType = software.amazon.jsii.Kernel.get(this, "fsType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nodePublishSecretRef = software.amazon.jsii.Kernel.get(this, "nodePublishSecretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef.class)));
            this.nodeStageSecretRef = software.amazon.jsii.Kernel.get(this, "nodeStageSecretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef.class)));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.volumeAttributes = software.amazon.jsii.Kernel.get(this, "volumeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String driver, final java.lang.String volumeHandle, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> controllerExpandSecretRef, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> controllerPublishSecretRef, final java.lang.String fsType, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> nodePublishSecretRef, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> nodeStageSecretRef, final java.lang.Boolean readOnly, final java.util.Map<java.lang.String, java.lang.String> volumeAttributes) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.driver = java.util.Objects.requireNonNull(driver, "driver is required");
            this.volumeHandle = java.util.Objects.requireNonNull(volumeHandle, "volumeHandle is required");
            this.controllerExpandSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef>)controllerExpandSecretRef;
            this.controllerPublishSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef>)controllerPublishSecretRef;
            this.fsType = fsType;
            this.nodePublishSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef>)nodePublishSecretRef;
            this.nodeStageSecretRef = (java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef>)nodeStageSecretRef;
            this.readOnly = readOnly;
            this.volumeAttributes = volumeAttributes;
        }

        @Override
        public final java.lang.String getDriver() {
            return this.driver;
        }

        @Override
        public final java.lang.String getVolumeHandle() {
            return this.volumeHandle;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerExpandSecretRef> getControllerExpandSecretRef() {
            return this.controllerExpandSecretRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCsiControllerPublishSecretRef> getControllerPublishSecretRef() {
            return this.controllerPublishSecretRef;
        }

        @Override
        public final java.lang.String getFsType() {
            return this.fsType;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCsiNodePublishSecretRef> getNodePublishSecretRef() {
            return this.nodePublishSecretRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCsiNodeStageSecretRef> getNodeStageSecretRef() {
            return this.nodeStageSecretRef;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getVolumeAttributes() {
            return this.volumeAttributes;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("driver", om.valueToTree(this.getDriver()));
            data.set("volumeHandle", om.valueToTree(this.getVolumeHandle()));
            if (this.getControllerExpandSecretRef() != null) {
                data.set("controllerExpandSecretRef", om.valueToTree(this.getControllerExpandSecretRef()));
            }
            if (this.getControllerPublishSecretRef() != null) {
                data.set("controllerPublishSecretRef", om.valueToTree(this.getControllerPublishSecretRef()));
            }
            if (this.getFsType() != null) {
                data.set("fsType", om.valueToTree(this.getFsType()));
            }
            if (this.getNodePublishSecretRef() != null) {
                data.set("nodePublishSecretRef", om.valueToTree(this.getNodePublishSecretRef()));
            }
            if (this.getNodeStageSecretRef() != null) {
                data.set("nodeStageSecretRef", om.valueToTree(this.getNodeStageSecretRef()));
            }
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }
            if (this.getVolumeAttributes() != null) {
                data.set("volumeAttributes", om.valueToTree(this.getVolumeAttributes()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecVolumeCsi"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecVolumeCsi.Jsii$Proxy that = (PodSpecVolumeCsi.Jsii$Proxy) o;

            if (!driver.equals(that.driver)) return false;
            if (!volumeHandle.equals(that.volumeHandle)) return false;
            if (this.controllerExpandSecretRef != null ? !this.controllerExpandSecretRef.equals(that.controllerExpandSecretRef) : that.controllerExpandSecretRef != null) return false;
            if (this.controllerPublishSecretRef != null ? !this.controllerPublishSecretRef.equals(that.controllerPublishSecretRef) : that.controllerPublishSecretRef != null) return false;
            if (this.fsType != null ? !this.fsType.equals(that.fsType) : that.fsType != null) return false;
            if (this.nodePublishSecretRef != null ? !this.nodePublishSecretRef.equals(that.nodePublishSecretRef) : that.nodePublishSecretRef != null) return false;
            if (this.nodeStageSecretRef != null ? !this.nodeStageSecretRef.equals(that.nodeStageSecretRef) : that.nodeStageSecretRef != null) return false;
            if (this.readOnly != null ? !this.readOnly.equals(that.readOnly) : that.readOnly != null) return false;
            return this.volumeAttributes != null ? this.volumeAttributes.equals(that.volumeAttributes) : that.volumeAttributes == null;
        }

        @Override
        public final int hashCode() {
            int result = this.driver.hashCode();
            result = 31 * result + (this.volumeHandle.hashCode());
            result = 31 * result + (this.controllerExpandSecretRef != null ? this.controllerExpandSecretRef.hashCode() : 0);
            result = 31 * result + (this.controllerPublishSecretRef != null ? this.controllerPublishSecretRef.hashCode() : 0);
            result = 31 * result + (this.fsType != null ? this.fsType.hashCode() : 0);
            result = 31 * result + (this.nodePublishSecretRef != null ? this.nodePublishSecretRef.hashCode() : 0);
            result = 31 * result + (this.nodeStageSecretRef != null ? this.nodeStageSecretRef.hashCode() : 0);
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            result = 31 * result + (this.volumeAttributes != null ? this.volumeAttributes.hashCode() : 0);
            return result;
        }
    }
}
