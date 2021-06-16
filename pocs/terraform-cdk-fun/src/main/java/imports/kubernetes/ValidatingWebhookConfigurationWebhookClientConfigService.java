package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.966Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ValidatingWebhookConfigurationWebhookClientConfigService")
@software.amazon.jsii.Jsii.Proxy(ValidatingWebhookConfigurationWebhookClientConfigService.Jsii$Proxy.class)
public interface ValidatingWebhookConfigurationWebhookClientConfigService extends software.amazon.jsii.JsiiSerializable {

    /**
     * `name` is the name of the service. Required.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#name ValidatingWebhookConfiguration#name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * `namespace` is the namespace of the service. Required.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#namespace ValidatingWebhookConfiguration#namespace}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getNamespace();

    /**
     * `path` is an optional URL path which will be sent in any request to this service.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#path ValidatingWebhookConfiguration#path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPath() {
        return null;
    }

    /**
     * If specified, the port on the service that hosting webhook.
     * <p>
     * Default to 443 for backward compatibility. <code>port</code> should be a valid port number (1-65535, inclusive).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#port ValidatingWebhookConfiguration#port}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getPort() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ValidatingWebhookConfigurationWebhookClientConfigService}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ValidatingWebhookConfigurationWebhookClientConfigService}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ValidatingWebhookConfigurationWebhookClientConfigService> {
        private java.lang.String name;
        private java.lang.String namespace;
        private java.lang.String path;
        private java.lang.Number port;

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookClientConfigService#getName}
         * @param name `name` is the name of the service. Required. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#name ValidatingWebhookConfiguration#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookClientConfigService#getNamespace}
         * @param namespace `namespace` is the namespace of the service. Required. This parameter is required.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#namespace ValidatingWebhookConfiguration#namespace}
         * @return {@code this}
         */
        public Builder namespace(java.lang.String namespace) {
            this.namespace = namespace;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookClientConfigService#getPath}
         * @param path `path` is an optional URL path which will be sent in any request to this service.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#path ValidatingWebhookConfiguration#path}
         * @return {@code this}
         */
        public Builder path(java.lang.String path) {
            this.path = path;
            return this;
        }

        /**
         * Sets the value of {@link ValidatingWebhookConfigurationWebhookClientConfigService#getPort}
         * @param port If specified, the port on the service that hosting webhook.
         *             Default to 443 for backward compatibility. <code>port</code> should be a valid port number (1-65535, inclusive).
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#port ValidatingWebhookConfiguration#port}
         * @return {@code this}
         */
        public Builder port(java.lang.Number port) {
            this.port = port;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ValidatingWebhookConfigurationWebhookClientConfigService}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ValidatingWebhookConfigurationWebhookClientConfigService build() {
            return new Jsii$Proxy(name, namespace, path, port);
        }
    }

    /**
     * An implementation for {@link ValidatingWebhookConfigurationWebhookClientConfigService}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ValidatingWebhookConfigurationWebhookClientConfigService {
        private final java.lang.String name;
        private final java.lang.String namespace;
        private final java.lang.String path;
        private final java.lang.Number port;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.namespace = software.amazon.jsii.Kernel.get(this, "namespace", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.path = software.amazon.jsii.Kernel.get(this, "path", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String name, final java.lang.String namespace, final java.lang.String path, final java.lang.Number port) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.name = java.util.Objects.requireNonNull(name, "name is required");
            this.namespace = java.util.Objects.requireNonNull(namespace, "namespace is required");
            this.path = path;
            this.port = port;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.String getNamespace() {
            return this.namespace;
        }

        @Override
        public final java.lang.String getPath() {
            return this.path;
        }

        @Override
        public final java.lang.Number getPort() {
            return this.port;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("name", om.valueToTree(this.getName()));
            data.set("namespace", om.valueToTree(this.getNamespace()));
            if (this.getPath() != null) {
                data.set("path", om.valueToTree(this.getPath()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ValidatingWebhookConfigurationWebhookClientConfigService"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ValidatingWebhookConfigurationWebhookClientConfigService.Jsii$Proxy that = (ValidatingWebhookConfigurationWebhookClientConfigService.Jsii$Proxy) o;

            if (!name.equals(that.name)) return false;
            if (!namespace.equals(that.namespace)) return false;
            if (this.path != null ? !this.path.equals(that.path) : that.path != null) return false;
            return this.port != null ? this.port.equals(that.port) : that.port == null;
        }

        @Override
        public final int hashCode() {
            int result = this.name.hashCode();
            result = 31 * result + (this.namespace.hashCode());
            result = 31 * result + (this.path != null ? this.path.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            return result;
        }
    }
}
