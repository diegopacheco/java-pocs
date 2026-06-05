export function Spinner({ label }: { label?: string }) {
  return (
    <div className="spinner-wrap">
      <div className="spinner" />
      {label ? <span className="spinner-label">{label}</span> : null}
    </div>
  );
}
