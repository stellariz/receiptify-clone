import React, {useState, useEffect, createContext, useContext} from 'react';
import TrackCard from "./components/cards/TrackCard";
import Navbar from "../Navbar";
import ArtistCard from "./components/cards/ArtistCard";
import Filters from "./Filters";
import APIUtils from "../utils/APIUtils";
import "./components/cards/card.css"

const FilterContext = createContext(null)
export const useFilter = () => useContext(FilterContext)

const TracksPage = () => {
    const [artists, setArtists] = useState([])
    const [tracks, setTracks] = useState([])
    const [filter, setFilter] = useState({
        type: "tracks",
        time: "short_term"
    })


    return (
        <div>
            <Navbar/>
            <FilterContext.Provider value={{setArtists, setTracks, filter, setFilter}}>
                <Filters/>
            </FilterContext.Provider>
            <div className="container">
                <div className="row">
                    {filter.type === "tracks" ?
                        tracks.map((track, i) => (
                            < TrackCard track={track} number={i + 1} key={i}/>
                        ))
                        :
                        artists.map((artist, i) => (
                            < ArtistCard artist={artist} number={i + 1} key={i}/>
                        ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;