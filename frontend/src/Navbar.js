import React from 'react';
import {useAuth} from "./auth/AuthUtils";
import {useNavigate} from "react-router-dom";

const Navbar = () => {
    const auth = useAuth()
    const navigate = useNavigate()

    return (
        <div>
            <nav className="navbar navbar-light" style={{background: "#FFFFFF"}}>
                <form className="container-fluid justify-content-end">
                    <button className="btn btn-success me-2" type="button">Your Spotify profile</button>
                    <button className="btn btn-secondary me-2" type="button">About project</button>
                    <button onClick={()=>auth.signout(()=>navigate("/login"))} className="btn btn-danger me-2" type="button">Logout</button>
                </form>
            </nav>
        </div>
    );
};

export default Navbar;