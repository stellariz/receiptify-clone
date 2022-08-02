import axios from "axios";
import {ACCESS_TOKEN} from "./constants";

function getTracks(type, time) {
    return axios.get("http://localhost:8080/api/get_tracks", {
        params: {
            type: type,
            time: time
        },
        headers: {'Authorization' : "Bearer " + localStorage.getItem(ACCESS_TOKEN)}
    })
}

const TrackService = {
    getTracks
}

export default TrackService