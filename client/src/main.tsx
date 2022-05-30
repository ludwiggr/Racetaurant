import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import Theme from './components/theme'
import './index.css'
import theme from './theme'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <Theme theme={theme} save="default">
      <App />
    </Theme>
  </React.StrictMode>
)
