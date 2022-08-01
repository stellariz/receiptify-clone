import { API_BASE_URL, ACCESS_TOKEN } from '../constants';
import axios from "axios";

function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return axios.get(API_BASE_URL + "api/user", {
        headers: {'Authorization' : "Bearer " + localStorage.getItem(ACCESS_TOKEN)}
    })
}

export default {
    getCurrentUser,
}