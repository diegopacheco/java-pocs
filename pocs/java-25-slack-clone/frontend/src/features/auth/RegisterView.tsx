import { useState } from "react";
import { Link, useNavigate } from "@tanstack/react-router";
import { useMutation } from "@tanstack/react-query";
import { api, ApiError } from "../../lib/apiClient";
import { setSession } from "../../lib/auth";
import type { AuthResponse } from "../../types/api";
import { Button } from "../../components/Button";

export function RegisterView() {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [displayName, setDisplayName] = useState("");
  const [password, setPassword] = useState("");

  const mutation = useMutation({
    mutationFn: () =>
      api.post<AuthResponse>("/api/auth/register", { username, password, displayName }),
    onSuccess: (response) => {
      setSession(response.token, response.user);
      navigate({ to: "/" });
    },
  });

  const error =
    mutation.error instanceof ApiError && mutation.error.status === 409
      ? "That username is already taken"
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
        <h1>Create your account</h1>
        <p className="auth-sub">Pick a username and you are in.</p>
        <form
          onSubmit={(event) => {
            event.preventDefault();
            mutation.mutate();
          }}
        >
          <label className="field">
            <span>Display name</span>
            <input value={displayName} onChange={(event) => setDisplayName(event.target.value)} required />
          </label>
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
              autoComplete="new-password"
              required
            />
          </label>
          {error ? <p className="form-error">{error}</p> : null}
          <Button type="submit" disabled={mutation.isPending}>
            {mutation.isPending ? "Creating…" : "Create account"}
          </Button>
        </form>
        <p className="auth-switch">
          Already have an account? <Link to="/login">Sign in</Link>
        </p>
      </div>
    </div>
  );
}
