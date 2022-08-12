import React from 'react';
import TermSwitcher from "./components/switchers/TermSwitcher";
import TypeSwitcher from "./components/switchers/TypeSwitcher";


const Filters = () => {
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