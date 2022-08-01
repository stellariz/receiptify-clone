import axios from "axios";

function getTracks(type, time) {
    return axios.get("http://localhost:8080/api/getTracks", {
        params: {
            type: type,
            time: time
        }
    })
}

const TrackService = {
    getTracks
}

export default TrackService