package imports.kubernetes;

@javax.annotation.Generated(value = "jsii-pacmak/1.30.0 (build adae23f)", date = "2021-06-16T06:12:12.753Z")
@software.amazon.jsii.Jsii(module = imports.kubernetes.$Module.class, fqn = "kubernetes.PodSpecVolume")
@software.amazon.jsii.Jsii.Proxy(PodSpecVolume.Jsii$Proxy.class)
public interface PodSpecVolume extends software.amazon.jsii.JsiiSerializable {

    /**
     * aws_elastic_block_store block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#aws_elastic_block_store Pod#aws_elastic_block_store}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
        return null;
    }

    /**
     * azure_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#azure_disk Pod#azure_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk> getAzureDisk() {
        return null;
    }

    /**
     * azure_file block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#azure_file Pod#azure_file}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeAzureFile> getAzureFile() {
        return null;
    }

    /**
     * ceph_fs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#ceph_fs Pod#ceph_fs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCephFs> getCephFs() {
        return null;
    }

    /**
     * cinder block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#cinder Pod#cinder}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCinder> getCinder() {
        return null;
    }

    /**
     * config_map block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#config_map Pod#config_map}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeConfigMap> getConfigMap() {
        return null;
    }

    /**
     * csi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#csi Pod#csi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeCsi> getCsi() {
        return null;
    }

    /**
     * downward_api block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#downward_api Pod#downward_api}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi> getDownwardApi() {
        return null;
    }

    /**
     * empty_dir block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#empty_dir Pod#empty_dir}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir> getEmptyDir() {
        return null;
    }

    /**
     * fc block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fc Pod#fc}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeFc> getFc() {
        return null;
    }

    /**
     * flex_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#flex_volume Pod#flex_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume> getFlexVolume() {
        return null;
    }

    /**
     * flocker block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#flocker Pod#flocker}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeFlocker> getFlocker() {
        return null;
    }

    /**
     * gce_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#gce_persistent_disk Pod#gce_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
        return null;
    }

    /**
     * git_repo block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#git_repo Pod#git_repo}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeGitRepo> getGitRepo() {
        return null;
    }

    /**
     * glusterfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#glusterfs Pod#glusterfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs> getGlusterfs() {
        return null;
    }

    /**
     * host_path block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#host_path Pod#host_path}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeHostPath> getHostPath() {
        return null;
    }

    /**
     * iscsi block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#iscsi Pod#iscsi}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeIscsi> getIscsi() {
        return null;
    }

    /**
     * local block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#local Pod#local}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeLocal> getLocal() {
        return null;
    }

    /**
     * Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#name Pod#name}
     */
    default @org.jetbrains.annotations.Nullable java.lang.String getName() {
        return null;
    }

    /**
     * nfs block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#nfs Pod#nfs}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeNfs> getNfs() {
        return null;
    }

    /**
     * persistent_volume_claim block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#persistent_volume_claim Pod#persistent_volume_claim}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
        return null;
    }

    /**
     * photon_persistent_disk block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#photon_persistent_disk Pod#photon_persistent_disk}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
        return null;
    }

    /**
     * quobyte block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#quobyte Pod#quobyte}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeQuobyte> getQuobyte() {
        return null;
    }

    /**
     * rbd block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#rbd Pod#rbd}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeRbd> getRbd() {
        return null;
    }

    /**
     * secret block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#secret Pod#secret}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeSecret> getSecret() {
        return null;
    }

    /**
     * vsphere_volume block.
     * <p>
     * Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#vsphere_volume Pod#vsphere_volume}
     */
    default @org.jetbrains.annotations.Nullable java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume> getVsphereVolume() {
        return null;
    }

    /**
     * @return a {@link Builder} of {@link PodSpecVolume}
     */
    static Builder builder() {
        return new Builder();
    }
    /**
     * A builder for {@link PodSpecVolume}
     */
    public static final class Builder implements software.amazon.jsii.Builder<PodSpecVolume> {
        private java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk> azureDisk;
        private java.util.List<imports.kubernetes.PodSpecVolumeAzureFile> azureFile;
        private java.util.List<imports.kubernetes.PodSpecVolumeCephFs> cephFs;
        private java.util.List<imports.kubernetes.PodSpecVolumeCinder> cinder;
        private java.util.List<imports.kubernetes.PodSpecVolumeConfigMap> configMap;
        private java.util.List<imports.kubernetes.PodSpecVolumeCsi> csi;
        private java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi> downwardApi;
        private java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir> emptyDir;
        private java.util.List<imports.kubernetes.PodSpecVolumeFc> fc;
        private java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume> flexVolume;
        private java.util.List<imports.kubernetes.PodSpecVolumeFlocker> flocker;
        private java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private java.util.List<imports.kubernetes.PodSpecVolumeGitRepo> gitRepo;
        private java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs> glusterfs;
        private java.util.List<imports.kubernetes.PodSpecVolumeHostPath> hostPath;
        private java.util.List<imports.kubernetes.PodSpecVolumeIscsi> iscsi;
        private java.util.List<imports.kubernetes.PodSpecVolumeLocal> local;
        private java.lang.String name;
        private java.util.List<imports.kubernetes.PodSpecVolumeNfs> nfs;
        private java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private java.util.List<imports.kubernetes.PodSpecVolumeQuobyte> quobyte;
        private java.util.List<imports.kubernetes.PodSpecVolumeRbd> rbd;
        private java.util.List<imports.kubernetes.PodSpecVolumeSecret> secret;
        private java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Sets the value of {@link PodSpecVolume#getAwsElasticBlockStore}
         * @param awsElasticBlockStore aws_elastic_block_store block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#aws_elastic_block_store Pod#aws_elastic_block_store}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder awsElasticBlockStore(java.util.List<? extends imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> awsElasticBlockStore) {
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getAzureDisk}
         * @param azureDisk azure_disk block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#azure_disk Pod#azure_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureDisk(java.util.List<? extends imports.kubernetes.PodSpecVolumeAzureDisk> azureDisk) {
            this.azureDisk = (java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk>)azureDisk;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getAzureFile}
         * @param azureFile azure_file block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#azure_file Pod#azure_file}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder azureFile(java.util.List<? extends imports.kubernetes.PodSpecVolumeAzureFile> azureFile) {
            this.azureFile = (java.util.List<imports.kubernetes.PodSpecVolumeAzureFile>)azureFile;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getCephFs}
         * @param cephFs ceph_fs block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#ceph_fs Pod#ceph_fs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cephFs(java.util.List<? extends imports.kubernetes.PodSpecVolumeCephFs> cephFs) {
            this.cephFs = (java.util.List<imports.kubernetes.PodSpecVolumeCephFs>)cephFs;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getCinder}
         * @param cinder cinder block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#cinder Pod#cinder}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder cinder(java.util.List<? extends imports.kubernetes.PodSpecVolumeCinder> cinder) {
            this.cinder = (java.util.List<imports.kubernetes.PodSpecVolumeCinder>)cinder;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getConfigMap}
         * @param configMap config_map block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#config_map Pod#config_map}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder configMap(java.util.List<? extends imports.kubernetes.PodSpecVolumeConfigMap> configMap) {
            this.configMap = (java.util.List<imports.kubernetes.PodSpecVolumeConfigMap>)configMap;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getCsi}
         * @param csi csi block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#csi Pod#csi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder csi(java.util.List<? extends imports.kubernetes.PodSpecVolumeCsi> csi) {
            this.csi = (java.util.List<imports.kubernetes.PodSpecVolumeCsi>)csi;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getDownwardApi}
         * @param downwardApi downward_api block.
         *                    Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#downward_api Pod#downward_api}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder downwardApi(java.util.List<? extends imports.kubernetes.PodSpecVolumeDownwardApi> downwardApi) {
            this.downwardApi = (java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi>)downwardApi;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getEmptyDir}
         * @param emptyDir empty_dir block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#empty_dir Pod#empty_dir}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder emptyDir(java.util.List<? extends imports.kubernetes.PodSpecVolumeEmptyDir> emptyDir) {
            this.emptyDir = (java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir>)emptyDir;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getFc}
         * @param fc fc block.
         *           Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#fc Pod#fc}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder fc(java.util.List<? extends imports.kubernetes.PodSpecVolumeFc> fc) {
            this.fc = (java.util.List<imports.kubernetes.PodSpecVolumeFc>)fc;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getFlexVolume}
         * @param flexVolume flex_volume block.
         *                   Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#flex_volume Pod#flex_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flexVolume(java.util.List<? extends imports.kubernetes.PodSpecVolumeFlexVolume> flexVolume) {
            this.flexVolume = (java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume>)flexVolume;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getFlocker}
         * @param flocker flocker block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#flocker Pod#flocker}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder flocker(java.util.List<? extends imports.kubernetes.PodSpecVolumeFlocker> flocker) {
            this.flocker = (java.util.List<imports.kubernetes.PodSpecVolumeFlocker>)flocker;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getGcePersistentDisk}
         * @param gcePersistentDisk gce_persistent_disk block.
         *                          Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#gce_persistent_disk Pod#gce_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gcePersistentDisk(java.util.List<? extends imports.kubernetes.PodSpecVolumeGcePersistentDisk> gcePersistentDisk) {
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getGitRepo}
         * @param gitRepo git_repo block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#git_repo Pod#git_repo}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder gitRepo(java.util.List<? extends imports.kubernetes.PodSpecVolumeGitRepo> gitRepo) {
            this.gitRepo = (java.util.List<imports.kubernetes.PodSpecVolumeGitRepo>)gitRepo;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getGlusterfs}
         * @param glusterfs glusterfs block.
         *                  Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#glusterfs Pod#glusterfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder glusterfs(java.util.List<? extends imports.kubernetes.PodSpecVolumeGlusterfs> glusterfs) {
            this.glusterfs = (java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs>)glusterfs;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getHostPath}
         * @param hostPath host_path block.
         *                 Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#host_path Pod#host_path}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder hostPath(java.util.List<? extends imports.kubernetes.PodSpecVolumeHostPath> hostPath) {
            this.hostPath = (java.util.List<imports.kubernetes.PodSpecVolumeHostPath>)hostPath;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getIscsi}
         * @param iscsi iscsi block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#iscsi Pod#iscsi}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder iscsi(java.util.List<? extends imports.kubernetes.PodSpecVolumeIscsi> iscsi) {
            this.iscsi = (java.util.List<imports.kubernetes.PodSpecVolumeIscsi>)iscsi;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getLocal}
         * @param local local block.
         *              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#local Pod#local}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder local(java.util.List<? extends imports.kubernetes.PodSpecVolumeLocal> local) {
            this.local = (java.util.List<imports.kubernetes.PodSpecVolumeLocal>)local;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getName}
         * @param name Volume's name. Must be a DNS_LABEL and unique within the pod. More info: http://kubernetes.io/docs/user-guide/identifiers#names.
         *             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#name Pod#name}
         * @return {@code this}
         */
        public Builder name(java.lang.String name) {
            this.name = name;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getNfs}
         * @param nfs nfs block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#nfs Pod#nfs}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder nfs(java.util.List<? extends imports.kubernetes.PodSpecVolumeNfs> nfs) {
            this.nfs = (java.util.List<imports.kubernetes.PodSpecVolumeNfs>)nfs;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getPersistentVolumeClaim}
         * @param persistentVolumeClaim persistent_volume_claim block.
         *                              Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#persistent_volume_claim Pod#persistent_volume_claim}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder persistentVolumeClaim(java.util.List<? extends imports.kubernetes.PodSpecVolumePersistentVolumeClaim> persistentVolumeClaim) {
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getPhotonPersistentDisk}
         * @param photonPersistentDisk photon_persistent_disk block.
         *                             Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#photon_persistent_disk Pod#photon_persistent_disk}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder photonPersistentDisk(java.util.List<? extends imports.kubernetes.PodSpecVolumePhotonPersistentDisk> photonPersistentDisk) {
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getQuobyte}
         * @param quobyte quobyte block.
         *                Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#quobyte Pod#quobyte}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder quobyte(java.util.List<? extends imports.kubernetes.PodSpecVolumeQuobyte> quobyte) {
            this.quobyte = (java.util.List<imports.kubernetes.PodSpecVolumeQuobyte>)quobyte;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getRbd}
         * @param rbd rbd block.
         *            Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#rbd Pod#rbd}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder rbd(java.util.List<? extends imports.kubernetes.PodSpecVolumeRbd> rbd) {
            this.rbd = (java.util.List<imports.kubernetes.PodSpecVolumeRbd>)rbd;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getSecret}
         * @param secret secret block.
         *               Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#secret Pod#secret}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder secret(java.util.List<? extends imports.kubernetes.PodSpecVolumeSecret> secret) {
            this.secret = (java.util.List<imports.kubernetes.PodSpecVolumeSecret>)secret;
            return this;
        }

        /**
         * Sets the value of {@link PodSpecVolume#getVsphereVolume}
         * @param vsphereVolume vsphere_volume block.
         *                      Docs at Terraform Registry: {&#64;link https://www.terraform.io/docs/providers/kubernetes/r/pod.html#vsphere_volume Pod#vsphere_volume}
         * @return {@code this}
         */
        @SuppressWarnings("unchecked")
        public Builder vsphereVolume(java.util.List<? extends imports.kubernetes.PodSpecVolumeVsphereVolume> vsphereVolume) {
            this.vsphereVolume = (java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume>)vsphereVolume;
            return this;
        }

        /**
         * Builds the configured instance.
         * @return a new instance of {@link PodSpecVolume}
         * @throws NullPointerException if any required attribute was not provided
         */
        @Override
        public PodSpecVolume build() {
            return new Jsii$Proxy(awsElasticBlockStore, azureDisk, azureFile, cephFs, cinder, configMap, csi, downwardApi, emptyDir, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, iscsi, local, name, nfs, persistentVolumeClaim, photonPersistentDisk, quobyte, rbd, secret, vsphereVolume);
        }
    }

    /**
     * An implementation for {@link PodSpecVolume}
     */
    @software.amazon.jsii.Internal
    final class Jsii$Proxy extends software.amazon.jsii.JsiiObject implements PodSpecVolume {
        private final java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> awsElasticBlockStore;
        private final java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk> azureDisk;
        private final java.util.List<imports.kubernetes.PodSpecVolumeAzureFile> azureFile;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCephFs> cephFs;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCinder> cinder;
        private final java.util.List<imports.kubernetes.PodSpecVolumeConfigMap> configMap;
        private final java.util.List<imports.kubernetes.PodSpecVolumeCsi> csi;
        private final java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi> downwardApi;
        private final java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir> emptyDir;
        private final java.util.List<imports.kubernetes.PodSpecVolumeFc> fc;
        private final java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume> flexVolume;
        private final java.util.List<imports.kubernetes.PodSpecVolumeFlocker> flocker;
        private final java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk> gcePersistentDisk;
        private final java.util.List<imports.kubernetes.PodSpecVolumeGitRepo> gitRepo;
        private final java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs> glusterfs;
        private final java.util.List<imports.kubernetes.PodSpecVolumeHostPath> hostPath;
        private final java.util.List<imports.kubernetes.PodSpecVolumeIscsi> iscsi;
        private final java.util.List<imports.kubernetes.PodSpecVolumeLocal> local;
        private final java.lang.String name;
        private final java.util.List<imports.kubernetes.PodSpecVolumeNfs> nfs;
        private final java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim> persistentVolumeClaim;
        private final java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk> photonPersistentDisk;
        private final java.util.List<imports.kubernetes.PodSpecVolumeQuobyte> quobyte;
        private final java.util.List<imports.kubernetes.PodSpecVolumeRbd> rbd;
        private final java.util.List<imports.kubernetes.PodSpecVolumeSecret> secret;
        private final java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume> vsphereVolume;

        /**
         * Constructor that initializes the object based on values retrieved from the JsiiObject.
         * @param objRef Reference to the JSII managed object.
         */
        protected Jsii$Proxy(final software.amazon.jsii.JsiiObjectRef objRef) {
            super(objRef);
            this.awsElasticBlockStore = software.amazon.jsii.Kernel.get(this, "awsElasticBlockStore", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeAwsElasticBlockStore.class)));
            this.azureDisk = software.amazon.jsii.Kernel.get(this, "azureDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeAzureDisk.class)));
            this.azureFile = software.amazon.jsii.Kernel.get(this, "azureFile", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeAzureFile.class)));
            this.cephFs = software.amazon.jsii.Kernel.get(this, "cephFs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCephFs.class)));
            this.cinder = software.amazon.jsii.Kernel.get(this, "cinder", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCinder.class)));
            this.configMap = software.amazon.jsii.Kernel.get(this, "configMap", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeConfigMap.class)));
            this.csi = software.amazon.jsii.Kernel.get(this, "csi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeCsi.class)));
            this.downwardApi = software.amazon.jsii.Kernel.get(this, "downwardApi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeDownwardApi.class)));
            this.emptyDir = software.amazon.jsii.Kernel.get(this, "emptyDir", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeEmptyDir.class)));
            this.fc = software.amazon.jsii.Kernel.get(this, "fc", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeFc.class)));
            this.flexVolume = software.amazon.jsii.Kernel.get(this, "flexVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeFlexVolume.class)));
            this.flocker = software.amazon.jsii.Kernel.get(this, "flocker", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeFlocker.class)));
            this.gcePersistentDisk = software.amazon.jsii.Kernel.get(this, "gcePersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeGcePersistentDisk.class)));
            this.gitRepo = software.amazon.jsii.Kernel.get(this, "gitRepo", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeGitRepo.class)));
            this.glusterfs = software.amazon.jsii.Kernel.get(this, "glusterfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeGlusterfs.class)));
            this.hostPath = software.amazon.jsii.Kernel.get(this, "hostPath", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeHostPath.class)));
            this.iscsi = software.amazon.jsii.Kernel.get(this, "iscsi", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeIscsi.class)));
            this.local = software.amazon.jsii.Kernel.get(this, "local", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeLocal.class)));
            this.name = software.amazon.jsii.Kernel.get(this, "name", software.amazon.jsii.NativeType.forClass(java.lang.String.class));
            this.nfs = software.amazon.jsii.Kernel.get(this, "nfs", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeNfs.class)));
            this.persistentVolumeClaim = software.amazon.jsii.Kernel.get(this, "persistentVolumeClaim", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumePersistentVolumeClaim.class)));
            this.photonPersistentDisk = software.amazon.jsii.Kernel.get(this, "photonPersistentDisk", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumePhotonPersistentDisk.class)));
            this.quobyte = software.amazon.jsii.Kernel.get(this, "quobyte", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeQuobyte.class)));
            this.rbd = software.amazon.jsii.Kernel.get(this, "rbd", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeRbd.class)));
            this.secret = software.amazon.jsii.Kernel.get(this, "secret", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeSecret.class)));
            this.vsphereVolume = software.amazon.jsii.Kernel.get(this, "vsphereVolume", software.amazon.jsii.NativeType.listOf(software.amazon.jsii.NativeType.forClass(imports.kubernetes.PodSpecVolumeVsphereVolume.class)));
        }

        /**
         * Constructor that initializes the object based on literal property values passed by the {@link Builder}.
         */
        @SuppressWarnings("unchecked")
        protected Jsii$Proxy(final java.util.List<? extends imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> awsElasticBlockStore, final java.util.List<? extends imports.kubernetes.PodSpecVolumeAzureDisk> azureDisk, final java.util.List<? extends imports.kubernetes.PodSpecVolumeAzureFile> azureFile, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCephFs> cephFs, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCinder> cinder, final java.util.List<? extends imports.kubernetes.PodSpecVolumeConfigMap> configMap, final java.util.List<? extends imports.kubernetes.PodSpecVolumeCsi> csi, final java.util.List<? extends imports.kubernetes.PodSpecVolumeDownwardApi> downwardApi, final java.util.List<? extends imports.kubernetes.PodSpecVolumeEmptyDir> emptyDir, final java.util.List<? extends imports.kubernetes.PodSpecVolumeFc> fc, final java.util.List<? extends imports.kubernetes.PodSpecVolumeFlexVolume> flexVolume, final java.util.List<? extends imports.kubernetes.PodSpecVolumeFlocker> flocker, final java.util.List<? extends imports.kubernetes.PodSpecVolumeGcePersistentDisk> gcePersistentDisk, final java.util.List<? extends imports.kubernetes.PodSpecVolumeGitRepo> gitRepo, final java.util.List<? extends imports.kubernetes.PodSpecVolumeGlusterfs> glusterfs, final java.util.List<? extends imports.kubernetes.PodSpecVolumeHostPath> hostPath, final java.util.List<? extends imports.kubernetes.PodSpecVolumeIscsi> iscsi, final java.util.List<? extends imports.kubernetes.PodSpecVolumeLocal> local, final java.lang.String name, final java.util.List<? extends imports.kubernetes.PodSpecVolumeNfs> nfs, final java.util.List<? extends imports.kubernetes.PodSpecVolumePersistentVolumeClaim> persistentVolumeClaim, final java.util.List<? extends imports.kubernetes.PodSpecVolumePhotonPersistentDisk> photonPersistentDisk, final java.util.List<? extends imports.kubernetes.PodSpecVolumeQuobyte> quobyte, final java.util.List<? extends imports.kubernetes.PodSpecVolumeRbd> rbd, final java.util.List<? extends imports.kubernetes.PodSpecVolumeSecret> secret, final java.util.List<? extends imports.kubernetes.PodSpecVolumeVsphereVolume> vsphereVolume) {
            super(software.amazon.jsii.JsiiObject.InitializationMode.JSII);
            this.awsElasticBlockStore = (java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore>)awsElasticBlockStore;
            this.azureDisk = (java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk>)azureDisk;
            this.azureFile = (java.util.List<imports.kubernetes.PodSpecVolumeAzureFile>)azureFile;
            this.cephFs = (java.util.List<imports.kubernetes.PodSpecVolumeCephFs>)cephFs;
            this.cinder = (java.util.List<imports.kubernetes.PodSpecVolumeCinder>)cinder;
            this.configMap = (java.util.List<imports.kubernetes.PodSpecVolumeConfigMap>)configMap;
            this.csi = (java.util.List<imports.kubernetes.PodSpecVolumeCsi>)csi;
            this.downwardApi = (java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi>)downwardApi;
            this.emptyDir = (java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir>)emptyDir;
            this.fc = (java.util.List<imports.kubernetes.PodSpecVolumeFc>)fc;
            this.flexVolume = (java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume>)flexVolume;
            this.flocker = (java.util.List<imports.kubernetes.PodSpecVolumeFlocker>)flocker;
            this.gcePersistentDisk = (java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk>)gcePersistentDisk;
            this.gitRepo = (java.util.List<imports.kubernetes.PodSpecVolumeGitRepo>)gitRepo;
            this.glusterfs = (java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs>)glusterfs;
            this.hostPath = (java.util.List<imports.kubernetes.PodSpecVolumeHostPath>)hostPath;
            this.iscsi = (java.util.List<imports.kubernetes.PodSpecVolumeIscsi>)iscsi;
            this.local = (java.util.List<imports.kubernetes.PodSpecVolumeLocal>)local;
            this.name = name;
            this.nfs = (java.util.List<imports.kubernetes.PodSpecVolumeNfs>)nfs;
            this.persistentVolumeClaim = (java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim>)persistentVolumeClaim;
            this.photonPersistentDisk = (java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk>)photonPersistentDisk;
            this.quobyte = (java.util.List<imports.kubernetes.PodSpecVolumeQuobyte>)quobyte;
            this.rbd = (java.util.List<imports.kubernetes.PodSpecVolumeRbd>)rbd;
            this.secret = (java.util.List<imports.kubernetes.PodSpecVolumeSecret>)secret;
            this.vsphereVolume = (java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume>)vsphereVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeAwsElasticBlockStore> getAwsElasticBlockStore() {
            return this.awsElasticBlockStore;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeAzureDisk> getAzureDisk() {
            return this.azureDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeAzureFile> getAzureFile() {
            return this.azureFile;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCephFs> getCephFs() {
            return this.cephFs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCinder> getCinder() {
            return this.cinder;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeConfigMap> getConfigMap() {
            return this.configMap;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeCsi> getCsi() {
            return this.csi;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeDownwardApi> getDownwardApi() {
            return this.downwardApi;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeEmptyDir> getEmptyDir() {
            return this.emptyDir;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeFc> getFc() {
            return this.fc;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeFlexVolume> getFlexVolume() {
            return this.flexVolume;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeFlocker> getFlocker() {
            return this.flocker;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeGcePersistentDisk> getGcePersistentDisk() {
            return this.gcePersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeGitRepo> getGitRepo() {
            return this.gitRepo;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeGlusterfs> getGlusterfs() {
            return this.glusterfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeHostPath> getHostPath() {
            return this.hostPath;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeIscsi> getIscsi() {
            return this.iscsi;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeLocal> getLocal() {
            return this.local;
        }

        @Override
        public final java.lang.String getName() {
            return this.name;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeNfs> getNfs() {
            return this.nfs;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumePersistentVolumeClaim> getPersistentVolumeClaim() {
            return this.persistentVolumeClaim;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumePhotonPersistentDisk> getPhotonPersistentDisk() {
            return this.photonPersistentDisk;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeQuobyte> getQuobyte() {
            return this.quobyte;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeRbd> getRbd() {
            return this.rbd;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeSecret> getSecret() {
            return this.secret;
        }

        @Override
        public final java.util.List<imports.kubernetes.PodSpecVolumeVsphereVolume> getVsphereVolume() {
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
            struct.set("fqn", om.valueToTree("kubernetes.PodSpecVolume"));
            struct.set("data", data);

            final com.fasterxml.jackson.databind.node.ObjectNode obj = com.fasterxml.jackson.databind.node.JsonNodeFactory.instance.objectNode();
            obj.set("$jsii.struct", struct);

            return obj;
        }

        @Override
        public final boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PodSpecVolume.Jsii$Proxy that = (PodSpecVolume.Jsii$Proxy) o;

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
