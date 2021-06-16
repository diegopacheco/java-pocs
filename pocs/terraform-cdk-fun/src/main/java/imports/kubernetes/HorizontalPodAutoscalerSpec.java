package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.595Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.HorizontalPodAutoscalerSpec")
@software.amazon.jsii.Jsii.Proxy(HorizontalPodAutoscalerSpec.Jsii$Proxy.class)
public interface HorizontalPodAutoscalerSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * Upper limit for the number of pods that can be set by the autoscaler.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#max_replicas HorizontalPodAutoscaler#max_replicas}
     */
    @org.jetbrains.annotations.NotNull java.lang.Number getMaxReplicas();

    /**
     * scale_target_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#scale_target_ref HorizontalPodAutoscaler#scale_target_ref}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> getScaleTargetRef();

    /**
     * metric block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#metric HorizontalPodAutoscaler#metric}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric> getMetric() {
        return null;
    }

    /**
     * Lower limit for the number of pods that can be set by the autoscaler, defaults to `1`.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#min_replicas HorizontalPodAutoscaler#min_replicas}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getMinReplicas() {
        return null;
    }

    /**
     * Target average CPU utilization (represented as a percentage of requested CPU) over all the pods.
     * <p>
     * If not specified the default autoscaling policy will be used.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target_cpu_utilization_percentage HorizontalPodAutoscaler#target_cpu_utilization_percentage}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getTargetCpuUtilizationPercentage() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HorizontalPodAutoscalerSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HorizontalPodAutoscalerSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HorizontalPodAutoscalerSpec> {
        private java.lang.Number maxReplicas;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> scaleTargetRef;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric> metric;
        private java.lang.Number minReplicas;
        private java.lang.Number targetCpuUtilizationPercentage;

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpec#getMaxReplicas}
         * @param maxReplicas Upper limit for the number of pods that can be set by the autoscaler. This parameter is required.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#max_replicas HorizontalPodAutoscaler#max_replicas}
         * @return {@code this}
         */
        public Builder maxReplicas(java.lang.Number maxReplicas) {
            this.maxReplicas = maxReplicas;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpec#getScaleTargetRef}
         * @param scaleTargetRef scale_target_ref block. This parameter is required.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#scale_target_ref HorizontalPodAutoscaler#scale_target_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder scaleTargetRef(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> scaleTargetRef) {
            this.scaleTargetRef = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef>)scaleTargetRef;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpec#getMetric}
         * @param metric metric block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#metric HorizontalPodAutoscaler#metric}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder metric(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetric> metric) {
            this.metric = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric>)metric;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpec#getMinReplicas}
         * @param minReplicas Lower limit for the number of pods that can be set by the autoscaler, defaults to `1`.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#min_replicas HorizontalPodAutoscaler#min_replicas}
         * @return {@code this}
         */
        public Builder minReplicas(java.lang.Number minReplicas) {
            this.minReplicas = minReplicas;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpec#getTargetCpuUtilizationPercentage}
         * @param targetCpuUtilizationPercentage Target average CPU utilization (represented as a percentage of requested CPU) over all the pods.
         *                                       If not specified the default autoscaling policy will be used.
         *                                       <p>
         *                                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target_cpu_utilization_percentage HorizontalPodAutoscaler#target_cpu_utilization_percentage}
         * @return {@code this}
         */
        public Builder targetCpuUtilizationPercentage(java.lang.Number targetCpuUtilizationPercentage) {
            this.targetCpuUtilizationPercentage = targetCpuUtilizationPercentage;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HorizontalPodAutoscalerSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HorizontalPodAutoscalerSpec build() {
            return new Jsii$Proxy(maxReplicas, scaleTargetRef, metric, minReplicas, targetCpuUtilizationPercentage);
        }
    }

    /**
     * An implementation for {@link HorizontalPodAutoscalerSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HorizontalPodAutoscalerSpec {
        private final java.lang.Number maxReplicas;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> scaleTargetRef;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric> metric;
        private final java.lang.Number minReplicas;
        private final java.lang.Number targetCpuUtilizationPercentage;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.maxReplicas = software.amazon.jsii.Kernel.get(this, "maxReplicas", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.scaleTargetRef = software.amazon.jsii.Kernel.get(this, "scaleTargetRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef.class)));
            this.metric = software.amazon.jsii.Kernel.get(this, "metric", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetric.class)));
            this.minReplicas = software.amazon.jsii.Kernel.get(this, "minReplicas", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.targetCpuUtilizationPercentage = software.amazon.jsii.Kernel.get(this, "targetCpuUtilizationPercentage", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.Number maxReplicas, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> scaleTargetRef, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetric> metric, final java.lang.Number minReplicas, final java.lang.Number targetCpuUtilizationPercentage) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.maxReplicas = java.util.Objects.requireNonNull(maxReplicas, "maxReplicas is required");
            this.scaleTargetRef = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef>)java.util.Objects.requireNonNull(scaleTargetRef, "scaleTargetRef is required");
            this.metric = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric>)metric;
            this.minReplicas = minReplicas;
            this.targetCpuUtilizationPercentage = targetCpuUtilizationPercentage;
        }

        @Override
        public final java.lang.Number getMaxReplicas() {
            return this.maxReplicas;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecScaleTargetRef> getScaleTargetRef() {
            return this.scaleTargetRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetric> getMetric() {
            return this.metric;
        }

        @Override
        public final java.lang.Number getMinReplicas() {
            return this.minReplicas;
        }

        @Override
        public final java.lang.Number getTargetCpuUtilizationPercentage() {
            return this.targetCpuUtilizationPercentage;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("maxReplicas", om.valueToTree(this.getMaxReplicas()));
            data.set("scaleTargetRef", om.valueToTree(this.getScaleTargetRef()));
            if (this.getMetric() != null) {
                data.set("metric", om.valueToTree(this.getMetric()));
            }
            if (this.getMinReplicas() != null) {
                data.set("minReplicas", om.valueToTree(this.getMinReplicas()));
            }
            if (this.getTargetCpuUtilizationPercentage() != null) {
                data.set("targetCpuUtilizationPercentage", om.valueToTree(this.getTargetCpuUtilizationPercentage()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.HorizontalPodAutoscalerSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HorizontalPodAutoscalerSpec.Jsii$Proxy that = (HorizontalPodAutoscalerSpec.Jsii$Proxy) o;

            if (!maxReplicas.equals(that.maxReplicas)) return false;
            if (!scaleTargetRef.equals(that.scaleTargetRef)) return false;
            if (this.metric != null ? !this.metric.equals(that.metric) : that.metric != null) return false;
            if (this.minReplicas != null ? !this.minReplicas.equals(that.minReplicas) : that.minReplicas != null) return false;
            return this.targetCpuUtilizationPercentage != null ? this.targetCpuUtilizationPercentage.equals(that.targetCpuUtilizationPercentage) : that.targetCpuUtilizationPercentage == null;
        }

        @Override
        public final int hashCode() {
            int result = this.maxReplicas.hashCode();
            result = 31 * result + (this.scaleTargetRef.hashCode());
            result = 31 * result + (this.metric != null ? this.metric.hashCode() : 0);
            result = 31 * result + (this.minReplicas != null ? this.minReplicas.hashCode() : 0);
            result = 31 * result + (this.targetCpuUtilizationPercentage != null ? this.targetCpuUtilizationPercentage.hashCode() : 0);
            return result;
        }
    }
}
