package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html kubernetes_endpoints}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.593Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.Endpoints")
public class Endpoints extends com.hashicorp.cdktf.TerraformResource {

    protected Endpoints(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected Endpoints(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html kubernetes_endpoints} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public Endpoints(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.EndpointsConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    public void resetSubset() {
        software.amazon.jsii.Kernel.call(this, "resetSubset", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.EndpointsMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsMetadata.class))));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.EndpointsSubset> getSubsetInput() {
        return java.util.Optional.ofNullable((java.util.List<imports.kubernetes.EndpointsSubset>)(software.amazon.jsii.Kernel.get(this, "subsetInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsSubset.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.EndpointsMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.EndpointsMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.EndpointsSubset> getSubset() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "subset", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.EndpointsSubset.class))));
    }

    public void setSubset(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.EndpointsSubset> value) {
        software.amazon.jsii.Kernel.set(this, "subset", java.util.Objects.requireNonNull(value, "subset is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.Endpoints}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.Endpoints> {
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
        private final imports.kubernetes.EndpointsConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.EndpointsConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#metadata Endpoints#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.EndpointsMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * subset block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/endpoints.html#subset Endpoints#subset}
         * <p>
         * @return {@code this}
         * @param subset subset block. This parameter is required.
         */
        public Builder subset(final java.util.List<? extends imports.kubernetes.EndpointsSubset> subset) {
            this.config.subset(subset);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.Endpoints}.
         */
        @Override
        public imports.kubernetes.Endpoints build() {
            return new imports.kubernetes.Endpoints(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
