package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.937Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecycle")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecInitContainerLifecycle.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecInitContainerLifecycle extends software.amazon.jsii.JsiiSerializable {

    /**
     * post_start block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#post_start StatefulSet#post_start}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> getPostStart() {
        return null;
    }

    /**
     * pre_stop block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#pre_stop StatefulSet#pre_stop}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> getPreStop() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecInitContainerLifecycle}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecInitContainerLifecycle}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecInitContainerLifecycle> {
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> postStart;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> preStop;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecycle#getPostStart}
         * @param postStart post_start block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#post_start StatefulSet#post_start}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder postStart(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> postStart) {
            this.postStart = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart>)postStart;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecycle#getPreStop}
         * @param preStop pre_stop block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#pre_stop StatefulSet#pre_stop}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder preStop(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> preStop) {
            this.preStop = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop>)preStop;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecInitContainerLifecycle}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecInitContainerLifecycle build() {
            return new Jsii$Proxy(postStart, preStop);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecInitContainerLifecycle}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecInitContainerLifecycle {
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> postStart;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> preStop;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.postStart = software.amazon.jsii.Kernel.get(this, "postStart", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart.class)));
            this.preStop = software.amazon.jsii.Kernel.get(this, "preStop", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> postStart, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> preStop) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.postStart = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart>)postStart;
            this.preStop = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop>)preStop;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> getPostStart() {
            return this.postStart;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> getPreStop() {
            return this.preStop;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getPostStart() != null) {
                data.set("postStart", om.valueToTree(this.getPostStart()));
            }
            if (this.getPreStop() != null) {
                data.set("preStop", om.valueToTree(this.getPreStop()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecycle"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecInitContainerLifecycle.Jsii$Proxy that = (StatefulSetSpecTemplateSpecInitContainerLifecycle.Jsii$Proxy) o;

            if (this.postStart != null ? !this.postStart.equals(that.postStart) : that.postStart != null) return false;
            return this.preStop != null ? this.preStop.equals(that.preStop) : that.preStop == null;
        }

        @Override
        public final int hashCode() {
            int result = this.postStart != null ? this.postStart.hashCode() : 0;
            result = 31 * result + (this.preStop != null ? this.preStop.hashCode() : 0);
            return result;
        }
    }
}
