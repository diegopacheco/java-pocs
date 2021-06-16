package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html kubernetes_ingress}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.604Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.Ingress")
public class Ingress extends com.hashicorp.cdktf.TerraformResource {

    protected Ingress(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected Ingress(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html kubernetes_ingress} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config This parameter is required.
     */
    public Ingress(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.NotNull imports.kubernetes.IngressConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), java.util.Objects.requireNonNull(config, "config is required") });
    }

    public @org.jetbrains.annotations.NotNull imports.kubernetes.IngressLoadBalancerIngress loadBalancerIngress(final @org.jetbrains.annotations.NotNull java.lang.String index) {
        return software.amazon.jsii.Kernel.call(this, "loadBalancerIngress", software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressLoadBalancerIngress.class), new Object[] { java.util.Objects.requireNonNull(index, "index is required") });
    }

    public void resetWaitForLoadBalancer() {
        software.amazon.jsii.Kernel.call(this, "resetWaitForLoadBalancer", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.NotNull java.lang.String getId() {
        return software.amazon.jsii.Kernel.get(this, "id", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressMetadata> getMetadataInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadataInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressMetadata.class))));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressSpec> getSpecInput() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "specInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpec.class))));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getWaitForLoadBalancerInput() {
        return software.amazon.jsii.Kernel.get(this, "waitForLoadBalancerInput", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressMetadata> getMetadata() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "metadata", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressMetadata.class))));
    }

    public void setMetadata(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressMetadata> value) {
        software.amazon.jsii.Kernel.set(this, "metadata", java.util.Objects.requireNonNull(value, "metadata is required"));
    }

    public @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressSpec> getSpec() {
        return java.util.Collections.unmodifiableList(software.amazon.jsii.Kernel.get(this, "spec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.IngressSpec.class))));
    }

    public void setSpec(final @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.IngressSpec> value) {
        software.amazon.jsii.Kernel.set(this, "spec", java.util.Objects.requireNonNull(value, "spec is required"));
    }

    public @org.jetbrains.annotations.NotNull java.lang.Boolean getWaitForLoadBalancer() {
        return software.amazon.jsii.Kernel.get(this, "waitForLoadBalancer", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public void setWaitForLoadBalancer(final @org.jetbrains.annotations.NotNull java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "waitForLoadBalancer", java.util.Objects.requireNonNull(value, "waitForLoadBalancer is required"));
    }

    /**
     * A fluent builder for {@link imports.kubernetes.Ingress}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.Ingress> {
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
        private final imports.kubernetes.IngressConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
            this.config = new imports.kubernetes.IngressConfig.Builder();
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
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#metadata Ingress#metadata}
         * <p>
         * @return {@code this}
         * @param metadata metadata block. This parameter is required.
         */
        public Builder metadata(final java.util.List<? extends imports.kubernetes.IngressMetadata> metadata) {
            this.config.metadata(metadata);
            return this;
        }

        /**
         * spec block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#spec Ingress#spec}
         * <p>
         * @return {@code this}
         * @param spec spec block. This parameter is required.
         */
        public Builder spec(final java.util.List<? extends imports.kubernetes.IngressSpec> spec) {
            this.config.spec(spec);
            return this;
        }

        /**
         * Terraform will wait for the load balancer to have at least 1 endpoint before considering the resource created.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/ingress.html#wait_for_load_balancer Ingress#wait_for_load_balancer}
         * <p>
         * @return {@code this}
         * @param waitForLoadBalancer Terraform will wait for the load balancer to have at least 1 endpoint before considering the resource created. This parameter is required.
         */
        public Builder waitForLoadBalancer(final java.lang.Boolean waitForLoadBalancer) {
            this.config.waitForLoadBalancer(waitForLoadBalancer);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.Ingress}.
         */
        @Override
        public imports.kubernetes.Ingress build() {
            return new imports.kubernetes.Ingress(
                this.scope,
                this.id,
                this.config.build()
            );
        }
    }
}
