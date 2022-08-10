import {createContext, useContext, useEffect} from "react";
import {useLocation, useNavigate} from "react-router-dom";
import {ACCESS_TOKEN} from "../constants";


const AuthContext = createContext(null)

export const AuthProvider = ({children}) => {

    const signin = (token, f) => {
        localStorage.setItem(ACCESS_TOKEN, token)
        f()
    }

    const signout = (f) => {
        console.log("signed_out")
        localStorage.removeItem(ACCESS_TOKEN);
        f()
    }

    const value = {signin, signout}

    return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>
}

export const useAuth = () => {
    return useContext(AuthContext)
}


export const RequireAuth = ({children}) => {
    const auth = useAuth()
    const location = useLocation()
    const navigate = useNavigate()
    useEffect(() => {
        if (localStorage.getItem(ACCESS_TOKEN) === null) {
            return navigate("/login", {replace: true, state: {from: location}})
        }
    }, [navigate])
    return children
}
