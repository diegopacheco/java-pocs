package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html kubernetes_cluster_role_binding}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.329Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ClusterRoleBinding")
public class ClusterRoleBinding extends com.hashicorp.cdktf.TerraformResource {

    protected ClusterRoleBinding(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected ClusterRoleBinding(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html kubernetes_cluster_role_binding} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public ClusterRoleBinding(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.ClusterRoleBindingConfig config) {
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

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> getRoleRefInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "roleRefInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingRoleRef.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingSubject> getSubjectInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "subjectInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingSubject.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> getRoleRef() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "roleRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingRoleRef.class))));
    }

    public void setRoleRef(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> value) {
        software.amazon.jsii.Kernel.set(this, "roleRef", java.util.Objects.requireNonNull(value, "roleRef is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingSubject> getSubject() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "subject", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingSubject.class))));
    }

    public void setSubject(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingSubject> value) {
        software.amazon.jsii.Kernel.set(this, "subject", java.util.Objects.requireNonNull(value, "subject is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.ClusterRoleBinding}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.ClusterRoleBinding> {
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
        private final imports.kubernetes.ClusterRoleBindingConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.ClusterRoleBindingConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#metadata ClusterRoleBinding#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.ClusterRoleBindingMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * role_ref block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#role_ref ClusterRoleBinding#role_ref}
         * <p>
         * @return {@code this}
         * @param roleRef role_ref block. This parameter is required.
         */
        public Builder roleRef(final java.util.List<? extends imports.kubernetes.ClusterRoleBindingRoleRef> roleRef) {
            this.config.roleRef(roleRef);
            return this;
        }

        /**
         * subject block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#subject ClusterRoleBinding#subject}
         * <p>
         * @return {@code this}
         * @param subject subject block. This parameter is required.
         */
        public Builder subject(final java.util.List<? extends imports.kubernetes.ClusterRoleBindingSubject> subject) {
            this.config.subject(subject);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.ClusterRoleBinding}.
         */
        @Override
        public imports.kubernetes.ClusterRoleBinding build() {
            return new imports.kubernetes.ClusterRoleBinding(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
