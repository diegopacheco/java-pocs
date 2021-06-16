package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html kubernetes_validating_webhook_configuration}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.964Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ValidatingWebhookConfiguration")
public class ValidatingWebhookConfiguration extends com.hashicorp.cdktf.TerraformResource {

    protected ValidatingWebhookConfiguration(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected ValidatingWebhookConfiguration(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html kubernetes_validating_webhook_configuration} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public ValidatingWebhookConfiguration(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.ValidatingWebhookConfigurationConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ValidatingWebhookConfigurationMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationWebhook> getWebhookInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "webhookInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ValidatingWebhookConfigurationWebhook.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ValidatingWebhookConfigurationMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationWebhook> getWebhook() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "webhook", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ValidatingWebhookConfigurationWebhook.class))));
    }

    public void setWebhook(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ValidatingWebhookConfigurationWebhook> value) {
        software.amazon.jsii.Kernel.set(this, "webhook", java.util.Objects.requireNonNull(value, "webhook is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.ValidatingWebhookConfiguration}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.ValidatingWebhookConfiguration> {
        /**
         * @return a new instance of {@link Builder}.
         * @param scope The scope in which to define this construct. This parameter is required.
         * @param id The scoped construct ID. This parameter is required.
         */
        public static Builder create(final software.constructs.Construct scope, final java.lang.String id) {
            return new Builder(scope, id);
        }

        private final software.constructs.Construct scope;
        private final java.lang.String id;
        private final imports.kubernetes.ValidatingWebhookConfigurationConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.ValidatingWebhookConfigurationConfig.Builder();
        }

        /**
         * @return {@code this}
         * @param count This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(final java.lang.Number count) {
            this.config.count(count);
            return this;
        }

        /**
         * @return {@code this}
         * @param dependsOn This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder dependsOn(final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn) {
            this.config.dependsOn(dependsOn);
            return this;
        }

        /**
         * @return {@code this}
         * @param lifecycle This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.config.lifecycle(lifecycle);
            return this;
        }

        /**
         * @return {@code this}
         * @param provider This parameter is required.
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder provider(final com.hashicorp.cdktf.TerraformProvider provider) {
            this.config.provider(provider);
            return this;
        }

        /**
         * metadata block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#metadata ValidatingWebhookConfiguration#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.ValidatingWebhookConfigurationMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * webhook block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/validating_webhook_configuration.html#webhook ValidatingWebhookConfiguration#webhook}
         * <p>
         * @return {@code this}
         * @param webhook webhook block. This parameter is required.
         */
        public Builder webhook(final java.util.List<? extends imports.kubernetes.ValidatingWebhookConfigurationWebhook> webhook) {
            this.config.webhook(webhook);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.ValidatingWebhookConfiguration}.
         */
        @Override
        public imports.kubernetes.ValidatingWebhookConfiguration build() {
            return new imports.kubernetes.ValidatingWebhookConfiguration(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
