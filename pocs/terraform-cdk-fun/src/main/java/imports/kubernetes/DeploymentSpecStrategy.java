package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.539Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DeploymentSpecStrategy")
@software.amazon.jsii.Jsii.Proxy(DeploymentSpecStrategy.Jsii$Proxy.class)
public interface DeploymentSpecStrategy extends software.amazon.jsii.JsiiSerializable {

    /**
     * rolling_update block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#rolling_update Deployment#rolling_update}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate> getRollingUpdate() {
        return null;
    }

    /**
     * Type of deployment. Can be 'Recreate' or 'RollingUpdate'. Default is RollingUpdate.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#type Deployment#type}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getType() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DeploymentSpecStrategy}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DeploymentSpecStrategy}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DeploymentSpecStrategy> {
        private java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate> rollingUpdate;
        private java.lang.String type;

        /**
         * Sets the value of {@link DeploymentSpecStrategy#getRollingUpdate}
         * @param rollingUpdate rolling_update block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#rolling_update Deployment#rolling_update}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rollingUpdate(java.util.List<? extends imports.kubernetes.DeploymentSpecStrategyRollingUpdate> rollingUpdate) {
            this.rollingUpdate = (java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate>)rollingUpdate;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecStrategy#getType}
         * @param type Type of deployment. Can be 'Recreate' or 'RollingUpdate'. Default is RollingUpdate.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#type Deployment#type}
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DeploymentSpecStrategy}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DeploymentSpecStrategy build() {
            return new Jsii$Proxy(rollingUpdate, type);
        }
    }

    /**
     * An implementation for {@link DeploymentSpecStrategy}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DeploymentSpecStrategy {
        private final java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate> rollingUpdate;
        private final java.lang.String type;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.rollingUpdate = software.amazon.jsii.Kernel.get(this, "rollingUpdate", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecStrategyRollingUpdate.class)));
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DeploymentSpecStrategyRollingUpdate> rollingUpdate, final java.lang.String type) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.rollingUpdate = (java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate>)rollingUpdate;
            this.type = type;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecStrategyRollingUpdate> getRollingUpdate() {
            return this.rollingUpdate;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getRollingUpdate() != null) {
                data.set("rollingUpdate", om.valueToTree(this.getRollingUpdate()));
            }
            if (this.getType() != null) {
                data.set("type", om.valueToTree(this.getType()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DeploymentSpecStrategy"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DeploymentSpecStrategy.Jsii$Proxy that = (DeploymentSpecStrategy.Jsii$Proxy) o;

            if (this.rollingUpdate != null ? !this.rollingUpdate.equals(that.rollingUpdate) : that.rollingUpdate != null) return false;
            return this.type != null ? this.type.equals(that.type) : that.type == null;
        }

        @Override
        public final int hashCode() {
            int result = this.rollingUpdate != null ? this.rollingUpdate.hashCode() : 0;
            result = 31 * result + (this.type != null ? this.type.hashCode() : 0);
            return result;
        }
    }
}
