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
            <Link to="/dietRec">식단 추천</Link>
          </li>
          <li>
            <Link to="/board">게시판</Link>
          </li>
        </ul>
      </div>
      <div>
        <ul>
          <li>
            <Link to="/signin">로그인</Link>
          </li>
          <li>
            <Link to="/signup">회원가입</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Nav;
