import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MainPage from "./page/MainPage";
import LottoMainPage from "./features/lotto/page/main/MainPage";
// import MainPage from './components/MainPage';
// import LottoPage from './features/lotto/LottoPage';
// import MoripPage from './features/morip/MoripPage';
import './App.css';

function App() {
  return (
      <Router>
        <div className="App">
          <Routes>
            <Route path="/" element={<MainPage />} />
            <Route path="/lotto"  element={<LottoMainPage />} />
            {/*<Route path="/lotto" element={<LottoMainPage />} />*/}
            {/*<Route path="/morip" element={<MoripPage />} />*/}
          </Routes>
        </div>
      </Router>
  );
}

export default App;
