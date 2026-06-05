import type { ButtonHTMLAttributes } from "react";

type Variant = "primary" | "ghost" | "danger" | "subtle";

interface ButtonProps extends ButtonHTMLAttributes<HTMLButtonElement> {
  variant?: Variant;
}

export function Button({ variant = "primary", className = "", ...props }: ButtonProps) {
  return <button className={`btn btn-${variant} ${className}`.trim()} {...props} />;
}
