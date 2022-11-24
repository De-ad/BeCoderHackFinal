import React from 'react';
const table_style = "px-5 text-green-300 font-thin";

export const Header = (props) => (
  <tr>
    <th className={table_style}>id</th>
    <th className={table_style}>commit name</th>
    <th className={table_style}>Better to be reviewed by</th>
  </tr>
);