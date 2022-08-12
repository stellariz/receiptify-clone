import React from 'react';
import './ButtonOutline.css'
import {useFilter} from "../../TracksPage";
import APIUtils from "../../../utils/APIUtils";


const TypeSwitcher = () => {
    const {innerFilter, setInnerFilter} = useFilter()

    const handleClick = (event) => {
        APIUtils.getTracksCurrentUser({...innerFilter, type: event.target.id})
            .then(res => {
                setInnerFilter({
                    ...innerFilter,
                    type: event.target.id,
                    data: res.data.items
                })
            }).catch(err => {
            console.log(err)
        })
    }

    return (
        <div className="btn-group" role="type" aria-label="type">
            <input type="radio" onChange={handleClick} className="btn-check" name="type" autoComplete="off"
                   id="tracks" defaultChecked={innerFilter.type === "tracks"}/>
            <label id="tracks" className="btn btn-outline-primary" htmlFor="tracks">Tracks</label>

            <input type="radio" onChange={handleClick} className="btn-check" name="type" autoComplete="off"
                   id="artists" defaultChecked={innerFilter.type === "artists"}/>
            <label id="artists" className="btn btn-outline-primary" htmlFor="artists">Artists</label>
        </div>
    );
};

export default TypeSwitcher;