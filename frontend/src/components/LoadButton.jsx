import React from 'react';

export const LoadButton = (props) => (
  <button
    className=' bg-green-400 text-white p-1 m-1 rounded-lg'
    onClick={props.onLoad}
  >
    {props.title}
  </button>
);