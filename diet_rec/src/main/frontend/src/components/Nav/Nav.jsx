import { Link } from "react-router-dom";

import "./Nav.css";

const Nav = () => {
  return (
    <nav>
      <div className="menu">
        <ul>
          <li>
            <Link to="/">홈</Link>
          </li>
          <li>
            <Link to="/about">식단 추천</Link>
          </li>
          <li>
            <Link to="/contact">게시판</Link>
          </li>
        </ul>
      </div>
      <div>
        <ul>
          <li>
            <Link to="/about">로그인</Link>
          </li>
          <li>
            <Link to="/contact">회원가입</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Nav;
