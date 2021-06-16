package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.606Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.IngressSpecRuleHttp")
@software.amazon.jsii.Jsii.Proxy(IngressSpecRuleHttp.Jsii$Proxy.class)
public interface IngressSpecRuleHttp extends software.amazon.jsii.JsiiSerializable {

    /**
     * path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#path Ingress#path}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressSpecRuleHttpPath> getPath();

    /**
     * @return a {@link Builder} of {@link IngressSpecRuleHttp}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link IngressSpecRuleHttp}
     */
    public static final class Builder implements software.amazon.jsii.Builder<IngressSpecRuleHttp> {
        private java.util.List<imports.kubernetes.IngressSpecRuleHttpPath> path;

        /**
         * Sets the value of {@link IngressSpecRuleHttp#getPath}
         * @param path path block. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#path Ingress#path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder path(java.util.List<? extends imports.kubernetes.IngressSpecRuleHttpPath> path) {
            this.path = (java.util.List<imports.kubernetes.IngressSpecRuleHttpPath>)path;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link IngressSpecRuleHttp}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public IngressSpecRuleHttp build() {
            return new Jsii$Proxy(path);
        }
    }

    /**
     * An implementation for {@link IngressSpecRuleHttp}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements IngressSpecRuleHttp {
        private final java.util.List<imports.kubernetes.IngressSpecRuleHttpPath> path;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpecRuleHttpPath.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.IngressSpecRuleHttpPath> path) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.path = (java.util.List<imports.kubernetes.IngressSpecRuleHttpPath>)java.util.Objects.requireNonNull(path, "path is required");
        }

        @Override
        public final java.util.List<imports.kubernetes.IngressSpecRuleHttpPath> getPath() {
            return this.path;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("path", om.valueToTree(this.getPath()));

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.IngressSpecRuleHttp"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IngressSpecRuleHttp.Jsii$Proxy that = (IngressSpecRuleHttp.Jsii$Proxy) o;

            return this.path.equals(that.path);
        }

        @Override
        public final int hashCode() {
            int result = this.path.hashCode();
            return result;
        }
    }
}
