package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.859Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateSpecVolumeRbd.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateSpecVolumeRbd extends software.amazon.jsii.JsiiSerializable {

    /**
     * A collection of Ceph monitors. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_monitors ReplicationController#ceph_monitors}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getCephMonitors();

    /**
     * The rados image name. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd_image ReplicationController#rbd_image}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getRbdImage();

    /**
     * Filesystem type of the volume that you want to mount.
     * <p>
     * Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: http://kubernetes.io/docs/user-guide/volumes#rbd
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fs_type ReplicationController#fs_type}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getFsType() {
        return null;
    }

    /**
     * Keyring is the path to key ring for RBDUser. Default is /etc/ceph/keyring. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#keyring ReplicationController#keyring}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getKeyring() {
        return null;
    }

    /**
     * The rados user name. Default is admin. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rados_user ReplicationController#rados_user}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getRadosUser() {
        return null;
    }

    /**
     * The rados pool name. Default is rbd. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd_pool ReplicationController#rbd_pool}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getRbdPool() {
        return null;
    }

    /**
     * Whether to force the read-only setting in VolumeMounts. Defaults to false. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#read_only ReplicationController#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret_ref ReplicationController#secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> getSecretRef() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateSpecVolumeRbd}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateSpecVolumeRbd}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateSpecVolumeRbd> {
        private java.util.List<java.lang.String> cephMonitors;
        private java.lang.String rbdImage;
        private java.lang.String fsType;
        private java.lang.String keyring;
        private java.lang.String radosUser;
        private java.lang.String rbdPool;
        private java.lang.Boolean readOnly;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> secretRef;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getCephMonitors}
         * @param cephMonitors A collection of Ceph monitors. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it. This parameter is required.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_monitors ReplicationController#ceph_monitors}
         * @return {@code this}
         */
        public Builder cephMonitors(java.util.List<java.lang.String> cephMonitors) {
            this.cephMonitors = cephMonitors;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getRbdImage}
         * @param rbdImage The rados image name. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd_image ReplicationController#rbd_image}
         * @return {@code this}
         */
        public Builder rbdImage(java.lang.String rbdImage) {
            this.rbdImage = rbdImage;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getFsType}
         * @param fsType Filesystem type of the volume that you want to mount.
         *               Tip: Ensure that the filesystem type is supported by the host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" if unspecified. More info: http://kubernetes.io/docs/user-guide/volumes#rbd
         *               <p>
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fs_type ReplicationController#fs_type}
         * @return {@code this}
         */
        public Builder fsType(java.lang.String fsType) {
            this.fsType = fsType;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getKeyring}
         * @param keyring Keyring is the path to key ring for RBDUser. Default is /etc/ceph/keyring. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#keyring ReplicationController#keyring}
         * @return {@code this}
         */
        public Builder keyring(java.lang.String keyring) {
            this.keyring = keyring;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getRadosUser}
         * @param radosUser The rados user name. Default is admin. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rados_user ReplicationController#rados_user}
         * @return {@code this}
         */
        public Builder radosUser(java.lang.String radosUser) {
            this.radosUser = radosUser;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getRbdPool}
         * @param rbdPool The rados pool name. Default is rbd. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd_pool ReplicationController#rbd_pool}
         * @return {@code this}
         */
        public Builder rbdPool(java.lang.String rbdPool) {
            this.rbdPool = rbdPool;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getReadOnly}
         * @param readOnly Whether to force the read-only setting in VolumeMounts. Defaults to false. More info: http://releases.k8s.io/HEAD/examples/volumes/rbd/README.md#how-to-use-it.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#read_only ReplicationController#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolumeRbd#getSecretRef}
         * @param secretRef secret_ref block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret_ref ReplicationController#secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secretRef(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> secretRef) {
            this.secretRef = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef>)secretRef;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateSpecVolumeRbd}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateSpecVolumeRbd build() {
            return new Jsii$Proxy(cephMonitors, rbdImage, fsType, keyring, radosUser, rbdPool, readOnly, secretRef);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateSpecVolumeRbd}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateSpecVolumeRbd {
        private final java.util.List<java.lang.String> cephMonitors;
        private final java.lang.String rbdImage;
        private final java.lang.String fsType;
        private final java.lang.String keyring;
        private final java.lang.String radosUser;
        private final java.lang.String rbdPool;
        private final java.lang.Boolean readOnly;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> secretRef;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.cephMonitors = software.amazon.jsii.Kernel.get(this, "cephMonitors", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.rbdImage = software.amazon.jsii.Kernel.get(this, "rbdImage", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.fsType = software.amazon.jsii.Kernel.get(this, "fsType", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.keyring = software.amazon.jsii.Kernel.get(this, "keyring", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.radosUser = software.amazon.jsii.Kernel.get(this, "radosUser", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.rbdPool = software.amazon.jsii.Kernel.get(this, "rbdPool", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.secretRef = software.amazon.jsii.Kernel.get(this, "secretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<java.lang.String> cephMonitors, final java.lang.String rbdImage, final java.lang.String fsType, final java.lang.String keyring, final java.lang.String radosUser, final java.lang.String rbdPool, final java.lang.Boolean readOnly, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> secretRef) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.cephMonitors = java.util.Objects.requireNonNull(cephMonitors, "cephMonitors is required");
            this.rbdImage = java.util.Objects.requireNonNull(rbdImage, "rbdImage is required");
            this.fsType = fsType;
            this.keyring = keyring;
            this.radosUser = radosUser;
            this.rbdPool = rbdPool;
            this.readOnly = readOnly;
            this.secretRef = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef>)secretRef;
        }

        @Override
        public final java.util.List<java.lang.String> getCephMonitors() {
            return this.cephMonitors;
        }

        @Override
        public final java.lang.String getRbdImage() {
            return this.rbdImage;
        }

        @Override
        public final java.lang.String getFsType() {
            return this.fsType;
        }

        @Override
        public final java.lang.String getKeyring() {
            return this.keyring;
        }

        @Override
        public final java.lang.String getRadosUser() {
            return this.radosUser;
        }

        @Override
        public final java.lang.String getRbdPool() {
            return this.rbdPool;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbdSecretRef> getSecretRef() {
            return this.secretRef;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("cephMonitors", om.valueToTree(this.getCephMonitors()));
            data.set("rbdImage", om.valueToTree(this.getRbdImage()));
            if (this.getFsType() != null) {
                data.set("fsType", om.valueToTree(this.getFsType()));
            }
            if (this.getKeyring() != null) {
                data.set("keyring", om.valueToTree(this.getKeyring()));
            }
            if (this.getRadosUser() != null) {
                data.set("radosUser", om.valueToTree(this.getRadosUser()));
            }
            if (this.getRbdPool() != null) {
                data.set("rbdPool", om.valueToTree(this.getRbdPool()));
            }
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }
            if (this.getSecretRef() != null) {
                data.set("secretRef", om.valueToTree(this.getSecretRef()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateSpecVolumeRbd.Jsii$Proxy that = (ReplicationControllerSpecTemplateSpecVolumeRbd.Jsii$Proxy) o;

            if (!cephMonitors.equals(that.cephMonitors)) return false;
            if (!rbdImage.equals(that.rbdImage)) return false;
            if (this.fsType != null ? !this.fsType.equals(that.fsType) : that.fsType != null) return false;
            if (this.keyring != null ? !this.keyring.equals(that.keyring) : that.keyring != null) return false;
            if (this.radosUser != null ? !this.radosUser.equals(that.radosUser) : that.radosUser != null) return false;
            if (this.rbdPool != null ? !this.rbdPool.equals(that.rbdPool) : that.rbdPool != null) return false;
            if (this.readOnly != null ? !this.readOnly.equals(that.readOnly) : that.readOnly != null) return false;
            return this.secretRef != null ? this.secretRef.equals(that.secretRef) : that.secretRef == null;
        }

        @Override
        public final int hashCode() {
            int result = this.cephMonitors.hashCode();
            result = 31 * result + (this.rbdImage.hashCode());
            result = 31 * result + (this.fsType != null ? this.fsType.hashCode() : 0);
            result = 31 * result + (this.keyring != null ? this.keyring.hashCode() : 0);
            result = 31 * result + (this.radosUser != null ? this.radosUser.hashCode() : 0);
            result = 31 * result + (this.rbdPool != null ? this.rbdPool.hashCode() : 0);
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            result = 31 * result + (this.secretRef != null ? this.secretRef.hashCode() : 0);
            return result;
        }
    }
}
