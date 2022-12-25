import { render, screen, waitFor } from '@testing-library/react';
import VideoGameList from './VideoGameList';
import axios from 'axios';
import mockData from '../Utils/mockVideoGames.json';

jest.mock('axios');

describe('Video Game List tests', () => {
  const noVideoGamesText = 'No Video Games could be found.';

  test('if API response contains no properties, should render no video games found', async () => {
    (axios.get as jest.Mock).mockResolvedValueOnce({});

    render(<VideoGameList />);
    await waitFor(() => expect(axios.get).toHaveBeenCalledTimes(1));

    expect(
      screen.getByRole('heading', { name: noVideoGamesText })
    ).toBeInTheDocument();
  });
  test('if API response contains empty data object, should render no video games found', async () => {
    (axios.get as jest.Mock).mockResolvedValueOnce({ data: [] });

    render(<VideoGameList />);
    await waitFor(() => expect(axios.get).toHaveBeenCalledTimes(1));

    expect(
      screen.getByRole('heading', { name: noVideoGamesText })
    ).toBeInTheDocument();
  });

  test('if video games found, renders the correct number of video games', async () => {
    (axios.get as jest.Mock).mockResolvedValueOnce({ data: mockData });

    render(<VideoGameList />);

    await waitFor(() =>
      expect(
        screen.queryByRole('heading', { name: noVideoGamesText })
      ).not.toBeInTheDocument()
    );

    expect(screen.getAllByTestId('GameItem')).toHaveLength(mockData.length);
  });
});
