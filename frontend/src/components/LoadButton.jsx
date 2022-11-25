import React from 'react';

export const LoadButton = (props) => (
  <button
  className="border-2 rounded-full p-1 px-4 shadow-lg text-green-300 border-green-300"
    onClick={props.onLoad}
  >
    {props.title}
  </button>
);