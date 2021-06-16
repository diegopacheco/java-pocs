package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.606Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.IngressSpecRuleHttpPath")
@software.amazon.jsii.Jsii.Proxy(IngressSpecRuleHttpPath.Jsii$Proxy.class)
public interface IngressSpecRuleHttpPath extends software.amazon.jsii.JsiiSerializable {

    /**
     * backend block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#backend Ingress#backend}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend> getBackend() {
        return null;
    }

    /**
     * Path is an extended POSIX regex as defined by IEEE Std 1003.1, (i.e this follows the egrep/unix syntax, not the perl syntax) matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. If unspecified, the path defaults to a catch all sending traffic to the backend.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#path Ingress#path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPath() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link IngressSpecRuleHttpPath}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link IngressSpecRuleHttpPath}
     */
    public static final class Builder implements software.amazon.jsii.Builder<IngressSpecRuleHttpPath> {
        private java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend> backend;
        private java.lang.String path;

        /**
         * Sets the value of {@link IngressSpecRuleHttpPath#getBackend}
         * @param backend backend block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#backend Ingress#backend}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder backend(java.util.List<? extends imports.kubernetes.IngressSpecRuleHttpPathBackend> backend) {
            this.backend = (java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend>)backend;
            return this;
        }

        /**
         * Sets the value of {@link IngressSpecRuleHttpPath#getPath}
         * @param path Path is an extended POSIX regex as defined by IEEE Std 1003.1, (i.e this follows the egrep/unix syntax, not the perl syntax) matched against the path of an incoming request. Currently it can contain characters disallowed from the conventional "path" part of a URL as defined by RFC 3986. Paths must begin with a '/'. If unspecified, the path defaults to a catch all sending traffic to the backend.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#path Ingress#path}
         * @return {@code this}
         */
        public Builder path(java.lang.String path) {
            this.path = path;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link IngressSpecRuleHttpPath}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public IngressSpecRuleHttpPath build() {
            return new Jsii$Proxy(backend, path);
        }
    }

    /**
     * An implementation for {@link IngressSpecRuleHttpPath}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements IngressSpecRuleHttpPath {
        private final java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend> backend;
        private final java.lang.String path;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.backend = software.amazon.jsii.Kernel.get(this, "backend", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpecRuleHttpPathBackend.class)));
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.IngressSpecRuleHttpPathBackend> backend, final java.lang.String path) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.backend = (java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend>)backend;
            this.path = path;
        }

        @Override
        public final java.util.List<imports.kubernetes.IngressSpecRuleHttpPathBackend> getBackend() {
            return this.backend;
        }

        @Override
        public final java.lang.String getPath() {
            return this.path;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getBackend() != null) {
                data.set("backend", om.valueToTree(this.getBackend()));
            }
            if (this.getPath() != null) {
                data.set("path", om.valueToTree(this.getPath()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.IngressSpecRuleHttpPath"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IngressSpecRuleHttpPath.Jsii$Proxy that = (IngressSpecRuleHttpPath.Jsii$Proxy) o;

            if (this.backend != null ? !this.backend.equals(that.backend) : that.backend != null) return false;
            return this.path != null ? this.path.equals(that.path) : that.path == null;
        }

        @Override
        public final int hashCode() {
            int result = this.backend != null ? this.backend.hashCode() : 0;
            result = 31 * result + (this.path != null ? this.path.hashCode() : 0);
            return result;
        }
    }
}
