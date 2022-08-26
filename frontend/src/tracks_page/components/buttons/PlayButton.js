import React, {useEffect, useState} from 'react';

const useAudio = (url) => {
    const [audio] = useState(new Audio(url));
    const [playing, setPlaying] = useState(false);

    const toggle = () => setPlaying(!playing);

    useEffect(() => {
            playing ? audio.play() : audio.pause();
            }, [playing]);


    useEffect(()=> {
        audio.addEventListener('ended', () => setPlaying(false));
        return () => {
            audio.removeEventListener('ended', () => setPlaying(false));
        };
    }, [])

    return [playing, toggle];
};

const PlayButton = ({preview_url}) => {
    const [playing, toggle] = useAudio(preview_url);

    return (
        <div>
            {!preview_url ?
                <button className="btn btn-secondary">
                    <i className="bi bi-play-circle-fill"></i> Playing unavailable :(
                </button>
                :
                <div>
                    {playing ?
                        <button onClick={toggle} className="btn btn-danger">
                            <i className="bi bi-pause-circle-fill"></i> Pause
                        </button>
                        :
                        <button onClick={toggle} className="btn btn-success">
                            <i className="bi bi-play-circle-fill"></i> Play
                        </button>
                    }
                </div>}
        </div>
    )
};

export default PlayButton;