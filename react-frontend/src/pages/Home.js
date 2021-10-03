import '../styles/home.css';


const Home = () => {
    return (
        <div>
            <section className="banner-1">
                <div className="text">
                    <h1 className="title">Home Page!</h1>
                    <strong className="slogan">Keeping it extra homie</strong>
                    <p className="description">
                        Description. If we need descriptions
                    </p>
                </div>
            </section>

            <section className="banner-2">
                <div className="text">
                    <h1 className="title">Introducing The Team!</h1>                   
                    <p className="description">
                        Picture cards of all of us idk or something
                    </p>
                    <p> The site is expandable just scroll</p>
                </div>
            </section>
        </div>
    )
}

export default Home;