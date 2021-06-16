package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.631Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.JobSpecTemplateSpecContainerVolumeMount")
@software.amazon.jsii.Jsii.Proxy(JobSpecTemplateSpecContainerVolumeMount.Jsii$Proxy.class)
public interface JobSpecTemplateSpecContainerVolumeMount extends software.amazon.jsii.JsiiSerializable {

    /**
     * Path within the container at which the volume should be mounted. Must not contain ':'.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#mount_path Job#mount_path}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getMountPath();

    /**
     * This must match the Name of a Volume.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#name Job#name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * Mount propagation mode.
     * <p>
     * mount_propagation determines how mounts are propagated from the host to container and the other way around. Valid values are None (default), HostToContainer and Bidirectional.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#mount_propagation Job#mount_propagation}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMountPropagation() {
        return null;
    }

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#read_only Job#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#sub_path Job#sub_path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSubPath() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link JobSpecTemplateSpecContainerVolumeMount}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link JobSpecTemplateSpecContainerVolumeMount}
     */
    public static final class Builder implements software.amazon.jsii.Builder<JobSpecTemplateSpecContainerVolumeMount> {
        private java.lang.String mountPath;
        private java.lang.String name;
        private java.lang.String mountPropagation;
        private java.lang.Boolean readOnly;
        private java.lang.String subPath;

        /**
         * Sets the value of {@link JobSpecTemplateSpecContainerVolumeMount#getMountPath}
         * @param mountPath Path within the container at which the volume should be mounted. Must not contain ':'. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#mount_path Job#mount_path}
         * @return {@code this}
         */
        public Builder mountPath(java.lang.String mountPath) {
            this.mountPath = mountPath;
            return this;
        }

        /**
         * Sets the value of {@link JobSpecTemplateSpecContainerVolumeMount#getName}
         * @param name This must match the Name of a Volume. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#name Job#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link JobSpecTemplateSpecContainerVolumeMount#getMountPropagation}
         * @param mountPropagation Mount propagation mode.
         *                         mount_propagation determines how mounts are propagated from the host to container and the other way around. Valid values are None (default), HostToContainer and Bidirectional.
         *                         <p>
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#mount_propagation Job#mount_propagation}
         * @return {@code this}
         */
        public Builder mountPropagation(java.lang.String mountPropagation) {
            this.mountPropagation = mountPropagation;
            return this;
        }

        /**
         * Sets the value of {@link JobSpecTemplateSpecContainerVolumeMount#getReadOnly}
         * @param readOnly Mounted read-only if true, read-write otherwise (false or unspecified). Defaults to false.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#read_only Job#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Sets the value of {@link JobSpecTemplateSpecContainerVolumeMount#getSubPath}
         * @param subPath Path within the volume from which the container's volume should be mounted. Defaults to "" (volume's root).
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#sub_path Job#sub_path}
         * @return {@code this}
         */
        public Builder subPath(java.lang.String subPath) {
            this.subPath = subPath;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link JobSpecTemplateSpecContainerVolumeMount}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public JobSpecTemplateSpecContainerVolumeMount build() {
            return new Jsii$Proxy(mountPath, name, mountPropagation, readOnly, subPath);
        }
    }

    /**
     * An implementation for {@link JobSpecTemplateSpecContainerVolumeMount}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements JobSpecTemplateSpecContainerVolumeMount {
        private final java.lang.String mountPath;
        private final java.lang.String name;
        private final java.lang.String mountPropagation;
        private final java.lang.Boolean readOnly;
        private final java.lang.String subPath;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.mountPath = software.amazon.jsii.Kernel.get(this, "mountPath", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.mountPropagation = software.amazon.jsii.Kernel.get(this, "mountPropagation", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.subPath = software.amazon.jsii.Kernel.get(this, "subPath", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String mountPath, final java.lang.String name, final java.lang.String mountPropagation, final java.lang.Boolean readOnly, final java.lang.String subPath) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.mountPath = java.util.Objects.requireNonNull(mountPath, "mountPath is required");
            this.name = java.util.Objects.requireNonNull(name, "name is required");
            this.mountPropagation = mountPropagation;
            this.readOnly = readOnly;
            this.subPath = subPath;
        }

        @Override
        public final java.lang.String getMountPath() {
            return this.mountPath;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.String getMountPropagation() {
            return this.mountPropagation;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        public final java.lang.String getSubPath() {
            return this.subPath;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("mountPath", om.valueToTree(this.getMountPath()));
            data.set("name", om.valueToTree(this.getName()));
            if (this.getMountPropagation() != null) {
                data.set("mountPropagation", om.valueToTree(this.getMountPropagation()));
            }
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }
            if (this.getSubPath() != null) {
                data.set("subPath", om.valueToTree(this.getSubPath()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.JobSpecTemplateSpecContainerVolumeMount"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JobSpecTemplateSpecContainerVolumeMount.Jsii$Proxy that = (JobSpecTemplateSpecContainerVolumeMount.Jsii$Proxy) o;

            if (!mountPath.equals(that.mountPath)) return false;
            if (!name.equals(that.name)) return false;
            if (this.mountPropagation != null ? !this.mountPropagation.equals(that.mountPropagation) : that.mountPropagation != null) return false;
            if (this.readOnly != null ? !this.readOnly.equals(that.readOnly) : that.readOnly != null) return false;
            return this.subPath != null ? this.subPath.equals(that.subPath) : that.subPath == null;
        }

        @Override
        public final int hashCode() {
            int result = this.mountPath.hashCode();
            result = 31 * result + (this.name.hashCode());
            result = 31 * result + (this.mountPropagation != null ? this.mountPropagation.hashCode() : 0);
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            result = 31 * result + (this.subPath != null ? this.subPath.hashCode() : 0);
            return result;
        }
    }
}
