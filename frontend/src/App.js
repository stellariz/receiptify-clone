import Navbar from "./Navbar";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import {useEffect, useState} from "react";
import APIUtils from "./utils/APIUtils";
import Profile from "./Profile";
import OAuth2RedirectHandler from "./oauth2/OAuth2RedirectHandler";
import HomePage from "./home_page/homePage";

import {createMemoryHistory} from 'history';


function App() {
    const history = createMemoryHistory();

    const [status, setStatus] = useState({
        currentUser: null,
        authenticated: false
    })

    useEffect(() => {
        APIUtils.getCurrentUser()
            .then(res => {
                console.log(res)
                setStatus({
                    currentUser: res,
                    authenticated: true,
                })
            })
    }, [])

    return (
        <div>
            <Navbar/>
            <BrowserRouter>
                <Routes>
                    <Route exact path="/" element={<HomePage/>}/>
                    <Route path="/oauth2/redirect" element={<OAuth2RedirectHandler/>}/>
                    <Route path="/me" element={<Profile/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;
