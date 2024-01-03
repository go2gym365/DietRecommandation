import "./App.css";
import { useEffect, useState } from "react";
import { BrowserRouter as BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/home/Home";
import Board from "./pages/board/Board";
import DietRec from "./pages/dietRec/DietRec";
import Signin from "./pages/auth/signin/SignIn";
import Signup from "./pages/auth/signup/SignUp";

function App() {
  return (
    <BrowserRouter>
        <Routes>
          <Route path="" element={<Home />} />
          <Route path="/dietRec" element={<DietRec />} />
          <Route path="/board" element={<Board />} />
          <Route path="/signin" element={<Signin />} />
          <Route path="/signup" element={<Signup />} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
