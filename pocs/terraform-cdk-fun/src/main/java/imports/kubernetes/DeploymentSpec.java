package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.538Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DeploymentSpec")
@software.amazon.jsii.Jsii.Proxy(DeploymentSpec.Jsii$Proxy.class)
public interface DeploymentSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * template block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#template Deployment#template}
     */
    @org.jetbrains.annotations.NotNull java.util.List<imports.kubernetes.DeploymentSpecTemplate> getTemplate();

    /**
     * Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
     * <p>
     * Defaults to 0 (pod will be considered available as soon as it is ready)
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#min_ready_seconds Deployment#min_ready_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getMinReadySeconds() {
        return null;
    }

    /**
     * Indicates that the deployment is paused.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#paused Deployment#paused}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getPaused() {
        return null;
    }

    /**
     * The maximum time in seconds for a deployment to make progress before it is considered to be failed.
     * <p>
     * The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#progress_deadline_seconds Deployment#progress_deadline_seconds}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getProgressDeadlineSeconds() {
        return null;
    }

    /**
     * The number of desired replicas. Defaults to 1. More info: http://kubernetes.io/docs/user-guide/replication-controller#what-is-a-replication-controller.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#replicas Deployment#replicas}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getReplicas() {
        return null;
    }

    /**
     * The number of old ReplicaSets to retain to allow rollback.
     * <p>
     * This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#revision_history_limit Deployment#revision_history_limit}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Number getRevisionHistoryLimit() {
        return null;
    }

    /**
     * selector block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#selector Deployment#selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecSelector> getSelector() {
        return null;
    }

    /**
     * strategy block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#strategy Deployment#strategy}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.DeploymentSpecStrategy> getStrategy() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DeploymentSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DeploymentSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DeploymentSpec> {
        private java.util.List<imports.kubernetes.DeploymentSpecTemplate> template;
        private java.lang.Number minReadySeconds;
        private java.lang.Boolean paused;
        private java.lang.Number progressDeadlineSeconds;
        private java.lang.Number replicas;
        private java.lang.Number revisionHistoryLimit;
        private java.util.List<imports.kubernetes.DeploymentSpecSelector> selector;
        private java.util.List<imports.kubernetes.DeploymentSpecStrategy> strategy;

        /**
         * Sets the value of {@link DeploymentSpec#getTemplate}
         * @param template template block. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#template Deployment#template}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder template(java.util.List<? extends imports.kubernetes.DeploymentSpecTemplate> template) {
            this.template = (java.util.List<imports.kubernetes.DeploymentSpecTemplate>)template;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getMinReadySeconds}
         * @param minReadySeconds Minimum number of seconds for which a newly created pod should be ready without any of its container crashing, for it to be considered available.
         *                        Defaults to 0 (pod will be considered available as soon as it is ready)
         *                        <p>
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#min_ready_seconds Deployment#min_ready_seconds}
         * @return {@code this}
         */
        public Builder minReadySeconds(java.lang.Number minReadySeconds) {
            this.minReadySeconds = minReadySeconds;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getPaused}
         * @param paused Indicates that the deployment is paused.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#paused Deployment#paused}
         * @return {@code this}
         */
        public Builder paused(java.lang.Boolean paused) {
            this.paused = paused;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getProgressDeadlineSeconds}
         * @param progressDeadlineSeconds The maximum time in seconds for a deployment to make progress before it is considered to be failed.
         *                                The deployment controller will continue to process failed deployments and a condition with a ProgressDeadlineExceeded reason will be surfaced in the deployment status. Note that progress will not be estimated during the time a deployment is paused. Defaults to 600s.
         *                                <p>
         *                                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#progress_deadline_seconds Deployment#progress_deadline_seconds}
         * @return {@code this}
         */
        public Builder progressDeadlineSeconds(java.lang.Number progressDeadlineSeconds) {
            this.progressDeadlineSeconds = progressDeadlineSeconds;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getReplicas}
         * @param replicas The number of desired replicas. Defaults to 1. More info: http://kubernetes.io/docs/user-guide/replication-controller#what-is-a-replication-controller.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#replicas Deployment#replicas}
         * @return {@code this}
         */
        public Builder replicas(java.lang.Number replicas) {
            this.replicas = replicas;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getRevisionHistoryLimit}
         * @param revisionHistoryLimit The number of old ReplicaSets to retain to allow rollback.
         *                             This is a pointer to distinguish between explicit zero and not specified. Defaults to 10.
         *                             <p>
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#revision_history_limit Deployment#revision_history_limit}
         * @return {@code this}
         */
        public Builder revisionHistoryLimit(java.lang.Number revisionHistoryLimit) {
            this.revisionHistoryLimit = revisionHistoryLimit;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getSelector}
         * @param selector selector block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#selector Deployment#selector}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder selector(java.util.List<? extends imports.kubernetes.DeploymentSpecSelector> selector) {
            this.selector = (java.util.List<imports.kubernetes.DeploymentSpecSelector>)selector;
            return this;
        }

        /**
         * Sets the value of {@link DeploymentSpec#getStrategy}
         * @param strategy strategy block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/deployment.html#strategy Deployment#strategy}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder strategy(java.util.List<? extends imports.kubernetes.DeploymentSpecStrategy> strategy) {
            this.strategy = (java.util.List<imports.kubernetes.DeploymentSpecStrategy>)strategy;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DeploymentSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DeploymentSpec build() {
            return new Jsii$Proxy(template, minReadySeconds, paused, progressDeadlineSeconds, replicas, revisionHistoryLimit, selector, strategy);
        }
    }

    /**
     * An implementation for {@link DeploymentSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DeploymentSpec {
        private final java.util.List<imports.kubernetes.DeploymentSpecTemplate> template;
        private final java.lang.Number minReadySeconds;
        private final java.lang.Boolean paused;
        private final java.lang.Number progressDeadlineSeconds;
        private final java.lang.Number replicas;
        private final java.lang.Number revisionHistoryLimit;
        private final java.util.List<imports.kubernetes.DeploymentSpecSelector> selector;
        private final java.util.List<imports.kubernetes.DeploymentSpecStrategy> strategy;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.template = software.amazon.jsii.Kernel.get(this, "template", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecTemplate.class)));
            this.minReadySeconds = software.amazon.jsii.Kernel.get(this, "minReadySeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.paused = software.amazon.jsii.Kernel.get(this, "paused", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.progressDeadlineSeconds = software.amazon.jsii.Kernel.get(this, "progressDeadlineSeconds", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.replicas = software.amazon.jsii.Kernel.get(this, "replicas", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.revisionHistoryLimit = software.amazon.jsii.Kernel.get(this, "revisionHistoryLimit", software.amazon.jsii.NativeType.forClass(java.lang.Number.class));
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecSelector.class)));
            this.strategy = software.amazon.jsii.Kernel.get(this, "strategy", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.DeploymentSpecStrategy.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.DeploymentSpecTemplate> template, final java.lang.Number minReadySeconds, final java.lang.Boolean paused, final java.lang.Number progressDeadlineSeconds, final java.lang.Number replicas, final java.lang.Number revisionHistoryLimit, final java.util.List<? extends imports.kubernetes.DeploymentSpecSelector> selector, final java.util.List<? extends imports.kubernetes.DeploymentSpecStrategy> strategy) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.template = (java.util.List<imports.kubernetes.DeploymentSpecTemplate>)java.util.Objects.requireNonNull(template, "template is required");
            this.minReadySeconds = minReadySeconds;
            this.paused = paused;
            this.progressDeadlineSeconds = progressDeadlineSeconds;
            this.replicas = replicas;
            this.revisionHistoryLimit = revisionHistoryLimit;
            this.selector = (java.util.List<imports.kubernetes.DeploymentSpecSelector>)selector;
            this.strategy = (java.util.List<imports.kubernetes.DeploymentSpecStrategy>)strategy;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecTemplate> getTemplate() {
            return this.template;
        }

        @Override
        public final java.lang.Number getMinReadySeconds() {
            return this.minReadySeconds;
        }

        @Override
        public final java.lang.Boolean getPaused() {
            return this.paused;
        }

        @Override
        public final java.lang.Number getProgressDeadlineSeconds() {
            return this.progressDeadlineSeconds;
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
        public final java.util.List<imports.kubernetes.DeploymentSpecSelector> getSelector() {
            return this.selector;
        }

        @Override
        public final java.util.List<imports.kubernetes.DeploymentSpecStrategy> getStrategy() {
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
            if (this.getPaused() != null) {
                data.set("paused", om.valueToTree(this.getPaused()));
            }
            if (this.getProgressDeadlineSeconds() != null) {
                data.set("progressDeadlineSeconds", om.valueToTree(this.getProgressDeadlineSeconds()));
            }
            if (this.getReplicas() != null) {
                data.set("replicas", om.valueToTree(this.getReplicas()));
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
            struct.set("fqn", om.valueToTree("kubernetes.DeploymentSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DeploymentSpec.Jsii$Proxy that = (DeploymentSpec.Jsii$Proxy) o;

            if (!template.equals(that.template)) return false;
            if (this.minReadySeconds != null ? !this.minReadySeconds.equals(that.minReadySeconds) : that.minReadySeconds != null) return false;
            if (this.paused != null ? !this.paused.equals(that.paused) : that.paused != null) return false;
            if (this.progressDeadlineSeconds != null ? !this.progressDeadlineSeconds.equals(that.progressDeadlineSeconds) : that.progressDeadlineSeconds != null) return false;
            if (this.replicas != null ? !this.replicas.equals(that.replicas) : that.replicas != null) return false;
            if (this.revisionHistoryLimit != null ? !this.revisionHistoryLimit.equals(that.revisionHistoryLimit) : that.revisionHistoryLimit != null) return false;
            if (this.selector != null ? !this.selector.equals(that.selector) : that.selector != null) return false;
            return this.strategy != null ? this.strategy.equals(that.strategy) : that.strategy == null;
        }

        @Override
        public final int hashCode() {
            int result = this.template.hashCode();
            result = 31 * result + (this.minReadySeconds != null ? this.minReadySeconds.hashCode() : 0);
            result = 31 * result + (this.paused != null ? this.paused.hashCode() : 0);
            result = 31 * result + (this.progressDeadlineSeconds != null ? this.progressDeadlineSeconds.hashCode() : 0);
            result = 31 * result + (this.replicas != null ? this.replicas.hashCode() : 0);
            result = 31 * result + (this.revisionHistoryLimit != null ? this.revisionHistoryLimit.hashCode() : 0);
            result = 31 * result + (this.selector != null ? this.selector.hashCode() : 0);
            result = 31 * result + (this.strategy != null ? this.strategy.hashCode() : 0);
            return result;
        }
    }
}
