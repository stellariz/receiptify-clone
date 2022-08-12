import React from 'react';
import './ButtonOutline.css'
import {useFilter} from "../../TracksPage";
import APIUtils from "../../../utils/APIUtils";

const TermSwitcher = () => {
    const {innerFilter, setInnerFilter} = useFilter()

    const handleClick = (event) => {
        console.log(innerFilter)
        APIUtils.getTracksCurrentUser({...innerFilter, time: event.target.id})
            .then(res => {
                setInnerFilter({
                    ...innerFilter,
                    time: event.target.id,
                    data: res.data.items
                })
            }).catch(err => {
            console.log(err)
        })
    }
    return (
        <div className="btn-group" role="time" aria-label="time">
            <input type="radio" onChange={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="short_term" defaultChecked={innerFilter.time === "short_term"}/>
            <label className="btn btn-outline-primary" htmlFor="short_term">Last month</label>

            <input type="radio" onChange={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="medium_term" defaultChecked={innerFilter.time === "medium_term"}/>
            <label id="medium_term" className="btn btn-outline-primary" htmlFor="medium_term">Last 6 months</label>

            <input type="radio" onClick={handleClick} className="btn-check" name="term" autoComplete="off"
                   id="long_term" defaultChecked={innerFilter.time === "long_term"}/>
            <label id="long_term" className="btn btn-outline-primary" htmlFor="long_term">All time</label>
        </div>
    );
};

export default TermSwitcher;