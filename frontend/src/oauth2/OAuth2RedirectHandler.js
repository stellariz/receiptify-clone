import React, {useEffect, useState} from 'react';
import {ACCESS_TOKEN} from '../constants';
import {Navigate, useSearchParams} from 'react-router-dom'

const OAuth2RedirectHandler = (props) => {
    const [searchParams] = useSearchParams()

    const token = searchParams.get("token")
    const error = searchParams.get("error")

    if (token) {
        console.log(token)
        localStorage.setItem(ACCESS_TOKEN, token);
    }

    return (
        <div>
            {token.length === 0 ?
                <Navigate to={{
                    pathname: "/",
                }}/> :
                <Navigate to={{
                    pathname: "/tracks",
                    state: {
                        error: error
                    }
                }}/>}
        </div>
    );
};

export default OAuth2RedirectHandler;