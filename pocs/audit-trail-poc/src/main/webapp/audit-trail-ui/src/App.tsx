import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

interface Audit {
  id: number;
  timestamp: number[] | string;
  event: string;
  userId: string;
}

function App() {
  const [audits, setAudits] = useState<Audit[]>([])
  const [searchId, setSearchId] = useState('')
  const [loading, setLoading] = useState(false)

  const API_BASE_URL = 'http://localhost:8080';

  const parseTimestamp = (timestamp: number[] | string): Date => {
    if (Array.isArray(timestamp)) {
      return new Date(timestamp[0], timestamp[1] - 1, timestamp[2], timestamp[3], timestamp[4], timestamp[5]);
    }
    return new Date(timestamp);
  };

  const loadAllAudits = async () => {
    setLoading(true)
    try {
      const response = await fetch(`${API_BASE_URL}/api/audits`, {
        headers: {
          'Accept': 'application/json'
        }
      })

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }

      const data = await response.json()
      setAudits(data)
    } catch (error) {
      console.error('Error loading audits:', error)
      setAudits([])
    } finally {
      setLoading(false)
    }
  }

  const searchAuditById = async () => {
    if (!searchId.trim()) return

    setLoading(true)
    try {
      const response = await fetch(`${API_BASE_URL}/api/audits/${searchId}`, {
        headers: {
          'Accept': 'application/json'
        }
      })

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`)
      }

      const data = await response.json()
      setAudits(Array.isArray(data) ? data : [data])
    } catch (error) {
      console.error('Error searching audit:', error)
      setAudits([])
    } finally {
      setLoading(false)
    }
  }

  return (
    <>
      <h1>Audit Trail System</h1>
      <div>
        <a href="https://vite.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <div className="audit-controls">
        <button
          onClick={loadAllAudits}
          disabled={loading}
          className="audit-button"
        >
          Load All Audit Trail
        </button>

        <div className="search-container">
          <textarea
            value={searchId}
            onChange={(e) => setSearchId(e.target.value)}
            placeholder="Enter ID to search specific audit"
            rows={2}
          />
          <button
            onClick={searchAuditById}
            disabled={loading || !searchId.trim()}
            className="search-button"
          >
            Search
          </button>
        </div>
      </div>

      {loading && <p>Loading...</p>}

      {audits.length > 0 ? (
        <div className="audit-grid">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Timestamp</th>
                <th>Event</th>
                <th>User ID</th>
              </tr>
            </thead>
            <tbody>
              {audits.map((audit: Audit) => (
                <tr key={audit.id.toString()}>
                  <td>{audit.id}</td>
                  <td>{parseTimestamp(audit.timestamp).toLocaleString()}</td>
                  <td>{audit.event}</td>
                  <td>{audit.userId}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      ) : (
        <p>No audit records found</p>
      )}
    </>
  )
}

export default App