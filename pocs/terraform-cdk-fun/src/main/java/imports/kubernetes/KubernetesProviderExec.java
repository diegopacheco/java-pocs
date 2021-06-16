package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.664Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.KubernetesProviderExec")
@software.amazon.jsii.Jsii.Proxy(KubernetesProviderExec.Jsii$Proxy.class)
public interface KubernetesProviderExec extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#api_version KubernetesProvider#api_version}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getApiVersion();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#command KubernetesProvider#command}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getCommand();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#args KubernetesProvider#args}.
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getArgs() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#env KubernetesProvider#env}.
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getEnv() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link KubernetesProviderExec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link KubernetesProviderExec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<KubernetesProviderExec> {
        private java.lang.String apiVersion;
        private java.lang.String command;
        private java.util.List<java.lang.String> args;
        private java.util.Map<java.lang.String, java.lang.String> env;

        /**
         * Sets the value of {@link KubernetesProviderExec#getApiVersion}
         * @param apiVersion Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#api_version KubernetesProvider#api_version}. This parameter is required.
         * @return {@code this}
         */
        public Builder apiVersion(java.lang.String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        /**
         * Sets the value of {@link KubernetesProviderExec#getCommand}
         * @param command Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#command KubernetesProvider#command}. This parameter is required.
         * @return {@code this}
         */
        public Builder command(java.lang.String command) {
            this.command = command;
            return this;
        }

        /**
         * Sets the value of {@link KubernetesProviderExec#getArgs}
         * @param args Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#args KubernetesProvider#args}.
         * @return {@code this}
         */
        public Builder args(java.util.List<java.lang.String> args) {
            this.args = args;
            return this;
        }

        /**
         * Sets the value of {@link KubernetesProviderExec#getEnv}
         * @param env Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes#env KubernetesProvider#env}.
         * @return {@code this}
         */
        public Builder env(java.util.Map<java.lang.String, java.lang.String> env) {
            this.env = env;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link KubernetesProviderExec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public KubernetesProviderExec build() {
            return new Jsii$Proxy(apiVersion, command, args, env);
        }
    }

    /**
     * An implementation for {@link KubernetesProviderExec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements KubernetesProviderExec {
        private final java.lang.String apiVersion;
        private final java.lang.String command;
        private final java.util.List<java.lang.String> args;
        private final java.util.Map<java.lang.String, java.lang.String> env;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.apiVersion = software.amazon.jsii.Kernel.get(this, "apiVersion", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.command = software.amazon.jsii.Kernel.get(this, "command", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.args = software.amazon.jsii.Kernel.get(this, "args", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.env = software.amazon.jsii.Kernel.get(this, "env", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String apiVersion, final java.lang.String command, final java.util.List<java.lang.String> args, final java.util.Map<java.lang.String, java.lang.String> env) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.apiVersion = java.util.Objects.requireNonNull(apiVersion, "apiVersion is required");
            this.command = java.util.Objects.requireNonNull(command, "command is required");
            this.args = args;
            this.env = env;
        }

        @Override
        public final java.lang.String getApiVersion() {
            return this.apiVersion;
        }

        @Override
        public final java.lang.String getCommand() {
            return this.command;
        }

        @Override
        public final java.util.List<java.lang.String> getArgs() {
            return this.args;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getEnv() {
            return this.env;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("apiVersion", om.valueToTree(this.getApiVersion()));
            data.set("command", om.valueToTree(this.getCommand()));
            if (this.getArgs() != null) {
                data.set("args", om.valueToTree(this.getArgs()));
            }
            if (this.getEnv() != null) {
                data.set("env", om.valueToTree(this.getEnv()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.KubernetesProviderExec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KubernetesProviderExec.Jsii$Proxy that = (KubernetesProviderExec.Jsii$Proxy) o;

            if (!apiVersion.equals(that.apiVersion)) return false;
            if (!command.equals(that.command)) return false;
            if (this.args != null ? !this.args.equals(that.args) : that.args != null) return false;
            return this.env != null ? this.env.equals(that.env) : that.env == null;
        }

        @Override
        public final int hashCode() {
            int result = this.apiVersion.hashCode();
            result = 31 * result + (this.command.hashCode());
            result = 31 * result + (this.args != null ? this.args.hashCode() : 0);
            result = 31 * result + (this.env != null ? this.env.hashCode() : 0);
            return result;
        }
    }
}
