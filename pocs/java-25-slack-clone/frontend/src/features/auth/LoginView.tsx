import { useState } from "react";
import { Link, useNavigate } from "@tanstack/react-router";
import { useMutation } from "@tanstack/react-query";
import { api, ApiError } from "../../lib/apiClient";
import { setSession } from "../../lib/auth";
import type { AuthResponse } from "../../types/api";
import { Button } from "../../components/Button";

export function LoginView() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const mutation = useMutation({
    mutationFn: () => api.post<AuthResponse>("/api/auth/login", { username, password }),
    onSuccess: (response) => {
      setSession(response.token, response.user);
      navigate({ to: "/" });
    },
  });

  const error =
    mutation.error instanceof ApiError && mutation.error.status === 401
      ? "Invalid username or password"
      : mutation.isError
        ? "Something went wrong, try again"
        : null;

  return (
    <div className="auth-screen">
      <div className="auth-card">
        <div className="auth-brand">
          <span className="auth-logo">◆</span>
          <span className="auth-brand-name">Slack Clone</span>
        </div>
        <h1>Welcome back</h1>
        <p className="auth-sub">Sign in to keep the conversation going.</p>
        <form
          onSubmit={(event) => {
            event.preventDefault();
            mutation.mutate();
          }}
        >
          <label className="field">
            <span>Username</span>
            <input
              value={username}
              onChange={(event) => setUsername(event.target.value)}
              autoComplete="username"
              required
            />
          </label>
          <label className="field">
            <span>Password</span>
            <input
              type="password"
              value={password}
              onChange={(event) => setPassword(event.target.value)}
              autoComplete="current-password"
              required
            />
          </label>
          {error ? <p className="form-error">{error}</p> : null}
          <Button type="submit" disabled={mutation.isPending}>
            {mutation.isPending ? "Signing in…" : "Sign in"}
          </Button>
        </form>
        <p className="auth-switch">
          New here? <Link to="/register">Create an account</Link>
        </p>
      </div>
    </div>
  );
}
