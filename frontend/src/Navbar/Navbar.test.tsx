import React from 'react';
import { render, screen } from '@testing-library/react';
import Navbar from './Navbar';

test('renders page', () => {
  render(<Navbar />);
});

test('renders application name', () => {
  render(<Navbar />);

  expect(
    screen.getByRole('heading', { name: 'Video Game Library' })
  ).toBeInTheDocument();
});
