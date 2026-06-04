import {
  createRootRoute,
  createRoute,
  createRouter,
  Link,
  Outlet,
} from '@tanstack/react-router'
import Dashboard from './routes/dashboard'
import Logs from './routes/logs'
import Replay from './routes/replay'

function Layout() {
  return (
    <div className="app">
      <header className="topbar">
        <div className="brand">
          <span className="brand-dot" />
          <div>
            <h1>Traffic Record &amp; Replay</h1>
            <p>capture &middot; inspect &middot; replay</p>
          </div>
        </div>
        <nav className="tabs">
          <Link to="/" className="tab" activeProps={{ className: 'tab active' }} activeOptions={{ exact: true }}>
            Dashboard
          </Link>
          <Link to="/logs" className="tab" activeProps={{ className: 'tab active' }}>
            Traffic Log
          </Link>
          <Link to="/replay" className="tab" activeProps={{ className: 'tab active' }}>
            Replay
          </Link>
        </nav>
      </header>
      <main className="content">
        <Outlet />
      </main>
    </div>
  )
}

const rootRoute = createRootRoute({ component: Layout })
const dashboardRoute = createRoute({ getParentRoute: () => rootRoute, path: '/', component: Dashboard })
const logsRoute = createRoute({ getParentRoute: () => rootRoute, path: '/logs', component: Logs })
const replayRoute = createRoute({ getParentRoute: () => rootRoute, path: '/replay', component: Replay })

const routeTree = rootRoute.addChildren([dashboardRoute, logsRoute, replayRoute])

export const router = createRouter({ routeTree })

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router
  }
}
