import { createRootRoute, createRoute, createRouter, redirect, Outlet } from "@tanstack/react-router";
import { getToken } from "../lib/auth";
import { LoginView } from "../features/auth/LoginView";
import { RegisterView } from "../features/auth/RegisterView";
import { AppLayout } from "./AppLayout";
import { WelcomeView } from "../features/channels/WelcomeView";
import { ChannelView } from "../features/messages/ChannelView";

const rootRoute = createRootRoute({ component: () => <Outlet /> });

const loginRoute = createRoute({
  getParentRoute: () => rootRoute,
  path: "/login",
  component: LoginView,
});

const registerRoute = createRoute({
  getParentRoute: () => rootRoute,
  path: "/register",
  component: RegisterView,
});

const appRoute = createRoute({
  getParentRoute: () => rootRoute,
  id: "app",
  beforeLoad: () => {
    if (!getToken()) {
      throw redirect({ to: "/login" });
    }
  },
  component: AppLayout,
});

const indexRoute = createRoute({
  getParentRoute: () => appRoute,
  path: "/",
  component: WelcomeView,
});

const channelRoute = createRoute({
  getParentRoute: () => appRoute,
  path: "/c/$channelId",
  component: ChannelView,
});

const routeTree = rootRoute.addChildren([
  loginRoute,
  registerRoute,
  appRoute.addChildren([indexRoute, channelRoute]),
]);

export const router = createRouter({ routeTree });

declare module "@tanstack/react-router" {
  interface Register {
    router: typeof router;
  }
}
