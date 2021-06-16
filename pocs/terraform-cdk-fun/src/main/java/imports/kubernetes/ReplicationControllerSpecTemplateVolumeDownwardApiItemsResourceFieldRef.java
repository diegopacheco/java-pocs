package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.870Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef extends software.amazon.jsii.JsiiSerializable {

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#container_name ReplicationController#container_name}.
     */
    @org.jetbrains.annotations.NotNull java.lang.String getContainerName();

    /**
     * Resource to select.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#resource ReplicationController#resource}
     */
    @org.jetbrains.annotations.NotNull java.lang.String getResource();

    /**
     * Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quantity ReplicationController#quantity}.
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getQuantity() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef> {
        private java.lang.String containerName;
        private java.lang.String resource;
        private java.lang.String quantity;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef#getContainerName}
         * @param containerName Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#container_name ReplicationController#container_name}. This parameter is required.
         * @return {@code this}
         */
        public Builder containerName(java.lang.String containerName) {
            this.containerName = containerName;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef#getResource}
         * @param resource Resource to select. This parameter is required.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#resource ReplicationController#resource}
         * @return {@code this}
         */
        public Builder resource(java.lang.String resource) {
            this.resource = resource;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef#getQuantity}
         * @param quantity Docs at Terraform Registry: {@link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quantity ReplicationController#quantity}.
         * @return {@code this}
         */
        public Builder quantity(java.lang.String quantity) {
            this.quantity = quantity;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef build() {
            return new Jsii$Proxy(containerName, resource, quantity);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef {
        private final java.lang.String containerName;
        private final java.lang.String resource;
        private final java.lang.String quantity;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.containerName = software.amazon.jsii.Kernel.get(this, "containerName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.resource = software.amazon.jsii.Kernel.get(this, "resource", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.quantity = software.amazon.jsii.Kernel.get(this, "quantity", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String containerName, final java.lang.String resource, final java.lang.String quantity) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.containerName = java.util.Objects.requireNonNull(containerName, "containerName is required");
            this.resource = java.util.Objects.requireNonNull(resource, "resource is required");
            this.quantity = quantity;
        }

        @Override
        public final java.lang.String getContainerName() {
            return this.containerName;
        }

        @Override
        public final java.lang.String getResource() {
            return this.resource;
        }

        @Override
        public final java.lang.String getQuantity() {
            return this.quantity;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            data.set("containerName", om.valueToTree(this.getContainerName()));
            data.set("resource", om.valueToTree(this.getResource()));
            if (this.getQuantity() != null) {
                data.set("quantity", om.valueToTree(this.getQuantity()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef.Jsii$Proxy that = (ReplicationControllerSpecTemplateVolumeDownwardApiItemsResourceFieldRef.Jsii$Proxy) o;

            if (!containerName.equals(that.containerName)) return false;
            if (!resource.equals(that.resource)) return false;
            return this.quantity != null ? this.quantity.equals(that.quantity) : that.quantity == null;
        }

        @Override
        public final int hashCode() {
            int result = this.containerName.hashCode();
            result = 31 * result + (this.resource.hashCode());
            result = 31 * result + (this.quantity != null ? this.quantity.hashCode() : 0);
            return result;
        }
    }
}
