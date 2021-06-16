package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.552Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DeploymentSpecTemplateSpecContainerEnvFrom")
@software.amazon.jsii.Jsii.Proxy(DeploymentSpecTemplateSpecContainerEnvFrom.Jsii$Proxy.class)
public interface DeploymentSpecTemplateSpecContainerEnvFrom extends software.amazon.jsii.JsiiSerializable {

    /**
     * config_map_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#config_map_ref Deployment#config_map_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> getConfigMapRef() {
        return null;
    }

    /**
     * An optional identifer to prepend to each key in the ConfigMap. Must be a C_IDENTIFIER.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#prefix Deployment#prefix}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPrefix() {
        return null;
    }

    /**
     * secret_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#secret_ref Deployment#secret_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> getSecretRef() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DeploymentSpecTemplateSpecContainerEnvFrom}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DeploymentSpecTemplateSpecContainerEnvFrom}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DeploymentSpecTemplateSpecContainerEnvFrom> {
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> configMapRef;
        private java.lang.String prefix;
        private java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> secretRef;

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecContainerEnvFrom#getConfigMapRef}
         * @param configMapRef config_map_ref block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#config_map_ref Deployment#config_map_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMapRef(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> configMapRef) {
            this.configMapRef = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef>)configMapRef;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecContainerEnvFrom#getPrefix}
         * @param prefix An optional identifer to prepend to each key in the ConfigMap. Must be a C_IDENTIFIER.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#prefix Deployment#prefix}
         * @return {@code this}
         */
        public Builder prefix(java.lang.String prefix) {
            this.prefix = prefix;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecTemplateSpecContainerEnvFrom#getSecretRef}
         * @param secretRef secret_ref block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#secret_ref Deployment#secret_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secretRef(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> secretRef) {
            this.secretRef = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef>)secretRef;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DeploymentSpecTemplateSpecContainerEnvFrom}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DeploymentSpecTemplateSpecContainerEnvFrom build() {
            return new Jsii$Proxy(configMapRef, prefix, secretRef);
        }
    }

    /**
     * An implementation for {@link DeploymentSpecTemplateSpecContainerEnvFrom}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DeploymentSpecTemplateSpecContainerEnvFrom {
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> configMapRef;
        private final java.lang.String prefix;
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> secretRef;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.configMapRef = software.amazon.jsii.Kernel.get(this, "configMapRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef.class)));
            this.prefix = software.amazon.jsii.Kernel.get(this, "prefix", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.secretRef = software.amazon.jsii.Kernel.get(this, "secretRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> configMapRef, final java.lang.String prefix, final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> secretRef) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.configMapRef = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef>)configMapRef;
            this.prefix = prefix;
            this.secretRef = (java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef>)secretRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromConfigMapRef> getConfigMapRef() {
            return this.configMapRef;
        }

        @Override
        public final java.lang.String getPrefix() {
            return this.prefix;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplateSpecContainerEnvFromSecretRef> getSecretRef() {
            return this.secretRef;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getConfigMapRef() != null) {
                data.set("configMapRef", om.valueToTree(this.getConfigMapRef()));
            }
            if (this.getPrefix() != null) {
                data.set("prefix", om.valueToTree(this.getPrefix()));
            }
            if (this.getSecretRef() != null) {
                data.set("secretRef", om.valueToTree(this.getSecretRef()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DeploymentSpecTemplateSpecContainerEnvFrom"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DeploymentSpecTemplateSpecContainerEnvFrom.Jsii$Proxy that = (DeploymentSpecTemplateSpecContainerEnvFrom.Jsii$Proxy) o;

            if (this.configMapRef != null ? !this.configMapRef.equals(that.configMapRef) : that.configMapRef != null) return false;
            if (this.prefix != null ? !this.prefix.equals(that.prefix) : that.prefix != null) return false;
            return this.secretRef != null ? this.secretRef.equals(that.secretRef) : that.secretRef == null;
        }

        @Override
        public final int hashCode() {
            int result = this.configMapRef != null ? this.configMapRef.hashCode() : 0;
            result = 31 * result + (this.prefix != null ? this.prefix.hashCode() : 0);
            result = 31 * result + (this.secretRef != null ? this.secretRef.hashCode() : 0);
            return result;
        }
    }
}
