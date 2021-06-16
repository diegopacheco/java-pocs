package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.603Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.HorizontalPodAutoscalerSpecMetricResource")
@software.amazon.jsii.Jsii.Proxy(HorizontalPodAutoscalerSpecMetricResource.Jsii$Proxy.class)
public interface HorizontalPodAutoscalerSpecMetricResource extends software.amazon.jsii.JsiiSerializable {

    /**
     * name is the name of the resource in question.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#name HorizontalPodAutoscaler#name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * target block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target HorizontalPodAutoscaler#target}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> getTarget() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HorizontalPodAutoscalerSpecMetricResource}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HorizontalPodAutoscalerSpecMetricResource}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HorizontalPodAutoscalerSpecMetricResource> {
        private java.lang.String name;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> target;

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricResource#getName}
         * @param name name is the name of the resource in question. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#name HorizontalPodAutoscaler#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetricResource#getTarget}
         * @param target target block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#target HorizontalPodAutoscaler#target}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder target(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> target) {
            this.target = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget>)target;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HorizontalPodAutoscalerSpecMetricResource}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HorizontalPodAutoscalerSpecMetricResource build() {
            return new Jsii$Proxy(name, target);
        }
    }

    /**
     * An implementation for {@link HorizontalPodAutoscalerSpecMetricResource}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HorizontalPodAutoscalerSpecMetricResource {
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> target;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.target = software.amazon.jsii.Kernel.get(this, "target", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String name, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> target) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.name = java.util.Objects.requireNonNull(name, "name is required");
            this.target = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget>)target;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResourceTarget> getTarget() {
            return this.target;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("name", om.valueToTree(this.getName()));
            if (this.getTarget() != null) {
                data.set("target", om.valueToTree(this.getTarget()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.HorizontalPodAutoscalerSpecMetricResource"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HorizontalPodAutoscalerSpecMetricResource.Jsii$Proxy that = (HorizontalPodAutoscalerSpecMetricResource.Jsii$Proxy) o;

            if (!name.equals(that.name)) return false;
            return this.target != null ? this.target.equals(that.target) : that.target == null;
        }

        @Override
        public final int hashCode() {
            int result = this.name.hashCode();
            result = 31 * result + (this.target != null ? this.target.hashCode() : 0);
            return result;
        }
    }
}
