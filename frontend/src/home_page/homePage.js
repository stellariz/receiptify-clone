import './home_page.css'
import {SPOTIFY_AUTH_URL} from "../constants";
import {useRef} from "react";
import axios from "axios";

const HomePage = () => {
    return (
        <div className="grad_animation pt-5">
            <div className="container col-xxl-9 pr-4 pt-5">
                <div className="row flex-lg-row-reverse justify-content-center align-items-center pt-5">
                    <div className="col-10 col-sm-8 col-lg-3">
                        <img src="Spotify_logo_without_text.svg.png" className="d-block mx-lg-auto img-fluid"
                             alt="spotify logo"
                             width="700" height="500" loading="lazy"/>
                    </div>
                    <div className="col-lg-5">
                        <div className="text_animation">
                            <h1 className="display-2 fw-bold lh-1 mb-3">Topify</h1>
                            <p className="lead">Твои самые прослушиваемые треки (и артисты)</p>
                            <div className="d-grid gap-2 d-md-flex justify-content-md-start">
                                <a href={SPOTIFY_AUTH_URL} type="button" className="btn btn-success btn-lg px-4 me-md-2">Login with Spotify</a>
                                <button type="button" className="btn btn-secondary btn-lg px-4">Info</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default HomePage;