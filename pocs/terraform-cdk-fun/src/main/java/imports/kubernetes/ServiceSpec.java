package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.882Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ServiceSpec")
@software.amazon.jsii.Jsii.Proxy(ServiceSpec.Jsii$Proxy.class)
public interface ServiceSpec extends software.amazon.jsii.JsiiSerializable {

    /**
     * The IP address of the service.
     * <p>
     * It is usually assigned randomly by the master. If an address is specified manually and is not in use by others, it will be allocated to the service; otherwise, creation of the service will fail. <code>None</code> can be specified for headless services when proxying is not required. Ignored if type is <code>ExternalName</code>. More info: http://kubernetes.io/docs/user-guide/services#virtual-ips-and-service-proxies
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#cluster_ip Service#cluster_ip}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getClusterIp() {
        return null;
    }

    /**
     * A list of IP addresses for which nodes in the cluster will also accept traffic for this service.
     * <p>
     * These IPs are not managed by Kubernetes. The user is responsible for ensuring that traffic arrives at a node with this IP.  A common example is external load-balancers that are not part of the Kubernetes system.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_ips Service#external_ips}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getExternalIps() {
        return null;
    }

    /**
     * The external reference that kubedns or equivalent will return as a CNAME record for this service.
     * <p>
     * No proxying will be involved. Must be a valid DNS name and requires <code>type</code> to be <code>ExternalName</code>.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_name Service#external_name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getExternalName() {
        return null;
    }

    /**
     * Denotes if this Service desires to route external traffic to node-local or cluster-wide endpoints.
     * <p>
     * <code>Local</code> preserves the client source IP and avoids a second hop for LoadBalancer and Nodeport type services, but risks potentially imbalanced traffic spreading. <code>Cluster</code> obscures the client source IP and may cause a second hop to another node, but should have good overall load-spreading. More info: https://kubernetes.io/docs/tutorials/services/source-ip/
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_traffic_policy Service#external_traffic_policy}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getExternalTrafficPolicy() {
        return null;
    }

    /**
     * Only applies to `type = LoadBalancer`.
     * <p>
     * LoadBalancer will get created with the IP specified in this field. This feature depends on whether the underlying cloud-provider supports specifying this field when a load balancer is created. This field will be ignored if the cloud-provider does not support the feature.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#load_balancer_ip Service#load_balancer_ip}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getLoadBalancerIp() {
        return null;
    }

    /**
     * If specified and supported by the platform, this will restrict traffic through the cloud-provider load-balancer will be restricted to the specified client IPs.
     * <p>
     * This field will be ignored if the cloud-provider does not support the feature. More info: http://kubernetes.io/docs/user-guide/services-firewalls
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#load_balancer_source_ranges Service#load_balancer_source_ranges}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<java.lang.String> getLoadBalancerSourceRanges() {
        return null;
    }

    /**
     * port block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#port Service#port}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ServiceSpecPort> getPort() {
        return null;
    }

    /**
     * When set to true, indicates that DNS implementations must publish the `notReadyAddresses` of subsets for the Endpoints associated with the Service.
     * <p>
     * The default value is <code>false</code>. The primary use case for setting this field is to use a StatefulSet's Headless Service to propagate <code>SRV</code> records for its Pods without respect to their readiness for purpose of peer discovery.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#publish_not_ready_addresses Service#publish_not_ready_addresses}
     */
    default @org.jetbrains.annotations.Nullable java.lang.Boolean getPublishNotReadyAddresses() {
        return null;
    }

    /**
     * Route service traffic to pods with label keys and values matching this selector.
     * <p>
     * Only applies to types <code>ClusterIP</code>, <code>NodePort</code>, and <code>LoadBalancer</code>. More info: http://kubernetes.io/docs/user-guide/services#overview
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#selector Service#selector}
     */
    default @org.jetbrains.annotations.Nullable java.util.Map<java.lang.String, java.lang.String> getSelector() {
        return null;
    }

    /**
     * Used to maintain session affinity. Supports `ClientIP` and `None`. Defaults to `None`. More info: http://kubernetes.io/docs/user-guide/services#virtual-ips-and-service-proxies.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#session_affinity Service#session_affinity}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getSessionAffinity() {
        return null;
    }

    /**
     * Determines how the service is exposed.
     * <p>
     * Defaults to <code>ClusterIP</code>. Valid options are <code>ExternalName</code>, <code>ClusterIP</code>, <code>NodePort</code>, and <code>LoadBalancer</code>. <code>ExternalName</code> maps to the specified <code>external_name</code>. More info: http://kubernetes.io/docs/user-guide/services#overview
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#type Service#type}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getType() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ServiceSpec}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ServiceSpec}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ServiceSpec> {
        private java.lang.String clusterIp;
        private java.util.List<java.lang.String> externalIps;
        private java.lang.String externalName;
        private java.lang.String externalTrafficPolicy;
        private java.lang.String loadBalancerIp;
        private java.util.List<java.lang.String> loadBalancerSourceRanges;
        private java.util.List<imports.kubernetes.ServiceSpecPort> port;
        private java.lang.Boolean publishNotReadyAddresses;
        private java.util.Map<java.lang.String, java.lang.String> selector;
        private java.lang.String sessionAffinity;
        private java.lang.String type;

        /**
         * Sets the value of {@link ServiceSpec#getClusterIp}
         * @param clusterIp The IP address of the service.
         *                  It is usually assigned randomly by the master. If an address is specified manually and is not in use by others, it will be allocated to the service; otherwise, creation of the service will fail. <code>None</code> can be specified for headless services when proxying is not required. Ignored if type is <code>ExternalName</code>. More info: http://kubernetes.io/docs/user-guide/services#virtual-ips-and-service-proxies
         *                  <p>
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#cluster_ip Service#cluster_ip}
         * @return {@code this}
         */
        public Builder clusterIp(java.lang.String clusterIp) {
            this.clusterIp = clusterIp;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getExternalIps}
         * @param externalIps A list of IP addresses for which nodes in the cluster will also accept traffic for this service.
         *                    These IPs are not managed by Kubernetes. The user is responsible for ensuring that traffic arrives at a node with this IP.  A common example is external load-balancers that are not part of the Kubernetes system.
         *                    <p>
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_ips Service#external_ips}
         * @return {@code this}
         */
        public Builder externalIps(java.util.List<java.lang.String> externalIps) {
            this.externalIps = externalIps;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getExternalName}
         * @param externalName The external reference that kubedns or equivalent will return as a CNAME record for this service.
         *                     No proxying will be involved. Must be a valid DNS name and requires <code>type</code> to be <code>ExternalName</code>.
         *                     <p>
         *                     Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_name Service#external_name}
         * @return {@code this}
         */
        public Builder externalName(java.lang.String externalName) {
            this.externalName = externalName;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getExternalTrafficPolicy}
         * @param externalTrafficPolicy Denotes if this Service desires to route external traffic to node-local or cluster-wide endpoints.
         *                              <code>Local</code> preserves the client source IP and avoids a second hop for LoadBalancer and Nodeport type services, but risks potentially imbalanced traffic spreading. <code>Cluster</code> obscures the client source IP and may cause a second hop to another node, but should have good overall load-spreading. More info: https://kubernetes.io/docs/tutorials/services/source-ip/
         *                              <p>
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#external_traffic_policy Service#external_traffic_policy}
         * @return {@code this}
         */
        public Builder externalTrafficPolicy(java.lang.String externalTrafficPolicy) {
            this.externalTrafficPolicy = externalTrafficPolicy;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getLoadBalancerIp}
         * @param loadBalancerIp Only applies to `type = LoadBalancer`.
         *                       LoadBalancer will get created with the IP specified in this field. This feature depends on whether the underlying cloud-provider supports specifying this field when a load balancer is created. This field will be ignored if the cloud-provider does not support the feature.
         *                       <p>
         *                       Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#load_balancer_ip Service#load_balancer_ip}
         * @return {@code this}
         */
        public Builder loadBalancerIp(java.lang.String loadBalancerIp) {
            this.loadBalancerIp = loadBalancerIp;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getLoadBalancerSourceRanges}
         * @param loadBalancerSourceRanges If specified and supported by the platform, this will restrict traffic through the cloud-provider load-balancer will be restricted to the specified client IPs.
         *                                 This field will be ignored if the cloud-provider does not support the feature. More info: http://kubernetes.io/docs/user-guide/services-firewalls
         *                                 <p>
         *                                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#load_balancer_source_ranges Service#load_balancer_source_ranges}
         * @return {@code this}
         */
        public Builder loadBalancerSourceRanges(java.util.List<java.lang.String> loadBalancerSourceRanges) {
            this.loadBalancerSourceRanges = loadBalancerSourceRanges;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getPort}
         * @param port port block.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#port Service#port}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder port(java.util.List<? extends imports.kubernetes.ServiceSpecPort> port) {
            this.port = (java.util.List<imports.kubernetes.ServiceSpecPort>)port;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getPublishNotReadyAddresses}
         * @param publishNotReadyAddresses When set to true, indicates that DNS implementations must publish the `notReadyAddresses` of subsets for the Endpoints associated with the Service.
         *                                 The default value is <code>false</code>. The primary use case for setting this field is to use a StatefulSet's Headless Service to propagate <code>SRV</code> records for its Pods without respect to their readiness for purpose of peer discovery.
         *                                 <p>
         *                                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#publish_not_ready_addresses Service#publish_not_ready_addresses}
         * @return {@code this}
         */
        public Builder publishNotReadyAddresses(java.lang.Boolean publishNotReadyAddresses) {
            this.publishNotReadyAddresses = publishNotReadyAddresses;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getSelector}
         * @param selector Route service traffic to pods with label keys and values matching this selector.
         *                 Only applies to types <code>ClusterIP</code>, <code>NodePort</code>, and <code>LoadBalancer</code>. More info: http://kubernetes.io/docs/user-guide/services#overview
         *                 <p>
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#selector Service#selector}
         * @return {@code this}
         */
        public Builder selector(java.util.Map<java.lang.String, java.lang.String> selector) {
            this.selector = selector;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getSessionAffinity}
         * @param sessionAffinity Used to maintain session affinity. Supports `ClientIP` and `None`. Defaults to `None`. More info: http://kubernetes.io/docs/user-guide/services#virtual-ips-and-service-proxies.
         *                        Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#session_affinity Service#session_affinity}
         * @return {@code this}
         */
        public Builder sessionAffinity(java.lang.String sessionAffinity) {
            this.sessionAffinity = sessionAffinity;
            return this;
        }

        /**
         * Sets the value of {@link ServiceSpec#getType}
         * @param type Determines how the service is exposed.
         *             Defaults to <code>ClusterIP</code>. Valid options are <code>ExternalName</code>, <code>ClusterIP</code>, <code>NodePort</code>, and <code>LoadBalancer</code>. <code>ExternalName</code> maps to the specified <code>external_name</code>. More info: http://kubernetes.io/docs/user-guide/services#overview
         *             <p>
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/service.html#type Service#type}
         * @return {@code this}
         */
        public Builder type(java.lang.String type) {
            this.type = type;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ServiceSpec}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ServiceSpec build() {
            return new Jsii$Proxy(clusterIp, externalIps, externalName, externalTrafficPolicy, loadBalancerIp, loadBalancerSourceRanges, port, publishNotReadyAddresses, selector, sessionAffinity, type);
        }
    }

    /**
     * An implementation for {@link ServiceSpec}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ServiceSpec {
        private final java.lang.String clusterIp;
        private final java.util.List<java.lang.String> externalIps;
        private final java.lang.String externalName;
        private final java.lang.String externalTrafficPolicy;
        private final java.lang.String loadBalancerIp;
        private final java.util.List<java.lang.String> loadBalancerSourceRanges;
        private final java.util.List<imports.kubernetes.ServiceSpecPort> port;
        private final java.lang.Boolean publishNotReadyAddresses;
        private final java.util.Map<java.lang.String, java.lang.String> selector;
        private final java.lang.String sessionAffinity;
        private final java.lang.String type;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.clusterIp = software.amazon.jsii.Kernel.get(this, "clusterIp", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.externalIps = software.amazon.jsii.Kernel.get(this, "externalIps", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.externalName = software.amazon.jsii.Kernel.get(this, "externalName", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.externalTrafficPolicy = software.amazon.jsii.Kernel.get(this, "externalTrafficPolicy", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.loadBalancerIp = software.amazon.jsii.Kernel.get(this, "loadBalancerIp", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.loadBalancerSourceRanges = software.amazon.jsii.Kernel.get(this, "loadBalancerSourceRanges", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.port = software.amazon.jsii.Kernel.get(this, "port", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ServiceSpecPort.class)));
            this.publishNotReadyAddresses = software.amazon.jsii.Kernel.get(this, "publishNotReadyAddresses", software.amazon.jsii.NativeType.forClass(java.lang.Boolean.class));
            this.selector = software.amazon.jsii.Kernel.get(this, "selector", software.amazon.jsii.NativeType.mapOf(software.amazon.jsii.NativeType.forClass(java.lang.String.class)));
            this.sessionAffinity = software.amazon.jsii.Kernel.get(this, "sessionAffinity", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.type = software.amazon.jsii.Kernel.get(this, "type", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.lang.String clusterIp, final java.util.List<java.lang.String> externalIps, final java.lang.String externalName, final java.lang.String externalTrafficPolicy, final java.lang.String loadBalancerIp, final java.util.List<java.lang.String> loadBalancerSourceRanges, final java.util.List<? extends imports.kubernetes.ServiceSpecPort> port, final java.lang.Boolean publishNotReadyAddresses, final java.util.Map<java.lang.String, java.lang.String> selector, final java.lang.String sessionAffinity, final java.lang.String type) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.clusterIp = clusterIp;
            this.externalIps = externalIps;
            this.externalName = externalName;
            this.externalTrafficPolicy = externalTrafficPolicy;
            this.loadBalancerIp = loadBalancerIp;
            this.loadBalancerSourceRanges = loadBalancerSourceRanges;
            this.port = (java.util.List<imports.kubernetes.ServiceSpecPort>)port;
            this.publishNotReadyAddresses = publishNotReadyAddresses;
            this.selector = selector;
            this.sessionAffinity = sessionAffinity;
            this.type = type;
        }

        @Override
        public final java.lang.String getClusterIp() {
            return this.clusterIp;
        }

        @Override
        public final java.util.List<java.lang.String> getExternalIps() {
            return this.externalIps;
        }

        @Override
        public final java.lang.String getExternalName() {
            return this.externalName;
        }

        @Override
        public final java.lang.String getExternalTrafficPolicy() {
            return this.externalTrafficPolicy;
        }

        @Override
        public final java.lang.String getLoadBalancerIp() {
            return this.loadBalancerIp;
        }

        @Override
        public final java.util.List<java.lang.String> getLoadBalancerSourceRanges() {
            return this.loadBalancerSourceRanges;
        }

        @Override
        public final java.util.List<imports.kubernetes.ServiceSpecPort> getPort() {
            return this.port;
        }

        @Override
        public final java.lang.Boolean getPublishNotReadyAddresses() {
            return this.publishNotReadyAddresses;
        }

        @Override
        public final java.util.Map<java.lang.String, java.lang.String> getSelector() {
            return this.selector;
        }

        @Override
        public final java.lang.String getSessionAffinity() {
            return this.sessionAffinity;
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

            if (this.getClusterIp() != null) {
                data.set("clusterIp", om.valueToTree(this.getClusterIp()));
            }
            if (this.getExternalIps() != null) {
                data.set("externalIps", om.valueToTree(this.getExternalIps()));
            }
            if (this.getExternalName() != null) {
                data.set("externalName", om.valueToTree(this.getExternalName()));
            }
            if (this.getExternalTrafficPolicy() != null) {
                data.set("externalTrafficPolicy", om.valueToTree(this.getExternalTrafficPolicy()));
            }
            if (this.getLoadBalancerIp() != null) {
                data.set("loadBalancerIp", om.valueToTree(this.getLoadBalancerIp()));
            }
            if (this.getLoadBalancerSourceRanges() != null) {
                data.set("loadBalancerSourceRanges", om.valueToTree(this.getLoadBalancerSourceRanges()));
            }
            if (this.getPort() != null) {
                data.set("port", om.valueToTree(this.getPort()));
            }
            if (this.getPublishNotReadyAddresses() != null) {
                data.set("publishNotReadyAddresses", om.valueToTree(this.getPublishNotReadyAddresses()));
            }
            if (this.getSelector() != null) {
                data.set("selector", om.valueToTree(this.getSelector()));
            }
            if (this.getSessionAffinity() != null) {
                data.set("sessionAffinity", om.valueToTree(this.getSessionAffinity()));
            }
            if (this.getType() != null) {
                data.set("type", om.valueToTree(this.getType()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ServiceSpec"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ServiceSpec.Jsii$Proxy that = (ServiceSpec.Jsii$Proxy) o;

            if (this.clusterIp != null ? !this.clusterIp.equals(that.clusterIp) : that.clusterIp != null) return false;
            if (this.externalIps != null ? !this.externalIps.equals(that.externalIps) : that.externalIps != null) return false;
            if (this.externalName != null ? !this.externalName.equals(that.externalName) : that.externalName != null) return false;
            if (this.externalTrafficPolicy != null ? !this.externalTrafficPolicy.equals(that.externalTrafficPolicy) : that.externalTrafficPolicy != null) return false;
            if (this.loadBalancerIp != null ? !this.loadBalancerIp.equals(that.loadBalancerIp) : that.loadBalancerIp != null) return false;
            if (this.loadBalancerSourceRanges != null ? !this.loadBalancerSourceRanges.equals(that.loadBalancerSourceRanges) : that.loadBalancerSourceRanges != null) return false;
            if (this.port != null ? !this.port.equals(that.port) : that.port != null) return false;
            if (this.publishNotReadyAddresses != null ? !this.publishNotReadyAddresses.equals(that.publishNotReadyAddresses) : that.publishNotReadyAddresses != null) return false;
            if (this.selector != null ? !this.selector.equals(that.selector) : that.selector != null) return false;
            if (this.sessionAffinity != null ? !this.sessionAffinity.equals(that.sessionAffinity) : that.sessionAffinity != null) return false;
            return this.type != null ? this.type.equals(that.type) : that.type == null;
        }

        @Override
        public final int hashCode() {
            int result = this.clusterIp != null ? this.clusterIp.hashCode() : 0;
            result = 31 * result + (this.externalIps != null ? this.externalIps.hashCode() : 0);
            result = 31 * result + (this.externalName != null ? this.externalName.hashCode() : 0);
            result = 31 * result + (this.externalTrafficPolicy != null ? this.externalTrafficPolicy.hashCode() : 0);
            result = 31 * result + (this.loadBalancerIp != null ? this.loadBalancerIp.hashCode() : 0);
            result = 31 * result + (this.loadBalancerSourceRanges != null ? this.loadBalancerSourceRanges.hashCode() : 0);
            result = 31 * result + (this.port != null ? this.port.hashCode() : 0);
            result = 31 * result + (this.publishNotReadyAddresses != null ? this.publishNotReadyAddresses.hashCode() : 0);
            result = 31 * result + (this.selector != null ? this.selector.hashCode() : 0);
            result = 31 * result + (this.sessionAffinity != null ? this.sessionAffinity.hashCode() : 0);
            result = 31 * result + (this.type != null ? this.type.hashCode() : 0);
            return result;
        }
    }
}
