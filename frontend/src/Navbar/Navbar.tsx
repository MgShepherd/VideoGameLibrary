import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';

const Navbar = () => {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static" color="primary" sx={{ pl: '2em' }}>
        <h1>Video Game Library</h1>
      </AppBar>
    </Box>
  );
};

export default Navbar;
