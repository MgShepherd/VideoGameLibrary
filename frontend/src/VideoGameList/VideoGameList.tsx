import { useState, useEffect } from 'react';
import axios from 'axios';
import VideoGame from '../Models/VideoGame';
import VideoGameItem from '../VideoGameItem/VideoGameItem';
import { Box } from '@mui/material';

const VideoGameList = () => {
  const [videoGames, setVideoGames] = useState<VideoGame[]>([]);

  useEffect(() => {
    const fetchGameData = () => {
      axios
        .get('http://localhost:8080/games')
        .then((response) => {
          if (response.data && response.data.length > 0) {
            setVideoGames(response.data);
          }
        })
        .catch((error) => {
          console.log(`Could not fetch game data due to error: ${error}`);
        });
    };

    fetchGameData();
  }, []);

  const getItemsToDisplay = () => {
    if (videoGames.length > 0) {
      return videoGames.map((game, index) => (
        <div data-testid="GameItem">
          <VideoGameItem game={game} key={index} />
        </div>
      ));
    }
    return <h2>No Video Games could be found.</h2>;
  };

  return <Box sx={{ padding: '2em' }}>{getItemsToDisplay()}</Box>;
};

export default VideoGameList;
