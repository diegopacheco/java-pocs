package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.539Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DeploymentSpecStrategyRollingUpdate")
@software.amazon.jsii.Jsii.Proxy(DeploymentSpecStrategyRollingUpdate.Jsii$Proxy.class)
public interface DeploymentSpecStrategyRollingUpdate extends software.amazon.jsii.JsiiSerializable {

    /**
     * The maximum number of pods that can be scheduled above the desired number of pods.
     * <p>
     * Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%). This can not be 0 if MaxUnavailable is 0. Absolute number is calculated from percentage by rounding up. Defaults to 25%. Example: when this is set to 30%, the new RC can be scaled up immediately when the rolling update starts, such that the total number of old and new pods do not exceed 130% of desired pods. Once old pods have been killed, new RC can be scaled up further, ensuring that total number of pods running at any time during the update is atmost 130% of desired pods.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#max_surge Deployment#max_surge}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMaxSurge() {
        return null;
    }

    /**
     * The maximum number of pods that can be unavailable during the update.
     * <p>
     * Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%). Absolute number is calculated from percentage by rounding down. This can not be 0 if MaxSurge is 0. Defaults to 25%. Example: when this is set to 30%, the old RC can be scaled down to 70% of desired pods immediately when the rolling update starts. Once new pods are ready, old RC can be scaled down further, followed by scaling up the new RC, ensuring that the total number of pods available at all times during the update is at least 70% of desired pods.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#max_unavailable Deployment#max_unavailable}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMaxUnavailable() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DeploymentSpecStrategyRollingUpdate}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DeploymentSpecStrategyRollingUpdate}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DeploymentSpecStrategyRollingUpdate> {
        private java.lang.String maxSurge;
        private java.lang.String maxUnavailable;

        /**
         * Sets the value of {@link DeploymentSpecStrategyRollingUpdate#getMaxSurge}
         * @param maxSurge The maximum number of pods that can be scheduled above the desired number of pods.
         *                 Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%). This can not be 0 if MaxUnavailable is 0. Absolute number is calculated from percentage by rounding up. Defaults to 25%. Example: when this is set to 30%, the new RC can be scaled up immediately when the rolling update starts, such that the total number of old and new pods do not exceed 130% of desired pods. Once old pods have been killed, new RC can be scaled up further, ensuring that total number of pods running at any time during the update is atmost 130% of desired pods.
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#max_surge Deployment#max_surge}
         * @return {@code this}
         */
        public Builder maxSurge(java.lang.String maxSurge) {
            this.maxSurge = maxSurge;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpecStrategyRollingUpdate#getMaxUnavailable}
         * @param maxUnavailable The maximum number of pods that can be unavailable during the update.
         *                       Value can be an absolute number (ex: 5) or a percentage of desired pods (ex: 10%). Absolute number is calculated from percentage by rounding down. This can not be 0 if MaxSurge is 0. Defaults to 25%. Example: when this is set to 30%, the old RC can be scaled down to 70% of desired pods immediately when the rolling update starts. Once new pods are ready, old RC can be scaled down further, followed by scaling up the new RC, ensuring that the total number of pods available at all times during the update is at least 70% of desired pods.
         *                       <p>
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#max_unavailable Deployment#max_unavailable}
         * @return {@code this}
         */
        public Builder maxUnavailable(java.lang.String maxUnavailable) {
            this.maxUnavailable = maxUnavailable;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DeploymentSpecStrategyRollingUpdate}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DeploymentSpecStrategyRollingUpdate build() {
            return new Jsii$Proxy(maxSurge, maxUnavailable);
        }
    }

    /**
     * An implementation for {@link DeploymentSpecStrategyRollingUpdate}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DeploymentSpecStrategyRollingUpdate {
        private final java.lang.String maxSurge;
        private final java.lang.String maxUnavailable;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.maxSurge = software.amazon.jsii.Kernel.get(this, "maxSurge", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.maxUnavailable = software.amazon.jsii.Kernel.get(this, "maxUnavailable", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String maxSurge, final java.lang.String maxUnavailable) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.maxSurge = maxSurge;
            this.maxUnavailable = maxUnavailable;
        }

        @Override
        public final java.lang.String getMaxSurge() {
            return this.maxSurge;
        }

        @Override
        public final java.lang.String getMaxUnavailable() {
            return this.maxUnavailable;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getMaxSurge() != null) {
                data.set("maxSurge", om.valueToTree(this.getMaxSurge()));
            }
            if (this.getMaxUnavailable() != null) {
                data.set("maxUnavailable", om.valueToTree(this.getMaxUnavailable()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DeploymentSpecStrategyRollingUpdate"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DeploymentSpecStrategyRollingUpdate.Jsii$Proxy that = (DeploymentSpecStrategyRollingUpdate.Jsii$Proxy) o;

            if (this.maxSurge != null ? !this.maxSurge.equals(that.maxSurge) : that.maxSurge != null) return false;
            return this.maxUnavailable != null ? this.maxUnavailable.equals(that.maxUnavailable) : that.maxUnavailable == null;
        }

        @Override
        public final int hashCode() {
            int result = this.maxSurge != null ? this.maxSurge.hashCode() : 0;
            result = 31 * result + (this.maxUnavailable != null ? this.maxUnavailable.hashCode() : 0);
            return result;
        }
    }
}
