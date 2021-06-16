package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.698Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodDisruptionBudgetSpec")
@software.amazon.jsii.Jsii.Proxy(PodDisruptionBudgetSpec.Jsii$Proxy.class)
public interface PodDisruptionBudgetSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#selector PodDisruptionBudget#selector}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector> getSelector();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#max_unavailable PodDisruptionBudget#max_unavailable}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMaxUnavailable() {
        return null;
    }

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#min_available PodDisruptionBudget#min_available}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMinAvailable() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodDisruptionBudgetSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodDisruptionBudgetSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodDisruptionBudgetSpec> {
        private java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector> selector;
        private java.lang.String maxUnavailable;
        private java.lang.String minAvailable;

        /**
         * Sets the value of {@link PodDisruptionBudgetSpec#getSelector}
         * @param selector selector block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#selector PodDisruptionBudget#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.PodDisruptionBudgetSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link PodDisruptionBudgetSpec#getMaxUnavailable}
         * @param maxUnavailable Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#max_unavailable PodDisruptionBudget#max_unavailable}.
         * @return {@code this}
         */
        public Builder maxUnavailable(java.lang.String maxUnavailable) {
            this.maxUnavailable = maxUnavailable;
            return this;
        }

        /**
         * Sets the value of {@link PodDisruptionBudgetSpec#getMinAvailable}
         * @param minAvailable Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/pod_disruption_budget.html#min_available PodDisruptionBudget#min_available}.
         * @return {@code this}
         */
        public Builder minAvailable(java.lang.String minAvailable) {
            this.minAvailable = minAvailable;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodDisruptionBudgetSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodDisruptionBudgetSpec build() {
            return new Jsii$Proxy(selector, maxUnavailable, minAvailable);
        }
    }

    /**
     * An implementation for {@link PodDisruptionBudgetSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodDisruptionBudgetSpec {
        private final java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector> selector;
        private final java.lang.String maxUnavailable;
        private final java.lang.String minAvailable;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodDisruptionBudgetSpecSelector.class)));
            this.maxUnavailable = software.amazon.jsii.Kernel.get(this, "maxUnavailable", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.minAvailable = software.amazon.jsii.Kernel.get(this, "minAvailable", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PodDisruptionBudgetSpecSelector> selector, final java.lang.String maxUnavailable, final java.lang.String minAvailable) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.selector = (java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector>)java.util.Objects.requireNonNull(selector, "selector is required");
            this.maxUnavailable = maxUnavailable;
            this.minAvailable = minAvailable;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodDisruptionBudgetSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.lang.String getMaxUnavailable() {
            return this.maxUnavailable;
        }

        @Override
        public final java.lang.String getMinAvailable() {
            return this.minAvailable;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("selector", om.valueToTree(this.getSelector()));
            if (this.getMaxUnavailable() != null) {
                data.set("maxUnavailable", om.valueToTree(this.getMaxUnavailable()));
            }
            if (this.getMinAvailable() != null) {
                data.set("minAvailable", om.valueToTree(this.getMinAvailable()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodDisruptionBudgetSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodDisruptionBudgetSpec.Jsii$Proxy that = (PodDisruptionBudgetSpec.Jsii$Proxy) o;

            if (!selector.equals(that.selector)) return false;
            if (this.maxUnavailable != null ? !this.maxUnavailable.equals(that.maxUnavailable) : that.maxUnavailable != null) return false;
            return this.minAvailable != null ? this.minAvailable.equals(that.minAvailable) : that.minAvailable == null;
        }

        @Override
        public final int hashCode() {
            int result = this.selector.hashCode();
            result = 31 * result + (this.maxUnavailable != null ? this.maxUnavailable.hashCode() : 0);
            result = 31 * result + (this.minAvailable != null ? this.minAvailable.hashCode() : 0);
            return result;
        }
    }
}
