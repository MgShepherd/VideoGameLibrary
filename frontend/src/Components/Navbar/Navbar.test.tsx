import { render, screen } from '@testing-library/react';
import Navbar from './Navbar';

test('renders header with the application name', () => {
  render(<Navbar />);

  expect(
    screen.getByRole('heading', { name: 'Video Game Library' })
  ).toBeInTheDocument();
});
