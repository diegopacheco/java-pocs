package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.736Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecInitContainerEnvValueFrom")
@software.amazon.jsii.Jsii.Proxy(PodSpecInitContainerEnvValueFrom.Jsii$Proxy.class)
public interface PodSpecInitContainerEnvValueFrom extends software.amazon.jsii.JsiiSerializable {

    /**
     * config_map_key_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#config_map_key_ref Pod#config_map_key_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> getConfigMapKeyRef() {
        return null;
    }

    /**
     * field_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#field_ref Pod#field_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> getFieldRef() {
        return null;
    }

    /**
     * resource_field_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#resource_field_ref Pod#resource_field_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> getResourceFieldRef() {
        return null;
    }

    /**
     * secret_key_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#secret_key_ref Pod#secret_key_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> getSecretKeyRef() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecInitContainerEnvValueFrom}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecInitContainerEnvValueFrom}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecInitContainerEnvValueFrom> {
        private java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> configMapKeyRef;
        private java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> fieldRef;
        private java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> resourceFieldRef;
        private java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> secretKeyRef;

        /**
         * Sets the value of {@link PodSpecInitContainerEnvValueFrom#getConfigMapKeyRef}
         * @param configMapKeyRef config_map_key_ref block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#config_map_key_ref Pod#config_map_key_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMapKeyRef(java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> configMapKeyRef) {
            this.configMapKeyRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef>)configMapKeyRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerEnvValueFrom#getFieldRef}
         * @param fieldRef field_ref block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#field_ref Pod#field_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fieldRef(java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> fieldRef) {
            this.fieldRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef>)fieldRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerEnvValueFrom#getResourceFieldRef}
         * @param resourceFieldRef resource_field_ref block.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#resource_field_ref Pod#resource_field_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder resourceFieldRef(java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> resourceFieldRef) {
            this.resourceFieldRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef>)resourceFieldRef;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecInitContainerEnvValueFrom#getSecretKeyRef}
         * @param secretKeyRef secret_key_ref block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#secret_key_ref Pod#secret_key_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secretKeyRef(java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> secretKeyRef) {
            this.secretKeyRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef>)secretKeyRef;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecInitContainerEnvValueFrom}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecInitContainerEnvValueFrom build() {
            return new Jsii$Proxy(configMapKeyRef, fieldRef, resourceFieldRef, secretKeyRef);
        }
    }

    /**
     * An implementation for {@link PodSpecInitContainerEnvValueFrom}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecInitContainerEnvValueFrom {
        private final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> configMapKeyRef;
        private final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> fieldRef;
        private final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> resourceFieldRef;
        private final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> secretKeyRef;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.configMapKeyRef = software.amazon.jsii.Kernel.get(this, "configMapKeyRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef.class)));
            this.fieldRef = software.amazon.jsii.Kernel.get(this, "fieldRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef.class)));
            this.resourceFieldRef = software.amazon.jsii.Kernel.get(this, "resourceFieldRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef.class)));
            this.secretKeyRef = software.amazon.jsii.Kernel.get(this, "secretKeyRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> configMapKeyRef, final java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> fieldRef, final java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> resourceFieldRef, final java.util.List<? extends imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> secretKeyRef) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.configMapKeyRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef>)configMapKeyRef;
            this.fieldRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef>)fieldRef;
            this.resourceFieldRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef>)resourceFieldRef;
            this.secretKeyRef = (java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef>)secretKeyRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromConfigMapKeyRef> getConfigMapKeyRef() {
            return this.configMapKeyRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromFieldRef> getFieldRef() {
            return this.fieldRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromResourceFieldRef> getResourceFieldRef() {
            return this.resourceFieldRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecInitContainerEnvValueFromSecretKeyRef> getSecretKeyRef() {
            return this.secretKeyRef;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getConfigMapKeyRef() != null) {
                data.set("configMapKeyRef", om.valueToTree(this.getConfigMapKeyRef()));
            }
            if (this.getFieldRef() != null) {
                data.set("fieldRef", om.valueToTree(this.getFieldRef()));
            }
            if (this.getResourceFieldRef() != null) {
                data.set("resourceFieldRef", om.valueToTree(this.getResourceFieldRef()));
            }
            if (this.getSecretKeyRef() != null) {
                data.set("secretKeyRef", om.valueToTree(this.getSecretKeyRef()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecInitContainerEnvValueFrom"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecInitContainerEnvValueFrom.Jsii$Proxy that = (PodSpecInitContainerEnvValueFrom.Jsii$Proxy) o;

            if (this.configMapKeyRef != null ? !this.configMapKeyRef.equals(that.configMapKeyRef) : that.configMapKeyRef != null) return false;
            if (this.fieldRef != null ? !this.fieldRef.equals(that.fieldRef) : that.fieldRef != null) return false;
            if (this.resourceFieldRef != null ? !this.resourceFieldRef.equals(that.resourceFieldRef) : that.resourceFieldRef != null) return false;
            return this.secretKeyRef != null ? this.secretKeyRef.equals(that.secretKeyRef) : that.secretKeyRef == null;
        }

        @Override
        public final int hashCode() {
            int result = this.configMapKeyRef != null ? this.configMapKeyRef.hashCode() : 0;
            result = 31 * result + (this.fieldRef != null ? this.fieldRef.hashCode() : 0);
            result = 31 * result + (this.resourceFieldRef != null ? this.resourceFieldRef.hashCode() : 0);
            result = 31 * result + (this.secretKeyRef != null ? this.secretKeyRef.hashCode() : 0);
            return result;
        }
    }
}
