package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.884Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpec")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpec.Jsii$Proxy.class)
public interface StatefulSetSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#selector StatefulSet#selector}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.StatefulSetSpecSelector> getSelector();

    /**
     * The name of the service that governs this StatefulSet.
     * <p>
     * This service must exist before the StatefulSet, and is responsible for the network identity of the set.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#service_name StatefulSet#service_name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getServiceName();

    /**
     * template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#template StatefulSet#template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.StatefulSetSpecTemplate> getTemplate();

    /**
     * Controls how pods are created during initial scale up, when replacing pods on nodes, or when scaling down.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#pod_management_policy StatefulSet#pod_management_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getPodManagementPolicy() {
        return null;
    }

    /**
     * The desired number of replicas of the given Template, in the sense that they are instantiations of the same Template.
     * <p>
     * Value must be a positive integer.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#replicas StatefulSet#replicas}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getReplicas() {
        return null;
    }

    /**
     * The maximum number of revisions that will be maintained in the StatefulSet's revision history. The default value is 10.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#revision_history_limit StatefulSet#revision_history_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRevisionHistoryLimit() {
        return null;
    }

    /**
     * update_strategy block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#update_strategy StatefulSet#update_strategy}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy> getUpdateStrategy() {
        return null;
    }

    /**
     * volume_claim_template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#volume_claim_template StatefulSet#volume_claim_template}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> getVolumeClaimTemplate() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpec> {
        private java.util.List<imports.kubernetes.StatefulSetSpecSelector> selector;
        private java.lang.String serviceName;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplate> template;
        private java.lang.String podManagementPolicy;
        private java.lang.Number replicas;
        private java.lang.Number revisionHistoryLimit;
        private java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy> updateStrategy;
        private java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> volumeClaimTemplate;

        /**
         * Sets the value of {@link StatefulSetSpec#getSelector}
         * @param selector selector block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#selector StatefulSet#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.StatefulSetSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.StatefulSetSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getServiceName}
         * @param serviceName The name of the service that governs this StatefulSet. This parameter is required.
         *                    This service must exist before the StatefulSet, and is responsible for the network identity of the set.
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#service_name StatefulSet#service_name}
         * @return {@code this}
         */
        public Builder serviceName(java.lang.String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getTemplate}
         * @param template template block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#template StatefulSet#template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder template(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplate> template) {
            this.template = (java.util.List<imports.kubernetes.StatefulSetSpecTemplate>)template;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getPodManagementPolicy}
         * @param podManagementPolicy Controls how pods are created during initial scale up, when replacing pods on nodes, or when scaling down.
         *                            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#pod_management_policy StatefulSet#pod_management_policy}
         * @return {@code this}
         */
        public Builder podManagementPolicy(java.lang.String podManagementPolicy) {
            this.podManagementPolicy = podManagementPolicy;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getReplicas}
         * @param replicas The desired number of replicas of the given Template, in the sense that they are instantiations of the same Template.
         *                 Value must be a positive integer.
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#replicas StatefulSet#replicas}
         * @return {@code this}
         */
        public Builder replicas(java.lang.Number replicas) {
            this.replicas = replicas;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getRevisionHistoryLimit}
         * @param revisionHistoryLimit The maximum number of revisions that will be maintained in the StatefulSet's revision history. The default value is 10.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#revision_history_limit StatefulSet#revision_history_limit}
         * @return {@code this}
         */
        public Builder revisionHistoryLimit(java.lang.Number revisionHistoryLimit) {
            this.revisionHistoryLimit = revisionHistoryLimit;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getUpdateStrategy}
         * @param updateStrategy update_strategy block.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#update_strategy StatefulSet#update_strategy}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder updateStrategy(java.util.List<? extends imports.kubernetes.StatefulSetSpecUpdateStrategy> updateStrategy) {
            this.updateStrategy = (java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy>)updateStrategy;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpec#getVolumeClaimTemplate}
         * @param volumeClaimTemplate volume_claim_template block.
         *                            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#volume_claim_template StatefulSet#volume_claim_template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder volumeClaimTemplate(java.util.List<? extends imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> volumeClaimTemplate) {
            this.volumeClaimTemplate = (java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate>)volumeClaimTemplate;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpec build() {
            return new Jsii$Proxy(selector, serviceName, template, podManagementPolicy, replicas, revisionHistoryLimit, updateStrategy, volumeClaimTemplate);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpec {
        private final java.util.List<imports.kubernetes.StatefulSetSpecSelector> selector;
        private final java.lang.String serviceName;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplate> template;
        private final java.lang.String podManagementPolicy;
        private final java.lang.Number replicas;
        private final java.lang.Number revisionHistoryLimit;
        private final java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy> updateStrategy;
        private final java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> volumeClaimTemplate;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecSelector.class)));
            this.serviceName = software.amazon.jsii.Kernel.get(this, "serviceName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.template = software.amazon.jsii.Kernel.get(this, "template", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplate.class)));
            this.podManagementPolicy = software.amazon.jsii.Kernel.get(this, "podManagementPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.replicas = software.amazon.jsii.Kernel.get(this, "replicas", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.revisionHistoryLimit = software.amazon.jsii.Kernel.get(this, "revisionHistoryLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.updateStrategy = software.amazon.jsii.Kernel.get(this, "updateStrategy", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecUpdateStrategy.class)));
            this.volumeClaimTemplate = software.amazon.jsii.Kernel.get(this, "volumeClaimTemplate", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecVolumeClaimTemplate.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecSelector> selector, final java.lang.String serviceName, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplate> template, final java.lang.String podManagementPolicy, final java.lang.Number replicas, final java.lang.Number revisionHistoryLimit, final java.util.List<? extends imports.kubernetes.StatefulSetSpecUpdateStrategy> updateStrategy, final java.util.List<? extends imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> volumeClaimTemplate) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.selector = (java.util.List<imports.kubernetes.StatefulSetSpecSelector>)java.util.Objects.requireNonNull(selector, "selector is required");
            this.serviceName = java.util.Objects.requireNonNull(serviceName, "serviceName is required");
            this.template = (java.util.List<imports.kubernetes.StatefulSetSpecTemplate>)java.util.Objects.requireNonNull(template, "template is required");
            this.podManagementPolicy = podManagementPolicy;
            this.replicas = replicas;
            this.revisionHistoryLimit = revisionHistoryLimit;
            this.updateStrategy = (java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy>)updateStrategy;
            this.volumeClaimTemplate = (java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate>)volumeClaimTemplate;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.lang.String getServiceName() {
            return this.serviceName;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplate> getTemplate() {
            return this.template;
        }

        @Override
        public final java.lang.String getPodManagementPolicy() {
            return this.podManagementPolicy;
        }

        @Override
        public final java.lang.Number getReplicas() {
            return this.replicas;
        }

        @Override
        public final java.lang.Number getRevisionHistoryLimit() {
            return this.revisionHistoryLimit;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecUpdateStrategy> getUpdateStrategy() {
            return this.updateStrategy;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecVolumeClaimTemplate> getVolumeClaimTemplate() {
            return this.volumeClaimTemplate;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("selector", om.valueToTree(this.getSelector()));
            data.set("serviceName", om.valueToTree(this.getServiceName()));
            data.set("template", om.valueToTree(this.getTemplate()));
            if (this.getPodManagementPolicy() != null) {
                data.set("podManagementPolicy", om.valueToTree(this.getPodManagementPolicy()));
            }
            if (this.getReplicas() != null) {
                data.set("replicas", om.valueToTree(this.getReplicas()));
            }
            if (this.getRevisionHistoryLimit() != null) {
                data.set("revisionHistoryLimit", om.valueToTree(this.getRevisionHistoryLimit()));
            }
            if (this.getUpdateStrategy() != null) {
                data.set("updateStrategy", om.valueToTree(this.getUpdateStrategy()));
            }
            if (this.getVolumeClaimTemplate() != null) {
                data.set("volumeClaimTemplate", om.valueToTree(this.getVolumeClaimTemplate()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpec.Jsii$Proxy that = (StatefulSetSpec.Jsii$Proxy) o;

            if (!selector.equals(that.selector)) return false;
            if (!serviceName.equals(that.serviceName)) return false;
            if (!template.equals(that.template)) return false;
            if (this.podManagementPolicy != null ? !this.podManagementPolicy.equals(that.podManagementPolicy) : that.podManagementPolicy != null) return false;
            if (this.replicas != null ? !this.replicas.equals(that.replicas) : that.replicas != null) return false;
            if (this.revisionHistoryLimit != null ? !this.revisionHistoryLimit.equals(that.revisionHistoryLimit) : that.revisionHistoryLimit != null) return false;
            if (this.updateStrategy != null ? !this.updateStrategy.equals(that.updateStrategy) : that.updateStrategy != null) return false;
            return this.volumeClaimTemplate != null ? this.volumeClaimTemplate.equals(that.volumeClaimTemplate) : that.volumeClaimTemplate == null;
        }

        @Override
        public final int hashCode() {
            int result = this.selector.hashCode();
            result = 31 * result + (this.serviceName.hashCode());
            result = 31 * result + (this.template.hashCode());
            result = 31 * result + (this.podManagementPolicy != null ? this.podManagementPolicy.hashCode() : 0);
            result = 31 * result + (this.replicas != null ? this.replicas.hashCode() : 0);
            result = 31 * result + (this.revisionHistoryLimit != null ? this.revisionHistoryLimit.hashCode() : 0);
            result = 31 * result + (this.updateStrategy != null ? this.updateStrategy.hashCode() : 0);
            result = 31 * result + (this.volumeClaimTemplate != null ? this.volumeClaimTemplate.hashCode() : 0);
            return result;
        }
    }
}
