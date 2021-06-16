package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.342Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplate")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplate.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplate extends software.amazon.jsii.JsiiSerializable {

    /**
     * metadata block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#metadata CronJob#metadata}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> getMetadata();

    /**
     * spec block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#spec CronJob#spec}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> getSpec() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplate}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplate}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplate> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> metadata;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> spec;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplate#getMetadata}
         * @param metadata metadata block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#metadata CronJob#metadata}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metadata(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> metadata) {
            this.metadata = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata>)metadata;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplate#getSpec}
         * @param spec spec block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#spec CronJob#spec}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder spec(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> spec) {
            this.spec = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec>)spec;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplate}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplate build() {
            return new Jsii$Proxy(metadata, spec);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplate}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplate {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> metadata;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> spec;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.metadata = software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata.class)));
            this.spec = software.amazon.jsii.Kernel.get(this, "spec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> metadata, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> spec) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.metadata = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata>)java.util.Objects.requireNonNull(metadata, "metadata is required");
            this.spec = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec>)spec;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateMetadata> getMetadata() {
            return this.metadata;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpec> getSpec() {
            return this.spec;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("metadata", om.valueToTree(this.getMetadata()));
            if (this.getSpec() != null) {
                data.set("spec", om.valueToTree(this.getSpec()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplate"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplate.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplate.Jsii$Proxy) o;

            if (!metadata.equals(that.metadata)) return false;
            return this.spec != null ? this.spec.equals(that.spec) : that.spec == null;
        }

        @Override
        public final int hashCode() {
            int result = this.metadata.hashCode();
            result = 31 * result + (this.spec != null ? this.spec.hashCode() : 0);
            return result;
        }
    }
}
