package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.660Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.JobSpecTemplateSpecVolumePersistentVolumeClaim")
@software.amazon.jsii.Jsii.Proxy(JobSpecTemplateSpecVolumePersistentVolumeClaim.Jsii$Proxy.class)
public interface JobSpecTemplateSpecVolumePersistentVolumeClaim extends software.amazon.jsii.JsiiSerializable {

    /**
     * ClaimName is the name of a PersistentVolumeClaim in the same.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#claim_name Job#claim_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getClaimName() {
        return null;
    }

    /**
     * Will force the ReadOnly setting in VolumeMounts.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#read_only Job#read_only}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getReadOnly() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link JobSpecTemplateSpecVolumePersistentVolumeClaim}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link JobSpecTemplateSpecVolumePersistentVolumeClaim}
     */
    public static final class Builder implements software.amazon.jsii.Builder<JobSpecTemplateSpecVolumePersistentVolumeClaim> {
        private java.lang.String claimName;
        private java.lang.Boolean readOnly;

        /**
         * Sets the value of {@link JobSpecTemplateSpecVolumePersistentVolumeClaim#getClaimName}
         * @param claimName ClaimName is the name of a PersistentVolumeClaim in the same.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#claim_name Job#claim_name}
         * @return {@code this}
         */
        public Builder claimName(java.lang.String claimName) {
            this.claimName = claimName;
            return this;
        }

        /**
         * Sets the value of {@link JobSpecTemplateSpecVolumePersistentVolumeClaim#getReadOnly}
         * @param readOnly Will force the ReadOnly setting in VolumeMounts.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/job.html#read_only Job#read_only}
         * @return {@code this}
         */
        public Builder readOnly(java.lang.Boolean readOnly) {
            this.readOnly = readOnly;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link JobSpecTemplateSpecVolumePersistentVolumeClaim}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public JobSpecTemplateSpecVolumePersistentVolumeClaim build() {
            return new Jsii$Proxy(claimName, readOnly);
        }
    }

    /**
     * An implementation for {@link JobSpecTemplateSpecVolumePersistentVolumeClaim}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements JobSpecTemplateSpecVolumePersistentVolumeClaim {
        private final java.lang.String claimName;
        private final java.lang.Boolean readOnly;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.claimName = software.amazon.jsii.Kernel.get(this, "claimName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.readOnly = software.amazon.jsii.Kernel.get(this, "readOnly", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String claimName, final java.lang.Boolean readOnly) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.claimName = claimName;
            this.readOnly = readOnly;
        }

        @Override
        public final java.lang.String getClaimName() {
            return this.claimName;
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

            if (this.getClaimName() != null) {
                data.set("claimName", om.valueToTree(this.getClaimName()));
            }
            if (this.getReadOnly() != null) {
                data.set("readOnly", om.valueToTree(this.getReadOnly()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.JobSpecTemplateSpecVolumePersistentVolumeClaim"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JobSpecTemplateSpecVolumePersistentVolumeClaim.Jsii$Proxy that = (JobSpecTemplateSpecVolumePersistentVolumeClaim.Jsii$Proxy) o;

            if (this.claimName != null ? !this.claimName.equals(that.claimName) : that.claimName != null) return false;
            return this.readOnly != null ? this.readOnly.equals(that.readOnly) : that.readOnly == null;
        }

        @Override
        public final int hashCode() {
            int result = this.claimName != null ? this.claimName.hashCode() : 0;
            result = 31 * result + (this.readOnly != null ? this.readOnly.hashCode() : 0);
            return result;
        }
    }
}
