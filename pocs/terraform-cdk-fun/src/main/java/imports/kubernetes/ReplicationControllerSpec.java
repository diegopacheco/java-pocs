package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.763Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpec")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpec.Jsii$Proxy.class)
public interface ReplicationControllerSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * A label query over pods that should match the Replicas count.
     * <p>
     * If Selector is empty, it is defaulted to the labels present on the Pod template. Label keys and values that must match in order to be controlled by this replication controller, if empty defaulted to labels on Pod template. More info: http://kubernetes.io/docs/user-guide/labels#label-selectors
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#selector ReplicationController#selector}
     */
    @org.jetbrains.annotations.NotNull java.util.Map<java.lang.String, java.lang.String> getSelector();

    /**
     * template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#template ReplicationController#template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate> getTemplate();

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
     * <p>
     * Defaults to 0 (pod will be considered available as soon as it is ready)
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#min_ready_seconds ReplicationController#min_ready_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getMinReadySeconds() {
        return null;
    }

    /**
     * The number of desired replicas. Defaults to 1. More info: http://kubernetes.io/docs/user-guide/replication-controller#what-is-a-replication-controller.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#replicas ReplicationController#replicas}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getReplicas() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpec> {
        private java.util.Map<java.lang.String, java.lang.String> selector;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate> template;
        private java.lang.Number minReadySeconds;
        private java.lang.Number replicas;

        /**
         * Sets the value of {@link ReplicationControllerSpec#getSelector}
         * @param selector A label query over pods that should match the Replicas count. This parameter is required.
         *                 If Selector is empty, it is defaulted to the labels present on the Pod template. Label keys and values that must match in order to be controlled by this replication controller, if empty defaulted to labels on Pod template. More info: http://kubernetes.io/docs/user-guide/labels#label-selectors
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#selector ReplicationController#selector}
         * @return {@code this}
         */
        public Builder selector(java.util.Map<java.lang.String, java.lang.String> selector) {
            this.selector = selector;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpec#getTemplate}
         * @param template template block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#template ReplicationController#template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder template(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplate> template) {
            this.template = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate>)template;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpec#getMinReadySeconds}
         * @param minReadySeconds Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
         *                        Defaults to 0 (pod will be considered available as soon as it is ready)
         *                        <p>
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#min_ready_seconds ReplicationController#min_ready_seconds}
         * @return {@code this}
         */
        public Builder minReadySeconds(java.lang.Number minReadySeconds) {
            this.minReadySeconds = minReadySeconds;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpec#getReplicas}
         * @param replicas The number of desired replicas. Defaults to 1. More info: http://kubernetes.io/docs/user-guide/replication-controller#what-is-a-replication-controller.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#replicas ReplicationController#replicas}
         * @return {@code this}
         */
        public Builder replicas(java.lang.Number replicas) {
            this.replicas = replicas;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpec build() {
            return new Jsii$Proxy(selector, template, minReadySeconds, replicas);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpec {
        private final java.util.Map<java.lang.String, java.lang.String> selector;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate> template;
        private final java.lang.Number minReadySeconds;
        private final java.lang.Number replicas;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.template = software.amazon.jsii.Kernel.get(this, "template", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplate.class)));
            this.minReadySeconds = software.amazon.jsii.Kernel.get(this, "minReadySeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.replicas = software.amazon.jsii.Kernel.get(this, "replicas", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.Map<java.lang.String, java.lang.String> selector, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplate> template, final java.lang.Number minReadySeconds, final java.lang.Number replicas) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.selector = java.util.Objects.requireNonNull(selector, "selector is required");
            this.template = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate>)java.util.Objects.requireNonNull(template, "template is required");
            this.minReadySeconds = minReadySeconds;
            this.replicas = replicas;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getSelector() {
            return this.selector;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplate> getTemplate() {
            return this.template;
        }

        @Override
        public final java.lang.Number getMinReadySeconds() {
            return this.minReadySeconds;
        }

        @Override
        public final java.lang.Number getReplicas() {
            return this.replicas;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("selector", om.valueToTree(this.getSelector()));
            data.set("template", om.valueToTree(this.getTemplate()));
            if (this.getMinReadySeconds() != null) {
                data.set("minReadySeconds", om.valueToTree(this.getMinReadySeconds()));
            }
            if (this.getReplicas() != null) {
                data.set("replicas", om.valueToTree(this.getReplicas()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpec.Jsii$Proxy that = (ReplicationControllerSpec.Jsii$Proxy) o;

            if (!selector.equals(that.selector)) return false;
            if (!template.equals(that.template)) return false;
            if (this.minReadySeconds != null ? !this.minReadySeconds.equals(that.minReadySeconds) : that.minReadySeconds != null) return false;
            return this.replicas != null ? this.replicas.equals(that.replicas) : that.replicas == null;
        }

        @Override
        public final int hashCode() {
            int result = this.selector.hashCode();
            result = 31 * result + (this.template.hashCode());
            result = 31 * result + (this.minReadySeconds != null ? this.minReadySeconds.hashCode() : 0);
            result = 31 * result + (this.replicas != null ? this.replicas.hashCode() : 0);
            return result;
        }
    }
}
