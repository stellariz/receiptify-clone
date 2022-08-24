import React, {createContext, useContext, useEffect, useState} from 'react';
import TrackCard from "./components/cards/TrackCard";
import Navbar from "../Navbar";
import ArtistCard from "./components/cards/ArtistCard";
import Filters from "./Filters";
import "./components/cards/card_animation.css"
import APIUtils from "../utils/APIUtils";

const FilterContext = createContext(null)
export const useFilter = () => useContext(FilterContext)

const TracksPage = () => {
    const [chart, setChart] = useState({
            type: "tracks",
            data: []
        }
    )
    const [filter, setFilter] = useState({
        type: "tracks",
        time: "short_term"
    })

    useEffect(() => {
        APIUtils.getTracksCurrentUser(filter).then(res => {
            setChart({
                type: filter.type,
                data: res.data.items
            })
        }).catch(err => console.log(err));
    }, [filter])

    return (
        <div>
            <Navbar/>
            <FilterContext.Provider value={{filter, setFilter}}>
                <Filters/>
            </FilterContext.Provider>
            <div className="container">
                <div className="row">
                    {chart.type === "tracks" ?
                        chart.data.map((track, i) => (
                            < TrackCard track={track} number={i} key={i + track.name}/>
                        ))
                        :
                        chart.data.map((artist, i) => (
                            < ArtistCard artist={artist} number={i} key={i + artist.name}/>
                        ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;