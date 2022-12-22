import { useState, useEffect } from 'react';
import axios from 'axios';

interface VideoGame {
  id: number;
  name: string;
  publisher: string;
  releaseDate: Date;
  genre: string;
}

const VideoGameList = () => {
  const [videoGames, setVideoGames] = useState<VideoGame[]>([]);

  useEffect(() => {
    const fetchGameData = () => {
      axios
        .get('http://localhost:8080/games')
        .then((response) => {
          if (response.data) {
            setVideoGames(response.data);
          }
        })
        .catch((error) => {
          console.log(`Could not fetch game data due to error: ${error}`);
        });
    };

    fetchGameData();
  }, []);

  return (
    <div>
      {videoGames.map((game) => (
        <p>{game.name}</p>
      ))}
    </div>
  );
};

export default VideoGameList;
