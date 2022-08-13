import PlayButton from "../buttons/PlayButton";
import {useMemo} from "react";

function getArtistName(artists) {
    if (artists.length === 1){
        return artists[0].name
    }
    return  artists.map(artist=>artist.name).join(", ")
}

const TrackCard = ({number, track}) => {

    const artists = useMemo(()=>{
        return getArtistName(track.artists)
    }, [track])

    return (
        <div className="col mt-5">
            <div className="card" style={{width: '13rem'}}>
                <img className="card-img-top" src={track.album.images[0].url}
                     alt="Card image cap"/>
                <div className="card-body">
                    <h5 className="card-text">{number+1 + ". " + track.name}</h5>
                    <p className="card-text">{artists}</p>
                    <PlayButton preview_url={track.preview_url}/>
                </div>
            </div>
        </div>
    );
};

export default TrackCard;