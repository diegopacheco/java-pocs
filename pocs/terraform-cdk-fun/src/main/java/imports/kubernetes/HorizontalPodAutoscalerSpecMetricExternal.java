package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.596Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.HorizontalPodAutoscalerSpecMetricExternal")
@software.amazon.jsii.Jsii.Proxy(HorizontalPodAutoscalerSpecMetricExternal.Jsii$Proxy.class)
public interface HorizontalPodAutoscalerSpecMetricExternal extends software.amazon.jsii.JsiiSerializable {

    /**
     * metric block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#metric HorizontalPodAutoscaler#metric}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> getMetric();

    /**
     * target block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target HorizontalPodAutoscaler#target}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> getTarget() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HorizontalPodAutoscalerSpecMetricExternal}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HorizontalPodAutoscalerSpecMetricExternal}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HorizontalPodAutoscalerSpecMetricExternal> {
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> metric;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> target;

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternal#getMetric}
         * @param metric metric block. This parameter is required.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#metric HorizontalPodAutoscaler#metric}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metric(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> metric) {
            this.metric = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric>)metric;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternal#getTarget}
         * @param target target block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target HorizontalPodAutoscaler#target}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder target(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> target) {
            this.target = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget>)target;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HorizontalPodAutoscalerSpecMetricExternal}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HorizontalPodAutoscalerSpecMetricExternal build() {
            return new Jsii$Proxy(metric, target);
        }
    }

    /**
     * An implementation for {@link HorizontalPodAutoscalerSpecMetricExternal}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HorizontalPodAutoscalerSpecMetricExternal {
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> metric;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> target;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.metric = software.amazon.jsii.Kernel.get(this, "metric", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric.class)));
            this.target = software.amazon.jsii.Kernel.get(this, "target", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> metric, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> target) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.metric = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric>)java.util.Objects.requireNonNull(metric, "metric is required");
            this.target = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget>)target;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalMetric> getMetric() {
            return this.metric;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget> getTarget() {
            return this.target;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("metric", om.valueToTree(this.getMetric()));
            if (this.getTarget() != null) {
                data.set("target", om.valueToTree(this.getTarget()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.HorizontalPodAutoscalerSpecMetricExternal"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HorizontalPodAutoscalerSpecMetricExternal.Jsii$Proxy that = (HorizontalPodAutoscalerSpecMetricExternal.Jsii$Proxy) o;

            if (!metric.equals(that.metric)) return false;
            return this.target != null ? this.target.equals(that.target) : that.target == null;
        }

        @Override
        public final int hashCode() {
            int result = this.metric.hashCode();
            result = 31 * result + (this.target != null ? this.target.hashCode() : 0);
            return result;
        }
    }
}
