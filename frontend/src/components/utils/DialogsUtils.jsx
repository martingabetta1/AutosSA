import { forwardRef, useEffect, useState } from 'react';
import { styled } from '@mui/material/styles';
import Dialog from '@mui/material/Dialog';
import Slide from '@mui/material/Slide';
import CircularProgress from '@mui/material/CircularProgress';

// Styles

const BootstrapDialog = styled(Dialog)(({ theme }) => ({
  '& .MuiDialogContent-root': {
    padding: theme.spacing(2),
    position: 'relative'
  },
  '& .MuiDialogActions-root': {
    padding: theme.spacing(1),
  },
  '& .MuiPaper-root': {
    position: 'relative',
  },
}));

const InputStyles = styled('div')({
  '& .MuiTextField-root': {
    display: 'block',
    margin: '0px 0px 10px 0px'
  },
  '& .MuiOutlinedInput-root': {
    width: '400px'
  },
});

const circularProgressContainer = {
  position: 'absolute',
  backgroundColor: 'white',
  zIndex: '10',
  width: '100%',
  height: '100%',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center'
}

// Functions

const Transition = forwardRef(function Transition(props, ref) {
  return <Slide direction="down" ref={ref} {...props} />;
});

// Components

const DialogLoader = (props) => {
  const [show, setShow] = useState();

  useEffect(() => {
    if(props.show){
      setShow(true)
      setTimeout(() => {
        setShow(false);
      }, 500);
    }
  }, [props.show]);

  return (
    show && (
      <div style={circularProgressContainer}>
        <CircularProgress />
      </div>
    )
  );
}

const DialogsUtils = {
  Styles:{
    BootstrapDialog,
    InputStyles,
  },
  Functions:{
    Transition,
  },
  Components:{
    DialogLoader
  }
}

export default DialogsUtils