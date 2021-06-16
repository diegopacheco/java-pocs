package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html kubernetes_persistent_volume_claim}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.680Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PersistentVolumeClaim")
public class PersistentVolumeClaim extends com.hashicorp.cdktf.TerraformResource {

    protected PersistentVolumeClaim(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected PersistentVolumeClaim(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html kubernetes_persistent_volume_claim} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public PersistentVolumeClaim(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.PersistentVolumeClaimConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    public void resetTimeouts() {
        software.amazon.jsii.Kernel.call(this, "resetTimeouts", software.amazon.jsii.NativeType.VOID);
    }

    public void resetWaitUntilBound() {
        software.amazon.jsii.Kernel.call(this, "resetWaitUntilBound", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimSpec> getSpecInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "specInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimSpec.class))));
    }

    public @org.jetbrains.annotations.Nullable imports.kubernetes.PersistentVolumeClaimTimeouts getTimeoutsInput() {
        return software.amazon.jsii.Kernel.get(this, "timeoutsInput", software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimTimeouts.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getWaitUntilBoundInput() {
        return software.amazon.jsii.Kernel.get(this, "waitUntilBoundInput", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimSpec> getSpec() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "spec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimSpec.class))));
    }

    public void setSpec(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PersistentVolumeClaimSpec> value) {
        software.amazon.jsii.Kernel.set(this, "spec", java.util.Objects.requireNonNull(value, "spec is required"));
    }

    public @org.jetbrains.annotations.NotNull imports.kubernetes.PersistentVolumeClaimTimeouts getTimeouts() {
        return software.amazon.jsii.Kernel.get(this, "timeouts", software.amazon.jsii.NativeType.forClass(imports.kubernetes.PersistentVolumeClaimTimeouts.class));
    }

    public void setTimeouts(final @org.jetbrains.annotations.NotNull imports.kubernetes.PersistentVolumeClaimTimeouts value) {
        software.amazon.jsii.Kernel.set(this, "timeouts", java.util.Objects.requireNonNull(value, "timeouts is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Boolean getWaitUntilBound() {
        return software.amazon.jsii.Kernel.get(this, "waitUntilBound", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public void setWaitUntilBound(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "waitUntilBound", java.util.Objects.requireNonNull(value, "waitUntilBound is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.PersistentVolumeClaim}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.PersistentVolumeClaim> {
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
        private final imports.kubernetes.PersistentVolumeClaimConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.PersistentVolumeClaimConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html#metadata PersistentVolumeClaim#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.PersistentVolumeClaimMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * spec block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html#spec PersistentVolumeClaim#spec}
         * <p>
         * @return {@code this}
         * @param spec spec block. This parameter is required.
         */
        public Builder spec(final java.util.List<? extends imports.kubernetes.PersistentVolumeClaimSpec> spec) {
            this.config.spec(spec);
            return this;
        }

        /**
         * timeouts block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html#timeouts PersistentVolumeClaim#timeouts}
         * <p>
         * @return {@code this}
         * @param timeouts timeouts block. This parameter is required.
         */
        public Builder timeouts(final imports.kubernetes.PersistentVolumeClaimTimeouts timeouts) {
            this.config.timeouts(timeouts);
            return this;
        }

        /**
         * Whether to wait for the claim to reach `Bound` state (to find volume in which to claim the space).
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/persistent_volume_claim.html#wait_until_bound PersistentVolumeClaim#wait_until_bound}
         * <p>
         * @return {@code this}
         * @param waitUntilBound Whether to wait for the claim to reach `Bound` state (to find volume in which to claim the space). This parameter is required.
         */
        public Builder waitUntilBound(final java.lang.Boolean waitUntilBound) {
            this.config.waitUntilBound(waitUntilBound);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.PersistentVolumeClaim}.
         */
        @Override
        public imports.kubernetes.PersistentVolumeClaim build() {
            return new imports.kubernetes.PersistentVolumeClaim(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
