package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.665Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.LimitRangeSpecLimit")
@software.amazon.jsii.Jsii.Proxy(LimitRangeSpecLimit.Jsii$Proxy.class)
public interface LimitRangeSpecLimit extends software.amazon.jsii.JsiiSerializable {

    /**
     * Default resource requirement limit value by resource name if resource limit is omitted.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#default LimitRange#default}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getDefaultValue() {
        return null;
    }

    /**
     * The default resource requirement request value by resource name if resource request is omitted.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#default_request LimitRange#default_request}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getDefaultRequest() {
        return null;
    }

    /**
     * Max usage constraints on this kind by resource name.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#max LimitRange#max}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getMax() {
        return null;
    }

    /**
     * The named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value;
     * <p>
     * this represents the max burst for the named resource.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#max_limit_request_ratio LimitRange#max_limit_request_ratio}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getMaxLimitRequestRatio() {
        return null;
    }

    /**
     * Min usage constraints on this kind by resource name.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#min LimitRange#min}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getMin() {
        return null;
    }

    /**
     * Type of resource that this limit applies to.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#type LimitRange#type}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getType() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link LimitRangeSpecLimit}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link LimitRangeSpecLimit}
     */
    public static final class Builder implements software.amazon.jsii.Builder<LimitRangeSpecLimit> {
        private java.util.Map<java.lang.String, java.lang.String> defaultValue;
        private java.util.Map<java.lang.String, java.lang.String> defaultRequest;
        private java.util.Map<java.lang.String, java.lang.String> max;
        private java.util.Map<java.lang.String, java.lang.String> maxLimitRequestRatio;
        private java.util.Map<java.lang.String, java.lang.String> min;
        private java.lang.String type;

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getDefaultValue}
         * @param defaultValue Default resource requirement limit value by resource name if resource limit is omitted.
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#default LimitRange#default}
         * @return {@code this}
         */
        public Builder defaultValue(java.util.Map<java.lang.String, java.lang.String> defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getDefaultRequest}
         * @param defaultRequest The default resource requirement request value by resource name if resource request is omitted.
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#default_request LimitRange#default_request}
         * @return {@code this}
         */
        public Builder defaultRequest(java.util.Map<java.lang.String, java.lang.String> defaultRequest) {
            this.defaultRequest = defaultRequest;
            return this;
        }

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getMax}
         * @param max Max usage constraints on this kind by resource name.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#max LimitRange#max}
         * @return {@code this}
         */
        public Builder max(java.util.Map<java.lang.String, java.lang.String> max) {
            this.max = max;
            return this;
        }

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getMaxLimitRequestRatio}
         * @param maxLimitRequestRatio The named resource must have a request and limit that are both non-zero where limit divided by request is less than or equal to the enumerated value;.
         *                             this represents the max burst for the named resource.
         *                             <p>
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#max_limit_request_ratio LimitRange#max_limit_request_ratio}
         * @return {@code this}
         */
        public Builder maxLimitRequestRatio(java.util.Map<java.lang.String, java.lang.String> maxLimitRequestRatio) {
            this.maxLimitRequestRatio = maxLimitRequestRatio;
            return this;
        }

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getMin}
         * @param min Min usage constraints on this kind by resource name.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#min LimitRange#min}
         * @return {@code this}
         */
        public Builder min(java.util.Map<java.lang.String, java.lang.String> min) {
            this.min = min;
            return this;
        }

        /**
         * Sets the value of {@link LimitRangeSpecLimit#getType}
         * @param type Type of resource that this limit applies to.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/limit_range.html#type LimitRange#type}
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link LimitRangeSpecLimit}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public LimitRangeSpecLimit build() {
            return new Jsii$Proxy(defaultValue, defaultRequest, max, maxLimitRequestRatio, min, type);
        }
    }

    /**
     * An implementation for {@link LimitRangeSpecLimit}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements LimitRangeSpecLimit {
        private final java.util.Map<java.lang.String, java.lang.String> defaultValue;
        private final java.util.Map<java.lang.String, java.lang.String> defaultRequest;
        private final java.util.Map<java.lang.String, java.lang.String> max;
        private final java.util.Map<java.lang.String, java.lang.String> maxLimitRequestRatio;
        private final java.util.Map<java.lang.String, java.lang.String> min;
        private final java.lang.String type;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.defaultValue = software.amazon.jsii.Kernel.get(this, "default", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.defaultRequest = software.amazon.jsii.Kernel.get(this, "defaultRequest", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.max = software.amazon.jsii.Kernel.get(this, "max", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.maxLimitRequestRatio = software.amazon.jsii.Kernel.get(this, "maxLimitRequestRatio", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.min = software.amazon.jsii.Kernel.get(this, "min", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        protected Jsii$Proxy(final java.util.Map<java.lang.String, java.lang.String> defaultValue, final java.util.Map<java.lang.String, java.lang.String> defaultRequest, final java.util.Map<java.lang.String, java.lang.String> max, final java.util.Map<java.lang.String, java.lang.String> maxLimitRequestRatio, final java.util.Map<java.lang.String, java.lang.String> min, final java.lang.String type) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.defaultValue = defaultValue;
            this.defaultRequest = defaultRequest;
            this.max = max;
            this.maxLimitRequestRatio = maxLimitRequestRatio;
            this.min = min;
            this.type = type;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getDefaultValue() {
            return this.defaultValue;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getDefaultRequest() {
            return this.defaultRequest;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getMax() {
            return this.max;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getMaxLimitRequestRatio() {
            return this.maxLimitRequestRatio;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getMin() {
            return this.min;
        }

        @Override
        public final java.lang.String getType() {
            return this.type;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getDefaultValue() != null) {
                data.set("default", om.valueToTree(this.getDefaultValue()));
            }
            if (this.getDefaultRequest() != null) {
                data.set("defaultRequest", om.valueToTree(this.getDefaultRequest()));
            }
            if (this.getMax() != null) {
                data.set("max", om.valueToTree(this.getMax()));
            }
            if (this.getMaxLimitRequestRatio() != null) {
                data.set("maxLimitRequestRatio", om.valueToTree(this.getMaxLimitRequestRatio()));
            }
            if (this.getMin() != null) {
                data.set("min", om.valueToTree(this.getMin()));
            }
            if (this.getType() != null) {
                data.set("type", om.valueToTree(this.getType()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.LimitRangeSpecLimit"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            LimitRangeSpecLimit.Jsii$Proxy that = (LimitRangeSpecLimit.Jsii$Proxy) o;

            if (this.defaultValue != null ? !this.defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
            if (this.defaultRequest != null ? !this.defaultRequest.equals(that.defaultRequest) : that.defaultRequest != null) return false;
            if (this.max != null ? !this.max.equals(that.max) : that.max != null) return false;
            if (this.maxLimitRequestRatio != null ? !this.maxLimitRequestRatio.equals(that.maxLimitRequestRatio) : that.maxLimitRequestRatio != null) return false;
            if (this.min != null ? !this.min.equals(that.min) : that.min != null) return false;
            return this.type != null ? this.type.equals(that.type) : that.type == null;
        }

        @Override
        public final int hashCode() {
            int result = this.defaultValue != null ? this.defaultValue.hashCode() : 0;
            result = 31 * result + (this.defaultRequest != null ? this.defaultRequest.hashCode() : 0);
            result = 31 * result + (this.max != null ? this.max.hashCode() : 0);
            result = 31 * result + (this.maxLimitRequestRatio != null ? this.maxLimitRequestRatio.hashCode() : 0);
            result = 31 * result + (this.min != null ? this.min.hashCode() : 0);
            result = 31 * result + (this.type != null ? this.type.hashCode() : 0);
            return result;
        }
    }
}
