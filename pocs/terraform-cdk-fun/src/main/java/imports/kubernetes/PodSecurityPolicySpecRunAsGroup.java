package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.705Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSecurityPolicySpecRunAsGroup")
@software.amazon.jsii.Jsii.Proxy(PodSecurityPolicySpecRunAsGroup.Jsii$Proxy.class)
public interface PodSecurityPolicySpecRunAsGroup extends software.amazon.jsii.JsiiSerializable {

    /**
     * rule is the strategy that will dictate the allowable RunAsGroup values that may be set.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#rule PodSecurityPolicy#rule}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getRule();

    /**
     * range block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#range PodSecurityPolicy#range}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> getRange() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSecurityPolicySpecRunAsGroup}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSecurityPolicySpecRunAsGroup}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSecurityPolicySpecRunAsGroup> {
        private java.lang.String rule;
        private java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> range;

        /**
         * Sets the value of {@link PodSecurityPolicySpecRunAsGroup#getRule}
         * @param rule rule is the strategy that will dictate the allowable RunAsGroup values that may be set. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#rule PodSecurityPolicy#rule}
         * @return {@code this}
         */
        public Builder rule(java.lang.String rule) {
            this.rule = rule;
            return this;
        }

        /**
         * Sets the value of {@link PodSecurityPolicySpecRunAsGroup#getRange}
         * @param range range block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_security_policy.html#range PodSecurityPolicy#range}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder range(java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> range) {
            this.range = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange>)range;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSecurityPolicySpecRunAsGroup}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSecurityPolicySpecRunAsGroup build() {
            return new Jsii$Proxy(rule, range);
        }
    }

    /**
     * An implementation for {@link PodSecurityPolicySpecRunAsGroup}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSecurityPolicySpecRunAsGroup {
        private final java.lang.String rule;
        private final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> range;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.rule = software.amazon.jsii.Kernel.get(this, "rule", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.range = software.amazon.jsii.Kernel.get(this, "range", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String rule, final java.util.List<? extends imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> range) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.rule = java.util.Objects.requireNonNull(rule, "rule is required");
            this.range = (java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange>)range;
        }

        @Override
        public final java.lang.String getRule() {
            return this.rule;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSecurityPolicySpecRunAsGroupRange> getRange() {
            return this.range;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("rule", om.valueToTree(this.getRule()));
            if (this.getRange() != null) {
                data.set("range", om.valueToTree(this.getRange()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSecurityPolicySpecRunAsGroup"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSecurityPolicySpecRunAsGroup.Jsii$Proxy that = (PodSecurityPolicySpecRunAsGroup.Jsii$Proxy) o;

            if (!rule.equals(that.rule)) return false;
            return this.range != null ? this.range.equals(that.range) : that.range == null;
        }

        @Override
        public final int hashCode() {
            int result = this.rule.hashCode();
            result = 31 * result + (this.range != null ? this.range.hashCode() : 0);
            return result;
        }
    }
}
