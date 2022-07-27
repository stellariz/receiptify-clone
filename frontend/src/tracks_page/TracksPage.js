import React from 'react';
import TermSwitcher from "./switchers/TermSwitcher";
import TypeSwitcher from "./switchers/TypeSwitcher";
import TrackCard from "./TrackCard";

const TracksPage = () => {
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
            <div className="container">
                <div className="row">
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                    <TrackCard/>
                </div>
            </div>
        </div>
    );
};

export default TracksPage;