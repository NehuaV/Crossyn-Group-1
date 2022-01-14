import "../styles/home.css";
import DriverAssignment from "../components/DriverAssignment";
import HomeDefault from "../components/HomeDefault";
import { useEffect, useState } from "react";
import axios from "axios";

const Home = () => {
  const [assigned, setAssigned] = useState(null);

  const checkStatus = () => {
    axios
      .get("/users/status")
      .then((response) => {
        console.log(response.data);
        setAssigned(response.data);
      })
      .catch((error) => {
        if (error.response.status === 404) {
          alert("Page not found");
          // redirect to page 404
        } else {
          alert("Something went wrong");
        }
      });
  };

  useEffect(() => {
    checkStatus();
  }, []);

  return ( assigned === null ? null : (
          <div>
            {!assigned ? (
                <>
                  <DriverAssignment />
                </>
            ) : (
                <>
                  <HomeDefault />
                </>
            )}
          </div>
      )
  );
};

export default Home;
