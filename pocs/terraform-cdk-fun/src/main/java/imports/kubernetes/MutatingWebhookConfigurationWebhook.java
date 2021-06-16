package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.667Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.MutatingWebhookConfigurationWebhook")
@software.amazon.jsii.Jsii.Proxy(MutatingWebhookConfigurationWebhook.Jsii$Proxy.class)
public interface MutatingWebhookConfigurationWebhook extends software.amazon.jsii.JsiiSerializable {

    /**
     * client_config block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#client_config MutatingWebhookConfiguration#client_config}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> getClientConfig();

    /**
     * The name of the admission webhook.
     * <p>
     * Name should be fully qualified, e.g., imagepolicy.kubernetes.io, where "imagepolicy" is the name of the webhook, and kubernetes.io is the name of the organization. Required.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#name MutatingWebhookConfiguration#name}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getName();

    /**
     * rule block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#rule MutatingWebhookConfiguration#rule}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule> getRule();

    /**
     * AdmissionReviewVersions is an ordered list of preferred `AdmissionReview` versions the Webhook expects.
     * <p>
     * API server will try to use first version in the list which it supports. If none of the versions specified in this list supported by API server, validation will fail for this object. If a persisted webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail and be subject to the failure policy.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#admission_review_versions MutatingWebhookConfiguration#admission_review_versions}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getAdmissionReviewVersions() {
        return null;
    }

    /**
     * FailurePolicy defines how unrecognized errors from the admission endpoint are handled - allowed values are Ignore or Fail.
     * <p>
     * Defaults to Fail.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#failure_policy MutatingWebhookConfiguration#failure_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getFailurePolicy() {
        return null;
    }

    /**
     * matchPolicy defines how the "rules" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".
     * <p>
     * <ul>
     * <li>Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included <code>apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]</code>, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the webhook.</li>
     * <li>Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included <code>apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]</code>, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the webhook.</li>
     * </ul>
     * <p>
     * Defaults to "Equivalent"
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#match_policy MutatingWebhookConfiguration#match_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getMatchPolicy() {
        return null;
    }

    /**
     * namespace_selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#namespace_selector MutatingWebhookConfiguration#namespace_selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> getNamespaceSelector() {
        return null;
    }

    /**
     * object_selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#object_selector MutatingWebhookConfiguration#object_selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> getObjectSelector() {
        return null;
    }

    /**
     * reinvocationPolicy indicates whether this webhook should be called multiple times as part of a single admission evaluation.
     * <p>
     * Allowed values are "Never" and "IfNeeded".
     * <p>
     * Never: the webhook will not be called more than once in a single admission evaluation.
     * <p>
     * IfNeeded: the webhook will be called at least one additional time as part of the admission evaluation if the object being admitted is modified by other admission plugins after the initial webhook call. Webhooks that specify this option <em>must</em> be idempotent, able to process objects they previously admitted. Note: * the number of additional invocations is not guaranteed to be exactly one. * if additional invocations result in further modifications to the object, webhooks are not guaranteed to be invoked again. * webhooks that use this option may be reordered to minimize the number of additional invocations. * to validate an object after all mutations are guaranteed complete, use a validating admission webhook instead.
     * <p>
     * Defaults to "Never".
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#reinvocation_policy MutatingWebhookConfiguration#reinvocation_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getReinvocationPolicy() {
        return null;
    }

    /**
     * SideEffects states whether this webhook has side effects.
     * <p>
     * Acceptable values are: None, NoneOnDryRun (webhooks created via v1beta1 may also specify Some or Unknown). Webhooks with side effects MUST implement a reconciliation system, since a request may be rejected by a future step in the admission change and the side effects therefore need to be undone. Requests with the dryRun attribute will be auto-rejected if they match a webhook with sideEffects == Unknown or Some.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#side_effects MutatingWebhookConfiguration#side_effects}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSideEffects() {
        return null;
    }

    /**
     * TimeoutSeconds specifies the timeout for this webhook.
     * <p>
     * After the timeout passes, the webhook call will be ignored or the API call will fail based on the failure policy. The timeout value must be between 1 and 30 seconds. Default to 10 seconds.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#timeout_seconds MutatingWebhookConfiguration#timeout_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getTimeoutSeconds() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link MutatingWebhookConfigurationWebhook}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link MutatingWebhookConfigurationWebhook}
     */
    public static final class Builder implements software.amazon.jsii.Builder<MutatingWebhookConfigurationWebhook> {
        private java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> clientConfig;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule> rule;
        private java.util.List<java.lang.String> admissionReviewVersions;
        private java.lang.String failurePolicy;
        private java.lang.String matchPolicy;
        private java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> namespaceSelector;
        private java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> objectSelector;
        private java.lang.String reinvocationPolicy;
        private java.lang.String sideEffects;
        private java.lang.Number timeoutSeconds;

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getClientConfig}
         * @param clientConfig client_config block. This parameter is required.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#client_config MutatingWebhookConfiguration#client_config}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder clientConfig(java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> clientConfig) {
            this.clientConfig = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig>)clientConfig;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getName}
         * @param name The name of the admission webhook. This parameter is required.
         *             Name should be fully qualified, e.g., imagepolicy.kubernetes.io, where "imagepolicy" is the name of the webhook, and kubernetes.io is the name of the organization. Required.
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#name MutatingWebhookConfiguration#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getRule}
         * @param rule rule block. This parameter is required.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#rule MutatingWebhookConfiguration#rule}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rule(java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookRule> rule) {
            this.rule = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule>)rule;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getAdmissionReviewVersions}
         * @param admissionReviewVersions AdmissionReviewVersions is an ordered list of preferred `AdmissionReview` versions the Webhook expects.
         *                                API server will try to use first version in the list which it supports. If none of the versions specified in this list supported by API server, validation will fail for this object. If a persisted webhook configuration specifies allowed versions and does not include any versions known to the API Server, calls to the webhook will fail and be subject to the failure policy.
         *                                <p>
         *                                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#admission_review_versions MutatingWebhookConfiguration#admission_review_versions}
         * @return {@code this}
         */
        public Builder admissionReviewVersions(java.util.List<java.lang.String> admissionReviewVersions) {
            this.admissionReviewVersions = admissionReviewVersions;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getFailurePolicy}
         * @param failurePolicy FailurePolicy defines how unrecognized errors from the admission endpoint are handled - allowed values are Ignore or Fail.
         *                      Defaults to Fail.
         *                      <p>
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#failure_policy MutatingWebhookConfiguration#failure_policy}
         * @return {@code this}
         */
        public Builder failurePolicy(java.lang.String failurePolicy) {
            this.failurePolicy = failurePolicy;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getMatchPolicy}
         * @param matchPolicy matchPolicy defines how the "rules" list is used to match incoming requests. Allowed values are "Exact" or "Equivalent".
         *                    <ul>
         *                    <li>Exact: match a request only if it exactly matches a specified rule. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, but "rules" only included <code>apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]</code>, a request to apps/v1beta1 or extensions/v1beta1 would not be sent to the webhook.</li>
         *                    <li>Equivalent: match a request if modifies a resource listed in rules, even via another API group or version. For example, if deployments can be modified via apps/v1, apps/v1beta1, and extensions/v1beta1, and "rules" only included <code>apiGroups:["apps"], apiVersions:["v1"], resources: ["deployments"]</code>, a request to apps/v1beta1 or extensions/v1beta1 would be converted to apps/v1 and sent to the webhook.</li>
         *                    </ul>
         *                    <p>
         *                    Defaults to "Equivalent"
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#match_policy MutatingWebhookConfiguration#match_policy}
         * @return {@code this}
         */
        public Builder matchPolicy(java.lang.String matchPolicy) {
            this.matchPolicy = matchPolicy;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getNamespaceSelector}
         * @param namespaceSelector namespace_selector block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#namespace_selector MutatingWebhookConfiguration#namespace_selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder namespaceSelector(java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> namespaceSelector) {
            this.namespaceSelector = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector>)namespaceSelector;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getObjectSelector}
         * @param objectSelector object_selector block.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#object_selector MutatingWebhookConfiguration#object_selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder objectSelector(java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> objectSelector) {
            this.objectSelector = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector>)objectSelector;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getReinvocationPolicy}
         * @param reinvocationPolicy reinvocationPolicy indicates whether this webhook should be called multiple times as part of a single admission evaluation.
         *                           Allowed values are "Never" and "IfNeeded".
         *                           <p>
         *                           Never: the webhook will not be called more than once in a single admission evaluation.
         *                           <p>
         *                           IfNeeded: the webhook will be called at least one additional time as part of the admission evaluation if the object being admitted is modified by other admission plugins after the initial webhook call. Webhooks that specify this option <em>must</em> be idempotent, able to process objects they previously admitted. Note: * the number of additional invocations is not guaranteed to be exactly one. * if additional invocations result in further modifications to the object, webhooks are not guaranteed to be invoked again. * webhooks that use this option may be reordered to minimize the number of additional invocations. * to validate an object after all mutations are guaranteed complete, use a validating admission webhook instead.
         *                           <p>
         *                           Defaults to "Never".
         *                           <p>
         *                           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#reinvocation_policy MutatingWebhookConfiguration#reinvocation_policy}
         * @return {@code this}
         */
        public Builder reinvocationPolicy(java.lang.String reinvocationPolicy) {
            this.reinvocationPolicy = reinvocationPolicy;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getSideEffects}
         * @param sideEffects SideEffects states whether this webhook has side effects.
         *                    Acceptable values are: None, NoneOnDryRun (webhooks created via v1beta1 may also specify Some or Unknown). Webhooks with side effects MUST implement a reconciliation system, since a request may be rejected by a future step in the admission change and the side effects therefore need to be undone. Requests with the dryRun attribute will be auto-rejected if they match a webhook with sideEffects == Unknown or Some.
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#side_effects MutatingWebhookConfiguration#side_effects}
         * @return {@code this}
         */
        public Builder sideEffects(java.lang.String sideEffects) {
            this.sideEffects = sideEffects;
            return this;
        }

        /**
         * Sets the value of {@link MutatingWebhookConfigurationWebhook#getTimeoutSeconds}
         * @param timeoutSeconds TimeoutSeconds specifies the timeout for this webhook.
         *                       After the timeout passes, the webhook call will be ignored or the API call will fail based on the failure policy. The timeout value must be between 1 and 30 seconds. Default to 10 seconds.
         *                       <p>
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/mutating_webhook_configuration.html#timeout_seconds MutatingWebhookConfiguration#timeout_seconds}
         * @return {@code this}
         */
        public Builder timeoutSeconds(java.lang.Number timeoutSeconds) {
            this.timeoutSeconds = timeoutSeconds;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link MutatingWebhookConfigurationWebhook}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public MutatingWebhookConfigurationWebhook build() {
            return new Jsii$Proxy(clientConfig, name, rule, admissionReviewVersions, failurePolicy, matchPolicy, namespaceSelector, objectSelector, reinvocationPolicy, sideEffects, timeoutSeconds);
        }
    }

    /**
     * An implementation for {@link MutatingWebhookConfigurationWebhook}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements MutatingWebhookConfigurationWebhook {
        private final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> clientConfig;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule> rule;
        private final java.util.List<java.lang.String> admissionReviewVersions;
        private final java.lang.String failurePolicy;
        private final java.lang.String matchPolicy;
        private final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> namespaceSelector;
        private final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> objectSelector;
        private final java.lang.String reinvocationPolicy;
        private final java.lang.String sideEffects;
        private final java.lang.Number timeoutSeconds;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.clientConfig = software.amazon.jsii.Kernel.get(this, "clientConfig", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.rule = software.amazon.jsii.Kernel.get(this, "rule", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.MutatingWebhookConfigurationWebhookRule.class)));
            this.admissionReviewVersions = software.amazon.jsii.Kernel.get(this, "admissionReviewVersions", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.failurePolicy = software.amazon.jsii.Kernel.get(this, "failurePolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.matchPolicy = software.amazon.jsii.Kernel.get(this, "matchPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.namespaceSelector = software.amazon.jsii.Kernel.get(this, "namespaceSelector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector.class)));
            this.objectSelector = software.amazon.jsii.Kernel.get(this, "objectSelector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector.class)));
            this.reinvocationPolicy = software.amazon.jsii.Kernel.get(this, "reinvocationPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.sideEffects = software.amazon.jsii.Kernel.get(this, "sideEffects", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.timeoutSeconds = software.amazon.jsii.Kernel.get(this, "timeoutSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> clientConfig, final java.lang.String name, final java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookRule> rule, final java.util.List<java.lang.String> admissionReviewVersions, final java.lang.String failurePolicy, final java.lang.String matchPolicy, final java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> namespaceSelector, final java.util.List<? extends imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> objectSelector, final java.lang.String reinvocationPolicy, final java.lang.String sideEffects, final java.lang.Number timeoutSeconds) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.clientConfig = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig>)java.util.Objects.requireNonNull(clientConfig, "clientConfig is required");
            this.name = java.util.Objects.requireNonNull(name, "name is required");
            this.rule = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule>)java.util.Objects.requireNonNull(rule, "rule is required");
            this.admissionReviewVersions = admissionReviewVersions;
            this.failurePolicy = failurePolicy;
            this.matchPolicy = matchPolicy;
            this.namespaceSelector = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector>)namespaceSelector;
            this.objectSelector = (java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector>)objectSelector;
            this.reinvocationPolicy = reinvocationPolicy;
            this.sideEffects = sideEffects;
            this.timeoutSeconds = timeoutSeconds;
        }

        @Override
        public final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookClientConfig> getClientConfig() {
            return this.clientConfig;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookRule> getRule() {
            return this.rule;
        }

        @Override
        public final java.util.List<java.lang.String> getAdmissionReviewVersions() {
            return this.admissionReviewVersions;
        }

        @Override
        public final java.lang.String getFailurePolicy() {
            return this.failurePolicy;
        }

        @Override
        public final java.lang.String getMatchPolicy() {
            return this.matchPolicy;
        }

        @Override
        public final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookNamespaceSelector> getNamespaceSelector() {
            return this.namespaceSelector;
        }

        @Override
        public final java.util.List<imports.kubernetes.MutatingWebhookConfigurationWebhookObjectSelector> getObjectSelector() {
            return this.objectSelector;
        }

        @Override
        public final java.lang.String getReinvocationPolicy() {
            return this.reinvocationPolicy;
        }

        @Override
        public final java.lang.String getSideEffects() {
            return this.sideEffects;
        }

        @Override
        public final java.lang.Number getTimeoutSeconds() {
            return this.timeoutSeconds;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("clientConfig", om.valueToTree(this.getClientConfig()));
            data.set("name", om.valueToTree(this.getName()));
            data.set("rule", om.valueToTree(this.getRule()));
            if (this.getAdmissionReviewVersions() != null) {
                data.set("admissionReviewVersions", om.valueToTree(this.getAdmissionReviewVersions()));
            }
            if (this.getFailurePolicy() != null) {
                data.set("failurePolicy", om.valueToTree(this.getFailurePolicy()));
            }
            if (this.getMatchPolicy() != null) {
                data.set("matchPolicy", om.valueToTree(this.getMatchPolicy()));
            }
            if (this.getNamespaceSelector() != null) {
                data.set("namespaceSelector", om.valueToTree(this.getNamespaceSelector()));
            }
            if (this.getObjectSelector() != null) {
                data.set("objectSelector", om.valueToTree(this.getObjectSelector()));
            }
            if (this.getReinvocationPolicy() != null) {
                data.set("reinvocationPolicy", om.valueToTree(this.getReinvocationPolicy()));
            }
            if (this.getSideEffects() != null) {
                data.set("sideEffects", om.valueToTree(this.getSideEffects()));
            }
            if (this.getTimeoutSeconds() != null) {
                data.set("timeoutSeconds", om.valueToTree(this.getTimeoutSeconds()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.MutatingWebhookConfigurationWebhook"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MutatingWebhookConfigurationWebhook.Jsii$Proxy that = (MutatingWebhookConfigurationWebhook.Jsii$Proxy) o;

            if (!clientConfig.equals(that.clientConfig)) return false;
            if (!name.equals(that.name)) return false;
            if (!rule.equals(that.rule)) return false;
            if (this.admissionReviewVersions != null ? !this.admissionReviewVersions.equals(that.admissionReviewVersions) : that.admissionReviewVersions != null) return false;
            if (this.failurePolicy != null ? !this.failurePolicy.equals(that.failurePolicy) : that.failurePolicy != null) return false;
            if (this.matchPolicy != null ? !this.matchPolicy.equals(that.matchPolicy) : that.matchPolicy != null) return false;
            if (this.namespaceSelector != null ? !this.namespaceSelector.equals(that.namespaceSelector) : that.namespaceSelector != null) return false;
            if (this.objectSelector != null ? !this.objectSelector.equals(that.objectSelector) : that.objectSelector != null) return false;
            if (this.reinvocationPolicy != null ? !this.reinvocationPolicy.equals(that.reinvocationPolicy) : that.reinvocationPolicy != null) return false;
            if (this.sideEffects != null ? !this.sideEffects.equals(that.sideEffects) : that.sideEffects != null) return false;
            return this.timeoutSeconds != null ? this.timeoutSeconds.equals(that.timeoutSeconds) : that.timeoutSeconds == null;
        }

        @Override
        public final int hashCode() {
            int result = this.clientConfig.hashCode();
            result = 31 * result + (this.name.hashCode());
            result = 31 * result + (this.rule.hashCode());
            result = 31 * result + (this.admissionReviewVersions != null ? this.admissionReviewVersions.hashCode() : 0);
            result = 31 * result + (this.failurePolicy != null ? this.failurePolicy.hashCode() : 0);
            result = 31 * result + (this.matchPolicy != null ? this.matchPolicy.hashCode() : 0);
            result = 31 * result + (this.namespaceSelector != null ? this.namespaceSelector.hashCode() : 0);
            result = 31 * result + (this.objectSelector != null ? this.objectSelector.hashCode() : 0);
            result = 31 * result + (this.reinvocationPolicy != null ? this.reinvocationPolicy.hashCode() : 0);
            result = 31 * result + (this.sideEffects != null ? this.sideEffects.hashCode() : 0);
            result = 31 * result + (this.timeoutSeconds != null ? this.timeoutSeconds.hashCode() : 0);
            return result;
        }
    }
}
