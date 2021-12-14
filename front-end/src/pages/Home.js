import '../styles/home.css';
import DriverAssignment from "../components/DriverAssignment"
import HomeDefault from "../components/HomeDefault"

const Home = () => {
    return (
        <div>
            {localStorage.getItem("assigned") ? (
                <>
                    < DriverAssignment />
                </>
            ) : (
                <>
                    < HomeDefault />
                </>
            )}
        </div>
    )
}

export default Home;