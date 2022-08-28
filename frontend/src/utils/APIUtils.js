import { API_BASE_URL, ACCESS_TOKEN } from '../constants';
import axios from "axios";

function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return axios.get(API_BASE_URL + "/api/user", {
        headers: {'Authorization' : "Bearer " + localStorage.getItem(ACCESS_TOKEN)}
    })
}

function getTracksCurrentUser(filter){
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return axios.get(API_BASE_URL + "/api/get_tracks", {
        params: {
          time: filter.time
        },
        headers: {'Authorization' : "Bearer " + localStorage.getItem(ACCESS_TOKEN)}
    })
}

function getArtistsCurrentUser(filter){
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return axios.get(API_BASE_URL + "/api/get_artists", {
        params: {
            time: filter.time
        },
        headers: {'Authorization' : "Bearer " + localStorage.getItem(ACCESS_TOKEN)}
    })
}

export default {
    getCurrentUser,
    getTracksCurrentUser,
    getArtistsCurrentUser,
}