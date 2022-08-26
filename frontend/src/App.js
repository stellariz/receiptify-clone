import {BrowserRouter, Route, Routes} from "react-router-dom";
import OAuth2RedirectHandler from "./oauth2/OAuth2RedirectHandler";
import LoginPage from "./login_page/LoginPage";
import TracksPage from "./tracks_page/TracksPage";
import {AuthProvider, RequireAuth} from "./auth/AuthUtils"
import InfoPage from "./info_page/InfoPage";


function App() {
    return (
        <div>
            <BrowserRouter>
                <AuthProvider>
                    <Routes>
                        <Route path="/" element={
                            <RequireAuth>
                                <TracksPage/>
                            </RequireAuth>
                        }/>
                        <Route path="/login" element={<LoginPage/>}/>
                        <Route path="/oauth2/redirect"
                               element={<OAuth2RedirectHandler/>}/>
                        <Route path="/info" element={<InfoPage/>}/>
                    </Routes>
                </AuthProvider>
            </BrowserRouter>
        </div>
    );
}

export default App;
