import { Card, CardHeader, CardMedia } from '@mui/material';
import VideoGame from '../../Models/VideoGame';

interface VideoGameItemProps {
  game: VideoGame;
}

const VideoGameItem = ({ game }: VideoGameItemProps) => {
  return (
    <Card sx={{ maxWidth: '10em' }}>
      <CardHeader title={game.name} subheader={game.publisher} />
      <CardMedia component="img" image={game.imageUrl} />
    </Card>
  );
};

export default VideoGameItem;
