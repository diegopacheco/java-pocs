package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.845Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateSpecVolume")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateSpecVolume.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateSpecVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#aws_elastic_block_store ReplicationController#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_disk ReplicationController#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_file ReplicationController#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_fs ReplicationController#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#cinder ReplicationController#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#config_map ReplicationController#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#csi ReplicationController#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#downward_api ReplicationController#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#empty_dir ReplicationController#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fc ReplicationController#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flex_volume ReplicationController#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flocker ReplicationController#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#gce_persistent_disk ReplicationController#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#git_repo ReplicationController#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#glusterfs ReplicationController#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#host_path ReplicationController#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#iscsi ReplicationController#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#local ReplicationController#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> getLocal() {
        return null;
    }

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#name ReplicationController#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#nfs ReplicationController#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#persistent_volume_claim ReplicationController#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#photon_persistent_disk ReplicationController#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quobyte ReplicationController#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd ReplicationController#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret ReplicationController#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#vsphere_volume ReplicationController#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateSpecVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateSpecVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateSpecVolume> {
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> csi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> fc;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> secret;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#aws_elastic_block_store ReplicationController#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_disk ReplicationController#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_file ReplicationController#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_fs ReplicationController#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#cinder ReplicationController#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#config_map ReplicationController#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#csi ReplicationController#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#downward_api ReplicationController#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#empty_dir ReplicationController#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fc ReplicationController#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flex_volume ReplicationController#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flocker ReplicationController#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#gce_persistent_disk ReplicationController#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#git_repo ReplicationController#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#glusterfs ReplicationController#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#host_path ReplicationController#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#iscsi ReplicationController#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#local ReplicationController#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#name ReplicationController#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#nfs ReplicationController#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#persistent_volume_claim ReplicationController#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#photon_persistent_disk ReplicationController#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quobyte ReplicationController#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd ReplicationController#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret ReplicationController#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateSpecVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#vsphere_volume ReplicationController#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateSpecVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateSpecVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateSpecVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateSpecVolume {
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> fc;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> fc, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
            return this.vsphereVolume;
        }

        @Override
        @software.amazon.jsii.Internal
        public com.fasterxml.jackson.databind.JsonNode $jsii$toJson() {
            final com.fasterxml.jackson.databind.ObjectMapper om = software.amazon.jsii.JsiiObjectMapper.INSTANCE;
            final com.fasterxml.jackson.databind.node.ObjectNode data = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();

            if (this.getAwsElasticBlockStore() != null) {
                data.set("awsElasticBlockStore", om.valueToTree(this.getAwsElasticBlockStore()));
            }
            if (this.getAzureDisk() != null) {
                data.set("azureDisk", om.valueToTree(this.getAzureDisk()));
            }
            if (this.getAzureFile() != null) {
                data.set("azureFile", om.valueToTree(this.getAzureFile()));
            }
            if (this.getCephFs() != null) {
                data.set("cephFs", om.valueToTree(this.getCephFs()));
            }
            if (this.getCinder() != null) {
                data.set("cinder", om.valueToTree(this.getCinder()));
            }
            if (this.getConfigMap() != null) {
                data.set("configMap", om.valueToTree(this.getConfigMap()));
            }
            if (this.getCsi() != null) {
                data.set("csi", om.valueToTree(this.getCsi()));
            }
            if (this.getDownwardApi() != null) {
                data.set("downwardApi", om.valueToTree(this.getDownwardApi()));
            }
            if (this.getEmptyDir() != null) {
                data.set("emptyDir", om.valueToTree(this.getEmptyDir()));
            }
            if (this.getFc() != null) {
                data.set("fc", om.valueToTree(this.getFc()));
            }
            if (this.getFlexVolume() != null) {
                data.set("flexVolume", om.valueToTree(this.getFlexVolume()));
            }
            if (this.getFlocker() != null) {
                data.set("flocker", om.valueToTree(this.getFlocker()));
            }
            if (this.getGcePersistentDisk() != null) {
                data.set("gcePersistentDisk", om.valueToTree(this.getGcePersistentDisk()));
            }
            if (this.getGitRepo() != null) {
                data.set("gitRepo", om.valueToTree(this.getGitRepo()));
            }
            if (this.getGlusterfs() != null) {
                data.set("glusterfs", om.valueToTree(this.getGlusterfs()));
            }
            if (this.getHostPath() != null) {
                data.set("hostPath", om.valueToTree(this.getHostPath()));
            }
            if (this.getIscsi() != null) {
                data.set("iscsi", om.valueToTree(this.getIscsi()));
            }
            if (this.getLocal() != null) {
                data.set("local", om.valueToTree(this.getLocal()));
            }
            if (this.getName() != null) {
                data.set("name", om.valueToTree(this.getName()));
            }
            if (this.getNfs() != null) {
                data.set("nfs", om.valueToTree(this.getNfs()));
            }
            if (this.getPersistentVolumeClaim() != null) {
                data.set("persistentVolumeClaim", om.valueToTree(this.getPersistentVolumeClaim()));
            }
            if (this.getPhotonPersistentDisk() != null) {
                data.set("photonPersistentDisk", om.valueToTree(this.getPhotonPersistentDisk()));
            }
            if (this.getQuobyte() != null) {
                data.set("quobyte", om.valueToTree(this.getQuobyte()));
            }
            if (this.getRbd() != null) {
                data.set("rbd", om.valueToTree(this.getRbd()));
            }
            if (this.getSecret() != null) {
                data.set("secret", om.valueToTree(this.getSecret()));
            }
            if (this.getVsphereVolume() != null) {
                data.set("vsphereVolume", om.valueToTree(this.getVsphereVolume()));
            }

            final com.fasterxml.jackson.databind.node.ObjectNode struct = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateSpecVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateSpecVolume.Jsii$Proxy that = (ReplicationControllerSpecTemplateSpecVolume.Jsii$Proxy) o;

            if (this.awsElasticBlockStore != null ? !this.awsElasticBlockStore.equals(that.awsElasticBlockStore) : that.awsElasticBlockStore != null) return false;
            if (this.azureDisk != null ? !this.azureDisk.equals(that.azureDisk) : that.azureDisk != null) return false;
            if (this.azureFile != null ? !this.azureFile.equals(that.azureFile) : that.azureFile != null) return false;
            if (this.cephFs != null ? !this.cephFs.equals(that.cephFs) : that.cephFs != null) return false;
            if (this.cinder != null ? !this.cinder.equals(that.cinder) : that.cinder != null) return false;
            if (this.configMap != null ? !this.configMap.equals(that.configMap) : that.configMap != null) return false;
            if (this.csi != null ? !this.csi.equals(that.csi) : that.csi != null) return false;
            if (this.downwardApi != null ? !this.downwardApi.equals(that.downwardApi) : that.downwardApi != null) return false;
            if (this.emptyDir != null ? !this.emptyDir.equals(that.emptyDir) : that.emptyDir != null) return false;
            if (this.fc != null ? !this.fc.equals(that.fc) : that.fc != null) return false;
            if (this.flexVolume != null ? !this.flexVolume.equals(that.flexVolume) : that.flexVolume != null) return false;
            if (this.flocker != null ? !this.flocker.equals(that.flocker) : that.flocker != null) return false;
            if (this.gcePersistentDisk != null ? !this.gcePersistentDisk.equals(that.gcePersistentDisk) : that.gcePersistentDisk != null) return false;
            if (this.gitRepo != null ? !this.gitRepo.equals(that.gitRepo) : that.gitRepo != null) return false;
            if (this.glusterfs != null ? !this.glusterfs.equals(that.glusterfs) : that.glusterfs != null) return false;
            if (this.hostPath != null ? !this.hostPath.equals(that.hostPath) : that.hostPath != null) return false;
            if (this.iscsi != null ? !this.iscsi.equals(that.iscsi) : that.iscsi != null) return false;
            if (this.local != null ? !this.local.equals(that.local) : that.local != null) return false;
            if (this.name != null ? !this.name.equals(that.name) : that.name != null) return false;
            if (this.nfs != null ? !this.nfs.equals(that.nfs) : that.nfs != null) return false;
            if (this.persistentVolumeClaim != null ? !this.persistentVolumeClaim.equals(that.persistentVolumeClaim) : that.persistentVolumeClaim != null) return false;
            if (this.photonPersistentDisk != null ? !this.photonPersistentDisk.equals(that.photonPersistentDisk) : that.photonPersistentDisk != null) return false;
            if (this.quobyte != null ? !this.quobyte.equals(that.quobyte) : that.quobyte != null) return false;
            if (this.rbd != null ? !this.rbd.equals(that.rbd) : that.rbd != null) return false;
            if (this.secret != null ? !this.secret.equals(that.secret) : that.secret != null) return false;
            return this.vsphereVolume != null ? this.vsphereVolume.equals(that.vsphereVolume) : that.vsphereVolume == null;
        }

        @Override
        public final int hashCode() {
            int result = this.awsElasticBlockStore != null ? this.awsElasticBlockStore.hashCode() : 0;
            result = 31 * result + (this.azureDisk != null ? this.azureDisk.hashCode() : 0);
            result = 31 * result + (this.azureFile != null ? this.azureFile.hashCode() : 0);
            result = 31 * result + (this.cephFs != null ? this.cephFs.hashCode() : 0);
            result = 31 * result + (this.cinder != null ? this.cinder.hashCode() : 0);
            result = 31 * result + (this.configMap != null ? this.configMap.hashCode() : 0);
            result = 31 * result + (this.csi != null ? this.csi.hashCode() : 0);
            result = 31 * result + (this.downwardApi != null ? this.downwardApi.hashCode() : 0);
            result = 31 * result + (this.emptyDir != null ? this.emptyDir.hashCode() : 0);
            result = 31 * result + (this.fc != null ? this.fc.hashCode() : 0);
            result = 31 * result + (this.flexVolume != null ? this.flexVolume.hashCode() : 0);
            result = 31 * result + (this.flocker != null ? this.flocker.hashCode() : 0);
            result = 31 * result + (this.gcePersistentDisk != null ? this.gcePersistentDisk.hashCode() : 0);
            result = 31 * result + (this.gitRepo != null ? this.gitRepo.hashCode() : 0);
            result = 31 * result + (this.glusterfs != null ? this.glusterfs.hashCode() : 0);
            result = 31 * result + (this.hostPath != null ? this.hostPath.hashCode() : 0);
            result = 31 * result + (this.iscsi != null ? this.iscsi.hashCode() : 0);
            result = 31 * result + (this.local != null ? this.local.hashCode() : 0);
            result = 31 * result + (this.name != null ? this.name.hashCode() : 0);
            result = 31 * result + (this.nfs != null ? this.nfs.hashCode() : 0);
            result = 31 * result + (this.persistentVolumeClaim != null ? this.persistentVolumeClaim.hashCode() : 0);
            result = 31 * result + (this.photonPersistentDisk != null ? this.photonPersistentDisk.hashCode() : 0);
            result = 31 * result + (this.quobyte != null ? this.quobyte.hashCode() : 0);
            result = 31 * result + (this.rbd != null ? this.rbd.hashCode() : 0);
            result = 31 * result + (this.secret != null ? this.secret.hashCode() : 0);
            result = 31 * result + (this.vsphereVolume != null ? this.vsphereVolume.hashCode() : 0);
            return result;
        }
    }
}
