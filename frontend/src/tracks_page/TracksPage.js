import React, {useState, useEffect} from 'react';
import TermSwitcher from "./components/switchers/TermSwitcher";
import TypeSwitcher from "./components/switchers/TypeSwitcher";
import TrackCard from "./TrackCard";
import TrackService from "../TrackService";

const TracksPage = () => {
    const[tracks, setTracks] = useState([])
    useEffect(() => {
        TrackService.getTracks("tracks", "short_term")
            .then(res => {
                console.log(res.data.items)
                setTracks(res.data.items)
            })
            .catch(err => {
            console.log(err)
        })
    }, [])
    return (
        <div>
            <div className="container col-3 py-5">
                <div className="row gy-5">
                    <TermSwitcher/>
                </div>
                <div className="row mt-2">
                    <TypeSwitcher/>
                </div>
            </div>
            <div className="container">
                <div className="row">
                    {tracks.map((track, i) => (
                        < TrackCard track={track} number={i+1} key={i}/>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;