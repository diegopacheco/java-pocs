const planets = [
  { name: 'Mercury', year: '88 days', radius: '2,440 km', distance: '57.9m km', orbit: .12, size: 4, color: '#8a8275' },
  { name: 'Venus', year: '224.7 days', radius: '6,052 km', distance: '108.2m km', orbit: .18, size: 7, color: '#c79a52' },
  { name: 'Earth', year: '365.25 days', radius: '6,371 km', distance: '149.6m km', orbit: .25, size: 8, color: '#397e9c' },
  { name: 'Mars', year: '687 days', radius: '3,390 km', distance: '227.9m km', orbit: .33, size: 6, color: '#bd573c' },
  { name: 'Jupiter', year: '11.86 years', radius: '69,911 km', distance: '778.5m km', orbit: .48, size: 19, color: '#c3986d' },
  { name: 'Saturn', year: '29.45 years', radius: '58,232 km', distance: '1.43b km', orbit: .62, size: 16, color: '#d0b674', ring: true },
  { name: 'Uranus', year: '84 years', radius: '25,362 km', distance: '2.87b km', orbit: .77, size: 11, color: '#82c4c8' },
  { name: 'Neptune', year: '164.8 years', radius: '24,622 km', distance: '4.50b km', orbit: .91, size: 11, color: '#456fa8' }
]

const canvas = document.querySelector('#space')
const ctx = canvas.getContext('2d')
const stage = document.querySelector('#stage')
const card = document.querySelector('#planetCard')
let playing = !matchMedia('(prefers-reduced-motion: reduce)').matches
let speed = 1
let elapsed = 0
let previous = performance.now()
let positions = []
let selected = -1

document.querySelector('#planetList').innerHTML = planets.map((planet, index) => `<button class="planet-row" data-index="${index}" type="button"><span>0${index + 1}</span><b>${planet.name}</b><i style="--size:${Math.max(9, planet.size)}px;--color:${planet.color}"></i></button>`).join('')

function resize() {
  const ratio = devicePixelRatio || 1
  const rect = canvas.getBoundingClientRect()
  canvas.width = rect.width * ratio
  canvas.height = rect.height * ratio
  ctx.setTransform(ratio, 0, 0, ratio, 0, 0)
}

function draw(now) {
  const width = canvas.clientWidth
  const height = canvas.clientHeight
  const delta = Math.min((now - previous) / 1000, .05)
  previous = now
  if (playing) elapsed += delta * speed
  ctx.clearRect(0, 0, width, height)
  const cx = width * .49
  const cy = height * .52
  const maxRadius = Math.min(width * .46, height * .46)
  ctx.strokeStyle = 'rgba(19,33,58,.16)'
  ctx.lineWidth = 1
  ctx.setLineDash([2, 5])
  positions = planets.map((planet, index) => {
    const radius = maxRadius * planet.orbit
    const squash = .58
    ctx.beginPath()
    ctx.ellipse(cx, cy, radius, radius * squash, -.15, 0, Math.PI * 2)
    ctx.stroke()
    const angle = elapsed * (1.4 / Math.pow(index + 1, .72)) + index * 1.38
    return { x: cx + Math.cos(angle) * radius, y: cy + Math.sin(angle) * radius * squash, planet, index }
  })
  ctx.setLineDash([])
  const glow = ctx.createRadialGradient(cx, cy, 2, cx, cy, 55)
  glow.addColorStop(0, '#fff9c4')
  glow.addColorStop(.18, '#e5ad42')
  glow.addColorStop(.42, 'rgba(229,173,66,.32)')
  glow.addColorStop(1, 'rgba(229,173,66,0)')
  ctx.fillStyle = glow
  ctx.beginPath()
  ctx.arc(cx, cy, 55, 0, Math.PI * 2)
  ctx.fill()
  ctx.fillStyle = '#d7942f'
  ctx.beginPath()
  ctx.arc(cx, cy, 14, 0, Math.PI * 2)
  ctx.fill()
  positions.forEach(({ x, y, planet, index }) => {
    if (index === selected) {
      ctx.strokeStyle = 'rgba(185,122,47,.65)'
      ctx.beginPath()
      ctx.arc(x, y, planet.size + 7, 0, Math.PI * 2)
      ctx.stroke()
    }
    if (planet.ring) {
      ctx.strokeStyle = '#9b8561'
      ctx.lineWidth = 2
      ctx.beginPath()
      ctx.ellipse(x, y, planet.size * 1.65, planet.size * .48, -.18, 0, Math.PI * 2)
      ctx.stroke()
    }
    const shade = ctx.createRadialGradient(x - planet.size * .35, y - planet.size * .4, 1, x, y, planet.size)
    shade.addColorStop(0, '#fff')
    shade.addColorStop(.25, planet.color)
    shade.addColorStop(1, '#263043')
    ctx.fillStyle = shade
    ctx.beginPath()
    ctx.arc(x, y, planet.size, 0, Math.PI * 2)
    ctx.fill()
  })
  requestAnimationFrame(draw)
}

function showPlanet(index) {
  const planet = planets[index]
  selected = index
  document.querySelector('#cardNumber').textContent = `PLANET 0${index + 1}`
  document.querySelector('#cardName').textContent = planet.name
  document.querySelector('#cardYear').textContent = planet.year
  document.querySelector('#cardRadius').textContent = planet.radius
  document.querySelector('#cardDistance').textContent = planet.distance
  card.classList.add('visible')
}

canvas.addEventListener('click', event => {
  const rect = canvas.getBoundingClientRect()
  const point = { x: event.clientX - rect.left, y: event.clientY - rect.top }
  const hit = positions.find(({ x, y, planet }) => Math.hypot(point.x - x, point.y - y) < planet.size + 9)
  if (hit) showPlanet(hit.index)
})

document.querySelector('#planetList').addEventListener('click', event => {
  const row = event.target.closest('[data-index]')
  if (!row) return
  showPlanet(Number(row.dataset.index))
  stage.scrollIntoView({ behavior: 'smooth', block: 'center' })
})

document.querySelector('#playButton').addEventListener('click', event => {
  playing = !playing
  event.currentTarget.classList.toggle('paused', !playing)
  event.currentTarget.setAttribute('aria-label', playing ? 'Pause orbital motion' : 'Start orbital motion')
  document.querySelector('#playLabel').textContent = playing ? 'SYSTEM IN MOTION' : 'SYSTEM PAUSED'
})

document.querySelector('#speed').addEventListener('input', event => {
  speed = Number(event.target.value)
  document.querySelector('#speedOutput').textContent = `${speed.toFixed(2)}×`
})

document.querySelector('#resetButton').addEventListener('click', () => { elapsed = 0; speed = 1; selected = -1; card.classList.remove('visible'); document.querySelector('#speed').value = 1; document.querySelector('#speedOutput').textContent = '1.00×' })
document.querySelector('#closeCard').addEventListener('click', () => { selected = -1; card.classList.remove('visible') })
document.querySelector('#aboutTrigger').addEventListener('click', () => document.querySelector('#aboutDialog').showModal())
document.querySelector('#closeAbout').addEventListener('click', () => document.querySelector('#aboutDialog').close())
addEventListener('resize', resize)
resize()
requestAnimationFrame(draw)
