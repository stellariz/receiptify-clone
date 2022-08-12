import React, {createContext, useContext, useEffect, useState} from 'react';
import TrackCard from "./components/cards/TrackCard";
import Navbar from "../Navbar";
import ArtistCard from "./components/cards/ArtistCard";
import Filters from "./Filters";
import "./components/cards/card.css"
import APIUtils from "../utils/APIUtils";

const FilterContext = createContext(null)
export const useFilter = () => useContext(FilterContext)

const TracksPage = () => {
    const [data, setData] = useState([])
    const [innerFilter, setInnerFilter] = useState({
        type: "tracks",
        time: "short_term",
        data: null
    })

    const [outerFilter] = useState({})

    useEffect(() => {
        outerFilter.type = innerFilter.type
        if (data.length === 0) {
            APIUtils.getTracksCurrentUser(innerFilter).then(res => {
                setData(res.data.items)
            }).catch(err => console.log(err));
        } else {
            setData(innerFilter.data)
        }
    }, [innerFilter])

    return (
        <div>
            <Navbar/>
            <FilterContext.Provider value={{innerFilter, setInnerFilter}}>
                <Filters/>
            </FilterContext.Provider>
            <div className="container">
                <div className="row">
                    {outerFilter.type === "tracks" ?
                        data.map((track, i) => (
                            < TrackCard track={track} number={i + 1} key={i}/>
                        ))
                        :
                        data.map((artist, i) => (
                            < ArtistCard artist={artist} number={i + 1} key={i}/>
                        ))}
                </div>
            </div>
        </div>
    );
};

export default TracksPage;