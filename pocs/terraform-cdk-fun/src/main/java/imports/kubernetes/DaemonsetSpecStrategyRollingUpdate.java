package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.430Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DaemonsetSpecStrategyRollingUpdate")
@software.amazon.jsii.Jsii.Proxy(DaemonsetSpecStrategyRollingUpdate.Jsii$Proxy.class)
public interface DaemonsetSpecStrategyRollingUpdate extends software.amazon.jsii.JsiiSerializable {

    /**
     * The maximum number of DaemonSet pods that can be unavailable during the update.
     * <p>
     * Value can be an absolute number (ex: 5) or a percentage of total number of DaemonSet pods at the start of the update (ex: 10%). Absolute number is calculated from percentage by rounding up. This cannot be 0. Default value is 1. Example: when this is set to 30%, at most 30% of the total number of nodes that should be running the daemon pod (i.e. status.desiredNumberScheduled) can have their pods stopped for an update at any given time. The update starts by stopping at most 30% of those DaemonSet pods and then brings up new DaemonSet pods in their place. Once the new pods are available, it then proceeds onto other DaemonSet pods, thus ensuring that at least 70% of original number of DaemonSet pods are available at all times during the update.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#max_unavailable Daemonset#max_unavailable}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMaxUnavailable() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DaemonsetSpecStrategyRollingUpdate}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DaemonsetSpecStrategyRollingUpdate}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DaemonsetSpecStrategyRollingUpdate> {
        private java.lang.String maxUnavailable;

        /**
         * Sets the value of {@link DaemonsetSpecStrategyRollingUpdate#getMaxUnavailable}
         * @param maxUnavailable The maximum number of DaemonSet pods that can be unavailable during the update.
         *                       Value can be an absolute number (ex: 5) or a percentage of total number of DaemonSet pods at the start of the update (ex: 10%). Absolute number is calculated from percentage by rounding up. This cannot be 0. Default value is 1. Example: when this is set to 30%, at most 30% of the total number of nodes that should be running the daemon pod (i.e. status.desiredNumberScheduled) can have their pods stopped for an update at any given time. The update starts by stopping at most 30% of those DaemonSet pods and then brings up new DaemonSet pods in their place. Once the new pods are available, it then proceeds onto other DaemonSet pods, thus ensuring that at least 70% of original number of DaemonSet pods are available at all times during the update.
         *                       <p>
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#max_unavailable Daemonset#max_unavailable}
         * @return {@code this}
         */
        public Builder maxUnavailable(java.lang.String maxUnavailable) {
            this.maxUnavailable = maxUnavailable;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DaemonsetSpecStrategyRollingUpdate}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DaemonsetSpecStrategyRollingUpdate build() {
            return new Jsii$Proxy(maxUnavailable);
        }
    }

    /**
     * An implementation for {@link DaemonsetSpecStrategyRollingUpdate}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DaemonsetSpecStrategyRollingUpdate {
        private final java.lang.String maxUnavailable;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.maxUnavailable = software.amazon.jsii.Kernel.get(this, "maxUnavailable", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String maxUnavailable) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.maxUnavailable = maxUnavailable;
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

            if (this.getMaxUnavailable() != null) {
                data.set("maxUnavailable", om.valueToTree(this.getMaxUnavailable()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DaemonsetSpecStrategyRollingUpdate"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DaemonsetSpecStrategyRollingUpdate.Jsii$Proxy that = (DaemonsetSpecStrategyRollingUpdate.Jsii$Proxy) o;

            return this.maxUnavailable != null ? this.maxUnavailable.equals(that.maxUnavailable) : that.maxUnavailable == null;
        }

        @Override
        public final int hashCode() {
            int result = this.maxUnavailable != null ? this.maxUnavailable.hashCode() : 0;
            return result;
        }
    }
}
