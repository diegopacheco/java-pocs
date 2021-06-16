package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.881Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ServiceAccountConfig")
@software.amazon.jsii.Jsii.Proxy(ServiceAccountConfig.Jsii$Proxy.class)
public interface ServiceAccountConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * metadata block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#metadata ServiceAccount#metadata}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountMetadata> getMetadata();

    /**
     * True to enable automatic mounting of the service account token.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#automount_service_account_token ServiceAccount#automount_service_account_token}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getAutomountServiceAccountToken() {
        return null;
    }

    /**
     * image_pull_secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#image_pull_secret ServiceAccount#image_pull_secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> getImagePullSecret() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#secret ServiceAccount#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ServiceAccountSecret> getSecret() {
        return null;
    }

    /**
     * timeouts block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#timeouts ServiceAccount#timeouts}
     */
    default @org.jetbrains.annotations.Nullable imports.kubernetes.ServiceAccountTimeouts getTimeouts() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServiceAccountConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServiceAccountConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServiceAccountConfig> {
        private java.util.List<imports.kubernetes.ServiceAccountMetadata> metadata;
        private java.lang.Boolean automountServiceAccountToken;
        private java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> imagePullSecret;
        private java.util.List<imports.kubernetes.ServiceAccountSecret> secret;
        private imports.kubernetes.ServiceAccountTimeouts timeouts;
        private java.lang.Number count;
        private java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private com.hashicorp.cdktf.TerraformProvider provider;

        /**
         * Sets the value of {@link ServiceAccountConfig#getMetadata}
         * @param metadata metadata block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#metadata ServiceAccount#metadata}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metadata(java.util.List<? extends imports.kubernetes.ServiceAccountMetadata> metadata) {
            this.metadata = (java.util.List<imports.kubernetes.ServiceAccountMetadata>)metadata;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getAutomountServiceAccountToken}
         * @param automountServiceAccountToken True to enable automatic mounting of the service account token.
         *                                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#automount_service_account_token ServiceAccount#automount_service_account_token}
         * @return {@code this}
         */
        public Builder automountServiceAccountToken(java.lang.Boolean automountServiceAccountToken) {
            this.automountServiceAccountToken = automountServiceAccountToken;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getImagePullSecret}
         * @param imagePullSecret image_pull_secret block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#image_pull_secret ServiceAccount#image_pull_secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder imagePullSecret(java.util.List<? extends imports.kubernetes.ServiceAccountImagePullSecret> imagePullSecret) {
            this.imagePullSecret = (java.util.List<imports.kubernetes.ServiceAccountImagePullSecret>)imagePullSecret;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#secret ServiceAccount#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.ServiceAccountSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.ServiceAccountSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getTimeouts}
         * @param timeouts timeouts block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#timeouts ServiceAccount#timeouts}
         * @return {@code this}
         */
        public Builder timeouts(imports.kubernetes.ServiceAccountTimeouts timeouts) {
            this.timeouts = timeouts;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getDependsOn}
         * @param dependsOn the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        @SuppressWarnings("unchecked")
        public Builder dependsOn(java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link ServiceAccountConfig#getProvider}
         * @param provider the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(com.hashicorp.cdktf.TerraformProvider provider) {
            this.provider = provider;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServiceAccountConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServiceAccountConfig build() {
            return new Jsii$Proxy(metadata, automountServiceAccountToken, imagePullSecret, secret, timeouts, count, dependsOn, lifecycle, provider);
        }
    }

    /**
     * An implementation for {@link ServiceAccountConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServiceAccountConfig {
        private final java.util.List<imports.kubernetes.ServiceAccountMetadata> metadata;
        private final java.lang.Boolean automountServiceAccountToken;
        private final java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> imagePullSecret;
        private final java.util.List<imports.kubernetes.ServiceAccountSecret> secret;
        private final imports.kubernetes.ServiceAccountTimeouts timeouts;
        private final java.lang.Number count;
        private final java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private final com.hashicorp.cdktf.TerraformProvider provider;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.metadata = software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountMetadata.class)));
            this.automountServiceAccountToken = software.amazon.jsii.Kernel.get(this, "automountServiceAccountToken", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.imagePullSecret = software.amazon.jsii.Kernel.get(this, "imagePullSecret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountImagePullSecret.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountSecret.class)));
            this.timeouts = software.amazon.jsii.Kernel.get(this, "timeouts", software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountTimeouts.class));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.ServiceAccountMetadata> metadata, final java.lang.Boolean automountServiceAccountToken, final java.util.List<? extends imports.kubernetes.ServiceAccountImagePullSecret> imagePullSecret, final java.util.List<? extends imports.kubernetes.ServiceAccountSecret> secret, final imports.kubernetes.ServiceAccountTimeouts timeouts, final java.lang.Number count, final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn, final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle, final com.hashicorp.cdktf.TerraformProvider provider) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.metadata = (java.util.List<imports.kubernetes.ServiceAccountMetadata>)java.util.Objects.requireNonNull(metadata, "metadata is required");
            this.automountServiceAccountToken = automountServiceAccountToken;
            this.imagePullSecret = (java.util.List<imports.kubernetes.ServiceAccountImagePullSecret>)imagePullSecret;
            this.secret = (java.util.List<imports.kubernetes.ServiceAccountSecret>)secret;
            this.timeouts = timeouts;
            this.count = count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            this.lifecycle = lifecycle;
            this.provider = provider;
        }

        @Override
        public final java.util.List<imports.kubernetes.ServiceAccountMetadata> getMetadata() {
            return this.metadata;
        }

        @Override
        public final java.lang.Boolean getAutomountServiceAccountToken() {
            return this.automountServiceAccountToken;
        }

        @Override
        public final java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> getImagePullSecret() {
            return this.imagePullSecret;
        }

        @Override
        public final java.util.List<imports.kubernetes.ServiceAccountSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final imports.kubernetes.ServiceAccountTimeouts getTimeouts() {
            return this.timeouts;
        }

        @Override
        public final java.lang.Number getCount() {
            return this.count;
        }

        @Override
        public final java.util.List<com.hashicorp.cdktf.ITerraformDependable> getDependsOn() {
            return this.dependsOn;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformResourceLifecycle getLifecycle() {
            return this.lifecycle;
        }

        @Override
        public final com.hashicorp.cdktf.TerraformProvider getProvider() {
            return this.provider;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("metadata", om.valueToTree(this.getMetadata()));
            if (this.getAutomountServiceAccountToken() != null) {
                data.set("automountServiceAccountToken", om.valueToTree(this.getAutomountServiceAccountToken()));
            }
            if (this.getImagePullSecret() != null) {
                data.set("imagePullSecret", om.valueToTree(this.getImagePullSecret()));
            }
            if (this.getSecret() != null) {
                data.set("secret", om.valueToTree(this.getSecret()));
            }
            if (this.getTimeouts() != null) {
                data.set("timeouts", om.valueToTree(this.getTimeouts()));
            }
            if (this.getCount() != null) {
                data.set("count", om.valueToTree(this.getCount()));
            }
            if (this.getDependsOn() != null) {
                data.set("dependsOn", om.valueToTree(this.getDependsOn()));
            }
            if (this.getLifecycle() != null) {
                data.set("lifecycle", om.valueToTree(this.getLifecycle()));
            }
            if (this.getProvider() != null) {
                data.set("provider", om.valueToTree(this.getProvider()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ServiceAccountConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServiceAccountConfig.Jsii$Proxy that = (ServiceAccountConfig.Jsii$Proxy) o;

            if (!metadata.equals(that.metadata)) return false;
            if (this.automountServiceAccountToken != null ? !this.automountServiceAccountToken.equals(that.automountServiceAccountToken) : that.automountServiceAccountToken != null) return false;
            if (this.imagePullSecret != null ? !this.imagePullSecret.equals(that.imagePullSecret) : that.imagePullSecret != null) return false;
            if (this.secret != null ? !this.secret.equals(that.secret) : that.secret != null) return false;
            if (this.timeouts != null ? !this.timeouts.equals(that.timeouts) : that.timeouts != null) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            return this.provider != null ? this.provider.equals(that.provider) : that.provider == null;
        }

        @Override
        public final int hashCode() {
            int result = this.metadata.hashCode();
            result = 31 * result + (this.automountServiceAccountToken != null ? this.automountServiceAccountToken.hashCode() : 0);
            result = 31 * result + (this.imagePullSecret != null ? this.imagePullSecret.hashCode() : 0);
            result = 31 * result + (this.secret != null ? this.secret.hashCode() : 0);
            result = 31 * result + (this.timeouts != null ? this.timeouts.hashCode() : 0);
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            return result;
        }
    }
}
