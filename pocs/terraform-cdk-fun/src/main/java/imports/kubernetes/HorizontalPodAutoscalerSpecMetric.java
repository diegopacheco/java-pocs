package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.596Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.HorizontalPodAutoscalerSpecMetric")
@software.amazon.jsii.Jsii.Proxy(HorizontalPodAutoscalerSpecMetric.Jsii$Proxy.class)
public interface HorizontalPodAutoscalerSpecMetric extends software.amazon.jsii.JsiiSerializable {

    /**
     * type is the type of metric source.
     * <p>
     * It should be one of "Object", "Pods", "External" or "Resource", each mapping to a matching field in the object.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#type HorizontalPodAutoscaler#type}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getType();

    /**
     * external block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#external HorizontalPodAutoscaler#external}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> getExternal() {
        return null;
    }

    /**
     * object block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#object HorizontalPodAutoscaler#object}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> getObject() {
        return null;
    }

    /**
     * pods block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#pods HorizontalPodAutoscaler#pods}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> getPods() {
        return null;
    }

    /**
     * resource block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#resource HorizontalPodAutoscaler#resource}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> getResource() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link HorizontalPodAutoscalerSpecMetric}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link HorizontalPodAutoscalerSpecMetric}
     */
    public static final class Builder implements software.amazon.jsii.Builder<HorizontalPodAutoscalerSpecMetric> {
        private java.lang.String type;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> external;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> object;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> pods;
        private java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> resource;

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetric#getType}
         * @param type type is the type of metric source. This parameter is required.
         *             It should be one of "Object", "Pods", "External" or "Resource", each mapping to a matching field in the object.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#type HorizontalPodAutoscaler#type}
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetric#getExternal}
         * @param external external block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#external HorizontalPodAutoscaler#external}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder external(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> external) {
            this.external = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal>)external;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetric#getObject}
         * @param object object block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#object HorizontalPodAutoscaler#object}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder object(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> object) {
            this.object = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject>)object;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetric#getPods}
         * @param pods pods block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#pods HorizontalPodAutoscaler#pods}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder pods(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> pods) {
            this.pods = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods>)pods;
            return this;
        }

        /**
         * Sets the value of {@link HorizontalPodAutoscalerSpecMetric#getResource}
         * @param resource resource block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/horizontal_pod_autoscaler.html#resource HorizontalPodAutoscaler#resource}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder resource(java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> resource) {
            this.resource = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource>)resource;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link HorizontalPodAutoscalerSpecMetric}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public HorizontalPodAutoscalerSpecMetric build() {
            return new Jsii$Proxy(type, external, object, pods, resource);
        }
    }

    /**
     * An implementation for {@link HorizontalPodAutoscalerSpecMetric}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements HorizontalPodAutoscalerSpecMetric {
        private final java.lang.String type;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> external;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> object;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> pods;
        private final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> resource;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.external = software.amazon.jsii.Kernel.get(this, "external", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal.class)));
            this.object = software.amazon.jsii.Kernel.get(this, "object", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject.class)));
            this.pods = software.amazon.jsii.Kernel.get(this, "pods", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods.class)));
            this.resource = software.amazon.jsii.Kernel.get(this, "resource", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String type, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> external, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> object, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> pods, final java.util.List<? extends imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> resource) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.type = java.util.Objects.requireNonNull(type, "type is required");
            this.external = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal>)external;
            this.object = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject>)object;
            this.pods = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods>)pods;
            this.resource = (java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource>)resource;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricExternal> getExternal() {
            return this.external;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricObject> getObject() {
            return this.object;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricPods> getPods() {
            return this.pods;
        }

        @Override
        public final java.util.List<imports.kubernetes.HorizontalPodAutoscalerSpecMetricResource> getResource() {
            return this.resource;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("type", om.valueToTree(this.getType()));
            if (this.getExternal() != null) {
                data.set("external", om.valueToTree(this.getExternal()));
            }
            if (this.getObject() != null) {
                data.set("object", om.valueToTree(this.getObject()));
            }
            if (this.getPods() != null) {
                data.set("pods", om.valueToTree(this.getPods()));
            }
            if (this.getResource() != null) {
                data.set("resource", om.valueToTree(this.getResource()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.HorizontalPodAutoscalerSpecMetric"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HorizontalPodAutoscalerSpecMetric.Jsii$Proxy that = (HorizontalPodAutoscalerSpecMetric.Jsii$Proxy) o;

            if (!type.equals(that.type)) return false;
            if (this.external != null ? !this.external.equals(that.external) : that.external != null) return false;
            if (this.object != null ? !this.object.equals(that.object) : that.object != null) return false;
            if (this.pods != null ? !this.pods.equals(that.pods) : that.pods != null) return false;
            return this.resource != null ? this.resource.equals(that.resource) : that.resource == null;
        }

        @Override
        public final int hashCode() {
            int result = this.type.hashCode();
            result = 31 * result + (this.external != null ? this.external.hashCode() : 0);
            result = 31 * result + (this.object != null ? this.object.hashCode() : 0);
            result = 31 * result + (this.pods != null ? this.pods.hashCode() : 0);
            result = 31 * result + (this.resource != null ? this.resource.hashCode() : 0);
            return result;
        }
    }
}
