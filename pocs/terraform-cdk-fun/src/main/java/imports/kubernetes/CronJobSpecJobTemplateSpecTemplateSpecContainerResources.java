package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.377Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResources")
@software.amazon.jsii.Jsii.Proxy(CronJobSpecJobTemplateSpecTemplateSpecContainerResources.Jsii$Proxy.class)
public interface CronJobSpecJobTemplateSpecTemplateSpecContainerResources extends software.amazon.jsii.JsiiSerializable {

    /**
     * limits block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#limits CronJob#limits}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> getLimits() {
        return null;
    }

    /**
     * requests block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#requests CronJob#requests}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> getRequests() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources}
     */
    public static final class Builder implements software.amazon.jsii.Builder<CronJobSpecJobTemplateSpecTemplateSpecContainerResources> {
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> limits;
        private java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> requests;

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources#getLimits}
         * @param limits limits block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#limits CronJob#limits}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder limits(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> limits) {
            this.limits = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits>)limits;
            return this;
        }

        /**
         * Sets the value of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources#getRequests}
         * @param requests requests block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cron_job.html#requests CronJob#requests}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder requests(java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> requests) {
            this.requests = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests>)requests;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public CronJobSpecJobTemplateSpecTemplateSpecContainerResources build() {
            return new Jsii$Proxy(limits, requests);
        }
    }

    /**
     * An implementation for {@link CronJobSpecJobTemplateSpecTemplateSpecContainerResources}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements CronJobSpecJobTemplateSpecTemplateSpecContainerResources {
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> limits;
        private final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> requests;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.limits = software.amazon.jsii.Kernel.get(this, "limits", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits.class)));
            this.requests = software.amazon.jsii.Kernel.get(this, "requests", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> limits, final java.util.List<? extends imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> requests) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.limits = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits>)limits;
            this.requests = (java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests>)requests;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesLimits> getLimits() {
            return this.limits;
        }

        @Override
        public final java.util.List<imports.kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResourcesRequests> getRequests() {
            return this.requests;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getLimits() != null) {
                data.set("limits", om.valueToTree(this.getLimits()));
            }
            if (this.getRequests() != null) {
                data.set("requests", om.valueToTree(this.getRequests()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.CronJobSpecJobTemplateSpecTemplateSpecContainerResources"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CronJobSpecJobTemplateSpecTemplateSpecContainerResources.Jsii$Proxy that = (CronJobSpecJobTemplateSpecTemplateSpecContainerResources.Jsii$Proxy) o;

            if (this.limits != null ? !this.limits.equals(that.limits) : that.limits != null) return false;
            return this.requests != null ? this.requests.equals(that.requests) : that.requests == null;
        }

        @Override
        public final int hashCode() {
            int result = this.limits != null ? this.limits.hashCode() : 0;
            result = 31 * result + (this.requests != null ? this.requests.hashCode() : 0);
            return result;
        }
    }
}
