import React from 'react';


const ArtistCard = ({number, artist}) => {
    return (
        <div className="col mt-5">
            <div className="card" style={{width: '13rem'}}>
                <img className="card-img-top" src={artist.images[0].url}
                     alt="Card image cap"/>
                <div className="card-body">
                    <h5 className="card-text">{number+1 + ". " + artist.name}</h5>
                </div>
            </div>
        </div>
    );
};

export default ArtistCard;