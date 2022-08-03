import React from 'react';
import './ButtonOutline.css'

const TypeSwitcher = ({filter, setFilter}) => {

    const handleClick = (event) => {

        console.log(event.target.id)
        setFilter({
            ...filter,
            type: event.target.id
        })
    }

    return (
        <div className="btn-group" role="type" aria-label="type">
            <input type="radio" onChange={handleClick} className="btn-check" name="tracks" id="tracks" autoComplete="off" defaultChecked={filter.type === "tracks"}/>
            <label className="btn btn-outline-primary" htmlFor="tracks">Tracks</label>

            <input type="radio" onChange={handleClick} className="btn-check" name="artists" id="artists" autoComplete="off" defaultChecked={filter.type === "artists"} disabled/>
            <label className="btn btn-outline-primary" htmlFor="artists">Artists</label>
        </div>
    );
};

export default TypeSwitcher;