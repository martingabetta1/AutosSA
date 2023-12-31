
import * as React from 'react';
import { styled, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Drawer from '@mui/material/Drawer';
import MuiAppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import CssBaseline from '@mui/material/CssBaseline';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import HomeIcon from '@mui/icons-material/Home';
import MenuIcon from '@mui/icons-material/Menu';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import ChevronRightIcon from '@mui/icons-material/ChevronRight';
import SellIcon from '@mui/icons-material/Sell';//Marca
import InventoryIcon from '@mui/icons-material/Inventory';//Modelo
import DirectionsCarIcon from '@mui/icons-material/DirectionsCar';//Vehiculo
import PersonIcon from '@mui/icons-material/Person';//Cliente
import EmojiPeopleIcon from '@mui/icons-material/EmojiPeople';//Visita
import BadgeIcon from '@mui/icons-material/Badge';//Tecnico
import ReceiptIcon from '@mui/icons-material/Receipt';//Orden
import MiscellaneousServicesIcon from '@mui/icons-material/MiscellaneousServices';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import { Link } from 'react-router-dom';
import { ClickAwayListener } from '@mui/material';
import BarChartIcon from '@mui/icons-material/BarChart';


const drawerWidth = 240;

const Main = styled('main', { shouldForwardProp: (prop) => prop !== 'open' })(
  ({ theme, open }) => ({
    flexGrow: 1,
    padding: theme.spacing(3),
    transition: theme.transitions.create('margin', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    marginRight: -drawerWidth,
    ...(open && {
      transition: theme.transitions.create('margin', {
        easing: theme.transitions.easing.easeOut,
        duration: theme.transitions.duration.enteringScreen,
      }),
      marginRight: 0,
    }),
  }),
);

const AppBar = styled(MuiAppBar, {
  shouldForwardProp: (prop) => prop !== 'open',
})(({ theme, open }) => ({
  transition: theme.transitions.create(['margin', 'width'], {
    easing: theme.transitions.easing.sharp,
    duration: theme.transitions.duration.leavingScreen,
  }),
  ...(open && {
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['margin', 'width'], {
      easing: theme.transitions.easing.easeOut,
      duration: theme.transitions.duration.enteringScreen,
    }),
    marginRight: drawerWidth,
  }),
}));

const DrawerHeader = styled('div')(({ theme }) => ({
  display: 'flex',
  alignItems: 'center',
  padding: theme.spacing(0, 1),
  // necessary for content to be below app bar
  ...theme.mixins.toolbar,
  justifyContent: 'flex-start',
}));

export default function PersistentDrawerRight() {
  const theme = useTheme();
  const [open, setOpen] = React.useState(false);

  const handleDrawerOpen = () => {
    setOpen(true);
  };

  const handleDrawerClose = () => {
    setOpen(false);
  };

  const listContent = [{
    nombre: "Inicio",
    icono: <HomeIcon />,
    ruta: "/"
  },
  {
    nombre: "Marcas",
    icono: <SellIcon />,
    ruta: "/marca"
  },
  {
    nombre: "Modelos",
    icono: <InventoryIcon />,
    ruta: "/modelo"
  },
  {
    nombre: "Vehiculos",
    icono: <DirectionsCarIcon />,
    ruta: "/vehiculo"
  },
  {
    nombre: "Clientes",
    icono: <PersonIcon />,
    ruta: "/cliente"
  },
  // {
  //   nombre:"Visitas",
  //   icono:<EmojiPeopleIcon/>,
  //   ruta:"/visita"
  // },
  {
    nombre: "Tecnicos",
    icono: <BadgeIcon />,
    ruta: "/tecnico"
  },
  {
    nombre: "Ordenes",
    icono: <ReceiptIcon />,
    ruta: "/orden"
  },
  {
    nombre: "Servicios",
    icono: <MiscellaneousServicesIcon />,
    ruta: "/servicio"
  }]
  return (
    <Box sx={{ display: 'flex' }}>
      <CssBaseline />
      <AppBar position="fixed" open={open}>
        <Toolbar>
          <Typography variant="h6" noWrap sx={{ flexGrow: 1, display: 'inline-flex' }} component="div">
            Autos S.A.
          </Typography>
          <IconButton
            color="inherit"
            aria-label="open drawer"
            edge="end"
            onClick={handleDrawerOpen}
            sx={{ ...(open && { display: 'none' }) }}
          >
            <MenuIcon />
          </IconButton>
        </Toolbar>
      </AppBar>
      <Main style={{ padding: '0px' }} open={open}>
        <DrawerHeader />
      </Main>
      <ClickAwayListener
        mouseEvent="onMouseDown"
        touchEvent="onTouchStart"
        onClickAway={() => open && handleDrawerClose()}
      >
        <Drawer
          sx={{
            width: drawerWidth,
            flexShrink: 0,
            '& .MuiDrawer-paper': {
              width: drawerWidth,
            },
          }}
          variant="persistent"
          anchor="right"
          open={open}

        >
          <DrawerHeader>
            <IconButton onClick={handleDrawerClose}>
              {theme.direction === 'rtl' ? <ChevronLeftIcon /> : <ChevronRightIcon />}
            </IconButton>
          </DrawerHeader>
          <Divider />
          <List>
            {listContent.map(item => {
              return (
                <ListItem component={Link} to={item.ruta} key={item.nombre} disablePadding>
                  <ListItemButton>
                    <ListItemIcon>
                      {item.icono}
                    </ListItemIcon>
                    <ListItemText primary={item.nombre} />
                  </ListItemButton>
                </ListItem>
              )
            })}
            <Divider />
            <ListItem component={Link} to={"/estadisticas"} key={"estadisticas"} disablePadding>
              <ListItemButton>
                <ListItemIcon>
                  <BarChartIcon />
                </ListItemIcon>
                <ListItemText primary={"Estadisticas"} />
              </ListItemButton>
            </ListItem>
          </List>
        </Drawer>
      </ClickAwayListener>
    </Box>
  );
}