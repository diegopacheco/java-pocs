package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.503Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DataKubernetesIngressMetadata")
@software.amazon.jsii.Jsii.Proxy(DataKubernetesIngressMetadata.Jsii$Proxy.class)
public interface DataKubernetesIngressMetadata extends software.amazon.jsii.JsiiSerializable {

    /**
     * An unstructured key value map stored with the ingress that may be used to store arbitrary metadata.
     * <p>
     * More info: http://kubernetes.io/docs/user-guide/annotations
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#annotations DataKubernetesIngress#annotations}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getAnnotations() {
        return null;
    }

    /**
     * Map of string keys and values that can be used to organize and categorize (scope and select) the ingress.
     * <p>
     * May match selectors of replication controllers and services. More info: http://kubernetes.io/docs/user-guide/labels
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#labels DataKubernetesIngress#labels}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getLabels() {
        return null;
    }

    /**
     * Name of the ingress, must be unique. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#name DataKubernetesIngress#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * Namespace defines the space within which name of the ingress must be unique.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#namespace DataKubernetesIngress#namespace}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getNamespace() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DataKubernetesIngressMetadata}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DataKubernetesIngressMetadata}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DataKubernetesIngressMetadata> {
        private java.util.Map<java.lang.String, java.lang.String> annotations;
        private java.util.Map<java.lang.String, java.lang.String> labels;
        private java.lang.String name;
        private java.lang.String namespace;

        /**
         * Sets the value of {@link DataKubernetesIngressMetadata#getAnnotations}
         * @param annotations An unstructured key value map stored with the ingress that may be used to store arbitrary metadata.
         *                    More info: http://kubernetes.io/docs/user-guide/annotations
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#annotations DataKubernetesIngress#annotations}
         * @return {@code this}
         */
        public Builder annotations(java.util.Map<java.lang.String, java.lang.String> annotations) {
            this.annotations = annotations;
            return this;
        }

        /**
         * Sets the value of {@link DataKubernetesIngressMetadata#getLabels}
         * @param labels Map of string keys and values that can be used to organize and categorize (scope and select) the ingress.
         *               May match selectors of replication controllers and services. More info: http://kubernetes.io/docs/user-guide/labels
         *               <p>
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#labels DataKubernetesIngress#labels}
         * @return {@code this}
         */
        public Builder labels(java.util.Map<java.lang.String, java.lang.String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Sets the value of {@link DataKubernetesIngressMetadata#getName}
         * @param name Name of the ingress, must be unique. Cannot be updated. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#name DataKubernetesIngress#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link DataKubernetesIngressMetadata#getNamespace}
         * @param namespace Namespace defines the space within which name of the ingress must be unique.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/d/ingress.html#namespace DataKubernetesIngress#namespace}
         * @return {@code this}
         */
        public Builder namespace(java.lang.String namespace) {
            this.namespace = namespace;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DataKubernetesIngressMetadata}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DataKubernetesIngressMetadata build() {
            return new Jsii$Proxy(annotations, labels, name, namespace);
        }
    }

    /**
     * An implementation for {@link DataKubernetesIngressMetadata}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DataKubernetesIngressMetadata {
        private final java.util.Map<java.lang.String, java.lang.String> annotations;
        private final java.util.Map<java.lang.String, java.lang.String> labels;
        private final java.lang.String name;
        private final java.lang.String namespace;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.annotations = software.amazon.jsii.Kernel.get(this, "annotations", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.labels = software.amazon.jsii.Kernel.get(this, "labels", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.namespace = software.amazon.jsii.Kernel.get(this, "namespace", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.Map<java.lang.String, java.lang.String> annotations, final java.util.Map<java.lang.String, java.lang.String> labels, final java.lang.String name, final java.lang.String namespace) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.annotations = annotations;
            this.labels = labels;
            this.name = name;
            this.namespace = namespace;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getAnnotations() {
            return this.annotations;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getLabels() {
            return this.labels;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.lang.String getNamespace() {
            return this.namespace;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAnnotations() != null) {
                data.set("annotations", om.valueToTree(this.getAnnotations()));
            }
            if (this.getLabels() != null) {
                data.set("labels", om.valueToTree(this.getLabels()));
            }
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }
            if (this.getNamespace() != null) {
                data.set("namespace", om.valueToTree(this.getNamespace()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DataKubernetesIngressMetadata"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DataKubernetesIngressMetadata.Jsii$Proxy that = (DataKubernetesIngressMetadata.Jsii$Proxy) o;

            if (this.annotations != null ? !this.annotations.equals(that.annotations) : that.annotations != null) return false;
            if (this.labels != null ? !this.labels.equals(that.labels) : that.labels != null) return false;
            if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
            return this.namespace != null ? this.namespace.equals(that.namespace) : that.namespace == null;
        }

        @Override
        public final int hashCode() {
            int result = this.annotations != null ? this.annotations.hashCode() : 0;
            result = 31 * result + (this.labels != null ? this.labels.hashCode() : 0);
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            result = 31 * result + (this.namespace != null ? this.namespace.hashCode() : 0);
            return result;
        }
    }
}
