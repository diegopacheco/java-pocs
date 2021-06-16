package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.937Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart extends software.amazon.jsii.JsiiSerializable {

    /**
     * exec block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#exec StatefulSet#exec}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> getExec() {
        return null;
    }

    /**
     * http_get block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_get StatefulSet#http_get}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> getHttpGet() {
        return null;
    }

    /**
     * tcp_socket block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#tcp_socket StatefulSet#tcp_socket}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> getTcpSocket() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart> {
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> exec;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> httpGet;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> tcpSocket;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart#getExec}
         * @param exec exec block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#exec StatefulSet#exec}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder exec(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> exec) {
            this.exec = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec>)exec;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart#getHttpGet}
         * @param httpGet http_get block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#http_get StatefulSet#http_get}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder httpGet(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> httpGet) {
            this.httpGet = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet>)httpGet;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart#getTcpSocket}
         * @param tcpSocket tcp_socket block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#tcp_socket StatefulSet#tcp_socket}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder tcpSocket(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> tcpSocket) {
            this.tcpSocket = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket>)tcpSocket;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart build() {
            return new Jsii$Proxy(exec, httpGet, tcpSocket);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart {
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> exec;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> httpGet;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> tcpSocket;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.exec = software.amazon.jsii.Kernel.get(this, "exec", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec.class)));
            this.httpGet = software.amazon.jsii.Kernel.get(this, "httpGet", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet.class)));
            this.tcpSocket = software.amazon.jsii.Kernel.get(this, "tcpSocket", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> exec, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> httpGet, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> tcpSocket) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.exec = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec>)exec;
            this.httpGet = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet>)httpGet;
            this.tcpSocket = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket>)tcpSocket;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartExec> getExec() {
            return this.exec;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartHttpGet> getHttpGet() {
            return this.httpGet;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStartTcpSocket> getTcpSocket() {
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
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart.Jsii$Proxy that = (StatefulSetSpecTemplateSpecInitContainerLifecyclePostStart.Jsii$Proxy) o;

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
