import React, {useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import APIUtils from "./utils/APIUtils";

const Profile = () => {
    const [currentUser, setUser] = useState()
    useEffect(() => {
        APIUtils.getCurrentUser()
            .then(res => {
                console.log(res)
                setUser(res)
            }).catch(err => {
            console.log(err)
        })
    })
    return (
        <div>
            WTF
        </div>
    );
};

export default Profile;