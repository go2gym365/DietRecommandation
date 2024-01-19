import { useEffect, useState } from "react";
import Nav from "../../components/Nav/Nav";

const Home = () => {
  const [message, setMessage] = useState([]);
  useEffect(() => {
    fetch("/hello")
      .then((res) => {
        return res.json();
      })
      .then((data) => {
        setMessage(data);
      });
  }, []);
    return (
      <div>
        <Nav />
        <h1>메인 페이지임</h1>
        <ul>
          {message.map((v, idx) => (
            <li key={`${idx}-${v}`}>{v}</li>
          ))}
        </ul>
      </div>
    );
  };
  
  export default Home;
  