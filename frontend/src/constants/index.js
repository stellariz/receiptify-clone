export const API_BASE_URL = 'http://localhost:8080';
export const ACCESS_TOKEN = 'token';

export const OAUTH2_REDIRECT_URI = 'http://localhost:3000/oauth2/redirect'

export const SPOTIFY_AUTH_URL = API_BASE_URL + '/oauth2/authorize/spotify?redirect_uri=' + OAUTH2_REDIRECT_URI;
