package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html kubernetes_service_account}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.880Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ServiceAccount")
public class ServiceAccount extends com.hashicorp.cdktf.TerraformResource {

    protected ServiceAccount(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected ServiceAccount(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html kubernetes_service_account} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public ServiceAccount(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.ServiceAccountConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    public void resetAutomountServiceAccountToken() {
        software.amazon.jsii.Kernel.call(this, "resetAutomountServiceAccountToken", software.amazon.jsii.NativeType.VOID);
    }

    public void resetImagePullSecret() {
        software.amazon.jsii.Kernel.call(this, "resetImagePullSecret", software.amazon.jsii.NativeType.VOID);
    }

    public void resetSecret() {
        software.amazon.jsii.Kernel.call(this, "resetSecret", software.amazon.jsii.NativeType.VOID);
    }

    public void resetTimeouts() {
        software.amazon.jsii.Kernel.call(this, "resetTimeouts", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getDefaultSecretName() {
        return software.amazon.jsii.Kernel.get(this, "defaultSecretName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountMetadata.class))));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getAutomountServiceAccountTokenInput() {
        return software.amazon.jsii.Kernel.get(this, "automountServiceAccountTokenInput", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> getImagePullSecretInput() {
        return java.util.Optional.ofNullable((java.util.List<imports.kubernetes.ServiceAccountImagePullSecret>)(software.amazon.jsii.Kernel.get(this, "imagePullSecretInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountImagePullSecret.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ServiceAccountSecret> getSecretInput() {
        return java.util.Optional.ofNullable((java.util.List<imports.kubernetes.ServiceAccountSecret>)(software.amazon.jsii.Kernel.get(this, "secretInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountSecret.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable imports.kubernetes.ServiceAccountTimeouts getTimeoutsInput() {
        return software.amazon.jsii.Kernel.get(this, "timeoutsInput", software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountTimeouts.class));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Boolean getAutomountServiceAccountToken() {
        return software.amazon.jsii.Kernel.get(this, "automountServiceAccountToken", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public void setAutomountServiceAccountToken(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "automountServiceAccountToken", java.util.Objects.requireNonNull(value, "automountServiceAccountToken is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> getImagePullSecret() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "imagePullSecret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountImagePullSecret.class))));
    }

    public void setImagePullSecret(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountImagePullSecret> value) {
        software.amazon.jsii.Kernel.set(this, "imagePullSecret", java.util.Objects.requireNonNull(value, "imagePullSecret is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountSecret> getSecret() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountSecret.class))));
    }

    public void setSecret(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ServiceAccountSecret> value) {
        software.amazon.jsii.Kernel.set(this, "secret", java.util.Objects.requireNonNull(value, "secret is required"));
    }

    public @org.jetbrains.annotations.NotNull imports.kubernetes.ServiceAccountTimeouts getTimeouts() {
        return software.amazon.jsii.Kernel.get(this, "timeouts", software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceAccountTimeouts.class));
    }

    public void setTimeouts(final @org.jetbrains.annotations.NotNull imports.kubernetes.ServiceAccountTimeouts value) {
        software.amazon.jsii.Kernel.set(this, "timeouts", java.util.Objects.requireNonNull(value, "timeouts is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.ServiceAccount}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.ServiceAccount> {
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
        private final imports.kubernetes.ServiceAccountConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.ServiceAccountConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#metadata ServiceAccount#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.ServiceAccountMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * True to enable automatic mounting of the service account token.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#automount_service_account_token ServiceAccount#automount_service_account_token}
         * <p>
         * @return {@code this}
         * @param automountServiceAccountToken True to enable automatic mounting of the service account token. This parameter is required.
         */
        public Builder automountServiceAccountToken(final java.lang.Boolean automountServiceAccountToken) {
            this.config.automountServiceAccountToken(automountServiceAccountToken);
            return this;
        }

        /**
         * image_pull_secret block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#image_pull_secret ServiceAccount#image_pull_secret}
         * <p>
         * @return {@code this}
         * @param imagePullSecret image_pull_secret block. This parameter is required.
         */
        public Builder imagePullSecret(final java.util.List<? extends imports.kubernetes.ServiceAccountImagePullSecret> imagePullSecret) {
            this.config.imagePullSecret(imagePullSecret);
            return this;
        }

        /**
         * secret block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#secret ServiceAccount#secret}
         * <p>
         * @return {@code this}
         * @param secret secret block. This parameter is required.
         */
        public Builder secret(final java.util.List<? extends imports.kubernetes.ServiceAccountSecret> secret) {
            this.config.secret(secret);
            return this;
        }

        /**
         * timeouts block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service_account.html#timeouts ServiceAccount#timeouts}
         * <p>
         * @return {@code this}
         * @param timeouts timeouts block. This parameter is required.
         */
        public Builder timeouts(final imports.kubernetes.ServiceAccountTimeouts timeouts) {
            this.config.timeouts(timeouts);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.ServiceAccount}.
         */
        @Override
        public imports.kubernetes.ServiceAccount build() {
            return new imports.kubernetes.ServiceAccount(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
