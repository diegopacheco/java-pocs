package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/role_binding.html kubernetes_role_binding}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.876Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.RoleBinding")
public class RoleBinding extends com.hashicorp.cdktf.TerraformResource {

    protected RoleBinding(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected RoleBinding(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/role_binding.html kubernetes_role_binding} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public RoleBinding(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.RoleBindingConfig config) {
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

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingRoleRef> getRoleRefInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "roleRefInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingRoleRef.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingSubject> getSubjectInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "subjectInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingSubject.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingRoleRef> getRoleRef() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "roleRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingRoleRef.class))));
    }

    public void setRoleRef(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingRoleRef> value) {
        software.amazon.jsii.Kernel.set(this, "roleRef", java.util.Objects.requireNonNull(value, "roleRef is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingSubject> getSubject() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "subject", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.RoleBindingSubject.class))));
    }

    public void setSubject(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.RoleBindingSubject> value) {
        software.amazon.jsii.Kernel.set(this, "subject", java.util.Objects.requireNonNull(value, "subject is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.RoleBinding}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.RoleBinding> {
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
        private final imports.kubernetes.RoleBindingConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.RoleBindingConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role_binding.html#metadata RoleBinding#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.RoleBindingMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * role_ref block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role_binding.html#role_ref RoleBinding#role_ref}
         * <p>
         * @return {@code this}
         * @param roleRef role_ref block. This parameter is required.
         */
        public Builder roleRef(final java.util.List<? extends imports.kubernetes.RoleBindingRoleRef> roleRef) {
            this.config.roleRef(roleRef);
            return this;
        }

        /**
         * subject block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/role_binding.html#subject RoleBinding#subject}
         * <p>
         * @return {@code this}
         * @param subject subject block. This parameter is required.
         */
        public Builder subject(final java.util.List<? extends imports.kubernetes.RoleBindingSubject> subject) {
            this.config.subject(subject);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.RoleBinding}.
         */
        @Override
        public imports.kubernetes.RoleBinding build() {
            return new imports.kubernetes.RoleBinding(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
