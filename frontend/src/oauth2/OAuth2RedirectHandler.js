import React, {useEffect} from 'react';
import {useLocation, useNavigate, useSearchParams} from 'react-router-dom'
import {useAuth} from "../auth/AuthUtils";

const OAuth2RedirectHandler = () => {
    const navigate = useNavigate()
    const location = useLocation()
    const auth = useAuth()

    const from = location.state?.from?.pathname || "/"

    const [searchParams] = useSearchParams()

    useEffect(() => {
        const token = searchParams.get("token")
        const error = searchParams.get("error")
        if (token) {
            auth.signin(token, () => {
                navigate("/", {replace: true, state: {from: from}})
            })
        } else {
            console.log(error)
            navigate("/login", {replace: true, state: {from: from}})
        }
    }, [])

    return (
        <></>
    );
};

export default OAuth2RedirectHandler;