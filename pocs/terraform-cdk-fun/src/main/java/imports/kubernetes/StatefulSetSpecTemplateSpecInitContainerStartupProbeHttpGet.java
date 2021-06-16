package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.945Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet extends software.amazon.jsii.JsiiSerializable {

    /**
     * Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host StatefulSet#host}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getHost() {
        return null;
    }

    /**
     * http_header block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_header StatefulSet#http_header}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> getHttpHeader() {
        return null;
    }

    /**
     * Path to access on the HTTP server.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#path StatefulSet#path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPath() {
        return null;
    }

    /**
     * Name or number of the port to access on the container.
     * <p>
     * Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#port StatefulSet#port}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPort() {
        return null;
    }

    /**
     * Scheme to use for connecting to the host.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#scheme StatefulSet#scheme}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getScheme() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet> {
        private java.lang.String host;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> httpHeader;
        private java.lang.String path;
        private java.lang.String port;
        private java.lang.String scheme;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet#getHost}
         * @param host Host name to connect to, defaults to the pod IP. You probably want to set "Host" in httpHeaders instead.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host StatefulSet#host}
         * @return {@code this}
         */
        public Builder host(java.lang.String host) {
            this.host = host;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet#getHttpHeader}
         * @param httpHeader http_header block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_header StatefulSet#http_header}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder httpHeader(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> httpHeader) {
            this.httpHeader = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader>)httpHeader;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet#getPath}
         * @param path Path to access on the HTTP server.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#path StatefulSet#path}
         * @return {@code this}
         */
        public Builder path(java.lang.String path) {
            this.path = path;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet#getPort}
         * @param port Name or number of the port to access on the container.
         *             Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#port StatefulSet#port}
         * @return {@code this}
         */
        public Builder port(java.lang.String port) {
            this.port = port;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet#getScheme}
         * @param scheme Scheme to use for connecting to the host.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#scheme StatefulSet#scheme}
         * @return {@code this}
         */
        public Builder scheme(java.lang.String scheme) {
            this.scheme = scheme;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet build() {
            return new Jsii$Proxy(host, httpHeader, path, port, scheme);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet {
        private final java.lang.String host;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> httpHeader;
        private final java.lang.String path;
        private final java.lang.String port;
        private final java.lang.String scheme;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.host = software.amazon.jsii.Kernel.get(this, "host", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.httpHeader = software.amazon.jsii.Kernel.get(this, "httpHeader", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader.class)));
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.scheme = software.amazon.jsii.Kernel.get(this, "scheme", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String host, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> httpHeader, final java.lang.String path, final java.lang.String port, final java.lang.String scheme) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.host = host;
            this.httpHeader = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader>)httpHeader;
            this.path = path;
            this.port = port;
            this.scheme = scheme;
        }

        @Override
        public final java.lang.String getHost() {
            return this.host;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGetHttpHeader> getHttpHeader() {
            return this.httpHeader;
        }

        @Override
        public final java.lang.String getPath() {
            return this.path;
        }

        @Override
        public final java.lang.String getPort() {
            return this.port;
        }

        @Override
        public final java.lang.String getScheme() {
            return this.scheme;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getHost() != null) {
                data.set("host", om.valueToTree(this.getHost()));
            }
            if (this.getHttpHeader() != null) {
                data.set("httpHeader", om.valueToTree(this.getHttpHeader()));
            }
            if (this.getPath() != null) {
                data.set("path", om.valueToTree(this.getPath()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }
            if (this.getScheme() != null) {
                data.set("scheme", om.valueToTree(this.getScheme()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet.Jsii$Proxy that = (StatefulSetSpecTemplateSpecInitContainerStartupProbeHttpGet.Jsii$Proxy) o;

            if (this.host != null ? !this.host.equals(that.host) : that.host != null) return false;
            if (this.httpHeader != null ? !this.httpHeader.equals(that.httpHeader) : that.httpHeader != null) return false;
            if (this.path != null ? !this.path.equals(that.path) : that.path != null) return false;
            if (this.port != null ? !this.port.equals(that.port) : that.port != null) return false;
            return this.scheme != null ? this.scheme.equals(that.scheme) : that.scheme == null;
        }

        @Override
        public final int hashCode() {
            int result = this.host != null ? this.host.hashCode() : 0;
            result = 31 * result + (this.httpHeader != null ? this.httpHeader.hashCode() : 0);
            result = 31 * result + (this.path != null ? this.path.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            result = 31 * result + (this.scheme != null ? this.scheme.hashCode() : 0);
            return result;
        }
    }
}
