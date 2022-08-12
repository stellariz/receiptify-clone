import React from 'react';
import './ButtonOutline.css'
import {useFilter} from "../../TracksPage";

const TermSwitcher = () => {
    const {filter, setFilter} = useFilter()

    const handleClick = (event) => {
        setFilter({
            ...filter,
            time: event.target.id
        })
    }

    return (
        <div className="btn-group" role="time" aria-label="time">
            <input type="radio" onChange={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="short_term" defaultChecked={filter.time === "short_term"}/>
            <label className="btn btn-outline-primary" htmlFor="short_term">Last month</label>

            <input type="radio" onChange={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="medium_term" defaultChecked={filter.time === "medium_term"}/>
            <label id="medium_term" className="btn btn-outline-primary" htmlFor="medium_term">Last 6 months</label>

            <input type="radio" onClick={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="long_term" defaultChecked={filter.time === "long_term"}/>
            <label id="long_term" className="btn btn-outline-primary" htmlFor="long_term">All time</label>
        </div>
    );
};

export default TermSwitcher;