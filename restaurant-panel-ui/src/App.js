
import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Home from './components/Home/Home';
import CustomerList from './components/Customer/CustomerList';
import ResturantList from './components/Restaurant/RestaurantList';
import NavbarContent from './components/Navbar/Navbar';
import RestaurantDetail from "./components/Restaurant/RestaurantDetail"
import 'bootstrap/dist/css/bootstrap.min.css';
import { useParams } from 'react-router-dom';


function App() {
  const RestaurantWrapper = () => {
    const { restaurantId } = useParams();
    return <RestaurantDetail  restaurantId = {restaurantId} />;
  };
  
  return (
    <div className="App">
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"></link>
      <BrowserRouter>
        <NavbarContent></NavbarContent>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/customers" element={<CustomerList />} />
          <Route path="/restaurants" element={<ResturantList />} />    
          <Route path="/restaurants/:restaurantId" element= {<RestaurantWrapper></RestaurantWrapper>}> 
          </Route>
        </Routes>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
