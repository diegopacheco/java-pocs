package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.429Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DaemonsetSpec")
@software.amazon.jsii.Jsii.Proxy(DaemonsetSpec.Jsii$Proxy.class)
public interface DaemonsetSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#template Daemonset#template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.DaemonsetSpecTemplate> getTemplate();

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
     * <p>
     * Defaults to 0 (pod will be considered available as soon as it is ready)
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#min_ready_seconds Daemonset#min_ready_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getMinReadySeconds() {
        return null;
    }

    /**
     * The number of old ReplicaSets to retain to allow rollback.
     * <p>
     * This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#revision_history_limit Daemonset#revision_history_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRevisionHistoryLimit() {
        return null;
    }

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#selector Daemonset#selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DaemonsetSpecSelector> getSelector() {
        return null;
    }

    /**
     * strategy block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#strategy Daemonset#strategy}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DaemonsetSpecStrategy> getStrategy() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DaemonsetSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DaemonsetSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DaemonsetSpec> {
        private java.util.List<imports.kubernetes.DaemonsetSpecTemplate> template;
        private java.lang.Number minReadySeconds;
        private java.lang.Number revisionHistoryLimit;
        private java.util.List<imports.kubernetes.DaemonsetSpecSelector> selector;
        private java.util.List<imports.kubernetes.DaemonsetSpecStrategy> strategy;

        /**
         * Sets the value of {@link DaemonsetSpec#getTemplate}
         * @param template template block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#template Daemonset#template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder template(java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplate> template) {
            this.template = (java.util.List<imports.kubernetes.DaemonsetSpecTemplate>)template;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpec#getMinReadySeconds}
         * @param minReadySeconds Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
         *                        Defaults to 0 (pod will be considered available as soon as it is ready)
         *                        <p>
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#min_ready_seconds Daemonset#min_ready_seconds}
         * @return {@code this}
         */
        public Builder minReadySeconds(java.lang.Number minReadySeconds) {
            this.minReadySeconds = minReadySeconds;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpec#getRevisionHistoryLimit}
         * @param revisionHistoryLimit The number of old ReplicaSets to retain to allow rollback.
         *                             This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
         *                             <p>
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#revision_history_limit Daemonset#revision_history_limit}
         * @return {@code this}
         */
        public Builder revisionHistoryLimit(java.lang.Number revisionHistoryLimit) {
            this.revisionHistoryLimit = revisionHistoryLimit;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpec#getSelector}
         * @param selector selector block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#selector Daemonset#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.DaemonsetSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.DaemonsetSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpec#getStrategy}
         * @param strategy strategy block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#strategy Daemonset#strategy}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder strategy(java.util.List<? extends imports.kubernetes.DaemonsetSpecStrategy> strategy) {
            this.strategy = (java.util.List<imports.kubernetes.DaemonsetSpecStrategy>)strategy;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DaemonsetSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DaemonsetSpec build() {
            return new Jsii$Proxy(template, minReadySeconds, revisionHistoryLimit, selector, strategy);
        }
    }

    /**
     * An implementation for {@link DaemonsetSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DaemonsetSpec {
        private final java.util.List<imports.kubernetes.DaemonsetSpecTemplate> template;
        private final java.lang.Number minReadySeconds;
        private final java.lang.Number revisionHistoryLimit;
        private final java.util.List<imports.kubernetes.DaemonsetSpecSelector> selector;
        private final java.util.List<imports.kubernetes.DaemonsetSpecStrategy> strategy;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.template = software.amazon.jsii.Kernel.get(this, "template", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecTemplate.class)));
            this.minReadySeconds = software.amazon.jsii.Kernel.get(this, "minReadySeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.revisionHistoryLimit = software.amazon.jsii.Kernel.get(this, "revisionHistoryLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecSelector.class)));
            this.strategy = software.amazon.jsii.Kernel.get(this, "strategy", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DaemonsetSpecStrategy.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DaemonsetSpecTemplate> template, final java.lang.Number minReadySeconds, final java.lang.Number revisionHistoryLimit, final java.util.List<? extends imports.kubernetes.DaemonsetSpecSelector> selector, final java.util.List<? extends imports.kubernetes.DaemonsetSpecStrategy> strategy) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.template = (java.util.List<imports.kubernetes.DaemonsetSpecTemplate>)java.util.Objects.requireNonNull(template, "template is required");
            this.minReadySeconds = minReadySeconds;
            this.revisionHistoryLimit = revisionHistoryLimit;
            this.selector = (java.util.List<imports.kubernetes.DaemonsetSpecSelector>)selector;
            this.strategy = (java.util.List<imports.kubernetes.DaemonsetSpecStrategy>)strategy;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecTemplate> getTemplate() {
            return this.template;
        }

        @Override
        public final java.lang.Number getMinReadySeconds() {
            return this.minReadySeconds;
        }

        @Override
        public final java.lang.Number getRevisionHistoryLimit() {
            return this.revisionHistoryLimit;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.util.List<imports.kubernetes.DaemonsetSpecStrategy> getStrategy() {
            return this.strategy;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("template", om.valueToTree(this.getTemplate()));
            if (this.getMinReadySeconds() != null) {
                data.set("minReadySeconds", om.valueToTree(this.getMinReadySeconds()));
            }
            if (this.getRevisionHistoryLimit() != null) {
                data.set("revisionHistoryLimit", om.valueToTree(this.getRevisionHistoryLimit()));
            }
            if (this.getSelector() != null) {
                data.set("selector", om.valueToTree(this.getSelector()));
            }
            if (this.getStrategy() != null) {
                data.set("strategy", om.valueToTree(this.getStrategy()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DaemonsetSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DaemonsetSpec.Jsii$Proxy that = (DaemonsetSpec.Jsii$Proxy) o;

            if (!template.equals(that.template)) return false;
            if (this.minReadySeconds != null ? !this.minReadySeconds.equals(that.minReadySeconds) : that.minReadySeconds != null) return false;
            if (this.revisionHistoryLimit != null ? !this.revisionHistoryLimit.equals(that.revisionHistoryLimit) : that.revisionHistoryLimit != null) return false;
            if (this.selector != null ? !this.selector.equals(that.selector) : that.selector != null) return false;
            return this.strategy != null ? this.strategy.equals(that.strategy) : that.strategy == null;
        }

        @Override
        public final int hashCode() {
            int result = this.template.hashCode();
            result = 31 * result + (this.minReadySeconds != null ? this.minReadySeconds.hashCode() : 0);
            result = 31 * result + (this.revisionHistoryLimit != null ? this.revisionHistoryLimit.hashCode() : 0);
            result = 31 * result + (this.selector != null ? this.selector.hashCode() : 0);
            result = 31 * result + (this.strategy != null ? this.strategy.hashCode() : 0);
            return result;
        }
    }
}
