import "./Home.scss";
import SuggestRestaurants from "../SuggestRestaurants/SuggestedRestaurants";

function Home() {
  return (
    <div className="home container-fluid full-screen ">
      <div className="container">
        <SuggestRestaurants></SuggestRestaurants>
      </div>
    </div>
  );
}

export default Home;
