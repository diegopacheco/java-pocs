package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.860Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.ReplicationControllerSpecTemplateVolume")
@software.amazon.jsii.Jsii.Proxy(ReplicationControllerSpecTemplateVolume.Jsii$Proxy.class)
public interface ReplicationControllerSpecTemplateVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#aws_elastic_block_store ReplicationController#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_disk ReplicationController#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_file ReplicationController#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_fs ReplicationController#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#cinder ReplicationController#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#config_map ReplicationController#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#csi ReplicationController#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#downward_api ReplicationController#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#empty_dir ReplicationController#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fc ReplicationController#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flex_volume ReplicationController#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flocker ReplicationController#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#gce_persistent_disk ReplicationController#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#git_repo ReplicationController#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#glusterfs ReplicationController#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#host_path ReplicationController#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#iscsi ReplicationController#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#local ReplicationController#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> getLocal() {
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
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#persistent_volume_claim ReplicationController#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#photon_persistent_disk ReplicationController#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quobyte ReplicationController#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd ReplicationController#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret ReplicationController#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#vsphere_volume ReplicationController#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link ReplicationControllerSpecTemplateVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link ReplicationControllerSpecTemplateVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<ReplicationControllerSpecTemplateVolume> {
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> csi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> fc;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> secret;
        private java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#aws_elastic_block_store ReplicationController#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_disk ReplicationController#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#azure_file ReplicationController#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#ceph_fs ReplicationController#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#cinder ReplicationController#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#config_map ReplicationController#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#csi ReplicationController#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#downward_api ReplicationController#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#empty_dir ReplicationController#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#fc ReplicationController#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flex_volume ReplicationController#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#flocker ReplicationController#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#gce_persistent_disk ReplicationController#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#git_repo ReplicationController#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#glusterfs ReplicationController#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#host_path ReplicationController#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#iscsi ReplicationController#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#local ReplicationController#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#name ReplicationController#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#nfs ReplicationController#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#persistent_volume_claim ReplicationController#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#photon_persistent_disk ReplicationController#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#quobyte ReplicationController#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#rbd ReplicationController#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#secret ReplicationController#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link ReplicationControllerSpecTemplateVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/replication_controller.html#vsphere_volume ReplicationController#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link ReplicationControllerSpecTemplateVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public ReplicationControllerSpecTemplateVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link ReplicationControllerSpecTemplateVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements ReplicationControllerSpecTemplateVolume {
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> fc;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> fc, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.ReplicationControllerSpecTemplateVolumeVsphereVolume> getVsphereVolume() {
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
            struct.set("fqn", om.valueToTree("kubernetes.ReplicationControllerSpecTemplateVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ReplicationControllerSpecTemplateVolume.Jsii$Proxy that = (ReplicationControllerSpecTemplateVolume.Jsii$Proxy) o;

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
