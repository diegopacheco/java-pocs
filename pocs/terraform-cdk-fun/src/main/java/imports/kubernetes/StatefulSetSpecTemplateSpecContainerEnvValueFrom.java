package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.928Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFrom")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecContainerEnvValueFrom.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecContainerEnvValueFrom extends software.amazon.jsii.JsiiSerializable {

    /**
     * config_map_key_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#config_map_key_ref StatefulSet#config_map_key_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> getConfigMapKeyRef() {
        return null;
    }

    /**
     * field_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#field_ref StatefulSet#field_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> getFieldRef() {
        return null;
    }

    /**
     * resource_field_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#resource_field_ref StatefulSet#resource_field_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> getResourceFieldRef() {
        return null;
    }

    /**
     * secret_key_ref block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#secret_key_ref StatefulSet#secret_key_ref}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> getSecretKeyRef() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecContainerEnvValueFrom> {
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> configMapKeyRef;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> fieldRef;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> resourceFieldRef;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> secretKeyRef;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom#getConfigMapKeyRef}
         * @param configMapKeyRef config_map_key_ref block.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#config_map_key_ref StatefulSet#config_map_key_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMapKeyRef(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> configMapKeyRef) {
            this.configMapKeyRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef>)configMapKeyRef;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom#getFieldRef}
         * @param fieldRef field_ref block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#field_ref StatefulSet#field_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fieldRef(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> fieldRef) {
            this.fieldRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef>)fieldRef;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom#getResourceFieldRef}
         * @param resourceFieldRef resource_field_ref block.
         *                         Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#resource_field_ref StatefulSet#resource_field_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder resourceFieldRef(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> resourceFieldRef) {
            this.resourceFieldRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef>)resourceFieldRef;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom#getSecretKeyRef}
         * @param secretKeyRef secret_key_ref block.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#secret_key_ref StatefulSet#secret_key_ref}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secretKeyRef(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> secretKeyRef) {
            this.secretKeyRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef>)secretKeyRef;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecContainerEnvValueFrom build() {
            return new Jsii$Proxy(configMapKeyRef, fieldRef, resourceFieldRef, secretKeyRef);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecContainerEnvValueFrom}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecContainerEnvValueFrom {
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> configMapKeyRef;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> fieldRef;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> resourceFieldRef;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> secretKeyRef;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.configMapKeyRef = software.amazon.jsii.Kernel.get(this, "configMapKeyRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef.class)));
            this.fieldRef = software.amazon.jsii.Kernel.get(this, "fieldRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef.class)));
            this.resourceFieldRef = software.amazon.jsii.Kernel.get(this, "resourceFieldRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef.class)));
            this.secretKeyRef = software.amazon.jsii.Kernel.get(this, "secretKeyRef", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> configMapKeyRef, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> fieldRef, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> resourceFieldRef, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> secretKeyRef) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.configMapKeyRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef>)configMapKeyRef;
            this.fieldRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef>)fieldRef;
            this.resourceFieldRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef>)resourceFieldRef;
            this.secretKeyRef = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef>)secretKeyRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromConfigMapKeyRef> getConfigMapKeyRef() {
            return this.configMapKeyRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromFieldRef> getFieldRef() {
            return this.fieldRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromResourceFieldRef> getResourceFieldRef() {
            return this.resourceFieldRef;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFromSecretKeyRef> getSecretKeyRef() {
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
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecContainerEnvValueFrom"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecContainerEnvValueFrom.Jsii$Proxy that = (StatefulSetSpecTemplateSpecContainerEnvValueFrom.Jsii$Proxy) o;

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
