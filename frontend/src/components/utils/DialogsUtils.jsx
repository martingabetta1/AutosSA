import { forwardRef } from 'react';
import { styled } from '@mui/material/styles';
import Dialog from '@mui/material/Dialog';
import Slide from '@mui/material/Slide';

const Transition = forwardRef(function Transition(props, ref) {
  return <Slide direction="down" ref={ref} {...props} />;
});

const BootstrapDialog = styled(Dialog)(({ theme }) => ({
  '& .MuiDialogContent-root': {
    padding: theme.spacing(2),
  },
  '& .MuiDialogActions-root': {
    padding: theme.spacing(1),
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

const DialogsUtils = {
  BootstrapDialog,
  Transition,
  InputStyles
}

export default DialogsUtils