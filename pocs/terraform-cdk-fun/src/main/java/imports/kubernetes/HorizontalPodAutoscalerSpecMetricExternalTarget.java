package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.597Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget")
@software.amazon.jsii.Jsii.Proxy(HorizontalPodAutoscalerSpecMetricExternalTarget.Jsii$Proxy.class)
public interface HorizontalPodAutoscalerSpecMetricExternalTarget extends software.amazon.jsii.JsiiSerializable {

    /**
     * type represents whether the metric type is Utilization, Value, or AverageValue.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#type HorizontalPodAutoscaler#type}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getType();

    /**
     * averageUtilization is the target value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.
     * <p>
     * Currently only valid for Resource metric source type
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#average_utilization HorizontalPodAutoscaler#average_utilization}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getAverageUtilization() {
        return null;
    }

    /**
     * averageValue is the target value of the average of the metric across all relevant pods (as a quantity).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#average_value HorizontalPodAutoscaler#average_value}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getAverageValue() {
        return null;
    }

    /**
     * value is the target value of the metric (as a quantity).
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#value HorizontalPodAutoscaler#value}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getValue() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HorizontalPodAutoscalerSpecMetricExternalTarget}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HorizontalPodAutoscalerSpecMetricExternalTarget}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HorizontalPodAutoscalerSpecMetricExternalTarget> {
        private java.lang.String type;
        private java.lang.Number averageUtilization;
        private java.lang.String averageValue;
        private java.lang.String value;

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternalTarget#getType}
         * @param type type represents whether the metric type is Utilization, Value, or AverageValue. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#type HorizontalPodAutoscaler#type}
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternalTarget#getAverageUtilization}
         * @param averageUtilization averageUtilization is the target value of the average of the resource metric across all relevant pods, represented as a percentage of the requested value of the resource for the pods.
         *                           Currently only valid for Resource metric source type
         *                           <p>
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#average_utilization HorizontalPodAutoscaler#average_utilization}
         * @return {@code this}
         */
        public Builder averageUtilization(java.lang.Number averageUtilization) {
            this.averageUtilization = averageUtilization;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternalTarget#getAverageValue}
         * @param averageValue averageValue is the target value of the average of the metric across all relevant pods (as a quantity).
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#average_value HorizontalPodAutoscaler#average_value}
         * @return {@code this}
         */
        public Builder averageValue(java.lang.String averageValue) {
            this.averageValue = averageValue;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricExternalTarget#getValue}
         * @param value value is the target value of the metric (as a quantity).
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#value HorizontalPodAutoscaler#value}
         * @return {@code this}
         */
        public Builder value(java.lang.String value) {
            this.value = value;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HorizontalPodAutoscalerSpecMetricExternalTarget}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HorizontalPodAutoscalerSpecMetricExternalTarget build() {
            return new Jsii$Proxy(type, averageUtilization, averageValue, value);
        }
    }

    /**
     * An implementation for {@link HorizontalPodAutoscalerSpecMetricExternalTarget}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HorizontalPodAutoscalerSpecMetricExternalTarget {
        private final java.lang.String type;
        private final java.lang.Number averageUtilization;
        private final java.lang.String averageValue;
        private final java.lang.String value;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.averageUtilization = software.amazon.jsii.Kernel.get(this, "averageUtilization", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.averageValue = software.amazon.jsii.Kernel.get(this, "averageValue", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.value = software.amazon.jsii.Kernel.get(this, "value", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String type, final java.lang.Number averageUtilization, final java.lang.String averageValue, final java.lang.String value) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.type = java.util.Objects.requireNonNull(type, "type is required");
            this.averageUtilization = averageUtilization;
            this.averageValue = averageValue;
            this.value = value;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        public final java.lang.Number getAverageUtilization() {
            return this.averageUtilization;
        }

        @Override
        public final java.lang.String getAverageValue() {
            return this.averageValue;
        }

        @Override
        public final java.lang.String getValue() {
            return this.value;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("type", om.valueToTree(this.getType()));
            if (this.getAverageUtilization() != null) {
                data.set("averageUtilization", om.valueToTree(this.getAverageUtilization()));
            }
            if (this.getAverageValue() != null) {
                data.set("averageValue", om.valueToTree(this.getAverageValue()));
            }
            if (this.getValue() != null) {
                data.set("value", om.valueToTree(this.getValue()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.HorizontalPodAutoscalerSpecMetricExternalTarget"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HorizontalPodAutoscalerSpecMetricExternalTarget.Jsii$Proxy that = (HorizontalPodAutoscalerSpecMetricExternalTarget.Jsii$Proxy) o;

            if (!type.equals(that.type)) return false;
            if (this.averageUtilization != null ? !this.averageUtilization.equals(that.averageUtilization) : that.averageUtilization != null) return false;
            if (this.averageValue != null ? !this.averageValue.equals(that.averageValue) : that.averageValue != null) return false;
            return this.value != null ? this.value.equals(that.value) : that.value == null;
        }

        @Override
        public final int hashCode() {
            int result = this.type.hashCode();
            result = 31 * result + (this.averageUtilization != null ? this.averageUtilization.hashCode() : 0);
            result = 31 * result + (this.averageValue != null ? this.averageValue.hashCode() : 0);
            result = 31 * result + (this.value != null ? this.value.hashCode() : 0);
            return result;
        }
    }
}
