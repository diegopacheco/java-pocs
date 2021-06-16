package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.967Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ValidatingWebhookConfigurationWebhookRule")
@software.amazon.jsii.Jsii.Proxy(ValidatingWebhookConfigurationWebhookRule.Jsii$Proxy.class)
public interface ValidatingWebhookConfigurationWebhookRule extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#api_groups ValidatingWebhookConfiguration#api_groups}.
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getApiGroups();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#api_versions ValidatingWebhookConfiguration#api_versions}.
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getApiVersions();

    /**
     * Operations is the operations the admission hook cares about - CREATE, UPDATE, or * for all operations.
     * <p>
     * If '*' is present, the length of the slice must be one. Required.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#operations ValidatingWebhookConfiguration#operations}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getOperations();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#resources ValidatingWebhookConfiguration#resources}.
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getResources();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#scope ValidatingWebhookConfiguration#scope}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getScope() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ValidatingWebhookConfigurationWebhookRule}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ValidatingWebhookConfigurationWebhookRule}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ValidatingWebhookConfigurationWebhookRule> {
        private java.util.List<java.lang.String> apiGroups;
        private java.util.List<java.lang.String> apiVersions;
        private java.util.List<java.lang.String> operations;
        private java.util.List<java.lang.String> resources;
        private java.lang.String scope;

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookRule#getApiGroups}
         * @param apiGroups Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#api_groups ValidatingWebhookConfiguration#api_groups}. This parameter is required.
         * @return {@code this}
         */
        public Builder apiGroups(java.util.List<java.lang.String> apiGroups) {
            this.apiGroups = apiGroups;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookRule#getApiVersions}
         * @param apiVersions Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#api_versions ValidatingWebhookConfiguration#api_versions}. This parameter is required.
         * @return {@code this}
         */
        public Builder apiVersions(java.util.List<java.lang.String> apiVersions) {
            this.apiVersions = apiVersions;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookRule#getOperations}
         * @param operations Operations is the operations the admission hook cares about - CREATE, UPDATE, or * for all operations. This parameter is required.
         *                   If '*' is present, the length of the slice must be one. Required.
         *                   <p>
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#operations ValidatingWebhookConfiguration#operations}
         * @return {@code this}
         */
        public Builder operations(java.util.List<java.lang.String> operations) {
            this.operations = operations;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookRule#getResources}
         * @param resources Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#resources ValidatingWebhookConfiguration#resources}. This parameter is required.
         * @return {@code this}
         */
        public Builder resources(java.util.List<java.lang.String> resources) {
            this.resources = resources;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookRule#getScope}
         * @param scope Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#scope ValidatingWebhookConfiguration#scope}.
         * @return {@code this}
         */
        public Builder scope(java.lang.String scope) {
            this.scope = scope;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ValidatingWebhookConfigurationWebhookRule}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ValidatingWebhookConfigurationWebhookRule build() {
            return new Jsii$Proxy(apiGroups, apiVersions, operations, resources, scope);
        }
    }

    /**
     * An implementation for {@link ValidatingWebhookConfigurationWebhookRule}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ValidatingWebhookConfigurationWebhookRule {
        private final java.util.List<java.lang.String> apiGroups;
        private final java.util.List<java.lang.String> apiVersions;
        private final java.util.List<java.lang.String> operations;
        private final java.util.List<java.lang.String> resources;
        private final java.lang.String scope;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.apiGroups = software.amazon.jsii.Kernel.get(this, "apiGroups", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.apiVersions = software.amazon.jsii.Kernel.get(this, "apiVersions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.operations = software.amazon.jsii.Kernel.get(this, "operations", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.resources = software.amazon.jsii.Kernel.get(this, "resources", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.scope = software.amazon.jsii.Kernel.get(this, "scope", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.List<java.lang.String> apiGroups, final java.util.List<java.lang.String> apiVersions, final java.util.List<java.lang.String> operations, final java.util.List<java.lang.String> resources, final java.lang.String scope) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.apiGroups = java.util.Objects.requireNonNull(apiGroups, "apiGroups is required");
            this.apiVersions = java.util.Objects.requireNonNull(apiVersions, "apiVersions is required");
            this.operations = java.util.Objects.requireNonNull(operations, "operations is required");
            this.resources = java.util.Objects.requireNonNull(resources, "resources is required");
            this.scope = scope;
        }

        @Override
        public final java.util.List<java.lang.String> getApiGroups() {
            return this.apiGroups;
        }

        @Override
        public final java.util.List<java.lang.String> getApiVersions() {
            return this.apiVersions;
        }

        @Override
        public final java.util.List<java.lang.String> getOperations() {
            return this.operations;
        }

        @Override
        public final java.util.List<java.lang.String> getResources() {
            return this.resources;
        }

        @Override
        public final java.lang.String getScope() {
            return this.scope;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("apiGroups", om.valueToTree(this.getApiGroups()));
            data.set("apiVersions", om.valueToTree(this.getApiVersions()));
            data.set("operations", om.valueToTree(this.getOperations()));
            data.set("resources", om.valueToTree(this.getResources()));
            if (this.getScope() != null) {
                data.set("scope", om.valueToTree(this.getScope()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ValidatingWebhookConfigurationWebhookRule"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ValidatingWebhookConfigurationWebhookRule.Jsii$Proxy that = (ValidatingWebhookConfigurationWebhookRule.Jsii$Proxy) o;

            if (!apiGroups.equals(that.apiGroups)) return false;
            if (!apiVersions.equals(that.apiVersions)) return false;
            if (!operations.equals(that.operations)) return false;
            if (!resources.equals(that.resources)) return false;
            return this.scope != null ? this.scope.equals(that.scope) : that.scope == null;
        }

        @Override
        public final int hashCode() {
            int result = this.apiGroups.hashCode();
            result = 31 * result + (this.apiVersions.hashCode());
            result = 31 * result + (this.operations.hashCode());
            result = 31 * result + (this.resources.hashCode());
            result = 31 * result + (this.scope != null ? this.scope.hashCode() : 0);
            return result;
        }
    }
}
