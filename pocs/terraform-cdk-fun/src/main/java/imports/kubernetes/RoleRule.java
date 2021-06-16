package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.878Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.RoleRule")
@software.amazon.jsii.Jsii.Proxy(RoleRule.Jsii$Proxy.class)
public interface RoleRule extends software.amazon.jsii.JsiiSerializable {

    /**
     * Name of the APIGroup that contains the resources.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#api_groups Role#api_groups}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getApiGroups();

    /**
     * List of resources that the rule applies to.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#resources Role#resources}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getResources();

    /**
     * List of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#verbs Role#verbs}
     */
    @org.jetbrains.annotations.NotNull java.util.List<java.lang.String> getVerbs();

    /**
     * White list of names that the rule applies to.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#resource_names Role#resource_names}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getResourceNames() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link RoleRule}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link RoleRule}
     */
    public static final class Builder implements software.amazon.jsii.Builder<RoleRule> {
        private java.util.List<java.lang.String> apiGroups;
        private java.util.List<java.lang.String> resources;
        private java.util.List<java.lang.String> verbs;
        private java.util.List<java.lang.String> resourceNames;

        /**
         * Sets the value of {@link RoleRule#getApiGroups}
         * @param apiGroups Name of the APIGroup that contains the resources. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#api_groups Role#api_groups}
         * @return {@code this}
         */
        public Builder apiGroups(java.util.List<java.lang.String> apiGroups) {
            this.apiGroups = apiGroups;
            return this;
        }

        /**
         * Sets the value of {@link RoleRule#getResources}
         * @param resources List of resources that the rule applies to. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#resources Role#resources}
         * @return {@code this}
         */
        public Builder resources(java.util.List<java.lang.String> resources) {
            this.resources = resources;
            return this;
        }

        /**
         * Sets the value of {@link RoleRule#getVerbs}
         * @param verbs List of Verbs that apply to ALL the ResourceKinds and AttributeRestrictions contained in this rule. This parameter is required.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#verbs Role#verbs}
         * @return {@code this}
         */
        public Builder verbs(java.util.List<java.lang.String> verbs) {
            this.verbs = verbs;
            return this;
        }

        /**
         * Sets the value of {@link RoleRule#getResourceNames}
         * @param resourceNames White list of names that the rule applies to.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role.html#resource_names Role#resource_names}
         * @return {@code this}
         */
        public Builder resourceNames(java.util.List<java.lang.String> resourceNames) {
            this.resourceNames = resourceNames;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link RoleRule}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public RoleRule build() {
            return new Jsii$Proxy(apiGroups, resources, verbs, resourceNames);
        }
    }

    /**
     * An implementation for {@link RoleRule}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements RoleRule {
        private final java.util.List<java.lang.String> apiGroups;
        private final java.util.List<java.lang.String> resources;
        private final java.util.List<java.lang.String> verbs;
        private final java.util.List<java.lang.String> resourceNames;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.apiGroups = software.amazon.jsii.Kernel.get(this, "apiGroups", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.resources = software.amazon.jsii.Kernel.get(this, "resources", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.verbs = software.amazon.jsii.Kernel.get(this, "verbs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.resourceNames = software.amazon.jsii.Kernel.get(this, "resourceNames", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.List<java.lang.String> apiGroups, final java.util.List<java.lang.String> resources, final java.util.List<java.lang.String> verbs, final java.util.List<java.lang.String> resourceNames) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.apiGroups = java.util.Objects.requireNonNull(apiGroups, "apiGroups is required");
            this.resources = java.util.Objects.requireNonNull(resources, "resources is required");
            this.verbs = java.util.Objects.requireNonNull(verbs, "verbs is required");
            this.resourceNames = resourceNames;
        }

        @Override
        public final java.util.List<java.lang.String> getApiGroups() {
            return this.apiGroups;
        }

        @Override
        public final java.util.List<java.lang.String> getResources() {
            return this.resources;
        }

        @Override
        public final java.util.List<java.lang.String> getVerbs() {
            return this.verbs;
        }

        @Override
        public final java.util.List<java.lang.String> getResourceNames() {
            return this.resourceNames;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("apiGroups", om.valueToTree(this.getApiGroups()));
            data.set("resources", om.valueToTree(this.getResources()));
            data.set("verbs", om.valueToTree(this.getVerbs()));
            if (this.getResourceNames() != null) {
                data.set("resourceNames", om.valueToTree(this.getResourceNames()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.RoleRule"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            RoleRule.Jsii$Proxy that = (RoleRule.Jsii$Proxy) o;

            if (!apiGroups.equals(that.apiGroups)) return false;
            if (!resources.equals(that.resources)) return false;
            if (!verbs.equals(that.verbs)) return false;
            return this.resourceNames != null ? this.resourceNames.equals(that.resourceNames) : that.resourceNames == null;
        }

        @Override
        public final int hashCode() {
            int result = this.apiGroups.hashCode();
            result = 31 * result + (this.resources.hashCode());
            result = 31 * result + (this.verbs.hashCode());
            result = 31 * result + (this.resourceNames != null ? this.resourceNames.hashCode() : 0);
            return result;
        }
    }
}
