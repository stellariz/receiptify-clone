import React, {useEffect, useState} from 'react';
import TermSwitcher from "./components/switchers/TermSwitcher";
import TypeSwitcher from "./components/switchers/TypeSwitcher";
import TrackCard from "./TrackCard";
import APIUtils from "../utils/APIUtils";

const TracksPage = () => {
    const [tracks, setTracks] = useState([])
    const [filter, setFilter] = useState({
        type: "tracks",
        time: "short_term"
    })

    useEffect(() => {
        APIUtils.getTracksCurrentUser(filter)
            .then(res => {
                console.log(res.data.items)
                setTracks(res.data.items)
            })
            .catch(err => {
                console.log(err)
            })
    }, [filter])

    useEffect(() => {

    }, [tracks])


    return (
        <div>
            <div className="container col-3 py-5">
                <div className="row gy-5">
                    <TermSwitcher filter={filter} setFilter={setFilter}/>
                </div>
                <div className="row mt-2">
                    <TypeSwitcher filter={filter} setFilter={setFilter}/>
                </div>
            </div>
            <div className="container">
                <div className="row">
                    {tracks.map((track, i) => (
                        < TrackCard track={track} number={i + 1} key={i}/>
                    ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;