import React, {useEffect, useState} from 'react';
import TermSwitcher from "./switchers/TermSwitcher";
import TypeSwitcher from "./switchers/TypeSwitcher";
import TrackCard from "./TrackCard";
import TrackService from "../TrackService";

const TracksPage = () => {

    const [tracks, setTracks] = useState([])

    useEffect(() => {
        TrackService.getTracks("tracks", "short_term").then(res => {
            console.log(res)
            setTracks(res.body.items)
        }).catch(err => {
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
                    {tracks.map((track) => (
                        < TrackCard track={track}/>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;