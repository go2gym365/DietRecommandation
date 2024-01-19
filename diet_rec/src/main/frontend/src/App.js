import "./App.css";
import { Routes, Route } from "react-router-dom";
import Home from "./pages/home/Home";
import Board from "./pages/board/Board";
import DietRec from "./pages/dietRec/DietRec";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/dietRec" element={<DietRec />} />
      <Route path="/board" element={<Board />} />
    </Routes>
  );
}

export default App;
