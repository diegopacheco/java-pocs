package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role.html kubernetes_cluster_role}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.329Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ClusterRole")
public class ClusterRole extends com.hashicorp.cdktf.TerraformResource {

    protected ClusterRole(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected ClusterRole(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role.html kubernetes_cluster_role} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public ClusterRole(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.ClusterRoleConfig config) {
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

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleRule> getRuleInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "ruleInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleRule.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleRule> getRule() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "rule", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleRule.class))));
    }

    public void setRule(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleRule> value) {
        software.amazon.jsii.Kernel.set(this, "rule", java.util.Objects.requireNonNull(value, "rule is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.ClusterRole}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.ClusterRole> {
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
        private final imports.kubernetes.ClusterRoleConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.ClusterRoleConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role.html#metadata ClusterRole#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.ClusterRoleMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * rule block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role.html#rule ClusterRole#rule}
         * <p>
         * @return {@code this}
         * @param rule rule block. This parameter is required.
         */
        public Builder rule(final java.util.List<? extends imports.kubernetes.ClusterRoleRule> rule) {
            this.config.rule(rule);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.ClusterRole}.
         */
        @Override
        public imports.kubernetes.ClusterRole build() {
            return new imports.kubernetes.ClusterRole(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
