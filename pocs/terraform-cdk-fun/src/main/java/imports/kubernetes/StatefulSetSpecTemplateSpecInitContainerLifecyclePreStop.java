package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.938Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop extends software.amazon.jsii.JsiiSerializable {

    /**
     * exec block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#exec StatefulSet#exec}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> getExec() {
        return null;
    }

    /**
     * http_get block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_get StatefulSet#http_get}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> getHttpGet() {
        return null;
    }

    /**
     * tcp_socket block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#tcp_socket StatefulSet#tcp_socket}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> getTcpSocket() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop> {
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> exec;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> httpGet;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> tcpSocket;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop#getExec}
         * @param exec exec block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#exec StatefulSet#exec}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder exec(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> exec) {
            this.exec = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec>)exec;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop#getHttpGet}
         * @param httpGet http_get block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_get StatefulSet#http_get}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder httpGet(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> httpGet) {
            this.httpGet = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet>)httpGet;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop#getTcpSocket}
         * @param tcpSocket tcp_socket block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#tcp_socket StatefulSet#tcp_socket}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder tcpSocket(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> tcpSocket) {
            this.tcpSocket = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket>)tcpSocket;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop build() {
            return new Jsii$Proxy(exec, httpGet, tcpSocket);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop {
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> exec;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> httpGet;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> tcpSocket;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.exec = software.amazon.jsii.Kernel.get(this, "exec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec.class)));
            this.httpGet = software.amazon.jsii.Kernel.get(this, "httpGet", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet.class)));
            this.tcpSocket = software.amazon.jsii.Kernel.get(this, "tcpSocket", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> exec, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> httpGet, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> tcpSocket) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.exec = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec>)exec;
            this.httpGet = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet>)httpGet;
            this.tcpSocket = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket>)tcpSocket;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopExec> getExec() {
            return this.exec;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopHttpGet> getHttpGet() {
            return this.httpGet;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStopTcpSocket> getTcpSocket() {
            return this.tcpSocket;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getExec() != null) {
                data.set("exec", om.valueToTree(this.getExec()));
            }
            if (this.getHttpGet() != null) {
                data.set("httpGet", om.valueToTree(this.getHttpGet()));
            }
            if (this.getTcpSocket() != null) {
                data.set("tcpSocket", om.valueToTree(this.getTcpSocket()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop.Jsii$Proxy that = (StatefulSetSpecTemplateSpecInitContainerLifecyclePreStop.Jsii$Proxy) o;

            if (this.exec != null ? !this.exec.equals(that.exec) : that.exec != null) return false;
            if (this.httpGet != null ? !this.httpGet.equals(that.httpGet) : that.httpGet != null) return false;
            return this.tcpSocket != null ? this.tcpSocket.equals(that.tcpSocket) : that.tcpSocket == null;
        }

        @Override
        public final int hashCode() {
            int result = this.exec != null ? this.exec.hashCode() : 0;
            result = 31 * result + (this.httpGet != null ? this.httpGet.hashCode() : 0);
            result = 31 * result + (this.tcpSocket != null ? this.tcpSocket.hashCode() : 0);
            return result;
        }
    }
}
