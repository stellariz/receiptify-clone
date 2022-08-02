import React from 'react';

const TermSwitcher = ({clickHandler}) => {
    return (
        <div className="btn-group" role="time" aria-label="time">
            <input type="radio" className="btn-check" name="term" id="short_term" autoComplete="off"/>
            <label className="btn btn-outline-primary" htmlFor="short_term">Last month</label>

            <input type="radio" className="btn-check" name="term" id="middle_term" autoComplete="off"/>
            <label className="btn btn-outline-primary" htmlFor="middle_term">Last 6 months</label>

            <input type="radio" className="btn-check" name="term" id="long_term" autoComplete="off"/>
            <label className="btn btn-outline-primary" htmlFor="long_term">All time</label>
        </div>
    );
};

export default TermSwitcher;