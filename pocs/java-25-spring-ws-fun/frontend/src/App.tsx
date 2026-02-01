import { useState, useEffect, useRef } from 'react'
import './index.css'

interface PrimeNumber {
  value: number
  timestamp: number
}

interface ChatMessage {
  nickname: string
  content: string
  timestamp: number
}

function App() {
  const [nickname, setNickname] = useState('')
  const [isJoined, setIsJoined] = useState(false)
  const [connected, setConnected] = useState(false)
  const [primes, setPrimes] = useState<PrimeNumber[]>([])
  const [messages, setMessages] = useState<ChatMessage[]>([])
  const [inputMessage, setInputMessage] = useState('')
  const [nicknameInput, setNicknameInput] = useState('')
  const primeWsRef = useRef<WebSocket | null>(null)
  const chatWsRef = useRef<WebSocket | null>(null)
  const messagesEndRef = useRef<HTMLDivElement>(null)
  const primesEndRef = useRef<HTMLDivElement>(null)

  useEffect(() => {
    if (!isJoined) return

    const wsProtocol = window.location.protocol === 'https:' ? 'wss:' : 'ws:'
    const host = window.location.host

    const primeWs = new WebSocket(`${wsProtocol}//${host}/ws/primes`)
    primeWsRef.current = primeWs

    primeWs.onopen = () => {
      setConnected(true)
    }

    primeWs.onmessage = (event) => {
      const data = JSON.parse(event.data)
      if (data.type === 'history') {
        setPrimes(data.primes)
      } else {
        setPrimes(prev => [...prev, data])
      }
    }

    primeWs.onclose = () => {
      setConnected(false)
    }

    const chatWs = new WebSocket(`${wsProtocol}//${host}/ws/chat`)
    chatWsRef.current = chatWs

    chatWs.onmessage = (event) => {
      const msg: ChatMessage = JSON.parse(event.data)
      setMessages(prev => [...prev, msg])
    }

    return () => {
      primeWs.close()
      chatWs.close()
    }
  }, [isJoined])

  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({ behavior: 'smooth' })
  }, [messages])

  useEffect(() => {
    primesEndRef.current?.scrollIntoView({ behavior: 'smooth' })
  }, [primes])

  const handleJoin = () => {
    if (nicknameInput.trim()) {
      setNickname(nicknameInput.trim())
      setIsJoined(true)
    }
  }

  const handleSendMessage = () => {
    if (inputMessage.trim() && chatWsRef.current?.readyState === WebSocket.OPEN) {
      chatWsRef.current.send(JSON.stringify({
        nickname,
        content: inputMessage,
        timestamp: Date.now()
      }))
      setInputMessage('')
    }
  }

  const handleKeyPress = (e: React.KeyboardEvent) => {
    if (e.key === 'Enter') {
      handleSendMessage()
    }
  }

  const formatTime = (ts: number) => {
    return new Date(ts).toLocaleTimeString()
  }

  if (!isJoined) {
    return (
      <div className="container">
        <h1>Prime Discovery Chat</h1>
        <div className="nickname-setup">
          <h2>Enter your nickname to join</h2>
          <br /><br />
          <input
            type="text"
            placeholder="Your nickname"
            value={nicknameInput}
            onChange={(e) => setNicknameInput(e.target.value)}
            onKeyPress={(e) => e.key === 'Enter' && handleJoin()}
          />
          <button onClick={handleJoin}>Join</button>
        </div>
      </div>
    )
  }

  return (
    <div className="container">
      <h1>Prime Discovery Chat</h1>
      <div className={`status ${connected ? 'connected' : 'disconnected'}`}>
        {connected ? 'Connected' : 'Disconnected'} - Welcome, {nickname}!
      </div>
      <div className="panels">
        <div className="panel">
          <h2>Prime Numbers Discovered</h2>
          <div className="prime-count">Total: {primes.length}</div>
          <div className="prime-list">
            {primes.map((p, i) => (
              <span key={i} className="prime-item">{p.value}</span>
            ))}
            <div ref={primesEndRef} />
          </div>
        </div>
        <div className="panel">
          <h2>Chat Room</h2>
          <div className="chat-messages">
            {messages.map((m, i) => (
              <div key={i} className="chat-message">
                <span className="nickname">{m.nickname}:</span>
                <span>{m.content}</span>
                <span className="time">{formatTime(m.timestamp)}</span>
              </div>
            ))}
            <div ref={messagesEndRef} />
          </div>
          <div className="chat-input-area">
            <input
              type="text"
              placeholder="Type a message..."
              value={inputMessage}
              onChange={(e) => setInputMessage(e.target.value)}
              onKeyPress={handleKeyPress}
            />
            <button onClick={handleSendMessage}>Send</button>
          </div>
        </div>
      </div>
    </div>
  )
}

export default App
