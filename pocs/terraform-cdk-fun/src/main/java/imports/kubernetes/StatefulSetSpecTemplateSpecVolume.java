package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.947Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.StatefulSetSpecTemplateSpecVolume")
@software.amazon.jsii.Jsii.Proxy(StatefulSetSpecTemplateSpecVolume.Jsii$Proxy.class)
public interface StatefulSetSpecTemplateSpecVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#aws_elastic_block_store StatefulSet#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#azure_disk StatefulSet#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#azure_file StatefulSet#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#ceph_fs StatefulSet#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#cinder StatefulSet#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#config_map StatefulSet#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#csi StatefulSet#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#downward_api StatefulSet#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#empty_dir StatefulSet#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#fc StatefulSet#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#flex_volume StatefulSet#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#flocker StatefulSet#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#gce_persistent_disk StatefulSet#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#git_repo StatefulSet#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#glusterfs StatefulSet#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_path StatefulSet#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#iscsi StatefulSet#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#local StatefulSet#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> getLocal() {
        return null;
    }

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#name StatefulSet#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#nfs StatefulSet#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#persistent_volume_claim StatefulSet#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#photon_persistent_disk StatefulSet#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#quobyte StatefulSet#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#rbd StatefulSet#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#secret StatefulSet#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#vsphere_volume StatefulSet#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link StatefulSetSpecTemplateSpecVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link StatefulSetSpecTemplateSpecVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<StatefulSetSpecTemplateSpecVolume> {
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> csi;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> fc;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> secret;
        private java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#aws_elastic_block_store StatefulSet#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#azure_disk StatefulSet#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#azure_file StatefulSet#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#ceph_fs StatefulSet#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#cinder StatefulSet#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#config_map StatefulSet#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#csi StatefulSet#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#downward_api StatefulSet#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#empty_dir StatefulSet#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#fc StatefulSet#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#flex_volume StatefulSet#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#flocker StatefulSet#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#gce_persistent_disk StatefulSet#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#git_repo StatefulSet#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#glusterfs StatefulSet#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#host_path StatefulSet#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#iscsi StatefulSet#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#local StatefulSet#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#name StatefulSet#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#nfs StatefulSet#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#persistent_volume_claim StatefulSet#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#photon_persistent_disk StatefulSet#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#quobyte StatefulSet#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#rbd StatefulSet#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#secret StatefulSet#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link StatefulSetSpecTemplateSpecVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/stateful_set.html#vsphere_volume StatefulSet#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link StatefulSetSpecTemplateSpecVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public StatefulSetSpecTemplateSpecVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link StatefulSetSpecTemplateSpecVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements StatefulSetSpecTemplateSpecVolume {
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> fc;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> fc, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.StatefulSetSpecTemplateSpecVolumeVsphereVolume> getVsphereVolume() {
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
            struct.set("fqn", om.valueToTree("kubernetes.StatefulSetSpecTemplateSpecVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StatefulSetSpecTemplateSpecVolume.Jsii$Proxy that = (StatefulSetSpecTemplateSpecVolume.Jsii$Proxy) o;

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
