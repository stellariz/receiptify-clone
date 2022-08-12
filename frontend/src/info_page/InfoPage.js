import React from 'react';
import {useNavigate} from "react-router-dom";

const InfoPage = () => {
    const navigate = useNavigate()

    return (
        <div className="container pt-5 mt-5">
            <div className="px-4 pt-5 mt-5 text-center">
                <h1 className="display-5 fw-bold">О проекте</h1>
                <div className="col-lg-6 mx-auto">
                    <p className="lead mb-4">Здесь должно быть написано что-то умное :) </p>
                    <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <button onClick={()=>navigate("/tracks")} type="button" className="btn btn-primary btn-lg px-4 gap-3">Попробуй</button>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default InfoPage;