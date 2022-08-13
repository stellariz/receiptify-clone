import React from 'react';
import './ButtonOutline.css'
import {useFilter} from "../../TracksPage";

const TypeSwitcher = () => {
    const {filter, setFilter} = useFilter()

    const handleClick = (event) => {
        setFilter({
            ...filter,
            type: event.target.id
        })
    }

    return (
        <div className="btn-group" role="type" aria-label="type">
            <input type="radio" onChange={handleClick} className="btn-check" name="type" autoComplete="off"
                   id="tracks" defaultChecked={filter.type === "tracks"}/>
            <label id="tracks" className="btn btn-outline-primary" htmlFor="tracks">Tracks</label>

            <input type="radio" onChange={handleClick} className="btn-check" name="type" autoComplete="off"
                   id="artists" defaultChecked={filter.type === "artists"}/>
            <label id="artists" className="btn btn-outline-primary" htmlFor="artists">Artists</label>
        </div>
    );
};

export default TypeSwitcher;