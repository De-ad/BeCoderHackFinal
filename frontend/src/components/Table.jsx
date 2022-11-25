import React from 'react';


export const Table = (props) => (
  <div>
    <div className="grid p-10 space-y-3 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit ">
        <div className="text-green-300 text-center text-2xl"> High risk of errors in commits:</div>
    <h2 className="title">{props.title}</h2>
    <table className="table">
      <thead>
        {props.headerRender()}
      </thead>
      <tbody>
        {props.items.map(props.rowRender)}
      </tbody>
    </table>
  </div>
  </div>
);