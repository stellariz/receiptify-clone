import React from 'react';
import PlayButton from "../buttons/PlayButton";

const TrackCard = ({number, track}) => {

    const getArtists = (artists) => {
        if (artists.length === 1){
            return artists[0].name
        }
        return  artists.map(artist=>artist.name).join(", ")
    }

    return (
        <div className="col mt-5">
            <div className="card" style={{width: '13rem'}}>
                <img className="card-img-top" src={track.album.images[0].url}
                     alt="Card image cap"/>
                <div className="card-body">
                    <h5 className="card-text">{number + ". " + track.name}</h5>
                    <p className="card-text">{getArtists(track.artists)}</p>
                    <PlayButton preview_url={track.preview_url}/>
                </div>
            </div>
        </div>
    );
};

export default TrackCard;