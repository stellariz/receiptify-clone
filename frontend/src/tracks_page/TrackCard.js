import React from 'react';


const TrackCard = ({track}) => {
    return (
        <div className="col mt-5">
            <div className="card" style={{width: '13rem'}}>
                <img className="card-img-top" src="https://i.scdn.co/image/ab67616d0000b27367d38453b6f85a4b470b9b4b"
                     alt="Card image cap"/>
                <div className="card-body">
                    <h5 className="card-text">track.name</h5>
                    <p className="card-text">track.artists.name</p>
                    <a href="#" className="btn btn-success">
                        <i className="bi bi-play-circle-fill"></i> Play
                    </a>
                </div>
            </div>
        </div>
    );
};

export default TrackCard;