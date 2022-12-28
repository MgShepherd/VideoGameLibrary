import { render, screen } from '@testing-library/react';
import VideoGameItem from './VideoGameItem';
import mockVideoGames from '../../Utils/mockVideoGames.json';

test('renders all the correct parts of the video game object', () => {
  render(<VideoGameItem game={mockVideoGames[0]} />);

  expect(screen.getByText('FakeGame')).toBeInTheDocument();
  expect(screen.getByText('Michael Shepherd')).toBeInTheDocument();

  const gameImage = screen.getByRole('img') as HTMLImageElement;
  expect(gameImage.src).toBe('http://www.fakeurl.com/');
});
