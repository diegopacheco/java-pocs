interface ImportMetaEnv {
  readonly VITE_API_URL?: string
  readonly VITE_PROXY_URL?: string
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
