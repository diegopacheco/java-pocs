package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.871Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateVolumeFlocker")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateVolumeFlocker.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateVolumeFlocker extends software.amazon.jsii.JsiiSerializable {

    /**
     * Name of the dataset stored as metadata -> name on the dataset for Flocker should be considered as deprecated.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#dataset_name ReplicationController#dataset_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDatasetName() {
        return null;
    }

    /**
     * UUID of the dataset. This is unique identifier of a Flocker dataset.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#dataset_uuid ReplicationController#dataset_uuid}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getDatasetUuid() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateVolumeFlocker}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateVolumeFlocker}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateVolumeFlocker> {
        private java.lang.String datasetName;
        private java.lang.String datasetUuid;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolumeFlocker#getDatasetName}
         * @param datasetName Name of the dataset stored as metadata -> name on the dataset for Flocker should be considered as deprecated.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#dataset_name ReplicationController#dataset_name}
         * @return {@code this}
         */
        public Builder datasetName(java.lang.String datasetName) {
            this.datasetName = datasetName;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolumeFlocker#getDatasetUuid}
         * @param datasetUuid UUID of the dataset. This is unique identifier of a Flocker dataset.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#dataset_uuid ReplicationController#dataset_uuid}
         * @return {@code this}
         */
        public Builder datasetUuid(java.lang.String datasetUuid) {
            this.datasetUuid = datasetUuid;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateVolumeFlocker}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateVolumeFlocker build() {
            return new Jsii$Proxy(datasetName, datasetUuid);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateVolumeFlocker}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateVolumeFlocker {
        private final java.lang.String datasetName;
        private final java.lang.String datasetUuid;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.datasetName = software.amazon.jsii.Kernel.get(this, "datasetName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.datasetUuid = software.amazon.jsii.Kernel.get(this, "datasetUuid", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.lang.String datasetName, final java.lang.String datasetUuid) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.datasetName = datasetName;
            this.datasetUuid = datasetUuid;
        }

        @Override
        public final java.lang.String getDatasetName() {
            return this.datasetName;
        }

        @Override
        public final java.lang.String getDatasetUuid() {
            return this.datasetUuid;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getDatasetName() != null) {
                data.set("datasetName", om.valueToTree(this.getDatasetName()));
            }
            if (this.getDatasetUuid() != null) {
                data.set("datasetUuid", om.valueToTree(this.getDatasetUuid()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateVolumeFlocker"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateVolumeFlocker.Jsii$Proxy that = (ReplicationControllerSpecTemplateVolumeFlocker.Jsii$Proxy) o;

            if (this.datasetName != null ? !this.datasetName.equals(that.datasetName) : that.datasetName != null) return false;
            return this.datasetUuid != null ? this.datasetUuid.equals(that.datasetUuid) : that.datasetUuid == null;
        }

        @Override
        public final int hashCode() {
            int result = this.datasetName != null ? this.datasetName.hashCode() : 0;
            result = 31 * result + (this.datasetUuid != null ? this.datasetUuid.hashCode() : 0);
            return result;
        }
    }
}
