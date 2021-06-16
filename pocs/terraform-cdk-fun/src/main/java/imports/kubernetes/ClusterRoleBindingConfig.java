package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.330Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ClusterRoleBindingConfig")
@software.amazon.jsii.Jsii.Proxy(ClusterRoleBindingConfig.Jsii$Proxy.class)
public interface ClusterRoleBindingConfig extends software.amazon.jsii.JsiiSerializable, com.hashicorp.cdktf.TerraformMetaArguments {

    /**
     * metadata block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#metadata ClusterRoleBinding#metadata}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> getMetadata();

    /**
     * role_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#role_ref ClusterRoleBinding#role_ref}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> getRoleRef();

    /**
     * subject block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#subject ClusterRoleBinding#subject}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ClusterRoleBindingSubject> getSubject();

    /**
     * @return a {@link Builder} of {@link ClusterRoleBindingConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ClusterRoleBindingConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ClusterRoleBindingConfig> {
        private java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> metadata;
        private java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> roleRef;
        private java.util.List<imports.kubernetes.ClusterRoleBindingSubject> subject;
        private java.lang.Number count;
        private java.util.List<com.hashicorp.cdktf.ITerraformDependable> dependsOn;
        private com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle;
        private com.hashicorp.cdktf.TerraformProvider provider;

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getMetadata}
         * @param metadata metadata block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#metadata ClusterRoleBinding#metadata}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metadata(java.util.List<? extends imports.kubernetes.ClusterRoleBindingMetadata> metadata) {
            this.metadata = (java.util.List<imports.kubernetes.ClusterRoleBindingMetadata>)metadata;
            return this;
        }

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getRoleRef}
         * @param roleRef role_ref block. This parameter is required.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#role_ref ClusterRoleBinding#role_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder roleRef(java.util.List<? extends imports.kubernetes.ClusterRoleBindingRoleRef> roleRef) {
            this.roleRef = (java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef>)roleRef;
            return this;
        }

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getSubject}
         * @param subject subject block. This parameter is required.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/cluster_role_binding.html#subject ClusterRoleBinding#subject}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder subject(java.util.List<? extends imports.kubernetes.ClusterRoleBindingSubject> subject) {
            this.subject = (java.util.List<imports.kubernetes.ClusterRoleBindingSubject>)subject;
            return this;
        }

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getCount}
         * @param count the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder count(java.lang.Number count) {
            this.count = count;
            return this;
        }

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getDependsOn}
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
         * Sets the value of {@link ClusterRoleBindingConfig#getLifecycle}
         * @param lifecycle the value to be set.
         * @return {@code this}
         */
        @software.amazon.jsii.Stability(software.amazon.jsii.Stability.Level.Experimental)
        public Builder lifecycle(com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle) {
            this.lifecycle = lifecycle;
            return this;
        }

        /**
         * Sets the value of {@link ClusterRoleBindingConfig#getProvider}
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
         * @return a new instance of {@link ClusterRoleBindingConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ClusterRoleBindingConfig build() {
            return new Jsii$Proxy(metadata, roleRef, subject, count, dependsOn, lifecycle, provider);
        }
    }

    /**
     * An implementation for {@link ClusterRoleBindingConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ClusterRoleBindingConfig {
        private final java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> metadata;
        private final java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> roleRef;
        private final java.util.List<imports.kubernetes.ClusterRoleBindingSubject> subject;
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
            this.metadata = software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingMetadata.class)));
            this.roleRef = software.amazon.jsii.Kernel.get(this, "roleRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingRoleRef.class)));
            this.subject = software.amazon.jsii.Kernel.get(this, "subject", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ClusterRoleBindingSubject.class)));
            this.count = software.amazon.jsii.Kernel.get(this, "count", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.dependsOn = software.amazon.jsii.Kernel.get(this, "dependsOn", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.ITerraformDependable.class)));
            this.lifecycle = software.amazon.jsii.Kernel.get(this, "lifecycle", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformResourceLifecycle.class));
            this.provider = software.amazon.jsii.Kernel.get(this, "provider", software.amazon.jsii.NativeType.forClass(com.hashicorp.cdktf.TerraformProvider.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.ClusterRoleBindingMetadata> metadata, final java.util.List<? extends imports.kubernetes.ClusterRoleBindingRoleRef> roleRef, final java.util.List<? extends imports.kubernetes.ClusterRoleBindingSubject> subject, final java.lang.Number count, final java.util.List<? extends com.hashicorp.cdktf.ITerraformDependable> dependsOn, final com.hashicorp.cdktf.TerraformResourceLifecycle lifecycle, final com.hashicorp.cdktf.TerraformProvider provider) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.metadata = (java.util.List<imports.kubernetes.ClusterRoleBindingMetadata>)java.util.Objects.requireNonNull(metadata, "metadata is required");
            this.roleRef = (java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef>)java.util.Objects.requireNonNull(roleRef, "roleRef is required");
            this.subject = (java.util.List<imports.kubernetes.ClusterRoleBindingSubject>)java.util.Objects.requireNonNull(subject, "subject is required");
            this.count = count;
            this.dependsOn = (java.util.List<com.hashicorp.cdktf.ITerraformDependable>)dependsOn;
            this.lifecycle = lifecycle;
            this.provider = provider;
        }

        @Override
        public final java.util.List<imports.kubernetes.ClusterRoleBindingMetadata> getMetadata() {
            return this.metadata;
        }

        @Override
        public final java.util.List<imports.kubernetes.ClusterRoleBindingRoleRef> getRoleRef() {
            return this.roleRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.ClusterRoleBindingSubject> getSubject() {
            return this.subject;
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
            data.set("roleRef", om.valueToTree(this.getRoleRef()));
            data.set("subject", om.valueToTree(this.getSubject()));
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
            struct.set("fqn", om.valueToTree("kubernetes.ClusterRoleBindingConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClusterRoleBindingConfig.Jsii$Proxy that = (ClusterRoleBindingConfig.Jsii$Proxy) o;

            if (!metadata.equals(that.metadata)) return false;
            if (!roleRef.equals(that.roleRef)) return false;
            if (!subject.equals(that.subject)) return false;
            if (this.count != null ? !this.count.equals(that.count) : that.count != null) return false;
            if (this.dependsOn != null ? !this.dependsOn.equals(that.dependsOn) : that.dependsOn != null) return false;
            if (this.lifecycle != null ? !this.lifecycle.equals(that.lifecycle) : that.lifecycle != null) return false;
            return this.provider != null ? this.provider.equals(that.provider) : that.provider == null;
        }

        @Override
        public final int hashCode() {
            int result = this.metadata.hashCode();
            result = 31 * result + (this.roleRef.hashCode());
            result = 31 * result + (this.subject.hashCode());
            result = 31 * result + (this.count != null ? this.count.hashCode() : 0);
            result = 31 * result + (this.dependsOn != null ? this.dependsOn.hashCode() : 0);
            result = 31 * result + (this.lifecycle != null ? this.lifecycle.hashCode() : 0);
            result = 31 * result + (this.provider != null ? this.provider.hashCode() : 0);
            return result;
        }
    }
}
