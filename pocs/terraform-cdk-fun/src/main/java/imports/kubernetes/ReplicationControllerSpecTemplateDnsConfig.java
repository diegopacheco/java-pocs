package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.791Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateDnsConfig")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateDnsConfig.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateDnsConfig extends software.amazon.jsii.JsiiSerializable {

    /**
     * A list of DNS name server IP addresses.
     * <p>
     * This will be appended to the base nameservers generated from DNSPolicy. Duplicated nameservers will be removed.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#nameservers ReplicationController#nameservers}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getNameservers() {
        return null;
    }

    /**
     * option block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#option ReplicationController#option}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> getOption() {
        return null;
    }

    /**
     * A list of DNS search domains for host-name lookup.
     * <p>
     * This will be appended to the base search paths generated from DNSPolicy. Duplicated search paths will be removed.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#searches ReplicationController#searches}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getSearches() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateDnsConfig}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateDnsConfig}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateDnsConfig> {
        private java.util.List<java.lang.String> nameservers;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> option;
        private java.util.List<java.lang.String> searches;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateDnsConfig#getNameservers}
         * @param nameservers A list of DNS name server IP addresses.
         *                    This will be appended to the base nameservers generated from DNSPolicy. Duplicated nameservers will be removed.
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#nameservers ReplicationController#nameservers}
         * @return {@code this}
         */
        public Builder nameservers(java.util.List<java.lang.String> nameservers) {
            this.nameservers = nameservers;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateDnsConfig#getOption}
         * @param option option block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#option ReplicationController#option}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder option(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> option) {
            this.option = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption>)option;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateDnsConfig#getSearches}
         * @param searches A list of DNS search domains for host-name lookup.
         *                 This will be appended to the base search paths generated from DNSPolicy. Duplicated search paths will be removed.
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#searches ReplicationController#searches}
         * @return {@code this}
         */
        public Builder searches(java.util.List<java.lang.String> searches) {
            this.searches = searches;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateDnsConfig}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateDnsConfig build() {
            return new Jsii$Proxy(nameservers, option, searches);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateDnsConfig}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateDnsConfig {
        private final java.util.List<java.lang.String> nameservers;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> option;
        private final java.util.List<java.lang.String> searches;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.nameservers = software.amazon.jsii.Kernel.get(this, "nameservers", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.option = software.amazon.jsii.Kernel.get(this, "option", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption.class)));
            this.searches = software.amazon.jsii.Kernel.get(this, "searches", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<java.lang.String> nameservers, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> option, final java.util.List<java.lang.String> searches) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.nameservers = nameservers;
            this.option = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption>)option;
            this.searches = searches;
        }

        @Override
        public final java.util.List<java.lang.String> getNameservers() {
            return this.nameservers;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateDnsConfigOption> getOption() {
            return this.option;
        }

        @Override
        public final java.util.List<java.lang.String> getSearches() {
            return this.searches;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getNameservers() != null) {
                data.set("nameservers", om.valueToTree(this.getNameservers()));
            }
            if (this.getOption() != null) {
                data.set("option", om.valueToTree(this.getOption()));
            }
            if (this.getSearches() != null) {
                data.set("searches", om.valueToTree(this.getSearches()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateDnsConfig"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateDnsConfig.Jsii$Proxy that = (ReplicationControllerSpecTemplateDnsConfig.Jsii$Proxy) o;

            if (this.nameservers != null ? !this.nameservers.equals(that.nameservers) : that.nameservers != null) return false;
            if (this.option != null ? !this.option.equals(that.option) : that.option != null) return false;
            return this.searches != null ? this.searches.equals(that.searches) : that.searches == null;
        }

        @Override
        public final int hashCode() {
            int result = this.nameservers != null ? this.nameservers.hashCode() : 0;
            result = 31 * result + (this.option != null ? this.option.hashCode() : 0);
            result = 31 * result + (this.searches != null ? this.searches.hashCode() : 0);
            return result;
        }
    }
}
