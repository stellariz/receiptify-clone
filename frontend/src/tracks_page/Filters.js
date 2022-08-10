import React from 'react';
import TermSwitcher from "./components/switchers/TermSwitcher";
import TypeSwitcher from "./components/switchers/TypeSwitcher";
import {useEffect} from "react";
import APIUtils from "../utils/APIUtils";
import {useFilter} from "./TracksPage";


const Filters = () => {
    const {filter, setTracks, setArtists} = useFilter()
    useEffect(() => {
        APIUtils.getTracksCurrentUser(filter)
            .then(res => {
                if (filter.type === "tracks") {
                    setTracks(res.data.items)
                } else {
                    setArtists(res.data.items)
                }
            }).catch(err => {
            console.log(err)
        })
    }, [filter])
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
        </div>
    );
};

export default Filters;