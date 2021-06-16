package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.876Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ResourceQuotaSpec")
@software.amazon.jsii.Jsii.Proxy(ResourceQuotaSpec.Jsii$Proxy.class)
public interface ResourceQuotaSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * The set of desired hard limits for each named resource. More info: http://releases.k8s.io/HEAD/docs/design/admission_control_resource_quota.md#admissioncontrol-plugin-resourcequota.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/resource_quota.html#hard ResourceQuota#hard}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getHard() {
        return null;
    }

    /**
     * A collection of filters that must match each object tracked by a quota.
     * <p>
     * If not specified, the quota matches all objects.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/resource_quota.html#scopes ResourceQuota#scopes}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getScopes() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ResourceQuotaSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ResourceQuotaSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ResourceQuotaSpec> {
        private java.util.Map<java.lang.String, java.lang.String> hard;
        private java.util.List<java.lang.String> scopes;

        /**
         * Sets the value of {@link ResourceQuotaSpec#getHard}
         * @param hard The set of desired hard limits for each named resource. More info: http://releases.k8s.io/HEAD/docs/design/admission_control_resource_quota.md#admissioncontrol-plugin-resourcequota.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/resource_quota.html#hard ResourceQuota#hard}
         * @return {@code this}
         */
        public Builder hard(java.util.Map<java.lang.String, java.lang.String> hard) {
            this.hard = hard;
            return this;
        }

        /**
         * Sets the value of {@link ResourceQuotaSpec#getScopes}
         * @param scopes A collection of filters that must match each object tracked by a quota.
         *               If not specified, the quota matches all objects.
         *               <p>
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/resource_quota.html#scopes ResourceQuota#scopes}
         * @return {@code this}
         */
        public Builder scopes(java.util.List<java.lang.String> scopes) {
            this.scopes = scopes;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ResourceQuotaSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ResourceQuotaSpec build() {
            return new Jsii$Proxy(hard, scopes);
        }
    }

    /**
     * An implementation for {@link ResourceQuotaSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ResourceQuotaSpec {
        private final java.util.Map<java.lang.String, java.lang.String> hard;
        private final java.util.List<java.lang.String> scopes;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.hard = software.amazon.jsii.Kernel.get(this, "hard", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.scopes = software.amazon.jsii.Kernel.get(this, "scopes", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.Map<java.lang.String, java.lang.String> hard, final java.util.List<java.lang.String> scopes) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.hard = hard;
            this.scopes = scopes;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getHard() {
            return this.hard;
        }

        @Override
        public final java.util.List<java.lang.String> getScopes() {
            return this.scopes;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getHard() != null) {
                data.set("hard", om.valueToTree(this.getHard()));
            }
            if (this.getScopes() != null) {
                data.set("scopes", om.valueToTree(this.getScopes()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ResourceQuotaSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ResourceQuotaSpec.Jsii$Proxy that = (ResourceQuotaSpec.Jsii$Proxy) o;

            if (this.hard != null ? !this.hard.equals(that.hard) : that.hard != null) return false;
            return this.scopes != null ? this.scopes.equals(that.scopes) : that.scopes == null;
        }

        @Override
        public final int hashCode() {
            int result = this.hard != null ? this.hard.hashCode() : 0;
            result = 31 * result + (this.scopes != null ? this.scopes.hashCode() : 0);
            return result;
        }
    }
}
