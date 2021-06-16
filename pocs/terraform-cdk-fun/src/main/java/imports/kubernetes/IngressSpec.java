package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.605Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.IngressSpec")
@software.amazon.jsii.Jsii.Proxy(IngressSpec.Jsii$Proxy.class)
public interface IngressSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * backend block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#backend Ingress#backend}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.IngressSpecBackend> getBackend() {
        return null;
    }

    /**
     * rule block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#rule Ingress#rule}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.IngressSpecRule> getRule() {
        return null;
    }

    /**
     * tls block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#tls Ingress#tls}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.IngressSpecTls> getTls() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link IngressSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link IngressSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<IngressSpec> {
        private java.util.List<imports.kubernetes.IngressSpecBackend> backend;
        private java.util.List<imports.kubernetes.IngressSpecRule> rule;
        private java.util.List<imports.kubernetes.IngressSpecTls> tls;

        /**
         * Sets the value of {@link IngressSpec#getBackend}
         * @param backend backend block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#backend Ingress#backend}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder backend(java.util.List<? extends imports.kubernetes.IngressSpecBackend> backend) {
            this.backend = (java.util.List<imports.kubernetes.IngressSpecBackend>)backend;
            return this;
        }

        /**
         * Sets the value of {@link IngressSpec#getRule}
         * @param rule rule block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#rule Ingress#rule}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rule(java.util.List<? extends imports.kubernetes.IngressSpecRule> rule) {
            this.rule = (java.util.List<imports.kubernetes.IngressSpecRule>)rule;
            return this;
        }

        /**
         * Sets the value of {@link IngressSpec#getTls}
         * @param tls tls block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#tls Ingress#tls}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder tls(java.util.List<? extends imports.kubernetes.IngressSpecTls> tls) {
            this.tls = (java.util.List<imports.kubernetes.IngressSpecTls>)tls;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link IngressSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public IngressSpec build() {
            return new Jsii$Proxy(backend, rule, tls);
        }
    }

    /**
     * An implementation for {@link IngressSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements IngressSpec {
        private final java.util.List<imports.kubernetes.IngressSpecBackend> backend;
        private final java.util.List<imports.kubernetes.IngressSpecRule> rule;
        private final java.util.List<imports.kubernetes.IngressSpecTls> tls;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.backend = software.amazon.jsii.Kernel.get(this, "backend", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpecBackend.class)));
            this.rule = software.amazon.jsii.Kernel.get(this, "rule", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpecRule.class)));
            this.tls = software.amazon.jsii.Kernel.get(this, "tls", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpecTls.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.IngressSpecBackend> backend, final java.util.List<? extends imports.kubernetes.IngressSpecRule> rule, final java.util.List<? extends imports.kubernetes.IngressSpecTls> tls) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.backend = (java.util.List<imports.kubernetes.IngressSpecBackend>)backend;
            this.rule = (java.util.List<imports.kubernetes.IngressSpecRule>)rule;
            this.tls = (java.util.List<imports.kubernetes.IngressSpecTls>)tls;
        }

        @Override
        public final java.util.List<imports.kubernetes.IngressSpecBackend> getBackend() {
            return this.backend;
        }

        @Override
        public final java.util.List<imports.kubernetes.IngressSpecRule> getRule() {
            return this.rule;
        }

        @Override
        public final java.util.List<imports.kubernetes.IngressSpecTls> getTls() {
            return this.tls;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getBackend() != null) {
                data.set("backend", om.valueToTree(this.getBackend()));
            }
            if (this.getRule() != null) {
                data.set("rule", om.valueToTree(this.getRule()));
            }
            if (this.getTls() != null) {
                data.set("tls", om.valueToTree(this.getTls()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.IngressSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IngressSpec.Jsii$Proxy that = (IngressSpec.Jsii$Proxy) o;

            if (this.backend != null ? !this.backend.equals(that.backend) : that.backend != null) return false;
            if (this.rule != null ? !this.rule.equals(that.rule) : that.rule != null) return false;
            return this.tls != null ? this.tls.equals(that.tls) : that.tls == null;
        }

        @Override
        public final int hashCode() {
            int result = this.backend != null ? this.backend.hashCode() : 0;
            result = 31 * result + (this.rule != null ? this.rule.hashCode() : 0);
            result = 31 * result + (this.tls != null ? this.tls.hashCode() : 0);
            return result;
        }
    }
}
