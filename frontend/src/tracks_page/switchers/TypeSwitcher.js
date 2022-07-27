import React from 'react';

const TypeSwitcher = () => {
    return (
        <div className="btn-group" role="type" aria-label="type">
            <input type="radio" className="btn-check" name="tracks" id="tracks" autoComplete="off" />
                <label className="btn btn-outline-primary" htmlFor="tracks">Tracks</label>

            <input type="radio" className="btn-check" name="artists" id="artists" autoComplete="off"/>
                <label className="btn btn-outline-primary" htmlFor="artists">Artists</label>
        </div>
    );
};

export default TypeSwitcher;