package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.408Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile extends software.amazon.jsii.JsiiSerializable {

    /**
     * The name of secret that contains Azure Storage Account Name and Key.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#secret_name CronJob#secret_name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getSecretName();

    /**
     * Share Name.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#share_name CronJob#share_name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getShareName();

    /**
     * Whether to force the read-only setting in VolumeMounts. Defaults to false (read/write).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#read_only CronJob#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile> {
        private java.lang.String secretName;
        private java.lang.String shareName;
        private java.lang.Boolean readOnly;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile#getSecretName}
         * @param secretName The name of secret that contains Azure Storage Account Name and Key. This parameter is required.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#secret_name CronJob#secret_name}
         * @return {@code this}
         */
        public Builder secretName(java.lang.String secretName) {
            this.secretName = secretName;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile#getShareName}
         * @param shareName Share Name. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#share_name CronJob#share_name}
         * @return {@code this}
         */
        public Builder shareName(java.lang.String shareName) {
            this.shareName = shareName;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile#getReadOnly}
         * @param readOnly Whether to force the read-only setting in VolumeMounts. Defaults to false (read/write).
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#read_only CronJob#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile build() {
            return new Jsii$Proxy(secretName, shareName, readOnly);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile {
        private final java.lang.String secretName;
        private final java.lang.String shareName;
        private final java.lang.Boolean readOnly;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.secretName = software.amazon.jsii.Kernel.get(this, "secretName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.shareName = software.amazon.jsii.Kernel.get(this, "shareName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String secretName, final java.lang.String shareName, final java.lang.Boolean readOnly) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.secretName = java.util.Objects.requireNonNull(secretName, "secretName is required");
            this.shareName = java.util.Objects.requireNonNull(shareName, "shareName is required");
            this.readOnly = readOnly;
        }

        @Override
        public final java.lang.String getSecretName() {
            return this.secretName;
        }

        @Override
        public final java.lang.String getShareName() {
            return this.shareName;
        }

        @Override
        public final java.lang.Boolean getReadOnly() {
            return this.readOnly;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("secretName", om.valueToTree(this.getSecretName()));
            data.set("shareName", om.valueToTree(this.getShareName()));
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplateSpecVolumeAzureFile.Jsii$Proxy) o;

            if (!secretName.equals(that.secretName)) return false;
            if (!shareName.equals(that.shareName)) return false;
            return this.readOnly != null ? this.readOnly.equals(that.readOnly) : that.readOnly == null;
        }

        @Override
        public final int hashCode() {
            int result = this.secretName.hashCode();
            result = 31 * result + (this.shareName.hashCode());
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            return result;
        }
    }
}
