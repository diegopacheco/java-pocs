package imports.kubernetes;

/**
 * Represents a {@link https://www.terraform.io/docs/providers/kubernetes kubernetes}.
 */
@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.663Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.KubernetesProvider")
public class KubernetesProvider extends com.hashicorp.cdktf.TerraformProvider {

    protected KubernetesProvider(final software.amazon.jsii.JsiiObjectRef objRef) {
        super(objRef);
    }

    protected KubernetesProvider(final software.amazon.jsii.JsiiObject.InitializationMode initializationMode) {
        super(initializationMode);
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes kubernetes} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     * @param config
     */
    public KubernetesProvider(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id, final @org.jetbrains.annotations.Nullable imports.kubernetes.KubernetesProviderConfig config) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required"), config });
    }

    /**
     * Create a new {@link https://www.terraform.io/docs/providers/kubernetes kubernetes} Resource.
     * <p>
     * @param scope The scope in which to define this construct. This parameter is required.
     * @param id The scoped construct ID. This parameter is required.
     */
    public KubernetesProvider(final @org.jetbrains.annotations.NotNull software.constructs.Construct scope, final @org.jetbrains.annotations.NotNull java.lang.String id) {
        super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
        software.amazon.jsii.JsiiEngine.getInstance().createNewObject(this, new Object[] { java.util.Objects.requireNonNull(scope, "scope is required"), java.util.Objects.requireNonNull(id, "id is required") });
    }

    public void resetAlias() {
        software.amazon.jsii.Kernel.call(this, "resetAlias", software.amazon.jsii.NativeType.VOID);
    }

    public void resetClientCertificate() {
        software.amazon.jsii.Kernel.call(this, "resetClientCertificate", software.amazon.jsii.NativeType.VOID);
    }

    public void resetClientKey() {
        software.amazon.jsii.Kernel.call(this, "resetClientKey", software.amazon.jsii.NativeType.VOID);
    }

    public void resetClusterCaCertificate() {
        software.amazon.jsii.Kernel.call(this, "resetClusterCaCertificate", software.amazon.jsii.NativeType.VOID);
    }

    public void resetConfigContext() {
        software.amazon.jsii.Kernel.call(this, "resetConfigContext", software.amazon.jsii.NativeType.VOID);
    }

    public void resetConfigContextAuthInfo() {
        software.amazon.jsii.Kernel.call(this, "resetConfigContextAuthInfo", software.amazon.jsii.NativeType.VOID);
    }

    public void resetConfigContextCluster() {
        software.amazon.jsii.Kernel.call(this, "resetConfigContextCluster", software.amazon.jsii.NativeType.VOID);
    }

    public void resetConfigPath() {
        software.amazon.jsii.Kernel.call(this, "resetConfigPath", software.amazon.jsii.NativeType.VOID);
    }

    public void resetExec() {
        software.amazon.jsii.Kernel.call(this, "resetExec", software.amazon.jsii.NativeType.VOID);
    }

    public void resetHost() {
        software.amazon.jsii.Kernel.call(this, "resetHost", software.amazon.jsii.NativeType.VOID);
    }

    public void resetInsecure() {
        software.amazon.jsii.Kernel.call(this, "resetInsecure", software.amazon.jsii.NativeType.VOID);
    }

    public void resetLoadConfigFile() {
        software.amazon.jsii.Kernel.call(this, "resetLoadConfigFile", software.amazon.jsii.NativeType.VOID);
    }

    public void resetPassword() {
        software.amazon.jsii.Kernel.call(this, "resetPassword", software.amazon.jsii.NativeType.VOID);
    }

    public void resetToken() {
        software.amazon.jsii.Kernel.call(this, "resetToken", software.amazon.jsii.NativeType.VOID);
    }

    public void resetUsername() {
        software.amazon.jsii.Kernel.call(this, "resetUsername", software.amazon.jsii.NativeType.VOID);
    }

    @Override
    protected @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.Object> synthesizeAttributes() {
        return java.util.Collections.unmodifiableMap(software.amazon.jsii.Kernel.call(this, "synthesizeAttributes", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.Object.class))));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getAliasInput() {
        return software.amazon.jsii.Kernel.get(this, "aliasInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClientCertificateInput() {
        return software.amazon.jsii.Kernel.get(this, "clientCertificateInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClientKeyInput() {
        return software.amazon.jsii.Kernel.get(this, "clientKeyInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClusterCaCertificateInput() {
        return software.amazon.jsii.Kernel.get(this, "clusterCaCertificateInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContextAuthInfoInput() {
        return software.amazon.jsii.Kernel.get(this, "configContextAuthInfoInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContextClusterInput() {
        return software.amazon.jsii.Kernel.get(this, "configContextClusterInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContextInput() {
        return software.amazon.jsii.Kernel.get(this, "configContextInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigPathInput() {
        return software.amazon.jsii.Kernel.get(this, "configPathInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.KubernetesProviderExec> getExecInput() {
        return java.util.Optional.ofNullable((java.util.List<imports.kubernetes.KubernetesProviderExec>)(software.amazon.jsii.Kernel.get(this, "execInput", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.KubernetesProviderExec.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getHostInput() {
        return software.amazon.jsii.Kernel.get(this, "hostInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getInsecureInput() {
        return software.amazon.jsii.Kernel.get(this, "insecureInput", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getLoadConfigFileInput() {
        return software.amazon.jsii.Kernel.get(this, "loadConfigFileInput", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPasswordInput() {
        return software.amazon.jsii.Kernel.get(this, "passwordInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getTokenInput() {
        return software.amazon.jsii.Kernel.get(this, "tokenInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getUsernameInput() {
        return software.amazon.jsii.Kernel.get(this, "usernameInput", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    @Override
    public @org.jetbrains.annotations.Nullable java.lang.String getAlias() {
        return software.amazon.jsii.Kernel.get(this, "alias", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    @Override
    public void setAlias(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "alias", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClientCertificate() {
        return software.amazon.jsii.Kernel.get(this, "clientCertificate", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setClientCertificate(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "clientCertificate", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClientKey() {
        return software.amazon.jsii.Kernel.get(this, "clientKey", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setClientKey(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "clientKey", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getClusterCaCertificate() {
        return software.amazon.jsii.Kernel.get(this, "clusterCaCertificate", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setClusterCaCertificate(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "clusterCaCertificate", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContext() {
        return software.amazon.jsii.Kernel.get(this, "configContext", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setConfigContext(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "configContext", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContextAuthInfo() {
        return software.amazon.jsii.Kernel.get(this, "configContextAuthInfo", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setConfigContextAuthInfo(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "configContextAuthInfo", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigContextCluster() {
        return software.amazon.jsii.Kernel.get(this, "configContextCluster", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setConfigContextCluster(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "configContextCluster", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getConfigPath() {
        return software.amazon.jsii.Kernel.get(this, "configPath", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setConfigPath(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "configPath", value);
    }

    public @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.KubernetesProviderExec> getExec() {
        return java.util.Optional.ofNullable((java.util.List<imports.kubernetes.KubernetesProviderExec>)(software.amazon.jsii.Kernel.get(this, "exec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.KubernetesProviderExec.class))))).map(java.util.Collections::unmodifiableList).orElse(null);
    }

    public void setExec(final @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.KubernetesProviderExec> value) {
        software.amazon.jsii.Kernel.set(this, "exec", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getHost() {
        return software.amazon.jsii.Kernel.get(this, "host", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setHost(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "host", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getInsecure() {
        return software.amazon.jsii.Kernel.get(this, "insecure", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public void setInsecure(final @org.jetbrains.annotations.Nullable java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "insecure", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.Boolean getLoadConfigFile() {
        return software.amazon.jsii.Kernel.get(this, "loadConfigFile", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
    }

    public void setLoadConfigFile(final @org.jetbrains.annotations.Nullable java.lang.Boolean value) {
        software.amazon.jsii.Kernel.set(this, "loadConfigFile", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getPassword() {
        return software.amazon.jsii.Kernel.get(this, "password", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setPassword(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "password", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getToken() {
        return software.amazon.jsii.Kernel.get(this, "token", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setToken(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "token", value);
    }

    public @org.jetbrains.annotations.Nullable java.lang.String getUsername() {
        return software.amazon.jsii.Kernel.get(this, "username", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
    }

    public void setUsername(final @org.jetbrains.annotations.Nullable java.lang.String value) {
        software.amazon.jsii.Kernel.set(this, "username", value);
    }

    /**
     * A fluent builder for {@link imports.kubernetes.KubernetesProvider}.
     */
    public static final class Builder implements software.amazon.jsii.Builder<imports.kubernetes.KubernetesProvider> {
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
        private imports.kubernetes.KubernetesProviderConfig.Builder config;

        private Builder(final software.constructs.Construct scope, final java.lang.String id) {
            this.scope = scope;
            this.id = id;
        }

        /**
         * Alias name.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#alias KubernetesProvider#alias}
         * <p>
         * @return {@code this}
         * @param alias Alias name. This parameter is required.
         */
        public Builder alias(final java.lang.String alias) {
            this.config().alias(alias);
            return this;
        }

        /**
         * PEM-encoded client certificate for TLS authentication.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#client_certificate KubernetesProvider#client_certificate}
         * <p>
         * @return {@code this}
         * @param clientCertificate PEM-encoded client certificate for TLS authentication. This parameter is required.
         */
        public Builder clientCertificate(final java.lang.String clientCertificate) {
            this.config().clientCertificate(clientCertificate);
            return this;
        }

        /**
         * PEM-encoded client certificate key for TLS authentication.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#client_key KubernetesProvider#client_key}
         * <p>
         * @return {@code this}
         * @param clientKey PEM-encoded client certificate key for TLS authentication. This parameter is required.
         */
        public Builder clientKey(final java.lang.String clientKey) {
            this.config().clientKey(clientKey);
            return this;
        }

        /**
         * PEM-encoded root certificates bundle for TLS authentication.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#cluster_ca_certificate KubernetesProvider#cluster_ca_certificate}
         * <p>
         * @return {@code this}
         * @param clusterCaCertificate PEM-encoded root certificates bundle for TLS authentication. This parameter is required.
         */
        public Builder clusterCaCertificate(final java.lang.String clusterCaCertificate) {
            this.config().clusterCaCertificate(clusterCaCertificate);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context KubernetesProvider#config_context}.
         * <p>
         * @return {@code this}
         * @param configContext Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context KubernetesProvider#config_context}. This parameter is required.
         */
        public Builder configContext(final java.lang.String configContext) {
            this.config().configContext(configContext);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context_auth_info KubernetesProvider#config_context_auth_info}.
         * <p>
         * @return {@code this}
         * @param configContextAuthInfo Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context_auth_info KubernetesProvider#config_context_auth_info}. This parameter is required.
         */
        public Builder configContextAuthInfo(final java.lang.String configContextAuthInfo) {
            this.config().configContextAuthInfo(configContextAuthInfo);
            return this;
        }

        /**
         * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context_cluster KubernetesProvider#config_context_cluster}.
         * <p>
         * @return {@code this}
         * @param configContextCluster Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#config_context_cluster KubernetesProvider#config_context_cluster}. This parameter is required.
         */
        public Builder configContextCluster(final java.lang.String configContextCluster) {
            this.config().configContextCluster(configContextCluster);
            return this;
        }

        /**
         * Path to the kube config file, defaults to ~/.kube/config.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#config_path KubernetesProvider#config_path}
         * <p>
         * @return {@code this}
         * @param configPath Path to the kube config file, defaults to ~/.kube/config. This parameter is required.
         */
        public Builder configPath(final java.lang.String configPath) {
            this.config().configPath(configPath);
            return this;
        }

        /**
         * exec block.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#exec KubernetesProvider#exec}
         * <p>
         * @return {@code this}
         * @param exec exec block. This parameter is required.
         */
        public Builder exec(final java.util.List<? extends imports.kubernetes.KubernetesProviderExec> exec) {
            this.config().exec(exec);
            return this;
        }

        /**
         * The hostname (in form of URI) of Kubernetes master.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#host KubernetesProvider#host}
         * <p>
         * @return {@code this}
         * @param host The hostname (in form of URI) of Kubernetes master. This parameter is required.
         */
        public Builder host(final java.lang.String host) {
            this.config().host(host);
            return this;
        }

        /**
         * Whether server should be accessed without verifying the TLS certificate.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#insecure KubernetesProvider#insecure}
         * <p>
         * @return {@code this}
         * @param insecure Whether server should be accessed without verifying the TLS certificate. This parameter is required.
         */
        public Builder insecure(final java.lang.Boolean insecure) {
            this.config().insecure(insecure);
            return this;
        }

        /**
         * Load local kubeconfig.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#load_config_file KubernetesProvider#load_config_file}
         * <p>
         * @return {@code this}
         * @param loadConfigFile Load local kubeconfig. This parameter is required.
         */
        public Builder loadConfigFile(final java.lang.Boolean loadConfigFile) {
            this.config().loadConfigFile(loadConfigFile);
            return this;
        }

        /**
         * The password to use for HTTP basic authentication when accessing the Kubernetes master endpoint.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#password KubernetesProvider#password}
         * <p>
         * @return {@code this}
         * @param password The password to use for HTTP basic authentication when accessing the Kubernetes master endpoint. This parameter is required.
         */
        public Builder password(final java.lang.String password) {
            this.config().password(password);
            return this;
        }

        /**
         * Token to authenticate an service account.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#token KubernetesProvider#token}
         * <p>
         * @return {@code this}
         * @param token Token to authenticate an service account. This parameter is required.
         */
        public Builder token(final java.lang.String token) {
            this.config().token(token);
            return this;
        }

        /**
         * The username to use for HTTP basic authentication when accessing the Kubernetes master endpoint.
         * <p>
         * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes#username KubernetesProvider#username}
         * <p>
         * @return {@code this}
         * @param username The username to use for HTTP basic authentication when accessing the Kubernetes master endpoint. This parameter is required.
         */
        public Builder username(final java.lang.String username) {
            this.config().username(username);
            return this;
        }

        /**
         * @returns a newly built instance of {@link imports.kubernetes.KubernetesProvider}.
         */
        @Override
        public imports.kubernetes.KubernetesProvider build() {
            return new imports.kubernetes.KubernetesProvider(
                this.scope,
                this.id,
                this.config != null ? this.config.build() : null
            );
        }

        private imports.kubernetes.KubernetesProviderConfig.Builder config() {
            if (this.config == null) {
                this.config = new imports.kubernetes.KubernetesProviderConfig.Builder();
            }
            return this.config;
        }
    }
}
