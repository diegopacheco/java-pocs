package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.455Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef")
@software.amazon.jsii.Jsii.Proxy(DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef.Jsii$Proxy.class)
public interface DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef extends software.amazon.jsii.JsiiSerializable {

    /**
     * Version of the schema the FieldPath is written in terms of, defaults to "v1".
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#api_version Daemonset#api_version}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getApiVersion() {
        return null;
    }

    /**
     * Path of the field to select in the specified API version.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#field_path Daemonset#field_path}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getFieldPath() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef}
     */
    public static final class Builder implements software.amazon.jsii.Builder<DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef> {
        private java.lang.String apiVersion;
        private java.lang.String fieldPath;

        /**
         * Sets the value of {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef#getApiVersion}
         * @param apiVersion Version of the schema the FieldPath is written in terms of, defaults to "v1".
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#api_version Daemonset#api_version}
         * @return {@code this}
         */
        public Builder apiVersion(java.lang.String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

        /**
         * Sets the value of {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef#getFieldPath}
         * @param fieldPath Path of the field to select in the specified API version.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/daemonset.html#field_path Daemonset#field_path}
         * @return {@code this}
         */
        public Builder fieldPath(java.lang.String fieldPath) {
            this.fieldPath = fieldPath;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef build() {
            return new Jsii$Proxy(apiVersion, fieldPath);
        }
    }

    /**
     * An implementation for {@link DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef {
        private final java.lang.String apiVersion;
        private final java.lang.String fieldPath;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.apiVersion = software.amazon.jsii.Kernel.get(this, "apiVersion", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.fieldPath = software.amazon.jsii.Kernel.get(this, "fieldPath", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String apiVersion, final java.lang.String fieldPath) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.apiVersion = apiVersion;
            this.fieldPath = fieldPath;
        }

        @Override
        public final java.lang.String getApiVersion() {
            return this.apiVersion;
        }

        @Override
        public final java.lang.String getFieldPath() {
            return this.fieldPath;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getApiVersion() != null) {
                data.set("apiVersion", om.valueToTree(this.getApiVersion()));
            }
            if (this.getFieldPath() != null) {
                data.set("fieldPath", om.valueToTree(this.getFieldPath()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef.Jsii$Proxy that = (DaemonsetSpecTemplateSpecContainerEnvValueFromFieldRef.Jsii$Proxy) o;

            if (this.apiVersion != null ? !this.apiVersion.equals(that.apiVersion) : that.apiVersion != null) return false;
            return this.fieldPath != null ? this.fieldPath.equals(that.fieldPath) : that.fieldPath == null;
        }

        @Override
        public final int hashCode() {
            int result = this.apiVersion != null ? this.apiVersion.hashCode() : 0;
            result = 31 * result + (this.fieldPath != null ? this.fieldPath.hashCode() : 0);
            return result;
        }
    }
}
